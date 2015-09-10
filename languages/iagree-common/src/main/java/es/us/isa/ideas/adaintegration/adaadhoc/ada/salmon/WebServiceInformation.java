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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.salmon;

import java.util.Map;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class WebServiceInformation {
	
//	<WebServiceInformation name>               // Informaci-n del servicio
//	  <description>...</description>
//	  <domain>...</domain>
//	  <wsdlURL>...</wsdlURL>
//	  <endpoint>...</endpoint>
//	  <operation opName>  // Permitimos n operations
//	           <soapAction>-</soapAction>
//	  </operation>
//	</WebServiceInformation>
	
	private String name;
	
	private String description;
	
	private String domain;
	
	private String wsdlURL;
	
	private String endpoint;
	
	private Map<String, String> operations; //key = name, value = soapaction
	
	public WebServiceInformation(String name, String description, String domain, String wsdlURL, String endpoint, Map<String, String> operations){
		this.name = name;
		this.description = description;
		this.domain = domain;
		this.wsdlURL = wsdlURL;
		this.endpoint = endpoint;
		this.operations = operations;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getDomain() {
		return domain;
	}

	public String getWsdlURL() {
		return wsdlURL;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public Map<String, String> getOperations() {
		return operations;
	}
	
	public String toString(){
//		String tabulador = "  ";
//		String wsiAsXML = "<WebServiceInformation name=\""+name+"\">";
//		wsiAsXML+="\n"+tabulador+"<description>"+description+"</description>";
//		wsiAsXML+="\n"+tabulador+"<domain>"+domain+"</domain>";
//		wsiAsXML+="\n"+tabulador+"<wsdlURL>"+wsdlURL+"</wsdlURL>";
//		wsiAsXML+="\n"+tabulador+"<endpoint>"+endpoint+"</endpoint>";
//		for(Entry<String, String> e: this.operations.entrySet()){
//			wsiAsXML+="\n"+tabulador+"<operation name=\""+e.getKey()+"\">";
//			wsiAsXML+="\n"+tabulador+tabulador+"<soapAction>"+e.getValue()+"</soapAction>";
//			wsiAsXML+="\n"+tabulador+"</operation>";
//		}
//		wsiAsXML+="\n</WebServiceInformation>";
//		return wsiAsXML;
		Document doc = getAsDOMDocument();
		String result = Utils.DOM2String(doc);
		return result;
	}
	
	public Document getAsDOMDocument(){
		Document doc = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.newDocument();
			
			//creamos todos los nodos
			Element root = doc.createElement("WebServiceInformation");
			Element descriptionElement = doc.createElement("description");
			Element domainElement = doc.createElement("domain");
			Element wsdlURLElement = doc.createElement("wsdlURL");
			Element endpointElement = doc.createElement("endpoint");
			
			//damos valor a los que lo requieran
			root.setAttribute("name", name);
			descriptionElement.setTextContent(description);
			domainElement.setTextContent(domain);
			wsdlURLElement.setTextContent(wsdlURL);
			endpointElement.setTextContent(endpoint);
			
			//a-adimos los nodos de "WebServiceInformation"
			root.appendChild(descriptionElement);
			root.appendChild(domainElement);
			root.appendChild(wsdlURLElement);
			root.appendChild(endpointElement);
			//por cada operaci-n a-adimos un nodo
			for(Entry<String, String> e: this.operations.entrySet()){
				root.appendChild(getOperation(doc, e.getKey(), e.getValue()));
			}
			
			doc.appendChild(root);
		}catch (ParserConfigurationException e){
			e.printStackTrace();
		}
		return doc;
	}
	
	public Boolean equals(WebServiceInformation wsi){
		Boolean areEquals = Boolean.FALSE;
		if(this.name.equalsIgnoreCase(wsi.getName()) && this.description.equalsIgnoreCase(wsi.getDescription()) && this.domain.equalsIgnoreCase(wsi.getDomain()) && this.endpoint.equalsIgnoreCase(wsi.getEndpoint()) && this.wsdlURL.equalsIgnoreCase(wsi.getWsdlURL())){
			areEquals = Boolean.TRUE;
		}
		return areEquals;
	}
	
	private Element getOperation(Document doc, String opName, String soapAct){
		Element operationElement = doc.createElement("operation");
		Element soapActionElement = doc.createElement("soapAction");
		
		operationElement.setAttribute("opName", opName);
		soapActionElement.setTextContent(soapAct);
		
		operationElement.appendChild(soapActionElement);
		
		return operationElement;
	}
}