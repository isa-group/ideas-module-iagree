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

package es.us.isa.ada.subfacades;

import java.util.HashMap;
import java.util.Map;

import es.us.isa.ada.document.AbstractDocument;
import es.us.isa.ada.exceptions.ADAException;
import es.us.isa.ada.io.IDocumentParser;
import es.us.isa.ada.io.IDocumentWriter;

/**
 * Fachada del subsistema encargado de coordinar la carga y escritura
 * de documentos de acuerdo
 * @author Jesus
 *
 */
public class DocumentsManager {

	private Map<String,IDocumentParser> parsers;
	
	private Map<String,IDocumentWriter> writers;
	
	public DocumentsManager(){
		parsers = new HashMap<String,IDocumentParser>();
		writers = new HashMap<String,IDocumentWriter>();
	}
	
	public void addParser(String extension, IDocumentParser parser){
		parsers.put(extension, parser);
	}
	
	public void addWriter(String extension, IDocumentWriter writer){
		writers.put(extension, writer);
	}
	
	public AbstractDocument loadDocument(String path, String... opts){
		//XXX en principio, cargaremos por la extension del fichero
		AbstractDocument res = null;
		String extension = getExtension(path);
		IDocumentParser parser = parsers.get(extension);
		if (parser != null){
			res = parser.parseFile(path,opts);
		}else{
			throw new ADAException("There aren�t a parser for extension "+extension);
		}
		return res;
	}
	
	public void writeDocument(AbstractDocument doc, String path){
		String extension = getExtension(path);
		IDocumentWriter writer = writers.get(extension);
		if (writer != null){
			writer.writeFile(doc, path);
		}
	}
	
	private String getExtension(String path){
		int index = path.lastIndexOf(".") + 1;
		String extension = path.substring(index);
		return extension;
	}
	
}
