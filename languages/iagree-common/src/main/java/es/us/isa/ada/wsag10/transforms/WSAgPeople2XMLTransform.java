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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
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

import es.us.isa.ada.wsag10.AbstractAgreementDocument;
import es.us.isa.ada.wsag10.transforms.wsag4people2wsag.WSAgForPeopleToXML;
import es.us.isa.ada.wsag10.transforms.wsag4people2wsag.exceptions.AnalisisSintacticoExcepcion;


/**
 * @author  cmuller
 * Hay que modificar todo lo de dentro de esta clase para a�adir
 * c�digo del parseo de WSAg4People a WSAG
 */
public class WSAgPeople2XMLTransform implements ITransform{

	private final static String INPUT_FORMAT = "wsag4people";
	private final static String OUTPUT_FORMAT = "wsag";
	private Document agreement;
	private Document metricXML;
	/**
	 * @uml.property  name="agDoc"
	 * @uml.associationEnd  
	 */
	private AbstractAgreementDocument agDoc;
//	private ArrayTree<Term> docTerms = new ArrayTree<Term>();
	private String WSAg;
	

	/**
	 * The WS-Agreement document is opened and stored in "agreement" attribute
	 * If any error occurs, such attribute has the value null to simplify the use.
	 * 
	 *//*
	private void openAgreementXML(String agFileName) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			agreement = builder.parse(agFileName);
		} catch (Exception e) {
			System.err.println("Error while opening the agreement file");
		}
		//return agreement;

	}
	
	private void openMetricXML(String metricFileName, String varName) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			metricXML = builder.parse(metricFileName);
		} catch (Exception e) {
//			ErrorDialog.start("Error while opening the metric file: "+metricFileName+" \nof the variable: "+varName+"!.\nRevise the file path, please.", new java.awt.Font("Tahoma", Font.BOLD, 14), Color.YELLOW.darker(), new Dimension(390, 120));
			metricXML = null;
			System.err.println("Error while opening the metric file!. Revise the file path, please");
		}
		//return agreement;

	}*/
	
	protected String convertWSAg4PeopleToXML(String WSAg4P){
		
		try {
			WSAg = WSAgForPeopleToXML.convert(WSAg4P);
		} catch (AnalisisSintacticoExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return WSAg;
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
		
		String content = "";
		FileReader file = null;
		
		try {
			file = new FileReader(source);
			String text = "";

			BufferedReader inputStream = new BufferedReader(file);

			
			String inLine = null;

			while ((inLine = inputStream.readLine()) != null) {
				text += (inLine + "\n");
			}
			text = text.substring(0, text.lastIndexOf("\n"));
			

			inputStream.close();
		
			content = convertWSAg4PeopleToXML(text);
			
		} catch (IOException e) {
			System.out.println("IOException:");
			e.printStackTrace();
		}
		
		
		boolean res = (content != null);

		//Quiz�s habr�a que hacer el parseo a xml para ver si es un xml bien formado y libre de errores de XML
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
		//Reader r = new StringReader(source);
		//InputSource is = new InputSource(r);
		//Document docXML;
		//DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//DocumentBuilder builder;
		String res = "";

		//builder = factory.newDocumentBuilder();
		//docXML = builder.parse(is);
		res = convertWSAg4PeopleToXML(source); 

		
		return res;
	}
	
}
	
		


