/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.us.isa.ideas.iagree.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import es.us.isa.aml.model.AgreementModel;
import es.us.isa.aml.parsers.agreements.IAgreeParser;
import es.us.isa.aml.parsers.agreements.WsagParser;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeError;
import es.us.isa.aml.parsers.agreements.iagree.IAgreeErrorListener;
import es.us.isa.aml.parsers.agreements.yaml.ParserYAMLUtil;
import es.us.isa.aml.translator.Translator;
import es.us.isa.aml.translator.builders.iagree.IAgreeBuilder;
import es.us.isa.aml.translator.builders.wsag.WSAGBuilder;
import es.us.isa.ideas.module.common.AppAnnotations;
import es.us.isa.ideas.module.common.AppResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.yaml.snakeyaml.Yaml;

/**
 *
 * @author Usuario
 */
public class TranslateUtil {

    public static String convertToJson(String yamlString) {
        Yaml yaml = new Yaml();
        Map<String, String> obj = (Map<String, String>) yaml.load(yamlString);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(obj);
        return json;
    }

    public static String convertToYaml(String jsonContent) {
        Map<String, String> propertyMap = new HashMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            propertyMap = mapper.readValue(jsonContent, new TypeReference<HashMap<String, Object>>() {
            });
        } catch (IOException ex) {
            Logger.getLogger(ParserYAMLUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
                Yaml yaml = new Yaml();
        String output = yaml.dump(propertyMap);
        return output;
    }

    public static String wsag2iagree(String content) {
        WsagParser parser = new WsagParser();
        AgreementModel model = parser.doParse(content);
        Translator translator = new Translator(new IAgreeBuilder());
        String iagree = translator.print(model);
        return iagree;
    }

    public static String iagree2wsag(String content) {
        IAgreeParser parser = new IAgreeParser();
        AgreementModel model = parser.doParse(content);
        IAgreeErrorListener errorListener = parser.getErrorListener();
        Translator translator = new Translator(new WSAGBuilder());
        String wsag = translator.print(model);
        return wsag;

    }
}
