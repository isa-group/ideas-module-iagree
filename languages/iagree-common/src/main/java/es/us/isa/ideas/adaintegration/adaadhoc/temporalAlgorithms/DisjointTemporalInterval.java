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

import java.util.Comparator;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.ArrayList;

public class DisjointTemporalInterval {
	protected TreeSet<TemporalInterval> list;

	protected static TreeSet<TemporalInterval> CreateList(){
		TreeSet<TemporalInterval> list = new TreeSet<TemporalInterval>(
				new Comparator<TemporalInterval>() {
					public int compare(TemporalInterval ti1, TemporalInterval ti2){
						return ti1.compare(ti2);
					}
				}
		);
		
		return list;
	}
	
	public DisjointTemporalInterval() {
		this.list = CreateList();
	}
	
	public DisjointTemporalInterval(ArrayList<TemporalInterval> list){
		this.list = CreateList();
		for (TemporalInterval ti: list)
			this.list.add(ti);
	}

	public DisjointTemporalInterval(TreeSet<TemporalInterval> list){
		this.list = CreateList();
		for (TemporalInterval ti: list)
			this.list.add(ti);
	}
	
	public void add(TemporalInterval ti){
		list.add(ti);
	}

	public boolean isEmpty(){
		return list.isEmpty();
	}

	public DisjointTemporalInterval except(DisjointTemporalInterval dti){
		//System.out.println("Computing except...");
		
		// This a clone, but unfortunately I don't manage to use it (!)
		DisjointTemporalInterval dtiNew = new DisjointTemporalInterval();
		for (TemporalInterval ti: this.list)
			dtiNew.add(ti);
		
		dtiNew.remove(dti.getList());
		
		//System.out.println("Computing except has just finished!");
		
		return dtiNew;
	}
	
	public void remove(TreeSet<TemporalInterval> list2){
		//System.out.print("Disjoint Temporal Interval is: "); 
		//for(TemporalInterval ti: this.list)
		//	System.out.print("[" + ti.getInitialTimePoint().getTick()+","+ti.getEndingTimePoint().getTick()+")");
		//System.out.println();
		
		for(TemporalInterval ti: list2){
			//System.out.println("Removing [" + ti.getInitialTimePoint().getTick()+","+ti.getEndingTimePoint().getTick()+")");
			remove(ti);
		}	

		//System.out.print("Resulting Disjoint Temporal Interval is: "); 
		//for(TemporalInterval ti: this.list)
		//	System.out.print("[" + ti.getInitialTimePoint().getTick()+","+ti.getEndingTimePoint().getTick()+")");
		//System.out.println();
	}
	
	private void remove(TemporalInterval ti){
		DisjointTemporalInterval newNotCovering = new DisjointTemporalInterval();
		
		for(TemporalInterval tiCovering: list){
			DisjointTemporalInterval notCovering = tiCovering.extract(ti);
			if (!notCovering.isEmpty()) 
				for (TemporalInterval tiNotCovering: notCovering.getList())
					newNotCovering.add(tiNotCovering); 
		}
		
		list = newNotCovering.getList();
	}

	public TreeSet<TemporalInterval> getList() {
		return list;
	}
	
	public boolean equals(DisjointTemporalInterval dti){
		if (this.list.size() != dti.getList().size())
			return false;
		
		for (Iterator<TemporalInterval> i1 = this.list.iterator(), i2 = dti.getList().iterator(); i1.hasNext() && i2.hasNext();){
			TemporalInterval ti1 = i1.next(), ti2 = i2.next();
			if (!ti1.equals(ti2)) 
				return false; 
		}
		
		return true;

	}
}
