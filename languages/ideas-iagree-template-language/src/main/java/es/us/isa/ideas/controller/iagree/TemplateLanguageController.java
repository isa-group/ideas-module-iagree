package es.us.isa.ideas.controller.iagree;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.us.isa.ideas.adaintegration.iagree.AnalizeDelegate;
import es.us.isa.ideas.common.AppResponse;
import es.us.isa.ideas.module.controller.BaseLanguageController;
import es.us.isa.ideas.util.ConversionDelegate;
import es.us.isa.ideas.util.Convert;
import es.us.isa.ideas.util.LanguageDelegate;

@Controller
@RequestMapping("/language")
public class TemplateLanguageController extends BaseLanguageController {

	@RequestMapping(value = "/operation/{id}/execute", method = RequestMethod.POST)
	@ResponseBody
	public AppResponse executeOperation(String id, String content,
			String fileUri, String contentToCompare) {

		String[] wsagAggregation = Convert.getWsagFromIAgree(content);
		// wsagAggregation[0]; // Converted Document
		// wsagAggregation[1]; // Metrics URI
		// wsagAggregation[2]; // Metrics content
		
		String[] wsagToCompareAggregation = Convert.getWsagFromIAgree(contentToCompare);
		// wsagToCompareAggregation[0]; // Converted Document
		// wsagToCompareAggregation[1]; // Metrics URI
		// wsagToCompareAggregation[2]; // Metrics content

		AppResponse appResponse = AnalizeDelegate.analize(id, wsagAggregation, wsagToCompareAggregation, false);
		appResponse.setFileUri(fileUri);
		return appResponse;
	}

	@RequestMapping(value = "/format/{format}/checkLanguage", method = RequestMethod.POST)
	@ResponseBody
	public AppResponse checkLanguage(String id, String content, String fileUri) {

		return LanguageDelegate.checkLanguage(id, content, fileUri, false);
	}

	@RequestMapping(value = "/convert", method = RequestMethod.POST)
	@ResponseBody
	public AppResponse convertFormat(String currentFormat,
			String desiredFormat, String fileUri, String content) {
		
		return ConversionDelegate.convert(currentFormat, desiredFormat,
				fileUri, content);
	}
}
