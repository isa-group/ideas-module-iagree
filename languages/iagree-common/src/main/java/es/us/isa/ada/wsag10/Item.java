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
 * @author   Jesus
 */
public class Item extends CreationConstraint {

	/**
	 * @uml.property  name="location"
	 */
	private String location;
	/**
	 * @uml.property  name="iconst"
	 * @uml.associationEnd  
	 */
	private ItemConstraint iconst;

	/**
	 * @param  location
	 * @uml.property  name="location"
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return
	 * @uml.property  name="location"
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param  iconst
	 * @uml.property  name="iconst"
	 */
	public void setIconst(ItemConstraint iconst) {
		this.iconst = iconst;
	}

	/**
	 * @return
	 * @uml.property  name="iconst"
	 */
	public ItemConstraint getIconst() {
		return iconst;
	}
	
}