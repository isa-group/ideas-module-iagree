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

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class BusinessValueList {
	protected int importance; //a relative importance between terms is an unbounded int value
	protected Collection<Preference> preferences; //0..* 
	protected Collection<CustomBusinessValue> customBVLs; //0..*
	protected Collection<Penalty> penalties; //0..*
	protected Collection<Reward> rewards; //0..*
	
	
	public BusinessValueList() {
		importance = 0;
		preferences = new LinkedList<Preference>();
		customBVLs = new LinkedList<CustomBusinessValue>();
		penalties = new LinkedList<Penalty>();
		rewards = new LinkedList<Reward>();
	}

	public int getImportance() {
		return importance;
	}

	public void setImportance(int importance) {
		this.importance = importance;
	}

	public Collection<Preference> getPreferences() {
		return preferences;
	}

	public void setPreferences(Collection<Preference> preferences) {
		this.preferences = preferences;
	}
	
	public void addPreference(Preference preference) {
		if (this.preferences == null) {
			this.preferences = new HashSet<Preference>();
		}
		this.preferences.add(preference);
	}

	public Collection<CustomBusinessValue> getCustomBVLs() {
		return customBVLs;
	}

	public void setCustomBVLs(Collection<CustomBusinessValue> customBVLs) {
		this.customBVLs = customBVLs;
	}

	public Collection<Penalty> getPenalties() {
		return penalties;
	}

	public void setPenalties(Collection<Penalty> penalties) {
		this.penalties = penalties;
	}
	
	public void addPenalty(Penalty penalty) {
		if (this.penalties == null) {
			this.penalties = new HashSet<Penalty>();
		}
		this.penalties.add(penalty);
	}

	public Collection<Reward> getRewards() {
		return rewards;
	}

	public void setRewards(Collection<Reward> rewards) {
		this.rewards = rewards;
	}
	
	public void addReward(Reward reward) {
		if (this.rewards == null) {
			this.rewards = new HashSet<Reward>();
		}
		this.rewards.add(reward);
	}
	

}
