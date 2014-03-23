package es.us.isa.parser;

public class WsagObject {

	String xmlHeader = "";
	String template = "";
	String metric = "", version = "", name = "";
	String context = "";
	String serviceName = "", serviceURL = "";
	String servDescTerms = "";
	String serviceProps = "";
	String cc = "";

	public WsagObject() {
	}

	public String getXmlHeader() {
		return xmlHeader;
	}

	public void setXmlHeader(String xmlHeader) {
		this.xmlHeader = xmlHeader;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getMetric() {
		return metric;
	}

	public void setMetric(String metric) {
		this.metric = metric;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public String getServiceURL() {
		return serviceURL;
	}

	public void setServiceURL(String serviceURL) {
		this.serviceURL = serviceURL;
	}

	public String getServiceDescTerms() {
		return servDescTerms;
	}

	public void setServiceDescTerms(String servDescTerms) {
		this.servDescTerms = servDescTerms;
	}

	public String getServiceProperties() {
		return serviceProps;
	}

	public void setServiceProperties(String serviceProps) {
		this.serviceProps = serviceProps;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}
}
