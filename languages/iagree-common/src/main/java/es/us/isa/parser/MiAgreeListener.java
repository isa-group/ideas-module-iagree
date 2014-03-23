package es.us.isa.parser;

import java.util.Calendar;

import es.us.isa.parser.iAgreeParser.EntryContext;
import es.us.isa.parser.iAgreeParser.GlobalDescriptionContext;
import es.us.isa.parser.iAgreeParser.Global_MonitorablePropertiesContext;
import es.us.isa.parser.iAgreeParser.Key_value_propContext;
import es.us.isa.parser.iAgreeParser.ServiceContext;
import es.us.isa.parser.iAgreeParser.Temp_propertiesContext;
import es.us.isa.parser.iAgreeParser.TemplateContext;
import es.us.isa.util.Util;

public class MiAgreeListener extends iAgreeBaseListener {

	// Global vars:
	WsagObject wsag = null;

	@Override
	public void enterEntry(EntryContext ctx) {
		super.enterEntry(ctx);
		wsag = new WsagObject();
		wsag.setXmlHeader("<?xml version=\"1.0\" encoding = \"UTF-8\"?>\n");
	}

	@Override
	public void enterTemplate(TemplateContext ctx) {
		// TODO Auto-generated method stub
		super.enterTemplate(ctx);

		wsag.setMetric(ctx.Identifier().getText() + "_"
				+ Calendar.getInstance().getTimeInMillis());
		wsag.setVersion(ctx.versionNumber().getText());
		wsag.setName(ctx.Identifier().getText());
	}

	@Override
	public void enterTemp_properties(Temp_propertiesContext ctx) {
		// TODO Auto-generated method stub
		super.enterTemp_properties(ctx);

		if (ctx.initiator_prop() != null) {
			wsag.setContext(wsag.getContext()
					+ "\t\t<wsag:AgreementInitiator >"
					+ Util.withoutQuotes(ctx.initiator_prop().String()
							.getText()) + "</wsag:AgreementInitiator >\n");
		} else if (ctx.responder_prop() != null) {
			if (ctx.responder_prop().PROVIDER() != null) {
				wsag.setContext(wsag.getContext()
						+ "\t<wsag:AgreementResponder >"
						+ ctx.responder_prop().PROVIDER().getText()
						+ "</wsag:AgreementResponder >\n");
			} else if (ctx.responder_prop().CONSUMER() != null) {
				wsag.setContext(wsag.getContext()
						+ "\t\t<wsag:AgreementResponder >"
						+ ctx.responder_prop().CONSUMER().getText()
						+ "</wsag:AgreementResponder >\n");
			} else if (ctx.responder_prop().Identifier() != null) {
				wsag.setContext(wsag.getContext()
						+ "\t\t<wsag:AgreementResponder >"
						+ ctx.responder_prop().Identifier().getText()
						+ "</wsag:AgreementResponder >\n");
			}
		} else if (ctx.serviceProvider_prop() != null) {
			wsag.setContext(wsag.getContext()
					+ "\t\t<wsag:ServiceProvider >"
					+ Util.withoutQuotes(ctx.serviceProvider_prop().String()
							.getText()) + "</wsag:ServiceProvider >\n");
		} else if (ctx.expirationTime_prop() != null) {
			wsag.setContext(wsag.getContext()
					+ "\t\t<wsag:ExpirationTime >"
					+ Util.withoutQuotes(ctx.expirationTime_prop().String()
							.getText()) + "</wsag:ExpirationTime >\n");
		} else if (ctx.dateFormat_prop() != null) {
			wsag.setContext(wsag.getContext()
					+ "\t\t<twsag4people:DateFormat >"
					+ Util.withoutQuotes(ctx.dateFormat_prop().String()
							.getText()) + "</twsag4people:DateFormat >\n");
		} else if (ctx.gmtZone_prop() != null) {
			if (ctx.gmtZone_prop().S_Integer() != null) {
				wsag.setContext(wsag.getContext() + "\t\t<wsag:GMTZone >"
						+ ctx.gmtZone_prop().S_Integer().getText()
						+ "</wsag:GMTZone >\n");
			} else if (ctx.gmtZone_prop().Integer() != null) {
				wsag.setContext(wsag.getContext() + "\t\t<wsag:GMTZone >"
						+ ctx.gmtZone_prop().Integer().getText()
						+ "</wsag:GMTZone >\n");
			}
		} else if (ctx.globalPeriod_prop() != null) {
			wsag.setContext(wsag.getContext()
					+ "\t\t<twsag4people:GlobalPeriod >" + ""
					+ "</twsag4people:GlobalPeriod >\n");
		} else if (ctx.definedPeriod_prop() != null) {
			wsag.setContext(wsag.getContext()
					+ "\t\t<twsag4people:DefinedValidityPeriodSet >" + ""
					+ "</twsag4people:DefinedValidityPeriodSet >\n");
		}

	}

	@Override
	public void enterService(ServiceContext ctx) {
		super.enterService(ctx);

		wsag.setServiceName(ctx.Identifier().getText());

		wsag.setServiceURL(Util.withoutQuotes(ctx.url().getText()));
	}

	@Override
	public void enterGlobalDescription(GlobalDescriptionContext ctx) {
		super.enterGlobalDescription(ctx);

		for (Key_value_propContext kv : ctx.key_value_prop()) {
			String assigValue = "";

			if (kv.a != null) {
				assigValue = kv.a.getText();
			}

			// String
			if (kv.v != null) {
				wsag.setServiceDescTerms(wsag.getServiceDescTerms()
						+ "\t\t\t\t<OfferItem name=\"" + kv.k.getText()
						+ "\" wsag:Metric=\"metrics/" + wsag.getMetric() + ":"
						+ kv.v.getText() + "\" >" + assigValue
						+ "</OfferItem>\n");
			}
			// Type
			else if (kv.v2 != null) {
				wsag.setServiceDescTerms(wsag.getServiceDescTerms()
						+ "\t\t\t\t<OfferItem name=\"" + kv.k.getText()
						+ "\" wsag:Metric=\"metrics/" + wsag.getMetric() + ":"
						+ kv.type().getText() + "\" >" + assigValue
						+ "</OfferItem>\n");
			}
		}

	}

	@Override
	public void enterGlobal_MonitorableProperties(
			Global_MonitorablePropertiesContext ctx) {
		super.enterGlobal_MonitorableProperties(ctx);

		for (Key_value_propContext kv : ctx.key_value_prop()) {

			// String
			if (kv.v != null) {
				wsag.setServiceProperties(wsag.getServiceProperties()
						+ "\t\t\t\t\t<wsag:Variable  wsag:Name=\""
						+ kv.k.getText() + "\" wsag:Metric=\"metrics/"
						+ wsag.getMetric() + ":" + kv.v.getText() + "\" >\n"
						+ "\t\t\t\t\t\t<wsag:Location >/" + kv.k.getText()
						+ "</wsag:Location>\n"
						+ "\t\t\t\t\t</wsag:Variable >\n");
			}
			// Type
			else if (kv.v2 != null) {
				wsag.setServiceProperties(wsag.getServiceProperties()
						+ "\t\t\t\t\t<wsag:Variable  wsag:Name=\""
						+ kv.k.getText() + "\" wsag:Metric=\"metrics/"
						+ wsag.getMetric() + ":" + kv.v2.getText() + "\" >\n"
						+ "\t\t\t\t\t\t<wsag:Location >/" + kv.k.getText()
						+ "</wsag:Location>\n"
						+ "\t\t\t\t\t</wsag:Variable >\n");
			}
		}
	}

	public String getWSAG() {
		String res = wsag.getXmlHeader()
				+ "<wsag:Template wsag:TemplateId=\""
				+ wsag.getVersion()
				+ "\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"  \n"
				+ " xmlns:wsag=\"http://schemas.ggf.org/graap/2007/03/ws-agreement\" \n"
				+ " xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" \n"
				+ " xsi:schemaLocation=\"http://schemas.ggf.org/graap/2007/03/wsagreement\" \n"
				+ " agreement_types.xsd=\"http://www.w3.org/2001/XMLSchema XMLSchema.xsd\" >\n"
				+ "\t<wsag:Name >" + wsag.getName() + "</wsag:Name>\n"
				+ "\t<wsag:Context >\n" + wsag.getContext()
				+ "\n\t</wsag:Context >\n\n" + "\t<wsag:Terms wsag:Name=\""
				+ wsag.getServiceName() + "\">\n" + "\t\t<wsag:All >\n"
				+ "\t\t\t<wsag:ServiceDescriptionTerm wsag:Name=\"SDT_"
				+ wsag.getServiceName() + "\" wsag:ServiceName=\""
				+ wsag.getServiceName() + "\" >\n" + wsag.getServiceDescTerms()
				+ "\t\t\t</wsag:ServiceDescriptionTerm>\n\n"
				+ "\t\t\t<wsag:ServiceReference  wsag:Name=\""
				+ wsag.getServiceName() + "_SREF\" wsag:ServiceName=\""
				+ wsag.getServiceName() + "\" >" + wsag.getServiceURL()
				+ "</wsag:ServiceReference>\n"
				+ "\n\t\t\t<wsag:ServiceProperties wsag:Name=\"SP_"
				+ wsag.getServiceName() + "\" wsag:ServiceName=\""
				+ wsag.getServiceName() + "\">\n"
				+ "\t\t\t\t<wsag:VariableSet >\n"
				+ wsag.getServiceProperties()
				+ "\t\t\t\t</wsag:Variable >\n"
				+ "\t\t\t</wsag:ServiceProperties>" + "\n\t\t</wsag:All >\n"
				+ "\t</wsag:Terms >\n\n" +

				"\t<wsag:CreationConstraints >\n" + wsag.getCc()
				+ "\t</wsag:CreationConstraints >\n" + "</wsag:Template>";
		return res;
	}
}
