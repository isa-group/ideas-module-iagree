package es.us.isa.ideas.adaintegration.iagree;

import java.util.Map;

import es.us.isa.ideas.common.AppResponse;
import es.us.isa.ideas.common.AppResponse.Status;



public class AnalizeDelegate { 
	
	public static AppResponse analize(String id, Map<String, Object> wsagAggregation,
			Map<String, Object> wsagAggregationForComparation, boolean isOffer){

		
		// instanciados
		AdaFacade service = new AdaFacade();
		AppResponse appResponse = new AppResponse();
		
		// Añadir métricas primero:
		service.getService().addMetricFile(((String) wsagAggregation.get("metrics")).getBytes(), ((String) wsagAggregation.get("metricUri")).getBytes());
		String document = (String) wsagAggregation.get("data");
		
		// seleccion de la operacion
		if (id.equals("checkConsistency")) {
			try {
				Boolean check = service.consistency(document);
				if (check) {
					appResponse.setMessage("<pre>The document is consistent.</pre>");
					appResponse.setStatus(Status.OK);
				} else {
					String inconsistencies = service.inconsitencyExplaining(document);
					appResponse.setMessage(inconsistencies);
					appResponse.setStatus(Status.OK_PROBLEMS);
				}
			} catch (Exception e) {
				appResponse.setStatus(Status.ERROR);
				appResponse.setMessage("<pre>There has been an error: "
						+ e.getMessage() + "</pre>");
			}
		} else if (id.equals("getNumberOfAlternatives")) {
			try {
				Integer numAlt = service.getNumberOfAlternatives(document);
				if (numAlt == 0) {
					appResponse.setMessage("<pre>There are no alternatives for the document</pre>");
				} else {
					if (numAlt == 1) {
						appResponse.setMessage("<pre>There is " + numAlt + " alternative to the document</pre>");
					} else {
						appResponse.setMessage("<pre>There are " + numAlt + " alternatives to the document</pre>");
					}
				}
				appResponse.setStatus(Status.OK);
			} catch (Exception e) {
				appResponse.setStatus(Status.ERROR);
				appResponse.setMessage("<pre>There has been an error: " + e.getMessage() + "</pre>");
			}
		} else if (id.equals("checkCompliance") && isOffer) {
			
			try {
				
				service.getService().addMetricFile(((String) wsagAggregationForComparation.get("metrics")).getBytes(), ((String) wsagAggregationForComparation.get("metricUri")).getBytes());
				String otherDoc = (String) wsagAggregationForComparation.get("data");
				
				Boolean compliance = false;
				
				Boolean isCompliant = service.isCompliant(otherDoc, document);
				Boolean isLessRestrictiveOffer = service.isLessRestrictiveOffer(otherDoc, document);
				Boolean isMoreRestrictiveTemplateTermsThanCC = service.isMoreRestrictiveTemplateTermsThanCC(otherDoc);
							
				
				if (isCompliant){
					//System.out.println("OK, Plantilla y oferta son compliant");
					if (isLessRestrictiveOffer){
						//System.out.println("OK, La oferta es menos o igual de restrictiva que la plantilla");
						if (isMoreRestrictiveTemplateTermsThanCC){
							//System.out.println("OK, Los términos de la plantilla son más o igual de restrictivos que las CCs de la plantilla");
							compliance = true;
						}
					}	
				}
				
				if (compliance) {
					appResponse.setStatus(Status.OK);
					appResponse.setMessage("<pre>The provided offer is compliant with the provided template</pre>");
				} else {
					String explanation = service.nonComplianceExplaining(
							otherDoc, document);
					appResponse.setStatus(Status.OK_PROBLEMS);
					//appResponse.setMessage("<pre>" + explanation + "</pre>");
					appResponse.setMessage(explanation);
				}
			} catch (Exception e) {
				appResponse.setStatus(Status.ERROR);
				appResponse.setMessage("<pre>There has been an error: " + e.getMessage() +"</pre>");
			}
		} else {
			appResponse.setStatus(Status.ERROR);
			appResponse.setMessage("<pre>No such opperation</pre>");
		}

		return appResponse;
	}

}