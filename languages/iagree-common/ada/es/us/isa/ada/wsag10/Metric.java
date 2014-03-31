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

//package es.us.isa.ada.wsag10;
//
///**
// * @author    cmuller
// */
//public class Metric {
//	
//	public final static String INTEGER_TYPE = "integer";
//	
//	public final static String REAL_TYPE = "double";
//	
//	public final static String STRING_TYPE = "string";
//	/**
//	 * @uml.property  name="dataType"
//	 */
//	private String dataType;
//	/**
//	 * @uml.property  name="min"
//	 */
//	private String min;
//	/**
//	 * @uml.property  name="max"
//	 */
//	private String max;
//	
//	/**
//	 * @return
//	 * @uml.property  name="dataType"
//	 */
//	public String getDataType() {
//		return dataType;
//	}
//	/**
//	 * @param  dataType
//	 * @uml.property  name="dataType"
//	 */
//	public void setDataType(String dataType) {
//		this.dataType = dataType;
//	}
//	/**
//	 * @return
//	 * @uml.property  name="min"
//	 */
//	public String getMin() {
//		return min;
//	}
//	/**
//	 * @param  min
//	 * @uml.property  name="min"
//	 */
//	public void setMin(String min) {
//		this.min = min;
//	}
//	/**
//	 * @return
//	 * @uml.property  name="max"
//	 */
//	public String getMax() {
//		return max;
//	}
//	/**
//	 * @param  max
//	 * @uml.property  name="max"
//	 */
//	public void setMax(String max) {
//		this.max = max;
//	}
//	
//	public boolean equals(Object o){
//		boolean res = false;
//		if (o instanceof Metric){
//			Metric m = (Metric) o;
//			res = dataType.equals(m.getDataType()) && min.equals(m.getMin())
//				&& max.equals(m.getMax());
//		}
//		return res;
//	}
//
//}
