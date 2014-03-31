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

package es.us.isa.ada.wsag10;


/**
 * @author    cmuller
 */
public class Template extends AbstractAgreementDocument {
	
	/**
	 * @uml.property  name="cc"
	 * @uml.associationEnd  
	 */
	private CreationConstraints cc;

	
	/**
	 * @return
	 * @uml.property  name="cc"
	 */
	public CreationConstraints getCc() {
		return cc;
	}

	/**
	 * @param  cc
	 * @uml.property  name="cc"
	 */
	public void setCc(CreationConstraints cc) {
		this.cc = cc;
	}
	
//	/**
//	 * Devuelve tanto las restricciones asociadas a los terminos
//	 * como las asociadas a las creation constraints
//	 */
//	@Override
//	public Collection<DocumentConstraint> getConstraints() {
//		// TODO meter aqui las creation constraints, SLO's y demas
//		return null;
//	}
//
//	/**
//	 * Devuelve tanto las variables asociadas a los terminos como
//	 * las asociadas a las creation constraints
//	 */
//	@Override
//	public Collection<DocumentVariable> getVariables() {
//		// TODO meter aqui las serviceProperties, serviceDescription e Items
//		return null;
//	}

}