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
import java.util.LinkedHashSet;

public class InverseParallelIteratingPair {
		private TreeSet<TemporalInterval> validityPeriods;
		private LinkedHashSet<Object> dataM;
		private LinkedHashSet<Object> dataN;

		protected static TreeSet<TemporalInterval> CreateValidityPeriods(){
			TreeSet<TemporalInterval> validityPeriods = new TreeSet<TemporalInterval>(
					new Comparator<TemporalInterval>() {
						public int compare(TemporalInterval ti1, TemporalInterval ti2){
							return ti1.compare(ti2);
						}
					}
			);
			
			return validityPeriods;
		}	
		
		public InverseParallelIteratingPair(LinkedHashSet<Object> dataM,LinkedHashSet<Object> dataN){
			this.dataM = dataM;
			this.dataN = dataN;
			validityPeriods = CreateValidityPeriods();
		}
		
		public void addValidityPeriod(TemporalInterval validityPeriod){
			validityPeriods.add(validityPeriod);
		}

		public LinkedHashSet<Object> getDataM() {
			return dataM;
		}

		public LinkedHashSet<Object> getDataN() {
			return dataN;
		}
		
		public TreeSet<TemporalInterval> getValidityPeriods() {
			return validityPeriods;
		}
}
