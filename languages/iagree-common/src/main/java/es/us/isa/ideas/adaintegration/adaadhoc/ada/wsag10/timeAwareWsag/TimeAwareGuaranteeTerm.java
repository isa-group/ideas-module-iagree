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

package es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.timeAwareWsag;

import es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.GuaranteeTerm;
import es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms.RealTemporalInterval;

public class TimeAwareGuaranteeTerm extends GuaranteeTerm implements TimeAwareTerm{
	
	private RealTemporalInterval validityPeriod;
	
	public TimeAwareGuaranteeTerm(){
		super();
	}
	
	public TimeAwareGuaranteeTerm(GuaranteeTerm gt){
		setAnalysable(gt.isAnalysable());
		setBvl(gt.getBvl());
		setName(gt.getName());
		setObligated(gt.getObligated());
		setQualifyingCondition(gt.getQualifyingCondition());
		setScopes(gt.getScopes());
		setSlo(gt.getSlo());
		setTermName(gt.getTermName());
	}
	
	public RealTemporalInterval getValidityPeriod(){
		return this.validityPeriod;
	}
	
	public void setValidityPeriod(RealTemporalInterval rti){
		this.validityPeriod = rti;
	}
}
