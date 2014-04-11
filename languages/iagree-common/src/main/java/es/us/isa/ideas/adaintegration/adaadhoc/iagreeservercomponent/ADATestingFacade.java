package es.us.isa.ideas.adaintegration.adaadhoc.iagreeservercomponent;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//import es.us.isa.ada.choco.questions.ChocoExplainNoComplianceOp;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.Analyzer;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.Operation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.ChocoAnalyzer;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.questions.ChocoAlternativeDocumentsOp;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.questions.ChocoComplianceOp;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.questions.ChocoConsistencyOp;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.questions.ChocoDeadTermsOp;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.questions.ChocoExplainDeadTermsOp;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.questions.ChocoExplainLudicrousTermsOp;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.questions.ChocoExplainNoConsistencyOp;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.choco.questions.ChocoLudicrousTermsOp;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AbstractDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.parsers.ADASDTParser;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.parsers.DefaultWSAgParser;

public class ADATestingFacade {

	
	private DefaultWSAgParser parser;
	
	private Map<String,Class<? extends Operation>> mapOps;
	
	private Analyzer analyzer;
	
	
	public ADATestingFacade(){
		parser = new DefaultWSAgParser();
		analyzer = new ChocoAnalyzer();
		loadOps();
	}
	
	
	private void loadOps() {
		mapOps = new HashMap<String, Class<? extends Operation>>();
		mapOps.put("consistency", ChocoConsistencyOp.class);
		mapOps.put("compliance", ChocoComplianceOp.class);
		mapOps.put("alternativeDocuments",ChocoAlternativeDocumentsOp.class);
		mapOps.put("explainInconsistencies", ChocoExplainNoConsistencyOp.class);
		//mapOps.put("explainNonCompliance",ChocoExplainNoComplianceOp.class);
//		mapOps.put("explainWarnings", ChocoExplainWarningsOp.class);
		mapOps.put("ludicrous", ChocoLudicrousTermsOp.class);
		mapOps.put("dead", ChocoDeadTermsOp.class);
		mapOps.put("explainLudicrous", ChocoExplainLudicrousTermsOp.class);
		mapOps.put("explainDead", ChocoExplainDeadTermsOp.class);
	}


	public AbstractDocument loadDocument(String path){
		return parser.parseFile(path);
	}
	
	public Operation createOperation(String id){
		Class<? extends Operation> clazz = mapOps.get(id);
		Operation res = null;
		if (clazz != null){
			try {
				res = clazz.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public void analyze(Operation op){
		analyzer.analyze(op);
	}
	
	public Collection<String> getOperationIds(){
		return mapOps.keySet();
	}
	
}
