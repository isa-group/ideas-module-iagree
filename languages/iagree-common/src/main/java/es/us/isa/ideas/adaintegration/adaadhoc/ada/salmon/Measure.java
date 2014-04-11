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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Measure {
//	  <measure>
//    <value>...</value>
//           <timeStampInit>...</timeStampInit>
//           <timeStampEnd>...</timeStampEnd>
//   </measure>
	
	private String value;
	
	private String timeStampInit;
	
	private String timeStampEnd;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTimeStampInit() {
		return timeStampInit;
	}

	public void setTimeStampInit(String timeStampInit) {
		this.timeStampInit = timeStampInit;
	}

	public String getTimeStampEnd() {
		return timeStampEnd;
	}

	public void setTimeStampEnd(String timeStampEnd) {
		this.timeStampEnd = timeStampEnd;
	}
	
	public Document getAsDOMDocument(){
		Document doc = null;
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try{
			DocumentBuilder db = dbf.newDocumentBuilder();
			doc = db.newDocument();
			
			//creamos todos los nodos
			Element measure = doc.createElement("measure");
			Element value = doc.createElement("value");
			Element timeStampInit = doc.createElement("timeStampInit");
			Element timeStampEnd = doc.createElement("timeStampEnd");
			
			//damos valor a los que lo requieren
			value.setTextContent(this.value);
			timeStampInit.setTextContent(this.timeStampInit);
			timeStampEnd.setTextContent(this.timeStampEnd);
			
			//añadimos los hijos de "measure"
			measure.appendChild(value);
			measure.appendChild(timeStampInit);
			measure.appendChild(timeStampEnd);
			
			doc.appendChild(measure);
		}catch (ParserConfigurationException e){
			e.printStackTrace();
		}
		return doc;
	}
}
