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

package es.us.isa.ada.choco.questions;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import es.us.isa.ada.choco.ChocoAnalyzer;
import es.us.isa.ada.choco.ChocoOperation;
import es.us.isa.ada.document.AbstractDocument;
import es.us.isa.ada.operations.DecomposeIntoViewsOperation;
import es.us.isa.ada.wsag10.AbstractAgreementDocument;
import es.us.isa.ada.wsag10.GuaranteeTerm;
import es.us.isa.ada.wsag10.SLO;
import es.us.isa.ada.wsag10.ServiceDescriptionTerm;
import es.us.isa.ada.wsag10.ServiceProperties;
import es.us.isa.ada.wsag10.ServiceScope;
import es.us.isa.ada.wsag10.Template;
import es.us.isa.ada.wsag10.Term;
import es.us.isa.ada.wsag10.TermCompositor;
import es.us.isa.ada.wsag10.Variable;


//TODO implementada la operacion, faltan las pruebas sobre ella
//hacerlas con plantillas, puteando en las creation constraints,
//y con distintas operaciones en los scopes de GTs
public class ChocoDecomposeIntoViewsOp extends ChocoOperation implements
		DecomposeIntoViewsOperation {

	private Map<ServiceScope,AbstractDocument> views;
	
	private Set<Variable> globalVars;
	
	@Override
	public void execute(ChocoAnalyzer an) {

		if (docs.size() == 1){
			//presuponemos que el documento no contiene alternatives
			views = new HashMap<ServiceScope,AbstractDocument>();
			
			AbstractAgreementDocument document = (AbstractAgreementDocument) docs.get(0);
			Collection<Term> terms = document.getAllTerms();
			ServiceProperties sp = new ServiceProperties();
			Collection<ServiceDescriptionTerm> sdts = new LinkedList<ServiceDescriptionTerm>();
			Collection<GuaranteeTerm> gts = new LinkedList<GuaranteeTerm>();
			//XXX amos a guardar las variables de cada operacion asociadas
			//a su operacion (ServiceScope). tenemos que extraer las variables
			//de los slo's
			Map<ServiceScope,Set<Variable>> scopes2vars = new HashMap<ServiceScope, Set<Variable>>();
			//1º creamos los distintos documentos
			globalVars = new HashSet<Variable>();
			
			Class clazz = document.getClass();
			
			//sacamos primmero las vbles
			for (Term t:terms){
				if (t instanceof ServiceProperties){
					//XXX a cada doc deben ir las variables
					//correspondientes de la operacion, es decir
					//las que aparezcan sus GT's
					Collection<Variable> props = sp.getVariableSet();
					props.addAll(((ServiceProperties) t).getVariableSet());
					sp.setName(t.getName());
					sp.setTermName(t.getTermName());
					sp.setServiceName(((ServiceProperties) t).getServiceName());
				}
			}
			
			//y ahora los scopes de los gts
			for (Term t:terms){
				
				if (t instanceof GuaranteeTerm){
					GuaranteeTerm gt = (GuaranteeTerm) t;
					Set<ServiceScope> scopes = gt.getScopes();
					//cada scope es una operacion
					if (!scopes.isEmpty()){
						for (ServiceScope ss:scopes){
							AbstractDocument aux = views.get(ss);
							//XXX aqui cuidado con la creacion de la clase
							//con reflexion
							AbstractAgreementDocument tAux = null;
							if (aux != null){
								tAux = (AbstractAgreementDocument) aux;
							}
							else{
								try {
									tAux = (AbstractAgreementDocument) clazz.newInstance();
									tAux.setContext(document.getContext());
									tAux.setId(document.getId());
									tAux.setName(document.getName());
								} catch (InstantiationException e1) {
									e1.printStackTrace();
								} catch (IllegalAccessException e1) {
									e1.printStackTrace();
								}
							}
							TermCompositor compositor = tAux.getTerms();
							//le ponemos nombre y tipo "All"
							compositor.setName("terms");
							compositor.setType("All");
							//le metemos el GT
							compositor.addComprisedTerm(gt);
							views.put(ss, tAux);
							Set<Variable> vars = scopes2vars.get(ss);
							if (vars != null){
								vars.addAll(extractVarsFromGt(gt,sp));
							}
							else{
								vars = extractVarsFromGt(gt,sp);
							}
							
							scopes2vars.put(ss, vars);
						}
					}
					else{
						//el GT va a todos los docs
						gts.add(gt);
						//TODO tenemos que meter las variables de este GT
						//en todas las operaciones
						Set<Variable> vars = extractVarsFromGt(gt,sp);
						globalVars.addAll(vars);
					}
				}		
				else if (t instanceof ServiceDescriptionTerm){
					//XXX debe ir el SDT a todos los docs??
					//yo diria que si
					sdts.add((ServiceDescriptionTerm) t);
				}
			}
			
			if (views.size() > 0){
				Set<Entry<ServiceScope,AbstractDocument>> entries = views.entrySet();
				for (Entry<ServiceScope,AbstractDocument> e:entries){
					AbstractAgreementDocument temp = (AbstractAgreementDocument) e.getValue();
					Collection<Term> tc = temp.getAllTerms();
					tc.addAll(sdts);
					tc.addAll(gts);
					//por ultimo, le metemos las vbles
					Set<Variable> ssVars = scopes2vars.get(e.getKey());
					//metemos las variables que aparecen en GTs sin scopes,
					//por lo que son globales
					ssVars.addAll(globalVars);
					ServiceProperties ssProps = new ServiceProperties();
					ssProps.setName(sp.getName());
					ssProps.setServiceName(sp.getServiceName());
					ssProps.setTermName(sp.getTermName());
					ssProps.setVariableSet(ssVars);
					tc.add(ssProps);
				}
				//añadimos una vista para las variables sin scope
//				ServiceScope defaultServiceScope = new ServiceScope();
//				AbstractDocument absDoc = views.get(defaultServiceScope);
//				AbstractAgreementDocument absAgDoc = null;
//				if(absDoc != null){
//					absAgDoc = (AbstractAgreementDocument) absDoc;
//				}else{
//					try {
//						absAgDoc = (AbstractAgreementDocument) clazz.newInstance();
//						absAgDoc.setContext(document.getContext());
//						absAgDoc.setId(document.getId());
//						absAgDoc.setName(document.getName());
//					} catch (InstantiationException e1) {
//						e1.printStackTrace();
//					} catch (IllegalAccessException e1) {
//						e1.printStackTrace();
//					}
//				}
//				TermCompositor compositor = absAgDoc.getTerms();
//				//le metemos el GT
//				compositor.addComprisedTerm(gt);
//				views.put(defaultServiceScope, absAgDoc);
//				//Añadimos una vista para las variables sin scope
//				views.put(new ServiceScope(), document);
			}
			else{
				//si el tamaño es 0, es que no hay service scope en ningun sitio
				//lo metemos como un service scope sin nombre, y ya esta
				views.put(new ServiceScope(), document);
			}
			
			
			
			if (document instanceof Template){
				//XXX y que hacemos con los items y las CreationConstraints??
				//en principio, voy a añadirlas a lo burro
				Set<Entry<ServiceScope,AbstractDocument>> entries = views.entrySet();
				for (Entry<ServiceScope,AbstractDocument> e:entries){
					Template aux = (Template) e.getValue();
					Template docaux = (Template) document;
					aux.setCc(docaux.getCc());
				}
			}
		}
		
	}

	private Set<Variable> extractVarsFromGt(GuaranteeTerm gt, ServiceProperties sp) {
		Set<Variable> vars = sp.getVariableSet();
		SLO slo = gt.getSlo();
		String qc = gt.getQualifyingCondition();
		Set<Variable> res = new HashSet<Variable>();
		if (qc != null && !qc.isEmpty()){
			res.addAll(extractVariables(qc, vars));
		}
		//StringSLO => CustomSLO => SLO
		//StringSLO tiene implementado toString
		res.addAll(extractVariables(slo.toString(), vars));
		return res;
	}
	
	private Collection<Variable> extractVariables(String text,Collection<Variable> vars){
		//XXX buscaremos otra forma mas eficiente de extraer las vbles en el futuro
		Collection<Variable> res = new HashSet<Variable>();
		for (Variable v:vars){
			String aux = v.getName();
			if (text.contains(aux)){
				res.add(v);
			}
		}
		return res;
	}

	@Override
	public Collection<AbstractDocument> getOperationViews() {
		return new LinkedList<AbstractDocument>(views.values());
	}

	@Override
	public Map<ServiceScope, AbstractDocument> getScopes2Views() {
		return views;
	}

	@Override
	public Set<Variable> getVariablesWithoutScope(){
		return globalVars;
	}
}
