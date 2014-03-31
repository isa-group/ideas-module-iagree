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

package es.us.isa.temporalAlgorithms;

import java.util.ArrayList;

public class DisjointPeriodicRealTemporalInterval extends
		DisjointRealTemporalInterval {
	protected int repetitions;
	protected int frequency;
	protected TemporalMetric frequencyMetric;
	
	/**
	 * @param list
	 * @param repetitions
	 * @param frequency
	 * @param frequencyMetric
	 */
	public DisjointPeriodicRealTemporalInterval(
			ArrayList<RealTemporalInterval> list, int repetitions,
			int frequency, TemporalMetric frequencyMetric) {
		super(list);
		this.repetitions = repetitions;
		this.frequency = frequency;
		this.frequencyMetric = frequencyMetric;
	}

	protected DisjointRealTemporalInterval toDisjointRealTemporalInterval(){
		DisjointRealTemporalInterval drti = new DisjointRealTemporalInterval(new ArrayList<RealTemporalInterval>());
		
		for(RealTemporalInterval rti: this.list){
			if (rti instanceof SinglePeriodicRealTemporalInterval){
				SinglePeriodicRealTemporalInterval sprti = (SinglePeriodicRealTemporalInterval) rti;
				DisjointRealTemporalInterval drti1Aux = sprti.toDisjointRealTemporalInterval();
				
				/*for(RealTemporalInterval rti2: drti1Aux.getList()){
					SingleRealTemporalInterval srti2Aux = (SingleRealTemporalInterval) rti2;
					SinglePeriodicRealTemporalInterval sprti2Aux = 
						new SinglePeriodicRealTemporalInterval(srti2Aux.initialTimePoint,srti2Aux.duration,srti2Aux.durationMetric, 
													repetitions,frequency, frequencyMetric);
					DisjointRealTemporalInterval drtiAux2 = sprti2Aux.toDisjointRealTemporalInterval();
					drti.add(drtiAux2.getList());
				}*/
				
				DisjointPeriodicRealTemporalInterval dprti = 
					new DisjointPeriodicRealTemporalInterval(drti1Aux.getList(),repetitions,frequency,frequencyMetric);
				DisjointRealTemporalInterval drti2Aux = dprti.toDisjointRealTemporalInterval();
				drti.add(drti2Aux.getList());
			}
			else if (rti instanceof SingleRealTemporalInterval){ 
				SingleRealTemporalInterval srti= (SingleRealTemporalInterval) rti;
				SinglePeriodicRealTemporalInterval sprti = 
						new SinglePeriodicRealTemporalInterval(srti.initialTimePoint,srti.duration,srti.durationMetric, 
													repetitions,frequency, frequencyMetric);
				DisjointRealTemporalInterval drti1Aux = sprti.toDisjointRealTemporalInterval();
				drti.add(drti1Aux.getList());
			}
			else if (rti instanceof DisjointPeriodicRealTemporalInterval){
				DisjointPeriodicRealTemporalInterval dprti = (DisjointPeriodicRealTemporalInterval) rti;
				DisjointRealTemporalInterval drti1Aux = dprti.toDisjointRealTemporalInterval();
				DisjointPeriodicRealTemporalInterval dprti2Aux = 
					new DisjointPeriodicRealTemporalInterval(drti1Aux.getList(),repetitions,frequency,frequencyMetric);
				DisjointRealTemporalInterval drti2Aux = dprti2Aux.toDisjointRealTemporalInterval();
				drti.add(drti2Aux.getList());
			}
			else{ // rti instanceof DisjointRealTemporalInterval
				DisjointRealTemporalInterval drti1Aux = (DisjointRealTemporalInterval) rti;
				DisjointPeriodicRealTemporalInterval dprti = 
						new DisjointPeriodicRealTemporalInterval(drti1Aux.getList(),repetitions,frequency,frequencyMetric);
				DisjointRealTemporalInterval drti2Aux = dprti.toDisjointRealTemporalInterval();
				drti.add(drti2Aux.getList());
			}
		}
		
		return drti;
	}

	public ArrayList<TemporalInterval> toDisjointTemporalInterval(){
  		return toDisjointRealTemporalInterval().toDisjointTemporalInterval();
	}
	
	public int getRepetitions() {
		return repetitions;
	}

	public int getFrequency() {
		return frequency;
	}

	public TemporalMetric getFrequencyMetric() {
		return frequencyMetric;
	}
}
