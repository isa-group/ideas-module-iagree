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

public class TimePoint {
	private long tick;
	
	public TimePoint(long tick) {
		this.tick = tick;
	}
	
	public long getTick() {
		return tick;
	}
	
	public int compare(TimePoint tp){
		if (this.tick < tp.getTick())
			return -1; //less than
		else if (this.tick == tp.getTick())
			return 0; // equal to
		else return 1; // greater than
	}
}
