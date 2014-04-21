package test;

import es.us.isa.ideas.util.Convert;
import es.us.isa.ideas.util.Util;

public class Test {

	public static void main(String[] args) {

		String sample = Util.loadFile("samples/iagree/example.txt");
		
		String sample2 = Util.loadFile("samples/S3Premium.xml");
		
		convert2WSAG(sample);
		convert2IAgree(sample2);
	}
	
	public static String[] convert2WSAG(String sample){
		return Convert.getWsagFromIAgree(sample);
	}
	
	public static String convert2IAgree(String sample){		
		return Convert.getIAgreeFromWsag(sample);
	}
}
