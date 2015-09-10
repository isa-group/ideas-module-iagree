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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.selectors.temporalAware;

import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.PointBasedNormalization;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.TemporalSequence;

public class DefaultTimeAwareSelectorCriteria implements TimeAwareSelectorCriteria{

	@Override
	/*
	 * Por ahora, el -nico algoritmo de normalizaci-n es el basado en puntos
	 */
	public TemporalSequence selectTemporalNormaliser() {
		return new PointBasedNormalization();
	}
}
