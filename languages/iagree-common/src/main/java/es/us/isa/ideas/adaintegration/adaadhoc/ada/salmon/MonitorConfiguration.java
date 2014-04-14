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

import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class MonitorConfiguration {

//	<monitorConfiguration>
//	  <globalPeriodInit>...</globalPeriodInit>
//	  <globalPeriodEnd>...</globalPeriodEnd>
//	</monitorConfiguration>
	
	private String globalPeriodInit;
	
	private String globalPeriodEnd;
	
	public MonitorConfiguration(String init, String end){
		this.globalPeriodInit = init;
		this.globalPeriodEnd = end;
	}
	
	public MonitorConfiguration(Date expirationTime){
		this.globalPeriodInit = Utils.getTimestamp();
		this.globalPeriodEnd = Utils.dateTrasform(expirationTime);
	}

	public String getGlobalPeriodInit() {
		return globalPeriodInit;
	}

	public String getGlobalPeriodEnd() {
		return globalPeriodEnd;
	}
	
	public Document getAsDOMDocument(){
		Document doc = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.newDocument();
			
			//creamos todos los nodos
			Element monitorConfiguration = doc.createElement("monitorConfiguration");
			Element globalPeriodInit = doc.createElement("globalPeriodInit");
			Element globalPeriodEnd = doc.createElement("globalPeriodEnd");
			
			//damos valor a los que lo requieren
			globalPeriodInit.setTextContent(this.globalPeriodInit);
			globalPeriodEnd.setTextContent(this.globalPeriodEnd);
			
			//a-adimos los hijos de monitorConfiguration
			monitorConfiguration.appendChild(globalPeriodInit);
			monitorConfiguration.appendChild(globalPeriodEnd);
			
			doc.appendChild(monitorConfiguration);
		}catch (ParserConfigurationException e){
			e.printStackTrace();
		}
		return doc;
	}
}
