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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.selectors;

import java.util.Collection;
import java.util.Iterator;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.subfacades.ProxyAnalyzer;


public class DefaultSelectorCriteria implements SelectorCriteria{

	@Override
	/*
	 * Devuelve el primer analizador que encuentre 
	 * que implemente la operacion
	 */
	public ProxyAnalyzer selectAnalyzer(String id, Collection<ProxyAnalyzer> ans) {
		
		ProxyAnalyzer res = null;
		Iterator<ProxyAnalyzer> it = ans.iterator();
		boolean b = false;
		while (it.hasNext() && !b){
			ProxyAnalyzer aux = it.next();
			if (aux.hasOperation(id)){
				res = aux;
				b = true;
			}
		}
		return res;
		
	}

}
