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

import java.util.ArrayList;
import java.util.List;

public class DefaultConstantConverter implements ConstantConverter {

	private static DefaultConstantConverter instance = null;
	
	private List<String> values;
	
	private DefaultConstantConverter(){
		values = new ArrayList<String>();
	}
	
	public static DefaultConstantConverter getInstance(){
		if (instance == null){
			instance = new DefaultConstantConverter();
		}
		return instance;
	}
	
	@Override
	public int convertToInteger(String s) {
		int res = values.indexOf(s);
		if (res < 0){
			values.add(s);
			res = values.size() - 1;
		}
		return res;
	}

	@Override
	public String convertToString(int i) {
		if (i < values.size() && i >= 0){
			return values.get(i);
		}
		else{
			return null;
		}
	}

}
