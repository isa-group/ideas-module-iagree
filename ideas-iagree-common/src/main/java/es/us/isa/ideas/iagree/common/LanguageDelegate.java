package es.us.isa.ideas.iagree.common;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.us.isa.aml.parsers.agreements.IAgreeParser;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeError;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeErrorListener;
import es.us.isa.ideas.module.common.AppAnnotations;
import es.us.isa.ideas.module.common.AppResponse;
import es.us.isa.ideas.module.common.AppResponse.Status;

public class LanguageDelegate {
	
	private static final Logger LOGGER = Logger
			.getLogger(LanguageDelegate.class.getName());

	public static AppResponse checkLanguage(String format, String content,
			String fileUri, boolean isOffer) {

		AppResponse appResponse = new AppResponse();
		appResponse.setFileUri(fileUri);
		List<AppAnnotations> annotations = new ArrayList<AppAnnotations>();

		if (format.equals("iagree")) {

			IAgreeParser parser = new IAgreeParser();

			try {
				parser.doParse(content);
			} catch (Exception e) {
				IAgreeErrorListener errorListener = parser.getErrorListener();

				if (errorListener.hasErrors()) {

					for (IAgreeError error : errorListener.getErrors()) {

						Integer lineNo = error.getLineNo() - 1;
						Integer columnNo = error.getCharStart();

						AppAnnotations appAnnot = new AppAnnotations();
						appAnnot.setRow(lineNo.toString());
						appAnnot.setColumn(columnNo.toString());
						appAnnot.setText(error.getMessage().replace("\"", "'"));
						appAnnot.setType("error");
						annotations.add(appAnnot);
					}
				}
			}

			if (!annotations.isEmpty()) {
				appResponse.setStatus(Status.OK_PROBLEMS);
				appResponse.setAnnotations(annotations
						.toArray(new AppAnnotations[annotations.size()]));
			} else {
				appResponse.setStatus(Status.OK);
			}

		} else
			LOGGER.log(Level.INFO, "No language checker is implemented for this format: "
							+ format);

		return appResponse;
	}

}
