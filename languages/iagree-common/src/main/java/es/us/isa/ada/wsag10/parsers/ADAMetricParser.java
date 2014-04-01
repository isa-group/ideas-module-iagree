/**
 * 	This file is part of ADA.
 *
 *     ADA is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     ADA is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with ADA.  If not, see <http://www.gnu.org/licenses/>.
 */

package es.us.isa.ada.wsag10.parsers;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.us.isa.ada.wsag10.domain.DefaultConstantConverter;
import es.us.isa.ada.wsag10.domain.Domain;
import es.us.isa.ada.wsag10.domain.EnumeratedDomain;
import es.us.isa.ada.wsag10.domain.IntegerDomain;
import es.us.isa.ada.wsag10.domain.IntegerRange;
import es.us.isa.ada.wsag10.domain.RealDomain;
import es.us.isa.ada.wsag10.domain.RealRange;


public class ADAMetricParser implements MetricParser {
	
	protected static final int MIN_INT = -1000;
	protected static final int MAX_INT = 1000;
	private boolean newMetricFile;
	protected Document metricXML;


	public Domain getValue(String metric) {
		Domain d = null;

		if (metric.equals("xsd:int") || metric.equals("xsd:integer")) {
			IntegerDomain auxRes = new IntegerDomain();
			IntegerRange range = new IntegerRange(MIN_INT, MAX_INT);
			auxRes.addRange(range);
			d = auxRes;
		} else {
			String fileName;
			if(metric.endsWith(".xml")){
				fileName = metric.substring(0, metric.lastIndexOf(":"));
			}else{
				fileName = metric.substring(0, metric.lastIndexOf(":")).concat(".xml");
			}
			//fileName = "C:/Users/Antonio/workspaceICSOC/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/iAgreeStudioServerComponent/"+fileName;
			//fileName = "/usr/share/tomcat6/webapps/iAgreeStudioServerComponent/"+fileName;
			//fileName = "C:/workspaceADA/iAgreeStudioServerComponent/"+fileName;
			//fileName = "C:/Program Files/Apache Software Foundation/Tomcat 7.0/webapps/iAgreeStudioServerComponent/"+fileName;
			
			
			String elementName = metric.substring(metric.lastIndexOf(":") + 1);
			loadXML(fileName);
			//System.out.println("Fichero "+fileName+"-Busco "+elementName);
			
			d = findValue(elementName);

			
		}

		return d;
	}

	private void loadXML(String metricFileName) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder;

		try {
			builder = factory.newDocumentBuilder();
			metricXML = builder.parse(metricFileName);
			NodeList featureList = metricXML.getChildNodes();

			Node root = featureList.item(0);
			if (root.getNodeName().equalsIgnoreCase("metricXML")){
				newMetricFile = false;
			}
			else if (root.getNodeName().equalsIgnoreCase("met:metricXML")){
				newMetricFile = true;
			}
		} catch (Exception e) {
			metricXML = null;
			System.err
					.println("Error while opening the metric file!. Revise the file path, please");
		}
	}

	public Domain findValue(String var) {
		if (newMetricFile){
			return newFindValue(var);
		}
		else{
			return oldFindValue(var);
		}
	}
	
	public Domain oldFindValue(String var){
		Domain res = null;

		if (metricXML == null)
			return null;

		// checks if the file is not empty
		NodeList featureList = metricXML.getChildNodes();
		if (featureList.getLength() == 0) {
			return null;
		}

		Node root = featureList.item(0);
		if (!root.getNodeName().equalsIgnoreCase("metricXML")) {
			return null;
		}

		NodeList childNodes = root.getChildNodes();
		// all param nodes are passed.

		Boolean found = false;
		for (int i = 0; i < childNodes.getLength() && found == false; i++) {
			Node nextNode = childNodes.item(i);
			if (nextNode.getNodeType() == Node.ELEMENT_NODE) {
				if (nextNode.getNodeName().equalsIgnoreCase(var)) {
					found = true;
					String type = nextNode.getAttributes().getNamedItem("type").getNodeValue();
					
					
					if (type.equalsIgnoreCase("integer")){
						IntegerDomain auxRes = new IntegerDomain();
						
						NodeList nl1 = nextNode.getChildNodes();
						
						if (nl1.getLength()  == 0){
							String sMin = nextNode.getAttributes().getNamedItem("min").getNodeValue();
							String sMax = nextNode.getAttributes().getNamedItem("max").getNodeValue();
							int min = Integer.parseInt(sMin);
							int max = Integer.parseInt(sMax);
							IntegerRange range = new IntegerRange(min, max);
							auxRes.addRange(range);
						}
						else{
							for (int j = 0; j < nl1.getLength(); j++){
								Node n1 = nl1.item(j);
								if (n1.getNodeType() == Node.ELEMENT_NODE && n1.getNodeName().equals("Domain")){
									NamedNodeMap atts = n1.getAttributes();
									String sMin = atts.getNamedItem("min").getNodeName();
									String sMax = atts.getNamedItem("max").getNodeName();
									int min = Integer.parseInt(sMin);
									int max = Integer.parseInt(sMax);
									IntegerRange range = new IntegerRange(min, max);
									auxRes.addRange(range);
								}
							}
						}
						res = auxRes;
					}
					else if (type.equalsIgnoreCase("real")){
						RealDomain auxRes = new RealDomain();
						
						NodeList nl1 = nextNode.getChildNodes();
						for (int j = 0; j < nl1.getLength(); j++){
							Node n1 = nl1.item(j);
							if (n1.getNodeType() == Node.ELEMENT_NODE && n1.getNodeName().equals("Domain")){
								NamedNodeMap atts = n1.getAttributes();
								String sMin = atts.getNamedItem("min").getNodeName();
								String sMax = atts.getNamedItem("max").getNodeName();
								double min = Double.parseDouble(sMin);
								double max = Double.parseDouble(sMax);
								RealRange range = new RealRange(min, max);
								auxRes.addRange(range);
							}
						}
						res = auxRes;
					}
					else if (type.equalsIgnoreCase("enumerated")){
						EnumeratedDomain auxRes = new EnumeratedDomain(DefaultConstantConverter.getInstance());
						
						NodeList nl1 = nextNode.getChildNodes();
						for (int j = 0; j < nl1.getLength(); j++){
							Node n1 = nl1.item(j);
							if (n1.getNodeType() == Node.ELEMENT_NODE && n1.getNodeName().equals("Value")){
								String value = n1.getTextContent();
								auxRes.addValue(value);
							}
						}
						res = auxRes;
					}
				}
			}
		}

		return res;
	}
	
	public Domain newFindValue(String var) {
		Domain res = null;

		if (metricXML == null)
			return null;

		// checks if the file is not empty
		NodeList featureList = metricXML.getChildNodes();
		if (featureList.getLength() == 0) {
			return null;
		}

		Node root = featureList.item(0);
		if (!root.getNodeName().equalsIgnoreCase("met:metricXML")) {
			return null;
		}

		NodeList childNodes = root.getChildNodes();
		// all param nodes are passed.

		Boolean found = false;
		for (int i = 0; i < childNodes.getLength() && found == false; i++) {
			Node nextNode = childNodes.item(i);
			if (nextNode.getNodeType() == Node.ELEMENT_NODE && nextNode.getNodeName().equalsIgnoreCase("met:metric")) {
				String id = nextNode.getAttributes().getNamedItem("id").getNodeValue();
				
				if (id.equals(var)){
					NamedNodeMap atts = nextNode.getAttributes();
					String type = atts.getNamedItem("type").getNodeValue();
					if (type.equalsIgnoreCase("integer")){
						String sMin = atts.getNamedItem("min").getNodeValue();
						String sMax = atts.getNamedItem("max").getNodeValue();
						IntegerDomain auxRes = new IntegerDomain();
						int min = Integer.parseInt(sMin);
						int max = Integer.parseInt(sMax);
						IntegerRange range = new IntegerRange(min, max);
						auxRes.addRange(range);
						res = auxRes;
					}
					else if (type.equalsIgnoreCase("enumerated")){
						EnumeratedDomain auxRes = new EnumeratedDomain(DefaultConstantConverter.getInstance());
						
						NodeList nl1 = nextNode.getChildNodes();
						for (int j = 0; j < nl1.getLength(); j++){
							Node n1 = nl1.item(j);
							if (n1.getNodeType() == Node.ELEMENT_NODE && n1.getNodeName().equals("met:value")){
								String value = n1.getAttributes().getNamedItem("value").getNodeValue();
								auxRes.addValue(value);
							}
						}
						res = auxRes;
					}
					
				}
			}
		}

		return res;
	}

//	public Domain findOldValue(String var){
//		Domain res = null;
//
//		if (metricXML == null)
//			return null;
//
//		// checks if the file is not empty
//		NodeList featureList = metricXML.getChildNodes();
//		if (featureList.getLength() == 0) {
//			return null;
//		}
//
//		Node root = featureList.item(0);
//		if (!root.getNodeName().equalsIgnoreCase("metricXML")) {
//			return null;
//		}
//
//		NodeList childNodes = root.getChildNodes();
//		// all param nodes are passed.
//
//		Boolean found = false;
//		for (int i = 0; i < childNodes.getLength() && found == false; i++) {
//			Node nextNode = childNodes.item(i);
//			if (nextNode.getNodeType() == Node.ELEMENT_NODE) {
//				if (nextNode.getNodeName().equalsIgnoreCase(var)) {
//					found = true;
//					String type = nextNode.getAttributes().getNamedItem("type").getNodeValue();
//					String sMin = nextNode.getAttributes().getNamedItem("min").getNodeValue();
//					String sMax = nextNode.getAttributes().getNamedItem("max").getNodeValue();
//					
//					if (type.equalsIgnoreCase("integer")){			
//						int min = Integer.parseInt(sMin);
//						int max = Integer.parseInt(sMax);
//						IntegerRange range = new IntegerRange(min, max);
//						IntegerDomain auxRes = new IntegerDomain();
//						auxRes.addRange(range);
//						res = auxRes;
//					}
//					else if (type.equalsIgnoreCase("real")){
//						double min = Double.parseDouble(sMin);
//						double max = Double.parseDouble(sMax);
//						RealRange range = new RealRange(min, max);
//						RealDomain auxRes = new RealDomain();
//						auxRes.addRange(range);
//						res = auxRes;
//					}
//				}
//			}
//		}
//
//		return res;
//	}
	
}
