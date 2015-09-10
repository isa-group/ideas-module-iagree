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

package es.us.isa.ideas.adaintegration.adaadhoc.ada;

import java.util.Collection;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AbstractDocument;

public interface Operation {

	/**
	 * Adds a new document to the operation.
	 * 
	 * Remember if you want to invoke a compliance operation,
	 * you need 2 documents. The first one has to be
	 * a template, and the second one, an offer
	 * 
	 * @param doc AbstractDocument the document
	 */
	public void addDocument(AbstractDocument doc);
	
	/**
	 * Adds a collection of document to the operation
	 * 
	 * Remember if you want to invoke a compliance operation,
	 * you need 2 documents. The first one has to be
	 * a template, and the second one, an offer
	 * 
	 * @param docs Collection<AbstractDocument> the documents
	 */
	public void addDocuments(Collection<AbstractDocument> docs);
	
}
