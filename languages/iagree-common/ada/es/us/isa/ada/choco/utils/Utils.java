/**
 * 	This file is part of ADA.
 *
 *     ADA is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     ADA is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with ADA.  If not, see <http://www.gnu.org/licenses/>.
 */

package es.us.isa.ada.choco.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import choco.Choco;
import choco.cp.model.CPModel;
import choco.cp.solver.CPSolver;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.Variable;
import choco.kernel.model.variables.integer.IntegerVariable;
import choco.kernel.model.variables.real.RealVariable;
import choco.kernel.solver.ContradictionException;
import es.us.isa.ada.document.Range;
import es.us.isa.ada.wsag.values.AgreementState;
import es.us.isa.ada.wsag10.Restriction;
import es.us.isa.ada.wsag10.domain.ConstantConverter;
import es.us.isa.ada.wsag10.domain.DefaultConstantConverter;

public class Utils {
	
	private static short EQ = 0;
	private static short NEQ = 1;
	private static short GT = 2;
	private static short GEQ = 3;
	private static short LT = 4;
	private static short LEQ = 5;
	
	public static <T> Collection<T> single2Collection(T e){
		Collection<T> res = new LinkedList<T>();
		res.add(e);
		return res;
	}

	private static Collection<Collection<IntegerVariable>> mergeXors(
			Collection<IntegerVariable> col1, Collection<IntegerVariable> col2){
		
		Collection<Collection<IntegerVariable>> res = new LinkedList<Collection<IntegerVariable>>();
		
		Iterator<IntegerVariable> it1 = col1.iterator();
		while (it1.hasNext()){
			IntegerVariable v1 = it1.next();
			Iterator<IntegerVariable> it2 = col2.iterator();
			while (it2.hasNext()){
				IntegerVariable v2 = it2.next();
				Collection<IntegerVariable> aux = new LinkedList<IntegerVariable>();
				aux.add(v1);
				aux.add(v2);
				res.add(aux);
			}
		}
		
		return res;
		
	}
	
	private static Collection<Collection<IntegerVariable>> mergeCollectionXors(
			Collection<Collection<IntegerVariable>> col1, Collection<IntegerVariable> col2){
		
		Collection<Collection<IntegerVariable>> res = new LinkedList<Collection<IntegerVariable>>();
		
		Iterator<Collection<IntegerVariable>> it1 = col1.iterator();
		while (it1.hasNext()){
			Collection<IntegerVariable> elem1 = it1.next();
			Iterator<IntegerVariable> it2 = col2.iterator();
			while (it2.hasNext()){
				IntegerVariable v2 = it2.next();
				Collection<IntegerVariable> aux = new LinkedList<IntegerVariable>();
				aux.addAll(elem1);
				aux.add(v2);
				res.add(aux);
			}
		}
		
		return res;
		
	}
	
	public static Collection<Collection<IntegerVariable>> getVariations(Collection<Collection<IntegerVariable>> cols){
		Collection<Collection<IntegerVariable>> res;
		int size = cols.size();
		
		if (size == 1){
			res = new LinkedList<Collection<IntegerVariable>>();
			Iterator<IntegerVariable> it = cols.iterator().next().iterator();
			while (it.hasNext()){
				IntegerVariable aux = it.next();
				Collection<IntegerVariable> c = new LinkedList<IntegerVariable>();
				c.add(aux);
				res.add(c);
			}
		}
		else if (size > 1){
			Iterator<Collection<IntegerVariable>> it = cols.iterator();
			Collection<IntegerVariable> elem1 = it.next();
			Collection<IntegerVariable> elem2 = it.next();
			Collection<Collection<IntegerVariable>> aux = mergeXors(elem1, elem2);
			if (size > 2){
				while (it.hasNext()){
					Collection<IntegerVariable> elem = it.next();
					aux = mergeCollectionXors(aux, elem);
				}
			}
			res = aux;
			
		}
		else{
			res = null;
		}
		
		return res;
	}
	
	/**
	 * Uso: el primer parametro debe ser el conjunto de restricciones
	 * de la oferta, y el segundo, el conjunto de restricciones
	 * de la plantilla. 
	 * Pero esto no siempre es así porque para las operaciones de 
	 * comprobar que la oferta no sea más restrictiva que la plantilla
	 * el orden de los parámetros es al revés 
	 * 
	 * @param c1 Constraint offer
	 * @param c2 Constraint template
	 * @return boolean is compliant
	 */
	public static boolean isCompliantConstraint(Constraint c1, Constraint c2){
		boolean res;
		if (c1 == null){
			c1 = Choco.TRUE;
		}
		if (c2 == null){
			c2 = Choco.TRUE;
		}
		CPModel model = new CPModel();
		Constraint c = Choco.and(c1,Choco.not(c2));
		model.addConstraint(c);
		
		CPSolver solver = new CPSolver();
		solver.read(model);
//		res = !solver.solve();
		try {
			solver.propagate();
			res = !solver.solve();
		} catch (ContradictionException e) {
			res = true;
		}
		
		return res;
	}
	
	
	public static Constraint restriction2Choco(String varName, Restriction r, Map<String,Variable> vars)
			throws UnknownVariableException{
		Constraint c = null;
		
		String val = r.getFixedValue();
		if (val != null){
			//igualdad
			c = createConstraint(varName, EQ, val, vars);
		}
		else{
			//mayor, menor, o rango
			//dentro de cada if debo obtener una restriccion
			Constraint aux1 = Choco.TRUE, aux2 = Choco.TRUE;
			
			//primero el maximo
			String max = r.getMaxExclusive();
			if (max != null){
				// <
				aux1 = createConstraint(varName, LT, max, vars);
			}
			else if ((max = r.getMaxInclusive()) != null){
				// <=
				aux1 = createConstraint(varName, LEQ, max, vars);
			}
			
			//ahora el minimo
			String min = r.getMinExclusive();
			if (min != null){
				// >
				aux2 = createConstraint(varName, GT, min, vars);
			}
			else if ((min = r.getMinInclusive()) != null){
				// >=
				aux2 = createConstraint(varName, GEQ, min, vars);
			}
			
			c = Choco.and(aux1,aux2);
		}
		
		return c;
		
	}
	
	private static String trimQuotes(String s){
		String result = s;
		if (s.startsWith("\"")){
			result = result.substring(1, result.length());
		}
		if (s.endsWith("\"")){
			result = result.substring(0, result.length() - 1);
		}
		return result;
	}
	
	private static Constraint createConstraint(String varName, short operator, String value, Map<String,Variable> vars)
			throws UnknownVariableException{
		
		Constraint res = null;
		
		Variable var = vars.get(varName);
		if (var != null){
			if (var instanceof IntegerVariable){
				IntegerVariable intVar = (IntegerVariable) var;
				Integer constant = null; 
				try{
					constant = Integer.parseInt(value);
				}catch (NumberFormatException exp){
					//es un enumerado
					String aux = trimQuotes(value);
//					constant = DefaultConstantConverter.getInstance().convertToInteger(value);
					constant = DefaultConstantConverter.getInstance().convertToInteger(aux);
//					Double d = Double.parseDouble(value);
//					int aux = d.intValue();
//					constant = aux;
				}
				
//				if (constant == null){
//					//entonces lo consideramos como un valor enumerado
//					//al final terminaremos dando un valor a constant...
//					DefaultConstantConverter converter = DefaultConstantConverter.getInstance();
//					constant = converter.convertToInteger(value);
//				}
				
				if (operator == EQ){
					res = Choco.eq(intVar, constant);
				}
				else if (operator == NEQ){
					res = Choco.neq(intVar, constant);
				}
				else if (operator == GT){
					res = Choco.gt(intVar, constant);
				}
				else if (operator == GEQ){
					res = Choco.geq(intVar, constant);
				}
				else if (operator == LT){
					res = Choco.lt(intVar, constant);
				}
				else if (operator == LEQ){
					res = Choco.leq(intVar, constant);
				}
				else{
					//TODO lanzar excepcion, operador no reconocido
				}
				
			}
			else if (var instanceof RealVariable){
				RealVariable realVar = (RealVariable) var; 
				Double constant = null;
				try{
					constant = Double.parseDouble(value);
					
					if (operator == EQ){
						res = Choco.eq(realVar, constant);
					}
					else if (operator == GEQ){
						res = Choco.geq(realVar, constant);
					}
					else if (operator == LEQ){
						res = Choco.leq(realVar, constant);
					}
					else{
						//TODO lanzar excepcion, operador no reconocido
						//o no soportado para numeros reales
					}
				}catch(NumberFormatException exp){
					//error, habria que lanzar excepcion
				}
				
			}

		}
		else{
			throw new UnknownVariableException("Unknown variable "+varName+" detected");
		}
		
		return res;
	}
	
	public static void main(String[] args){
//		IntegerVariable v1 = Choco.makeBooleanVar("v1");
//		IntegerVariable v2 = Choco.makeBooleanVar("v2");
//		IntegerVariable v3 = Choco.makeBooleanVar("v3");
//		IntegerVariable v4 = Choco.makeBooleanVar("v4");
//		IntegerVariable v5 = Choco.makeBooleanVar("v5");
//		IntegerVariable v6 = Choco.makeBooleanVar("v6");
//		IntegerVariable v7 = Choco.makeBooleanVar("v7");
//		
//		Collection<IntegerVariable> c1 = new LinkedList<IntegerVariable>();
//		c1.add(v1);
//		c1.add(v2);
//		
//		Collection<IntegerVariable> c2 = new LinkedList<IntegerVariable>();
//		c2.add(v3);
//		c2.add(v4);
//		c2.add(v5);
//		
//		Collection<IntegerVariable> c3 = new LinkedList<IntegerVariable>();
//		c3.add(v6);
//		c3.add(v7);
//		
//		Collection<Collection<IntegerVariable>> aux = mergeXors(c1,c2);
//		Collection<Collection<IntegerVariable>> res = mergeCollectionXors(aux, c3);
//		
//		Iterator<Collection<IntegerVariable>> it1 = res.iterator();
//		while (it1.hasNext()){
//			Iterator<IntegerVariable> it2 = it1.next().iterator();
//			while (it2.hasNext()){
//				IntegerVariable var = it2.next();
//				System.out.print(var.getName()+" ");
//			}
//			System.out.println();
//		}
//		System.out.println(res.size());
		IntegerVariable v1 = Choco.makeIntVar("v1", 0, 10);
		Constraint c1 = Choco.and(Choco.gt(v1, 5),Choco.lt(v1, 9));
		Constraint c2 = Choco.gt(v1, 5);
		boolean b = Utils.isCompliantConstraint(c1, c2);
		//System.out.println(b);
	}
	
	public static String removeQuotes(String s){
		String result = s;
		if (result.startsWith("\"")){
			result.substring(1,result.length());
		}
		if (result.endsWith("\"")){
			result.substring(0,result.length() - 1);
		}
		return result;
	}
	
	public static Constraint[] state2Choco(Map<String, Variable> vars,
			AgreementState st) {
		
		Collection<String> stateVars = st.getVariablesAsString();
		Constraint[] stateCons = new Constraint[stateVars.size()];
		int i = 0;
		for (String var:stateVars){
			//por cada variable
			int valueType = st.getVariableValueType(var);
			Constraint c = null;
			IntegerVariable v = (IntegerVariable)vars.get(var);
			
			if (valueType == AgreementState.INT_VAL){
				int val = st.getIntegerValue(var);
				c = Choco.eq(v, val);
			}
			else if (valueType == AgreementState.RANGE_VAL){
				Range r = st.getRangeValue(var);
				c = Choco.and(Choco.geq(v,r.getMin()),Choco.leq(v, r.getMax()));
			}
			else if (valueType == AgreementState.ENUM_VAL){
				ConstantConverter conv = DefaultConstantConverter.getInstance();
				Collection<String> vals = st.getEnumValue(var);
				Constraint[] auxCons = new Constraint[vals.size()];
				int j = 0;
				for (String s:vals){
					int aux = conv.convertToInteger(s);
					auxCons[j] = Choco.eq(v, aux);
					j++;
				}
				c = Choco.or(auxCons);
			}
			stateCons[i] = c;
			i++;
		}
		return stateCons;
	}
	
}
