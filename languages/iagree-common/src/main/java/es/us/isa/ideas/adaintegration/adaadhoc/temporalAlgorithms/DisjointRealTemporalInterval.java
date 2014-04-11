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

// Restricted to AND operation
// public enum Operation {
//	AND, OR, XOR
// }

public class DisjointRealTemporalInterval extends RealTemporalInterval {
	protected ArrayList<RealTemporalInterval> list;
	
	/**
	 * @param initialTimePoint
	 * @param duration
	 * @param durationMetric
	 * @param list
	 */
	public DisjointRealTemporalInterval(ArrayList<RealTemporalInterval> list) {
		this.list = list;
	}
	
	public void add(ArrayList<RealTemporalInterval> l2){
		for (RealTemporalInterval srti: l2){
			list.add(srti);
		}
	}

	// To pass to timeMillis-based time point
	public ArrayList<TemporalInterval> toDisjointTemporalInterval(){
		ArrayList<TemporalInterval> dti = new ArrayList<TemporalInterval>();
		
		for(RealTemporalInterval rti: list){
			for (TemporalInterval ti: rti.toDisjointTemporalInterval())
				dti.add(ti);
			
			/*if (rti instanceof SinglePeriodicRealTemporalInterval){
				for (TemporalInterval ti: rti.toDisjointTemporalInterval())
					dti.add(ti);
				//SinglePeriodicRealTemporalInterval sprti = (SinglePeriodicRealTemporalInterval) rti;
				//DisjointRealTemporalInterval drti = sprti.toDisjointRealTemporalInterval();
				//for (RealTemporalInterval srti2: drti.getList())
				//	dti.add(srti2.toDisjointTemporalInterval().get(0));
					//for(TemporalInterval ti: srti2.toDisjointTemporalInterval()) 
					//	dti.add(ti);
			}
			else if (rti instanceof SingleRealTemporalInterval)
				dti.add(rti.toDisjointTemporalInterval().get(0));
				//for(TemporalInterval ti: rti.toDisjointTemporalInterval())
				//	dti.add(ti);
			else if (rti instanceof DisjointRealTemporalInterval)
				for (TemporalInterval ti: rti.toDisjointTemporalInterval())
					dti.add(ti);
			else { // rti instanceof DisjointPeriodicRealTemporalInterval
				for (TemporalInterval ti: rti.toDisjointTemporalInterval())
					dti.add(ti);
			}*/
		}
		
		return dti;
	}

	public ArrayList<RealTemporalInterval> getList() {
		return list;
	}
}
