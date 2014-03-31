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

import java.util.Collection;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ServiceMetric {

//	<serviceMetric>                   // métricas de servicio: e.g. availability
//	  <metric>...</metric>
//	  <localPeriodInit>...</localPeriodInit>
//	  <localPeriodEnd>...</localPeriodEnd>
//	  <measure>
//	    <value>...</value>
//	           <timeStampInit>...</timeStampInit>
//	           <timeStampEnd>...</timeStampEnd>
//	   </measure>
//	</serviceMetric>
	
	private String metric;
	
	private String localPeriodInit;
	
	private String localPeriodEnd;
	
	private Collection<Measure> measures;
	
	public ServiceMetric(String metric, String localPeriodInit, String localPeriodEnd){
		this.metric = metric;
		this.localPeriodInit = localPeriodInit;
		this.localPeriodEnd = localPeriodEnd;
		this.measures = new LinkedList<Measure>();
	}
	
	public String getMetric(){
		return metric;
	}
	
	public String getLocalPeriodInit(){
		return localPeriodInit;
	}
	
	public String getLocalPeriodEnd(){
		return localPeriodEnd;
	}
	
	public Collection<Measure> getMeasures(){
		return measures;
	}
	
	public void setMeasures(Collection<Measure> measures){
		this.measures = measures;
	}
	
	public void addMeasure(Measure measure){
		this.measures.add(measure);
	}
	
	public Document getAsDOMDocument(){
		Document doc = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.newDocument();
			
			//creamos todos los nodos
			Element serviceMetric = doc.createElement("serviceMetric");
			Element metricElement = doc.createElement("metric");
			Element localPeriodInitElement = doc.createElement("localPeriodInit");
			Element localPeriodEndElement = doc.createElement("localPeriodEnd");
			
			//damos valor a los que lo requieren
			metricElement.setTextContent(metric);
			localPeriodInitElement.setTextContent(localPeriodInit);
			localPeriodEndElement.setTextContent(localPeriodEnd);
			
			//añadimos los hijos de "serviceMetric"
			serviceMetric.appendChild(metricElement);
			serviceMetric.appendChild(metricElement);
			serviceMetric.appendChild(localPeriodInitElement);
			serviceMetric.appendChild(localPeriodEndElement);
			//añadimos todas las measures
			if(!measures.isEmpty()){
				for(Measure m:measures){
					serviceMetric.appendChild(doc.importNode(m.getAsDOMDocument().getDocumentElement(), true));
				}
			}
			
			doc.appendChild(serviceMetric);
		}catch (ParserConfigurationException e){
			e.printStackTrace();
		}
		return doc;
	}
}
