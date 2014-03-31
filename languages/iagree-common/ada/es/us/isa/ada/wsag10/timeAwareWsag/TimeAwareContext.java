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

package es.us.isa.ada.wsag10.timeAwareWsag;

import java.util.HashMap;
import java.util.Map;

import es.us.isa.ada.wsag10.Context;
import es.us.isa.temporalAlgorithms.RealTemporalInterval;

public class TimeAwareContext extends Context{

	private RealTemporalInterval globalPeriod;
	
	private Map<String, RealTemporalInterval> periods;
	
	private String gmtZone;
	
	private String dateFormat;

	public TimeAwareContext(){
		this.periods = new HashMap<String, RealTemporalInterval>();
	}
	
	/**
	 * Creates a new TimeAwareContext with the information of
	 * a Context
	 * @param c context
	 */
	public TimeAwareContext(Context c){
		setAgreementInitiator(c.getAgreementInitiator());
		setAgreementResponder(c.getAgreementResponder());
		setAnalysable(c.isAnalysable());
		setExpirationTime(c.getExpirationTime());
		setExtraTime(c.getExtraTime());
		setName(c.getName());
		setServiceProviderRole(c.getServiceProviderRole());
		setTemplateId(c.getTemplateId());
		setTemplateName(c.getTemplateName());
		this.periods = new HashMap<String, RealTemporalInterval>();
	}
	
	public RealTemporalInterval getGlobalPeriod(){
		return this.globalPeriod;
	}
	
	public Map<String, RealTemporalInterval> getPeriods(){
		return this.periods;
	}
	
	public void setGlobalPeriod(RealTemporalInterval rti){
		this.globalPeriod = rti;
	}
	
	public void setPeriods(Map<String, RealTemporalInterval> rtis){
		this.periods.putAll(rtis);
	}
	
	/**
	 * Associates the specified name with the specified interval
	 * @param intervalName 
	 * @param rti interval
	 */
	public void addPeriod(String intervalName, RealTemporalInterval rti){
		periods.put(intervalName, rti);
	}
	
	/**
	 * 
	 * @param periodName name associated to an interval
	 * @return Interval associated to the specified name, or null if this name has
	 * no associated intervals
	 */
	public RealTemporalInterval getPeriod(String periodName){
		return periods.get(periodName);
	}

	public void setGmtZone(String gmtZone) {
		this.gmtZone = gmtZone;
	}

	public String getGmtZone() {
		return gmtZone;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getDateFormat() {
		return dateFormat;
	}
}
