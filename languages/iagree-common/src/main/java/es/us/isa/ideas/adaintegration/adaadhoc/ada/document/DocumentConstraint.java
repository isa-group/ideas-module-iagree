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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.document;

import es.us.isa.ideas.adaintegration.adaadhoc.util.Tree;

//TODO hacer esta clase abstracta?
public class DocumentConstraint {

	//TODO completar esta clase
	
	private Tree<? extends Object> constraint;
	
	private String id;
	
	private String description;
	
	
	public DocumentConstraint(String id, Tree<? extends Object> constraint) {
		super();
		this.constraint = constraint;
		this.id = id;
	}

	public Tree<? extends Object> getConstraint(){
		return constraint;
	}
	
	public void setConstraint(Tree<? extends Object> t){
		constraint = t;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
