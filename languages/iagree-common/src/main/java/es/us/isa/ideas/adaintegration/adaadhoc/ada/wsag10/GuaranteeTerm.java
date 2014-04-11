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

import java.util.HashSet;
import java.util.Set;

/**
 * @author      cmuller
 * @uml.dependency   supplier="es.us.isa.ada.wsag10.SLO"
 */
public class GuaranteeTerm extends Term {
	
	/**
	 * @uml.property  name="obligated"
	 */
	private String obligated;
	/**
	 * @uml.property  name="scopes"
	 */
	private Set<ServiceScope> scopes;
	/**
	 * @uml.property  name="qualifyingCondition"
	 */
	private String qualifyingCondition;
	/**
	 * @uml.property  name="bvl"
	 * @uml.associationEnd  
	 */
	private BusinessValueList bvl;
	/**
	 * @uml.property  name="slo"
	 * @uml.associationEnd  
	 */
	private SLO slo;

	
	
	public GuaranteeTerm() {
		obligated = new String();
		scopes = new HashSet<ServiceScope>();
		qualifyingCondition = new String();
		bvl = new BusinessValueList();
		slo = new StringSLO();
	}
	/**
	 * @return
	 * @uml.property  name="obligated"
	 */
	public String getObligated() {
		return obligated;
	}
	/**
	 * @param  obligated
	 * @uml.property  name="obligated"
	 */
	public void setObligated(String obligated) {
		this.obligated = obligated;
	}
	/**
	 * @return
	 * @uml.property  name="scopes"
	 */
	public Set<ServiceScope> getScopes() {
		return scopes;
	}
	/**
	 * @param  scopes
	 * @uml.property  name="scopes"
	 */
	public void setScopes(Set<ServiceScope> scopes) {
		this.scopes = scopes;
	}
	
	
	public void addScope(ServiceScope scope) {
//		if (this.scopes == null) {
//			this.scopes = new TreeSet<ServiceScope>();
//		}
		this.scopes.add(scope);
	}
	/**
	 * @return
	 * @uml.property  name="qualifyingCondition"
	 */
	public String getQualifyingCondition() {
		return qualifyingCondition;
	}
	/**
	 * @param  qualifyingCondition
	 * @uml.property  name="qualifyingCondition"
	 */
	public void setQualifyingCondition(String qualifyingCondition) {
		this.qualifyingCondition = qualifyingCondition;
	}
	/**
	 * @return
	 * @uml.property  name="bvl"
	 */
	public BusinessValueList getBvl() {
		return bvl;
	}
	/**
	 * @param  bvl
	 * @uml.property  name="bvl"
	 */
	public void setBvl(BusinessValueList bvl) {
		this.bvl = bvl;
	}
	/**
	 * @return
	 * @uml.property  name="slo"
	 */
	public SLO getSlo() {
		return slo;
	}
	/**
	 * @param  slo
	 * @uml.property  name="slo"
	 */
	public void setSlo(SLO slo) {
		this.slo = slo;
	}
	
	public boolean hasQualifyCondition(){
		if (qualifyingCondition == null || qualifyingCondition.isEmpty()){
			return false;
		}
		else{
			return true;
		}
	}
	

}
