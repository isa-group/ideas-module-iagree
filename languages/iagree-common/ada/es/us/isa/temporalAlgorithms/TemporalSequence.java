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

public abstract class TemporalSequence {
	protected TemporalInterval validityPeriod;
	protected TreeSet<TemporalPair> pairs;
	protected int normalizationSteps; // Recursive depth reached during the algorithm step in normalization
	protected int divideAndRuleSteps; // Recursive depth reached during the divide and rule step in normalization
	protected int coalescingSteps;
	
	protected static TreeSet<TemporalPair> CreatePairs(){
		TreeSet<TemporalPair> pairs = new TreeSet<TemporalPair>(
				new Comparator<TemporalPair>() {
					public int compare(TemporalPair tp1, TemporalPair tp2){
						return tp1.compare(tp2);
					}
				}
		);
		
		return pairs;
	}		
	
//public TemporalSequence(TemporalInterval validityPeriod){
//	this.validityPeriod = validityPeriod;
//	this.pairs = CreatePairs();
//}
  
//public TemporalSequence(TemporalInterval validityPeriod,TreeSet<TemporalPair> pairs){
//	this.validityPeriod = validityPeriod;
//	this.pairs = pairs;
//}  
    
public TemporalSequence(){
	this.validityPeriod = new TemporalInterval(new TimePoint(Long.MAX_VALUE),new TimePoint(Long.MIN_VALUE));
	this.pairs = CreatePairs();
}

public TemporalInterval getValidityPeriod() {
	return validityPeriod;
}

public void setValidityPeriod(TemporalInterval vp) {
	validityPeriod = vp;
}

public int getDivideAndRuleSteps() {
	return divideAndRuleSteps;
}

public int getCoalescingSteps(){
	return coalescingSteps;
}

//public void setValidityPeriod(TemporalInterval validityPeriod) {
//	this.validityPeriod = validityPeriod;
//}
  
public void addPair(TemporalPair pair) {
	// The actual version does not change the limits of global VP in order to check over-covering (!)
	// Revising the limits of global validity period
	//if (pair.getValidityPeriod().getInitialTimePoint().getTick() < this.validityPeriod.getInitialTimePoint().getTick())
	//	this.validityPeriod.setInitialTimePoint(pair.getValidityPeriod().getInitialTimePoint());
	//
	//if (pair.getValidityPeriod().getEndingTimePoint().getTick() > this.validityPeriod.getEndingTimePoint().getTick())
	//	this.validityPeriod.setEndingTimePoint(pair.getValidityPeriod().getEndingTimePoint());

	this.pairs.add(pair);
}

public TreeSet<TemporalPair> getPairs(){
	return pairs;
}

public int getNormalizationSteps(){
	return normalizationSteps;
}

public boolean isAmbiguous(){
	for (TemporalPair pair1: pairs)
		for (TemporalPair pair2: pairs) {
			if (!pair1.getValidityPeriod().overlaps(pair2.getValidityPeriod())){
				return false;
			}							
	}
	
	return true;
}

public boolean isCoalesced() {
	for (TemporalPair pair1: pairs)
		for (TemporalPair pair2: pairs) {
			if (pair1.getValidityPeriod().meets(pair2.getValidityPeriod()))
				if (pair1.getData().equals(pair2.getData()))
					return false;
	}
	
	return true;
}

//public boolean isTimeOrdered() {
//	for (int index = 0; index < pairs.size() - 1; index++) {
//		if (!pairs.get(index).getValidityPeriod().isTimeOrdered(pairs.get(index+1).getValidityPeriod()))
//			return false;
//	}
//	return true;
//}

public boolean isNormalized() {
	return !isAmbiguous() && isCoalesced(); // && isTimeOrdered()
}

//public void order() {
//	// This instruction should implement the precondition
//	if (!isTimeOrdered()){
//		pairs = order(pairs);
//	}
//}

//private ArrayList<TemporalPair> order(ArrayList<TemporalPair> pairs){
//	// The initial case to finish the recursive function
//	if (pairs.size() == 1) return pairs;
//	
//	ArrayList<TemporalPair> lPairs = new ArrayList<TemporalPair>();
//	ArrayList<TemporalPair> rPairs = new ArrayList<TemporalPair>();
//	
//	// Splitting the temporal sequence in two parts
//	int middle = pairs.size()/2;
//	for (int index = 0; index < middle; index++) lPairs.add(pairs.get(index));
//	for (int index = middle; index < pairs.size(); index++) rPairs.add(pairs.get(index));
//	
//	// Time-ordering the temporal sequences separately
//	lPairs = order(lPairs);
//	rPairs = order(rPairs);
//
//	// Merging in time-order the already time-ordered temporal sequences
//	int lIndex = 0, rIndex = 0;
//	ArrayList<TemporalPair> orderedPairs = new ArrayList<TemporalPair>();
//	while (lIndex < lPairs.size() && rIndex < rPairs.size()){
//		if (lPairs.get(lIndex).getValidityPeriod().isTimeOrdered(rPairs.get(rIndex).getValidityPeriod())){
//			orderedPairs.add(lPairs.get(lIndex));
//			lIndex++;
//		}
//		else {
//			orderedPairs.add(rPairs.get(rIndex));
//			rIndex++;
//		}
//	}
//	for (int index = lIndex; index < lPairs.size(); index++) orderedPairs.add(lPairs.get(index));
//	for (int index = rIndex; index < rPairs.size(); index++) orderedPairs.add(rPairs.get(index));
//		
//	return orderedPairs;
//}

public abstract void normalize();
protected abstract TreeSet<TemporalPair> makeUnambiguous(TreeSet<TemporalPair> mPairs);

// Pre: the temporal sequence is not ambiguous
protected TreeSet<TemporalPair> coalesce(TreeSet<TemporalPair> mPairs){

	// The initial case to finish the recursive function
	if (mPairs.size() == 1) return mPairs;
	
	coalescingSteps++;
	
	// The main function body
	TreeSet<TemporalPair> rPairs = CreatePairs();
	
	TemporalPair mPair = mPairs.pollFirst();
	TemporalPair nPair = mPairs.pollFirst();

	if (mPair.getValidityPeriod().meets(nPair.getValidityPeriod())
		&& (mPair.getData().equals(nPair.getData()))){
			TemporalPair auxPair = new TemporalPair(new TemporalInterval(mPair.getValidityPeriod().getInitialTimePoint(),
																		nPair.getValidityPeriod().getEndingTimePoint()),
													mPair.getData());
			mPairs.add(auxPair);
			rPairs = this.coalesce(mPairs);
	}
	else {
			mPairs.add(nPair);
			rPairs = this.coalesce(mPairs);
			rPairs.add(mPair);
	}
	
	return rPairs;
}

public ParallelIteratingResult iterate(TemporalSequence ts2) {
	
	// These instructions should implement the preconditions
	if (!this.isNormalized()) this.normalize();
	if (!ts2.isNormalized()) ts2.normalize();

	// All global validity periods should be properly computed!
	return new ParallelIteratingResult(this.validityPeriod,iterate(this.pairs,ts2.getPairs()));
}

private ArrayList<ParallelIteratingPair> iterate(TreeSet<TemporalPair> mPairs, TreeSet<TemporalPair> nPairs){
	ArrayList<ParallelIteratingPair> rPairs = new ArrayList<ParallelIteratingPair>();
	LinkedHashSet<Object> noData = new LinkedHashSet<Object>(); // A collection without data
	
	// The initial cases to finish the recursive function
	if (mPairs.isEmpty() && nPairs.isEmpty()){
		return rPairs;		
	}
	if (mPairs.isEmpty() && !nPairs.isEmpty()){
		for (TemporalPair pair: nPairs)
			rPairs.add(new ParallelIteratingPair(pair.getValidityPeriod(),noData,pair.getData()));
		return rPairs;
	}
	if (!mPairs.isEmpty() && nPairs.isEmpty()){
		for (TemporalPair pair: mPairs)
			rPairs.add(new ParallelIteratingPair(pair.getValidityPeriod(),pair.getData(),noData));
		return rPairs;
	}
		
	// The main function body
	TemporalPair mPair = mPairs.pollFirst();
	TemporalPair nPair = nPairs.pollFirst();
	
	if (mPair.getValidityPeriod().equals(nPair.getValidityPeriod())){
		ParallelIteratingPair rPair = new ParallelIteratingPair(mPair.getValidityPeriod(),
											  mPair.getData(),nPair.getData());
		//mPairs.remove(0);
		//nPairs.remove(0);
		rPairs = this.iterate(mPairs, nPairs);
		rPairs.add(0,rPair);
	}
	else if (mPair.getValidityPeriod().contains(nPair.getValidityPeriod())){
		TemporalPair auxPair = new TemporalPair(new TemporalInterval(nPair.getValidityPeriod().getEndingTimePoint(),mPair.getValidityPeriod().getEndingTimePoint()),
												mPair.getData());
		ParallelIteratingPair rPair1 = new ParallelIteratingPair(new TemporalInterval(mPair.getValidityPeriod().getInitialTimePoint(),nPair.getValidityPeriod().getInitialTimePoint()),
																 mPair.getData(),noData);
		ParallelIteratingPair rPair2 = new ParallelIteratingPair(nPair.getValidityPeriod(),
																 mPair.getData(),nPair.getData());
		mPairs.add(auxPair);
		rPairs = this.iterate(mPairs, nPairs);
		rPairs.add(0,rPair2);
		rPairs.add(0,rPair1);
	}
	else if (mPair.getValidityPeriod().during(nPair.getValidityPeriod())){
		TemporalPair auxPair = new TemporalPair(new TemporalInterval(mPair.getValidityPeriod().getEndingTimePoint(),nPair.getValidityPeriod().getEndingTimePoint()),
				nPair.getData());
		ParallelIteratingPair rPair1 = new ParallelIteratingPair(new TemporalInterval(nPair.getValidityPeriod().getInitialTimePoint(),mPair.getValidityPeriod().getInitialTimePoint()),
																noData,nPair.getData());
		ParallelIteratingPair rPair2 = new ParallelIteratingPair(mPair.getValidityPeriod(),
								 								mPair.getData(),nPair.getData());
		nPairs.add(auxPair);
		rPairs = this.iterate(mPairs, nPairs);
		rPairs.add(0,rPair2);
		rPairs.add(0,rPair1);
	}
	else if (mPair.getValidityPeriod().finishes(nPair.getValidityPeriod())){
		ParallelIteratingPair rPair1 = new ParallelIteratingPair(new TemporalInterval(nPair.getValidityPeriod().getInitialTimePoint(),mPair.getValidityPeriod().getInitialTimePoint()),
																noData,nPair.getData());
		ParallelIteratingPair rPair2 = new ParallelIteratingPair(mPair.getValidityPeriod(),
																 mPair.getData(),nPair.getData());
		rPairs = this.iterate(mPairs, nPairs);
		rPairs.add(0,rPair2);
		rPairs.add(0,rPair1);
	}
	else if (mPair.getValidityPeriod().finishedBy(nPair.getValidityPeriod())){
		ParallelIteratingPair rPair1 = new ParallelIteratingPair(new TemporalInterval(mPair.getValidityPeriod().getInitialTimePoint(),nPair.getValidityPeriod().getInitialTimePoint()),
				 												mPair.getData(),noData);
		ParallelIteratingPair rPair2 = new ParallelIteratingPair(nPair.getValidityPeriod(),
				 												mPair.getData(),nPair.getData());
		rPairs = this.iterate(mPairs, nPairs);
		rPairs.add(0,rPair2);
		rPairs.add(0,rPair1);
	}
	else if (mPair.getValidityPeriod().starts(nPair.getValidityPeriod())){
		TemporalPair auxPair = new TemporalPair(new TemporalInterval(mPair.getValidityPeriod().getEndingTimePoint(),nPair.getValidityPeriod().getEndingTimePoint()),
												nPair.getData());
		ParallelIteratingPair rPair = new ParallelIteratingPair(mPair.getValidityPeriod(),
																mPair.getData(),nPair.getData());
		nPairs.add(auxPair);
		rPairs = this.iterate(mPairs, nPairs);
		rPairs.add(0,rPair);
	}
	else if (mPair.getValidityPeriod().startedBy(nPair.getValidityPeriod())){
		TemporalPair auxPair = new TemporalPair(new TemporalInterval(nPair.getValidityPeriod().getEndingTimePoint(),mPair.getValidityPeriod().getEndingTimePoint()),
												mPair.getData());
		ParallelIteratingPair rPair = new ParallelIteratingPair(nPair.getValidityPeriod(),
																mPair.getData(),nPair.getData());
		mPairs.add(auxPair);
		rPairs = this.iterate(mPairs, nPairs);
		rPairs.add(0,rPair);
	}
	else if (mPair.getValidityPeriod().overlaps(nPair.getValidityPeriod())){
		TemporalPair auxPair = new TemporalPair(new TemporalInterval(mPair.getValidityPeriod().getEndingTimePoint(),nPair.getValidityPeriod().getEndingTimePoint()),
												nPair.getData());
		ParallelIteratingPair rPair1 = new ParallelIteratingPair(new TemporalInterval(mPair.getValidityPeriod().getInitialTimePoint(),nPair.getValidityPeriod().getInitialTimePoint()),
																 mPair.getData(),noData);
		ParallelIteratingPair rPair2 = new ParallelIteratingPair(new TemporalInterval(nPair.getValidityPeriod().getInitialTimePoint(),mPair.getValidityPeriod().getEndingTimePoint()),
																 mPair.getData(),nPair.getData());
		nPairs.add(auxPair);
		rPairs = this.iterate(mPairs, nPairs);
		rPairs.add(0,rPair2);
		rPairs.add(0,rPair1);
	}
	else if (mPair.getValidityPeriod().overlappedBy(nPair.getValidityPeriod())){
		TemporalPair auxPair = new TemporalPair(new TemporalInterval(nPair.getValidityPeriod().getEndingTimePoint(),mPair.getValidityPeriod().getEndingTimePoint()),
				mPair.getData());
		ParallelIteratingPair rPair1 = new ParallelIteratingPair(new TemporalInterval(nPair.getValidityPeriod().getInitialTimePoint(),mPair.getValidityPeriod().getInitialTimePoint()),
																noData,nPair.getData());
		ParallelIteratingPair rPair2 = new ParallelIteratingPair(new TemporalInterval(mPair.getValidityPeriod().getInitialTimePoint(),nPair.getValidityPeriod().getEndingTimePoint()),
								 								mPair.getData(),nPair.getData());
		mPairs.add(auxPair);
		rPairs = this.iterate(mPairs, nPairs);
		rPairs.add(0,rPair2);
		rPairs.add(0,rPair1);
	}
	else if (mPair.getValidityPeriod().meets(nPair.getValidityPeriod())
			|| mPair.getValidityPeriod().before(nPair.getValidityPeriod())){
		ParallelIteratingPair rPair = new ParallelIteratingPair(mPair.getValidityPeriod(),
																mPair.getData(),noData);
		nPairs.add(nPair);
		rPairs = this.iterate(mPairs, nPairs);
		rPairs.add(0,rPair);
	}
	else if (mPair.getValidityPeriod().metBy(nPair.getValidityPeriod())
			|| mPair.getValidityPeriod().after(nPair.getValidityPeriod())){
		ParallelIteratingPair rPair = new ParallelIteratingPair(nPair.getValidityPeriod(),
																noData,nPair.getData());
		mPairs.add(mPair);
		rPairs = this.iterate(mPairs, nPairs);
		rPairs.add(0,rPair);
	}
	
	return rPairs;
}

public InverseTemporalSequence getInverseTemporalSequence(){
	// Precondition: ts is a normalized temporal sequence
	if (!this.isNormalized()) this.normalize();
	
	InverseTemporalSequence its = new InverseTemporalSequence(this.getValidityPeriod());
	
	for(TemporalPair tp: this.getPairs()){
		int index = its.search(tp.getData());
		if (index == -1) {
			InverseTemporalPair itp = new InverseTemporalPair(tp.getData());
			itp.addValidityPeriod(tp.getValidityPeriod());
			its.add(itp);
		}
		else {
			InverseTemporalPair itp = its.getPairs().get(index);
			itp.addValidityPeriod(tp.getValidityPeriod());
		}
	}
	
	return its;
}

}
