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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.service;

import java.util.Collection;
import java.util.Map;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AgreementElement;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.errors.AgreementError;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.errors.Explanation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term;

public interface ADAServiceWithRepo {
	/**
	 * Checks consistency for this document
	 * @param doc byte[] document
	 * @return boolean consistent
	 * @throws BadSyntaxException 
	 */
	public boolean checkDocumentConsistency(int doc) throws BadSyntaxException;
	
	/**
	 * Nos devuelve el conjunto de explicaciones de por que el documento
	 * pasado como parametro no es consistente. En caso de si serlo,
	 * el array de respuesta queda vacio
	 * @param doc
	 * @return
	 * @throws BadSyntaxException 
	 */
	public Map<AgreementElement, Collection<AgreementElement>> explainInconsistencies(int doc) throws BadSyntaxException;
	
	/**
	 * Returns ludicrous terms of this document
	 * 
	 * @param doc int document
	 * @return Collection<Term> ludicrous terms
	 * @throws BadSyntaxException 
	 */
	public Collection<Term> getLudicrousTerms(int doc) throws BadSyntaxException;
	
	/**
	 * Returns dead terms of this document
	 * 
	 * @param doc int document
	 * @return Collection<Term> dead terms
	 * @throws BadSyntaxException 
	 */
	public Collection<Term> getDeadTerms(int doc) throws BadSyntaxException;
	
	/**
	 * Returns the explanations of ludicrous terms from
	 * a document and its ludicrous terms.
	 * 
	 * @param doc int document
	 * @param terms Collection<Term> ludicrous terms
	 * @return Map<AgreementElement,Collection<AgreementElement>>
	 * @throws BadSyntaxException 
	 */
	public Map<Term,Collection<AgreementElement>> 
			explainLudicrousTerms(int doc, Collection<Term> terms) throws BadSyntaxException;
	
	/**
	 * Returns the explanations of dead terms from
	 * a document and its dead terms.
	 * 
	 * @param doc int document
	 * @param terms Collection<Term> dead terms
	 * @return Map<AgreementElement,Collection<AgreementElement>>
	 * @throws BadSyntaxException 
	 */
	public Map<Term,Collection<AgreementElement>> 
			explainDeadTerms(int doc, Collection<Term> terms) throws BadSyntaxException;
	
	
	/**
	 * Returns the metric file represented by this pathname
	 * 
	 * @return byte[] metric file
	 */
	public byte[] getMetricFile(String path);
	
	/**
	 * Permite incluir un nuevo archivo de metricas en el servidor,
	 * para poder utilizarlo posteriormente. Se nos devuelve
	 * la ruta de ese archivo de metricas en la maquina remota
	 * 
	 * @param doc
	 * @return
	 */
	public String addMetricFile(byte[] doc, byte[] docName);
	
	/**
	 * Transforms a xml wsag into a WSAg4People file
	 * 
	 * @param xmlAg byte[]
	 * @return byte[] wsag4people file
	 * @throws BadSyntaxException 
	 */
	public byte[] xmlToWSAg4People(byte[] xmlAg) throws BadSyntaxException;
	
	/**
	 * Transforms a WSAg4People file into a xml wsag file
	 * 
	 * @param wsag4poeple byte[]
	 * @return byte[] xml file
	 * @throws BadSyntaxException 
	 */
	public byte[] wsag4PeopleToXML(byte[] wsag4people) throws BadSyntaxException;
	
	/**
	 * Analyses if an offer is compliant 
	 * with a template 
	 * 
	 * @param template int 
	 * @param offer int
	 * @return boolean compliant
	 * @throws BadSyntaxException 
	 */
	public boolean isCompliant(int template, int offer) throws BadSyntaxException;
	
	/**
	 * If the offer is not compliant with the template,
	 * this method returns a mapping between each offer
	 * element and the collection of template element
	 * that conflicts with it
	 * 
	 * @param template int
	 * @param offer int
	 * @return Map<AgreementElement,Collection<AgreementElement>>
	 * @throws BadSyntaxException 
	 */
	public Map<AgreementError, Explanation> explainNonCompliance(int template, int offer) throws BadSyntaxException;
	
	/**
	 * Checks if the measures of the MMD
	 * fulfills the agreement
	 * 
	 * @param doc byte[]
	 * @param mmd byte[] Monitoring management document
	 * @return boolean 
	 * @throws BadSyntaxException 
	 */
	public boolean isFulfilled(int doc, byte[] mmd) throws BadSyntaxException;
	
	/**
	 * If the measures don't fulfill the agreement,
	 * this operation returns explanations about it.
	 * 
	 * @param doc byte[]
	 * @param mmd byte[] Monitoring management document
	 * @return Map<AgreementError, Explanation>
	 * @throws BadSyntaxException 
	 */
	public Map<AgreementError, Explanation> explainAgreementViolation(int doc, byte[] mmd) throws BadSyntaxException;
}
