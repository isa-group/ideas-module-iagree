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

/**
 * @author   Jesus
 */
public class Restriction extends ItemConstraint {

	protected String baseType; //XSD datatype
	
	/**
	 * @uml.property  name="minInclusive"
	 */
	private String minInclusive;
	/**
	 * @uml.property  name="minExclusive"
	 */
	private String minExclusive;
	/**
	 * @uml.property  name="maxExclusive"
	 */
	private String maxExclusive;
	/**
	 * @uml.property  name="maxInclusive"
	 */
	private String maxInclusive;
	
	
	private String fixedValue;
	
	/**
	 * @param  minInclusive
	 * @uml.property  name="minInclusive"
	 */
	public void setMinInclusive(String minInclusive) {
		this.minInclusive = minInclusive;
	}
	/**
	 * @return
	 * @uml.property  name="minInclusive"
	 */
	public String getMinInclusive() {
		return minInclusive;
	}
	/**
	 * @param  minExclusive
	 * @uml.property  name="minExclusive"
	 */
	public void setMinExclusive(String minExclusive) {
		this.minExclusive = minExclusive;
	}
	/**
	 * @return
	 * @uml.property  name="minExclusive"
	 */
	public String getMinExclusive() {
		return minExclusive;
	}
	/**
	 * @param  maxExclusive
	 * @uml.property  name="maxExclusive"
	 */
	public void setMaxExclusive(String maxExclusive) {
		this.maxExclusive = maxExclusive;
	}
	/**
	 * @return
	 * @uml.property  name="maxExclusive"
	 */
	public String getMaxExclusive() {
		return maxExclusive;
	}
	/**
	 * @param  maxInclusive
	 * @uml.property  name="maxInclusive"
	 */
	public void setMaxInclusive(String maxInclusive) {
		this.maxInclusive = maxInclusive;
	}
	/**
	 * @return
	 * @uml.property  name="maxInclusive"
	 */
	public String getMaxInclusive() {
		return maxInclusive;
	}
	public String getBaseType() {
		return baseType;
	}
	public void setBaseType(String baseType) {
		this.baseType = baseType;
	}
	
	public void setFixedValue(String val){
		fixedValue = val;
	}
	
	public String getFixedValue(){
		return fixedValue;
	}

}
