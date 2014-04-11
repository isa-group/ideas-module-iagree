package test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import es.us.isa.util.Convert;
import es.us.isa.util.Util;

public class Test {

	public static void main(String[] args) {

		String sample = Util.loadFile("samples/iagree/example.txt");
		convert2WSAG(sample);
		
//		String sample2 = Util.loadFile("samples/S3Premium.xml");
//		convert2IAgree(sample2);	
		
//		System.out.println(ConversionDelegate.convert("wsag", "iagree", "1234", sample2).getData());
		
	}
	
	public static void convert2WSAG(String sample){
		Convert.getWsagFromIAgree(sample);
	}
	
	public static void convert2IAgree(String sample){
		PrintWriter writer;
		try {
			writer = new PrintWriter("samples/AAA_Test.txt");
			writer.println(Convert.getIAgreeFromWsag(sample));
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
