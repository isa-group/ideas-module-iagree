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

import java.util.*;

public class SinglePeriodicRealTemporalInterval extends SingleRealTemporalInterval {
	protected int repetitions;
	protected int frequency;
	protected TemporalMetric frequencyMetric;

	/**
	 * @param initialTimePoint
	 * @param duration
	 * @param durationMetric
	 * @param repetitions
	 * @param frequency
	 * @param frequencyMetric
	 */
	public SinglePeriodicRealTemporalInterval(Calendar initialTimePoint,
			int duration, TemporalMetric durationMetric, int repetitions,
			int frequency, TemporalMetric frequencyMetric) {
		super(initialTimePoint, duration, durationMetric);
		this.repetitions = repetitions;
		this.frequency = frequency;
		this.frequencyMetric = frequencyMetric;
	}

	protected DisjointRealTemporalInterval toDisjointRealTemporalInterval(){
		Calendar firstInitialTimePoint = Calendar.getInstance();
		firstInitialTimePoint.setTime(initialTimePoint.getTime());
		ArrayList<RealTemporalInterval> list = new ArrayList<RealTemporalInterval>();
		list.add(new SingleRealTemporalInterval(firstInitialTimePoint,duration,durationMetric));
		
		Calendar nextInitialTimePoint = Calendar.getInstance();
		nextInitialTimePoint.setTime(initialTimePoint.getTime());
		int index = 2;
		while (index <= repetitions){
			if (frequencyMetric == TemporalMetric.SECONDS)
				nextInitialTimePoint.add(Calendar.SECOND, frequency);
			else if (frequencyMetric == TemporalMetric.DAYS)
				nextInitialTimePoint.add(Calendar.DAY_OF_MONTH, frequency);
			else if (frequencyMetric == TemporalMetric.HOURS)
				nextInitialTimePoint.add(Calendar.HOUR, frequency);
			else if (frequencyMetric == TemporalMetric.MONTHS)
				nextInitialTimePoint.add(Calendar.MONTH,frequency);
			else 
				nextInitialTimePoint.add(Calendar.YEAR,frequency);
			
			Calendar initialTimePoint2 = Calendar.getInstance();
			initialTimePoint2.setTime(nextInitialTimePoint.getTime());
			list.add(new SingleRealTemporalInterval(initialTimePoint2,duration,durationMetric));
			
			index++;
		}
		
		DisjointRealTemporalInterval drti = new DisjointRealTemporalInterval(list);
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
