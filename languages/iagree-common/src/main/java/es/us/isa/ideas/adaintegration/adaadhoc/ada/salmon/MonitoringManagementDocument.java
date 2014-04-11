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

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;


public class MonitoringManagementDocument {
//	<monitoringManagementDocument>
//		<WebServiceInformation name>               // Información del servicio
//		  <description>...</description>
//		  <domain>...</domain>
//		  <wsdlURL>...</wsdlURL>
//		  <endpoint>...</endpoint>
//		  <operation opName>  // Permitimos n operations
//		           <soapAction>…</soapAction>
//		  </operation>
//		</WebServiceInformation>
//		<monitorConfiguration>
//		  <globalPeriodInit>...</globalPeriodInit>
//		  <globalPeriodEnd>...</globalPeriodEnd>
//		</monitorConfiguration>
//		// Métricas y medidas de servicio a monitorizar: RoundTimeTrip, Availability,....
//		<serviceMetric>                   // métricas de servicio: e.g. availability
//		  <metric>...</metric>
//		  <localPeriodInit>...</localPeriodInit>
//		  <localPeriodEnd>...</localPeriodEnd>
//		  <measure>
//		    <value>...</value>
//		           <timeStampInit>...</timeStampInit>
//		           <timeStampEnd>...</timeStampEnd>
//		   </measure>
//		</serviceMetric>
//		// Métricas y medidas de la operación a monitorizar
//		<operationMetric opName >                                 
//		  <metric>...</metric>        // métricas de la operación: e.g. response time of operation 1
//		  <localPeriodInit>...</localPeriodInit>
//		  <localPeriodEnd>...</localPeriodEnd>
//		  <measure>
//		           <value>...</value>
//		           <timeStampInit>...</timeStampInit>
//		           <timeStampEnd>...</timeStampEnd>
//		   </measure>
//		</operationMetric>
//		//... repetir para toda operación
//	</monitoringManagementDocument>
	
	private WebServiceInformation webServiceInformation;
	
	private MonitorConfiguration monitorConfiguration;

	private Collection<ServiceMetric> serviceMetrics;
	
	private Collection<OperationMetric> operationMetrics;
	
	public MonitoringManagementDocument(){
		serviceMetrics = new LinkedList<ServiceMetric>();
		operationMetrics = new LinkedList<OperationMetric>();
	}
	
	public MonitoringManagementDocument(String mmd){
		this();
		parseMMD(mmd);
	}
	
	public WebServiceInformation getWebServiceInformation() {
		return webServiceInformation;
	}

	public void setWebServiceInformation(WebServiceInformation webServiceInformation) {
		this.webServiceInformation = webServiceInformation;
	}

	public MonitorConfiguration getMonitorConfiguration() {
		return monitorConfiguration;
	}

	public void setMonitorConfiguration(MonitorConfiguration monitorConfiguration) {
		this.monitorConfiguration = monitorConfiguration;
	}

	public Collection<ServiceMetric> getServiceMetrics() {
		return serviceMetrics;
	}

	public void setServiceMetrics(Collection<ServiceMetric> serviceMetrics) {
		this.serviceMetrics = serviceMetrics;
	}
	
	public void addServiceMetric(ServiceMetric sm){
		this.serviceMetrics.add(sm);
	}

	public Collection<OperationMetric> getOperationMetrics() {
		return operationMetrics;
	}

	public void setOperationMetrics(Collection<OperationMetric> operationMetrics) {
		this.operationMetrics = operationMetrics;
	}
	
	public void addOperationMetric(OperationMetric om){
		this.operationMetrics.add(om);
	}
	
	public String toString(){
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
			Element root = doc.createElement("MonitoringManagementDocument");
			Element wsi = webServiceInformation.getAsDOMDocument().getDocumentElement();
			Element mc = monitorConfiguration.getAsDOMDocument().getDocumentElement();
			
			//añadimos los nodos hijos
			root.appendChild(doc.importNode(wsi, true));
			root.appendChild(doc.importNode(mc, true));
			
			//creamos y añadimos los service metric
			for(ServiceMetric sm:serviceMetrics){
				Element smElem = sm.getAsDOMDocument().getDocumentElement();
				root.appendChild(doc.importNode(smElem, true));
			}
			//creamos y añadimos los operation metric
			for(OperationMetric om:operationMetrics){
				Element omElem = om.getAsDOMDocument().getDocumentElement();
				root.appendChild(doc.importNode(omElem, true));
			}
			
			doc.appendChild(root);
		}catch (ParserConfigurationException e){
			e.printStackTrace();
		}catch (NullPointerException e){
			e.printStackTrace();
		}
		return doc;
	}
	
	private void parseMMD(String mmd){
		//Creamos el documento DOM
		Document documentMMD = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			InputStream is = new ByteArrayInputStream(mmd.getBytes());
			InputSource source = new InputSource(is);
			builder = factory.newDocumentBuilder();
			documentMMD = builder.parse(source);
		} catch (Exception e) {
			System.err.println("Error while opening the monitoring management document");
		}
		//Si el documento tiene información empezamos a recorrerlo y parseamos
		NodeList rootNode = documentMMD.getChildNodes();
		if (rootNode.getLength() != 0) {
			Node root = rootNode.item(0);
			if(root.getNodeName().equalsIgnoreCase("MonitoringManagementDocument")){
				NodeList childNodes = root.getChildNodes();
				for(int i=0; i<childNodes.getLength(); i++){
					Node nextChild = childNodes.item(i);
					if (nextChild.getNodeType() == Node.ELEMENT_NODE) {
						if (nextChild.getNodeName().equalsIgnoreCase("WebServiceInformation")) {
							String name = "", description = "", domain = "", wsdlURL = "", endpoint = "";
							Map<String, String> operations = new HashMap<String, String>();

							NamedNodeMap attbs = nextChild.getAttributes();
							Node wsiName = attbs.getNamedItem("name");
							name = wsiName.getNodeValue();

							NodeList wsiChildNodes = nextChild.getChildNodes();
							for (int j = 0; j < wsiChildNodes.getLength(); j++) {
								Node nextWsiChild = wsiChildNodes.item(j);
								if (nextWsiChild.getNodeType() == Node.ELEMENT_NODE) {
									if (nextWsiChild.getNodeName().equalsIgnoreCase("description")) {
										description = nextWsiChild.getTextContent();
									} else if (nextWsiChild.getNodeName().equalsIgnoreCase("domain")) {
										domain = nextWsiChild.getTextContent();
									} else if (nextWsiChild.getNodeName().equalsIgnoreCase("wsdlURL")) {
										wsdlURL = nextWsiChild.getTextContent();
									} else if (nextWsiChild.getNodeName().equalsIgnoreCase("endpoint")) {
										endpoint = nextWsiChild.getTextContent();
									} else if (nextWsiChild.getNodeName().equalsIgnoreCase("operation")) {
										NamedNodeMap opAttbs = nextWsiChild.getAttributes();
										Node opName = opAttbs.getNamedItem("opName");
										NodeList opChildNodes = nextWsiChild.getChildNodes();
										for(int k=0; k<opChildNodes.getLength(); k++){
											Node soapActionNode = opChildNodes.item(k);
											if(soapActionNode.getNodeType() == Node.ELEMENT_NODE){
												if(soapActionNode.getNodeName().equalsIgnoreCase("soapAction")){
													operations.put(opName.getNodeValue(), soapActionNode.getTextContent());
												}
											}
										}
									}
								}
							}
							this.webServiceInformation = new WebServiceInformation(name, description, domain, wsdlURL, endpoint, operations);
						} else if (nextChild.getNodeName().equalsIgnoreCase("ServiceMetric")) {
							String metric = "", localPeriodInit = "", localPeriodEnd = "";
							List<Measure> measures = new LinkedList<Measure>();

							NodeList smChildNodes = nextChild.getChildNodes();
							for (int j = 0; j < smChildNodes.getLength(); j++) {
								Node smChild = smChildNodes.item(j);
								if(smChild.getNodeType() == Node.ELEMENT_NODE){
									if (smChild.getNodeName().equalsIgnoreCase("metric")) {
										metric = smChild.getTextContent();
									} else if (smChild.getNodeName().equalsIgnoreCase("localPeriodInit")) {
										localPeriodInit = smChild.getTextContent();
									} else if (smChild.getNodeName().equalsIgnoreCase("localPeriodEnd")) {
										localPeriodEnd = smChild.getTextContent();
									} else if (smChild.getNodeName().equalsIgnoreCase("measure")) {
										Measure measure = new Measure();
										NodeList measureChildNodes = smChild.getChildNodes();
										for (int k = 0; k < measureChildNodes.getLength(); k++) {
											Node measureChild = measureChildNodes.item(k);
											if (measureChild.getNodeName().equalsIgnoreCase("value")) {
												measure.setValue(measureChild.getTextContent());
											} else if (measureChild.getNodeName().equalsIgnoreCase("timeStampInit")) {
												measure.setTimeStampInit(measureChild.getTextContent());
											} else if (measureChild.getNodeName().equalsIgnoreCase("timeStampEnd")) {
												measure.setTimeStampEnd(measureChild.getTextContent());
											}
										}
										measures.add(measure);
									}
								}
							}
							ServiceMetric auxSM = new ServiceMetric(metric, localPeriodInit, localPeriodEnd);
							auxSM.setMeasures(measures);
							this.serviceMetrics.add(auxSM);
						} else if (nextChild.getNodeName().equalsIgnoreCase("OperationMetric")) {
							String opName = "", metric = "", localPeriodInit = "", localPeriodEnd = "";
							List<Measure> measures = new LinkedList<Measure>();
							
							NamedNodeMap attbs = nextChild.getAttributes();
							Node opNameNode = attbs.getNamedItem("opName");
							opName = opNameNode.getNodeValue();

							NodeList omChildNodes = nextChild.getChildNodes();
							for (int j = 0; j < omChildNodes.getLength(); j++) {
								Node omChild = omChildNodes.item(j);
								if(omChild.getNodeType() == Node.ELEMENT_NODE){
									if (omChild.getNodeName().equalsIgnoreCase("metric")) {
										metric = omChild.getTextContent();
									} else if (omChild.getNodeName().equalsIgnoreCase("localPeriodInit")) {
										localPeriodInit = omChild.getTextContent();
									} else if (omChild.getNodeName().equalsIgnoreCase("localPeriodEnd")) {
										localPeriodEnd = omChild.getTextContent();
									} else if (omChild.getNodeName().equalsIgnoreCase("measure")) {
										Measure measure = new Measure();
										NodeList measureChildNodes = omChild.getChildNodes();
										for (int k = 0; k < measureChildNodes.getLength(); k++) {
											Node measureChild = measureChildNodes.item(k);
											if (measureChild.getNodeName().equalsIgnoreCase("value")) {
												measure.setValue(measureChild.getTextContent());
											} else if (measureChild.getNodeName().equalsIgnoreCase("timeStampInit")) {
												measure.setTimeStampInit(measureChild.getTextContent());
											} else if (measureChild.getNodeName().equalsIgnoreCase("timeStampEnd")) {
												measure.setTimeStampEnd(measureChild.getTextContent());
											}
										}
										measures.add(measure);
									}
								}
							}
							OperationMetric om = new OperationMetric(opName, metric, localPeriodInit, localPeriodEnd);
							om.setMeasures(measures);
							this.operationMetrics.add(om);
						} else if (nextChild.getNodeName().equalsIgnoreCase("MonitorConfiguration")) {
							String globalPeriodInit = "", globalPeriodEnd = "";

							NodeList mcChildNodes = nextChild.getChildNodes();
							for (int j = 0; j < mcChildNodes.getLength(); j++) {
								Node mcChild = mcChildNodes.item(j);
								if (mcChild.getNodeName().equalsIgnoreCase("globalPeriodInit")) {
									globalPeriodInit = mcChild.getTextContent();
								} else if (mcChild.getNodeName().equalsIgnoreCase("globalPeriodEnd")) {
									globalPeriodEnd = mcChild.getTextContent();
								}
							}
							this.monitorConfiguration = new MonitorConfiguration(globalPeriodInit, globalPeriodEnd);
						}
					}
				}
			}
		}
	}
}
