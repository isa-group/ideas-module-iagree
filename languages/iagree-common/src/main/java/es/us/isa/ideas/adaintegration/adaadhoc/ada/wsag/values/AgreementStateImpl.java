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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag.values;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.Range;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.errors.PropertyState;

public class AgreementStateImpl implements AgreementState {

	/**
	 * Map para el tipo de las variables
	 */
	private Map<String,Integer> varsType;
	
	//y ahora 3 maps para los valores de cada variable
	private Map<String,Collection<String>> enumVals;
	private Map<String,Range> rangesVals;
	private Map<String,Integer> fixedVals;
	
	//y el collection de property states
	private Collection<PropertyState> states;
	
	public AgreementStateImpl() {
		varsType = new HashMap<String, Integer>();
		enumVals = new HashMap<String, Collection<String>>();
		rangesVals = new HashMap<String, Range>();
		fixedVals = new HashMap<String, Integer>();
		states = new LinkedList<PropertyState>();
	}

	@Override
	public Collection<String> getEnumValue(String var) {
		return enumVals.get(var);
	}

	@Override
	public int getIntegerValue(String var) {
		return fixedVals.get(var);
	}

	@Override
	public Range getRangeValue(String var) {
		return rangesVals.get(var);
	}

	@Override
	public int getVariableValueType(String var) {
		return varsType.get(var);
	}

	@Override
	public Collection<String> getVariablesAsString() {
		return varsType.keySet();
	}
	
	@Override
	public void putVariableValue(String var, String value){
		//ahora analizamos el valor para saber si es un valor fijo
		//un rango o un conjunto de enumerados
		if (value.contains("..")){
			//rango
			StringTokenizer st = new StringTokenizer(value, "..");
			String smin = st.nextToken(), smax = st.nextToken();
			int min = Integer.parseInt(smin);
			int max = Integer.parseInt(smax);
			Range r = new Range(min, max);
			putVariableValue(var, r);
		}else if (value.contains(",")){
			//enumerado
			StringTokenizer st = new StringTokenizer(value, ",");
			Collection<String> values = new LinkedList<String>();
			while (st.hasMoreTokens()){
				String aux = st.nextToken();
				values.add(aux);
			}
			putVariableValue(var, values);
		}else{
			if(value.equalsIgnoreCase("true")){
				//boolean true, lo parseamos como un entero 100
				putVariableValue(var, 100);
			}else if(value.equalsIgnoreCase("false")){
				//boolean false, lo parseamos como un entero 0
				putVariableValue(var, 0);
			}else{
				//entero
				int val = Integer.parseInt(value);
				putVariableValue(var, val);
			}
		}
	}

	private void putVariableValue(String var, int val) {
		varsType.put(var, AgreementState.INT_VAL);
		if(!fixedVals.containsKey(var)){
			states.add(new PropertyState(var, ""+val));
		}
		fixedVals.put(var, val);
	}

	private void putVariableValue(String var, Range val) {
		varsType.put(var, AgreementState.RANGE_VAL);
		if(!rangesVals.containsKey(var)){
			states.add(new PropertyState(var,val.toString()));
		}
		rangesVals.put(var, val);
	}

	private void putVariableValue(String var, Collection<String> val) {
		varsType.put(var, AgreementState.ENUM_VAL);
		if(!enumVals.containsKey(var)){
			states.add(new PropertyState(var, val.toString()));
		}
		enumVals.put(var, val);	
	}

	@Override
	public Collection<PropertyState> getStates() {
		return states;
	}
}
