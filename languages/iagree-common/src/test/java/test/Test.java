package test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import es.us.isa.util.Convert2IAgree;
import es.us.isa.util.Convert2Wsag;
import es.us.isa.util.Util;

public class Test {

	public static void main(String[] args) {

		String sample = Util.loadSample("samples/example.txt");
//		String sample = loadSample("samples/AmazonS3 with Semantic Errors Template.iagree.template");
//		System.out.println(sample);
//
//		System.out.println(Convert2Wsag.getWsagFromIAgree(sample));
		
//		PrintWriter writer;
//		try {
//			writer = new PrintWriter("samples/example.xml");
//			writer.println(Convert2Wsag.getWsagFromIAgree(sample));
//			writer.println(Convert2Wsag.getMetricsFromIAgree(sample));
//			writer.close();
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
		
		System.out.println(Convert2IAgree.getIAgreeFromWSAG(""));
		
	}
}
