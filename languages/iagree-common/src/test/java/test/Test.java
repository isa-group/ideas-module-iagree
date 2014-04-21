package test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import es.us.isa.ideas.util.Convert;
import es.us.isa.ideas.util.Util;

public class Test {

	public static void main(String[] args) {

		String sample = Util.loadFile("samples/iagree/example.txt");
		
//		String sample2 = Util.loadFile("samples/S3Premium.xml");
//		convert2IAgree(sample2);	
		
		convert2WSAG(sample);
		
	}
	
	public static String[] convert2WSAG(String sample){
		return Convert.getWsagFromIAgree(sample);
	}
	
	public static String convert2IAgree(String sample){
//		PrintWriter writer;
//		try {
//			writer = new PrintWriter("samples/AAA_Test.txt");
//			writer.println(Convert.getIAgreeFromWsag(sample));
//			writer.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
		return Convert.getIAgreeFromWsag(sample);
	}
}
