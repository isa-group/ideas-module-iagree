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

public class OfferItem extends AgreementElement {

	private ServiceDescriptionTerm containerSDT;
	private Restriction r;
	
	
	public OfferItem(ServiceDescriptionTerm containerSDT, String name,
			Restriction r) {
		this.containerSDT = containerSDT;
		this.name = name;
		this.r = r;
	}

	public ServiceDescriptionTerm getContainerSDT() {
		return containerSDT;
	}
	
	public void setContainerSDT(ServiceDescriptionTerm containerSDT) {
		this.containerSDT = containerSDT;
	}
	
	public Restriction getRestriction() {
		return r;
	}
	
	public void setRestriction(Restriction r) {
		this.r = r;
	}
		
	public boolean equals(Object o){
		boolean res = false;
		
		if (o instanceof OfferItem){
			OfferItem aux = (OfferItem) o;
			if (aux.getName().equals(name) && 
					containerSDT.getName().equals(aux.getContainerSDT().getName())){
				res = true;
			}
		}
		
		return res;
	}
	
	
	
	public String toString(){
		return containerSDT.getName()+"-"+name;
	}
	
}
