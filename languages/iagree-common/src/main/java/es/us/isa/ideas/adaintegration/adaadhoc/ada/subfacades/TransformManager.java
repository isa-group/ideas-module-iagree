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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.subfacades;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.transforms.ITransform;

/**
 * Fachada del subsistema encargado de realizar transformaciones
 * entre los distintos formatos de documentos de acuerdo
 * @author Jesus
 *
 */
public class TransformManager {

	private Collection<ITransform> transforms;
	
	public TransformManager(){
		transforms = new LinkedList<ITransform>();
	}
	
	public boolean transformTo(String sourceFile, String destinationFile){
		String inputFormat = extractExtension(sourceFile);
		String outputFormat = extractExtension(destinationFile);
		Iterator<ITransform> it = transforms.iterator();
		boolean b = false;
		while (it.hasNext() && !b){
			ITransform i = it.next();
			String in = i.getInputFormat();
			String out = i.getOutputFormat();
			if (in.equalsIgnoreCase(inputFormat) && out.equalsIgnoreCase(outputFormat)){
				b = i.transform(sourceFile, destinationFile);
			}
		}
		return b;
	}

	private String extractExtension(String destinationFile) {
		int index = destinationFile.lastIndexOf(".");
		String ext = destinationFile.substring(index + 1);
		return ext;
	}

	public String transformTo(String source, String inputFormat, String outputFormat){
		Iterator<ITransform> it = transforms.iterator();
		boolean b = false;
		String res = "";
		while (it.hasNext() && !b){
			ITransform i = it.next();
			String in = i.getInputFormat();
			String out = i.getOutputFormat();
			if (in.equalsIgnoreCase(inputFormat) && out.equalsIgnoreCase(outputFormat)){
				res = i.transform(source);
				b = (res != null);
			}
		}
		return res;
	}
	
	public void addTransform(ITransform t){
		transforms.add(t);
	}

}
