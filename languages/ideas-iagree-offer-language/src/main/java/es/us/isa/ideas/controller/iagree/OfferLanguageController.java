package es.us.isa.ideas.controller.iagree;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.us.isa.ideas.adaintegration.iagree.AnalizeDelegate;
import es.us.isa.ideas.common.AppAnnotations;
import es.us.isa.ideas.common.AppResponse;
import es.us.isa.ideas.common.AppResponse.Status;
import es.us.isa.ideas.module.controller.BaseLanguageController;
import es.us.isa.ideas.util.ConversionDelegate;
import es.us.isa.ideas.util.Convert;
import es.us.isa.ideas.util.LanguageDelegate;

@Controller
@RequestMapping("/language")
public class OfferLanguageController extends BaseLanguageController {
	
	@RequestMapping(value = "/operation/{id}/execute", method = RequestMethod.POST)
	@ResponseBody
	public AppResponse executeOperation(String id, String content, String fileUri, String auxArg0) {
		Map<String, Object> wsagAggregation = Convert.getWsagFromIAgree(content, true);
		// wsagAggregation[0]; // Converted Document
		// wsagAggregation[1]; // Metrics URI
		// wsagAggregation[2]; // Metrics content
		
		List<AppAnnotations> annotations = (List<AppAnnotations>) wsagAggregation.get("annotations");
		AppResponse appResponse = new AppResponse();
		if(annotations.isEmpty()){			
			Map<String, Object> wsagAggregationForComparation = null;
			
			if (auxArg0 != null){
				wsagAggregationForComparation = Convert.getWsagFromIAgree(auxArg0, true);
				List<AppAnnotations> annotations2 = (List<AppAnnotations>) wsagAggregationForComparation.get("annotations");
				if(annotations2.isEmpty()){
					appResponse = AnalizeDelegate.analize(id, wsagAggregation, wsagAggregationForComparation, true);
				} else {
					for(AppAnnotations ann : annotations)
						appResponse.setMessage("<pre>Error: " + ann.getText() + "</pre>");
					appResponse.setStatus(Status.OK_PROBLEMS);
				}
			} else {
				appResponse = AnalizeDelegate.analize(id, wsagAggregation, wsagAggregationForComparation, true);
			}
		} else {
			for(AppAnnotations ann : annotations)
				appResponse.setMessage("<pre>Error: " + ann.getText() + "</pre>");
			appResponse.setStatus(Status.OK_PROBLEMS);
		}
		appResponse.setFileUri(fileUri);
		
		return appResponse;
	}

	@RequestMapping(value = "/format/{format}/checkLanguage", method = RequestMethod.POST)
	@ResponseBody
	public AppResponse checkLanguage(String id, String content, String fileUri) {
		
		return LanguageDelegate.checkLanguage(id, content, fileUri, true);
	}

	@RequestMapping(value = "/convert", method = RequestMethod.POST)
	@ResponseBody
	public AppResponse convertFormat(String currentFormat,
		String desiredFormat, String fileUri, String content) {
		
		return ConversionDelegate.convert(currentFormat, desiredFormat, fileUri, content);
	}
}
