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

package es.us.isa.ada.wsag10.domain;

import java.util.Collection;
import java.util.LinkedList;


public class IntegerDomain extends Domain{

	private Collection<IntegerRange> ranges;
	
	
	public IntegerDomain(){
		ranges = new LinkedList<IntegerRange>();
	}
	
	public IntegerDomain(Collection<IntegerRange> ranges){
		this.ranges = ranges;
	}
	
	public Collection<IntegerRange> getRanges(){
		return ranges;
	}
	
	public void addRange(IntegerRange r){
		ranges.add(r);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof IntegerDomain)) {
			return false;
		}
		IntegerDomain other = (IntegerDomain) obj;
		if (ranges == null) {
			if (other.ranges != null) {
				return false;
			}
		} else if (!ranges.equals(other.ranges)) {
			return false;
		}
		return true;
	}
	
	
	
}
