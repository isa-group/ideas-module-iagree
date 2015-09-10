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

import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.OfferItem;

public class AgreementElement {

	protected String name;

	private boolean analysable = true;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object o){
		boolean res = false;
		if (o instanceof AgreementElement){
			AgreementElement elem = (AgreementElement) o;
			if (elem.getName().equalsIgnoreCase(name)){
				res = true;
			}
		}
		return res;
	}

	public boolean isAnalysable() {
		return analysable;
	}

	public void setAnalysable(boolean analysable) {
		this.analysable = analysable;
	}
	
	public String toString(){
		if(this instanceof OfferItem){
			OfferItem oi = (OfferItem) this;
			return oi.toString();
		}
		return name;
	}
	
}
