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

package es.us.isa.ada.loaders;

import es.us.isa.ada.subfacades.ADAManager;
import es.us.isa.ada.subfacades.AnalysisManager;
import es.us.isa.ada.subfacades.DocumentsManager;
import es.us.isa.ada.subfacades.TransformManager;

/**
 * Las clases que implementan esta interfaz cargan los distintos componentes
 * del framework. 
 * @author Jesus
 *
 */
public interface ExtensionsLoader {

	public AnalysisManager getAnalysisManager();
	
	public DocumentsManager getDocumentsManager();
	
	public TransformManager getTransformManager();
	
	public ADAManager getADAManager();
	
}
