package es.us.isa.ideas.util;

import java.util.ArrayList;
import java.util.List;

import es.us.isa.ideas.common.AppAnnotations;
import es.us.isa.ideas.common.AppResponse;
import es.us.isa.ideas.error.IAgreeError;

public class ConversionDelegate {

	public static AppResponse convert(String currentFormat, String desiredFormat,
			String fileUri, String content) {
		AppResponse appResp = new AppResponse();
		List<AppAnnotations> annotations = new ArrayList<AppAnnotations>();
		String wsag = "";
		if (currentFormat.equals("iagree") && desiredFormat.equals("wsag")) {

			if (Convert.hasErrors()) {
				for (IAgreeError error : Convert.getErrors()) {
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
				wsag = Convert.getWsagFromIAgree(content)[0];
			}

			appResp.setData(wsag);
			appResp.setFileUri(fileUri);
			appResp.setAnnotations(annotations
					.toArray(new AppAnnotations[annotations.size()]));
		} else if (currentFormat.equals("wsag") && desiredFormat.equals("iagree")) {
			
			wsag = Convert.getIAgreeFromWsag(content);
			
			if(wsag.isEmpty())
				wsag = "errorrororrorororororr";

			appResp.setData(wsag);
			appResp.setFileUri(fileUri);
			appResp.setAnnotations(annotations
					.toArray(new AppAnnotations[annotations.size()]));
		}

		return appResp;
	}
}
