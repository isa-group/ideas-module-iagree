package es.us.isa.ideas.util;

import java.util.ArrayList;
import java.util.List;

import es.us.isa.ideas.common.AppAnnotations;
import es.us.isa.ideas.common.AppResponse;
import es.us.isa.ideas.common.AppResponse.Status;

public class LanguageDelegate {

	@SuppressWarnings("unchecked")
	public static AppResponse checkLanguage(String format, String content, String fileUri, boolean isOffer) {
		
		AppResponse appResponse = new AppResponse();
		appResponse.setFileUri(fileUri);
		List<AppAnnotations> annotations = new ArrayList<AppAnnotations>();
		
		if (format.equals("iagree")) {
			
			annotations.addAll((List<AppAnnotations>) Convert.getWsagFromIAgree(content, false).get("annotations"));
			
			if (!annotations.isEmpty()) {
				appResponse.setStatus(Status.OK_PROBLEMS);
				appResponse.setAnnotations(annotations.toArray(new AppAnnotations[annotations.size()]));
			} else {
				appResponse.setStatus(Status.OK);
			}
			
		} else
			System.out.println("No language checker is implemented for this format: " + format);
		
		return appResponse;
	}
	
}
