package es.us.isa.ideas.parser;

import es.us.isa.ideas.util.KeyValueProp;
import es.us.isa.ideas.util.Range;

public class WsagObject {

	public WsagObject() {
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getAggOffer() {
		return aggOffer;
	}

	public void setAggOffer(String aggOffer) {
		this.aggOffer = aggOffer;
	}

	public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

	public String getTemplateName() {
		return name;
	}

	public void setTemplateName(String name) {
		this.name = name;
	}

	public String getVersionNumber() {
		return versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		this.versionNumber = versionNumber;
	}

	public String getTemplateDef() {
		return templateDef;
	}

	public void setTemplateDef(String templateDef) {
		this.templateDef = templateDef;
	}

	public String getAggTemplate() {
		return aggTemplate;
	}

	public void setAggTemplate(String aggTemplate) {
		this.aggTemplate = aggTemplate;
	}

	public String getAggDef() {
		return aggDef;
	}

	public void setAggDef(String aggDef) {
		this.aggDef = aggDef;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getAgreementTerms() {
		return agreementTerms;
	}

	public void setAgreementTerms(String agreementTerms) {
		this.agreementTerms = agreementTerms;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getAgreementTermsDef() {
		return agreementTermsDef;
	}

	public void setAgreementTermsDef(String agreementTermsDef) {
		this.agreementTermsDef = agreementTermsDef;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getMonitorableProperties() {
		return monitorableProperties;
	}

	public void setMonitorableProperties(String monitorableProperties) {
		this.monitorableProperties = monitorableProperties;
	}

	public String getGuaranteeTerms() {
		return guaranteeTerms;
	}

	public void setGuaranteeTerms(String guaranteeTerms) {
		this.guaranteeTerms = guaranteeTerms;
	}

	public String getGuaranteeTerm() {
		return guaranteeTerm;
	}

	public void setGuaranteeTerm(String guaranteeTerm) {
		this.guaranteeTerm = guaranteeTerm;
	}

	public String getGroupedGuaranteeTerm() {
		return groupedGuaranteeTerm;
	}

	public void setGroupedGuaranteeTerm(String groupedGuaranteeTerm) {
		this.groupedGuaranteeTerm = groupedGuaranteeTerm;
	}

	public String getGuaranteeDef() {
		return guaranteeDef;
	}

	public void setGuaranteeDef(String guaranteeDef) {
		this.guaranteeDef = guaranteeDef;
	}

	public String getGuaranteeDefObligated() {
		return guaranteeDefObligated;
	}

	public void setGuaranteeDefObligated(String guaranteeDefObligated) {
		this.guaranteeDefObligated = guaranteeDefObligated;
	}

	public String getOfferItems() {
		return offerItems;
	}

	public void setOfferItems(String offerItems) {
		this.offerItems = offerItems;
	}

	public String getServiceUrl() {
		return serviceUrl;
	}

	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTypeArg() {
		return typeArg;
	}

	public void setTypeArg(String typeArg) {
		this.typeArg = typeArg;
	}

	public KeyValueProp getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(KeyValueProp keyValue) {
		this.keyValue = keyValue;
	}

	public String getListValues() {
		return listValues;
	}

	public void setListValues(String listValues) {
		this.listValues = listValues;
	}

	public String getServiceProperties() {
		return serviceProperties;
	}

	public void setServiceProperties(String serviceProperties) {
		this.serviceProperties = serviceProperties;
	}

	public String getVariablesSet() {
		return variablesSet;
	}

	public void setVariablesSet(String variablesSet) {
		this.variablesSet = variablesSet;
	}

	public String getCuantif() {
		return cuantif;
	}

	public void setCuantif(String cuantif) {
		this.cuantif = cuantif;
	}

	public String getOnlyIf() {
		return onlyIf;
	}

	public void setOnlyIf(String onlyIf) {
		this.onlyIf = onlyIf;
	}

	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public String getAssigValue() {
		return assigValue;
	}

	public void setAssigValue(String assigValue) {
		this.assigValue = assigValue;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public Range getRange() {
		return range;
	}

	public void setRange(Range range) {
		this.range = range;
	}

	String result = "";
	String template = "";
	String aggOffer = "";
	String aggTemplate = "";
	String aggTemplateId = "";
	String aggDef = "";
	String metric = "";
	String name = "";
	String versionNumber = "";
	String templateDef = "";
	String context = "";
	String serviceName = "";
	String agreementTerms = "";
	String cc = "";
	String agreementTermsDef = "";
	String service = "";
	String monitorableProperties = "";
	String guaranteeTerms = "";
	String guaranteeTerm = "";
	String groupedGuaranteeTerm = "";
	String guaranteeDef = "";
	String guaranteeDefObligated = "";
	String offerItems = "";
	String serviceUrl = "";
	String type = "";
	String typeArg = "";
	KeyValueProp keyValue = new KeyValueProp();
	String listValues = "";
	String serviceProperties = "";
	String variablesSet = "";
	String cuantif = "";
	String onlyIf = "";
	String expression = "";
	String assigValue = "";
	String operation = "";
	Range range = new Range();

}
