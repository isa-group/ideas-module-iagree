package test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import es.us.isa.ideas.util.Convert;
import es.us.isa.ideas.util.Util;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import org.custommonkey.xmlunit.*;


public class Test {

	public static void main(String[] args) throws SAXException, IOException {

		String sample = Util.loadFile("samples/iagree/Compliant Offer.iagree.offer");
		String[] sample3 =convert2WSAG(sample);
		String sample4 = sample3[0];
		String sample2 = Util.loadFile("samples/wsag/Compliant Offer.xml");
		System.out.println("----------------------");
		System.out.println(sample4);
		System.out.println("----------------------");
		System.out.println(sample2);
		System.out.println("----------------------");

	
//		String myControlXML = "<struct><int>3</int><boolean>false</boolean></struct>";
//		String myTestXML = "<struct><boolean>false</boolean><int>3</int></struct>";
		Diff myDiff = new Diff(sample4, sample2);
		System.out.println("Antes del if");
		if (!myDiff.similar()) System.out.println("pieces of XML are similar " + myDiff);
		System.out.println("Entre el if");
		if(myDiff.identical()) System.out.println("but are they identical? " + myDiff);
		System.out.println("Despues del if");
	}
//		if(sampleObject.equals(sampleObject2)){
//			System.out.println("Funciona");
//		}else{
//			System.out.println("No funciona");
//		}

//	}
	
	public static String[] convert2WSAG(String sample){
		return Convert.getWsagFromIAgree(sample);
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
