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

package es.us.isa.ada.wsag10.transforms;


import java.awt.Color;
import java.awt.Dimension;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import es.us.isa.ada.wsag10.AbstractAgreementDocument;
import es.us.isa.ada.wsag10.transforms.wsag2wsag4people.XmlToWSAg4People;


/**
 * @author  cmuller
 */
public class WSAg4PeopleTransform implements ITransform{

	private final static String INPUT_FORMAT = "wsag";
	private final static String OUTPUT_FORMAT = "wsag4people";
	
	private XmlToWSAg4People impl;
	
	public WSAg4PeopleTransform(){
		impl = new XmlToWSAg4People();
	}
	
	@Override
	public String getInputFormat() {
		return INPUT_FORMAT;
	}

	@Override
	public String getOutputFormat() {
		return OUTPUT_FORMAT;
	}

	@Override
	public boolean transform(String source, String destination) {
		Document docXML ;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		DocumentBuilder builder;
		String content = "";
		
			try {
				builder = factory.newDocumentBuilder();
				docXML = builder.parse(source);
				content = impl.convertXMLToWSAg4People(docXML);
			} catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				System.err.println("Error while opening the agreement file");
				e1.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				System.err.println("Error while opening the agreement file");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("Error while opening the agreement file");
				e.printStackTrace();
			}
			
		
		
		boolean res = (content != null);

		FileWriter fichero = null;
		PrintWriter pw = null;
		try {
			fichero = new FileWriter(destination);
			pw = new PrintWriter(fichero);
			pw.println(content);
		} catch (IOException e) {
			res = false;
			e.printStackTrace();
		} finally {
			try {
				fichero.close();
			} catch (IOException e) {
				res = false;
				e.printStackTrace();
			}

		}

		return res;
	}

	@Override
	public String transform(String source) {
		Reader r = new StringReader(source);
		InputSource is = new InputSource(r);
		Document docXML;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		String res = "";

		try {
			builder = factory.newDocumentBuilder();
			docXML = builder.parse(is);
			res = impl.convertXMLToWSAg4People(docXML); 
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return res;
	}
	
}
	
		


