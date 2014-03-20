package es.us.isa.iagreeservercomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.NoViableAltException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;
import org.w3c.dom.Document;

import es.us.isa.ada.document.AgreementElement;
import es.us.isa.ada.errors.AgreementError;
import es.us.isa.ada.errors.Explanation;
import es.us.isa.ada.exceptions.BadSyntaxException;
import es.us.isa.ada.exceptions.PeriodDefinitionException;
import es.us.isa.ada.exceptions.PeriodDefinitionWarningException;
import es.us.isa.ada.service.ADAServiceImpl;
import es.us.isa.ada.service.ADAServiceV2;

import es.us.isa.ada.service.ADAServiceV2PortType;
import es.us.isa.ada.service.AgreementElement2ArrayOfAgreementElementMapEntry;
import es.us.isa.ada.service.AgreementError2ExplanationMapEntry;
import es.us.isa.ada.service.Term2ArrayOfAgreementElementMapEntry;
import es.us.isa.ada.wsag10.Term;
import es.us.isa.iagreeparser.SampleLexer;
import es.us.isa.iagreeparser.SampleParser;

/**
 * Servlet implementation class iAgreeProcessor
 */
//@WebServlet("/iAgreeProcessor")
public class iAgreeProcessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int[] requiredMetrics = {0,1,2};
	private ADAServiceV2 ada;
	private String wsag = "";
	private String metrics = "";
	private String metricsName = "";
	private String template;
	private String metricURI;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public iAgreeProcessor() {
        super();
      //Create service port
		//try {
        ada = new ADAServiceImpl();
			//ada = new ADAServiceV2Locator().getADAServiceV2Port();
		//} catch (ServiceException e) {
		//	e.printStackTrace();
		//}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		FileOutputStream fos = new FileOutputStream("c:/MyMylog.txt");
		new PrintStream(fos).println(request.getServletPath());
		new PrintStream(fos).println(request.getServletContext().getRealPath(request.getServletPath()));
		fos.close();
		*/
		/*
		System.out.println(request.getServletPath());
		System.out.println(request.getServletContext().getRealPath(request.getServletPath()));
		System.out.println("File write complete! Saved to: "+new File("data.txt").getAbsolutePath());
		System.out.println("File write complete! Saved to: "+new File("c:/data.txt").getAbsolutePath());
		*/
		//response.getOutputStream().print(request.getServletContext().getRealPath(request.getServletPath()));
		
		wsag = "";
		metrics = "";
		metricsName = "";
		
		
		//Get operation ID
		int opID = Integer.parseInt(request.getParameter("operationID"));
		
		if(opID == -101) 			//AYA?
			response.getOutputStream().print("true");
		else
			try {
		
				//Get content
				ServletInputStream content = request.getInputStream();
				
				
				
				//Parsing
				CharStream charStream = new ANTLRInputStream(content);
				
				SampleLexer lexer = new SampleLexer(charStream);
				TokenStream tokenStream = new CommonTokenStream(lexer);
				SampleParser parser = new SampleParser(tokenStream);
				
				wsag = parser.entry();
				//Upload metrics if necesary
				//if(requiredMetrics.contains(opID)true) {
				if(true) {
					//Get Metrics
					metrics = parser.getMetrics();
					metricsName = parser.getMetricsName();
					uploadMetrics(ada, metricsName, metrics);
					
				}
	
				
				byte[] wsagBytes = wsag.getBytes("UTF-8");
				
				
				response.setContentType("text/xml");
				
				if (opID == 0) {		//Consistencia
					
					Boolean isConsistent = false;
					
					if (ada.checkDocumentConsistency(wsagBytes)){	
						if (ada.getDeadTerms(wsagBytes).size()==0){
							if (ada.getLudicrousTerms(wsagBytes).size()==0){
								isConsistent = true;
							}
						}
					}
					
//					if(isConsistent)
//						response.getOutputStream().print("The document is consistent.");
//					else
//						response.getOutputStream().print("The document is NOT consistent.");
					response.getOutputStream().print(isConsistent);
	//				
					
				} else if (opID == 1) {			//Num. variantes
					
					int num = ada.getNumberOfAlternatives(wsagBytes);
					
//					String res = "";
//					if(num == 0)
//						res = "There are no alternatives for this document.";
//					else if(num == 1)
//						res = "There is one alternative document.";
//					else if(num > 1)
//						res = "There are "+num+" alternatives.";
		
					response.getOutputStream().print(num);
					
				} else if (opID == 2) {			//Inconsistency explaining
					int num = ada.getNumberOfAlternatives(wsagBytes);
					String pre = "";
					if(num>1)
						pre = "As there are "+num+" agreement variants for this document, the semantic errors may appear up to "+num+" times.";
					Map<AgreementElement,Collection<AgreementElement>> incon = ada.explainInconsistencies(wsagBytes);
					//AgreementElement2ArrayOfAgreementElementMapEntry[] incon = ada.explainInconsistencies(wsagBytes);
					response.getOutputStream().print( pre+inconsitencyExplaining(ada, wsag, incon) );
					
				}else if (opID == 3) {			//Compliance
					
					wsag = wsag.replaceAll(parser.getMetricsName(), metricURI);
					
					boolean isCompliant = false;
							
					if (ada.isCompliant(template.getBytes(), wsag.getBytes())){
						//System.out.println("OK, Plantilla y oferta son compliant");
						if (ada.isLessRestrictiveOffer(template.getBytes(), wsag.getBytes())){
							//System.out.println("OK, La oferta es menos o igual de restrictiva que la plantilla");
							if (ada.isMoreRestrictiveTemplateTermsThanCC(template.getBytes())){
								//System.out.println("OK, Los términos de la plantilla son más o igual de restrictivos que las CCs de la plantilla");
								isCompliant = true;
							}
						}	
					}
					
					//boolean isCompliant = ada.isCompliant(template.getBytes(), wsag.getBytes());
					
					
					
//					if(isCompliant)
//						response.getOutputStream().print("The offer is compliant to the template.");
//					else
//						response.getOutputStream().print("The offer is NOT compliant to the template.");
					
					response.getOutputStream().print(isCompliant);
					
	
				}else if (opID == 4) {			//Compliance explaining
					
					wsag = wsag.replaceAll(parser.getMetricsName(), metricURI);
					
					response.getOutputStream().print( nonComplianceExplaining(ada, template, wsag) );
	
					
				}else if (opID == -2) {			//Coger mÃ©tricas
					
					response.getOutputStream().print(metricsName+":\n"+metrics);
	
				}else if (opID == -3 || opID == -4) {			//Cargar plantilla para comparaciÃ³n
					template = wsag;
					metricURI = parser.getMetricsName();
					response.getOutputStream().print(metricURI);
	
				} else {			//Simplemente devolver WSAG
					
					response.getOutputStream().print(wsag);
				}
	
				
			} catch (BadSyntaxException bs) {
				
				String s = "Syntactical errors detected";
				if(bs.getMessage()!=null)
					s+=":\n"+bs.getMessage();
				else
					s+=". Please review your document.";
				
				response.getOutputStream().print(s);
				
			}  catch (NoViableAltException e) {
				
				wsag = "Error processing (no viable alternative) \""+ e.token.getText() + "\" at line "+ e.line + " column "+e.charPositionInLine +".";
				response.getOutputStream().print(wsag);
					
			} catch(RecognitionException e) {
				
				wsag = "Error processing (recognition exception) \""+ e.token.getText() + "\" at line "+ e.line + " column "+e.charPositionInLine +".";
				response.getOutputStream().print(wsag);
					
			} catch (Exception e) {
				wsag = "Error: \n"+e.getMessage();
				
				response.getOutputStream().print(wsag+"\n"+e.getClass().getName());
			}
		
	
		
	}
	

	private void uploadMetrics(ADAServiceV2 ada, String metricsName, String metrics) throws RemoteException {
		ada.addMetricFile(metrics.getBytes(), (metricsName+".xml").getBytes());
	}
	
	
	private String inconsitencyExplaining(ADAServiceV2 ada, String wsag, Map<AgreementElement,Collection<AgreementElement>> incon) throws RemoteException {
		
		Object[] result = new Object[3];
		//1. isConsistent
		//2. hasWarnings
		//3. inconsistencias si las hay, warnings si no hay inconsistencias
		
		//usar estas mismas listas para ir guardando
		//los elementos que van apareciendo, y no colorearlos
		//de nuevo
		List<String> warningsNames = new ArrayList<String>();
		List<String> errorsNames = new ArrayList<String>();
		Integer conflictsShowedInConsole = 1;
		Integer deadTermsShowedInConsole = 1;
		Integer ludicrousTermsShowedInConsole = 1;
		
		String returnMsg = "";
		
		Collection<Collection<String>> explaining = new LinkedList<Collection<String>>();
		try{
			boolean isConsistent;
			boolean hasWarnings = false;
			
			//Checking Inconsistent Terms
			isConsistent = ada.checkDocumentConsistency(wsag.getBytes());
			
			if(isConsistent){
				returnMsg += "<span class=\"result-correct\">The document doesn't contain Inconsistent Terms.</span>";
				
				//Checking Dead Terms
				Collection<Term> deadTerms = ada.getDeadTerms(wsag.getBytes());

				if(deadTerms.size() > 0){
					returnMsg += "<span class=\"result-error\">The document contains the following Dead Terms:</span>";
					
					//Explaining Dead Terms
					Map<Term,Collection<AgreementElement>> deadTermsExplanation = ada.explainDeadTerms(wsag.getBytes(), deadTerms);
					//Term2ArrayOfAgreementElementMapEntry[] deadTermsExplanation = ada.explainDeadTerms(wsag.getBytes(), Arrays.asList(deadTerms));
					
					//for(Term2ArrayOfAgreementElementMapEntry e: deadTermsExplanation){
					for(Map.Entry<Term,Collection<AgreementElement>> e: deadTermsExplanation.entrySet()){
							
						Collection<String> set = new LinkedList<String>();
						Collection<AgreementElement> termValues = e.getValue();
						String warn = e.getKey().getName();
						
						returnMsg += "<span class=\"result-error\">Dead term "+deadTermsShowedInConsole+": "+warn+"</span>";
						
						deadTermsShowedInConsole++;
						
						if(!warningsNames.contains(warn)){
							//metemos el warning
							set.add(warn);
							warningsNames.add(warn);
						}
						
						for (AgreementElement cause:termValues){
							//causas del warning
							returnMsg += "<span class=\"result-cause\">Cause: "+cause.getName()+"</span>";
							if (!warningsNames.contains(cause)){
								//y metemos sus causas
								set.add(cause.getName());
								warningsNames.add(cause.getName());
							}
						}
						if (!set.isEmpty()){
							explaining.add(set);
						}
					}
				}else{
					returnMsg += "<span class=\"result-correct\">The document doesn't contain Dead Terms.</span>";
				}
				
				//Checking Ludicrous Terms
				Collection<Term> ludicrousTerms = ada.getLudicrousTerms(wsag.getBytes());
				
				if(ludicrousTerms.size() > 0){
					returnMsg += "<span class=\"result-error\">The document contains the following Conditionally Inconsistent Terms:</span>";
					
					//Explaining Ludicrous Terms
					Map<Term,Collection<AgreementElement>> ludicrousTermsExplanation = ada.explainLudicrousTerms(wsag.getBytes(), ludicrousTerms);
					//Term2ArrayOfAgreementElementMapEntry[] ludicrousTermsExplanation = ada.explainLudicrousTerms(wsag.getBytes(), ludicrousTerms);
					//for(Term2ArrayOfAgreementElementMapEntry e: ludicrousTermsExplanation){
					for(Map.Entry<Term,Collection<AgreementElement>> e: ludicrousTermsExplanation.entrySet()){
						Collection<String> set = new LinkedList<String>();
						Collection<AgreementElement> termValues = e.getValue();
						
						String warn = e.getKey().getName();
						
						returnMsg += "<span class=\"result-error\">Conditionally Inconsistent Term "+ludicrousTermsShowedInConsole+": "+warn+"</span>";
						
						ludicrousTermsShowedInConsole++;
						if(!warningsNames.contains(warn)){
							//metemos el warning
							set.add(warn);
							warningsNames.add(warn);
						}
						
						for (AgreementElement cause:termValues){
							returnMsg += "<span class=\"result-cause\">Cause: "+cause.getName()+"</span>";
							//causas del warning
							if (!warningsNames.contains(cause)){
								//y metemos sus causas
								set.add(cause.getName());
								warningsNames.add(cause.getName());
							}
						}
						
						if (!set.isEmpty()){
							explaining.add(set);
						}
					}
					
				}else{
					returnMsg += "<span class=\"result-correct\">The document doesn't contain Conditionally Inconsistent Terms.</span>";
				}
				hasWarnings = !(deadTerms.size() == 0 && ludicrousTerms.size() == 0);
				
			}else{
				returnMsg += "<span class=\"result-error\">The document contains the following Inconsistent Terms:</span>";
				
				//Explaining inconsistent terms
				Map<AgreementElement,Collection<AgreementElement>> errorsExplanation = ada.explainInconsistencies(wsag.getBytes());
				//AgreementElement2ArrayOfAgreementElementMapEntry[] errorsExplanation = ada.explainInconsistencies(wsag.getBytes());
				//for(AgreementElement2ArrayOfAgreementElementMapEntry e: errorsExplanation){
				for(Map.Entry<AgreementElement,Collection<AgreementElement>> e: errorsExplanation.entrySet()){

					Collection<String> set = new LinkedList<String>();
					
					String keyName = e.getKey().getName();
					returnMsg += "<span class=\"result-error\">Conflict "+conflictsShowedInConsole+": "+keyName+"</span>";
					conflictsShowedInConsole++;
					if (!errorsNames.contains(keyName)){
						set.add(keyName);
						errorsNames.add(keyName);
					}
					
					Collection<AgreementElement> termValues = e.getValue();
					for(AgreementElement ae: termValues){
						returnMsg += "<span class=\"result-cause\">Cause: "+ae.getName()+"</span>";
						if(!errorsNames.contains(ae.getName())){
							set.add(ae.getName());
							errorsNames.add(ae.getName());
						}
					}
					
					if (!set.isEmpty()){
						explaining.add(set);
					}
				}
//				
			}
			result[0] = isConsistent;
			result[1] = hasWarnings;
			result[2] = explaining;
//			result[2] = errorsNames;
//			result[3] = warningsNames;
		}catch(BadSyntaxException e){
			returnMsg += "There was an error: It may be due to a syntax error, please check the document syntax.";
			result = null;
		}
		
		return returnMsg;
	}
	
	
	private String nonComplianceExplaining(ADAServiceV2 ada, String template, String offer) throws PeriodDefinitionException, PeriodDefinitionWarningException, RemoteException {
		//el error k de offerErrors tiene como causas el elemento k de tempErrors
		Object[] result = new Object[5];
		List<String> templateErrorsNames = new ArrayList<String>();
		List<String> offerErrorsNames = new ArrayList<String>();
		String returnMsg = "";
		
		Collection<Collection<String>> tempErrors = new LinkedList<Collection<String>>();
		Collection<Collection<String>> offerErrors = new LinkedList<Collection<String>>();
		try{
			boolean isTempConsistent;
			boolean isOfferConsistent;
			boolean isCompliant = false;
			boolean isLessRestrictiveOffer = false;
			boolean isMoreRestrictiveTemplateTerms = false;
			
			
			//Checking Template Inconsistent Terms
			
			isTempConsistent = ada.checkDocumentConsistency(template.getBytes());
			if(isTempConsistent){
				returnMsg += "<span class=\"result-correct\">The <b>template</b> is valid.</span>";
			}else{
				returnMsg += "<span class=\"result-error\">The <b>template</b> is NOT valid because it contains semantic errors.</span>";
			}
			
			
			isOfferConsistent = ada.checkDocumentConsistency(offer.getBytes());
			if(isOfferConsistent){
				returnMsg += "<span class=\"result-correct\">The <b>offer</b> is valid.</span>";
			}else{
				returnMsg += "<span class=\"result-error\">The <b>offer</b> has NOT valid because contains semantic errors.</span>";
			}
			if(isTempConsistent && isOfferConsistent){
				
				isCompliant = ada.isCompliant(template.getBytes(), offer.getBytes());
				isLessRestrictiveOffer = ada.isLessRestrictiveOffer(template.getBytes(), offer.getBytes());
				isMoreRestrictiveTemplateTerms = ada.isMoreRestrictiveTemplateTermsThanCC(template.getBytes());
				
				if(!isCompliant){
					returnMsg += "<span class=\"result-error\">Conflicts between agreement offer terms and the template:</span>";
					
					//Explaining Non-Compliance conflicts
					Map<AgreementError,Explanation> errorsArrayMapEntry = ada.explainNonCompliance(template.getBytes(), offer.getBytes());
			        //AgreementError2ExplanationMapEntry[] errorsArrayMapEntry = ada.explainNonCompliance(template.getBytes(), offer.getBytes());
			        //for(AgreementError2ExplanationMapEntry e: errorsArrayMapEntry){
					for(Map.Entry<AgreementError,Explanation> e: errorsArrayMapEntry.entrySet()){
			        	Collection<AgreementElement> agreementErrorElements = e.getKey().getElements();
			        	Collection<String> offerElems = new LinkedList<String>();
			        	for(AgreementElement agErrorElem: agreementErrorElements){
			        		String offerElemName = agErrorElem.getName();
			        		
			        		returnMsg += "<span class=\"result-error\">"+"Offer conflict: "+offerElemName+".</span>";
			        		
			        		if (!offerErrorsNames.contains(offerElemName)){
				        		offerElems.add(offerElemName);
				        		offerErrorsNames.add(offerElemName);
				        	}
			        	}
			        	offerErrors.add(offerElems);
			        	
			        	Collection<AgreementElement> explanationElements = e.getValue().getElements();
			        	Collection<String> tempElems = new LinkedList<String>();
			        	for(AgreementElement explanationElem: explanationElements){
			        		String templateElemName = explanationElem.getName();
			        		
			        		returnMsg += "<span class=\"result-error\">"+"Template cause: "+templateElemName+".</span>";
			        		
			        		if (!templateErrorsNames.contains(templateElemName)){
			        			tempElems.add(templateElemName);
			        			templateErrorsNames.add(templateElemName);
			        		}
			        	}
			        	tempErrors.add(tempElems);
			        }
				}else{
					returnMsg += "<span class=\"result-correct\">The agreement offer terms are compliant with the template terms and creation constraints.</span>";
				}
				
				if((isCompliant)&&(!isLessRestrictiveOffer)){
					
					returnMsg += "<span class=\"result-error\">Offer terms that are More Restrictive than the template terms:</span>";
					
					//Explaining Non-Compliance for More Restrictive offer conflicts
					Map<AgreementError,Explanation> errorsArrayMapEntry = ada.explainMoreRestrictiveOffer(template.getBytes(), offer.getBytes());
					
			        //AgreementError2ExplanationMapEntry[] errorsArrayMapEntry = ada.explainNonCompliance(template.getBytes(), offer.getBytes());
			        //for(AgreementError2ExplanationMapEntry e: errorsArrayMapEntry){
					for(Map.Entry<AgreementError,Explanation> e: errorsArrayMapEntry.entrySet()){
			        	Collection<AgreementElement> agreementErrorElements = e.getKey().getElements();
			        	Collection<String> offerElems = new LinkedList<String>();
			        	for(AgreementElement agErrorElem: agreementErrorElements){
			        		String offerElemName = agErrorElem.getName();
			        		
			        		returnMsg += "<span class=\"result-error\">"+"Offer term: "+offerElemName+".</span>";
			        		
			        		if (!offerErrorsNames.contains(offerElemName)){
				        		offerElems.add(offerElemName);
				        		offerErrorsNames.add(offerElemName);
				        	}
			        	}
			        	offerErrors.add(offerElems);
			        	
			        	Collection<AgreementElement> explanationElements = e.getValue().getElements();
			        	Collection<String> tempElems = new LinkedList<String>();
			        	for(AgreementElement explanationElem: explanationElements){
			        		String templateElemName = explanationElem.getName();
			        		
			        		returnMsg += "<span class=\"result-error\">"+"Template element: "+templateElemName+".</span>";
			        		
			        		if (!templateErrorsNames.contains(templateElemName)){
			        			tempElems.add(templateElemName);
			        			templateErrorsNames.add(templateElemName);
			        		}
			        	}
			        	tempErrors.add(tempElems);
					}
				}else{
					if(!isCompliant){
						returnMsg += "<span class=\"result-correct\">As the documents are not compliant, the explaining for more restrictive offer is not performed.</span>";
					}else returnMsg += "<span class=\"result-correct\">The agreement offer is Less Restrictive, or equal, than the template.</span>";
				}
				if(!isMoreRestrictiveTemplateTerms){
					//System.out.println("aún por hacer la explicación de que los GTs de la plantilla son menos restrictivos que las CCs");
					
							
					returnMsg += "<span class=\"result-error\">Template terms are less restrictive than the template creation constraints:</span>";
					
					//Explaining Non-Compliance for Less Restrictive template terms conflicts
					Map<AgreementError,Explanation> errorsArrayMapEntry = ada.explainLessRestrictiveTemplateTerms(template.getBytes());
					
					
					// VOY POR AQUI, UNA VEZ HAYA IMPLEMENTADO EL ada.explainLessRestrictiveTemplateTerms(template.getBytes())
					
			        //AgreementError2ExplanationMapEntry[] errorsArrayMapEntry = ada.explainNonCompliance(template.getBytes(), offer.getBytes());
			        //for(AgreementError2ExplanationMapEntry e: errorsArrayMapEntry){
					for(Map.Entry<AgreementError,Explanation> e: errorsArrayMapEntry.entrySet()){
			        	Collection<AgreementElement> guaranteeTermErrorElements = e.getKey().getElements(); //agreementErrorElements
			        	Collection<String> gtElems = new LinkedList<String>();  //agErrorElem
			        	for(AgreementElement gtErrorElem: guaranteeTermErrorElements){
			        		String gtElemName = gtErrorElem.getName();
			        		
			        		returnMsg += "<span class=\"result-error\">"+"Conflicting Template Term: "+gtElemName+".</span>";
			        		
			        		if (!offerErrorsNames.contains(gtElemName)){
			        			gtElems.add(gtElemName);
				        		offerErrorsNames.add(gtElemName);
				        	}

			        	}
			        	offerErrors.add(gtElems);
			        	
			        	Collection<AgreementElement> explanationElements = e.getValue().getElements();
			        	Collection<String> ccElems = new LinkedList<String>();
			        	for(AgreementElement ccElem: explanationElements){
			        		String ccElemName = ccElem.getName();
			        		
			        		returnMsg += "<span class=\"result-error\">"+"Template Creation Constraint Cause: "+ccElemName+".</span>";
			        		
			        		if (!templateErrorsNames.contains(ccElemName)){
			        			ccElems.add(ccElemName);
			        			templateErrorsNames.add(ccElemName);
			        		}
			        	}
			        	tempErrors.add(ccElems);
					}					
					
				}else{
					returnMsg += "<span class=\"result-correct\">The template terms are more restrictive, or equal, than the template creation constraints.</span>";
				}
		
			}
	
			result[0] = isTempConsistent;
			result[1] = isOfferConsistent;
			result[2] = isCompliant;
			result[3] = tempErrors;
			result[4] = offerErrors;
		}catch(BadSyntaxException e){
			returnMsg += "<span class=\"result-error\">There was an error: It may be due to a syntax error, please check the document syntax..</span>";
		}
		
		return returnMsg;
	}
	
	/*
	private String nonComplianceExplaining(ADAServiceV2 ada, String template, String offer) throws PeriodDefinitionException, PeriodDefinitionWarningException, RemoteException {
		//el error k de offerErrors tiene como causas el elemento k de tempErrors
				Object[] result = new Object[5];
				List<String> templateErrorsNames = new ArrayList<String>();
				List<String> offerErrorsNames = new ArrayList<String>();
				String returnMsg = "";
				
				Collection<Collection<String>> tempErrors = new LinkedList<Collection<String>>();
				Collection<Collection<String>> offerErrors = new LinkedList<Collection<String>>();
				try{
					boolean isTempConsistent;
					boolean isOfferConsistent;
					boolean isCompliant = false;
					
					
					//Checking Template Inconsistent Terms
					
					isTempConsistent = ada.checkDocumentConsistency(template.getBytes());
					if(isTempConsistent){
						returnMsg += "<span class=\"result-correct\">The <b>template</b> is valid.</span>";
					}else{
						returnMsg += "<span class=\"result-error\">The <b>template</b> is NOT valid because it contains semantic errors.</span>";
					}
					
					
					isOfferConsistent = ada.checkDocumentConsistency(offer.getBytes());
					if(isOfferConsistent){
						returnMsg += "<span class=\"result-correct\">The <b>offer</b> is valid.</span>";
					}else{
						returnMsg += "<span class=\"result-error\">The <b>offer</b> has NOT valid because contains semantic errors.</span>";
					}
					if(isTempConsistent && isOfferConsistent){
						
						isCompliant = ada.isCompliant(template.getBytes(), offer.getBytes());
						if(!isCompliant){
							returnMsg += "<span class=\"result-error\">Compliance conflicts:</span>";
							
							//Explaining Non-Compliance conflicts
							Map<AgreementError,Explanation> errorsArrayMapEntry = ada.explainNonCompliance(template.getBytes(), offer.getBytes());
					        //AgreementError2ExplanationMapEntry[] errorsArrayMapEntry = ada.explainNonCompliance(template.getBytes(), offer.getBytes());
					        //for(AgreementError2ExplanationMapEntry e: errorsArrayMapEntry){
							for(Map.Entry<AgreementError,Explanation> e: errorsArrayMapEntry.entrySet()){
					        	Collection<AgreementElement> agreementErrorElements = e.getKey().getElements();
					        	Collection<String> offerElems = new LinkedList<String>();
					        	for(AgreementElement agErrorElem: agreementErrorElements){
					        		String offerElemName = agErrorElem.getName();
					        		
					        		returnMsg += "<span class=\"result-error\">"+"Offer conflict: "+offerElemName+".</span>";
					        		
					        		if (!offerErrorsNames.contains(offerElemName)){
						        		offerElems.add(offerElemName);
						        		offerErrorsNames.add(offerElemName);
						        	}
					        	}
					        	offerErrors.add(offerElems);
					        	
					        	Collection<AgreementElement> explanationElements = e.getValue().getElements();
					        	Collection<String> tempElems = new LinkedList<String>();
					        	for(AgreementElement explanationElem: explanationElements){
					        		String templateElemName = explanationElem.getName();
					        		
					        		returnMsg += "<span class=\"result-error\">"+"Template cause: "+templateElemName+".</span>";
					        		
					        		if (!templateErrorsNames.contains(templateElemName)){
					        			tempElems.add(templateElemName);
					        			templateErrorsNames.add(templateElemName);
					        		}
					        	}
					        	tempErrors.add(tempElems);
					        }
						}else{
							returnMsg += "<span class=\"result-correct\">The agreement offer is Compliant with the template.</span>";
						}
					}
					result[0] = isTempConsistent;
					result[1] = isOfferConsistent;
					result[2] = isCompliant;
					result[3] = tempErrors;
					result[4] = offerErrors;
				}catch(BadSyntaxException e){
					returnMsg += "<span class=\"result-error\">There was an error: It may be due to a syntax error, please check the document syntax..</span>";
				}
				
				return returnMsg;
	}
	*/

}
