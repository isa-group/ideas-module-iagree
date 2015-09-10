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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AgreementElement;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.domain.Domain;

/**
 * @author    cmuller
 */
public class Variable extends AgreementElement{
	
	/**
	 * @uml.property  name="location"
	 */
	private Location location;
	/**
	 * @uml.property  name="metric"
	 * @uml.associationEnd  
	 */
	private Domain domain;
	/**
	 * @uml.property  name="uniqueName"
	 */
	
	/**
	 * @return
	 * @uml.property  name="location"
	 */
	public Location getLocation() {
		return location;
	}
	/**
	 * @param  location
	 * @uml.property  name="location"
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
	/**
	 * @return
	 * @uml.property  name="metric"
	 */
	public Domain getDomain() {
		return domain;
	}
	/**
	 * @param  metric
	 * @uml.property  name="metric"
	 */
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	/**
	 * @return
	 * @uml.property  name="uniqueName"
	 */
	public String getUniqueName() {
		return getName();
	}
	/**
	 * @param  uniqueName
	 * @uml.property  name="uniqueName"
	 */
	public void setUniqueName(String uniqueName) {
		setName(uniqueName);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof Variable)) {
			return false;
		}
		Variable other = (Variable) obj;
		if (domain == null) {
			if (other.domain != null) {
				return false;
			}
		} else if (!domain.equals(other.domain)) {
			return false;
		}
		return true;
	}
	
	
	
	//tiramos del equals de la clase padre, AgreementElement
	
//	public boolean equals(Object o){
//		boolean res = false;
//		if (o instanceof Variable){
//			Variable v = (Variable) o;
//			res = location.equals(v.getLocation()) && getUniqueName().equals(v.getUniqueName())
//				&& metric.equals(v.getMetric());
//		}
//		return res;
//	}
	

}
