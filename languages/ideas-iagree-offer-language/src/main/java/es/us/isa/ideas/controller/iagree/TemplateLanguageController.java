package es.us.isa.ideas.controller.iagree;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.us.isa.ideas.common.AppResponse;
import es.us.isa.ideas.module.controller.BaseLanguageController;

@Controller
@RequestMapping("/language")
public class TemplateLanguageController extends BaseLanguageController {

	@Override
	public AppResponse executeOperation(String id, String content, String fileUri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppResponse checkLanguage(String id, String content, String fileUri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AppResponse convertFormat(String currentFormat, String desiredFormat,
			String fileUri, String code) {
		// TODO Auto-generated method stub
		return null;
	}

}
