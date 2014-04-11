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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.parsers;

import java.util.Map;

import org.w3c.dom.Node;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
import es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionException;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.RealTemporalInterval;

public interface TimeAwareParser {
	
	/**
	 * Sets used namespace to idenfity temporal XML nodes
	 * @param namespace
	 */
	public void setTimeAwareNamespace(String namespace);
	
	/**
	 * Clears defined periods. This method must be called every time a document is parsed
	 */
	public void resetDefinedPeriods();
	
	/**
	 * Sets GMTZone for this parser. Ex: +1, +2, -1, etc.
	 * @param gmtZone
	 */
	public void setGMTZone(String gmtZone);
	
	/**
	 * Sets the date format to be used in this parser. Ex: MM/DD/YYYY
	 * @param dateFormat
	 */
	public void setDateFormat(String dateFormat);
	
	public RealTemporalInterval parseGlobalValidityPeriod(Node globalValidityPeriod) throws PeriodDefinitionException, BadSyntaxException;
	
	public Map<String, RealTemporalInterval> parseDefinedValidityPeriodSet(Node definedValidityPeriodSet) throws PeriodDefinitionException, BadSyntaxException;

	public RealTemporalInterval parseValidityPeriod(Node validityPeriod) throws PeriodDefinitionException, BadSyntaxException;
}
