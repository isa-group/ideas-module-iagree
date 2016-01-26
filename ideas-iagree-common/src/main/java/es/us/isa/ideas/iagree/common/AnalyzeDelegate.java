/**
 *
 */
package es.us.isa.ideas.iagree.common;

import java.io.InputStream;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.core.csp.AreCompliant;
import es.us.isa.aml.operations.core.csp.WhyAreNotCompliant;
import es.us.isa.aml.operations.noCore.Valid;
import es.us.isa.aml.parsers.agreements.IAgreeParser;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeError;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeErrorListener;
import es.us.isa.aml.util.DocType;
import es.us.isa.aml.util.Util;
import es.us.isa.ideas.module.common.AppAnnotations;
import es.us.isa.ideas.module.common.AppResponse;
import es.us.isa.ideas.module.common.AppResponse.Status;
import java.util.List;

/**
 * @author jdelafuente
 *
 */
public class AnalyzeDelegate {

    public static AppResponse analize(String id, String content,
            String fileUri, DocType docType, String auxArg0) {

        AppResponse appResponse = new AppResponse();
        appResponse.setFileUri(fileUri);

        InputStream in = AnalyzeDelegate.class
                .getResourceAsStream("/config.json");
        String config = Util.getStringFromInputStream(in);

        AgreementManager manager = new AgreementManager(config);
        AgreementModel model = null, model2 = null;

        try {
            IAgreeParser parser = new IAgreeParser();
            parser.doParse(content);
            IAgreeErrorListener errorListener = parser.getErrorListener();
            if (errorListener.hasErrors()) {
                StringBuilder lines = new StringBuilder();
                List<IAgreeError> errors = errorListener.getErrors();
                for(IAgreeError error: errors){
                    lines.append(error.getLineNo());
                    if(errors.indexOf(error) != errors.size()-1)
                        lines.append(", ");
                }
                if(lines.toString().isEmpty())
                    appResponse.setHtmlMessage("<pre>This document is not supported by analysis operations.</pre>");
                else
                    appResponse.setHtmlMessage("<pre>This document is not supported by analysis operations. "
                        + "See annotations in lines " + lines + " for more information.</pre>");
                appResponse.setStatus(Status.OK_PROBLEMS);
            } else if (id.equals("checkConsistency")) {
                switch (docType) {
                    case TEMPLATE:
                        model = manager.createAgreementTemplate(content);
                        break;
                    case OFFER:
                        model = manager.createAgreementOffer(content);
                        break;
                    case AGREEMENT:
                        model = manager.createAgreement(content);
                        break;
                }

                if (manager.isValid(model)) {
                    appResponse
                            .setMessage("<pre><b>The document is consistent.</b></pre>");
                    appResponse.setStatus(Status.OK);
                } else {
                    Valid op = new Valid();
                    op.analyze(model);

                    if ((Boolean) op.getResult().get("existInconsistencies")) {
                        if (op.getResult().get("conflicts") != null) {
                            appResponse
                                    .setMessage("<pre><b>The document is not consistent.</b>\n"
                                            + op.getResult().get("conflicts")
                                            + "</pre>");
                        } else {
                            appResponse
                                    .setMessage("<pre><b>The document is not consistent.</b>"
                                            + "</pre>");
                        }
                        appResponse.setStatus(Status.OK_PROBLEMS);
                    } else if ((Boolean) op.getResult().get("existDeadTerms")) {
                        appResponse
                                .setMessage("<pre><b>The document has dead terms.</b>\n"
                                        + op.getResult().get(
                                                "conflicts_deadterms")
                                        + "</pre>");
                        appResponse.setStatus(Status.OK_PROBLEMS);
                    } else if ((Boolean) op.getResult().get(
                            "existCondInconsTerms")) {
                        appResponse
                                .setMessage("<pre><b>The document has conditionally inconsistent terms.</b>\n"
                                        + op.getResult().get(
                                                "conflicts_condIncons")
                                        + "</pre>");
                        appResponse.setStatus(Status.OK_PROBLEMS);
                    }
                }

            } else if (id.equals("checkCompliance")) {
                model = manager.createAgreementTemplate(content);
                model2 = manager.createAgreementOffer(auxArg0);

                AreCompliant op = new AreCompliant();
                op.analyze(model, model2);
                Boolean compliant = (Boolean) op.getResult().get("compliant");
                if (compliant != null) {
                    if (compliant) {
                        appResponse
                                .setMessage("<pre><b>The provided offer is compliant with the provided template.</b></pre>");
                        appResponse.setStatus(Status.OK);
                    } else {
                        appResponse
                                .setMessage("<pre><b>The documents are not compliant.</b></pre>");
                        appResponse.setStatus(Status.OK_PROBLEMS);
                    }
                } else {
                    appResponse.setMessage("<pre>There was an error.</pre>");
                    appResponse.setStatus(Status.ERROR);
                }
            } else if (id.equals("checkComplianceAuto")) {
                model = manager.createAgreementOffer(content);
                model2 = manager.createAgreementTemplate(auxArg0);

                AreCompliant op = new AreCompliant();
                op.analyze(model2, model);
                Boolean compliant = (Boolean) op.getResult().get("compliant");
                if (compliant != null) {
                    if (compliant) {
                        appResponse
                                .setMessage("<pre><b>The provided offer is compliant with the provided template.</b></pre>");
                        appResponse.setStatus(Status.OK);
                    } else {
                        appResponse
                                .setMessage("<pre><b>The documents are not compliant.</b></pre>");
                        appResponse.setStatus(Status.OK_PROBLEMS);
                    }
                } else {
                    appResponse.setMessage("<pre>There was an error.</pre>");
                    appResponse.setStatus(Status.ERROR);
                }
            } else if (id.equals("complianceAnalysis")) {
                model = manager.createAgreementOffer(content);
                model2 = manager.createAgreementTemplate(auxArg0);

                WhyAreNotCompliant op = new WhyAreNotCompliant();
                op.analyze(model2, model);
                Boolean compliant = (Boolean) op.getResult().get("compliant");
                if (compliant != null) {
                    if (compliant) {
                        appResponse
                                .setMessage("<pre><b>The provided offer is compliant with the provided template.</b></pre>");
                        appResponse.setStatus(Status.OK);
                    } else {
                        appResponse
                                .setMessage("<pre><b>The documents are not compliant:</b>\n"
                                        + " - Conflict type: "
                                        + op.getResult().get("conflictType")
                                        + "\n"
                                        + " - Conflicting offer terms: "
                                        + op.getResult().get("conflicts")
                                        + "\n"
                                        + " - Affected template terms: "
                                        + op.getResult().get("affectedTerms")
                                        + "</pre>");
                        appResponse.setStatus(Status.OK_PROBLEMS);
                    }
                } else {
                    appResponse.setMessage("<pre>There was an error.</pre>");
                    appResponse.setStatus(Status.ERROR);
                }
            } else if (id.equals("generateOPL")) {
                try {
                    appResponse = ConversionDelegate.convert("iagree", "opl",
                            fileUri, content);
                    String newURI = constructUri(fileUri, "opl");
                    appResponse
                            .setMessage("<pre><b>The OPL document has been generated successfully.</b></pre>");
                    appResponse.setFileUri(newURI);
                } catch (Exception e) {
                    appResponse.setMessage("<pre>There was an error.</pre>");
                    appResponse.setStatus(Status.ERROR);
                }
            }

        } catch (Exception e) {
            appResponse.setMessage("<pre>" + e.getMessage() + "</pre>");
            appResponse.setStatus(Status.OK_PROBLEMS);
        }

        return appResponse;
    }

    private static String constructUri(String uri, String extension) {
        String ret = "";
        String[] listUri = uri.split("/");
        String file = listUri[listUri.length - 1];

        String[] fileaux = file.split("\\.");
        String filename = fileaux[0];

        for (int i = 0; i < listUri.length - 1; i++) {
            ret += listUri[i] + "/";
        }
        ret += filename + "." + extension;
        return ret;
    }

    @Override
    public String toString() {
        return "AnalyzerDelegate - v1.0.0";
    }

}
