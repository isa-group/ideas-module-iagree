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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import es.us.isa.ada.salmon.WebServiceInformation;

/**
 * TODO vamos a tener que tocar aqui para permitir indicar el dominio
 * de cada uno de los offer item de los service description terms
 * 
 * @author    cmuller
 */
public class ServiceDescriptionTerm extends ServiceTerm {
	
	/**
	 * @uml.property  name="serviceFeatures"
	 */
	private Map<Variable,Restriction> serviceFeatures;
	
	private Map<String,Restriction> spServiceFeatures;
	
	private Collection<String> duplicatedServiceFeatures;
	
	private Collection<OfferItem> offerItems;
	
	private WebServiceInformation webServiceInfo;
	
	public ServiceDescriptionTerm(){
		serviceFeatures = new HashMap<Variable,Restriction>();
		spServiceFeatures = new HashMap<String,Restriction>();
		duplicatedServiceFeatures = new HashSet<String>();
		offerItems = new HashSet<OfferItem>();
	}
	
	/**
	 * @return
	 * @uml.property  name="serviceFeatures"
	 */
	public Map<Variable,Restriction> getServiceFeatures() {
		return serviceFeatures;
	}
	
	public Map<String,Restriction> getSPServiceFeatures(){
		return spServiceFeatures;
	}
	/**
	 * @param  serviceFeatures
	 * @uml.property  name="serviceFeatures"
	 */
	public void setServiceFeatures(Map<Variable,Restriction> serviceFeatures) {
		this.serviceFeatures.putAll(serviceFeatures);
	}
	
	public Restriction getFeatureValue(String feature){
		return spServiceFeatures.get(feature);
	}
	
	public Restriction getFeatureValue(Variable feature){
		return serviceFeatures.get(feature);
	}
	
	public void setFeature(Variable var, Restriction value){
		if (serviceFeatures.containsKey(var)){
			duplicatedServiceFeatures.add(var.getUniqueName());
		}
		serviceFeatures.put(var, value);
		offerItems.add(createOfferItem(var.getName(), value));
	}
	
	public void setFeature(String var, Restriction value){
		if (spServiceFeatures.containsKey(var)){
			duplicatedServiceFeatures.add(var);
		}
		spServiceFeatures.put(var, value);
		offerItems.add(createOfferItem(var, value));
	}
	
	public Collection<String> getDuplicatedServiceFeatures(){
		return duplicatedServiceFeatures;
	}
	
	private OfferItem createOfferItem(String var, Restriction r){
		return new OfferItem(this, var, r);
	}
	
	public boolean hasDuplicatedServiceFeatures(){
		return (duplicatedServiceFeatures.size() > 0);
	}
	
	public WebServiceInformation getWebServiceInformation(){
		return webServiceInfo;
	}
	
	public void setWebServiceInformation(WebServiceInformation wsi){
		this.webServiceInfo = wsi;
	}
	
	public Collection<OfferItem> getOfferItems(){
		return offerItems;
	}
	
//	public void setServiceInformation(String name, String description, String domain, String wsdlURL, String endpoint){
//		webServiceInfo.setName(name);
//		webServiceInfo.setDescription(description);
//		webServiceInfo.setDomain(domain);
//		webServiceInfo.setWsdlURL(wsdlURL);
//		webServiceInfo.setEndpoint(endpoint);
//	}
//	
//	public void setServiceInfoOperations(Map<String, String> operations){
//		webServiceInfo.setOperations(operations);
//	}
//	
//	public void setServiceInfoOperation(String name, String soapAction){
//		webServiceInfo.setOperation(name, soapAction);
//	}
}
