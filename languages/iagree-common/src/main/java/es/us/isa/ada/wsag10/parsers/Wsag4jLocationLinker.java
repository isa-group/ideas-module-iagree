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

import java.io.File;

import org.apache.xmlbeans.XmlObject;

public class Wsag4jLocationLinker implements LocationLinker {

	
	@Override
	/**
	 * It gets value from specified xquery expresion
	 * and file
	 * 
	 * @param expr xquery expression
	 * @param file source file to execute the expression
	 */
	public String parseLocation(String expr, String file) {
		XmlObject doc = null;
		try {
			doc = XmlObject.Factory.parse(new File(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		XmlObject[] obj = doc.execQuery(expr);
//		System.out.println("Tama�o del array devuelto: "+obj.length);
//		for (int i = 0; i < obj.length; i++) {
//			System.out.println("Valor: "+obj[i]);
//			System.out.println("Ahora: "+getTextContent(obj[i].toString()));
//		}
		return getTextContent(obj[0].toString());
	}
	
	private String getTextContent(String input){
		String output = input.replaceAll("\\<.*?>", "");
		return output;
	}
}
