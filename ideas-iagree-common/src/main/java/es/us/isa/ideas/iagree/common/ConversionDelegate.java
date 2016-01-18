package es.us.isa.ideas.iagree.common;

import java.util.ArrayList;
import java.util.List;

import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.parsers.agreements.IAgreeParser;
import es.us.isa.aml.parsers.agreements.JsonParser;
import es.us.isa.aml.parsers.agreements.WsagParser;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeError;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeErrorListener;
import es.us.isa.aml.parsers.agreements.YamlParser;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.csp.CSPBuilder;
import es.us.isa.aml.translator.builders.iagree.IAgreeBuilder;
import es.us.isa.aml.translator.builders.wsag.WSAGBuilder;
import es.us.isa.ideas.iagree.util.TranslateUtil;
import es.us.isa.ideas.module.common.AppAnnotations;
import es.us.isa.ideas.module.common.AppResponse;
import es.us.isa.ideas.module.common.AppResponse.Status;

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
        } else if (currentFormat.equals("iagree") && desiredFormat.equals("wsag")) {

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
        } else if (currentFormat.equals("wsag") && desiredFormat.equals("iagree")) {

            WsagParser parser = new WsagParser();
            AgreementModel model = parser.doParse(content);
            if (model != null) {
                Translator translator = new Translator(new IAgreeBuilder());
                String iagree = translator.print(model);
                appResponse.setStatus(Status.OK);
                appResponse.setData(iagree);
            }
        } else if (currentFormat.equals("iagree") && desiredFormat.equals("json")) {
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
                JsonParser translator = new JsonParser();
                String json = translator.parserToJson(model);
                appResponse.setStatus(Status.OK);
                appResponse.setData(json);
            }
        } else if (currentFormat.equals("iagree") && desiredFormat.equals("yaml")) {
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
                appResponse.setAnnotations(annotations.toArray(new AppAnnotations[annotations.size()]));
            } else {
                YamlParser translator = new YamlParser();
                String yaml = translator.parserToYaml(model);
                appResponse.setStatus(Status.OK);
                appResponse.setData(yaml);
            }
        } else if (currentFormat.equals("json") && desiredFormat.equals("iagree")) {
            JsonParser jparser = new JsonParser();
            AgreementModel model = jparser.doParse(content);
            if (model != null) {
                Translator translator = new Translator(new IAgreeBuilder());
                String iagree = translator.print(model);
                appResponse.setStatus(Status.OK);
                appResponse.setData(iagree);
            }
        } else if (currentFormat.equals("yaml") && desiredFormat.equals("iagree")) {
            YamlParser yparser = new YamlParser();
            AgreementModel model = yparser.doParse(content);
            if (model != null) {
                Translator translator = new Translator(new IAgreeBuilder());
                String iagree = translator.print(model);
                appResponse.setStatus(Status.OK);
                appResponse.setData(iagree);
            }
        } else if (currentFormat.equals("yaml") && desiredFormat.equals("json")) {
            appResponse.setStatus(AppResponse.Status.OK);
            appResponse.setData(TranslateUtil.convertToJson(content));
        } else if (currentFormat.equals("json") && desiredFormat.equals("yaml")) {
            appResponse.setStatus(AppResponse.Status.OK);
            appResponse.setData(TranslateUtil.convertToYaml(content));
        } else if (currentFormat.equals("json") && desiredFormat.equals("wsag")) {
            JsonParser jparser = new JsonParser();
            AgreementModel model = jparser.doParse(content);
            if (model != null) {
                Translator translator = new Translator(new IAgreeBuilder());
                String iagree = translator.print(model);
                appResponse.setStatus(Status.OK);
                appResponse.setData(TranslateUtil.iagree2wsag(iagree));
            }
        } else if (currentFormat.equals("yaml") && desiredFormat.equals("wsag")) {
            YamlParser yparser = new YamlParser();
            AgreementModel model = yparser.doParse(content);
            if (model != null) {
                Translator translator = new Translator(new IAgreeBuilder());
                String iagree = translator.print(model);
                appResponse.setStatus(Status.OK);
                appResponse.setData(TranslateUtil.iagree2wsag(iagree));
            }
        } else if (currentFormat.equals("wsag") && desiredFormat.equals("json")) {
            
            IAgreeParser parser = new IAgreeParser();
            AgreementModel model = parser.doParse(TranslateUtil.wsag2iagree(content));
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
                JsonParser translator = new JsonParser();
                String json = translator.parserToJson(model);
                appResponse.setStatus(Status.OK);
                appResponse.setData(json);
            }

        } else if (currentFormat.equals("wsag") && desiredFormat.equals("yaml")) {
            IAgreeParser parser = new IAgreeParser();
            AgreementModel model = parser.doParse(TranslateUtil.wsag2iagree(content));
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
                appResponse.setAnnotations(annotations.toArray(new AppAnnotations[annotations.size()]));
            } else {
                YamlParser translator = new YamlParser();
                String yaml = translator.parserToYaml(model);
                appResponse.setStatus(Status.OK);
                appResponse.setData(yaml);
            }
        }
        return appResponse;
    }
}
