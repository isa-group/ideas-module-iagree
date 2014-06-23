package es.us.isa.ideas.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import es.us.isa.ideas.common.AppAnnotations;
import es.us.isa.ideas.common.AppResponse;
import es.us.isa.ideas.common.AppResponse.Status;

public class ConversionDelegate {

	@SuppressWarnings("unchecked")
	public static AppResponse convert(String currentFormat,
			String desiredFormat, String fileUri, String content) {
		AppResponse appResp = new AppResponse();
		List<AppAnnotations> annotations = new ArrayList<AppAnnotations>();
		String wsag = "";
		if (currentFormat.equals("iagree") && desiredFormat.equals("wsag")) {
			Map<String, Object> res = Convert.getWsagFromIAgree(content, false);

			annotations.addAll((List<AppAnnotations>) res.get("annotations"));

			if (!annotations.isEmpty()) {
				appResp.setStatus(Status.OK_PROBLEMS);
				appResp.setAnnotations(annotations
						.toArray(new AppAnnotations[annotations.size()]));
			} else {
				appResp.setStatus(Status.OK);
				appResp.setData((String) res.get("data"));
				appResp.setFileUri(fileUri);
			}
		} else if (currentFormat.equals("wsag")
				&& desiredFormat.equals("iagree")) {

			// TODO implementar los errores en la conversion de wsag a iagree

			wsag = Convert.getIAgreeFromWsag(content);

			if (wsag.isEmpty())
				wsag = "ERROR!";

			appResp.setData(wsag);
			appResp.setFileUri(fileUri);
			appResp.setAnnotations(annotations
					.toArray(new AppAnnotations[annotations.size()]));
		}

		return appResp;
	}
}
