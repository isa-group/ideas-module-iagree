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

import java.util.ArrayList;

public class AgreementOffer {
	protected RealTemporalInterval globalValidityPeriod;
	protected ArrayList<GuaranteeTerm> guaranteeTerms;
	//protected TemporalSequence equivalentTemporalSequence;

	/**
	 * @param globalValidityPeriod
	 * @param guaranteeTerms
	 */
	public AgreementOffer(RealTemporalInterval globalValidityPeriod,
			ArrayList<GuaranteeTerm> guaranteeTerms) {
		this.globalValidityPeriod = globalValidityPeriod;
		this.guaranteeTerms = guaranteeTerms;
	}

	public TemporalSequence getEquivalentTemporalSequence(){
		TemporalSequence ts = new PointBasedNormalization();
		
		if (globalValidityPeriod instanceof SingleRealTemporalInterval){
			SingleRealTemporalInterval srti = (SingleRealTemporalInterval) globalValidityPeriod;
			ts.setValidityPeriod(srti.toDisjointTemporalInterval().get(0));
		}
		else{ 
			// Other types of real temporal intervals are not supported for global VP (!)
		}

		for(GuaranteeTerm gt:guaranteeTerms){
			ArrayList<TemporalInterval> dti = gt.getLocalValidityPeriod().toDisjointTemporalInterval();
			for (TemporalInterval ti: dti){
				TemporalPair tp = new TemporalPair(ti,gt.getServiceLevelObjective());
				ts.addPair(tp);
			}
		}
		
		ts.normalize();
		
		return ts;
	}
	
	public ConsistencyResult checkConsistency(){
		ConsistencyResult cr = ConsistencyResult.CONSISTENT;
		
		TemporalSequence equivalentTemporalSequence = getEquivalentTemporalSequence();
		InverseTemporalSequence its = equivalentTemporalSequence.getInverseTemporalSequence();
		
		// The temporal interval to be covered is the global validity period
		// We need an auxiliary variable in order to remove temporal intervals for it. 
		// In order to do it properly, a clone should be used (!)
		DisjointTemporalInterval covering = new DisjointTemporalInterval();
		DisjointTemporalInterval gvp = new DisjointTemporalInterval();
		covering.add(its.getValidityPeriod());		
		gvp.add(its.getValidityPeriod());
		
		for (InverseTemporalPair itp: its.getPairs()){
			// This is the point for non-temporal checking consistency to be asked (!)
			
			// IF "NOT RESOLUTION.CHECK-SATISFIABILITY(itp.getData())" THEN 
			// 		cr = ConsistencyResult.INCONSISTENT; 
			// ELSE 
			//		Temporal overcovering is checked
					DisjointTemporalInterval dti = new DisjointTemporalInterval(itp.getValidityPeriods());
					if (!dti.except(gvp).isEmpty())
						cr = ConsistencyResult.TEMPORAL_OVERCOVERING;
			//		AND The covered temporal interval is removed 		
					covering.remove(itp.getValidityPeriods());
			// END-ELSE
					
			//System.out.print("At this stage, global VP is ");
			//for(TemporalInterval ti1: covering.getList())
			//	System.out.print("[" + ti1.getInitialTimePoint().getTick() + "," 
			//		+ ti1.getEndingTimePoint().getTick() + ")");
			//System.out.println();
		}
		
		// In the end, if empty, the covering is not complete (!)
		if (cr != ConsistencyResult.INCONSISTENT && cr != ConsistencyResult.TEMPORAL_OVERCOVERING){
			if (!covering.isEmpty())
				cr = ConsistencyResult.TEMPORAL_UNDERCOVERING_WARNING;
		}
		
		return cr;
	}
		
	public ComplianceResult checkCompliance(AgreementOffer ao2){
		ComplianceResult cr = ComplianceResult.NON_COMPLIANT;

		// These steps can be optimized if equivalent temporal sequences are somehow stored previously (!)
		TemporalSequence equivalentTemporalSequence = getEquivalentTemporalSequence();
		TemporalSequence equivalentTemporalSequence2 = ao2.getEquivalentTemporalSequence();
		ParallelIteratingResult pir = equivalentTemporalSequence.iterate(equivalentTemporalSequence2); 
		InverseParallelIteratingResult ipir = pir.getInverseParallelIteratingResult();
		
		DisjointTemporalInterval covering = new DisjointTemporalInterval();
		// Only the relevant intervals in N are taken into account, not the global validity period (!)
		// covering.add(ipir.getValidityPeriod());		
		for(InverseParallelIteratingPair ipip: ipir.getPairs())
			if (!ipip.getDataN().isEmpty())
				for(TemporalInterval ti: ipip.getValidityPeriods()) 
					covering.add(ti);

		//System.out.print("Sum of LVP includes the following " + covering.getTiList().size() + " TIs: ");
		//for(TemporalInterval ti1: covering.getTiList())
		//	System.out.print("[" + ti1.getInitialTimePoint().getTick() + "," 
		//		+ ti1.getEndingTimePoint().getTick() + ")");
		//System.out.println();
		
		// Initially, the covering includes the full "global" validity period (sum of local validity periods)
		for (InverseParallelIteratingPair ipip: ipir.getPairs()){
			// It is assumed to be compliant (!)	
			if (!ipip.getDataM().isEmpty()) // and (RESOLUTION.CHECK-SATISFIABILITY(ipip.getDataM(), ipip.getDataN()
				// The covered temporal interval is removed
				covering.remove(ipip.getValidityPeriods());
			
			//System.out.print("At this stage, global VP is ");
			//for(TemporalInterval ti1: covering.getTiList())
			//	System.out.print("[" + ti1.getInitialTimePoint().getTick() + "," 
			//		+ ti1.getEndingTimePoint().getTick() + ")");
			//System.out.println();
		}
		
		// In the end, if empty, the covering is complete
		if (covering.isEmpty())
			cr = ComplianceResult.COMPLIANT;
		
		return cr;
	}
}
