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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.transforms;

public interface ITransform {

	/**
	 * Nos devuelve una cadena con el formato de entrada de la 
	 * transformacion
	 */
	public String getInputFormat();
	
	/**
	 * Nos devuelve una cadena con el formato de salida de la 
	 * transformacion
	 */
	public String getOutputFormat();
	
	/**
	 * Transforma el fichero que se encuentra en la ruta origen,
	 * y lo almacena en el fichero dado por la ruta destino
	 * 
	 * Si todo ha ido correcto, devolvera true. En caso contrario,
	 * false.
	 */
	public boolean transform(String source, String destination);

	/**
	 * Transforma la cadena origen, y devuelve dicha transformacion
	 */
	public String transform(String source);
	
}
