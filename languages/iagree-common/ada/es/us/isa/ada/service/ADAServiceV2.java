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

package es.us.isa.ada.service;

import java.util.Collection;
import java.util.Map;

import es.us.isa.ada.errors.AgreementError;
import es.us.isa.ada.errors.Explanation;
import es.us.isa.ada.exceptions.BadSyntaxException;
import es.us.isa.ada.exceptions.PeriodDefinitionException;
import es.us.isa.ada.exceptions.PeriodDefinitionWarningException;
import es.us.isa.ada.wsag10.AbstractAgreementDocument;

public interface ADAServiceV2 extends ADAService {

	/**
	 * Analyses if an offer is compliant 
	 * with a template 
	 * 
	 * @param template byte[] 
	 * @param offer byte[]
	 * @return boolean compliant
	 * @throws BadSyntaxException 
	 */
	public boolean isCompliant(byte[] template, byte[] offer) throws PeriodDefinitionException, PeriodDefinitionWarningException, BadSyntaxException;
	
	/**
	 * If the offer is not compliant with the template,
	 * this method returns a mapping between each offer
	 * element and the collection of template element
	 * that conflicts with it
	 * 
	 * @param template byte[]
	 * @param offer byte[]
	 * @return Map<AgreementElement,Collection<AgreementElement>>
	 * @throws BadSyntaxException 
	 */
	public Map<AgreementError, Explanation> explainNonCompliance(byte[] template, byte[] offer) throws BadSyntaxException;
	
	/**
	 * Returns true if the offer is less restrictive than
	 * the template, and false in other case
	 * 
	 * @param template byte[] 
	 * @param offer byte[]
	 * @return boolean isLessRestrictive
	 * @throws PeriodDefinitionException 
	 * @throws PeriodDefinitionWarningException 
	 * @throws BadSyntaxException 
	 */
	public boolean isLessRestrictiveOffer(byte[] template, byte[] offer) throws PeriodDefinitionException, PeriodDefinitionWarningException, BadSyntaxException;
	
	/**
	 * If the offer is more restrictive than the template,
	 * this method returns a mapping between each more restrictive offer
	 * element and the collection of template element
	 * that conflicts with it
	 * 
	 * @param template byte[]
	 * @param offer byte[]
	 * @return Map<AgreementError,Explanation>>
	 * @throws BadSyntaxException 
	 * @throws PeriodDefinitionException 
	 * @throws PeriodDefinitionWarningException 
	 * @throws BadSyntaxException 
	 */
	public Map<AgreementError, Explanation> explainMoreRestrictiveOffer(
			byte[] template, byte[] offer) throws BadSyntaxException;
	
	/**
	 * Returns true if the template terms are 
	 * more restrictive than the template CC, and 
	 * false in other case
	 * 
	 * @param template byte[] 
	 * @return boolean moreRestrictiveTemplateTermsThanCC
	 * @throws PeriodDefinitionException 
	 * @throws PeriodDefinitionWarningException 
	 * @throws BadSyntaxException 
	 */
	public boolean isMoreRestrictiveTemplateTermsThanCC(byte[] template) throws PeriodDefinitionException, PeriodDefinitionWarningException, BadSyntaxException;
	
	/**
	 * If the template terms are less restrictive than the template CCs,
	 * this method returns a mapping between each less restrictive template
	 * term and the collection of template CCs that conflicts with it.
	 * 
	 * @param template byte[]
	 * @return Map<AgreementError,Explanation>>
	 * @throws BadSyntaxException 
	 * @throws PeriodDefinitionException 
	 * @throws PeriodDefinitionWarningException 
	 * @throws BadSyntaxException 
	 */
	public Map<AgreementError, Explanation> explainLessRestrictiveTemplateTerms(byte[] template) throws BadSyntaxException;
	
	/**
	 * Checks if the current state (xmlDoc)
	 * fulfills the agreement
	 * 
	 * @param doc byte[]
	 * @param xmlDoc byte[] agreement state
	 * @return boolean 
	 * @throws BadSyntaxException 
	 */
	public boolean isFulfilled(byte[] doc, byte[] xmlDoc) throws BadSyntaxException;
	
	/**
	 * If the current state doesn't fulfill the agreement,
	 * this operation returns explanations about it.
	 * 
	 * @param doc byte[]
	 * @param xmlDoc byte[] agreement state
	 * @return Map<AgreementError, Explanation>
	 * @throws BadSyntaxException 
	 */
	public Map<AgreementError, Explanation> explainAgreementViolation(byte[] doc, byte[] xmlDoc) throws BadSyntaxException;
	
	/**
	 * Gets the alternative documents for the given doc
	 * @param doc byte[]
	 * @return Collection<AbstractAgreementDocument>
	 */
	public Collection<AbstractAgreementDocument> getAlternativeDocuments(byte[] doc);
	
	/**
	 * Gets the different views for the given doc
	 * @param doc byte[]
	 * @return Collection<AbstractAgreementDocument>
	 */
	public Collection<AbstractAgreementDocument> getDocumentViews(byte[] doc);
	
	/**
	 * Gets the number of alternatives for the given doc
	 * @param doc byte[]
	 * @return number of alternatives
	 */
	public int getNumberOfAlternatives(byte[] doc);

	
}
