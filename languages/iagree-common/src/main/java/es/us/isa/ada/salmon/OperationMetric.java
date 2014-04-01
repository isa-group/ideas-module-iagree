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

package es.us.isa.ada.salmon;

import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class OperationMetric {
//	<operationMetric opName >                                 
//	  <metric>...</metric>        // m�tricas de la operaci�n: e.g. response time of operation 1
//	  <localPeriodInit>...</localPeriodInit>
//	  <localPeriodEnd>...</localPeriodEnd>
//	  <measure>
//	           <value>...</value>
//	           <timeStampInit>...</timeStampInit>
//	           <timeStampEnd>...</timeStampEnd>
//	   </measure>
//	</operationMetric>
	
	private String opName;
	
	private String metric;
	
	private String localPeriodInit;
	
	private String localPeriodEnd;
	
	private List<Measure> measures;
	
	public OperationMetric(String opName, String metric, String localPeriodInit, String localPeriodEnd){
		this.opName = opName;
		this.metric = metric;
		this.localPeriodInit = localPeriodInit;
		this.localPeriodEnd = localPeriodEnd;
		this.measures = new LinkedList<Measure>();
	}
	
	public String getOpName() {
		return opName;
	}
	
	public String getMetric() {
		return metric;
	}
	
	public String getLocalPeriodInit() {
		return localPeriodInit;
	}
	
	public String getLocalPeriodEnd() {
		return localPeriodEnd;
	}

	public List<Measure> getMeasures() {
		return measures;
	}
	
	public void setMeasures(List<Measure> measures){
		this.measures = measures;
	}

	public void addMeasure(Measure measure) {
		this.measures.add(measure);
	}
	
	public Document getAsDOMDocument(){
		Document doc = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.newDocument();
			
			//creamos todos los nodos
			Element operationMetric = doc.createElement("operationMetric");
			Element metricElement = doc.createElement("metric");
			Element localPeriodInitElement = doc.createElement("localPeriodInit");
			Element localPeriodEndElement = doc.createElement("localPeriodEnd");
			
			//damos valor a los que lo requieren
			operationMetric.setAttribute("opName", opName);
			metricElement.setTextContent(metric);
			localPeriodInitElement.setTextContent(localPeriodInit);
			localPeriodEndElement.setTextContent(localPeriodEnd);
			
			//a�adimos los hijos de "operationMetric"
			operationMetric.appendChild(metricElement);
			operationMetric.appendChild(localPeriodInitElement);
			operationMetric.appendChild(localPeriodEndElement);
			//a�adimos todas las measures
			if(!measures.isEmpty()){
				for(Measure m:measures){
					operationMetric.appendChild(doc.importNode(m.getAsDOMDocument().getDocumentElement(), true));
				}
			}			
			
			doc.appendChild(operationMetric);
		}catch (ParserConfigurationException e){
			e.printStackTrace();
		}
		return doc;
	}
}
