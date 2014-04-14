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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.ADA;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AbstractDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AgreementElement;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.errors.AgreementError;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.errors.Explanation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionException;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionWarningException;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.loaders.ExtensionsLoader;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.loaders.ReflexionExtensionsLoader;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.AgreementFulfilmentOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.AlternativeDocumentsOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ComplianceOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ConsistencyOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.DeadTermsOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.DecomposeIntoViewsOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ExplainAgreementViolation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ExplainDeadTerms;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ExplainLessRestrictiveTemplateTermsOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ExplainLudicrousTerms;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ExplainMoreRestrictiveOfferOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ExplainNoConsistencyOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.ExplainNonComplianceOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.LessRestrictiveOfferComplianceOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.LudicrousTermsOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.MoreRestrictiveTemplateTermsComplianceOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.operations.NumberOfAlternativeDocsOperation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.salmon.MonitoringManagementDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term;

//TODO ver como mejorar el tema de que falle el archivo :)
public class ADAServiceImpl implements ADAServiceV2 {

	private ADA ada;

	//private final static String METRICS_FOLDER = "C:/Users/Antonio/workspaceICSOC/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/iAgreeStudioServerComponent/metrics";
	//private final static String METRICS_FOLDER = "/usr/share/tomcat6/webapps/iAgreeStudioServerComponent/metrics";
	//private final static String METRICS_FOLDER = "C:/workspaceADA/iAgreeStudioServerComponent/metrics";
	private final static String METRICS_FOLDER = "C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/iAgreeStudioServerComponent/metrics";
	
	public ADAServiceImpl() {
		ExtensionsLoader el = new ReflexionExtensionsLoader();
		ada = new ADA(el);
	}

	@Override
	public boolean checkDocumentConsistency(byte[] d) throws BadSyntaxException, PeriodDefinitionException, PeriodDefinitionWarningException {

		try {
			File f = toTempFile(d);
			String path = f.getAbsolutePath();
			AbstractDocument doc = ada.loadDocument(path);
			ConsistencyOperation op;
			// load TimeAwareConsistency if the document has temporality
			AbstractAgreementDocument absDoc = (AbstractAgreementDocument) doc;
			if(absDoc.getHasTemporality()){
				op = (ConsistencyOperation) ada.createOperation(ADA.TEMPORAL_CONSISTENCY);
			}else{
				op = (ConsistencyOperation) ada.createOperation(ADA.CONSISTENCY);
			}
			op.addDocument(doc);
			ada.analyze(op);
			boolean res = op.isConsistent();
			deleteTempFiles(f);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private File toTempFile(byte[] in) throws IOException {

		File f = File.createTempFile("tmp", ".wsag");
		FileOutputStream os = new FileOutputStream(f);
		os.write(in);
		os.flush();
		os.close();
		return f;

	}

	@Override
	public Map<AgreementElement, Collection<AgreementElement>> explainInconsistencies(byte[] d) throws BadSyntaxException {

		try {
			File f = toTempFile(d);
			String path = f.getAbsolutePath();
			AbstractDocument doc = ada.loadDocument(path);
			ExplainNoConsistencyOperation op;
			AbstractAgreementDocument absDoc = (AbstractAgreementDocument) doc;
			if(absDoc.getHasTemporality()){
				op = (ExplainNoConsistencyOperation) ada.createOperation(ADA.TEMPORAL_EXPLAIN_NO_CONSISTENCY);
			}else{
				op = (ExplainNoConsistencyOperation) ada.createOperation(ADA.EXPLAIN_NON_CONSISTENCY);
			}
			op.addDocument(doc);
			ada.analyze(op);
			Map<AgreementElement, Collection<AgreementElement>> res = op.explainErrors();
			// Explanation[] res = aux.toArray(new Explanation[1]);
			deleteTempFiles(f);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public Map<AgreementError, Explanation> explainNonCompliance(byte[] template, byte[] offer) throws BadSyntaxException {

		try {
			File f1 = toTempFile(template);
			String templateFile = f1.getAbsolutePath();
			File f2 = toTempFile(offer);
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
		}

	}
	
	@Override
	public Map<AgreementError, Explanation> explainMoreRestrictiveOffer(byte[] template, byte[] offer) throws BadSyntaxException {

		try {
			File f1 = toTempFile(template);
			String templateFile = f1.getAbsolutePath();
			File f2 = toTempFile(offer);
			String offerFile = f2.getAbsolutePath();
			AbstractDocument t = ada.loadDocument(templateFile);
			AbstractDocument o = ada.loadDocument(offerFile);
			ExplainMoreRestrictiveOfferOperation op = (ExplainMoreRestrictiveOfferOperation) ada.createOperation(ADA.EXPLAIN_MORE_RESTRICTIVE_OFFER);
			op.addDocument(t);
			op.addDocument(o);
			ada.analyze(op);
			Map<AgreementError, Explanation> res = op.explainErrors();
			deleteTempFiles(f1, f2);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	@Override
	public Map<AgreementError, Explanation> explainLessRestrictiveTemplateTerms(byte[] template) throws BadSyntaxException {

		try {
			File f1 = toTempFile(template);
			String templateFile = f1.getAbsolutePath();
			//File f2 = toTempFile(offer);
			//String offerFile = f2.getAbsolutePath();
			AbstractDocument t = ada.loadDocument(templateFile);
			//AbstractDocument o = ada.loadDocument(offerFile);
			ExplainLessRestrictiveTemplateTermsOperation op = (ExplainLessRestrictiveTemplateTermsOperation) ada.createOperation(ADA.EXPLAIN_LESS_RESTRICTIVE_TEMPLATE_TERMS);
			op.addDocument(t);
			//op.addDocument(o);
			ada.analyze(op);
			Map<AgreementError, Explanation> res = op.explainErrors();
			deleteTempFiles(f1);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public boolean isCompliant(byte[] template, byte[] offer) throws BadSyntaxException {

		try {
			File f1 = toTempFile(template);
			String templateFile = f1.getAbsolutePath();
			File f2 = toTempFile(offer);
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
		}

	}
	
	@Override
	public boolean isLessRestrictiveOffer(byte[] template, byte[] offer)
			throws PeriodDefinitionException, PeriodDefinitionWarningException,
			BadSyntaxException {
		try {
			File f1 = toTempFile(template);
			String templateFile = f1.getAbsolutePath();
			File f2 = toTempFile(offer);
			String offerFile = f2.getAbsolutePath();
			AbstractDocument t = ada.loadDocument(templateFile);
			AbstractDocument o = ada.loadDocument(offerFile);
			LessRestrictiveOfferComplianceOperation op = (LessRestrictiveOfferComplianceOperation) ada.createOperation(ADA.LESSRESTRICTIVEOFFERCOMPLIANCE);
			op.addDocument(t);
			op.addDocument(o);
			ada.analyze(op);
			boolean res = op.isLessRestrictiveOffer();
			deleteTempFiles(f1, f2);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean isMoreRestrictiveTemplateTermsThanCC(byte[] template)
			throws PeriodDefinitionException, PeriodDefinitionWarningException,
			BadSyntaxException {
		try {
			File f = toTempFile(template);
			String path = f.getAbsolutePath();
			AbstractDocument doc = ada.loadDocument(path);
			MoreRestrictiveTemplateTermsComplianceOperation op;
			// load Other class if the document has temporality
			AbstractAgreementDocument absDoc = (AbstractAgreementDocument) doc;
			if(absDoc.getHasTemporality()){
				//op = (ConsistencyOperation) ada.createOperation(ADA.TEMPORAL_CONSISTENCY);
				// TODO de momento utilizo la misma clase
				op = (MoreRestrictiveTemplateTermsComplianceOperation) ada.createOperation(ADA.MORERESTRICTIVETEMPLATETERMSCOMPLIANCE);
			}else{
				op = (MoreRestrictiveTemplateTermsComplianceOperation) ada.createOperation(ADA.MORERESTRICTIVETEMPLATETERMSCOMPLIANCE);
			}
			op.addDocument(doc);
			ada.analyze(op);
			boolean res = op.isMoreRestrictiveTemplateTermsThanCC();
			deleteTempFiles(f);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private void deleteTempFiles(File... files) {
		for (int i = 0; i < files.length; i++) {
			files[i].delete();
		}
	}

	@Override
	public byte[] getMetricFile(String path) {
		byte[] res = null;
		File f = new File(path);
		if (f.exists()) {
			try {
				InputStream in = new FileInputStream(f);
				BufferedReader reader = new BufferedReader(new InputStreamReader(in));
				String aux = "";
				String s;
				while ((s = reader.readLine()) != null) {
					aux += s + "\n";
				}
				res = aux.getBytes();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	@Override
	public String addMetricFile(byte[] data, byte[] name) {
		// long l = System.nanoTime();
		String result = null;
		String metricNameToAdd = new String(name);
		// Comprobamos que no exista un documento con el mismo nombre
		
		File metricsPath = new File(METRICS_FOLDER);
		File[] metrics = metricsPath.listFiles();
		
		Boolean existingMetricName = false;
		if (metrics!=null){
			for (File metric : metrics) {
				
				if (metricNameToAdd.equalsIgnoreCase(metric.getName())) {
					// Lanzar error y no seguimos buscando
					result = metricNameToAdd + " already exists";
					existingMetricName = true;
					break;
				}
			}
		}
		
		if (!existingMetricName) {
			// Si no ha encontrado ninguno con el mismo nombre
			// lo creamos
			String path = METRICS_FOLDER + "/" + metricNameToAdd;
			
			try {
				OutputStream out = new FileOutputStream(path);
				out.write(data);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			result = path;
		}
		return result;
		// //TODO implementarlo con mayor seguridad
		// //para impedir que peten el servidor en el futuro
		// return "";
	}

	@Override
	public byte[] xmlToWSAg4People(byte[] xmlAg) throws BadSyntaxException {
		String s = new String(xmlAg);
		String res;
		try {
			res = ada.transformTo(s, "wsag", "wsag4people");
		} catch (Exception e) {
			throw new BadSyntaxException();
		}
		return res.getBytes();
	}

	@Override
	public byte[] wsag4PeopleToXML(byte[] wsag4PeopleAg) throws BadSyntaxException {
		String s = new String(wsag4PeopleAg);

		String res;
		try {
			res = ada.transformTo(s, "wsag4people", "wsag");
		} catch (Exception e) {
			throw new BadSyntaxException();
		}

		// Descomentar esto para probarlo una vez se ponga el c-digo definitivo
		return res.getBytes();
		// return null;
	}

	@Override
	public Map<Term, Collection<AgreementElement>> explainDeadTerms(byte[] d, Collection<Term> terms) throws BadSyntaxException {
		try {
			File f = toTempFile(d);
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
		}
	}

	@Override
	public Map<Term, Collection<AgreementElement>> explainLudicrousTerms(byte[] d, Collection<Term> terms) throws BadSyntaxException {
		try {
			File f = toTempFile(d);
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
		}
	}

	@Override
	public Collection<Term> getDeadTerms(byte[] d) throws BadSyntaxException {
		try {
			File f = toTempFile(d);
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
		}
	}

	@Override
	public Collection<Term> getLudicrousTerms(byte[] d) throws BadSyntaxException {
		try {
			File f = toTempFile(d);
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
		}
	}

	@Override
	public Map<AgreementError, Explanation> explainAgreementViolation(byte[] doc, byte[] mmdString) throws BadSyntaxException {
		try {
			File f1 = toTempFile(doc);
			String f1Path = f1.getAbsolutePath();
			AbstractDocument d = ada.loadDocument(f1Path);
			ExplainAgreementViolation op = (ExplainAgreementViolation) ada.createOperation(ADA.VIOLATION_EXPLANATIONS);
			op.addDocument(d);
			MonitoringManagementDocument mmd = parseMMD(mmdString);
			op.setMMD(mmd);
			ada.analyze(op);
			Map<AgreementError, Explanation> res = op.explainViolation();
			deleteTempFiles(f1);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean isFulfilled(byte[] d, byte[] mmdString) throws BadSyntaxException {
		try {
			File f = toTempFile(d);
			String path = f.getAbsolutePath();
			AbstractDocument doc = ada.loadDocument(path);
			AgreementFulfilmentOperation op = (AgreementFulfilmentOperation) ada.createOperation(ADA.AGREEMENT_FULFILMENT);
			op.addDocument(doc);
			MonitoringManagementDocument mmd = parseMMD(mmdString);
			op.setMMD(mmd);
			ada.analyze(op);
			boolean res = op.isFulfilled();
			deleteTempFiles(f);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	private MonitoringManagementDocument parseMMD(byte[] mmd) {
		String mmdString = new String(mmd);
		MonitoringManagementDocument doc = new MonitoringManagementDocument(mmdString);
		return doc;
	}

	@Override
	public Collection<AbstractAgreementDocument> getAlternativeDocuments(byte[] doc) {
		try {
			File f1 = toTempFile(doc);
			String path = f1.getAbsolutePath();
			AbstractDocument t = ada.loadDocument(path);
			AlternativeDocumentsOperation op = (AlternativeDocumentsOperation) ada.createOperation(ADA.ALTERNATIVE_DOCUMENTS);
			op.addDocument(t);
			ada.analyze(op);
			Collection<AbstractDocument> alternatives = op.getAlternativeDocuments();
			Collection<AbstractAgreementDocument> res = new LinkedList<AbstractAgreementDocument>();
			for(AbstractDocument d: alternatives){
				res.add((AbstractAgreementDocument) d);
			}
			deleteTempFiles(f1);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Collection<AbstractAgreementDocument> getDocumentViews(byte[] doc) {
		try {
			File f1 = toTempFile(doc);
			String path = f1.getAbsolutePath();
			AbstractDocument t = ada.loadDocument(path);
			DecomposeIntoViewsOperation op = (DecomposeIntoViewsOperation) ada.createOperation(ADA.VIEWS);
			op.addDocument(t);
			ada.analyze(op);
			Collection<AbstractDocument> alternatives = op.getOperationViews();
			Collection<AbstractAgreementDocument> res = new LinkedList<AbstractAgreementDocument>();
			for(AbstractDocument d: alternatives){
				res.add((AbstractAgreementDocument) d);
			}
			deleteTempFiles(f1);
			return res;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getNumberOfAlternatives(byte[] doc) {
		try{
			File f1 = toTempFile(doc);
			String path = f1.getAbsolutePath();
			
			AbstractDocument t = ada.loadDocument(path);
			
			NumberOfAlternativeDocsOperation op = (NumberOfAlternativeDocsOperation) ada.createOperation(ADA.NUMBER_OF_ALTERNATIVES);
			
			
			op.addDocument(t);
			
			ada.analyze(op);
			
			int res = op.getNumberOfAlternativeDocs();
			deleteTempFiles(f1);
			return res;
		}catch(IOException e){
			e.printStackTrace();
			return -1;
		}
	}

}
