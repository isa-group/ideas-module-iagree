package es.us.isa.ideas.controller.iagree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.us.ideas.iagree.*;
import es.us.isa.error.IAgreeError;
import es.us.isa.ideas.common.AppAnnotations;
import es.us.isa.ideas.common.AppResponse;
import es.us.isa.ideas.module.controller.BaseLanguageController;
import es.us.isa.util.Convert2Wsag;

@Controller
@RequestMapping("/language")
public class OfferLanguageController extends BaseLanguageController {

	public AppResponse executeOperation(String id, String content,
			String fileUri, Map<String,String> data) {
		String translatedDoc = convertFormat("iagree", "wsag", fileUri, content).getData();
		String translatedOther = convertFormat("iagree", "wsag", fileUri, data.get("template")).getData();
		AppResponse appResponse = AnalizeDelegate.analize(id, translatedDoc, translatedOther, true);
		appResponse.setFileUri(fileUri);
		return appResponse;
	}

	@Override
	public AppResponse checkLanguage(String id, String content, String fileUri) {
		// TODO Auto-generated method stub
		return null;
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
		AppResponse appResp = new AppResponse();
		List<AppAnnotations> annotations = new ArrayList<AppAnnotations>();
		String wsag = "";
		if (currentFormat.equals("iagree") && desiredFormat.equals("wsag")) {
			
			if (Convert2Wsag.hasErrors()) {
				for (IAgreeError error : Convert2Wsag.getErrors()) {
					Integer lineNo = error.getLineNo();
					Integer columnNo = error.getCharStart();

					AppAnnotations appAnnot = new AppAnnotations();
					appAnnot.setRow(lineNo.toString());
					appAnnot.setColumn(columnNo.toString());
					appAnnot.setText(error.getMessage());
					appAnnot.setType(error.getSeverity().toString());
					annotations.add(appAnnot);
				}
			} else {
				wsag = Convert2Wsag.getWsagFromIAgree(content);
			}

			appResp.setData(wsag);
			appResp.setFileUri(fileUri);
			appResp.setAnnotations(annotations
					.toArray(new AppAnnotations[annotations.size()]));
			}

		return appResp;
	}
}
