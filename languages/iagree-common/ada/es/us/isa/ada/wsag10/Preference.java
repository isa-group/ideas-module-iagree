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

public class Preference {
	
	//a float value to express a preference utility value applied to a SDT (it is a value between 0.0 and 1.0)
	protected float utility;
	
	//the utility is defined for this service description term 
    protected ServiceDescriptionTerm serviceTermReference;
    
	public float getUtility() {
		return utility;
	}

	public void setUtility(float utility) {
		this.utility = utility;
	}

	public ServiceDescriptionTerm getServiceTermReference() {
		return serviceTermReference;
	}

	public void setServiceTermReference(ServiceDescriptionTerm serviceTermReference) {
		this.serviceTermReference = serviceTermReference;
	} 

}
