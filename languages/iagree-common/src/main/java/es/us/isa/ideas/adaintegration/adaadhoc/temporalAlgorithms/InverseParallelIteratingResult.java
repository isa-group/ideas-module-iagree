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

import java.util.ArrayList;
import java.util.LinkedHashSet;

public class InverseParallelIteratingResult {
	protected TemporalInterval validityPeriod;
	protected ArrayList<InverseParallelIteratingPair> pairs;

	/**
	 * @param validityPeriod
	 * @param pairs
	 */
	public InverseParallelIteratingResult(TemporalInterval validityPeriod,
			ArrayList<InverseParallelIteratingPair> pairs) {
		this.validityPeriod = validityPeriod;
		this.pairs = pairs;
	}
	
	public InverseParallelIteratingResult(TemporalInterval validityPeriod){
		this.validityPeriod = validityPeriod;
		this.pairs = new ArrayList<InverseParallelIteratingPair>();
	}
	
	public int search(LinkedHashSet<Object> dataM, LinkedHashSet<Object> dataN){
		int index = 0;
		for (InverseParallelIteratingPair ipip: pairs){
			if (ipip.getDataM().equals(dataM) && ipip.getDataN().equals(dataN)){
				return index; 
			}	
			index++;
		}
		return -1;
	}

	public void add(InverseParallelIteratingPair ipip){
		pairs.add(ipip);
	}
	
	public ArrayList<InverseParallelIteratingPair> getPairs() {
		return pairs;
	}

	public TemporalInterval getValidityPeriod() {
		return validityPeriod;
	}
}
