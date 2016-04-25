/**
 *
 */
package es.us.isa.ideas.iagree.common;

import com.google.common.base.Strings;
import com.google.gson.Gson;
import java.io.InputStream;

import es.us.isa.aml.AgreementManager;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.operations.core.csp.AreCompliant;
import es.us.isa.aml.operations.core.csp.WhyAreNotCompliant;
import es.us.isa.aml.operations.noCore.Valid;
import es.us.isa.aml.parsers.agreements.IAgreeParser;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeError;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeErrorListener;
import es.us.isa.aml.util.Config;
import es.us.isa.aml.util.DocType;
import es.us.isa.aml.util.Util;
import es.us.isa.ideas.iagree.common.portalConfig.Content;
import es.us.isa.ideas.iagree.common.portalConfig.Paypal;
import es.us.isa.ideas.iagree.common.portalConfig.Plan;
import es.us.isa.ideas.iagree.common.portalConfig.PortalConfig;
import es.us.isa.ideas.module.common.AppResponse;
import es.us.isa.ideas.module.common.AppResponse.Status;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * @author jdelafuente
 *
 */
public class AnalyzeDelegate {
    
    public static AppResponse analize(String id, String content,
            String fileUri, DocType docType, String auxArg0) {
        return analize(id, content, fileUri, docType, auxArg0, null);
    }

    public static AppResponse analize(String id, String content,
            String fileUri, DocType docType, String auxArg0, HttpServletRequest request) {

        AppResponse appResponse = new AppResponse();
        appResponse.setFileUri(fileUri);

        InputStream in = AnalyzeDelegate.class
                .getResourceAsStream("/config.json");
        String config = Util.getStringFromInputStream(in);

        AgreementManager manager = new AgreementManager(config);
        
        String username;
        try {
            String baseUrl = String.format("%s://%s:%d",request.getScheme(),  request.getServerName(), request.getServerPort());
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            
            String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
            headers.add("Cookie", "JSESSIONID=" + sessionId);
            HttpEntity requestEntity = new HttpEntity(null, headers);
            ResponseEntity<String> jsonResponse = restTemplate.exchange(baseUrl + "/IDEAS/researcher/principaluser", HttpMethod.GET, requestEntity, String.class);
            JSONObject json = new Gson().fromJson(jsonResponse.getBody(), JSONObject.class);
            username = json.getString("username");
            if(Strings.isNullOrEmpty(username)){
                username = "DemoMaster";
            }
            Config.getInstance().setCredential(username);
            AgreementModel model = null, model2;
        
            IAgreeParser parser = new IAgreeParser();
            parser.doParse(content);
            IAgreeErrorListener errorListener = parser.getErrorListener();
            if (errorListener.hasErrors()) {
                StringBuilder lines = new StringBuilder();
                List<IAgreeError> errors = errorListener.getErrors();
                for (IAgreeError error : errors) {
                    lines.append(error.getLineNo());
                    if (errors.indexOf(error) != errors.size() - 1) {
                        lines.append(", ");
                    }
                }
                if (lines.toString().isEmpty()) {
                    appResponse.setHtmlMessage("<pre>This document is not supported by analysis operations.</pre>");
                } else {
                    appResponse.setHtmlMessage("<pre>This document is not supported by analysis operations. "
                            + "See annotations in lines " + lines + " for more information.</pre>");
                }
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
                    appResponse.setMessage("<pre><b>The document is consistent.</b></pre>");
                    appResponse.setStatus(Status.OK);
                } else {
                    Valid op = new Valid();
                    op.analyze(model);

                    if (op.getResult().getExistInconsistencies()) {
                        if (!op.getResult().getConflicts().isEmpty()) {
                            appResponse.setMessage("<pre><b>The document is not consistent.</b>\n"
                                    + op.getResult().getConflicts()
                                    + "</pre>");
                        } else {
                            appResponse
                                    .setMessage("<pre><b>The document is not consistent.</b>"
                                            + "</pre>");
                        }
                        appResponse.setStatus(Status.OK_PROBLEMS);
                    } else if (op.getResult().getExistDeadTerms()) {
                        appResponse.setMessage("<pre><b>The document has dead terms.</b>\n"
                                + op.getResult().getConflicts()
                                + "</pre>");
                        appResponse.setStatus(Status.OK_PROBLEMS);
                    } else if (op.getResult().getExistCondInconsTerms()) {
                        appResponse.setMessage("<pre><b>The document has conditionally inconsistent terms.</b>\n"
                                + op.getResult().getConflicts()
                                + "</pre>");
                        appResponse.setStatus(Status.OK_PROBLEMS);
                    }
                }

            } else if (id.equals("checkCompliance")) {
                model = manager.createAgreementTemplate(content);
                model2 = manager.createAgreementOffer(auxArg0);

                AreCompliant op = new AreCompliant();
                op.analyze(model, model2);
                Boolean compliant = op.getResult().getCompliant();
                if (compliant != null) {
                    if (compliant) {
                        appResponse.setMessage("<pre><b>The provided offer is compliant with the provided template.</b></pre>");
                        appResponse.setStatus(Status.OK);
                    } else {
                        appResponse.setMessage("<pre><b>The documents are not compliant.</b></pre>");
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
                Boolean compliant = op.getResult().getCompliant();
                if (compliant != null) {
                    if (compliant) {
                        appResponse.setMessage("<pre><b>The provided offer is compliant with the provided template.</b></pre>");
                        appResponse.setStatus(Status.OK);
                    } else {
                        appResponse.setMessage("<pre><b>The documents are not compliant.</b></pre>");
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
                Boolean compliant = op.getResult().getCompliant();
                if (compliant != null) {
                    if (compliant) {
                        appResponse.setMessage("<pre><b>The provided offer is compliant with the provided template.</b></pre>");
                        appResponse.setStatus(Status.OK);
                    } else {
                        appResponse.setMessage("<pre><b>The documents are not compliant:</b>\n"
                                + " - Conflict type: "
                                + op.getResult().getConflictType()
                                + "\n"
                                + " - Conflicting offer terms: "
                                + op.getResult().getConflicts()
                                + "\n"
                                + " - Affected template terms: "
                                + op.getResult().getAffectedTerms()
                                + "</pre>");
                        appResponse.setStatus(Status.OK_PROBLEMS);
                    }
                } else {
                    appResponse.setMessage("<pre>There was an error.</pre>");
                    appResponse.setStatus(Status.ERROR);
                }
            } else if (id.equals("generateOPL")) {
                try {
                    appResponse = ConversionDelegate.convert("iagree", "opl", fileUri, content);
                    String newURI = constructUri(fileUri, "opl");
                    appResponse.setMessage("<pre><b>The OPL document has been generated successfully.</b></pre>");
                    appResponse.setFileUri(newURI);
                } catch (Exception e) {
                    appResponse.setMessage("<pre>There was an error.</pre>");
                    appResponse.setStatus(Status.ERROR);
                }
            } else if (id.equals("generatePortal")) {
                try {
                    PortalConfig pConfig = new PortalConfig();
                    pConfig.setType("multiplan");
                    pConfig.setDatastore("http://datastore.governify.io/api/v6.1/");
                    Plan plan = new Plan();
                    plan.setRenderMode("angular");

                    Content pContent = new Content();
                    pContent.setModelURL("http://labs.isa.us.es/ir/" + username + "/" + fileUri);
                    pContent.setViewURL("http://labs.isa.us.es/ir/" + username + "/" + constructGovernifyPortalUri(fileUri, "ang"));
                    pContent.setCtlURL("http://labs.isa.us.es/ir/" + username + "/" + constructGovernifyPortalUri(fileUri, "ctl"));
                    pContent.setCustomizable(false);
                    List<Content> contents = new ArrayList<>();
                    contents.add(pContent);
                    plan.setContent(contents);
                    pConfig.setPlan(plan);

                    Paypal paypal = new Paypal();
                    paypal.setAccount("paypal@governify.io");
                    paypal.setClientID("AWGQIW44STGH_tqJRMfu2WfSmY1uQauI6pDXzOjIPJ3-lL0una-ySLsNCvhPbzaUO9fvEgBfMavPgSwV");
                    paypal.setSecret("ENIR681gXkKPRL_kdfJccO0YkeamPVlxr6fOaYj43Rhs_nRI1f-LmPAzKI_ipqhtCFohEVGXc9GVvF7l");
                    pConfig.setPaypal(paypal);

                    String newFileUri = constructUri(fileUri, "portal-config", "json");
                    String portalLink = "http://portal.governify.io/app/#/portal?configurl=http://labs.isa.us.es/ir/" + username + "/" + newFileUri;
                    appResponse.setMessage("<pre><b>Access to <a href='"+portalLink+"' target='_blank'>Portal</a></b></pre>");
                    appResponse.setData(new Gson().toJson(pConfig));
                    appResponse.setFileUri(newFileUri);
                    appResponse.setStatus(Status.OK);
                } catch (Exception e) {
                    appResponse.setMessage("<pre>There was an error: " + e.getMessage() + "</pre>");
                    appResponse.setStatus(Status.ERROR);
                }
            }

        } catch (Exception e) {
            appResponse.setMessage("<pre>" + e.getMessage() + "</pre>");
            appResponse.setStatus(Status.OK_PROBLEMS);
        }

        return appResponse;
    }

    private static String getWorkspaceFromFileuri(String uri) {
        String ret;
        String[] listUri = uri.split("/");
        ret = listUri[0];
        return ret;
    }
    
    private static String constructUri(String uri, String filename, String extension) {
        String ret = "";
        String[] listUri = uri.split("/");
        for (int i = 0; i < listUri.length - 1; i++) {
            ret += listUri[i] + "/";
        }
        ret += filename + "." + extension;
        return ret;
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
        ret += filename + "-portal." + extension;
        return ret;
    }

    private static String constructGovernifyPortalUri(String uri, String extension) {
        String ret = "";
        String[] listUri = uri.split("/");
        String file = listUri[listUri.length - 1];

        String[] fileaux = file.split("\\.");
        String filename = fileaux[0];

        for (int i = 0; i < listUri.length - 1; i++) {
            ret += listUri[i] + "/";
        }
        ret += filename + "-portal." + extension;
        return ret;
    }

    @Override
    public String toString() {
        return "AnalyzerDelegate - v1.0.0";
    }

}
