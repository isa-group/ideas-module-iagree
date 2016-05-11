package es.us.isa.ideas.controller.iagree;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import es.us.isa.aml.util.DocType;
import es.us.isa.ideas.iagree.common.AnalyzeDelegate;
import es.us.isa.ideas.iagree.common.ConversionDelegate;
import es.us.isa.ideas.iagree.common.LanguageDelegate;
import es.us.isa.ideas.module.common.AppResponse;
import es.us.isa.ideas.module.controller.BaseLanguageController;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/language")
public class TemplateLanguageController extends BaseLanguageController {
	
	@RequestMapping(value = "/operation/{id}/execute", method = RequestMethod.POST)
	@ResponseBody
	public AppResponse executeOperation(String id, String content, String fileUri, String auxArg0, HttpServletRequest request) {
                
		return AnalyzeDelegate.analize(id, content, fileUri, DocType.TEMPLATE, auxArg0, request);
	}

	@RequestMapping(value = "/format/{format}/checkLanguage", method = RequestMethod.POST)
	@ResponseBody
	public AppResponse checkLanguage(String id, String content, String fileUri) {

		return LanguageDelegate.checkLanguage(id, content, fileUri, false);
	}

	@RequestMapping(value = "/convert", method = RequestMethod.POST)
	@ResponseBody
	public AppResponse convertFormat(String currentFormat, String desiredFormat, String fileUri, String content) {
		
		return ConversionDelegate.convert(currentFormat, desiredFormat,
				fileUri, content);
	}
}
