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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.errors;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AgreementElement;

public class PropertyState extends AgreementElement {

	private String propertyValue;
	
	public PropertyState(String name, String propertyValue) {
		super();
		this.name = name;
		this.propertyValue = propertyValue;
	}

	public String getPropertyValue() {
		return propertyValue;
	}

	public void setPropertyValue(String propertyValue) {
		this.propertyValue = propertyValue;
	}
	
	public boolean equals(Object o){
		boolean res = false;
		if (o instanceof PropertyState){
			PropertyState state = (PropertyState) o;
			if (name.equals(state.getName()) && 
					propertyValue.equals(state.getPropertyValue())){
				res = true;
			}
		}
		return res;
	}
	
}
