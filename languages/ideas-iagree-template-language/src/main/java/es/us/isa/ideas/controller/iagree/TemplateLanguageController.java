package es.us.isa.ideas.controller.iagree;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import es.us.ideas.iagree.*;
import es.us.isa.ideas.common.AppResponse;
import es.us.isa.ideas.common.AppResponse.Status;
import es.us.isa.ideas.module.controller.BaseLanguageController;
import es.us.isa.util.Conversion;
import es.us.isa.ada.document.AgreementElement;

@Controller
@RequestMapping("/language")
public class TemplateLanguageController extends BaseLanguageController {

	public AppResponse executeOperation(String id, String content,
			String fileUri) {
		
		//instanciados
		AdaFacade service = new AdaFacade();
		AppResponse appResponse = new AppResponse();
		//traduccion del documento
		String translatedDoc = convertFormat("iagree", "xml", fileUri, content).getData();
		//seleccion de la operacion
		if(id=="checkConsistency"){
			try{
				Boolean check = service.consistency(translatedDoc);
				if(check){
					appResponse.setStatus(Status.OK);
					appResponse.setMessage("The document is consistent");
				}else{
					appResponse.setStatus(Status.OK_PROBLEMS);
					appResponse.setMessage("The document is not consistent");
				}
				appResponse.setFileUri(fileUri);
			}catch(Exception e){
				appResponse.setStatus(Status.ERROR);
				appResponse.setMessage("There has been an error: " + e.getMessage());
			}
		}else if(id=="inconsistencyExplainingShort"){
			try{
				Map<AgreementElement, Collection<AgreementElement>> inconsistences = service.inconsistenciesMap(translatedDoc);
				if(inconsistences.isEmpty()){
					appResponse.setStatus(Status.OK_PROBLEMS);
					appResponse.setMessage("No inconsistences found. Please check if the document is consistent.");
				}else{
					appResponse.setStatus(Status.OK);
					appResponse.setMessage("The document is inconsistent because of these terms: " + inconsistences.toString());
				}
				appResponse.setFileUri(fileUri);
			}catch(Exception e){
				appResponse.setStatus(Status.ERROR);
				appResponse.setMessage("There has been an error: " + e.getMessage());
			}
		}else if(id=="inconsistenciesExplainingLong"){
			try{
				String inconsistencies = service.inconsitencyExplaining(translatedDoc);
				if(inconsistencies.contains("error")){
					appResponse.setStatus(Status.OK_PROBLEMS);
					appResponse.setMessage(inconsistencies);
				}else{
					appResponse.setStatus(Status.OK);
					appResponse.setMessage(inconsistencies);
				}
				appResponse.setFileUri(fileUri);
			}catch(Exception e){
				appResponse.setStatus(Status.ERROR);
				appResponse.setMessage("There has been an error: " + e.getMessage());
			}
		}else if(id=="getNumberOfAlternatives"){
			try{
				Integer numAlt = service.getNumberOfAlternatives(translatedDoc);
				if(numAlt == 0){
					appResponse.setStatus(Status.OK_PROBLEMS);
					appResponse.setMessage("There are no alternatives for the document");
				}else{
					appResponse.setStatus(Status.OK);
					if(numAlt==1){
						appResponse.setMessage("There is " + numAlt + " alternative to the document" );
					}else{
						appResponse.setMessage("There are " + numAlt + " alternatives to the document" );
					}
				}
				appResponse.setFileUri(fileUri);
			}catch(Exception e){
				appResponse.setStatus(Status.ERROR);
				appResponse.setMessage("There has been an error: " + e.getMessage());
			}
		}else{
			appResponse.setStatus(Status.ERROR);
			appResponse.setMessage("No such opperation");
		}
		
		return appResponse;

		// Documentar
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

		System.out.println(currentFormat);
		System.out.println(desiredFormat);	
		
		
		if (currentFormat.equals("iagree") && desiredFormat.equals("wsag")) {
			
			String wsag = Conversion.getWSAG(content);
			//AppResponse resp = new AppResponse();
		}

		return null;
	}
}
