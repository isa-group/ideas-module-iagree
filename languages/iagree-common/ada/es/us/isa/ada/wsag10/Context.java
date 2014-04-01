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

import java.util.Date;

import es.us.isa.ada.document.AgreementElement;

/**
 * @author    cmuller
 */
public class Context extends AgreementElement{

	/**
	 * @uml.property  name="serviceProviderRole"
	 */
	private String serviceProviderRole;
	/**
	 * @uml.property  name="agreementInitiator"
	 */
	private String agreementInitiator;
	/**
	 * @uml.property  name="agreementResponder"
	 */
	private String agreementResponder;
	/**
	 * @uml.property  name="templateName"
	 */
	private String templateName;
	/**
	 * @uml.property  name="templateId"
	 */
	private String templateId;
	/**
	 * @uml.property  name="expirationTime"
	 */
	private Date expirationTime;
	/**
	 * @uml.property  name="extraTime"
	 */
	private String extraTime;
	
	public Context(){
		setName("Context");
	}
	
	/**
	 * @return
	 * @uml.property  name="serviceProviderRole"
	 */
	public String getServiceProviderRole() {
		return serviceProviderRole;
	}
	/**
	 * @param  serviceProviderRole
	 * @uml.property  name="serviceProviderRole"
	 */
	public void setServiceProviderRole(String serviceProviderRole) {
		this.serviceProviderRole = serviceProviderRole;
	}
	/**
	 * @return
	 * @uml.property  name="agreementInitiator"
	 */
	public String getAgreementInitiator() {
		return agreementInitiator;
	}
	/**
	 * @param  agreementInitiator
	 * @uml.property  name="agreementInitiator"
	 */
	public void setAgreementInitiator(String agreementInitiator) {
		this.agreementInitiator = agreementInitiator;
	}
	/**
	 * @return
	 * @uml.property  name="agreementResponder"
	 */
	public String getAgreementResponder() {
		return agreementResponder;
	}
	/**
	 * @param  agreementResponder
	 * @uml.property  name="agreementResponder"
	 */
	public void setAgreementResponder(String agreementResponder) {
		this.agreementResponder = agreementResponder;
	}
	/**
	 * @return
	 * @uml.property  name="templateName"
	 */
	public String getTemplateName() {
		return templateName;
	}
	/**
	 * @param  templateName
	 * @uml.property  name="templateName"
	 */
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	/**
	 * @return
	 * @uml.property  name="templateId"
	 */
	public String getTemplateId() {
		return templateId;
	}
	/**
	 * @param  templateId
	 * @uml.property  name="templateId"
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}
	/**
	 * @return
	 * @uml.property  name="expirationTime"
	 */
	public Date getExpirationTime() {
		return expirationTime;
	}
	/**
	 * @param  expirationTime
	 * @uml.property  name="expirationTime"
	 */
	public void setExpirationTime(Date expirationTime) {
		this.expirationTime = expirationTime;
	}
	/**
	 * @param  extraTime
	 * @uml.property  name="extraTime"
	 */
	public void setExtraTime(String extraTime) {
		this.extraTime = extraTime;
	}
	/**
	 * @return
	 * @uml.property  name="extraTime"
	 */
	public String getExtraTime() {
		return extraTime;
	}
	
	
}
