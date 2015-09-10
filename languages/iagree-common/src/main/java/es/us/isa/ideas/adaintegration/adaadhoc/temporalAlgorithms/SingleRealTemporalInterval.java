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

public class SingleRealTemporalInterval extends RealTemporalInterval{
	protected Calendar initialTimePoint;
	protected int duration;
	protected TemporalMetric durationMetric;
	
	/**
	 * @param initialTimePoint
	 * @param duration
	 * @param durationMetric
	 */
	public SingleRealTemporalInterval(Calendar initialTimePoint, int duration, TemporalMetric durationMetric) {
		this.initialTimePoint = initialTimePoint;
		this.duration = duration;
		this.durationMetric = durationMetric;
	}

	// To pass to timeMillis-based time point
	public ArrayList<TemporalInterval> toDisjointTemporalInterval(){
		TemporalInterval ti = new TemporalInterval();
		Calendar endTimePoint = Calendar.getInstance();
				
		ti.setInitialTimePoint(new TimePoint(initialTimePoint.getTimeInMillis()));
		
		endTimePoint.setTimeInMillis(initialTimePoint.getTimeInMillis());
		
		if (durationMetric == TemporalMetric.SECONDS)
			endTimePoint.add(Calendar.SECOND, duration);
		else if (durationMetric == TemporalMetric.DAYS)
			endTimePoint.add(Calendar.DAY_OF_MONTH, duration);
		else if (durationMetric == TemporalMetric.HOURS)
			endTimePoint.add(Calendar.HOUR, duration);
		else if (durationMetric == TemporalMetric.MONTHS)
			endTimePoint.add(Calendar.MONTH, duration);
		else 
			endTimePoint.add(Calendar.YEAR,duration);
		
		ti.setEndingTimePoint(new TimePoint(endTimePoint.getTimeInMillis()));
		
		ArrayList<TemporalInterval> dti = new ArrayList<TemporalInterval>();
		dti.add(ti);
		
		return dti;
	}

	public Calendar getInitialTimePoint() {
		return initialTimePoint;
	}

	public int getDuration() {
		return duration;
	}

	public TemporalMetric getDurationMetric() {
		return durationMetric;
	}
	
	public String toString(){
		String result = "initialPoint: "+initialTimePoint.getTime().toString()+", duration: "+Integer.toString(duration)+", durationMetric: "+durationMetric.toString();
		return result;
	}
}
