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

import java.util.Collection;
import java.util.Iterator;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AgreementElement;

public class AgreementPiece {

	// private Observation obs;

	protected Collection<AgreementElement> elements;

	public AgreementPiece(Collection<AgreementElement> elements) {
		this.elements = elements;
	}


	public Collection<AgreementElement> getElements() {
		return elements;
	}


	public void setElements(Collection<AgreementElement> elements) {
		this.elements = elements;
	}


	public String toString() {
		String res = "";
		for (AgreementElement elem:elements){
			res += elem + ",";
		}
		//asi me cargo la ultima coma
		if (res.length() > 0){
			res = res.substring(0, res.length() - 1);
		}
		return res;
	}
	
	public boolean equals(Object o){
		boolean res = false;
		if (o instanceof AgreementPiece){
			AgreementPiece p = (AgreementPiece) o;
			Collection<AgreementElement> elems = p.getElements();
			res = elems.containsAll(elements) && elements.containsAll(elems);
		}
		return res;
	}
	
}
