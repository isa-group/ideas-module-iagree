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

package es.us.isa.ada.wsag10;

import java.util.HashSet;
import java.util.Set;



/**
 * @author    cmuller
 */
public class ServiceProperties extends ServiceTerm {
	
	/**
	 * @uml.property  name="variableSet"
	 */
	private Set<Variable> variableSet;
	
	public ServiceProperties(){
		variableSet = new HashSet<Variable>();
	}

	/**
	 * @return
	 * @uml.property  name="variableSet"
	 */
	public Set<Variable> getVariableSet() {
		return variableSet;
	}

	/**
	 * @param  variableSet
	 * @uml.property  name="variableSet"
	 */
	public void setVariableSet(Set<Variable> variableSet) {
		this.variableSet = variableSet;
	}

}
