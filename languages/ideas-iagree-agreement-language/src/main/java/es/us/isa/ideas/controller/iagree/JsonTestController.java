package es.us.isa.ideas.controller.iagree;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.us.isa.ideas.module.controller.BaseTestModuleController;

@Controller
@RequestMapping("/tests")
public class JsonTestController extends BaseTestModuleController {

	protected static String JSON_FILE_PATH = "/tests/tests.json";
	protected static String RESOURCE_PATH = "/tests/resources/";

	@Override
	protected void setJsonFilePath() {
		this.jsonFilePath = JSON_FILE_PATH;
	}
	
	@Override
	protected void setResourcePath() {
		this.resourcePath = RESOURCE_PATH;
	}
	
}