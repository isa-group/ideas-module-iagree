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

import java.util.Comparator;
import java.util.TreeSet;

public class PointBasedTemporalSequence {
	protected TreeSet<PointBasedTemporalPair> pairs;
	
	protected static TreeSet<PointBasedTemporalPair> CreatePairs(){
		TreeSet<PointBasedTemporalPair> pairs = new TreeSet<PointBasedTemporalPair>(
				new Comparator<PointBasedTemporalPair>() {
					public int compare(PointBasedTemporalPair tp1, PointBasedTemporalPair tp2){
						return tp1.compare(tp2);
					}
				}
		);
		
		return pairs;
	}		
}
