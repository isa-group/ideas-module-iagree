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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.parsers;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.salmon.WebServiceInformation;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Restriction;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.ServiceDescriptionTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Variable;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.domain.Domain;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.timeAwareWsag.TimeAwareServiceDescriptionTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.RealTemporalInterval;

public class ADASDTParser implements SDTParser {

	private Map<String,Variable> vars;
	
	private TimeAwareParser taParser;
	
	public ADASDTParser(){
		this.taParser = null;
	}
	
	public ADASDTParser(TimeAwareParser taParser){
		this.taParser = taParser;
	}
	
	public void setVars(Map<String,Variable> variables){
		vars = variables;
	}
	
	@Override
	public ServiceDescriptionTerm parseSDT(Node n) {
		TimeAwareServiceDescriptionTerm sdt = null;
		if (n.getNodeType() == Node.ELEMENT_NODE) {
			if (n.getNodeName().equalsIgnoreCase("wsag:ServiceDescriptionTerm")) {
				sdt = new TimeAwareServiceDescriptionTerm();
				sdt.setTermName(n.getAttributes().getNamedItem("wsag:Name")
						.getNodeValue());
				sdt.setServiceName(n.getAttributes().getNamedItem(
						"wsag:ServiceName").getNodeValue());

				/*
				 * if (!rootServiceFeature.getNodeName().equalsIgnoreCase(
				 * "ServiceFeatures")) { } else {
				 * 
				 * NodeList serviceFeaturesNodes = rootServiceFeature
				 * .getChildNodes();
				 */
				NodeList serviceFeaturesRootNodes = n.getChildNodes();
				Node rootServiceFeature = serviceFeaturesRootNodes.item(1);
				NodeList serviceFeaturesNodes;
				if (rootServiceFeature.getNodeName().equalsIgnoreCase(
						"ServiceFeatures")) {
					serviceFeaturesNodes = rootServiceFeature.getChildNodes();
				} else {
//					throw new IllegalArgumentException("No ServiceFeatures tag found");
					serviceFeaturesNodes = serviceFeaturesRootNodes;
				}

				for (int j = 0; j < serviceFeaturesNodes.getLength(); j++) {
					Node nextFeatureNode = serviceFeaturesNodes.item(j);

					// TODO aï¿½adir aki el sugar syntax de los SDT

					if (nextFeatureNode.getNodeType() == Node.ELEMENT_NODE) {
						String nodeName = nextFeatureNode.getNodeName();
						if (nodeName.equalsIgnoreCase("OfferItem")) {
							String name = nextFeatureNode.getAttributes()
									.getNamedItem("name").getTextContent();
							Node auxNode = nextFeatureNode.getAttributes()
									.getNamedItem("wsag:Metric");
							// XXX no se permite que a una variable que ya haya
							// sido declarada
							// en los ServiceProperties se le asigne un metric
							// en el SDT
							if (auxNode != null) {
								// si la variable ya existe, vemos que el metric
								// sea el mismo
								// si es distinto, lanzamos excepcion
								String metric = auxNode.getTextContent();
//								int index = metric.lastIndexOf(":");
//								String metricFile = metric.substring(0, index)
//										+ ".xml";
//								String metricDomain = metric.substring(
//										index + 1, metric.length());
////								MetricParser mp = new ADAMetricParser(metricFile);
////								openMetricXML(metricFile);
//								String[] vals = mp.getValue(metricDomain);
////								String[] vals = getValue(metricDomain);
								MetricParser mp = new ADAMetricParser();
								mp.getValue(metric);
								Domain d = mp.getValue(metric);
								Variable varAux = null;
								if ((varAux = vars.get(name)) != null) {
									if (!varAux.getDomain().equals(d)) {
										// si la variable se llama igual
										// pero no se referencia
										// el mismo dominio, error

										// para que pete, la pondremos
										// de nuevo y asi sera
										// reconocida como una vble
										// duplicada :)
										Variable v = new Variable();
										v.setUniqueName(name);
										v.setDomain(d);
										Restriction cons = new Restriction();
										cons.setFixedValue(nextFeatureNode
												.getTextContent().trim());
										sdt.setFeature(v,cons);
//										sdt.setFeature(v, nextFeatureNode
//												.getTextContent());
									} else {
										// si es la misma vble con el
										// mismo metric, no hacemos nada
										// pues ya esta metida
										Restriction cons = new Restriction();
										cons.setFixedValue(nextFeatureNode
												.getTextContent());
										sdt.setFeature(name,cons);
//										sdt.setFeature(name, nextFeatureNode
//												.getTextContent());
									}
								} else {
									Variable v = new Variable();
									v.setUniqueName(name);
									v.setDomain(d);
									Restriction cons = new Restriction();
									cons.setFixedValue(nextFeatureNode
											.getTextContent().trim());
									sdt.setFeature(v,cons);
//									sdt.setFeature(v, nextFeatureNode
//											.getTextContent());
								}

							} else {
								Restriction cons = new Restriction();
								cons.setFixedValue(nextFeatureNode
										.getTextContent().trim());
								sdt.setFeature(name,cons);
//								sdt.setFeature(name, nextFeatureNode
//										.getTextContent());
							}

						}else if(nodeName.equalsIgnoreCase("twsag4people:ValidityPeriod")){
							if(taParser == null){
								System.err.println("Se está intentando parsear un ValidityPeriod en un SDT y el parser de SDT no tiene referencia del parser de temporalidad");
							}else{
								RealTemporalInterval rti = taParser.parseValidityPeriod(nextFeatureNode);
								sdt.setValidityPeriod(rti);
							}
						}else{
							if(nodeName.equalsIgnoreCase("WebServiceInformation")){
								WebServiceInformation wsi = parseWebServiceInformation(nextFeatureNode);
								sdt.setWebServiceInformation(wsi);
							}else{
								Restriction cons = new Restriction();
								cons.setFixedValue(nextFeatureNode
										.getTextContent());
								sdt.setFeature(nextFeatureNode.getNodeName(), cons);
//								sdt.setFeature(nextFeatureNode.getNodeName(),
//										nextFeatureNode.getTextContent());
							}
						}

					}
				}

			}
		}
		if(sdt.getValidityPeriod() == null){
			return (ServiceDescriptionTerm) sdt;
		}
		return sdt;
	}
	
	private WebServiceInformation parseWebServiceInformation(Node n){
		String wsiName = "", wsiDescription = "", wsiDomain = "", wsiWsdlURL = "", wsiEndpoint = "", opName = "";
		Map<String, String> wsiOperations = new HashMap<String, String>();
		
		wsiName = n.getAttributes().getNamedItem("name").getTextContent();
		NodeList wsiNodes = n.getChildNodes();
		for(int i=0; i<wsiNodes.getLength(); i++){
			Node node = wsiNodes.item(i);
			if(node.getNodeType() == Node.ELEMENT_NODE){
				String nodeName = node.getNodeName();
				if(nodeName.equalsIgnoreCase("Description")){
					wsiDescription = node.getTextContent();
				}else if(nodeName.equalsIgnoreCase("Domain")){
					wsiDomain = node.getTextContent();
				}else if(nodeName.equalsIgnoreCase("wsdlURL")){
					wsiWsdlURL = node.getTextContent();
				}else if(nodeName.equalsIgnoreCase("endpoint")){
					wsiEndpoint = node.getTextContent();
				}else if(nodeName.equalsIgnoreCase("operation")){
					opName = node.getAttributes().getNamedItem("opName").getTextContent();
					NodeList childNodes = node.getChildNodes();
					for(int j=0; j < childNodes.getLength(); j++){
						Node auxNode = childNodes.item(j);
						String auxNodeName = auxNode.getNodeName();
						if (auxNode.getNodeType() == Node.ELEMENT_NODE) {
							if (auxNodeName.equalsIgnoreCase("soapAction")) {
								String soapAction = auxNode.getTextContent();
								wsiOperations.put(opName, soapAction);
							}
						}
					}
				}
			}
		}
		WebServiceInformation wsi = new WebServiceInformation(wsiName, wsiDescription, wsiDomain, wsiWsdlURL, wsiEndpoint, wsiOperations);
		return wsi;
	}
}