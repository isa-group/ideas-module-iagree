package es.us.isa.parser;

import java.util.Calendar;

import es.us.isa.parser.iAgreeParser.AgOfferContext;
import es.us.isa.parser.iAgreeParser.EntryContext;
import es.us.isa.parser.iAgreeParser.TemplateContext;

public class MiAgreeListener2 extends iAgreeBaseListener {

	// Global vars:
	String wsag = "";
	String xmlHeader = "<?xml version=\"1.0\" encoding = \"UTF-8\"?>\n";
	String metric = "";

	String context = "";
	String terms = "";
	String serviceName = "";
	String offerItems = "";
	String variablesSet = "";
	String cc = "";

	String metricsTemplate = "";

	String agg_template = "";
	String agg_temId = "";

	String result = "";

	@Override
	public void enterEntry(EntryContext ctx) {
		// TODO Auto-generated method stub
		super.enterEntry(ctx);
		wsag = xmlHeader + result;
	}

	@Override
	public void enterTemplate(TemplateContext ctx) {
		// TODO Auto-generated method stub
		super.enterTemplate(ctx);
		// metric = $IDENT.text + "_" +
		// Calendar.getInstance().getTimeInMillis();

		result = "<wsag:Template wsag:TemplateId=\""
				+ $version.result
				+ "\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"  \n"
				+ " xmlns:wsag=\"http://schemas.ggf.org/graap/2007/03/ws-agreement\" \n"
				+ " xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" \n"
				+ " xsi:schemaLocation=\"http://schemas.ggf.org/graap/2007/03/wsagreement\" \n"
				+ " agreement_types.xsd=\"http://www.w3.org/2001/XMLSchema XMLSchema.xsd\" >\n"
				+ "	<wsag:Name >" + $IDENT.text + "</wsag:Name>\n"
				+ $template_def.result + "</wsag:Template>";
	}
	
	@Override
	public void enterAgOffer(AgOfferContext ctx) {
		// TODO Auto-generated method stub
		super.enterAgOffer(ctx);
		
		metric = $i1.text+"_"+Calendar.getInstance().getTimeInMillis();
		
		agg_template = "		<wsag:TemplateId>"+$v2.result+"</wsag:TemplateId>\n";
		agg_temId = "		<wsag:TemplateName>"+$i2.text+"</wsag:TemplateName>\n";
	}

	public String withoutQuotes(String s) {
		String str = s;
		if (str.startsWith("\"")) {
			str = str.substring(1, str.length());
		}
		if (str.endsWith("\"")) {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}

	public String convertEntities(String s) {
		String str = s;
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		return str;
	}

	public String convertMetricType(String originalType) {
		String newType = originalType;

		if (originalType != null) {
			newType = newType.toLowerCase();

			if (originalType.equals("float") || originalType.equals("double")
					|| originalType.equals("natural")
					|| originalType.equals("number")
					|| originalType.equals("cost")
					|| originalType.equals("time")
					|| originalType.equals("size")
					|| originalType.equals("errors")
					|| originalType.equals("money")
					|| originalType.equals("percent")
					|| originalType.equals("integer")
					|| originalType.equals("string")) {
				newType = "integer";
			} else {
				newType = "enumerated";
			}
		}

		return newType;
	}

	public String getMetrics() {
		return metricsTemplate;
	}

	public String getMetricsName() {
		return metric;
	}

}
