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

import java.util.Collection;

import choco.kernel.model.constraints.Constraint;
import es.us.isa.ada.document.AgreementElement;

public class TermConstraintPairs {
	
	/*
	 * ¿por que par de colecciones en lugar de coleccion de pares?
	 * 
	 * asi sera mas eficiente el recorrido. ademas, una vez tengamos
	 * descompuestos los documentos en estos pares para las explanations,
	 * no sera posible descomponerlos mas (por los problemas que hay
	 * por el explaining y las variables relacionadas?
	 */
	
	private Collection<AgreementElement> elem;
	
	private Collection<Constraint> constraints;

	public Collection<AgreementElement> getElems() {
		return elem;
	}

	public void setElems(Collection<AgreementElement> elems) {
		this.elem = elems;
	}

	public Collection<Constraint> getConstraints() {
		return constraints;
	}

	public void setConstraints(Collection<Constraint> constraints) {
		this.constraints = constraints;
	}

}
