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

package es.us.isa.ada.selectors;

import java.util.Collection;

import es.us.isa.ada.subfacades.ProxyAnalyzer;

/**
 * Las clases que implementan esta interfaz ofrecen criterios para escoger
 * entre distintos analizadores que implementen la misma operacion.
 * Los criterios quedan a eleccion de aquel que implemente (tiempo,
 * eficiencia, memoria...)
 * @author Jesus
 *
 */
public interface SelectorCriteria {

	public ProxyAnalyzer selectAnalyzer(String id, Collection<ProxyAnalyzer> ans);
	
}
