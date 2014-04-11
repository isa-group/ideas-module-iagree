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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.domain;

import java.util.Collection;
import java.util.LinkedList;

public class RealDomain extends Domain {

	private Collection<RealRange> ranges;
	
	
	public RealDomain(){
		ranges = new LinkedList<RealRange>();
	}
	
	public RealDomain(Collection<RealRange> ranges){
		this.ranges = ranges;
	}
	
	public Collection<RealRange> getRanges(){
		return ranges;
	}
	
	public void addRange(RealRange r){
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
		if (!(obj instanceof RealDomain)) {
			return false;
		}
		RealDomain other = (RealDomain) obj;
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
