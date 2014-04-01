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

public class ExceptRealTemporalInterval extends RealTemporalInterval{
	
	private RealTemporalInterval rti1;
	
	private RealTemporalInterval rti2;
	
	/**
	 * rti1 EXCEPT rti2
	 * @param rti1
	 * @param rti2
	 */
	public ExceptRealTemporalInterval(RealTemporalInterval rti1, RealTemporalInterval rti2){
		this.rti1 = rti1;
		this.rti2 = rti2;
	}

	@Override
	public ArrayList<TemporalInterval> toDisjointTemporalInterval() {
		DisjointTemporalInterval dti1 = new DisjointTemporalInterval(rti1.toDisjointTemporalInterval());
		DisjointTemporalInterval dti2 = new DisjointTemporalInterval(rti2.toDisjointTemporalInterval());
		DisjointTemporalInterval dtiResult = dti1.except(dti2);
		ArrayList<TemporalInterval> result = new ArrayList<TemporalInterval>();
		for(TemporalInterval ti: dtiResult.getList()){
			result.add(ti);
		}
		return result;
	}

}
