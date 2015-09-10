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

package es.us.isa.ideas.adaintegration.adaadhoc.temporalAlgorithms;

import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.ArrayList;

public class PointBasedNormalization extends TemporalSequence {
	public void normalize() {
		normalizationSteps = 0;
		divideAndRuleSteps = 0;
		coalescingSteps = 0;
		
		pairs = makeUnambiguous(pairs);
	}
	
	protected TreeSet<TemporalPair> makeUnambiguous(TreeSet<TemporalPair> mPairs) 
	{
		//TreeSet<PointBasedTemporalPair> rPoints = splitting(mPairs);
		
		/*System.out.print("The temporary splitted sequence is: <<");
		for (PointBasedTemporalPair tp: rPoints){
			System.out.print("(" + tp.getTimePoint().getTick() + ",");
			if (tp.getPosition() == IntervalPosition.BEGIN)
				System.out.print("B,");
			else 
				System.out.print("E,");
			System.out.print(tp.getData()+")");
		}
		System.out.println(">>");*/
		
		//return coalesce(timing(rPoints));
		return coalesce(timing(splitting(mPairs)));
	}
	
	private TreeSet<PointBasedTemporalPair> splitting(TreeSet<TemporalPair> mPairs)
	{
		TreeSet<PointBasedTemporalPair> rPoints = PointBasedTemporalSequence.CreatePairs();
		
		for (TemporalPair mPair: mPairs){
			PointBasedTemporalPair rBeginPoint 
				= new PointBasedTemporalPair(mPair.getValidityPeriod().getInitialTimePoint(),IntervalPosition.BEGIN,mPair.getData());
			PointBasedTemporalPair rEndPoint 
				= new PointBasedTemporalPair(mPair.getValidityPeriod().getEndingTimePoint(),IntervalPosition.END,mPair.getData());
			rPoints.add(rBeginPoint);
			rPoints.add(rEndPoint);
		}

		return rPoints;
	}
	
	private TreeSet<TemporalPair> timing(TreeSet<PointBasedTemporalPair> mPoints)
	{
		TreeSet<TemporalPair> rPairs = CreatePairs();
		ArrayList<Object> pendingData = new ArrayList<Object>(); // Duplicated items have to be allowed !!!
		PointBasedTemporalPair mPoint1, mPoint2;
		TemporalPair rPair;
		
		// Ordinary transitions
		while (mPoints.size() > 2){
			mPoint1 = mPoints.pollFirst();
			mPoint2 = mPoints.pollFirst();
			 
			normalizationSteps++;
	
			/*System.out.print("(" + mPoint1.getTimePoint().getTick() + ",");
			if (mPoint1.getPosition() == IntervalPosition.BEGIN)
				System.out.print("B,");
			else 
				System.out.print("E,");
			System.out.print(mPoint1.getData()+") and ");*/
			
			/*System.out.print("(" + mPoint2.getTimePoint().getTick() + ",");
			if (mPoint2.getPosition() == IntervalPosition.BEGIN)
				System.out.print("B,");
			else 
				System.out.print("E,");
			System.out.print(mPoint2.getData()+") with relationship ");*/
			
			if (mPoint1.isNonSimultaneousBeginBeginRelationship(mPoint2)){
				//System.out.print("NSBB results: ");
				pendingData.addAll(mPoint1.getData());
				LinkedHashSet<Object> auxData = new LinkedHashSet<Object>();
				auxData.addAll(pendingData);
				rPair = new TemporalPair(new TemporalInterval(mPoint1.getTimePoint(),mPoint2.getTimePoint()),auxData);
				mPoints.add(mPoint2);
				rPairs.add(rPair);
								
				//System.out.print("([" + rPair.getValidityPeriod().getInitialTimePoint().getTick() + ","
				//		+ rPair.getValidityPeriod().getEndingTimePoint().getTick() + ")," 
				//		+ rPair.getData() + ")");				
			}            
			else if (mPoint1.isSimultaneousBeginBeginRelationship(mPoint2)){
				//System.out.print("SBB results: ");
				pendingData.addAll(mPoint1.getData());	
				mPoints.add(mPoint2);
			}
			else if (mPoint1.isNonSimultaneousEndBeginRelationship(mPoint2)){
				//System.out.print("NSEB results: ");
				for(Object data: mPoint1.getData()) pendingData.remove(data);
				if (!pendingData.isEmpty()){
					LinkedHashSet<Object> auxData = new LinkedHashSet<Object>();
					auxData.addAll(pendingData);
					rPair = new TemporalPair(new TemporalInterval(mPoint1.getTimePoint(),mPoint2.getTimePoint()),auxData);
					rPairs.add(rPair);
					
					//System.out.print("([" + rPair.getValidityPeriod().getInitialTimePoint().getTick() + ","
					//		+ rPair.getValidityPeriod().getEndingTimePoint().getTick() + ")," 
					//		+ rPair.getData() + ")");
				}
				//else
				//	System.out.print("");
				
				mPoints.add(mPoint2);
			}
			else if (mPoint1.isSimultaneousEndBeginRelationship(mPoint2)){
				// System.out.print("SEB: This case is not possible !!!");
				// This case is not possible because of the construction of the point-based temporal sequence
			}
			else if (mPoint1.isNonSimultaneousBeginEndRelationship(mPoint2)){
				//System.out.print("NSBE results: ");
				pendingData.addAll(mPoint1.getData());
				LinkedHashSet<Object> auxData = new LinkedHashSet<Object>();
				auxData.addAll(pendingData);
				rPair = new TemporalPair(new TemporalInterval(mPoint1.getTimePoint(),mPoint2.getTimePoint()),auxData);
				mPoints.add(mPoint2);
				rPairs.add(rPair);
				
				//System.out.print("([" + rPair.getValidityPeriod().getInitialTimePoint().getTick() + ","
				//		+ rPair.getValidityPeriod().getEndingTimePoint().getTick() + ")," 
				//		+ rPair.getData() + ")");
			}
			else if (mPoint1.isSimultaneousBeginEndRelationship(mPoint2)){
				//System.out.print("SBE results: ");
				for(Object data: mPoint2.getData()) pendingData.remove(data);
				mPoints.add(mPoint1); // These lines are ok!
			}
			else if (mPoint1.isNonSimultaneousEndEndRelationship(mPoint2)){
				//System.out.print("NSEE results: ");
				for(Object data: mPoint1.getData()) pendingData.remove(data);
				LinkedHashSet<Object> auxData = new LinkedHashSet<Object>();
				auxData.addAll(pendingData);
				rPair = new TemporalPair(new TemporalInterval(mPoint1.getTimePoint(),mPoint2.getTimePoint()),auxData);
				mPoints.add(mPoint2);
				rPairs.add(rPair);
				
				//System.out.print("([" + rPair.getValidityPeriod().getInitialTimePoint().getTick() + ","
				//		+ rPair.getValidityPeriod().getEndingTimePoint().getTick() + ")," 
				//		+ rPair.getData() + ")");	
			}
			else { // this is the case mPoint1.isSimultaneousEndEndRelationship(mPoint2)
				//System.out.print("SEE results: ");
				for(Object data: mPoint1.getData()) pendingData.remove(data);
				mPoints.add(mPoint2);
			}
			
			// System.out.println("/ remaining q is " + pendingData);
		}
		
		// Terminal transitions: It should remain two point-based temporal pairs to process!
		mPoint1 = mPoints.pollFirst();
		mPoint2 = mPoints.pollFirst();
		
		normalizationSteps++;
		
		/*System.out.print("Final Step: (" + mPoint1.getTimePoint().getTick() + ",");
		if (mPoint1.getPosition() == IntervalPosition.BEGIN)
			System.out.print("B,");
		else 
			System.out.print("E,");
		System.out.print(mPoint1.getData()+") and ");*/
		
		/*System.out.print("(" + mPoint2.getTimePoint().getTick() + ",");
		if (mPoint2.getPosition() == IntervalPosition.BEGIN)
			System.out.print("B,");
		else 
			System.out.print("E,");
		System.out.print(mPoint2.getData()+") with relationship ");*/
		
		if (mPoint1.isNonSimultaneousBeginBeginRelationship(mPoint2)){
			// This case is not possible because of the construction of the point-based temporal sequence
		}            
		else if (mPoint1.isSimultaneousBeginBeginRelationship(mPoint2)){
			// This case is not possible because of the construction of the point-based temporal sequence
		}
		else if (mPoint1.isNonSimultaneousEndBeginRelationship(mPoint2)){
			// This case is not possible because of the construction of the point-based temporal sequence
		}
		else if (mPoint1.isSimultaneousEndBeginRelationship(mPoint2)){
			// This case is not possible because of the construction of the point-based temporal sequence
		}
		else if (mPoint1.isNonSimultaneousBeginEndRelationship(mPoint2)){
			rPair = new TemporalPair(new TemporalInterval(mPoint1.getTimePoint(),mPoint2.getTimePoint()),mPoint1.getData());
			rPairs.add(rPair);
			
			//System.out.println("([" + rPair.getValidityPeriod().getInitialTimePoint().getTick() + ","
			//		+ rPair.getValidityPeriod().getEndingTimePoint().getTick() + ")," 
			//		+ rPair.getData() + ")");	
		}
		else if (mPoint1.isSimultaneousBeginEndRelationship(mPoint2)){
			// This case is not possible because of the construction of the point-based temporal sequence
		}
		else if (mPoint1.isNonSimultaneousEndEndRelationship(mPoint2)){
			rPair = new TemporalPair(new TemporalInterval(mPoint1.getTimePoint(),mPoint2.getTimePoint()),mPoint2.getData());
			rPairs.add(rPair);
			
			//System.out.println("([" + rPair.getValidityPeriod().getInitialTimePoint().getTick() + ","
			//		+ rPair.getValidityPeriod().getEndingTimePoint().getTick() + ")," 
			//		+ rPair.getData() + ")");
		}
		else { // this is the case mPoint1.isSimultaneousEndEndRelationship(mPoint2)
			// It is nothing to do at this point
			// System.out.println();
		}
				
		return rPairs;
	}
}
