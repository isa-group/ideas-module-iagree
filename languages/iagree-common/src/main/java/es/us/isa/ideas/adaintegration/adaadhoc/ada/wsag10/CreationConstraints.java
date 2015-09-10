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

/**
 * @author   Jesus
 */
public class CreationConstraints {
	
	public CreationConstraints() {
		super();
		this.items = new HashSet<Item>();
		this.constraints = new HashSet<GeneralConstraint>();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @uml.property  name="items"
	 */
	private HashSet<Item> items;
	/**
	 * @uml.property  name="constraints"
	 */
	private HashSet<GeneralConstraint> constraints;

		
	/**
	 * @param  items
	 * @uml.property  name="items"
	 */
	public void setItems(HashSet<Item> items) {
		this.items = items;
	}
	
	public void addItem(Item item) {
		this.items.add(item);
	}

	/**
	 * @return
	 * @uml.property  name="items"
	 */
	public HashSet<Item> getItems() {
		return items;
	}

	/**
	 * @param  constraints
	 * @uml.property  name="constraints"
	 */
	public void setConstraints(HashSet<GeneralConstraint> constraints) {
		this.constraints = constraints;
	}
	
	public void addConstraint(GeneralConstraint gc) {
		this.constraints.add(gc);
	}

	/**
	 * @return
	 * @uml.property  name="constraints"
	 */
	public HashSet<GeneralConstraint> getConstraints() {
		return constraints;
	}	
	
}
