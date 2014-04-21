package es.us.isa.ideas.util;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import es.us.isa.ideas.common.AppAnnotations;
import es.us.isa.ideas.common.AppResponse;
import es.us.isa.ideas.common.AppResponse.Status;
import es.us.isa.ideas.error.IAgreeError;
import es.us.isa.ideas.error.IAgreeErrorListener;
import es.us.isa.ideas.parser.MiAgreeListener;
import es.us.isa.ideas.parser.iAgreeLexer;
import es.us.isa.ideas.parser.iAgreeParser;
import es.us.isa.ideas.parser.iAgreeParser.EntryContext;

public class LanguageDelegate {

	public static AppResponse checkLanguage(String format, String content, String fileUri, boolean isOffer) {
		
		AppResponse appResponse = new AppResponse();
		appResponse.setFileUri(fileUri);
		List<AppAnnotations> annotations = new ArrayList<AppAnnotations>();
		
		if (format.equals("iagree")) {
			
			// TODO: Refactorizar junto con lo que hay en Convert.
			// En convert no se está gestionando bien la concurrencia. Los errores no se deben
			// "preguntar", sino que se deben gestionar dentro de la misma llamada.
			
			
			// Get our lexer
			iAgreeLexer lexer = new iAgreeLexer(new ANTLRInputStream(content));

			// Get a list of matched tokens
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			// Pass the tokens to the parser
			iAgreeParser parser = new iAgreeParser(tokens);

			IAgreeErrorListener errorListener = new IAgreeErrorListener();
			parser.addErrorListener(errorListener);

			// Specify our entry point
			EntryContext context = parser.entry();

			// Walk it and attach our listener
			MiAgreeListener listener = new MiAgreeListener();
			ParseTreeWalker walker = new ParseTreeWalker();
			walker.walk(listener, context);

			
			if (!errorListener.getErrors().isEmpty()) {
				appResponse.setStatus(Status.OK_PROBLEMS);
				
				// Construct error structures
				for (IAgreeError error : errorListener.getErrors()) {
					
					int lineNo = error.getLineNo();
					int columnNo = error.getCharStart();

					AppAnnotations appAnnot = new AppAnnotations();
					appAnnot.setRow(lineNo + "");
					appAnnot.setColumn(columnNo + "");
					appAnnot.setText(error.getMessage());
					appAnnot.setType(error.getSeverity().toString());
					annotations.add(appAnnot);
				}
				
			} else {
				appResponse.setStatus(Status.OK);
			}


			
		} else
			System.out.println("No language checker is implemented for this format: " + format);
		
		appResponse.setAnnotations(annotations.toArray(new AppAnnotations[annotations.size()]));
		
		return appResponse;
	}
	
}
