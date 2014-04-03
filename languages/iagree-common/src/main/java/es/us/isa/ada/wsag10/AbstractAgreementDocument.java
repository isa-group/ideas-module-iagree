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

import java.util.Collection;

import es.us.isa.ada.document.AbstractDocument;
import es.us.isa.ada.document.DocumentConstraint;
import es.us.isa.ada.document.DocumentVariable;


/**
 * @author    cmuller
 */
public abstract class AbstractAgreementDocument extends AbstractDocument{
	
	
	/**
	 * @uml.property  name="id"
	 */
	protected String id;
	/**
	 * @uml.property  name="name"
	 */
	protected String name;
	/**
	 * @uml.property  name="terms"
	 * @uml.associationEnd  
	 */
	protected TermCompositor terms;
	/**
	 * @uml.property  name="context"
	 * @uml.associationEnd  
	 */
	protected Context context;
	
	protected Boolean hasAlternatives;
	
	protected Boolean hasViews;
	
	protected Boolean hasTemporality;
	
	/**
	 * True if some term that accepts temporality in this agreement has been defined in global period. False otherwise
	 */
	protected Boolean hasSomeGlobalTerm;
	
//	protected ITranslator translator;

	public AbstractAgreementDocument() {
		super();
		terms = new TermCompositor();
		context = new Context();
		name = "";
		id = "";
		hasAlternatives = false;
		hasViews = false;
		hasTemporality = false;
//		translator = new WSAGTranslator();
	}

	/* (non-Javadoc)
	 * @see wsAgreement.AgDoc#getId()
	 */
	/**
	 * @return
	 * @uml.property  name="id"
	 */
	public String getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see wsAgreement.AgDoc#setId(java.lang.String)
	 */
	/**
	 * @param  id
	 * @uml.property  name="id"
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param  name
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 * @uml.property  name="terms"
	 */
	public TermCompositor getTerms() {
		return terms;
	}

	/**
	 * @param  terms
	 * @uml.property  name="terms"
	 */
	public void setTerms(TermCompositor terms) {
		this.terms = terms;
	}

	/**
	 * @return
	 * @uml.property  name="context"
	 */
	public Context getContext() {
		return context;
	}

	/**
	 * @param  context
	 * @uml.property  name="context"
	 */
	public void setContext(Context context) {
		this.context = context;
	}
	
	public Boolean getHasAlternatives(){
		return hasAlternatives;
	}
	
	public void setHasAlternatives(Boolean hasAlternatives){
		this.hasAlternatives = hasAlternatives;
	}
	
	public Boolean getHasViews(){
		return hasViews;
	}
	
	public void setHasViews(Boolean hasViews){
		this.hasViews = hasViews;
	}
	
	public Boolean getHasTemporality(){
		return hasTemporality;
	}
	
	public void setHasTemporality(Boolean hasTemporality){
		this.hasTemporality = hasTemporality;
	}
	
	/**
	 * 
	 * @return true if some term that accepts temporality in this agreement has been defined in global period. False otherwise
	 */
	public Boolean getHasSomeGlobalTerm(){
		return hasSomeGlobalTerm;
	}
	
	public void setHasSomeGlobalTerm(Boolean has){
		this.hasSomeGlobalTerm = has;
	}
	
	/**
	 * Devuelve las restricciones derivadas los terminos del documento
	 * 
	 */
	@Override
	public Collection<DocumentConstraint> getConstraints() {
		// TODO meter aqui las creation constraints, SLO's y demas
		return null;
	}

	/**
	 * Devuelve las variables derivadas de los terminos del documento
	 */
	@Override
	public Collection<DocumentVariable> getVariables() {
		// TODO meter aqui las serviceProperties, serviceDescription e Items
		return null;
	}
	
	public Collection<Term> getAllTerms(){
		return terms.getComprisedTerms();
	}


}
