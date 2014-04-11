package es.us.isa.ideas.controller.iagree;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import es.us.ideas.iagree.AnalizeDelegate;
import es.us.isa.ideas.common.AppResponse;
import es.us.isa.ideas.common.AppResponse.Status;
import es.us.isa.ideas.module.controller.BaseLanguageController;
import es.us.isa.util.ConversionDelegate;


@Controller
@RequestMapping("/language")
public class TemplateLanguageController extends BaseLanguageController {
	
	@RequestMapping("/pepe")
	@ResponseBody
	public String test() {
		return "pepepepe";
	}

	@Override
	public AppResponse executeOperation(String id, String content,
			String fileUri, Map<String,String> data) {
			String translatedDoc = convertFormat("iagree", "wsag", fileUri, content).getData();
			AppResponse appResponse = AnalizeDelegate.analize(id, translatedDoc, null, false);
			appResponse.setFileUri(fileUri);
			return appResponse;
		}

	@Override
	public AppResponse checkLanguage(String id, String content, String fileUri) {
		// TODO Auto-generated method stub
		AppResponse appResponse = new AppResponse();
		appResponse.setStatus(Status.OK_PROBLEMS);
		appResponse.setMessage("Language Checked, method not implemented");
		appResponse.setFileUri(fileUri);
		return appResponse;
		// AppResponse appResponse = new AppResponse();
		// SEDL4PeopleUnmarshaller unmarshaller = new SEDL4PeopleUnmarshaller();
		// Experiment experiment = unmarshaller.fromString(content);
		//
		// boolean problems = false;
		//
		// if ( experiment == null ) {
		// // provisional
		// AppAnnotations[] annotations = ErrorBuilder.buildErrorStructure(
		// unmarshaller.getErrorListener().getErrors() );
		// appResponse.setAnnotations(annotations);
		// problems = true;
		// } else {
		//
		// SEDLSemanticChecker semantic = new SEDLSemanticChecker(experiment,
		// unmarshaller.getListener().getObjectNodeMap(),
		// unmarshaller.getTokens());
		// List<Error> lError = semantic.checkSemantic();
		// if ( !lError.isEmpty() ) {
		// AppAnnotations[] annotations =
		// ErrorBuilder.buildSemanticErrorStructure(lError);
		// appResponse.setAnnotations(annotations);
		// problems = true;
		// }
		// }
		// //System.out.println("CheckSyntax: " + res );
		// appResponse.setFileUri(fileUri);
		//
		// if (problems)
		// appResponse.setStatus(Status.OK_PROBLEMS);
		// else
		// appResponse.setStatus(Status.OK);
		//
		//
		// return appResponse;
	}

	@Override
	public AppResponse convertFormat(String currentFormat,
		String desiredFormat, String fileUri, String content) {
		return ConversionDelegate.convert(currentFormat, desiredFormat, fileUri, content);
	}
}
