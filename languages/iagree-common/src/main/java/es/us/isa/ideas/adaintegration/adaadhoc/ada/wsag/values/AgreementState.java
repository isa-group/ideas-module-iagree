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

import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.Range;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.errors.PropertyState;

public interface AgreementState {

	int INT_VAL = 0;
	int RANGE_VAL = 1;
	int ENUM_VAL = 2;
	
	public Collection<String> getVariablesAsString();
	
	public Collection<PropertyState> getStates();
	
	public void putVariableValue(String var, String value);
	
//	public void putVariableValue(String var, int val);
	
//	public void putVariableValue(String var, Range val);
	
//	public void putVariableValue(String var, Collection<String> val);
	
	public int getVariableValueType(String var);
	
	public int getIntegerValue(String var);
	
	public Range getRangeValue(String var);
	
	public Collection<String> getEnumValue(String var);
	
}
