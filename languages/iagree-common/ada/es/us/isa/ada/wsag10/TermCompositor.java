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

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;



/**
 * @author    cmuller
 */
public class TermCompositor extends Term {
	
	public final static String ALL = "All";
	
	public final static String ONE_OR_MORE = "OneOrMore";
	
	public final static String EXACTLY_ONE = "ExactlyOne";
	
	/**
	 * @uml.property  name="type"
	 */
	private String type;
	/**
	 * @uml.property  name="comprisedTerms"
	 */
	private List<Term> comprisedTerms;

	public TermCompositor(){
		comprisedTerms = new ArrayList<Term>(); 
	}
	
	/**
	 * @return
	 * @uml.property  name="type"
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param  type
	 * @uml.property  name="type"
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return
	 * @uml.property  name="comprisedTerms"
	 */
	public List<Term> getComprisedTerms() {
		return comprisedTerms;
	}

	/**
	 * @param  comprisedTerms
	 * @uml.property  name="comprisedTerms"
	 */
	public void setComprisedTerms(List<Term> comprisedTerms) {
		this.comprisedTerms = comprisedTerms;
	}
	
	public void addComprisedTerm(Term t){
//		if (comprisedTerms == null){
//			comprisedTerms = new ArrayList<Term>();
//		}
		comprisedTerms.add(t);
	}
	
	public Collection<Term> getTerms(){
		Collection<Term> res = new LinkedList<Term>();
		for (Term t:comprisedTerms){
			if (t instanceof TermCompositor){
				TermCompositor compositor = (TermCompositor) t;
				res.addAll(compositor.getTerms());
			}
			else{
				if (!(t instanceof ServiceProperties)){
					res.add(t);
				}
			}
		}
		return res;
	}
	

}
