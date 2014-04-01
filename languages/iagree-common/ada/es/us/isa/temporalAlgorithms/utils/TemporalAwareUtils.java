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

package es.us.isa.temporalAlgorithms.utils;

import java.util.ArrayList;

import es.us.isa.ada.selectors.temporalAware.DefaultTimeAwareSelectorCriteria;
import es.us.isa.ada.selectors.temporalAware.TimeAwareSelectorCriteria;
import es.us.isa.ada.wsag10.AbstractAgreementDocument;
import es.us.isa.ada.wsag10.CreationConstraints;
import es.us.isa.ada.wsag10.GeneralConstraint;
import es.us.isa.ada.wsag10.Item;
import es.us.isa.ada.wsag10.Template;
import es.us.isa.ada.wsag10.Term;
import es.us.isa.ada.wsag10.timeAwareWsag.TimeAwareContext;
import es.us.isa.ada.wsag10.timeAwareWsag.TimeAwareGeneralConstraint;
import es.us.isa.ada.wsag10.timeAwareWsag.TimeAwareGuaranteeTerm;
import es.us.isa.ada.wsag10.timeAwareWsag.TimeAwareItem;
import es.us.isa.ada.wsag10.timeAwareWsag.TimeAwareServiceDescriptionTerm;
import es.us.isa.ada.wsag10.timeAwareWsag.TimeAwareTerm;
import es.us.isa.temporalAlgorithms.DisjointTemporalInterval;
import es.us.isa.temporalAlgorithms.RealTemporalInterval;
import es.us.isa.temporalAlgorithms.SinglePeriodicRealTemporalInterval;
import es.us.isa.temporalAlgorithms.SingleRealTemporalInterval;
import es.us.isa.temporalAlgorithms.TemporalInterval;
import es.us.isa.temporalAlgorithms.TemporalPair;
import es.us.isa.temporalAlgorithms.TemporalSequence;

public class TemporalAwareUtils {
	
	public static TemporalSequence getEquivalentTemporalSequence(AbstractAgreementDocument agreement){
		agreement.setHasSomeGlobalTerm(false);
		TimeAwareSelectorCriteria selector = new DefaultTimeAwareSelectorCriteria();
		TemporalSequence ts = selector.selectTemporalNormaliser();
		
		RealTemporalInterval globalValidityPeriod = getGlobalValidityPeriod(agreement);
		
		if (globalValidityPeriod instanceof SinglePeriodicRealTemporalInterval){
			// There are some validity periods, so there will be some more items in the temporal sequence (!)
		}else{ // SingleRealTemporalInterval
			SingleRealTemporalInterval srti = (SingleRealTemporalInterval) globalValidityPeriod;
			ts.setValidityPeriod(srti.toDisjointTemporalInterval().get(0));
			
			// Recorremos los SDTs, GTs, Items y Constraints porque es donde puede
			// estar la temporalidad
			// Si estos términos no tienen asignado un periodo de validez,
			// le asignamos el globalPeriod
			for(Term t: agreement.getAllTerms()){
				if(t instanceof TimeAwareServiceDescriptionTerm){
					TimeAwareServiceDescriptionTerm tasdt = (TimeAwareServiceDescriptionTerm) t;
					if(tasdt.getValidityPeriod() != null){
						addTermPeriodToTemporalSequence(ts, tasdt, tasdt.getValidityPeriod());
					}else{
						addTermPeriodToTemporalSequence(ts, tasdt, globalValidityPeriod);
						agreement.setHasSomeGlobalTerm(true);
					}
				}else if(t instanceof TimeAwareGuaranteeTerm){
					TimeAwareGuaranteeTerm tagt = (TimeAwareGuaranteeTerm) t;
					if(tagt.getValidityPeriod() != null){
						addTermPeriodToTemporalSequence(ts, tagt, tagt.getValidityPeriod());
					}else{
						addTermPeriodToTemporalSequence(ts, tagt, globalValidityPeriod);
						agreement.setHasSomeGlobalTerm(true);
					}
				}
			}
			if(agreement instanceof Template){
				Template t = (Template) agreement;
				CreationConstraints cc = t.getCc();
				for(Item item: cc.getItems()){
					if(item instanceof TimeAwareItem){
						TimeAwareItem taItem = (TimeAwareItem) item;
						if(taItem.getValidityPeriod() != null){
							addTermPeriodToTemporalSequence(ts, taItem, taItem.getValidityPeriod());
						}else{
							addTermPeriodToTemporalSequence(ts, taItem, globalValidityPeriod);
							agreement.setHasSomeGlobalTerm(true);
						}
					}
				}
				for(GeneralConstraint gc: cc.getConstraints()){
					if(gc instanceof TimeAwareGeneralConstraint){
						TimeAwareGeneralConstraint tagc = (TimeAwareGeneralConstraint) gc;
						if(tagc.getValidityPeriod() != null){
							addTermPeriodToTemporalSequence(ts, tagc, tagc.getValidityPeriod());
						}else{
							addTermPeriodToTemporalSequence(ts, tagc, globalValidityPeriod);
							agreement.setHasSomeGlobalTerm(true);
						}
					}
				}
			}
		}
		
		ts.normalize();
		
		return ts;
	}
	
	public static void printGlobalValidityPeriod(DisjointTemporalInterval dti){
		System.out.print("At this stage, global VP is ");
		for(TemporalInterval ti1: dti.getList())
			System.out.print("[" + ti1.getInitialTimePoint().getTick() + "," 
				+ ti1.getEndingTimePoint().getTick() + ")");
		System.out.println();
	}
	
	/**
	 * Gets the GlobalValidityPeriod that is inside the Context
	 * @param doc 
	 * @return GlobalValidityPeriod
	 */
	private static RealTemporalInterval getGlobalValidityPeriod(AbstractAgreementDocument doc){
		//El global validity period va dentro del contexto
		TimeAwareContext taContext = (TimeAwareContext)doc.getContext();
		return taContext.getGlobalPeriod();
	}
	
	/**
	 * Associates a given Term to a given ValidityPeriod into a TemporalSequence
	 * @param ts Where TemporalPair´s and Terms will be associated
	 * @param taTerm This term will be associated to a TemporalInterval
	 * @param rti This ValidityPeriod will be transformed into a TemporalInterval
	 */
	private static void addTermPeriodToTemporalSequence(TemporalSequence ts, TimeAwareTerm taTerm, RealTemporalInterval rti){
		ArrayList<TemporalInterval> tis = rti.toDisjointTemporalInterval();
		for(TemporalInterval ti: tis){
			TemporalPair tp = new TemporalPair(ti, taTerm);
			ts.addPair(tp);
		}
	}
}
