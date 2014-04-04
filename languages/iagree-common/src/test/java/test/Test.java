package test;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import es.us.isa.util.Convert2IAgree;
import es.us.isa.util.Convert2Wsag;
import es.us.isa.util.Util;

public class Test {

	public static void main(String[] args) {

//		String sample = Util.loadSample("samples/Compliant Offer.iagree.offer");
//		convert2WSAG(sample);
		
		String sample2 = Util.loadSample("samples/AAA_Test.xml");
		String sample2_metrics = Util.loadSample("samples/AAA_Test_Metrics.xml");
		convert2IAgree(sample2, sample2_metrics);	
	}
	
	public static void convert2WSAG(String sample){
		PrintWriter writer, writerMetrics;
		try {
			writer = new PrintWriter("samples/AAA_Test.xml");
			writer.println(Convert2Wsag.getWsagFromIAgree(sample));
			writer.close();
			
			writerMetrics = new PrintWriter("samples/AAA_Test_Metrics.xml");
			writerMetrics.println(Convert2Wsag.getMetricsFromIAgree(sample));
			writerMetrics.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void convert2IAgree(String sample, String sample_metrics){
		PrintWriter writer;
		try {
			writer = new PrintWriter("samples/AAA_Test.txt");
			writer.println(Convert2IAgree.getIAgreeFromWSAG(sample, sample_metrics));
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
