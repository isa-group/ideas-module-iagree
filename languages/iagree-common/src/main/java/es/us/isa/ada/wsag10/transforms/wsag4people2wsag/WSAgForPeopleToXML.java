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

package es.us.isa.ada.wsag10.transforms.wsag4people2wsag;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import antlr.ANTLRException;
import es.us.isa.ada.wsag10.transforms.wsag4people2wsag.exceptions.AnalisisSintacticoExcepcion;

public class WSAgForPeopleToXML {
	public static String resultado = "";

	public static String convert(String datos)
			throws AnalisisSintacticoExcepcion, IOException {

		// File file = new File("WSAg4Ptemp");

		boolean hay_err = false;

		// TODO cambiar las "\\" por "/" antes de pasar al antlr

//		AST arbol = null;
		try {
			// output file name
			// String outputFileName = file.getAbsolutePath();
			// // Create FileWriter Object
			// FileWriter outputFileWriter = new FileWriter(outputFileName);
			// // Create PrintWriter Objects
			// PrintWriter outputStream = new PrintWriter(outputFileWriter);
			//
			// outputStream.print(datos);
			//
			// outputStream.close();

			datos = datos.replace("\\\\", "/");
//			datos.re

			InputStream fis = new ByteArrayInputStream(datos.getBytes());

			Analex analex = new Analex(fis);

			Anasint anasint = new Anasint(analex);

			anasint.setASTNodeClass("es.us.isa.ada.wsag10.transforms.wsag4people2wsag.MyTree");

			hay_err = anasint.declaracion_modulo();

		} catch (ANTLRException ae) {
			hay_err = true;
			System.err.println("ERROR: " + ae.getMessage());
		}

		if (hay_err)
			throw new AnalisisSintacticoExcepcion();
		else
			//System.out.println("CORRECTO. ");

		return resultado;

	}

	public static String getResultado() {
		return resultado;
	}

	public static void setResultado(String resultado) {
		// Cambaimos los > y los <

		// eliminaMayorYmenor(resultado);

		//System.out.println("RESULTADO:\n" + resultado);
		WSAgForPeopleToXML.resultado = resultado;
	}

}
