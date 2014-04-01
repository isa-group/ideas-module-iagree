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

import es.us.isa.ada.document.AgreementElement;
import es.us.isa.ada.errors.AgreementError;
import es.us.isa.ada.errors.Explanation;
import es.us.isa.ada.exceptions.BadSyntaxException;
import es.us.isa.ada.exceptions.PeriodDefinitionException;
import es.us.isa.ada.exceptions.PeriodDefinitionWarningException;
import es.us.isa.ada.wsag10.Term;

public interface ADAService {

	/**
	 * Checks consistency for this document
	 * @param doc byte[] document
	 * @return boolean consistent
	 */
	public boolean checkDocumentConsistency(byte[] doc) throws PeriodDefinitionException, PeriodDefinitionWarningException, BadSyntaxException;
	
	/**
	 * Nos devuelve el conjunto de explicaciones de por que el documento
	 * pasado como parametro no es consistente. En caso de si serlo,
	 * el array de respuesta queda vacio
	 * @param doc
	 * @return
	 */
	public Map<AgreementElement, Collection<AgreementElement>> explainInconsistencies(byte[] doc) throws BadSyntaxException;
	
	/**
	 * Returns ludicrous terms of this document
	 * 
	 * @param doc byte[] document
	 * @return Collection<Term> ludicrous terms
	 */
	public Collection<Term> getLudicrousTerms(byte[] doc) throws BadSyntaxException;
	
	/**
	 * Returns dead terms of this document
	 * 
	 * @param doc byte[] document
	 * @return Collection<Term> dead terms
	 */
	public Collection<Term> getDeadTerms(byte[] doc) throws BadSyntaxException;
	
	/**
	 * Returns the explanations of ludicrous terms from
	 * a document and its ludicrous terms.
	 * 
	 * @param doc byte[] document
	 * @param terms Collection<Term> ludicrous terms
	 * @return Map<AgreementElement,Collection<AgreementElement>>
	 */
	public Map<Term,Collection<AgreementElement>> 
			explainLudicrousTerms(byte [] doc, Collection<Term> terms) throws BadSyntaxException;
	
	/**
	 * Returns the explanations of dead terms from
	 * a document and its dead terms.
	 * 
	 * @param doc byte[] document
	 * @param terms Collection<Term> dead terms
	 * @return Map<AgreementElement,Collection<AgreementElement>>
	 */
	public Map<Term,Collection<AgreementElement>> 
			explainDeadTerms(byte [] doc, Collection<Term> terms) throws BadSyntaxException;
	
	
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
	 * o el error que ha ocurrido para que no pueda subirse
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
	 */
	public byte[] xmlToWSAg4People(byte[] xmlAg) throws BadSyntaxException;
	
	/**
	 * Transforms a WSAg4People file into a xml wsag file
	 * 
	 * @param wsag4poeple byte[]
	 * @return byte[] xml file
	 */
	public byte[] wsag4PeopleToXML(byte[] wsag4people) throws BadSyntaxException;
	
	/**
	 * Analyses if an offer is compliant 
	 * with a template 
	 * 
	 * @param template byte[] 
	 * @param offer byte[]
	 * @return boolean compliant
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
	 */
	public Map<AgreementError, Explanation> explainNonCompliance(byte[] template, byte[] offer) throws BadSyntaxException;
	
}
