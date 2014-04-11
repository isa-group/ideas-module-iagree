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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.ADA;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AbstractDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AgreementElement;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.errors.AgreementError;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.errors.Explanation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.loaders.ExtensionsLoader;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.loaders.ReflexionExtensionsLoader;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ComplianceOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ConsistencyOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.DeadTermsOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ExplainDeadTerms;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ExplainLudicrousTerms;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ExplainNoConsistencyOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ExplainNonComplianceOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.LudicrousTermsOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term;

public class ADA4Wsag4JFacadeImpl implements ADA4Wsag4JFacade {

	private ADA4Wsag4J ada;

	public ADA4Wsag4JFacadeImpl() {
		ExtensionsLoader el = new ReflexionExtensionsLoader();
		ada = new ADA4Wsag4J(el);
	}

	@Override
	public Boolean checkConsistency(String documentContent) throws BadSyntaxException {
		try {
			File f = toTempFile(documentContent);
			String path = f.getAbsolutePath();
			AbstractDocument doc = ada.loadDocument(path);
			ConsistencyOperation op = (ConsistencyOperation) ada.createOperation(ADA.CONSISTENCY);
			op.addDocument(doc);
			ada.analyze(op);
			Boolean res = op.isConsistent();
			deleteTempFiles(f);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new BadSyntaxException();
		}
	}

	@Override
	public Map<AgreementElement, Collection<AgreementElement>> explainInconsistencies(String documentContent) throws BadSyntaxException {
		try {
			File f = toTempFile(documentContent);
			String path = f.getAbsolutePath();
			AbstractDocument doc = ada.loadDocument(path);
			ExplainNoConsistencyOperation op = (ExplainNoConsistencyOperation) ada.createOperation(ADA.EXPLAIN_NON_CONSISTENCY);
			op.addDocument(doc);
			ada.analyze(op);
			Map<AgreementElement, Collection<AgreementElement>> res = op.explainErrors();
			deleteTempFiles(f);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new BadSyntaxException();
		}
	}

	@Override
	public Collection<Term> getDeadTerms(String documentContent) throws BadSyntaxException {
		try {
			File f = toTempFile(documentContent);
			String path = f.getAbsolutePath();
			AbstractDocument doc = ada.loadDocument(path);
			DeadTermsOperation op = (DeadTermsOperation) ada.createOperation(ADA.DEAD_TERMS);
			op.addDocument(doc);
			ada.analyze(op);
			Collection<Term> res = op.getDeadTerms();
			deleteTempFiles(f);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new BadSyntaxException();
		}
	}

	@Override
	public Map<Term, Collection<AgreementElement>> explainDeadTerms(String documentContent, Collection<Term> terms) throws BadSyntaxException {
		try {
			File f = toTempFile(documentContent);
			String path = f.getAbsolutePath();
			AbstractDocument doc = ada.loadDocument(path);
			ExplainDeadTerms op = (ExplainDeadTerms) ada.createOperation(ADA.EXPLAIN_DEAD_TERMS);
			op.addDocument(doc);
			op.setDeadTerms(terms);
			ada.analyze(op);
			Map<Term, Collection<AgreementElement>> res = op.explainDeadTerms();
			deleteTempFiles(f);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new BadSyntaxException();
		}
	}

	@Override
	public Collection<Term> getLudicrousTerms(String documentContent) throws BadSyntaxException {
		try {
			File f = toTempFile(documentContent);
			String path = f.getAbsolutePath();
			AbstractDocument doc = ada.loadDocument(path);
			LudicrousTermsOperation op = (LudicrousTermsOperation) ada.createOperation(ADA.LUDICROUS_TERMS);
			op.addDocument(doc);
			ada.analyze(op);
			Collection<Term> res = op.getLudicrousTerms();
			deleteTempFiles(f);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new BadSyntaxException();
		}
	}

	@Override
	public Map<Term, Collection<AgreementElement>> explainLudicrousTerms(String documentContent, Collection<Term> terms) throws BadSyntaxException {
		try {
			File f = toTempFile(documentContent);
			String path = f.getAbsolutePath();
			AbstractDocument doc = ada.loadDocument(path);
			ExplainLudicrousTerms op = (ExplainLudicrousTerms) ada.createOperation(ADA.EXPLAIN_LUDICROUS_TERMS);
			op.addDocument(doc);
			op.setLudicrousTerms(terms);
			ada.analyze(op);
			Map<Term, Collection<AgreementElement>> res = op.explainLudicrousTerms();
			deleteTempFiles(f);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new BadSyntaxException();
		}
	}

	@Override
	public Boolean checkCompliance(String templateContent, String offerContent) throws BadSyntaxException {
		try {
			File f1 = toTempFile(templateContent);
			String templateFile = f1.getAbsolutePath();
			File f2 = toTempFile(offerContent);
			String offerFile = f2.getAbsolutePath();
			AbstractDocument t = ada.loadDocument(templateFile);
			AbstractDocument o = ada.loadDocument(offerFile);
			ComplianceOperation op = (ComplianceOperation) ada.createOperation(ADA.COMPLIANCE);
			op.addDocument(t);
			op.addDocument(o);
			ada.analyze(op);
			boolean res = op.isCompliant();
			deleteTempFiles(f1, f2);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new BadSyntaxException();
		}
	}

	@Override
	public Map<AgreementError, Explanation> explainNonCompliance(String templateContent, String offerContent) throws BadSyntaxException {
		try {
			File f1 = toTempFile(templateContent);
			String templateFile = f1.getAbsolutePath();
			File f2 = toTempFile(offerContent);
			String offerFile = f2.getAbsolutePath();
			AbstractDocument t = ada.loadDocument(templateFile);
			AbstractDocument o = ada.loadDocument(offerFile);
			ExplainNonComplianceOperation op = (ExplainNonComplianceOperation) ada.createOperation(ADA.EXPLAIN_NON_COMPLIANCE);
			op.addDocument(t);
			op.addDocument(o);
			ada.analyze(op);
			Map<AgreementError, Explanation> res = op.explainErrors();
			deleteTempFiles(f1, f2);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (NullPointerException e) {
			e.printStackTrace();
			throw new BadSyntaxException();
		}
	}

	private File toTempFile(String in) throws IOException {
		File f = File.createTempFile("tmp", ".wsag");
		FileOutputStream os = new FileOutputStream(f);
		os.write(in.getBytes());
		os.flush();
		os.close();
		return f;
	}

	private void deleteTempFiles(File... files) {
		for (int i = 0; i < files.length; i++) {
			files[i].delete();
		}
	}
}
