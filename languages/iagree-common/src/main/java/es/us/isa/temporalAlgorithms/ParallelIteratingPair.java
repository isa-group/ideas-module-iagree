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

public class ParallelIteratingPair {
	private TemporalInterval validityPeriod;
	private LinkedHashSet<Object> dataN;
	private LinkedHashSet<Object> dataM;
	
		/**
		 * @param validityPeriod
		 * @param dataM
		 * @param dataN
		 */
		public ParallelIteratingPair(TemporalInterval validityPeriod,LinkedHashSet<Object> dataM,LinkedHashSet<Object> dataN) {
			this.validityPeriod = validityPeriod;
			this.dataN = dataN;
			this.dataM = dataM;
		}

		public TemporalInterval getValidityPeriod() {
			return validityPeriod;
		}

		public LinkedHashSet<Object> getDataN() {
			return dataN;
		}

		public LinkedHashSet<Object> getDataM() {
			return dataM;
		}
}
