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

import es.us.isa.ada.ADA;
import es.us.isa.ada.document.AbstractDocument;
import es.us.isa.ada.loaders.ExtensionsLoader;
import es.us.isa.ada.operations.DecomposeIntoViewsOperation;
import es.us.isa.ada.repository.DocumentProxy;
import es.us.isa.ada.salmon.*;
import es.us.isa.ada.subfacades.ADAManager;
import es.us.isa.ada.wsag10.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.Map.Entry;

public class ADAManagerServiceImpl implements ADAManagerService {

	private ADAManager adama;
    private ExtensionsLoader extensionsLoader;

	// private AgreementRepository repo;
	//
	// private SessionManager session;


    public ADAManagerServiceImpl(ExtensionsLoader extensionsLoader) {
        adama = extensionsLoader.getADAManager();
        this.extensionsLoader = extensionsLoader;
    }

	@Override
	public boolean deleteAgreement(int id, String session) throws SQLException {
		return adama.getAgreementRepository().deleteAgreement(id, session);
	}

	@Override
	public Map<Integer, DocumentProxy> getAgreementsByUser(String session) throws SQLException {
		return adama.getAgreementRepository().getAgreementsByUser(session);
	}

	@Override
	public Map<Integer, DocumentProxy> getPublicAgreements() throws SQLException {
		return adama.getAgreementRepository().getPublicAgreements();
	}

	@Override
	public int getUserId(String session) {
		return adama.getSessionManager().getUserId(session);
	}

	@Override
	public String login(String user, String pass) {
		return adama.getSessionManager().login(user, pass);
	}

	@Override
	public boolean logout(String session) {
		return adama.getSessionManager().logout(session);
	}

	@Override
	public int storeAgreement(String agreementName, String agreementContent, String session) throws SQLException {
		return adama.getAgreementRepository().storeAgreement(agreementName, agreementContent, session);
	}

	@Override
	public boolean updateAgreement(int id, String agreementName, String agreementContent, String session) throws SQLException {
		return adama.getAgreementRepository().updateAgreement(id, agreementName, agreementContent, session);
	}

	@Override
	public String getMMD(int docId, String session) {
		/*
		 * dado el identificador del documento, generar el documento
		 * de monitorizaci�n (MonitoringManagementDocument) de este.
		 * Si la sesi�n no es del usuario due�o del documento, devolver null.
		 * Si el documento no tiene WebServiceInformation dentro de los SDT,
		 * devolver un MonitoringManagementDocument sin WebServiceInformation
		 */
		MonitoringManagementDocument mmd = new MonitoringManagementDocument();
		//If logged user is document owner
		Boolean loggedUserIsDocumentOwner = false;
		try {
			Map<Integer, DocumentProxy> userDocuments = adama.getAgreementRepository().getAgreementsByUser(session);
			for (Entry<Integer, DocumentProxy> doc : userDocuments.entrySet()) {
				if (doc.getKey().intValue() == docId) {
					loggedUserIsDocumentOwner = true;
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (loggedUserIsDocumentOwner && docId != 0) {
			try {
				Map<String, Collection<String>> monProps = new HashMap<String, Collection<String>>();
				// Get document
				DocumentProxy docProx = adama.getAgreementRepository().getAgreementById(docId);
				File f = toTempFile(docProx.getContent().getBytes());
				String path = f.getAbsolutePath();
				ADA ada = new ADA(extensionsLoader);
				AbstractAgreementDocument doc = (AbstractAgreementDocument) ada.loadDocument(path);
				Date expirationTime = doc.getContext().getExpirationTime();
//				//Get all variables
				Collection<String> allVariables = new LinkedList<String>();
				Collection<Term> allTerms = doc.getAllTerms();
				for(Term t:allTerms){
					if(t instanceof ServiceProperties){
						ServiceProperties sp = (ServiceProperties) t;
						Set<Variable> varSet = sp.getVariableSet();
						for(Variable v:varSet){
							allVariables.add(v.getName());
						}
					}
				}
				//Get Views of the document
				DecomposeIntoViewsOperation op = (DecomposeIntoViewsOperation) ada.createOperation(ADA.VIEWS);
				op.addDocument(doc);
				ada.analyze(op);
				//get variables without scope
				Set<Variable> varsWithoutScope = op.getVariablesWithoutScope();
				// Get ServiceScope and Document for every view
				Map<ServiceScope, AbstractDocument> views = op.getScopes2Views();
				for (Entry<ServiceScope, AbstractDocument> view : views.entrySet()) {
					String serviceScope = view.getKey().getContent();
					AbstractAgreementDocument auxDoc = (AbstractAgreementDocument) view.getValue();
					// Get name for every variable in this view of the document
					Collection<String> auxVariables = new LinkedList<String>();
					Collection<Term> terms = auxDoc.getAllTerms();
					ServiceProperties props = null;
					for (Term t : terms) {
						if (t instanceof ServiceProperties) {
							props = (ServiceProperties) t;
						}else if(t instanceof ServiceDescriptionTerm){
							//Create WebServiceInformation
							ServiceDescriptionTerm sdt = (ServiceDescriptionTerm) t;
							WebServiceInformation wsi = sdt.getWebServiceInformation();
							mmd.setWebServiceInformation(wsi);
						}
					}
					
					Set<Variable> vars = props.getVariableSet();
					for (Variable v:vars) {
						if(!varsWithoutScope.contains(v)){
							auxVariables.add(v.getName());
						}
					}
					monProps.put(serviceScope, auxVariables);
				}
				
//				//La variable que no est� en el alg�n Scope no ser� ServiceMetric
//				Collection<String> serviceMetrics = new HashSet<String>();
//				for(String v:allVariables){
//					//Suponemos que cada variable es ServiceMetric
//					Boolean isServiceMetric = true;
//					for(Entry<String, Collection<String>> monProp:monProps.entrySet()){
//						//Por cada ServiceScope
//						Collection<String> scopeVars = monProp.getValue();
//						if(!scopeVars.contains(v)){
//							//Si la variable no est� entre las variables 
//							//de el Scope entonces no es ServiceMetric
//							isServiceMetric = false;
//							break;
//						}
//					}
//					if(isServiceMetric){
//						//Si es ServiceMetric lo creamos y a�adimos al MMD
//						String metric = v;
//						String localPeriodInit = Utils.getTimestamp();
//						String localPeriodEnd = Utils.dateTrasform(expirationTime);
//						ServiceMetric sm = new ServiceMetric(metric, localPeriodInit, localPeriodEnd);
//						mmd.addServiceMetric(sm);
//						serviceMetrics.add(metric);
//					}
//				}
				//Create ServiceMetric
				Collection<String> serviceMetrics = new HashSet<String>();
				for(Variable var:varsWithoutScope){
					String metric = var.getName();
					String localPeriodInit = Utils.getTimestamp();
					String localPeriodEnd = Utils.dateTrasform(expirationTime);
					ServiceMetric sm = new ServiceMetric(metric, localPeriodInit, localPeriodEnd);
					mmd.addServiceMetric(sm);
					serviceMetrics.add(metric);
					
				}
				//Create OperationMetric
				for(Entry<String, Collection<String>> monProp:monProps.entrySet()){
					String scope = monProp.getKey();
					for(String var:monProp.getValue()){
						if(!serviceMetrics.contains(var)){
							//Si no es un ServiceMetric
							String opName = scope.trim();
							String metric = var;
							String localPeriodInit = Utils.getTimestamp();
							String localPeriodEnd = Utils.dateTrasform(expirationTime);
							OperationMetric om = new OperationMetric(opName, metric, localPeriodInit, localPeriodEnd);
							mmd.addOperationMetric(om);
						}
					}
				}
				//Create MonitorConfiguration
				MonitorConfiguration mc = new MonitorConfiguration(expirationTime);
				mmd.setMonitorConfiguration(mc);
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return mmd.toString();
	}

//	private Map<String, Collection<String>> getMonitorisableProperties(int docId, String sessions) {
//		// dado el identificador del documento, generar
//		// el documento de monitorizaci�n (monitoring management
//		// document de este. si la sesion
//		// no es del usuario due�o del documento, devolver un map vacio
//		Map<String, Collection<String>> monProps = new HashMap<String, Collection<String>>();
//		//If logged user is document owner
//		Boolean loggedUserIsDocumentOwner = false;
//		try {
//			Map<Integer, DocumentProxy> userDocuments = adama.getAgreementRepository().getAgreementsByUser(sessions);
//			for (Entry<Integer, DocumentProxy> doc : userDocuments.entrySet()) {
//				if (doc.getKey().intValue() == docId) {
//					loggedUserIsDocumentOwner = true;
//				}
//			}
//		} catch (SQLException e1) {
//			e1.printStackTrace();
//		}
//		if (loggedUserIsDocumentOwner && docId != 0) {
//			DocumentProxy doc = null;
//			try {
//				// Get document content
//				doc = adama.getAgreementRepository().getAgreementById(docId);
//				File f = toTempFile(doc.getContent().getBytes());
//				String path = f.getAbsolutePath();
//				// Execute operation to get views of this document
//				ADA ada = new ADA();
//				AbstractDocument absDoc = ada.loadDocument(path);				
//				DecomposeIntoViewsOperation op = (DecomposeIntoViewsOperation) ada.createOperation(ADA.VIEWS);
//				op.addDocument(absDoc);
//				ada.analyze(op);
//				// Get ServiceScope and Document for every view
//				Map<ServiceScope, AbstractDocument> views = op.getScopes2Views();
//				for (Entry<ServiceScope, AbstractDocument> view : views.entrySet()) {
//					String serviceScope = view.getKey().getContent();
//					AbstractAgreementDocument auxDoc = (AbstractAgreementDocument) view.getValue();
//					// Get name for every variable in this document
//					// Collection<DocumentVariable> variables =
//					// auxDoc.getVariables();
//					Collection<String> auxVariables = new LinkedList<String>();
//					Collection<Term> terms = auxDoc.getAllTerms();
//					ServiceProperties props = null;
//					for (Term t : terms) {
//						if (t instanceof ServiceProperties) {
//							props = (ServiceProperties) t;
//						}
//					}
//					Set<Variable> vars = props.getVariableSet();
//					for (Variable v : vars) {
//						auxVariables.add(v.getName());
//					}
//					// Add to monitorisable properties map
//					monProps.put(serviceScope, auxVariables);
//				}
//				deleteTempFiles(f);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//		// tenemos que utilizar la operacion de analisis VIEWS
//		return monProps;
//	}

	public byte[] documentId2String(int docId) throws SQLException {
		DocumentProxy doc = adama.getAgreementRepository().getAgreementById(docId);
		return doc.getContent().getBytes();
	}

	private File toTempFile(byte[] in) throws IOException {
		File f = File.createTempFile("tmp", ".wsag");
		FileOutputStream os = new FileOutputStream(f);
		os.write(in);
		os.flush();
		os.close();
		return f;
	}

//	private void deleteTempFiles(File... files) {
//		for (int i = 0; i < files.length; i++) {
//			files[i].delete();
//		}
//	}
}
