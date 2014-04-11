package es.us.isa.ideas.adaintegration.adaadhoc.iagreeservercomponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;

import org.antlr.runtime.ANTLRInputStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.TokenStream;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.service.ADAServiceImpl;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.service.ADAServiceV2;
import es.us.isa.ideas.adaintegration.adaadhoc.iagreeparser.SampleLexer;
import es.us.isa.ideas.adaintegration.adaadhoc.iagreeparser.SampleParser;

public class CarlosTesterNew {
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//ADATestingFacade ada = new ADATestingFacade();
		ADAServiceV2 ada = new ADAServiceImpl();
		
		/*ADAServiceV2 ada;
		String wsag = "";
		String metrics = "";
		String metricsName = "";
		
		ada = new ADAServiceImpl();
		wsag = "";
		metrics = "";
		metricsName = "";*/
		
		
		//File document = new File("samples/Prueba.wsag");
		
		
		String wsag = "";
		String template = "";
		String offer = "";
		String metrics = "";
		String metricsName = "";
		
		byte[] wsagBytesTemplate = null;
		byte[] wsagBytesOffer = null;
		
		
		
		File carpeta = new File("samples");
		String[] lista = carpeta.list();
		
		boolean compliance = false;
		
		for (int i = 0; i < lista.length; i++) {
			try {
				if (lista[i].equalsIgnoreCase("Template for Compliance Amazon.wsag")) {
					
					FileInputStream fis;
					
						fis = new FileInputStream(carpeta.getName()+"/"+lista[i]);
						CharStream charStream = new ANTLRInputStream((InputStream)fis);
						SampleLexer lexer = new SampleLexer(charStream);
						TokenStream tokenStream = new CommonTokenStream(lexer);
						SampleParser parser = new SampleParser(tokenStream);
					
						template = parser.entry();
						//Upload metrics if necesary
						if(/*requiredMetrics.contains(opID)*/true) {
							//Get Metrics
							metrics = parser.getMetrics();
							metricsName = parser.getMetricsName();
							uploadMetrics(ada, metricsName, metrics);
						}
								
						wsagBytesTemplate = template.getBytes("UTF-8");
						
						
				}	else if (lista[i].equalsIgnoreCase("Compliant Offer Amazon.wsag")) {
						FileInputStream fis;
						
						fis = new FileInputStream(carpeta.getName()+"/"+lista[i]);
						CharStream charStream = new ANTLRInputStream((InputStream)fis);
						SampleLexer lexer = new SampleLexer(charStream);
						TokenStream tokenStream = new CommonTokenStream(lexer);
						SampleParser parser = new SampleParser(tokenStream);
		
						offer = parser.entry();
						//Upload metrics if necesary
						if(true) {
							//Get Metrics
							metrics = parser.getMetrics();
							metricsName = parser.getMetricsName();
							uploadMetrics(ada, metricsName, metrics);
						}
						

			
						wsagBytesOffer = offer.getBytes("UTF-8");
					}
								
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RecognitionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
						
			}
		
			
			/*
			if (ada.isCompliant(wsagBytesTemplate, wsagBytesOffer)){
				System.out.println("OK, Plantilla y oferta son compliant");
				if (ada.isLessRestrictiveOffer(wsagBytesTemplate, wsagBytesOffer)){
					System.out.println("OK, La oferta es menos restrictiva que la plantilla");
					if (ada.isMoreRestrictiveTemplateTermsThanCC(wsagBytesTemplate)){
						System.out.println("OK, Los t�rminos de la plantilla son m�s restrictivos que las CCs de la plantilla");
						compliance = true;
					}
				}
			}
			*/
		if (ada.isCompliant(wsagBytesTemplate, wsagBytesOffer)){
			System.out.println("OK, Plantilla y oferta son compliant");
		} else System.out.println("NO, Plantilla y oferta NO son compliant");
		if (ada.isLessRestrictiveOffer(wsagBytesTemplate, wsagBytesOffer)){
			System.out.println("OK, La oferta es menos o igual de restrictiva que la plantilla");
		} else System.out.println("NO, La oferta es M�S restrictiva que la plantilla");
		if (ada.isMoreRestrictiveTemplateTermsThanCC(wsagBytesTemplate)){
			System.out.println("OK, Los t�rminos de la plantilla son m�s o igual de restrictivos que las CCs de la plantilla");
		} else System.out.println("NO, Los t�rminos de la plantilla son MENOS restrictivos que las CCs de la plantilla");
				
			
			
			
			
			
			//System.out.println("Are the documents strong compliant?: " + compliance);
		}
		
					
		
	
	
	private static void uploadMetrics(ADAServiceV2 ada, String mName, String m) throws RemoteException {
		ada.addMetricFile(m.getBytes(), (mName+".xml").getBytes());
	}
	
	/*
	private static String inconsitencyExplaining(ADAServiceV2 ada, String wsag, Map<AgreementElement,Collection<AgreementElement>> incon) throws RemoteException {
		
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
	*/
}
