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

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AgreementElement;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.errors.AgreementError;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.errors.Explanation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.loaders.ExtensionsLoader;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.loaders.ReflexionExtensionsLoader;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term;

public class ADAServiceWithRepoImpl implements ADAServiceWithRepo {

	private ADAManagerService adama;
	
	private ADAServiceV2 ada;
	
	public ADAServiceWithRepoImpl(){
		ExtensionsLoader el = new ReflexionExtensionsLoader();
		adama = new  ADAManagerServiceImpl(el);
		ada = new ADAServiceImpl();
	}
	
	@Override
	public String addMetricFile(byte[] doc, byte[] docName) {
		return ada.addMetricFile(doc, docName);
	}

	@Override
	public boolean checkDocumentConsistency(int doc) throws BadSyntaxException {
		byte[] d = documentId2String(doc);
		return ada.checkDocumentConsistency(d);
	}

	@Override
	public Map<Term, Collection<AgreementElement>> explainDeadTerms(int doc, Collection<Term> terms) throws BadSyntaxException {
		byte[] d = documentId2String(doc);
		return ada.explainDeadTerms(d, terms);
	}

	@Override
	public Map<AgreementElement, Collection<AgreementElement>> explainInconsistencies(int doc) throws BadSyntaxException {
		byte[] d = documentId2String(doc);
		return ada.explainInconsistencies(d);
	}

	@Override
	public Map<Term, Collection<AgreementElement>> explainLudicrousTerms(int doc, Collection<Term> terms) throws BadSyntaxException {
		byte[] d = documentId2String(doc);
		return ada.explainLudicrousTerms(d, terms);
	}

	@Override
	public Map<AgreementError, Explanation> explainNonCompliance(int template, int offer) throws BadSyntaxException {
		byte[] t = documentId2String(template);
		byte[] o = documentId2String(offer);
		return ada.explainNonCompliance(t, o);
	}

	@Override
	public Collection<Term> getDeadTerms(int doc) throws BadSyntaxException {
		byte[] d = documentId2String(doc);
		return ada.getDeadTerms(d);
	}

	@Override
	public Collection<Term> getLudicrousTerms(int doc) throws BadSyntaxException {
		byte[] d = documentId2String(doc);
		return ada.getLudicrousTerms(d);
	}

	@Override
	public byte[] getMetricFile(String path) {
		return ada.getMetricFile(path);
	}

	@Override
	public boolean isCompliant(int template, int offer) throws BadSyntaxException {
		byte[] t = documentId2String(template);
		byte[] o = documentId2String(offer);
		return ada.isCompliant(t, o);
	}

	@Override
	public byte[] wsag4PeopleToXML(byte[] wsag4people) throws BadSyntaxException {
		return ada.wsag4PeopleToXML(wsag4people);
	}

	@Override
	public byte[] xmlToWSAg4People(byte[] xmlAg) throws BadSyntaxException {
		return ada.xmlToWSAg4People(xmlAg);
	}

	@Override
	public Map<AgreementError, Explanation> explainAgreementViolation(int doc, byte[] mmd) throws BadSyntaxException {
		byte[] d = documentId2String(doc);
		return ada.explainAgreementViolation(d, mmd);
	}

	@Override
	public boolean isFulfilled(int doc, byte[] mmd) throws BadSyntaxException {
		byte[] d = documentId2String(doc);
		return ada.isFulfilled(d, mmd);
	}
	
	//da igual ponerla publica, pues en la interfaz no aparece,
	//y no se va a registrar
	public byte[] documentId2String(int docId){
		byte[] doc = null;
		try{
			doc = adama.documentId2String(docId);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return doc;
	}

}
