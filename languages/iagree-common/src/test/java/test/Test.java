package test;

import es.us.isa.util.Conversion;
import es.us.isa.util.Util;

public class Test {

	public static void main(String[] args) {

		String sample = Util.loadSample("samples/example.txt");
		//String sample = loadSample("samples/AmazonS3 with Semantic Errors Template.iagree.template");
		//System.out.println(sample);

		System.out.println(Conversion.getWSAG(sample));		
	}
}
