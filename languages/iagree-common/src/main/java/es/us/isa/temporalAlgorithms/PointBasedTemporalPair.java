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

import java.util.LinkedHashSet;

enum IntervalPosition {BEGIN,END};

public class PointBasedTemporalPair {
	TimePoint timePoint;
	IntervalPosition position;
	private LinkedHashSet<Object> data;
	  
	public PointBasedTemporalPair(TimePoint timePoint, IntervalPosition position, LinkedHashSet<Object> data) {
			this.timePoint = timePoint;
			this.position  = position;
			this.data = data;
	}
	
	public TimePoint getTimePoint() {
		return timePoint;
	}
	
	public IntervalPosition getPosition(){
		return position;
	}

	public LinkedHashSet<Object> getData() {
		return data;
	}

	public int compare(PointBasedTemporalPair tp){
		int resultTimePointsComparison 
			= this.timePoint.compare(tp.getTimePoint());

		if (resultTimePointsComparison == 0){
			if (this.position == IntervalPosition.BEGIN && tp.getPosition() == IntervalPosition.END)
				resultTimePointsComparison = -1;
			else if (this.position == IntervalPosition.END && tp.getPosition() == IntervalPosition.BEGIN)
				resultTimePointsComparison = 1;
		}
					
		if (resultTimePointsComparison!=0)
			return resultTimePointsComparison;
		else
			return 1; // To force the set to contain elements with the same data during the same time points
	}
	
	public boolean isNonSimultaneousBeginBeginRelationship(PointBasedTemporalPair tp){
		if (this.position == IntervalPosition.BEGIN && tp.getPosition() == IntervalPosition.BEGIN && this.timePoint.compare(tp.getTimePoint()) == -1)
			return true;
		else return false;
	}
	
	public boolean isSimultaneousBeginBeginRelationship(PointBasedTemporalPair tp){
		if (this.position == IntervalPosition.BEGIN && tp.getPosition() == IntervalPosition.BEGIN && this.timePoint.compare(tp.getTimePoint()) == 0)
			return true;
		else
			return false;
	}
	
	public boolean isNonSimultaneousEndBeginRelationship(PointBasedTemporalPair tp){
		if (this.position == IntervalPosition.END && tp.getPosition() == IntervalPosition.BEGIN && this.timePoint.compare(tp.getTimePoint()) == -1)
			return true;
		else
			return false;
	}
	
	public boolean isSimultaneousEndBeginRelationship(PointBasedTemporalPair tp){
		if (this.position == IntervalPosition.END && tp.getPosition() == IntervalPosition.BEGIN && this.timePoint.compare(tp.getTimePoint()) == 0)
			return true;
		else 
			return false;
	}

	public boolean isNonSimultaneousEndEndRelationship(PointBasedTemporalPair tp){
		if (this.position == IntervalPosition.END && tp.getPosition() == IntervalPosition.END && this.timePoint.compare(tp.getTimePoint()) == -1)
			return true;
		else
			return false;
	}
	
	public boolean isSimultaneousEndEndRelationship(PointBasedTemporalPair tp){
		if (this.position == IntervalPosition.END && tp.getPosition() == IntervalPosition.END && this.timePoint.compare(tp.getTimePoint()) == 0)
			return true;
		else
			return false;
	}
		
	public boolean isNonSimultaneousBeginEndRelationship(PointBasedTemporalPair tp){
		if (this.position == IntervalPosition.BEGIN && tp.getPosition() == IntervalPosition.END && this.timePoint.compare(tp.getTimePoint()) == -1)
			return true;
		else
			return false;
	}
	
	public boolean isSimultaneousBeginEndRelationship(PointBasedTemporalPair tp){
		if (this.position == IntervalPosition.BEGIN && tp.getPosition() == IntervalPosition.END && this.timePoint.compare(tp.getTimePoint()) == 0)
			return true;
		else
			return false;
	}
}
