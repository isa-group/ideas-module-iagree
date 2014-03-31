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

/**
 * @author    cmuller
 */
public class KPITarget implements SLO {
	
	/**
	 * @uml.property  name="target"
	 * @uml.associationEnd  
	 */
	private Target target;
	/**
	 * @uml.property  name="kpiName"
	 */
	private String kpiName;
	
	/**
	 * @return
	 * @uml.property  name="target"
	 */
	public Target getTarget() {
		return target;
	}
	/**
	 * @param  target
	 * @uml.property  name="target"
	 */
	public void setTarget(Target target) {
		this.target = target;
	}
	/**
	 * @return
	 * @uml.property  name="kpiName"
	 */
	public String getKpiName() {
		return kpiName;
	}
	/**
	 * @param  kpiName
	 * @uml.property  name="kpiName"
	 */
	public void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}

}
