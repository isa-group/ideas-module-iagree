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

package es.us.isa.ada.choco.utils;

import choco.kernel.model.constraints.Constraint;
import es.us.isa.ada.wsag10.GuaranteeTerm;

public class ChocoComplexGT {

	private GuaranteeTerm term;
	private Constraint qc;
	private Constraint slo;
	
	
	public ChocoComplexGT(Constraint qc, Constraint slo, GuaranteeTerm t) {
		this.qc = qc;
		this.slo = slo;
		this.term = t;
	}
	
	public Constraint getQc() {
		return qc;
	}
	
	public Constraint getSlo() {
		return slo;
	}
	
	public GuaranteeTerm getTerm(){
		return term;
	}
	
	public boolean equals(Object o){
		boolean res = false;
		if (o instanceof ChocoComplexGT){
			ChocoComplexGT complex = (ChocoComplexGT) o;
			if (complex.getTerm().equals(term)){
				res = true;
			}
		}
		return res;
	}
	
	
	
}