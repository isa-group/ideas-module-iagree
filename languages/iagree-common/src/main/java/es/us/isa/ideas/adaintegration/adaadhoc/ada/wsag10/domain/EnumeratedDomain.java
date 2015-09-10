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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EnumeratedDomain extends Domain{

	private Map<String,Integer> values;
	
	private ConstantConverter converter;
	
	public EnumeratedDomain(ConstantConverter conv){
		converter = conv;
		values = new HashMap<String, Integer>();
	}
	
	public EnumeratedDomain(ConstantConverter conv, Collection<String> vals){
		this(conv);
		for (String s:vals){
			addValue(s);
		}
	}
	
	public void addValue(String s){
		if (!values.containsKey(s)){
			Integer res = converter.convertToInteger(s);
			values.put(s, res);
		}
	}
	
	public Collection<Integer> getIntegerValues(){
		return values.values();
	}
	
	public Collection<String> getStringValues(){
		return values.keySet();
	}
	
	public boolean equals(Object o){
		boolean res = false;
		if (o instanceof EnumeratedDomain){
			EnumeratedDomain ed = (EnumeratedDomain) o;
			Collection<String> vals = ed.getStringValues();
			if (vals.equals(values.keySet())){
				res = true;
			}
		}
		return res;
	}
	
}
