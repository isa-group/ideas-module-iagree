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

package es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms;

import java.util.*;

public class TemporalPair {
  private TemporalInterval validityPeriod;
  private LinkedHashSet<Object> data;

/**
 * @param validityPeriod
 * @param data
 */
public TemporalPair(TemporalInterval validityPeriod, LinkedHashSet<Object> data) {
	this.validityPeriod = validityPeriod;
	this.data = data;
}
  
public TemporalPair(TemporalInterval validityPeriod) {
	this.validityPeriod = validityPeriod;
	data = new LinkedHashSet<Object>();
}

/**
 * @param validityPeriod
 * @param data
 */
public TemporalPair(TemporalInterval validityPeriod, Object data) {
	this.validityPeriod = validityPeriod;
	this.data = new LinkedHashSet<Object>();
	this.data.add(data);
}

/**
 * @return the validityPeriod
 */
public TemporalInterval getValidityPeriod() {
	return validityPeriod;
}

/**
 * @param data the data to set
 */
public void setData(LinkedHashSet<Object> data) {
	this.data = data;
}

/**
 * @return the data
 */
public LinkedHashSet<Object> getData() {
	return data;
}

public int compare(TemporalPair tp){
	int resultTemporalIntervalsComparison 
		= this.validityPeriod.compare(tp.getValidityPeriod());

	if (resultTemporalIntervalsComparison!=0)
		return resultTemporalIntervalsComparison;
	else
		return 1; // To force the set to contain elements with the same data during the same temporal intervals
}
    
}
