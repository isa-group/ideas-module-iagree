package es.us.isa.ideas.iagree.common;

import java.util.ArrayList;
import java.util.List;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.parsers.agreements.IAgreeParser;
import es.us.isa.aml.parsers.agreements.WsagParser;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeError;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeErrorListener;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.csp.CSPBuilder;
import es.us.isa.aml.translator.builders.iagree.IAgreeBuilder;
import es.us.isa.aml.translator.builders.wsag.WSAGBuilder;
import es.us.isa.ideas.common.AppAnnotations;
import es.us.isa.ideas.common.AppResponse;
import es.us.isa.ideas.common.AppResponse.Status;

public class ConversionDelegate {

	public static AppResponse convert(String currentFormat,
			String desiredFormat, String fileUri, String content) {

		AppResponse appResponse = new AppResponse();
		appResponse.setFileUri(fileUri);

		if (currentFormat.equals("iagree") && desiredFormat.equals("opl")) {

			IAgreeParser parser = new IAgreeParser();
			AgreementModel model = parser.doParse(content);

			IAgreeErrorListener errorListener = parser.getErrorListener();

			if (errorListener.hasErrors()) {
				appResponse.setStatus(Status.OK_PROBLEMS);

				List<AppAnnotations> annotations = new ArrayList<AppAnnotations>();

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
				appResponse.setAnnotations(annotations
						.toArray(new AppAnnotations[annotations.size()]));

			} else {

				Translator translator = new Translator(new CSPBuilder());
				String opl = translator.print(model);

				appResponse.setStatus(Status.OK);
				appResponse.setData(opl);
			}
		} else if (currentFormat.equals("iagree")
				&& desiredFormat.equals("wsag")) {
			IAgreeParser parser = new IAgreeParser();
			AgreementModel model = parser.doParse(content);

			IAgreeErrorListener errorListener = parser.getErrorListener();

			if (errorListener.hasErrors()) {
				appResponse.setStatus(Status.OK_PROBLEMS);

				List<AppAnnotations> annotations = new ArrayList<AppAnnotations>();

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
				appResponse.setAnnotations(annotations
						.toArray(new AppAnnotations[annotations.size()]));

			} else {

				Translator translator = new Translator(new WSAGBuilder());
				String wsag = translator.print(model);

				appResponse.setStatus(Status.OK);
				appResponse.setData(wsag);
			}
		} else if (currentFormat.equals("wsag")
				&& desiredFormat.equals("iagree")) {

			WsagParser parser = new WsagParser();
			AgreementModel model = parser.doParse(content);

			if (model != null) {
				Translator translator = new Translator(new IAgreeBuilder());
				String iagree = translator.print(model);

				appResponse.setStatus(Status.OK);
				appResponse.setData(iagree);
			}
		}

		return appResponse;
	}
}
