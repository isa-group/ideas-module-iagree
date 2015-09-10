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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag4j;

import java.util.Collection;
import java.util.Map;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AgreementElement;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.errors.AgreementError;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.errors.Explanation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term;

public interface ADA4Wsag4JFacade {

	/**
	 * 
	 * @param documentContent
	 * @return
	 * @throws BadSyntaxException
	 */
	public Boolean checkConsistency(String documentContent) throws BadSyntaxException;
	
	/**
	 * 
	 * @param documentContent
	 * @return
	 * @throws BadSyntaxException
	 */
	public Map<AgreementElement, Collection<AgreementElement>> explainInconsistencies(String documentContent) throws BadSyntaxException;

	/**
	 * 
	 * @param documentContent
	 * @return
	 * @throws BadSyntaxException
	 */
	public Collection<Term> getDeadTerms(String documentContent) throws BadSyntaxException;
	
	/**
	 * 
	 * @param documentContent
	 * @param terms
	 * @return
	 * @throws BadSyntaxException
	 */
	public Map<Term, Collection<AgreementElement>> explainDeadTerms(String documentContent, Collection<Term> terms) throws BadSyntaxException;
	
	/**
	 * 
	 * @param documentContent
	 * @return
	 * @throws BadSyntaxException
	 */
	public Collection<Term> getLudicrousTerms(String documentContent) throws BadSyntaxException;
	
	/**
	 * 
	 * @param documentContent
	 * @param terms
	 * @return
	 * @throws BadSyntaxException
	 */
	public Map<Term, Collection<AgreementElement>> explainLudicrousTerms(String documentContent, Collection<Term> terms) throws BadSyntaxException;
	
	/**
	 * 
	 * @param templateContent
	 * @param offerContent
	 * @return
	 * @throws BadSyntaxException
	 */
	public Boolean checkCompliance(String templateContent, String offerContent) throws BadSyntaxException;
	
	/**
	 * 
	 * @param templateContent
	 * @param offerContent
	 * @return
	 * @throws BadSyntaxException
	 */
	public Map<AgreementError, Explanation> explainNonCompliance(String templateContent, String offerContent) throws BadSyntaxException;
}
