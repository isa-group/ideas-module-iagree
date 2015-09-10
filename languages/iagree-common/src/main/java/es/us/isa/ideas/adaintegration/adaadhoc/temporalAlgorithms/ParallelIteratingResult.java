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

public class ParallelIteratingResult {
	private TemporalInterval validityPeriod;
	private ArrayList<ParallelIteratingPair> pairs;

	/**
	 * @param validityPeriod
	 * @param pairs
	 */
	public ParallelIteratingResult(TemporalInterval validityPeriod,
			ArrayList<ParallelIteratingPair> pairs) {
		this.validityPeriod = validityPeriod;
		this.pairs = pairs;
	}

	public TemporalInterval getValidityPeriod() {
		return validityPeriod;
	}

	public ArrayList<ParallelIteratingPair> getPairs() {
		return pairs;
	}
	
	public InverseParallelIteratingResult getInverseParallelIteratingResult(){
		InverseParallelIteratingResult ipir = new InverseParallelIteratingResult(this.getValidityPeriod());
		
		for(ParallelIteratingPair tp: this.getPairs()){
			int index = ipir.search(tp.getDataM(),tp.getDataN());
			if (index == -1) {
				//System.out.println("NO");
				InverseParallelIteratingPair ipip = new InverseParallelIteratingPair(tp.getDataM(),tp.getDataN());
				ipip.addValidityPeriod(tp.getValidityPeriod());
				ipir.add(ipip);
			}
			else {
				//System.out.println("SI");
				InverseParallelIteratingPair ipip = ipir.getPairs().get(index);
				ipip.addValidityPeriod(tp.getValidityPeriod());
			}
		}
		
		return ipir;
	}

}
