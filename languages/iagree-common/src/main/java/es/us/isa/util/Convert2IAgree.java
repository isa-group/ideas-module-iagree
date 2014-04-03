package es.us.isa.util;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.us.isa.error.IAgreeError;

public class Convert2IAgree {

	private static List<IAgreeError> errors = new LinkedList<IAgreeError>();

	public static String getIAgreeFromWSAG(String code) {

		try {
			File fXmlFile = new File("samples/example.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			
			doc.getDocumentElement().normalize();
			
			Element root = doc.getDocumentElement();
			
			if(root.getNodeName().equals("wsag:Template")){
				String name = doc.getElementsByTagName("wsag:Name").item(0).getTextContent();
				String version = root.getAttribute("wsag:TemplateId");
				
				String result = "Template " + name + " version " + version + "\n";
				
				result += getContext(doc);				
				
				System.out.println(result);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}
	
	public static String getContext(Document doc){
		String result="";
		Node context = doc.getElementsByTagName("wsag:Context").item(0);
		Node responder = doc.getElementsByTagName("wsag:AgreementResponder").item(0);
		if(responder!=null)
			result += "\t" + responder.getTextContent() + " as Responder\n";
		
		Node dateFormat = doc.getElementsByTagName("twsag4people:DateFormat").item(0);
		if(dateFormat!=null)
			result += "\tDateFormat: " + dateFormat.getTextContent() + "\n";
		
		Node GMTZone = doc.getElementsByTagName("wsag:GMTZone").item(0);
		if(GMTZone!=null)
			result += "\tGMTZone: " + GMTZone.getTextContent() + "\n";
		
		Node GlobalPeriod = doc.getElementsByTagName("twsag4people:GlobalPeriod").item(0);
		if(GlobalPeriod!=null)
			result += "\tGlobalPeriod: " + GlobalPeriod.getTextContent() + "\n";
		
		return result;
	}
}
