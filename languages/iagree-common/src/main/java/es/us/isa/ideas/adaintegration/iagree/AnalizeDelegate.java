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
					appResponse.setMessage("The document is consistent.");
					appResponse.setStatus(Status.OK);
				} else {
					String inconsistencies = service.inconsitencyExplaining(document);
					appResponse.setMessage(inconsistencies);
					appResponse.setStatus(Status.OK_PROBLEMS);
				}
			} catch (Exception e) {
				appResponse.setStatus(Status.ERROR);
				appResponse.setMessage("There has been an error: "
						+ e.getMessage());
			}
		} else if (id.equals("getNumberOfAlternatives")) {
			try {
				Integer numAlt = service.getNumberOfAlternatives(document);
				if (numAlt == 0) {
					appResponse.setMessage("There are no alternatives for the document");
				} else {
					if (numAlt == 1) {
						appResponse.setMessage("There is " + numAlt + " alternative to the document");
					} else {
						appResponse.setMessage("There are " + numAlt + " alternatives to the document");
					}
				}
				appResponse.setStatus(Status.OK);
			} catch (Exception e) {
				appResponse.setStatus(Status.ERROR);
				appResponse.setMessage("There has been an error: " + e.getMessage());
			}
		} else if (id.equals("checkCompliance") && isOffer) {
			
			try {
				
				service.getService().addMetricFile(((String) wsagAggregationForComparation.get("metrics")).getBytes(), ((String) wsagAggregationForComparation.get("metricUri")).getBytes());
				String otherDoc = (String) wsagAggregationForComparation.get("data");
				
				Boolean compliance = service.isCompliant(otherDoc, document);
				if (compliance) {
					appResponse.setStatus(Status.OK);
					appResponse.setMessage("The provided offer is compliant with the provided template");
				} else {
					String explanation = service.nonComplianceExplaining(
							otherDoc, document);
					appResponse.setStatus(Status.OK_PROBLEMS);
					appResponse.setMessage(explanation);
				}
			} catch (Exception e) {
				appResponse.setStatus(Status.ERROR);
				appResponse.setMessage("There has been an error: " + e.getMessage());
			}
		} else {
			appResponse.setStatus(Status.ERROR);
			appResponse.setMessage("No such opperation");
		}

		return appResponse;
	}

}
