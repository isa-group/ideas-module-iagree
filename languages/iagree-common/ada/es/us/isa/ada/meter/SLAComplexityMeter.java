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

package es.us.isa.ada.meter;

import es.us.isa.ada.exceptions.BadSyntaxException;

public interface SLAComplexityMeter {

	/**
	 * return the number of guarantee terms of this document
	 */
	public Integer amountOfGT(String doc) throws BadSyntaxException;

	/**
	 * return the number of alternatives of this document
	 */
	public Integer amountOfVariants(String doc) throws BadSyntaxException;

	/**
	 * return the number of scopes of this document
	 */
	public Integer amountOfServiceOperations(String doc) throws BadSyntaxException;
	
}
