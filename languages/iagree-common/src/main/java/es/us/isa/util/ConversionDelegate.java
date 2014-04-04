package es.us.isa.util;

import java.util.ArrayList;
import java.util.List;

import es.us.isa.error.IAgreeError;
import es.us.isa.ideas.common.AppAnnotations;
import es.us.isa.ideas.common.AppResponse;

public class ConversionDelegate {

	public static AppResponse convert(String currentFormat, String desiredFormat,
			String fileUri, String content) {
		AppResponse appResp = new AppResponse();
		List<AppAnnotations> annotations = new ArrayList<AppAnnotations>();
		String wsag = "";
		if (currentFormat.equals("iagree") && desiredFormat.equals("wsag")) {
			
			System.out.println("aaaaaaaaaaasdafsada");

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
					
					System.out.println("aaaaaaaaaa" + lineNo + " , " + columnNo);
				}
			} else {
				wsag = Convert2Wsag.getWsagFromIAgree(content);
			}

			appResp.setData(wsag);
			appResp.setFileUri(fileUri);
			appResp.setAnnotations(annotations
					.toArray(new AppAnnotations[annotations.size()]));
		} else if (currentFormat.equals("wsag") && desiredFormat.equals("iagree")) {

			/*
			if (Convert2IAgree.hasErrors()) {
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
			*/
			
			wsag = Convert2Wsag.getWsagFromIAgree(content);

			appResp.setData(wsag);
			appResp.setFileUri(fileUri);
			appResp.setAnnotations(annotations
					.toArray(new AppAnnotations[annotations.size()]));
		}

		return appResp;
	}

}
