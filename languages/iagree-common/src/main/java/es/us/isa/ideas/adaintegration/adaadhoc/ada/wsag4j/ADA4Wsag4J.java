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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag4j;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.ADA;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AbstractDocument;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.loaders.ExtensionsLoader;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.parsers.WSAg4jParser;

public class ADA4Wsag4J extends ADA {

	public ADA4Wsag4J(ExtensionsLoader extensionsLoader){
		super(extensionsLoader);
		//cambiamos el parser por defecto de documentos de acuerdo
		//al parser para wsag4j
		this.docManager.addParser("wsag", new WSAg4jParser());
		this.docManager.addParser("xml", new WSAg4jParser());
	}
	
	public AbstractDocument loadDocument(String path, String... opts){
		return docManager.loadDocument(path,opts);
	}
	
}
