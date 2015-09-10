package test;

import java.io.IOException;
import java.util.Map;

import org.xml.sax.SAXException;

import es.us.isa.ideas.util.Convert;
import es.us.isa.ideas.util.Util;



public class Test {

	public static void main(String[] args) throws SAXException, IOException {
		
		String sample = Util.loadFile("samples/iagree/test_penalty.iagreetemplate");
		String data = (String) convert2WSAG(sample).get("data");
		//System.out.println(data);
		
		
		String result = convert2iAgree(data);
		System.out.println(result);
	}

	
	public static Map<String, Object> convert2WSAG(String sample){
		return Convert.getWsagFromIAgree(sample, false);
	}
	
	public static String convert2iAgree(String sample){
		return Convert.getIAgreeFromWsag(sample);
	}
	
}
