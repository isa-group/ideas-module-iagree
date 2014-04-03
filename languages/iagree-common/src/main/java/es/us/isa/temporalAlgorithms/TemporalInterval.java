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

public class TemporalInterval {
private TimePoint initialTimePoint;
private TimePoint endingTimePoint;
  
 /**
 * @param initialTimePoint
 * @param endingTimePoint
 */
public TemporalInterval(TimePoint  initialTimePoint, TimePoint  endingTimePoint) {
	this.setInitialTimePoint(initialTimePoint);
	this.setEndingTimePoint(endingTimePoint);
}

// By default, the Jan 1, 1970 to "INFINITE" 
public TemporalInterval() {
	this.setInitialTimePoint(new TimePoint(0));
	this.setEndingTimePoint(new TimePoint(Long.MAX_VALUE));
}

/**
 * @param initialTimePoint the initialTimePoint to set
 */
public void setInitialTimePoint(TimePoint initialTimePoint) {
	this.initialTimePoint = initialTimePoint;
}

/**
 * @return the initialTimePoint
 */
public TimePoint getInitialTimePoint() {
	return initialTimePoint;
}

/**
 * @param endingTimePoint the endingTimePoint to set
 */
public void setEndingTimePoint(TimePoint endingTimePoint) {
	this.endingTimePoint = endingTimePoint;
}

/**
 * @return the endingTimePoint
 */
public TimePoint getEndingTimePoint() {
	return endingTimePoint;
}

public long getDuration() {
	return endingTimePoint.getTick() - initialTimePoint.getTick();
}

//public boolean isPunctualTemporalInterval(){
//	return initialTimePoint == endingTimePoint? true: false;
//}

public int compare(TemporalInterval temporalInterval){
	if (this.initialTimePoint.getTick() < temporalInterval.initialTimePoint.getTick())
		return -1; //less than
	else if (this.initialTimePoint.getTick() == temporalInterval.initialTimePoint.getTick()){
		if (this.endingTimePoint.getTick() < temporalInterval.endingTimePoint.getTick())
			return -1; // less than
		else if (this.endingTimePoint.getTick() == temporalInterval.endingTimePoint.getTick())
			return 0; // equal to
		else return 1; // greater than
	}
	else return 1; // greater than
}

public boolean contains(TemporalInterval temporalInterval){
	if (this.initialTimePoint.getTick() < temporalInterval.initialTimePoint.getTick()
		&& this.endingTimePoint.getTick() > temporalInterval.endingTimePoint.getTick())
		return true;
	else return false;
}

public boolean contains(TimePoint timePoint){
	if (this.initialTimePoint.getTick() <= timePoint.getTick()
		&& timePoint.getTick() < this.getEndingTimePoint().getTick()) // Close-Open Temporal Intervals (!)
		return true;
	else return false;
}

public boolean finishes(TemporalInterval temporalInterval){
	if (this.initialTimePoint.getTick() > temporalInterval.initialTimePoint.getTick()
		&& this.endingTimePoint.getTick() == temporalInterval.endingTimePoint.getTick())
		return true;
	else return false;
}

public boolean starts(TemporalInterval temporalInterval){
	if (this.initialTimePoint.getTick() == temporalInterval.initialTimePoint.getTick()
		&& this.endingTimePoint.getTick() < temporalInterval.endingTimePoint.getTick())
		return true;
	else return false;
}

public boolean overlaps(TemporalInterval temporalInterval){
	if (this.initialTimePoint.getTick() < temporalInterval.initialTimePoint.getTick()
		&& this.endingTimePoint.getTick() > temporalInterval.initialTimePoint.getTick()
		&& this.endingTimePoint.getTick() < temporalInterval.endingTimePoint.getTick())
		return true;
	else return false;	
}

public boolean meets(TemporalInterval temporalInterval){
	if (this.endingTimePoint.getTick() == temporalInterval.initialTimePoint.getTick()
		&& this.initialTimePoint.getTick() < temporalInterval.endingTimePoint.getTick())
		return true;
	else return false;
}

public boolean before(TemporalInterval temporalInterval){
	if (this.endingTimePoint.getTick() < temporalInterval.initialTimePoint.getTick())
		return true;
	else return false;
}

public boolean during(TemporalInterval temporalInterval){
	return temporalInterval.contains(this);
}

public boolean finishedBy(TemporalInterval temporalInterval){
	return temporalInterval.finishes(this);
}

public boolean startedBy(TemporalInterval temporalInterval){
	return temporalInterval.starts(this);
}

public boolean overlappedBy(TemporalInterval temporalInterval){
	return temporalInterval.overlaps(this);
}

public boolean metBy(TemporalInterval temporalInterval){
	return temporalInterval.meets(this);
}

public boolean after(TemporalInterval temporalInterval){
	return temporalInterval.before(this);
}

public boolean equals(TemporalInterval temporalInterval){
	if (this.initialTimePoint.getTick() == temporalInterval.initialTimePoint.getTick()
		&& this.endingTimePoint.getTick() == temporalInterval.endingTimePoint.getTick())
		return true;
	else return false;
}

public DisjointTemporalInterval extract(TemporalInterval ti){
	// It is inserted the portion of temporal interval that it is not covered (!)		
	DisjointTemporalInterval newNotCovering = new DisjointTemporalInterval();
	
	if (this.contains(ti)){
		TemporalInterval tiNew1 = new TemporalInterval(this.getInitialTimePoint(),ti.getInitialTimePoint());
		TemporalInterval tiNew2 = new TemporalInterval(ti.getEndingTimePoint(),this.getEndingTimePoint());
		newNotCovering.add(tiNew1);
		newNotCovering.add(tiNew2);
	}
	else if (this.during(ti)) {} // Nothing is inserted (!)
	else if (this.finishes(ti)) {} // Nothing is inserted (!)
	else if (this.finishedBy(ti)){
		TemporalInterval tiNew = new TemporalInterval(this.getInitialTimePoint(),ti.getInitialTimePoint());
		newNotCovering.add(tiNew);
	}
	else if (this.starts(ti)) {} // Nothing is inserted (!) 
	else if (this.startedBy(ti)){
		TemporalInterval tiNew = new TemporalInterval(ti.getEndingTimePoint(),this.getEndingTimePoint());
		newNotCovering.add(tiNew);
	}
	else if (this.overlaps(ti)){
		TemporalInterval tiNew = new TemporalInterval(this.getInitialTimePoint(),ti.getInitialTimePoint());
		newNotCovering.add(tiNew);
	}
	else if (this.overlappedBy(ti)){
		TemporalInterval tiNew = new TemporalInterval(ti.getEndingTimePoint(),this.getEndingTimePoint());
		newNotCovering.add(tiNew);
	}	
	else if (this.before(ti) || this.after(ti) || this.meets(ti) || this.metBy(ti))
		newNotCovering.add(this); // The complete temporal interval is inserted since it is not covered (!)
	else // tiCovering.equals(ti)) 
		{} // Nothing is inserted (!) 
		
	return newNotCovering;
}

}
