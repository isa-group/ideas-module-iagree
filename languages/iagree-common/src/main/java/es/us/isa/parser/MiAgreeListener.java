package es.us.isa.parser;

import java.util.Calendar;

import es.us.isa.parser.iAgreeParser.AgOfferContext;
import es.us.isa.parser.iAgreeParser.Ag_defContext;
import es.us.isa.parser.iAgreeParser.AgreementTermsContext;
import es.us.isa.parser.iAgreeParser.AgreementTerms_defContext;
import es.us.isa.parser.iAgreeParser.Assig_valueContext;
import es.us.isa.parser.iAgreeParser.CreationConstraintContext;
import es.us.isa.parser.iAgreeParser.CreationConstraintsContext;
import es.us.isa.parser.iAgreeParser.CreationConstraints_defContext;
import es.us.isa.parser.iAgreeParser.CuantifContext;
import es.us.isa.parser.iAgreeParser.EntryContext;
import es.us.isa.parser.iAgreeParser.ExpressionContext;
import es.us.isa.parser.iAgreeParser.GlobalDescriptionContext;
import es.us.isa.parser.iAgreeParser.Global_MonitorablePropertiesContext;
import es.us.isa.parser.iAgreeParser.Grouped_guaranteeTermContext;
import es.us.isa.parser.iAgreeParser.GuaranteeTermContext;
import es.us.isa.parser.iAgreeParser.GuaranteeTermsContext;
import es.us.isa.parser.iAgreeParser.Guarantee_defContext;
import es.us.isa.parser.iAgreeParser.Key_value_propContext;
import es.us.isa.parser.iAgreeParser.ListArgContext;
import es.us.isa.parser.iAgreeParser.ListContext;
import es.us.isa.parser.iAgreeParser.Metrics_propContext;
import es.us.isa.parser.iAgreeParser.MonitorablePropertiesContext;
import es.us.isa.parser.iAgreeParser.Onlyif_sentenceContext;
import es.us.isa.parser.iAgreeParser.OperationContext;
import es.us.isa.parser.iAgreeParser.RangeContext;
import es.us.isa.parser.iAgreeParser.ServiceContext;
import es.us.isa.parser.iAgreeParser.Temp_propertiesContext;
import es.us.isa.parser.iAgreeParser.TemplateContext;
import es.us.isa.parser.iAgreeParser.Template_defContext;
import es.us.isa.parser.iAgreeParser.TypeContext;
import es.us.isa.parser.iAgreeParser.VersionNumberContext;
import es.us.isa.util.KeyValueProp;
import es.us.isa.util.Range;
import es.us.isa.util.Util;

public class MiAgreeListener extends iAgreeBaseListener {

	// Global vars:
	public WsagObject wsag = null;
	public String metrics;
	public long timeStamp;

	@Override
	public void enterEntry(EntryContext ctx) {
		super.enterEntry(ctx);

		wsag = new WsagObject();
		timeStamp = Calendar.getInstance().getTimeInMillis();

		if (ctx.template() != null) {
			enterTemplate(ctx.template());
			wsag.setResult("<?xml version=\"1.0\" encoding = \"UTF-8\"?>\n"
					+ wsag.getTemplate());
		} else if (ctx.agOffer() != null) {
			enterAgOffer(ctx.agOffer());
			wsag.setResult("<?xml version=\"1.0\" encoding = \"UTF-8\"?>\n"
					+ wsag.getAggOffer());
		}
	}

	@Override
	public void enterTemplate(TemplateContext ctx) {
		super.enterTemplate(ctx);

		wsag.setMetric(ctx.Identifier().getText() + "_" + timeStamp);

		wsag.setTemplateName(ctx.Identifier().getText());

		enterVersionNumber(ctx.versionNumber());

		enterTemplate_def(ctx.template_def());

		wsag.setTemplate("<wsag:Template wsag:TemplateId=\""
				+ wsag.getVersionNumber()
				+ "\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"  \n"
				+ " xmlns:wsag=\"http://schemas.ggf.org/graap/2007/03/ws-agreement\" \n"
				+ " xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" \n"
				+ " xsi:schemaLocation=\"http://schemas.ggf.org/graap/2007/03/wsagreement\" \n"
				+ " agreement_types.xsd=\"http://www.w3.org/2001/XMLSchema XMLSchema.xsd\" >\n"
				+ "	<wsag:Name >" + wsag.getTemplateName() + "</wsag:Name>\n"
				+ wsag.getTemplateDef() + "</wsag:Template>");
	}

	@Override
	public void enterAgOffer(AgOfferContext ctx) {
		super.enterAgOffer(ctx);

		wsag.setMetric(ctx.Identifier(0).getText() + "_" + timeStamp);

		enterVersionNumber(ctx.versionNumber(1));
		wsag.setAggTemplate("\t\t<wsag:TemplateId>" + wsag.getVersionNumber()
				+ "</wsag:TemplateId>\n");

		wsag.setTemplateName(ctx.Identifier(1).getText());

		enterAg_def(ctx.ag_def());
		enterVersionNumber(ctx.versionNumber(0));
		wsag.setAggOffer("<wsag:AgreementOffer wsag:AgreementId=\""
				+ wsag.getVersionNumber()
				+ "\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"  \n"
				+ " xmlns:wsag=\"http://schemas.ggf.org/graap/2007/03/ws-agreement\" \n"
				+ " xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" \n"
				+ " xsi:schemaLocation=\"http://schemas.ggf.org/graap/2007/03/wsagreement\" \n"
				+ " agreement_types.xsd=\"http://www.w3.org/2001/XMLSchema XMLSchema.xsd\" >\n"
				+ "	<wsag:Name >" + ctx.Identifier(0).getText()
				+ "</wsag:Name>\n" + wsag.getAggDef()
				+ "</wsag:AgreementOffer>");
	}

	@Override
	public void enterAg_def(Ag_defContext ctx) {
		super.enterAg_def(ctx);

		for (Temp_propertiesContext tp : ctx.temp_properties()) {
			enterTemp_properties(tp);
		}

		enterAgreementTerms(ctx.agreementTerms());

		wsag.setAggDef("\t<wsag:Context >\n" + wsag.getAggTemplate()
				+ "\t\t<wsag:TemplateName>" + wsag.getTemplateName()
				+ "</wsag:TemplateName>\n" + wsag.getContext()
				+ "\n\t</wsag:Context >\n\n" + "\t<wsag:Terms wsag:Name=\""
				+ wsag.getServiceName() + "\">\n\t\t<wsag:All >\n"
				+ wsag.getAgreementTerms()
				+ "\n\t\t</wsag:All >\n\t</wsag:Terms >\n\n");
	}

	@Override
	public void enterTemplate_def(Template_defContext ctx) {
		super.enterTemplate_def(ctx);

		for (Temp_propertiesContext tempCtx : ctx.temp_properties()) {
			enterTemp_properties(tempCtx);
		}

		enterAgreementTerms(ctx.agreementTerms());

		enterCreationConstraints(ctx.creationConstraints());

		wsag.setTemplateDef("\t<wsag:Context >\n" + wsag.getContext()
				+ "\n\t</wsag:Context >\n\n" + "\t<wsag:Terms wsag:Name=\""
				+ wsag.getServiceName() + "\">\n\t\t<wsag:All >\n"
				+ wsag.getAgreementTerms()
				+ "\n\t\t</wsag:All >\n	</wsag:Terms >\n\n"
				+ "\t<wsag:CreationConstraints >\n" + wsag.getCc()
				+ "\t</wsag:CreationConstraints >\n");
	}

	@Override
	public void enterAgreementTerms(AgreementTermsContext ctx) {
		super.enterAgreementTerms(ctx);

		enterAgreementTerms_def(ctx.agreementTerms_def());
		wsag.setAgreementTerms(wsag.getAgreementTermsDef());
	}

	@Override
	public void enterCreationConstraints(CreationConstraintsContext ctx) {
		super.enterCreationConstraints(ctx);

		enterCreationConstraints_def(ctx.creationConstraints_def());
	}

	@Override
	public void enterCreationConstraints_def(CreationConstraints_defContext ctx) {
		super.enterCreationConstraints_def(ctx);

		for (CreationConstraintContext cc : ctx.creationConstraint()) {
			enterCreationConstraint(cc);
		}
	}

	@Override
	public void enterCreationConstraint(CreationConstraintContext ctx) {
		super.enterCreationConstraint(ctx);

		String name = ctx.Identifier().getText();

		String cc = "\t\t<wsag:Constraint >\n" + "\t\t\t<Name>" + name
				+ "</Name>\n" + "\t\t\t<Content>";

		if (ctx.onlyif_sentence() != null) {
			enterOnlyif_sentence(ctx.onlyif_sentence());
			cc += wsag.getOnlyIf() + " IMPLIES ";
		}

		enterExpression(ctx.expression());
		cc += wsag.getExpression() + "</Content>\n"
				+ "\t\t</wsag:Constraint >\n";

		wsag.setCc(wsag.getCc() + cc);
	}

	@Override
	public void enterAgreementTerms_def(AgreementTerms_defContext ctx) {
		super.enterAgreementTerms_def(ctx);

		enterService(ctx.service());

		enterMonitorableProperties(ctx.monitorableProperties());

		enterGuaranteeTerms(ctx.guaranteeTerms());

		wsag.setAgreementTermsDef(wsag.getService()
				+ wsag.getMonitorableProperties() + wsag.getGuaranteeTerms());
	}

	@Override
	public void enterService(ServiceContext ctx) {
		super.enterService(ctx);

		enterGlobalDescription(ctx.globalDescription());

		wsag.setServiceUrl(Util.withoutDoubleQuotes(ctx.url().getText()));

		String serviceName = ctx.Identifier().getText();
		String name = "SDT_" + serviceName;

		wsag.setServiceName(serviceName);
		wsag.setService("\t\t\t<wsag:ServiceDescriptionTerm wsag:Name=\""
				+ name + "\" wsag:ServiceName=\"" + serviceName + "\" >\n"
				+ wsag.getOfferItems()
				+ "\t\t\t</wsag:ServiceDescriptionTerm>\n\n");

		if (ctx.url() != null)
			wsag.setService(wsag.getService()
					+ "			<wsag:ServiceReference  wsag:Name=\""
					+ ctx.Identifier().getText()
					+ "_SREF\" wsag:ServiceName=\""
					+ ctx.Identifier().getText() + "\" >"
					+ Util.withoutDoubleQuotes(ctx.url().getText())
					+ "</wsag:ServiceReference>\n\n");
	}

	@Override
	public void enterTemp_properties(Temp_propertiesContext ctx) {
		super.enterTemp_properties(ctx);

		if (ctx.initiator_prop() != null) {
			wsag.setContext(wsag.getContext()
					+ "\t\t<wsag:AgreementInitiator >"
					+ Util.withoutDoubleQuotes(ctx.initiator_prop().String()
							.getText()) + "</wsag:AgreementInitiator >\n");
		} else if (ctx.responder_prop() != null) {
			if (ctx.responder_prop().PROVIDER() != null) {
				wsag.setContext(wsag.getContext()
						+ "\t\t<wsag:AgreementResponder >"
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
					+ Util.withoutDoubleQuotes(ctx.serviceProvider_prop()
							.String().getText()) + "</wsag:ServiceProvider >\n");
		} else if (ctx.expirationTime_prop() != null) {
			wsag.setContext(wsag.getContext()
					+ "\t\t<wsag:ExpirationTime >"
					+ Util.withoutDoubleQuotes(ctx.expirationTime_prop()
							.String().getText()) + "</wsag:ExpirationTime >\n");
		} else if (ctx.dateFormat_prop() != null) {
			// TODO Definir temporalidad
			// wsag.setContext(wsag.getContext()
			// + "\t\t<twsag4people:DateFormat >"
			// + Util.withoutQuotes(ctx.dateFormat_prop().String()
			// .getText()) + "</twsag4people:DateFormat >\n");
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
			// TODO Definir temporalidad
			// wsag.setContext(wsag.getContext()
			// + "\t\t<twsag4people:GlobalPeriod >" + ""
			// + "</twsag4people:GlobalPeriod >\n");
		} else if (ctx.definedPeriod_prop() != null) {
			// TODO Definir temporalidad
			// wsag.setContext(wsag.getContext()
			// + "\t\t<twsag4people:DefinedValidityPeriodSet >" + ""
			// + "</twsag4people:DefinedValidityPeriodSet >\n");
		}
	}

	@Override
	public void enterMonitorableProperties(MonitorablePropertiesContext ctx) {
		super.enterMonitorableProperties(ctx);

		if (ctx.global_MonitorableProperties() != null)
			enterGlobal_MonitorableProperties(ctx
					.global_MonitorableProperties());

		String name = "";
		if (ctx.Identifier() != null)
			name = ctx.Identifier().getText();
		else
			name = wsag.getServiceName();

		wsag.setMonitorableProperties("\t\t\t<wsag:ServiceProperties wsag:Name=\"SP_"
				+ name
				+ "\" wsag:ServiceName=\""
				+ name
				+ "\">\n"
				+ "\t\t\t\t<wsag:VariableSet >\n"
				+ wsag.getVariablesSet()
				+ "\t\t\t\t</wsag:VariableSet >\n"
				+ "\t\t\t</wsag:ServiceProperties>\n\n");
	}

	@Override
	public void enterGuaranteeTerms(GuaranteeTermsContext ctx) {
		super.enterGuaranteeTerms(ctx);

		for (GuaranteeTermContext gt : ctx.guaranteeTerm()) {
			enterGuaranteeTerm(gt);
			wsag.setGuaranteeTerms(wsag.getGuaranteeTerms()
					+ wsag.getGuaranteeTerm());
		}

	}

	@Override
	public void enterGlobalDescription(GlobalDescriptionContext ctx) {
		super.enterGlobalDescription(ctx);

		for (Key_value_propContext kv : ctx.key_value_prop()) {
			enterKey_value_prop(kv);
			wsag.setOfferItems(wsag.getOfferItems()
					+ "\t\t\t\t<OfferItem name=\"" + wsag.getKeyValue().key
					+ "\" wsag:Metric=\"metrics/" + wsag.getMetric() + ":"
					+ wsag.getKeyValue().value + "\" >"
					+ wsag.getKeyValue().assigValue + "</OfferItem>\n");
		}
	}

	@Override
	public void enterGlobal_MonitorableProperties(
			Global_MonitorablePropertiesContext ctx) {
		super.enterGlobal_MonitorableProperties(ctx);

		for (Key_value_propContext kv : ctx.key_value_prop()) {
			enterKey_value_prop(kv);
			wsag.setVariablesSet(wsag.getVariablesSet()
					+ "\t\t\t\t\t<wsag:Variable  wsag:Name=\""
					+ wsag.getKeyValue().key + "\" wsag:Metric=\"metrics/"
					+ wsag.getMetric() + ":" + wsag.getKeyValue().value
					+ "\" >\n" + "\t\t\t\t\t\t<wsag:Location >/"
					+ wsag.getKeyValue().key + "</wsag:Location>\n"
					+ "\t\t\t\t\t</wsag:Variable >\n");
		}
	}

	@Override
	public void enterGuaranteeTerm(GuaranteeTermContext ctx) {
		super.enterGuaranteeTerm(ctx);

		if (ctx.cuantif() != null) {
			enterCuantif(ctx.cuantif());
			enterGrouped_guaranteeTerm(ctx.grouped_guaranteeTerm());
			wsag.setGuaranteeTerm("\t\t\t<wsag:" + wsag.getCuantif() + " >\n"
					+ wsag.getGroupedGuaranteeTerm() + "\t\t\t</wsag:"
					+ wsag.getCuantif() + " >\n");
		} else {
			enterGuarantee_def(ctx.guarantee_def());
			wsag.setGuaranteeTerm("\t\t\t<wsag:GuaranteeTerm wsag:Obligated=\"Service"
					+ wsag.getGuaranteeDefObligated()
					+ "\" wsag:Name=\""
					+ ctx.Identifier().getText()
					+ "\" >\n"
					+ wsag.getGuaranteeDef() + "\t\t\t</wsag:GuaranteeTerm>\n");
		}
	}

	@Override
	public void enterGuarantee_def(Guarantee_defContext ctx) {
		super.enterGuarantee_def(ctx);

		wsag.setGuaranteeDefObligated(ctx.ob.getText());
		String result = "";
		if (ctx.onlyif_sentence() != null) {
			enterOnlyif_sentence(ctx.onlyif_sentence());
			result = "\t\t\t\t<wsag:QualifyingCondition >\n" + "					"
					+ Util.encodeEntities(wsag.getOnlyIf()) + "\n"
					+ "\t\t\t\t</wsag:QualifyingCondition>\n";
		}

		enterExpression(ctx.expression());
		result += "\t\t\t\t<wsag:ServiceLevelObjective >\n"
				+ "\t\t\t\t\t<wsag:CustomServiceLevel >"
				+ Util.encodeEntities(wsag.getExpression())
				+ "</wsag:CustomServiceLevel>\n"
				+ "\t\t\t\t</wsag:ServiceLevelObjective>\n";
		wsag.setGuaranteeDef(result);
	}

	@Override
	public void enterGrouped_guaranteeTerm(Grouped_guaranteeTermContext ctx) {
		super.enterGrouped_guaranteeTerm(ctx);

		for (GuaranteeTermContext gt : ctx.guaranteeTerm()) {
			enterGuaranteeTerm(gt);
			wsag.setGroupedGuaranteeTerm(wsag.getGroupedGuaranteeTerm()
					+ wsag.getGuaranteeTerm());
		}

	}

	@Override
	public void enterExpression(ExpressionContext ctx) {
		super.enterExpression(ctx);

		String result = "";

		if (ctx.NOT() != null) {
			enterExpression(ctx.e1);
			wsag.setExpression("NOT (" + wsag.getExpression() + ")");
		} else if (ctx.PA() != null) {
			enterExpression(ctx.e1);
			result = ctx.PA().getText() + wsag.getExpression()
					+ ctx.PC().getText();
			if (ctx.log != null) {
				enterExpression(ctx.e2);
				result += " " + ctx.log.getText() + " " + wsag.getExpression();
			}
			result = Util.encodeEntities(result);
			wsag.setExpression(result);
		} else if (ctx.BELONGS() != null) {

			result = "";

			if (ctx.l != null)
				enterList(ctx.l);

			String[] values = wsag.getListValues().split(",");

			result += "(" + ctx.ident.getText() + " = \"" + values[0] + "\"";

			for (int i = 1; i < values.length; i++) {
				result += " OR " + ctx.ident.getText() + " = \"" + values[i]
						+ "\"";
			}

			result += ")";

			if (ctx.log != null) {
				if (ctx.e1 != null)
					enterExpression(ctx.e1);
				result += " " + ctx.log.getText() + " " + wsag.getExpression();
			}
			result = Util.encodeEntities(result);
			wsag.setExpression(result);
		} else {

			if (ctx.cmp != null | ctx.log != null)
				result = ctx.ident.getText() + " ";
			else
				result = ctx.ident.getText();

			if (ctx.val != null)
				enterAssig_value(ctx.val);

			if (ctx.cmp != null)
				result += ctx.cmp.getText() + wsag.getAssigValue();

			if (ctx.e1 != null)
				enterExpression(ctx.e1);

			if (ctx.log != null)
				result += " " + ctx.log.getText() + " " + wsag.getExpression();

			result = Util.encodeEntities(result);
			wsag.setExpression(result);
		}
	}

	@Override
	public void enterAssig_value(Assig_valueContext ctx) {
		super.enterAssig_value(ctx);

		String result = "";

		if (ctx.val != null) {

			if (ctx.Integer(0) != null)
				result = " " + ctx.val.getText();
			else {
				result = " " + ctx.val.getText();
			}

			if (ctx.operation() != null) {
				enterOperation(ctx.operation());
				result += " " + wsag.getOperation();
			}
			wsag.setAssigValue(result);
		} else if (ctx.TRUE() != null) {
			result = " \"True\"";
			wsag.setAssigValue(result);
		} else if (ctx.FALSE() != null) {
			result = " \"False\"";
			wsag.setAssigValue(result);
		} else if (ctx.Float() != null) {
			result = " " + ctx.Float().getText();
			if (ctx.Unit() != null)
				result += ctx.Unit().getText();
			if (ctx.operation() != null) {
				enterOperation(ctx.operation());
				result += " " + wsag.getOperation();
			}
			wsag.setAssigValue(result);
		} else if (ctx.S_Float() != null) {
			result = " " + ctx.S_Float().getText();
			if (ctx.Unit() != null)
				result += ctx.Unit().getText();
			if (ctx.operation() != null) {
				enterOperation(ctx.operation());
				result += " " + wsag.getOperation();
			}
			wsag.setAssigValue(result);
		} else if (ctx.S_Integer() != null) {
			result = " " + ctx.S_Integer().getText();
			if (ctx.Unit() != null)
				result += ctx.Unit().getText();
			if (ctx.operation() != null) {
				enterOperation(ctx.operation());
				result += " " + wsag.getOperation();
			}
			wsag.setAssigValue(result);
		} else if (ctx.list() != null) {
			result = " {" + wsag.getListValues() + "}";
			wsag.setAssigValue(result);
		}
	}

	@Override
	public void enterKey_value_prop(Key_value_propContext ctx) {
		super.enterKey_value_prop(ctx);

		String key = ctx.k.getText();

		String value = "";
		String type = "";
		String typeArg = "";
		if (ctx.v != null) {
			value = ctx.v.getText();

		} else if (ctx.v2 != null) {
			enterType(ctx.v2);
			value = ctx.v2.getText();
			type = wsag.getType();
			typeArg = wsag.getTypeArg();
		}
		String assig = "";
		if (ctx.a != null) {
			assig = ctx.a.getText();
		}

		KeyValueProp kv = new KeyValueProp(key, value, assig, type, typeArg);
		wsag.setKeyValue(kv);
	}

	@Override
	public void enterVersionNumber(VersionNumberContext ctx) {
		super.enterVersionNumber(ctx);

		if (ctx.Float() != null) {
			wsag.setVersionNumber(ctx.Float().getText());
		} else if (ctx.Version() != null) {
			wsag.setVersionNumber(ctx.Version().getText());
		}
	}

	@Override
	public void enterType(TypeContext ctx) {
		super.enterType(ctx);

		wsag.setType("");
		wsag.setTypeArg("");

		if (ctx.v != null) {
			wsag.setType(ctx.v.getText());
			if (ctx.range() != null) {
				enterRange(ctx.range());
				wsag.setTypeArg(wsag.getRange().min + "," + wsag.getRange().max);
			}
		} else if (ctx.Identifier() != null) {
			wsag.setType(ctx.Identifier().getText());
		} else if (ctx.SET() != null) {
			enterList(ctx.list());
			wsag.setType(ctx.SET().getText());
			wsag.setTypeArg(wsag.getListValues());
		} else if (ctx.ENUM() != null) {
			enterList(ctx.list());
			wsag.setType(ctx.ENUM().getText());
			wsag.setTypeArg(wsag.getListValues());
		}
	}

	@Override
	public void enterList(ListContext ctx) {
		super.enterList(ctx);

		wsag.setListValues("");

		for (ListArgContext l : ctx.listArg()) {
			wsag.setListValues(wsag.getListValues() + l.l1.getText() + ",");
		}
	}

	@Override
	public void enterOnlyif_sentence(Onlyif_sentenceContext ctx) {
		super.enterOnlyif_sentence(ctx);

		if (ctx.expression() != null)
			enterExpression(ctx.expression());

		wsag.setOnlyIf(wsag.getExpression());
	}

	@Override
	public void enterCuantif(CuantifContext ctx) {
		super.enterCuantif(ctx);
		String cuantif = "";
		if (ctx.EXACTLY_ONE() != null) {
			cuantif = "ExactlyOne";
		} else if (ctx.ONE_OR_MORE() != null) {
			cuantif = "OneOrMore";
		} else if (ctx.ALL() != null) {
			cuantif = "All";
		}
		wsag.setCuantif(cuantif);
	}

	@Override
	public void enterRange(RangeContext ctx) {
		super.enterRange(ctx);

		wsag.setRange(new Range(ctx.min.getText(), ctx.max.getText()));
	}

	@Override
	public void enterOperation(OperationContext ctx) {
		super.enterOperation(ctx);

		enterAssig_value(ctx.assig_value());
		wsag.setOperation(ctx.Operador().getText() + wsag.getAssigValue());
	}

	@Override
	public void enterMetrics_prop(Metrics_propContext ctx) {
		super.enterMetrics_prop(ctx);

		String metrics_def = "\t<met:metric id=\"boolean\" type=\"enumerated\" >\n"
				+ "		<met:value value=\"True\"/>\n"
				+ "		<met:value value=\"False\"/>\n" + "\t</met:metric>\n";

		for (Key_value_propContext kv : ctx.key_value_prop()) {
			enterKey_value_prop(kv);

			String mId, mType;
			String min = "0";
			String max = "500";

			mId = wsag.getKeyValue().key;
			mType = Util.convertMetricType(wsag.getKeyValue().type);

			metrics_def += "\t<met:metric id=\"" + mId + "\" type=\"" + mType
					+ "\" ";

			if (!wsag.getKeyValue().typeArg.isEmpty()) {
				String[] aux = wsag.getKeyValue().typeArg.split(",");

				if (mType == "enumerated") {
					metrics_def += ">\n";

					if (!wsag.getKeyValue().type.isEmpty()
							&& wsag.getKeyValue().type.toLowerCase().equals(
									"boolean")) {
						aux[0] = "True";
						aux[1] = "False";
					}

					for (int i = 0; i < aux.length; i++) {
						metrics_def += "\t\t<met:value value=\"" + aux[i]
								+ "\"/>\n";
					}

					metrics_def += "\t</met:metric>\n";

				} else {
					min = aux[0];
					max = aux[1];

					metrics_def += " min=\"" + min + "\" max=\"" + max
							+ "\" />\n";

				}

			} else {
				metrics_def += " min=\"" + min + "\" max=\"" + max + "\"";
				metrics_def += "/>\n";
			}
		}

		metrics = "<met:metricXML xmlns:met=\"http:/www.isa.us.es/ada/metrics\">\n"
				+ metrics_def + "</met:metricXML>\n";
	}

	public String getWSAG() {
		return wsag.getResult();
	}

	public String getTemplateName() {
		return wsag.getTemplateName();
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public String getMetrics() {
		return metrics;
	}
}
