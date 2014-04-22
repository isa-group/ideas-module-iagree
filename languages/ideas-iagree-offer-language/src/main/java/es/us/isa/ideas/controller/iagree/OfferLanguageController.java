package es.us.isa.ideas.controller.iagree;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.us.isa.ideas.adaintegration.iagree.AnalizeDelegate;
import es.us.isa.ideas.common.AppResponse;
import es.us.isa.ideas.module.controller.BaseLanguageController;
import es.us.isa.ideas.util.ConversionDelegate;
import es.us.isa.ideas.util.Convert;
import es.us.isa.ideas.util.LanguageDelegate;

@Controller
@RequestMapping("/language")
public class OfferLanguageController extends BaseLanguageController {

	public AppResponse executeOperation(String id, String content,
			String fileUri, Map<String,String> data) {
		
		String[] wsagAggregation = Convert.getWsagFromIAgree(content);
		// wsagAggregation[0]; // Converted Document
		// wsagAggregation[1]; // Metrics URI
		// wsagAggregation[2]; // Metrics content
		String[] wsagAggregationForComparation = null;
		if(!data.isEmpty()){
			wsagAggregationForComparation = Convert.getWsagFromIAgree(data.get("template"));
		}
		

		AppResponse appResponse = AnalizeDelegate.analize(id, wsagAggregation, wsagAggregationForComparation, true);
		appResponse.setFileUri(fileUri);
		return appResponse;
	}

	@Override
	public AppResponse checkLanguage(String id, String content, String fileUri) {
		
		return LanguageDelegate.checkLanguage(id, content, fileUri, true);
		
	}

	@Override
	public AppResponse convertFormat(String currentFormat,
		String desiredFormat, String fileUri, String content) {
		
		return ConversionDelegate.convert(currentFormat, desiredFormat, fileUri, content);
	}
}
