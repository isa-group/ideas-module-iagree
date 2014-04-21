// Generated from C:\Users\Juanlu\Desktop\iAgree\iAgree.g4 by ANTLR 4.1
package es.us.isa.ideas.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class iAgreeParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TEMPLATE=1, END_TEMPLATE=2, AG_OFFER=3, END_AG_OFFER=4, INITIATOR=5, RESPONDER=6, 
		SERVICEPROVIDER=7, EXPIRATIONTIME=8, DATEFORMAT=9, GMTZONE=10, GLOBALPERIOD=11, 
		DEFINEDPERIOD=12, METRICS=13, AGREEMENT_TERMS=14, CREATION_CONSTRAINTS=15, 
		GUARANTEE_TERMS=16, SERVICE=17, FEATURES=18, GLOBALDESCRIPTION=19, DESCRIPTION=20, 
		GLOBAL=21, MONITORABLEPROPERTIES=22, GUARANTEES=23, AVAL_AT=24, PROVIDER=25, 
		CONSUMER=26, VERSION=27, EXCEPT=28, DURING=29, BOOLEAN=30, INTEGER=31, 
		FLOAT=32, NATURAL=33, NUMBER=34, SET=35, ENUM=36, TRUE=37, FALSE=38, CA=39, 
		CC=40, PA=41, PC=42, LLA=43, LLC=44, ON=45, FROM=46, OF=47, FOR=48, AS=49, 
		AND=50, OR=51, NOT=52, IMPLIES=53, ONLY_IF=54, EXACTLY_ONE=55, ONE_OR_MORE=56, 
		ALL=57, MENOR=58, MAYOR=59, IGUAL=60, MENOR_IGUAL=61, MAYOR_IGUAL=62, 
		BELONGS=63, UPON=64, DOT=65, COMMA=66, DP=67, SEMICOLON=68, RANGE_SEPARATOR=69, 
		Identifier=70, Integer=71, S_Integer=72, Float=73, S_Float=74, Boolean=75, 
		Url=76, Version=77, Date=78, Hour=79, Access=80, Unit=81, Operador=82, 
		String=83, WS=84, COMMENT=85, LINE_COMMENT=86;
	public static final String[] tokenNames = {
		"<INVALID>", "'Template'", "'EndTemplate'", "'AgreementOffer'", "'EndAgreementOffer'", 
		"'Initiator'", "'Responder'", "'ServiceProvider'", "'ExpirationTime'", 
		"'DateFormat'", "'GMTZone'", "'GlobalPeriod'", "'DefinedPeriod'", "'Metrics'", 
		"'AgreementTerms'", "'CreationConstraints'", "'GuaranteeTerms'", "'Service'", 
		"'Features/Operations'", "'GlobalDescription'", "'Description'", "'global'", 
		"'MonitorableProperties'", "'guarantees'", "'availableAt.'", "'Provider'", 
		"'Consumer'", "'version'", "'except'", "'during'", "'boolean'", "'integer'", 
		"'float'", "'natural'", "'number'", "'set'", "'enum'", "'true'", "'false'", 
		"'['", "']'", "'('", "')'", "'{'", "'}'", "'on'", "'from'", "'of'", "'for'", 
		"'as'", "'AND'", "'OR'", "'NOT'", "'IMPLIES'", "'onlyIf'", "'exactly one'", 
		"'one or more'", "'all'", "'<'", "'>'", "'='", "'<='", "'>='", "'belongs'", 
		"'upon'", "'.'", "','", "':'", "';'", "'..'", "Identifier", "Integer", 
		"S_Integer", "Float", "S_Float", "Boolean", "Url", "Version", "Date", 
		"Hour", "Access", "Unit", "Operador", "String", "WS", "COMMENT", "LINE_COMMENT"
	};
	public static final int
		RULE_entry = 0, RULE_template = 1, RULE_agOffer = 2, RULE_template_def = 3, 
		RULE_ag_def = 4, RULE_temp_properties = 5, RULE_agreementTerms = 6, RULE_creationConstraints = 7, 
		RULE_agreementTerms_def = 8, RULE_creationConstraints_def = 9, RULE_creationConstraint = 10, 
		RULE_initiator_prop = 11, RULE_responder_prop = 12, RULE_serviceProvider_prop = 13, 
		RULE_expirationTime_prop = 14, RULE_dateFormat_prop = 15, RULE_gmtZone_prop = 16, 
		RULE_globalPeriod_prop = 17, RULE_definedPeriod_prop = 18, RULE_metrics_prop = 19, 
		RULE_datePeriod_def = 20, RULE_temporality = 21, RULE_period = 22, RULE_period_def = 23, 
		RULE_service = 24, RULE_features = 25, RULE_globalDescription = 26, RULE_descriptions = 27, 
		RULE_feature = 28, RULE_description = 29, RULE_monitorableProperties = 30, 
		RULE_global_MonitorableProperties = 31, RULE_local_MonitorableProperties = 32, 
		RULE_guaranteeTerms = 33, RULE_guaranteeTerm = 34, RULE_grouped_guaranteeTerm = 35, 
		RULE_guarantee_def = 36, RULE_id = 37, RULE_versionNumber = 38, RULE_url = 39, 
		RULE_key_value_prop = 40, RULE_assig_value = 41, RULE_operation = 42, 
		RULE_expression = 43, RULE_op = 44, RULE_cuantif = 45, RULE_upon_sentence = 46, 
		RULE_onlyif_sentence = 47, RULE_type = 48, RULE_list = 49, RULE_listArg = 50, 
		RULE_range = 51;
	public static final String[] ruleNames = {
		"entry", "template", "agOffer", "template_def", "ag_def", "temp_properties", 
		"agreementTerms", "creationConstraints", "agreementTerms_def", "creationConstraints_def", 
		"creationConstraint", "initiator_prop", "responder_prop", "serviceProvider_prop", 
		"expirationTime_prop", "dateFormat_prop", "gmtZone_prop", "globalPeriod_prop", 
		"definedPeriod_prop", "metrics_prop", "datePeriod_def", "temporality", 
		"period", "period_def", "service", "features", "globalDescription", "descriptions", 
		"feature", "description", "monitorableProperties", "global_MonitorableProperties", 
		"local_MonitorableProperties", "guaranteeTerms", "guaranteeTerm", "grouped_guaranteeTerm", 
		"guarantee_def", "id", "versionNumber", "url", "key_value_prop", "assig_value", 
		"operation", "expression", "op", "cuantif", "upon_sentence", "onlyif_sentence", 
		"type", "list", "listArg", "range"
	};

	@Override
	public String getGrammarFileName() { return "iAgree.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public iAgreeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class EntryContext extends ParserRuleContext {
		public TerminalNode END_TEMPLATE() { return getToken(iAgreeParser.END_TEMPLATE, 0); }
		public TerminalNode END_AG_OFFER() { return getToken(iAgreeParser.END_AG_OFFER, 0); }
		public TemplateContext template() {
			return getRuleContext(TemplateContext.class,0);
		}
		public AgOfferContext agOffer() {
			return getRuleContext(AgOfferContext.class,0);
		}
		public EntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_entry; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterEntry(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitEntry(this);
		}
	}

	public final EntryContext entry() throws RecognitionException {
		EntryContext _localctx = new EntryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_entry);
		try {
			setState(110);
			switch (_input.LA(1)) {
			case TEMPLATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(104); template();
				setState(105); match(END_TEMPLATE);
				}
				break;
			case AG_OFFER:
				enterOuterAlt(_localctx, 2);
				{
				setState(107); agOffer();
				setState(108); match(END_AG_OFFER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemplateContext extends ParserRuleContext {
		public VersionNumberContext versionNumber() {
			return getRuleContext(VersionNumberContext.class,0);
		}
		public Template_defContext template_def() {
			return getRuleContext(Template_defContext.class,0);
		}
		public TerminalNode VERSION() { return getToken(iAgreeParser.VERSION, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode TEMPLATE() { return getToken(iAgreeParser.TEMPLATE, 0); }
		public TemplateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterTemplate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitTemplate(this);
		}
	}

	public final TemplateContext template() throws RecognitionException {
		TemplateContext _localctx = new TemplateContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_template);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112); match(TEMPLATE);
			setState(113); match(Identifier);
			setState(114); match(VERSION);
			setState(115); versionNumber();
			setState(116); template_def();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AgOfferContext extends ParserRuleContext {
		public List<VersionNumberContext> versionNumber() {
			return getRuleContexts(VersionNumberContext.class);
		}
		public Ag_defContext ag_def() {
			return getRuleContext(Ag_defContext.class,0);
		}
		public TerminalNode FOR() { return getToken(iAgreeParser.FOR, 0); }
		public List<TerminalNode> VERSION() { return getTokens(iAgreeParser.VERSION); }
		public TerminalNode Identifier(int i) {
			return getToken(iAgreeParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(iAgreeParser.Identifier); }
		public TerminalNode AG_OFFER() { return getToken(iAgreeParser.AG_OFFER, 0); }
		public VersionNumberContext versionNumber(int i) {
			return getRuleContext(VersionNumberContext.class,i);
		}
		public TerminalNode VERSION(int i) {
			return getToken(iAgreeParser.VERSION, i);
		}
		public AgOfferContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agOffer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterAgOffer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitAgOffer(this);
		}
	}

	public final AgOfferContext agOffer() throws RecognitionException {
		AgOfferContext _localctx = new AgOfferContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_agOffer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118); match(AG_OFFER);
			setState(119); match(Identifier);
			setState(120); match(VERSION);
			setState(121); versionNumber();
			setState(122); match(FOR);
			setState(123); match(Identifier);
			setState(124); match(VERSION);
			setState(125); versionNumber();
			setState(126); ag_def();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Template_defContext extends ParserRuleContext {
		public CreationConstraintsContext creationConstraints() {
			return getRuleContext(CreationConstraintsContext.class,0);
		}
		public Temp_propertiesContext temp_properties(int i) {
			return getRuleContext(Temp_propertiesContext.class,i);
		}
		public AgreementTermsContext agreementTerms() {
			return getRuleContext(AgreementTermsContext.class,0);
		}
		public List<Temp_propertiesContext> temp_properties() {
			return getRuleContexts(Temp_propertiesContext.class);
		}
		public Template_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_template_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterTemplate_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitTemplate_def(this);
		}
	}

	public final Template_defContext template_def() throws RecognitionException {
		Template_defContext _localctx = new Template_defContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_template_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INITIATOR) | (1L << SERVICEPROVIDER) | (1L << EXPIRATIONTIME) | (1L << DATEFORMAT) | (1L << GMTZONE) | (1L << GLOBALPERIOD) | (1L << DEFINEDPERIOD) | (1L << METRICS) | (1L << PROVIDER) | (1L << CONSUMER))) != 0) || _la==Identifier) {
				{
				{
				setState(128); temp_properties();
				}
				}
				setState(133);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(134); agreementTerms();
			setState(136);
			_la = _input.LA(1);
			if (_la==CREATION_CONSTRAINTS) {
				{
				setState(135); creationConstraints();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Ag_defContext extends ParserRuleContext {
		public Temp_propertiesContext temp_properties(int i) {
			return getRuleContext(Temp_propertiesContext.class,i);
		}
		public AgreementTermsContext agreementTerms() {
			return getRuleContext(AgreementTermsContext.class,0);
		}
		public List<Temp_propertiesContext> temp_properties() {
			return getRuleContexts(Temp_propertiesContext.class);
		}
		public Ag_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ag_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterAg_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitAg_def(this);
		}
	}

	public final Ag_defContext ag_def() throws RecognitionException {
		Ag_defContext _localctx = new Ag_defContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ag_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INITIATOR) | (1L << SERVICEPROVIDER) | (1L << EXPIRATIONTIME) | (1L << DATEFORMAT) | (1L << GMTZONE) | (1L << GLOBALPERIOD) | (1L << DEFINEDPERIOD) | (1L << METRICS) | (1L << PROVIDER) | (1L << CONSUMER))) != 0) || _la==Identifier) {
				{
				{
				setState(138); temp_properties();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(144); agreementTerms();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Temp_propertiesContext extends ParserRuleContext {
		public Responder_propContext responder_prop() {
			return getRuleContext(Responder_propContext.class,0);
		}
		public Initiator_propContext initiator_prop() {
			return getRuleContext(Initiator_propContext.class,0);
		}
		public Metrics_propContext metrics_prop() {
			return getRuleContext(Metrics_propContext.class,0);
		}
		public DefinedPeriod_propContext definedPeriod_prop() {
			return getRuleContext(DefinedPeriod_propContext.class,0);
		}
		public DateFormat_propContext dateFormat_prop() {
			return getRuleContext(DateFormat_propContext.class,0);
		}
		public GmtZone_propContext gmtZone_prop() {
			return getRuleContext(GmtZone_propContext.class,0);
		}
		public ServiceProvider_propContext serviceProvider_prop() {
			return getRuleContext(ServiceProvider_propContext.class,0);
		}
		public ExpirationTime_propContext expirationTime_prop() {
			return getRuleContext(ExpirationTime_propContext.class,0);
		}
		public GlobalPeriod_propContext globalPeriod_prop() {
			return getRuleContext(GlobalPeriod_propContext.class,0);
		}
		public Temp_propertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temp_properties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterTemp_properties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitTemp_properties(this);
		}
	}

	public final Temp_propertiesContext temp_properties() throws RecognitionException {
		Temp_propertiesContext _localctx = new Temp_propertiesContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_temp_properties);
		try {
			setState(155);
			switch (_input.LA(1)) {
			case INITIATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(146); initiator_prop();
				}
				break;
			case PROVIDER:
			case CONSUMER:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(147); responder_prop();
				}
				break;
			case SERVICEPROVIDER:
				enterOuterAlt(_localctx, 3);
				{
				setState(148); serviceProvider_prop();
				}
				break;
			case EXPIRATIONTIME:
				enterOuterAlt(_localctx, 4);
				{
				setState(149); expirationTime_prop();
				}
				break;
			case DATEFORMAT:
				enterOuterAlt(_localctx, 5);
				{
				setState(150); dateFormat_prop();
				}
				break;
			case GMTZONE:
				enterOuterAlt(_localctx, 6);
				{
				setState(151); gmtZone_prop();
				}
				break;
			case GLOBALPERIOD:
				enterOuterAlt(_localctx, 7);
				{
				setState(152); globalPeriod_prop();
				}
				break;
			case DEFINEDPERIOD:
				enterOuterAlt(_localctx, 8);
				{
				setState(153); definedPeriod_prop();
				}
				break;
			case METRICS:
				enterOuterAlt(_localctx, 9);
				{
				setState(154); metrics_prop();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AgreementTermsContext extends ParserRuleContext {
		public AgreementTerms_defContext agreementTerms_def() {
			return getRuleContext(AgreementTerms_defContext.class,0);
		}
		public TerminalNode AGREEMENT_TERMS() { return getToken(iAgreeParser.AGREEMENT_TERMS, 0); }
		public AgreementTermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agreementTerms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterAgreementTerms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitAgreementTerms(this);
		}
	}

	public final AgreementTermsContext agreementTerms() throws RecognitionException {
		AgreementTermsContext _localctx = new AgreementTermsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_agreementTerms);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157); match(AGREEMENT_TERMS);
			setState(158); agreementTerms_def();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreationConstraintsContext extends ParserRuleContext {
		public TerminalNode CREATION_CONSTRAINTS() { return getToken(iAgreeParser.CREATION_CONSTRAINTS, 0); }
		public CreationConstraints_defContext creationConstraints_def() {
			return getRuleContext(CreationConstraints_defContext.class,0);
		}
		public CreationConstraintsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creationConstraints; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterCreationConstraints(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitCreationConstraints(this);
		}
	}

	public final CreationConstraintsContext creationConstraints() throws RecognitionException {
		CreationConstraintsContext _localctx = new CreationConstraintsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_creationConstraints);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); match(CREATION_CONSTRAINTS);
			setState(161); creationConstraints_def();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AgreementTerms_defContext extends ParserRuleContext {
		public ServiceContext service() {
			return getRuleContext(ServiceContext.class,0);
		}
		public MonitorablePropertiesContext monitorableProperties() {
			return getRuleContext(MonitorablePropertiesContext.class,0);
		}
		public GuaranteeTermsContext guaranteeTerms() {
			return getRuleContext(GuaranteeTermsContext.class,0);
		}
		public AgreementTerms_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agreementTerms_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterAgreementTerms_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitAgreementTerms_def(this);
		}
	}

	public final AgreementTerms_defContext agreementTerms_def() throws RecognitionException {
		AgreementTerms_defContext _localctx = new AgreementTerms_defContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_agreementTerms_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(163); service();
			setState(164); monitorableProperties();
			setState(165); guaranteeTerms();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreationConstraints_defContext extends ParserRuleContext {
		public CreationConstraintContext creationConstraint(int i) {
			return getRuleContext(CreationConstraintContext.class,i);
		}
		public List<CreationConstraintContext> creationConstraint() {
			return getRuleContexts(CreationConstraintContext.class);
		}
		public CreationConstraints_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creationConstraints_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterCreationConstraints_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitCreationConstraints_def(this);
		}
	}

	public final CreationConstraints_defContext creationConstraints_def() throws RecognitionException {
		CreationConstraints_defContext _localctx = new CreationConstraints_defContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_creationConstraints_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(167); creationConstraint();
				}
				}
				setState(170); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CreationConstraintContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(iAgreeParser.SEMICOLON, 0); }
		public Onlyif_sentenceContext onlyif_sentence() {
			return getRuleContext(Onlyif_sentenceContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DP() { return getToken(iAgreeParser.DP, 0); }
		public CreationConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creationConstraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterCreationConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitCreationConstraint(this);
		}
	}

	public final CreationConstraintContext creationConstraint() throws RecognitionException {
		CreationConstraintContext _localctx = new CreationConstraintContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_creationConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(172); match(Identifier);
			}
			setState(173); match(DP);
			setState(174); expression();
			setState(175); match(SEMICOLON);
			setState(177);
			_la = _input.LA(1);
			if (_la==ONLY_IF) {
				{
				setState(176); onlyif_sentence();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Initiator_propContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode INITIATOR() { return getToken(iAgreeParser.INITIATOR, 0); }
		public TerminalNode DP() { return getToken(iAgreeParser.DP, 0); }
		public Initiator_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initiator_prop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterInitiator_prop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitInitiator_prop(this);
		}
	}

	public final Initiator_propContext initiator_prop() throws RecognitionException {
		Initiator_propContext _localctx = new Initiator_propContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_initiator_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179); match(INITIATOR);
			setState(180); match(DP);
			setState(181); match(String);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Responder_propContext extends ParserRuleContext {
		public TerminalNode CONSUMER() { return getToken(iAgreeParser.CONSUMER, 0); }
		public TerminalNode AS() { return getToken(iAgreeParser.AS, 0); }
		public TerminalNode RESPONDER() { return getToken(iAgreeParser.RESPONDER, 0); }
		public TerminalNode PROVIDER() { return getToken(iAgreeParser.PROVIDER, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public Responder_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_responder_prop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterResponder_prop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitResponder_prop(this);
		}
	}

	public final Responder_propContext responder_prop() throws RecognitionException {
		Responder_propContext _localctx = new Responder_propContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_responder_prop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			_la = _input.LA(1);
			if ( !(((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & ((1L << (PROVIDER - 25)) | (1L << (CONSUMER - 25)) | (1L << (Identifier - 25)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(184); match(AS);
			setState(185); match(RESPONDER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ServiceProvider_propContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode SERVICEPROVIDER() { return getToken(iAgreeParser.SERVICEPROVIDER, 0); }
		public TerminalNode DP() { return getToken(iAgreeParser.DP, 0); }
		public ServiceProvider_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceProvider_prop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterServiceProvider_prop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitServiceProvider_prop(this);
		}
	}

	public final ServiceProvider_propContext serviceProvider_prop() throws RecognitionException {
		ServiceProvider_propContext _localctx = new ServiceProvider_propContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_serviceProvider_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187); match(SERVICEPROVIDER);
			setState(188); match(DP);
			setState(189); match(String);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpirationTime_propContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode EXPIRATIONTIME() { return getToken(iAgreeParser.EXPIRATIONTIME, 0); }
		public TerminalNode DP() { return getToken(iAgreeParser.DP, 0); }
		public ExpirationTime_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expirationTime_prop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterExpirationTime_prop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitExpirationTime_prop(this);
		}
	}

	public final ExpirationTime_propContext expirationTime_prop() throws RecognitionException {
		ExpirationTime_propContext _localctx = new ExpirationTime_propContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_expirationTime_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191); match(EXPIRATIONTIME);
			setState(192); match(DP);
			setState(193); match(String);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DateFormat_propContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode DATEFORMAT() { return getToken(iAgreeParser.DATEFORMAT, 0); }
		public TerminalNode DP() { return getToken(iAgreeParser.DP, 0); }
		public DateFormat_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateFormat_prop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterDateFormat_prop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitDateFormat_prop(this);
		}
	}

	public final DateFormat_propContext dateFormat_prop() throws RecognitionException {
		DateFormat_propContext _localctx = new DateFormat_propContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_dateFormat_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195); match(DATEFORMAT);
			setState(196); match(DP);
			setState(197); match(String);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GmtZone_propContext extends ParserRuleContext {
		public TerminalNode Integer() { return getToken(iAgreeParser.Integer, 0); }
		public TerminalNode GMTZONE() { return getToken(iAgreeParser.GMTZONE, 0); }
		public TerminalNode S_Integer() { return getToken(iAgreeParser.S_Integer, 0); }
		public TerminalNode DP() { return getToken(iAgreeParser.DP, 0); }
		public GmtZone_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gmtZone_prop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterGmtZone_prop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitGmtZone_prop(this);
		}
	}

	public final GmtZone_propContext gmtZone_prop() throws RecognitionException {
		GmtZone_propContext _localctx = new GmtZone_propContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_gmtZone_prop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199); match(GMTZONE);
			setState(200); match(DP);
			setState(201);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==S_Integer) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalPeriod_propContext extends ParserRuleContext {
		public DatePeriod_defContext datePeriod_def() {
			return getRuleContext(DatePeriod_defContext.class,0);
		}
		public TerminalNode GLOBALPERIOD() { return getToken(iAgreeParser.GLOBALPERIOD, 0); }
		public TerminalNode DP() { return getToken(iAgreeParser.DP, 0); }
		public GlobalPeriod_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalPeriod_prop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterGlobalPeriod_prop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitGlobalPeriod_prop(this);
		}
	}

	public final GlobalPeriod_propContext globalPeriod_prop() throws RecognitionException {
		GlobalPeriod_propContext _localctx = new GlobalPeriod_propContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_globalPeriod_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); match(GLOBALPERIOD);
			setState(204); match(DP);
			setState(205); datePeriod_def();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinedPeriod_propContext extends ParserRuleContext {
		public List<PeriodContext> period() {
			return getRuleContexts(PeriodContext.class);
		}
		public TerminalNode DEFINEDPERIOD() { return getToken(iAgreeParser.DEFINEDPERIOD, 0); }
		public PeriodContext period(int i) {
			return getRuleContext(PeriodContext.class,i);
		}
		public TerminalNode DP() { return getToken(iAgreeParser.DP, 0); }
		public DefinedPeriod_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definedPeriod_prop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterDefinedPeriod_prop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitDefinedPeriod_prop(this);
		}
	}

	public final DefinedPeriod_propContext definedPeriod_prop() throws RecognitionException {
		DefinedPeriod_propContext _localctx = new DefinedPeriod_propContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_definedPeriod_prop);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(207); match(DEFINEDPERIOD);
			setState(208); match(DP);
			setState(210); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(209); period();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(212); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Metrics_propContext extends ParserRuleContext {
		public TerminalNode METRICS() { return getToken(iAgreeParser.METRICS, 0); }
		public Key_value_propContext key_value_prop(int i) {
			return getRuleContext(Key_value_propContext.class,i);
		}
		public List<Key_value_propContext> key_value_prop() {
			return getRuleContexts(Key_value_propContext.class);
		}
		public TerminalNode DP() { return getToken(iAgreeParser.DP, 0); }
		public Metrics_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_metrics_prop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterMetrics_prop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitMetrics_prop(this);
		}
	}

	public final Metrics_propContext metrics_prop() throws RecognitionException {
		Metrics_propContext _localctx = new Metrics_propContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_metrics_prop);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(214); match(METRICS);
			setState(215); match(DP);
			setState(217); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(216); key_value_prop();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(219); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatePeriod_defContext extends ParserRuleContext {
		public TerminalNode DURING() { return getToken(iAgreeParser.DURING, 0); }
		public TerminalNode RANGE_SEPARATOR() { return getToken(iAgreeParser.RANGE_SEPARATOR, 0); }
		public List<TerminalNode> Date() { return getTokens(iAgreeParser.Date); }
		public TerminalNode Date(int i) {
			return getToken(iAgreeParser.Date, i);
		}
		public DatePeriod_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datePeriod_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterDatePeriod_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitDatePeriod_def(this);
		}
	}

	public final DatePeriod_defContext datePeriod_def() throws RecognitionException {
		DatePeriod_defContext _localctx = new DatePeriod_defContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_datePeriod_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221); match(DURING);
			setState(222); match(Date);
			setState(223); match(RANGE_SEPARATOR);
			setState(224); match(Date);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TemporalityContext extends ParserRuleContext {
		public TerminalNode ON() { return getToken(iAgreeParser.ON, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TemporalityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_temporality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterTemporality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitTemporality(this);
		}
	}

	public final TemporalityContext temporality() throws RecognitionException {
		TemporalityContext _localctx = new TemporalityContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_temporality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); match(ON);
			setState(227); match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PeriodContext extends ParserRuleContext {
		public List<TerminalNode> EXCEPT() { return getTokens(iAgreeParser.EXCEPT); }
		public TerminalNode EXCEPT(int i) {
			return getToken(iAgreeParser.EXCEPT, i);
		}
		public List<TerminalNode> AND() { return getTokens(iAgreeParser.AND); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public List<Period_defContext> period_def() {
			return getRuleContexts(Period_defContext.class);
		}
		public TerminalNode AND(int i) {
			return getToken(iAgreeParser.AND, i);
		}
		public Period_defContext period_def(int i) {
			return getRuleContext(Period_defContext.class,i);
		}
		public TerminalNode DP() { return getToken(iAgreeParser.DP, 0); }
		public PeriodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_period; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterPeriod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitPeriod(this);
		}
	}

	public final PeriodContext period() throws RecognitionException {
		PeriodContext _localctx = new PeriodContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_period);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229); match(Identifier);
			setState(230); match(DP);
			setState(231); period_def();
			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==AND) {
				{
				{
				setState(232);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==AND) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(233); period_def();
				}
				}
				setState(238);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Period_defContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode ON() { return getToken(iAgreeParser.ON, 0); }
		public TerminalNode RANGE_SEPARATOR() { return getToken(iAgreeParser.RANGE_SEPARATOR, 0); }
		public DatePeriod_defContext datePeriod_def() {
			return getRuleContext(DatePeriod_defContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode Hour(int i) {
			return getToken(iAgreeParser.Hour, i);
		}
		public TerminalNode GLOBALPERIOD() { return getToken(iAgreeParser.GLOBALPERIOD, 0); }
		public TerminalNode FROM() { return getToken(iAgreeParser.FROM, 0); }
		public List<TerminalNode> Hour() { return getTokens(iAgreeParser.Hour); }
		public Period_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_period_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterPeriod_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitPeriod_def(this);
		}
	}

	public final Period_defContext period_def() throws RecognitionException {
		Period_defContext _localctx = new Period_defContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_period_def);
		int _la;
		try {
			setState(250);
			switch (_input.LA(1)) {
			case FROM:
				enterOuterAlt(_localctx, 1);
				{
				setState(239); match(FROM);
				setState(240); match(Hour);
				setState(241); match(RANGE_SEPARATOR);
				setState(242); match(Hour);
				setState(245);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(243); match(ON);
					setState(244); match(Identifier);
					}
				}

				setState(247); datePeriod_def();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(248); id();
				}
				break;
			case GLOBALPERIOD:
				enterOuterAlt(_localctx, 3);
				{
				setState(249); match(GLOBALPERIOD);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ServiceContext extends ParserRuleContext {
		public GlobalDescriptionContext globalDescription() {
			return getRuleContext(GlobalDescriptionContext.class,0);
		}
		public FeaturesContext features() {
			return getRuleContext(FeaturesContext.class,0);
		}
		public UrlContext url() {
			return getRuleContext(UrlContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode SERVICE() { return getToken(iAgreeParser.SERVICE, 0); }
		public TerminalNode AVAL_AT() { return getToken(iAgreeParser.AVAL_AT, 0); }
		public DescriptionsContext descriptions() {
			return getRuleContext(DescriptionsContext.class,0);
		}
		public ServiceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_service; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterService(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitService(this);
		}
	}

	public final ServiceContext service() throws RecognitionException {
		ServiceContext _localctx = new ServiceContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_service);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252); match(SERVICE);
			setState(253); match(Identifier);
			setState(256);
			_la = _input.LA(1);
			if (_la==AVAL_AT) {
				{
				setState(254); match(AVAL_AT);
				setState(255); url();
				}
			}

			setState(259);
			_la = _input.LA(1);
			if (_la==FEATURES) {
				{
				setState(258); features();
				}
			}

			setState(261); globalDescription();
			setState(262); descriptions();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeaturesContext extends ParserRuleContext {
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(iAgreeParser.COMMA); }
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(iAgreeParser.COMMA, i);
		}
		public TerminalNode FEATURES() { return getToken(iAgreeParser.FEATURES, 0); }
		public TerminalNode DP() { return getToken(iAgreeParser.DP, 0); }
		public FeaturesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_features; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterFeatures(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitFeatures(this);
		}
	}

	public final FeaturesContext features() throws RecognitionException {
		FeaturesContext _localctx = new FeaturesContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_features);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(264); match(FEATURES);
			setState(265); match(DP);
			setState(266); feature();
			setState(271);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(267); match(COMMA);
				setState(268); feature();
				}
				}
				setState(273);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GlobalDescriptionContext extends ParserRuleContext {
		public TerminalNode GLOBALDESCRIPTION() { return getToken(iAgreeParser.GLOBALDESCRIPTION, 0); }
		public Key_value_propContext key_value_prop(int i) {
			return getRuleContext(Key_value_propContext.class,i);
		}
		public List<Key_value_propContext> key_value_prop() {
			return getRuleContexts(Key_value_propContext.class);
		}
		public GlobalDescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalDescription; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterGlobalDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitGlobalDescription(this);
		}
	}

	public final GlobalDescriptionContext globalDescription() throws RecognitionException {
		GlobalDescriptionContext _localctx = new GlobalDescriptionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_globalDescription);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274); match(GLOBALDESCRIPTION);
			setState(276); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(275); key_value_prop();
				}
				}
				setState(278); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 30)) & ~0x3f) == 0 && ((1L << (_la - 30)) & ((1L << (BOOLEAN - 30)) | (1L << (INTEGER - 30)) | (1L << (Identifier - 30)) | (1L << (Access - 30)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionsContext extends ParserRuleContext {
		public List<DescriptionContext> description() {
			return getRuleContexts(DescriptionContext.class);
		}
		public DescriptionContext description(int i) {
			return getRuleContext(DescriptionContext.class,i);
		}
		public DescriptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_descriptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterDescriptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitDescriptions(this);
		}
	}

	public final DescriptionsContext descriptions() throws RecognitionException {
		DescriptionsContext _localctx = new DescriptionsContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_descriptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DESCRIPTION) {
				{
				{
				setState(280); description();
				}
				}
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FeatureContext extends ParserRuleContext {
		public List<OpContext> op() {
			return getRuleContexts(OpContext.class);
		}
		public OpContext op(int i) {
			return getRuleContext(OpContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(iAgreeParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(iAgreeParser.COMMA, i);
		}
		public FeatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_feature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterFeature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitFeature(this);
		}
	}

	public final FeatureContext feature() throws RecognitionException {
		FeatureContext _localctx = new FeatureContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_feature);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(286); op();
			setState(291);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(287); match(COMMA);
					setState(288); op();
					}
					} 
				}
				setState(293);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescriptionContext extends ParserRuleContext {
		public Key_value_propContext key_value_prop(int i) {
			return getRuleContext(Key_value_propContext.class,i);
		}
		public List<FeatureContext> feature() {
			return getRuleContexts(FeatureContext.class);
		}
		public TerminalNode FOR() { return getToken(iAgreeParser.FOR, 0); }
		public List<Key_value_propContext> key_value_prop() {
			return getRuleContexts(Key_value_propContext.class);
		}
		public List<TerminalNode> COMMA() { return getTokens(iAgreeParser.COMMA); }
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public TerminalNode COMMA(int i) {
			return getToken(iAgreeParser.COMMA, i);
		}
		public TerminalNode DESCRIPTION() { return getToken(iAgreeParser.DESCRIPTION, 0); }
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitDescription(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294); match(DESCRIPTION);
			setState(295); match(FOR);
			setState(296); feature();
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(297); match(COMMA);
				setState(298); feature();
				}
				}
				setState(303);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(305); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(304); key_value_prop();
				}
				}
				setState(307); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 30)) & ~0x3f) == 0 && ((1L << (_la - 30)) & ((1L << (BOOLEAN - 30)) | (1L << (INTEGER - 30)) | (1L << (Identifier - 30)) | (1L << (Access - 30)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MonitorablePropertiesContext extends ParserRuleContext {
		public Local_MonitorablePropertiesContext local_MonitorableProperties(int i) {
			return getRuleContext(Local_MonitorablePropertiesContext.class,i);
		}
		public Global_MonitorablePropertiesContext global_MonitorableProperties() {
			return getRuleContext(Global_MonitorablePropertiesContext.class,0);
		}
		public TerminalNode MONITORABLEPROPERTIES() { return getToken(iAgreeParser.MONITORABLEPROPERTIES, 0); }
		public List<Local_MonitorablePropertiesContext> local_MonitorableProperties() {
			return getRuleContexts(Local_MonitorablePropertiesContext.class);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public MonitorablePropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_monitorableProperties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterMonitorableProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitMonitorableProperties(this);
		}
	}

	public final MonitorablePropertiesContext monitorableProperties() throws RecognitionException {
		MonitorablePropertiesContext _localctx = new MonitorablePropertiesContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_monitorableProperties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(309); match(MONITORABLEPROPERTIES);
			setState(311);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(310); match(Identifier);
				}
			}

			setState(314);
			_la = _input.LA(1);
			if (_la==GLOBAL) {
				{
				setState(313); global_MonitorableProperties();
				}
			}

			setState(319);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FOR) {
				{
				{
				setState(316); local_MonitorableProperties();
				}
				}
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Global_MonitorablePropertiesContext extends ParserRuleContext {
		public TerminalNode GLOBAL() { return getToken(iAgreeParser.GLOBAL, 0); }
		public Key_value_propContext key_value_prop(int i) {
			return getRuleContext(Key_value_propContext.class,i);
		}
		public List<Key_value_propContext> key_value_prop() {
			return getRuleContexts(Key_value_propContext.class);
		}
		public TerminalNode DP() { return getToken(iAgreeParser.DP, 0); }
		public Global_MonitorablePropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global_MonitorableProperties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterGlobal_MonitorableProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitGlobal_MonitorableProperties(this);
		}
	}

	public final Global_MonitorablePropertiesContext global_MonitorableProperties() throws RecognitionException {
		Global_MonitorablePropertiesContext _localctx = new Global_MonitorablePropertiesContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_global_MonitorableProperties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322); match(GLOBAL);
			setState(323); match(DP);
			setState(325); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(324); key_value_prop();
				}
				}
				setState(327); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 30)) & ~0x3f) == 0 && ((1L << (_la - 30)) & ((1L << (BOOLEAN - 30)) | (1L << (INTEGER - 30)) | (1L << (Identifier - 30)) | (1L << (Access - 30)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Local_MonitorablePropertiesContext extends ParserRuleContext {
		public Key_value_propContext key_value_prop(int i) {
			return getRuleContext(Key_value_propContext.class,i);
		}
		public TerminalNode FOR() { return getToken(iAgreeParser.FOR, 0); }
		public List<Key_value_propContext> key_value_prop() {
			return getRuleContexts(Key_value_propContext.class);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode DP() { return getToken(iAgreeParser.DP, 0); }
		public Local_MonitorablePropertiesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_local_MonitorableProperties; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterLocal_MonitorableProperties(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitLocal_MonitorableProperties(this);
		}
	}

	public final Local_MonitorablePropertiesContext local_MonitorableProperties() throws RecognitionException {
		Local_MonitorablePropertiesContext _localctx = new Local_MonitorablePropertiesContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_local_MonitorableProperties);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329); match(FOR);
			setState(330); match(Identifier);
			setState(331); match(DP);
			setState(333); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(332); key_value_prop();
				}
				}
				setState(335); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 30)) & ~0x3f) == 0 && ((1L << (_la - 30)) & ((1L << (BOOLEAN - 30)) | (1L << (INTEGER - 30)) | (1L << (Identifier - 30)) | (1L << (Access - 30)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GuaranteeTermsContext extends ParserRuleContext {
		public GuaranteeTermContext guaranteeTerm(int i) {
			return getRuleContext(GuaranteeTermContext.class,i);
		}
		public List<GuaranteeTermContext> guaranteeTerm() {
			return getRuleContexts(GuaranteeTermContext.class);
		}
		public TerminalNode GUARANTEE_TERMS() { return getToken(iAgreeParser.GUARANTEE_TERMS, 0); }
		public GuaranteeTermsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guaranteeTerms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterGuaranteeTerms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitGuaranteeTerms(this);
		}
	}

	public final GuaranteeTermsContext guaranteeTerms() throws RecognitionException {
		GuaranteeTermsContext _localctx = new GuaranteeTermsContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_guaranteeTerms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337); match(GUARANTEE_TERMS);
			setState(339); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(338); guaranteeTerm();
				}
				}
				setState(341); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Identifier );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GuaranteeTermContext extends ParserRuleContext {
		public CuantifContext cuantif() {
			return getRuleContext(CuantifContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode OF() { return getToken(iAgreeParser.OF, 0); }
		public Grouped_guaranteeTermContext grouped_guaranteeTerm() {
			return getRuleContext(Grouped_guaranteeTermContext.class,0);
		}
		public Guarantee_defContext guarantee_def() {
			return getRuleContext(Guarantee_defContext.class,0);
		}
		public TerminalNode DP() { return getToken(iAgreeParser.DP, 0); }
		public GuaranteeTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guaranteeTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterGuaranteeTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitGuaranteeTerm(this);
		}
	}

	public final GuaranteeTermContext guaranteeTerm() throws RecognitionException {
		GuaranteeTermContext _localctx = new GuaranteeTermContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_guaranteeTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(343); match(Identifier);
			setState(344); match(DP);
			setState(350);
			switch (_input.LA(1)) {
			case PROVIDER:
			case CONSUMER:
				{
				setState(345); guarantee_def();
				}
				break;
			case EXACTLY_ONE:
			case ONE_OR_MORE:
			case ALL:
				{
				setState(346); cuantif();
				setState(347); match(OF);
				setState(348); grouped_guaranteeTerm();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Grouped_guaranteeTermContext extends ParserRuleContext {
		public GuaranteeTermContext guaranteeTerm(int i) {
			return getRuleContext(GuaranteeTermContext.class,i);
		}
		public List<GuaranteeTermContext> guaranteeTerm() {
			return getRuleContexts(GuaranteeTermContext.class);
		}
		public Grouped_guaranteeTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouped_guaranteeTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterGrouped_guaranteeTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitGrouped_guaranteeTerm(this);
		}
	}

	public final Grouped_guaranteeTermContext grouped_guaranteeTerm() throws RecognitionException {
		Grouped_guaranteeTermContext _localctx = new Grouped_guaranteeTermContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_grouped_guaranteeTerm);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(353); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(352); guaranteeTerm();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(355); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			} while ( _alt!=2 && _alt!=-1 );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Guarantee_defContext extends ParserRuleContext {
		public Token ob;
		public TerminalNode CONSUMER() { return getToken(iAgreeParser.CONSUMER, 0); }
		public TerminalNode SEMICOLON() { return getToken(iAgreeParser.SEMICOLON, 0); }
		public TerminalNode PROVIDER() { return getToken(iAgreeParser.PROVIDER, 0); }
		public Onlyif_sentenceContext onlyif_sentence() {
			return getRuleContext(Onlyif_sentenceContext.class,0);
		}
		public Upon_sentenceContext upon_sentence() {
			return getRuleContext(Upon_sentenceContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode GUARANTEES() { return getToken(iAgreeParser.GUARANTEES, 0); }
		public TemporalityContext temporality() {
			return getRuleContext(TemporalityContext.class,0);
		}
		public Guarantee_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guarantee_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterGuarantee_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitGuarantee_def(this);
		}
	}

	public final Guarantee_defContext guarantee_def() throws RecognitionException {
		Guarantee_defContext _localctx = new Guarantee_defContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_guarantee_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			((Guarantee_defContext)_localctx).ob = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==PROVIDER || _la==CONSUMER) ) {
				((Guarantee_defContext)_localctx).ob = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(358); match(GUARANTEES);
			setState(359); expression();
			setState(361);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(360); temporality();
				}
			}

			setState(363); match(SEMICOLON);
			setState(365);
			_la = _input.LA(1);
			if (_la==UPON) {
				{
				setState(364); upon_sentence();
				}
			}

			setState(368);
			_la = _input.LA(1);
			if (_la==ONLY_IF) {
				{
				setState(367); onlyif_sentence();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370); match(Identifier);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VersionNumberContext extends ParserRuleContext {
		public TerminalNode Float() { return getToken(iAgreeParser.Float, 0); }
		public TerminalNode Version() { return getToken(iAgreeParser.Version, 0); }
		public VersionNumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_versionNumber; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterVersionNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitVersionNumber(this);
		}
	}

	public final VersionNumberContext versionNumber() throws RecognitionException {
		VersionNumberContext _localctx = new VersionNumberContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_versionNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
			_la = _input.LA(1);
			if ( !(_la==Float || _la==Version) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UrlContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode Url() { return getToken(iAgreeParser.Url, 0); }
		public UrlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_url; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterUrl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitUrl(this);
		}
	}

	public final UrlContext url() throws RecognitionException {
		UrlContext _localctx = new UrlContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_url);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
			_la = _input.LA(1);
			if ( !(_la==Url || _la==String) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Key_value_propContext extends ParserRuleContext {
		public Token k;
		public Token v;
		public TypeContext v2;
		public Assig_valueContext a;
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode SEMICOLON() { return getToken(iAgreeParser.SEMICOLON, 0); }
		public TerminalNode BOOLEAN() { return getToken(iAgreeParser.BOOLEAN, 0); }
		public Assig_valueContext assig_value() {
			return getRuleContext(Assig_valueContext.class,0);
		}
		public TerminalNode Access() { return getToken(iAgreeParser.Access, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(iAgreeParser.IGUAL, 0); }
		public TerminalNode INTEGER() { return getToken(iAgreeParser.INTEGER, 0); }
		public TerminalNode DP() { return getToken(iAgreeParser.DP, 0); }
		public Key_value_propContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key_value_prop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterKey_value_prop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitKey_value_prop(this);
		}
	}

	public final Key_value_propContext key_value_prop() throws RecognitionException {
		Key_value_propContext _localctx = new Key_value_propContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_key_value_prop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(376);
			((Key_value_propContext)_localctx).k = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 30)) & ~0x3f) == 0 && ((1L << (_la - 30)) & ((1L << (BOOLEAN - 30)) | (1L << (INTEGER - 30)) | (1L << (Identifier - 30)) | (1L << (Access - 30)))) != 0)) ) {
				((Key_value_propContext)_localctx).k = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(377); match(DP);
			setState(380);
			switch (_input.LA(1)) {
			case String:
				{
				setState(378); ((Key_value_propContext)_localctx).v = match(String);
				}
				break;
			case BOOLEAN:
			case INTEGER:
			case FLOAT:
			case NATURAL:
			case NUMBER:
			case SET:
			case ENUM:
			case Identifier:
				{
				setState(379); ((Key_value_propContext)_localctx).v2 = type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(386);
			_la = _input.LA(1);
			if (_la==IGUAL) {
				{
				setState(382); match(IGUAL);
				setState(383); ((Key_value_propContext)_localctx).a = assig_value();
				setState(384); match(SEMICOLON);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assig_valueContext extends ParserRuleContext {
		public Token val;
		public List<TerminalNode> String() { return getTokens(iAgreeParser.String); }
		public List<TerminalNode> Integer() { return getTokens(iAgreeParser.Integer); }
		public TerminalNode S_Float() { return getToken(iAgreeParser.S_Float, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public TerminalNode String(int i) {
			return getToken(iAgreeParser.String, i);
		}
		public TerminalNode TRUE() { return getToken(iAgreeParser.TRUE, 0); }
		public TerminalNode S_Integer() { return getToken(iAgreeParser.S_Integer, 0); }
		public List<TerminalNode> Identifier() { return getTokens(iAgreeParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(iAgreeParser.Identifier, i);
		}
		public TerminalNode Unit() { return getToken(iAgreeParser.Unit, 0); }
		public TerminalNode Integer(int i) {
			return getToken(iAgreeParser.Integer, i);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode Float() { return getToken(iAgreeParser.Float, 0); }
		public TerminalNode FALSE() { return getToken(iAgreeParser.FALSE, 0); }
		public Assig_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assig_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterAssig_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitAssig_value(this);
		}
	}

	public final Assig_valueContext assig_value() throws RecognitionException {
		Assig_valueContext _localctx = new Assig_valueContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_assig_value);
		int _la;
		try {
			setState(420);
			switch (_input.LA(1)) {
			case Identifier:
			case Integer:
			case String:
				enterOuterAlt(_localctx, 1);
				{
				setState(389); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(388);
					((Assig_valueContext)_localctx).val = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (Identifier - 70)) | (1L << (Integer - 70)) | (1L << (String - 70)))) != 0)) ) {
						((Assig_valueContext)_localctx).val = (Token)_errHandler.recoverInline(this);
					}
					consume();
					}
					}
					setState(391); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (Identifier - 70)) | (1L << (Integer - 70)) | (1L << (String - 70)))) != 0) );
				setState(394);
				_la = _input.LA(1);
				if (_la==Operador) {
					{
					setState(393); operation();
					}
				}

				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(396); match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(397); match(FALSE);
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 4);
				{
				setState(398); match(Float);
				setState(400);
				_la = _input.LA(1);
				if (_la==Unit) {
					{
					setState(399); match(Unit);
					}
				}

				setState(403);
				_la = _input.LA(1);
				if (_la==Operador) {
					{
					setState(402); operation();
					}
				}

				}
				break;
			case S_Float:
				enterOuterAlt(_localctx, 5);
				{
				setState(405); match(S_Float);
				setState(407);
				_la = _input.LA(1);
				if (_la==Unit) {
					{
					setState(406); match(Unit);
					}
				}

				setState(410);
				_la = _input.LA(1);
				if (_la==Operador) {
					{
					setState(409); operation();
					}
				}

				}
				break;
			case S_Integer:
				enterOuterAlt(_localctx, 6);
				{
				setState(412); match(S_Integer);
				setState(414);
				_la = _input.LA(1);
				if (_la==Unit) {
					{
					setState(413); match(Unit);
					}
				}

				setState(417);
				_la = _input.LA(1);
				if (_la==Operador) {
					{
					setState(416); operation();
					}
				}

				}
				break;
			case LLA:
				enterOuterAlt(_localctx, 7);
				{
				setState(419); list();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperationContext extends ParserRuleContext {
		public TerminalNode Operador() { return getToken(iAgreeParser.Operador, 0); }
		public Assig_valueContext assig_value() {
			return getRuleContext(Assig_valueContext.class,0);
		}
		public OperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitOperation(this);
		}
	}

	public final OperationContext operation() throws RecognitionException {
		OperationContext _localctx = new OperationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422); match(Operador);
			setState(423); assig_value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext e1;
		public Token log;
		public ExpressionContext e2;
		public Token ident;
		public Token cmp;
		public Assig_valueContext val;
		public ListContext l;
		public TerminalNode MAYOR() { return getToken(iAgreeParser.MAYOR, 0); }
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode BELONGS() { return getToken(iAgreeParser.BELONGS, 0); }
		public Assig_valueContext assig_value() {
			return getRuleContext(Assig_valueContext.class,0);
		}
		public TerminalNode AND() { return getToken(iAgreeParser.AND, 0); }
		public TerminalNode MENOR() { return getToken(iAgreeParser.MENOR, 0); }
		public TerminalNode OR() { return getToken(iAgreeParser.OR, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode IGUAL() { return getToken(iAgreeParser.IGUAL, 0); }
		public TerminalNode PC() { return getToken(iAgreeParser.PC, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode MAYOR_IGUAL() { return getToken(iAgreeParser.MAYOR_IGUAL, 0); }
		public TerminalNode PA() { return getToken(iAgreeParser.PA, 0); }
		public TerminalNode NOT() { return getToken(iAgreeParser.NOT, 0); }
		public TerminalNode Access() { return getToken(iAgreeParser.Access, 0); }
		public TerminalNode MENOR_IGUAL() { return getToken(iAgreeParser.MENOR_IGUAL, 0); }
		public TerminalNode IMPLIES() { return getToken(iAgreeParser.IMPLIES, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_expression);
		int _la;
		try {
			setState(450);
			switch ( getInterpreter().adaptivePredict(_input,46,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(425); match(NOT);
				setState(426); ((ExpressionContext)_localctx).e1 = expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(427); match(PA);
				setState(428); ((ExpressionContext)_localctx).e1 = expression();
				setState(429); match(PC);
				setState(432);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << IMPLIES))) != 0)) {
					{
					setState(430);
					((ExpressionContext)_localctx).log = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << IMPLIES))) != 0)) ) {
						((ExpressionContext)_localctx).log = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(431); ((ExpressionContext)_localctx).e2 = expression();
					}
				}

				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(434);
				((ExpressionContext)_localctx).ident = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (Identifier - 70)) | (1L << (Access - 70)) | (1L << (String - 70)))) != 0)) ) {
					((ExpressionContext)_localctx).ident = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(437);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MENOR) | (1L << MAYOR) | (1L << IGUAL) | (1L << MENOR_IGUAL) | (1L << MAYOR_IGUAL))) != 0)) {
					{
					setState(435);
					((ExpressionContext)_localctx).cmp = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MENOR) | (1L << MAYOR) | (1L << IGUAL) | (1L << MENOR_IGUAL) | (1L << MAYOR_IGUAL))) != 0)) ) {
						((ExpressionContext)_localctx).cmp = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(436); ((ExpressionContext)_localctx).val = assig_value();
					}
				}

				setState(441);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << IMPLIES))) != 0)) {
					{
					setState(439);
					((ExpressionContext)_localctx).log = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << IMPLIES))) != 0)) ) {
						((ExpressionContext)_localctx).log = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(440); ((ExpressionContext)_localctx).e1 = expression();
					}
				}

				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(443);
				((ExpressionContext)_localctx).ident = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Identifier || _la==Access) ) {
					((ExpressionContext)_localctx).ident = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(444); match(BELONGS);
				setState(445); ((ExpressionContext)_localctx).l = list();
				setState(448);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << IMPLIES))) != 0)) {
					{
					setState(446);
					((ExpressionContext)_localctx).log = _input.LT(1);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << IMPLIES))) != 0)) ) {
						((ExpressionContext)_localctx).log = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(447); ((ExpressionContext)_localctx).e1 = expression();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpContext extends ParserRuleContext {
		public List<TerminalNode> COMMA() { return getTokens(iAgreeParser.COMMA); }
		public TerminalNode PA() { return getToken(iAgreeParser.PA, 0); }
		public TerminalNode Identifier(int i) {
			return getToken(iAgreeParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(iAgreeParser.Identifier); }
		public TerminalNode PC() { return getToken(iAgreeParser.PC, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(iAgreeParser.COMMA, i);
		}
		public OpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterOp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitOp(this);
		}
	}

	public final OpContext op() throws RecognitionException {
		OpContext _localctx = new OpContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452); match(Identifier);
			setState(463);
			_la = _input.LA(1);
			if (_la==PA) {
				{
				setState(453); match(PA);
				setState(454); match(Identifier);
				setState(459);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(455); match(COMMA);
					setState(456); match(Identifier);
					}
					}
					setState(461);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(462); match(PC);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CuantifContext extends ParserRuleContext {
		public TerminalNode ONE_OR_MORE() { return getToken(iAgreeParser.ONE_OR_MORE, 0); }
		public TerminalNode ALL() { return getToken(iAgreeParser.ALL, 0); }
		public TerminalNode EXACTLY_ONE() { return getToken(iAgreeParser.EXACTLY_ONE, 0); }
		public CuantifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cuantif; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterCuantif(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitCuantif(this);
		}
	}

	public final CuantifContext cuantif() throws RecognitionException {
		CuantifContext _localctx = new CuantifContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_cuantif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(465);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << EXACTLY_ONE) | (1L << ONE_OR_MORE) | (1L << ALL))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Upon_sentenceContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(iAgreeParser.SEMICOLON, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode UPON() { return getToken(iAgreeParser.UPON, 0); }
		public Upon_sentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_upon_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterUpon_sentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitUpon_sentence(this);
		}
	}

	public final Upon_sentenceContext upon_sentence() throws RecognitionException {
		Upon_sentenceContext _localctx = new Upon_sentenceContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_upon_sentence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(467); match(UPON);
			setState(468); match(Identifier);
			setState(469); match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Onlyif_sentenceContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(iAgreeParser.SEMICOLON, 0); }
		public TerminalNode PA() { return getToken(iAgreeParser.PA, 0); }
		public TerminalNode ONLY_IF() { return getToken(iAgreeParser.ONLY_IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PC() { return getToken(iAgreeParser.PC, 0); }
		public Onlyif_sentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_onlyif_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterOnlyif_sentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitOnlyif_sentence(this);
		}
	}

	public final Onlyif_sentenceContext onlyif_sentence() throws RecognitionException {
		Onlyif_sentenceContext _localctx = new Onlyif_sentenceContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_onlyif_sentence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471); match(ONLY_IF);
			setState(472); match(PA);
			setState(473); expression();
			setState(474); match(PC);
			setState(475); match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Token v;
		public TerminalNode SET() { return getToken(iAgreeParser.SET, 0); }
		public TerminalNode NATURAL() { return getToken(iAgreeParser.NATURAL, 0); }
		public TerminalNode ENUM() { return getToken(iAgreeParser.ENUM, 0); }
		public TerminalNode BOOLEAN() { return getToken(iAgreeParser.BOOLEAN, 0); }
		public TerminalNode FLOAT() { return getToken(iAgreeParser.FLOAT, 0); }
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(iAgreeParser.NUMBER, 0); }
		public TerminalNode INTEGER() { return getToken(iAgreeParser.INTEGER, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitType(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_type);
		int _la;
		try {
			setState(486);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(477); match(Identifier);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(478); match(SET);
				setState(479); list();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(480); match(ENUM);
				setState(481); list();
				}
				break;
			case BOOLEAN:
			case INTEGER:
			case FLOAT:
			case NATURAL:
			case NUMBER:
				enterOuterAlt(_localctx, 4);
				{
				setState(482);
				((TypeContext)_localctx).v = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INTEGER) | (1L << FLOAT) | (1L << NATURAL) | (1L << NUMBER))) != 0)) ) {
					((TypeContext)_localctx).v = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(484);
				_la = _input.LA(1);
				if (_la==CA) {
					{
					setState(483); range();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListContext extends ParserRuleContext {
		public ListArgContext l1;
		public ListArgContext l2;
		public ListArgContext listArg(int i) {
			return getRuleContext(ListArgContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(iAgreeParser.COMMA); }
		public List<ListArgContext> listArg() {
			return getRuleContexts(ListArgContext.class);
		}
		public TerminalNode LLA() { return getToken(iAgreeParser.LLA, 0); }
		public TerminalNode LLC() { return getToken(iAgreeParser.LLC, 0); }
		public TerminalNode COMMA(int i) {
			return getToken(iAgreeParser.COMMA, i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitList(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488); match(LLA);
			setState(489); ((ListContext)_localctx).l1 = listArg();
			setState(494);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(490); match(COMMA);
				setState(491); ((ListContext)_localctx).l2 = listArg();
				}
				}
				setState(496);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(497); match(LLC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListArgContext extends ParserRuleContext {
		public Token l1;
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode Integer() { return getToken(iAgreeParser.Integer, 0); }
		public TerminalNode S_Float() { return getToken(iAgreeParser.S_Float, 0); }
		public TerminalNode Float() { return getToken(iAgreeParser.Float, 0); }
		public TerminalNode S_Integer() { return getToken(iAgreeParser.S_Integer, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public ListArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listArg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterListArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitListArg(this);
		}
	}

	public final ListArgContext listArg() throws RecognitionException {
		ListArgContext _localctx = new ListArgContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_listArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(499);
			((ListArgContext)_localctx).l1 = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (Identifier - 70)) | (1L << (Integer - 70)) | (1L << (S_Integer - 70)) | (1L << (Float - 70)) | (1L << (S_Float - 70)) | (1L << (String - 70)))) != 0)) ) {
				((ListArgContext)_localctx).l1 = (Token)_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RangeContext extends ParserRuleContext {
		public Token min;
		public Token max;
		public List<TerminalNode> Integer() { return getTokens(iAgreeParser.Integer); }
		public TerminalNode Integer(int i) {
			return getToken(iAgreeParser.Integer, i);
		}
		public TerminalNode CC() { return getToken(iAgreeParser.CC, 0); }
		public TerminalNode RANGE_SEPARATOR() { return getToken(iAgreeParser.RANGE_SEPARATOR, 0); }
		public TerminalNode CA() { return getToken(iAgreeParser.CA, 0); }
		public List<TerminalNode> S_Integer() { return getTokens(iAgreeParser.S_Integer); }
		public TerminalNode S_Integer(int i) {
			return getToken(iAgreeParser.S_Integer, i);
		}
		public RangeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_range; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterRange(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitRange(this);
		}
	}

	public final RangeContext range() throws RecognitionException {
		RangeContext _localctx = new RangeContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_range);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(501); match(CA);
			setState(502);
			((RangeContext)_localctx).min = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==S_Integer) ) {
				((RangeContext)_localctx).min = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(503); match(RANGE_SEPARATOR);
			setState(504);
			((RangeContext)_localctx).max = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==S_Integer) ) {
				((RangeContext)_localctx).max = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(505); match(CC);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3X\u01fe\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\3\2\3\2\3\2\3\2\3\2\3\2\5\2q\n\2\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\7\5\u0084\n\5\f\5\16\5\u0087"+
		"\13\5\3\5\3\5\5\5\u008b\n\5\3\6\7\6\u008e\n\6\f\6\16\6\u0091\13\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7\u009e\n\7\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\n\3\n\3\n\3\n\3\13\6\13\u00ab\n\13\r\13\16\13\u00ac\3\f\3\f"+
		"\3\f\3\f\3\f\5\f\u00b4\n\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\17\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\6\24\u00d5\n\24\r\24\16\24\u00d6"+
		"\3\25\3\25\3\25\6\25\u00dc\n\25\r\25\16\25\u00dd\3\26\3\26\3\26\3\26\3"+
		"\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\7\30\u00ed\n\30\f\30\16\30"+
		"\u00f0\13\30\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00f8\n\31\3\31\3\31\3"+
		"\31\5\31\u00fd\n\31\3\32\3\32\3\32\3\32\5\32\u0103\n\32\3\32\5\32\u0106"+
		"\n\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\7\33\u0110\n\33\f\33\16"+
		"\33\u0113\13\33\3\34\3\34\6\34\u0117\n\34\r\34\16\34\u0118\3\35\7\35\u011c"+
		"\n\35\f\35\16\35\u011f\13\35\3\36\3\36\3\36\7\36\u0124\n\36\f\36\16\36"+
		"\u0127\13\36\3\37\3\37\3\37\3\37\3\37\7\37\u012e\n\37\f\37\16\37\u0131"+
		"\13\37\3\37\6\37\u0134\n\37\r\37\16\37\u0135\3 \3 \5 \u013a\n \3 \5 \u013d"+
		"\n \3 \7 \u0140\n \f \16 \u0143\13 \3!\3!\3!\6!\u0148\n!\r!\16!\u0149"+
		"\3\"\3\"\3\"\3\"\6\"\u0150\n\"\r\"\16\"\u0151\3#\3#\6#\u0156\n#\r#\16"+
		"#\u0157\3$\3$\3$\3$\3$\3$\3$\5$\u0161\n$\3%\6%\u0164\n%\r%\16%\u0165\3"+
		"&\3&\3&\3&\5&\u016c\n&\3&\3&\5&\u0170\n&\3&\5&\u0173\n&\3\'\3\'\3(\3("+
		"\3)\3)\3*\3*\3*\3*\5*\u017f\n*\3*\3*\3*\3*\5*\u0185\n*\3+\6+\u0188\n+"+
		"\r+\16+\u0189\3+\5+\u018d\n+\3+\3+\3+\3+\5+\u0193\n+\3+\5+\u0196\n+\3"+
		"+\3+\5+\u019a\n+\3+\5+\u019d\n+\3+\3+\5+\u01a1\n+\3+\5+\u01a4\n+\3+\5"+
		"+\u01a7\n+\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\5-\u01b3\n-\3-\3-\3-\5-\u01b8"+
		"\n-\3-\3-\5-\u01bc\n-\3-\3-\3-\3-\3-\5-\u01c3\n-\5-\u01c5\n-\3.\3.\3."+
		"\3.\3.\7.\u01cc\n.\f.\16.\u01cf\13.\3.\5.\u01d2\n.\3/\3/\3\60\3\60\3\60"+
		"\3\60\3\61\3\61\3\61\3\61\3\61\3\61\3\62\3\62\3\62\3\62\3\62\3\62\3\62"+
		"\5\62\u01e7\n\62\5\62\u01e9\n\62\3\63\3\63\3\63\3\63\7\63\u01ef\n\63\f"+
		"\63\16\63\u01f2\13\63\3\63\3\63\3\64\3\64\3\65\3\65\3\65\3\65\3\65\3\65"+
		"\3\65\2\66\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BDFHJLNPRTVXZ\\^`bdfh\2\21\4\2\33\34HH\3\2IJ\4\2\36\36\64\64\3\2"+
		"\33\34\4\2KKOO\4\2NNUU\5\2 !HHRR\4\2HIUU\4\2\64\65\67\67\5\2HHRRUU\3\2"+
		"<@\4\2HHRR\3\29;\3\2 $\4\2HLUU\u020e\2p\3\2\2\2\4r\3\2\2\2\6x\3\2\2\2"+
		"\b\u0085\3\2\2\2\n\u008f\3\2\2\2\f\u009d\3\2\2\2\16\u009f\3\2\2\2\20\u00a2"+
		"\3\2\2\2\22\u00a5\3\2\2\2\24\u00aa\3\2\2\2\26\u00ae\3\2\2\2\30\u00b5\3"+
		"\2\2\2\32\u00b9\3\2\2\2\34\u00bd\3\2\2\2\36\u00c1\3\2\2\2 \u00c5\3\2\2"+
		"\2\"\u00c9\3\2\2\2$\u00cd\3\2\2\2&\u00d1\3\2\2\2(\u00d8\3\2\2\2*\u00df"+
		"\3\2\2\2,\u00e4\3\2\2\2.\u00e7\3\2\2\2\60\u00fc\3\2\2\2\62\u00fe\3\2\2"+
		"\2\64\u010a\3\2\2\2\66\u0114\3\2\2\28\u011d\3\2\2\2:\u0120\3\2\2\2<\u0128"+
		"\3\2\2\2>\u0137\3\2\2\2@\u0144\3\2\2\2B\u014b\3\2\2\2D\u0153\3\2\2\2F"+
		"\u0159\3\2\2\2H\u0163\3\2\2\2J\u0167\3\2\2\2L\u0174\3\2\2\2N\u0176\3\2"+
		"\2\2P\u0178\3\2\2\2R\u017a\3\2\2\2T\u01a6\3\2\2\2V\u01a8\3\2\2\2X\u01c4"+
		"\3\2\2\2Z\u01c6\3\2\2\2\\\u01d3\3\2\2\2^\u01d5\3\2\2\2`\u01d9\3\2\2\2"+
		"b\u01e8\3\2\2\2d\u01ea\3\2\2\2f\u01f5\3\2\2\2h\u01f7\3\2\2\2jk\5\4\3\2"+
		"kl\7\4\2\2lq\3\2\2\2mn\5\6\4\2no\7\6\2\2oq\3\2\2\2pj\3\2\2\2pm\3\2\2\2"+
		"q\3\3\2\2\2rs\7\3\2\2st\7H\2\2tu\7\35\2\2uv\5N(\2vw\5\b\5\2w\5\3\2\2\2"+
		"xy\7\5\2\2yz\7H\2\2z{\7\35\2\2{|\5N(\2|}\7\62\2\2}~\7H\2\2~\177\7\35\2"+
		"\2\177\u0080\5N(\2\u0080\u0081\5\n\6\2\u0081\7\3\2\2\2\u0082\u0084\5\f"+
		"\7\2\u0083\u0082\3\2\2\2\u0084\u0087\3\2\2\2\u0085\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0085\3\2\2\2\u0088\u008a\5\16"+
		"\b\2\u0089\u008b\5\20\t\2\u008a\u0089\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\t\3\2\2\2\u008c\u008e\5\f\7\2\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2"+
		"\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091\u008f"+
		"\3\2\2\2\u0092\u0093\5\16\b\2\u0093\13\3\2\2\2\u0094\u009e\5\30\r\2\u0095"+
		"\u009e\5\32\16\2\u0096\u009e\5\34\17\2\u0097\u009e\5\36\20\2\u0098\u009e"+
		"\5 \21\2\u0099\u009e\5\"\22\2\u009a\u009e\5$\23\2\u009b\u009e\5&\24\2"+
		"\u009c\u009e\5(\25\2\u009d\u0094\3\2\2\2\u009d\u0095\3\2\2\2\u009d\u0096"+
		"\3\2\2\2\u009d\u0097\3\2\2\2\u009d\u0098\3\2\2\2\u009d\u0099\3\2\2\2\u009d"+
		"\u009a\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009c\3\2\2\2\u009e\r\3\2\2\2"+
		"\u009f\u00a0\7\20\2\2\u00a0\u00a1\5\22\n\2\u00a1\17\3\2\2\2\u00a2\u00a3"+
		"\7\21\2\2\u00a3\u00a4\5\24\13\2\u00a4\21\3\2\2\2\u00a5\u00a6\5\62\32\2"+
		"\u00a6\u00a7\5> \2\u00a7\u00a8\5D#\2\u00a8\23\3\2\2\2\u00a9\u00ab\5\26"+
		"\f\2\u00aa\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac"+
		"\u00ad\3\2\2\2\u00ad\25\3\2\2\2\u00ae\u00af\7H\2\2\u00af\u00b0\7E\2\2"+
		"\u00b0\u00b1\5X-\2\u00b1\u00b3\7F\2\2\u00b2\u00b4\5`\61\2\u00b3\u00b2"+
		"\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\27\3\2\2\2\u00b5\u00b6\7\7\2\2\u00b6"+
		"\u00b7\7E\2\2\u00b7\u00b8\7U\2\2\u00b8\31\3\2\2\2\u00b9\u00ba\t\2\2\2"+
		"\u00ba\u00bb\7\63\2\2\u00bb\u00bc\7\b\2\2\u00bc\33\3\2\2\2\u00bd\u00be"+
		"\7\t\2\2\u00be\u00bf\7E\2\2\u00bf\u00c0\7U\2\2\u00c0\35\3\2\2\2\u00c1"+
		"\u00c2\7\n\2\2\u00c2\u00c3\7E\2\2\u00c3\u00c4\7U\2\2\u00c4\37\3\2\2\2"+
		"\u00c5\u00c6\7\13\2\2\u00c6\u00c7\7E\2\2\u00c7\u00c8\7U\2\2\u00c8!\3\2"+
		"\2\2\u00c9\u00ca\7\f\2\2\u00ca\u00cb\7E\2\2\u00cb\u00cc\t\3\2\2\u00cc"+
		"#\3\2\2\2\u00cd\u00ce\7\r\2\2\u00ce\u00cf\7E\2\2\u00cf\u00d0\5*\26\2\u00d0"+
		"%\3\2\2\2\u00d1\u00d2\7\16\2\2\u00d2\u00d4\7E\2\2\u00d3\u00d5\5.\30\2"+
		"\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7"+
		"\3\2\2\2\u00d7\'\3\2\2\2\u00d8\u00d9\7\17\2\2\u00d9\u00db\7E\2\2\u00da"+
		"\u00dc\5R*\2\u00db\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd\u00db\3\2\2"+
		"\2\u00dd\u00de\3\2\2\2\u00de)\3\2\2\2\u00df\u00e0\7\37\2\2\u00e0\u00e1"+
		"\7P\2\2\u00e1\u00e2\7G\2\2\u00e2\u00e3\7P\2\2\u00e3+\3\2\2\2\u00e4\u00e5"+
		"\7/\2\2\u00e5\u00e6\7H\2\2\u00e6-\3\2\2\2\u00e7\u00e8\7H\2\2\u00e8\u00e9"+
		"\7E\2\2\u00e9\u00ee\5\60\31\2\u00ea\u00eb\t\4\2\2\u00eb\u00ed\5\60\31"+
		"\2\u00ec\u00ea\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef"+
		"\3\2\2\2\u00ef/\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f2\7\60\2\2\u00f2"+
		"\u00f3\7Q\2\2\u00f3\u00f4\7G\2\2\u00f4\u00f7\7Q\2\2\u00f5\u00f6\7/\2\2"+
		"\u00f6\u00f8\7H\2\2\u00f7\u00f5\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9"+
		"\3\2\2\2\u00f9\u00fd\5*\26\2\u00fa\u00fd\5L\'\2\u00fb\u00fd\7\r\2\2\u00fc"+
		"\u00f1\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd\61\3\2\2"+
		"\2\u00fe\u00ff\7\23\2\2\u00ff\u0102\7H\2\2\u0100\u0101\7\32\2\2\u0101"+
		"\u0103\5P)\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103\u0105\3\2\2"+
		"\2\u0104\u0106\5\64\33\2\u0105\u0104\3\2\2\2\u0105\u0106\3\2\2\2\u0106"+
		"\u0107\3\2\2\2\u0107\u0108\5\66\34\2\u0108\u0109\58\35\2\u0109\63\3\2"+
		"\2\2\u010a\u010b\7\24\2\2\u010b\u010c\7E\2\2\u010c\u0111\5:\36\2\u010d"+
		"\u010e\7D\2\2\u010e\u0110\5:\36\2\u010f\u010d\3\2\2\2\u0110\u0113\3\2"+
		"\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112\65\3\2\2\2\u0113\u0111"+
		"\3\2\2\2\u0114\u0116\7\25\2\2\u0115\u0117\5R*\2\u0116\u0115\3\2\2\2\u0117"+
		"\u0118\3\2\2\2\u0118\u0116\3\2\2\2\u0118\u0119\3\2\2\2\u0119\67\3\2\2"+
		"\2\u011a\u011c\5<\37\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b"+
		"\3\2\2\2\u011d\u011e\3\2\2\2\u011e9\3\2\2\2\u011f\u011d\3\2\2\2\u0120"+
		"\u0125\5Z.\2\u0121\u0122\7D\2\2\u0122\u0124\5Z.\2\u0123\u0121\3\2\2\2"+
		"\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126;\3"+
		"\2\2\2\u0127\u0125\3\2\2\2\u0128\u0129\7\26\2\2\u0129\u012a\7\62\2\2\u012a"+
		"\u012f\5:\36\2\u012b\u012c\7D\2\2\u012c\u012e\5:\36\2\u012d\u012b\3\2"+
		"\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130"+
		"\u0133\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0134\5R*\2\u0133\u0132\3\2\2"+
		"\2\u0134\u0135\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136="+
		"\3\2\2\2\u0137\u0139\7\30\2\2\u0138\u013a\7H\2\2\u0139\u0138\3\2\2\2\u0139"+
		"\u013a\3\2\2\2\u013a\u013c\3\2\2\2\u013b\u013d\5@!\2\u013c\u013b\3\2\2"+
		"\2\u013c\u013d\3\2\2\2\u013d\u0141\3\2\2\2\u013e\u0140\5B\"\2\u013f\u013e"+
		"\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0141\u0142\3\2\2\2\u0142"+
		"?\3\2\2\2\u0143\u0141\3\2\2\2\u0144\u0145\7\27\2\2\u0145\u0147\7E\2\2"+
		"\u0146\u0148\5R*\2\u0147\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u0147"+
		"\3\2\2\2\u0149\u014a\3\2\2\2\u014aA\3\2\2\2\u014b\u014c\7\62\2\2\u014c"+
		"\u014d\7H\2\2\u014d\u014f\7E\2\2\u014e\u0150\5R*\2\u014f\u014e\3\2\2\2"+
		"\u0150\u0151\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152\3\2\2\2\u0152C\3"+
		"\2\2\2\u0153\u0155\7\22\2\2\u0154\u0156\5F$\2\u0155\u0154\3\2\2\2\u0156"+
		"\u0157\3\2\2\2\u0157\u0155\3\2\2\2\u0157\u0158\3\2\2\2\u0158E\3\2\2\2"+
		"\u0159\u015a\7H\2\2\u015a\u0160\7E\2\2\u015b\u0161\5J&\2\u015c\u015d\5"+
		"\\/\2\u015d\u015e\7\61\2\2\u015e\u015f\5H%\2\u015f\u0161\3\2\2\2\u0160"+
		"\u015b\3\2\2\2\u0160\u015c\3\2\2\2\u0161G\3\2\2\2\u0162\u0164\5F$\2\u0163"+
		"\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2"+
		"\2\2\u0166I\3\2\2\2\u0167\u0168\t\5\2\2\u0168\u0169\7\31\2\2\u0169\u016b"+
		"\5X-\2\u016a\u016c\5,\27\2\u016b\u016a\3\2\2\2\u016b\u016c\3\2\2\2\u016c"+
		"\u016d\3\2\2\2\u016d\u016f\7F\2\2\u016e\u0170\5^\60\2\u016f\u016e\3\2"+
		"\2\2\u016f\u0170\3\2\2\2\u0170\u0172\3\2\2\2\u0171\u0173\5`\61\2\u0172"+
		"\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173K\3\2\2\2\u0174\u0175\7H\2\2\u0175"+
		"M\3\2\2\2\u0176\u0177\t\6\2\2\u0177O\3\2\2\2\u0178\u0179\t\7\2\2\u0179"+
		"Q\3\2\2\2\u017a\u017b\t\b\2\2\u017b\u017e\7E\2\2\u017c\u017f\7U\2\2\u017d"+
		"\u017f\5b\62\2\u017e\u017c\3\2\2\2\u017e\u017d\3\2\2\2\u017f\u0184\3\2"+
		"\2\2\u0180\u0181\7>\2\2\u0181\u0182\5T+\2\u0182\u0183\7F\2\2\u0183\u0185"+
		"\3\2\2\2\u0184\u0180\3\2\2\2\u0184\u0185\3\2\2\2\u0185S\3\2\2\2\u0186"+
		"\u0188\t\t\2\2\u0187\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u0187\3\2"+
		"\2\2\u0189\u018a\3\2\2\2\u018a\u018c\3\2\2\2\u018b\u018d\5V,\2\u018c\u018b"+
		"\3\2\2\2\u018c\u018d\3\2\2\2\u018d\u01a7\3\2\2\2\u018e\u01a7\7\'\2\2\u018f"+
		"\u01a7\7(\2\2\u0190\u0192\7K\2\2\u0191\u0193\7S\2\2\u0192\u0191\3\2\2"+
		"\2\u0192\u0193\3\2\2\2\u0193\u0195\3\2\2\2\u0194\u0196\5V,\2\u0195\u0194"+
		"\3\2\2\2\u0195\u0196\3\2\2\2\u0196\u01a7\3\2\2\2\u0197\u0199\7L\2\2\u0198"+
		"\u019a\7S\2\2\u0199\u0198\3\2\2\2\u0199\u019a\3\2\2\2\u019a\u019c\3\2"+
		"\2\2\u019b\u019d\5V,\2\u019c\u019b\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u01a7"+
		"\3\2\2\2\u019e\u01a0\7J\2\2\u019f\u01a1\7S\2\2\u01a0\u019f\3\2\2\2\u01a0"+
		"\u01a1\3\2\2\2\u01a1\u01a3\3\2\2\2\u01a2\u01a4\5V,\2\u01a3\u01a2\3\2\2"+
		"\2\u01a3\u01a4\3\2\2\2\u01a4\u01a7\3\2\2\2\u01a5\u01a7\5d\63\2\u01a6\u0187"+
		"\3\2\2\2\u01a6\u018e\3\2\2\2\u01a6\u018f\3\2\2\2\u01a6\u0190\3\2\2\2\u01a6"+
		"\u0197\3\2\2\2\u01a6\u019e\3\2\2\2\u01a6\u01a5\3\2\2\2\u01a7U\3\2\2\2"+
		"\u01a8\u01a9\7T\2\2\u01a9\u01aa\5T+\2\u01aaW\3\2\2\2\u01ab\u01ac\7\66"+
		"\2\2\u01ac\u01c5\5X-\2\u01ad\u01ae\7+\2\2\u01ae\u01af\5X-\2\u01af\u01b2"+
		"\7,\2\2\u01b0\u01b1\t\n\2\2\u01b1\u01b3\5X-\2\u01b2\u01b0\3\2\2\2\u01b2"+
		"\u01b3\3\2\2\2\u01b3\u01c5\3\2\2\2\u01b4\u01b7\t\13\2\2\u01b5\u01b6\t"+
		"\f\2\2\u01b6\u01b8\5T+\2\u01b7\u01b5\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8"+
		"\u01bb\3\2\2\2\u01b9\u01ba\t\n\2\2\u01ba\u01bc\5X-\2\u01bb\u01b9\3\2\2"+
		"\2\u01bb\u01bc\3\2\2\2\u01bc\u01c5\3\2\2\2\u01bd\u01be\t\r\2\2\u01be\u01bf"+
		"\7A\2\2\u01bf\u01c2\5d\63\2\u01c0\u01c1\t\n\2\2\u01c1\u01c3\5X-\2\u01c2"+
		"\u01c0\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c5\3\2\2\2\u01c4\u01ab\3\2"+
		"\2\2\u01c4\u01ad\3\2\2\2\u01c4\u01b4\3\2\2\2\u01c4\u01bd\3\2\2\2\u01c5"+
		"Y\3\2\2\2\u01c6\u01d1\7H\2\2\u01c7\u01c8\7+\2\2\u01c8\u01cd\7H\2\2\u01c9"+
		"\u01ca\7D\2\2\u01ca\u01cc\7H\2\2\u01cb\u01c9\3\2\2\2\u01cc\u01cf\3\2\2"+
		"\2\u01cd\u01cb\3\2\2\2\u01cd\u01ce\3\2\2\2\u01ce\u01d0\3\2\2\2\u01cf\u01cd"+
		"\3\2\2\2\u01d0\u01d2\7,\2\2\u01d1\u01c7\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2"+
		"[\3\2\2\2\u01d3\u01d4\t\16\2\2\u01d4]\3\2\2\2\u01d5\u01d6\7B\2\2\u01d6"+
		"\u01d7\7H\2\2\u01d7\u01d8\7F\2\2\u01d8_\3\2\2\2\u01d9\u01da\78\2\2\u01da"+
		"\u01db\7+\2\2\u01db\u01dc\5X-\2\u01dc\u01dd\7,\2\2\u01dd\u01de\7F\2\2"+
		"\u01dea\3\2\2\2\u01df\u01e9\7H\2\2\u01e0\u01e1\7%\2\2\u01e1\u01e9\5d\63"+
		"\2\u01e2\u01e3\7&\2\2\u01e3\u01e9\5d\63\2\u01e4\u01e6\t\17\2\2\u01e5\u01e7"+
		"\5h\65\2\u01e6\u01e5\3\2\2\2\u01e6\u01e7\3\2\2\2\u01e7\u01e9\3\2\2\2\u01e8"+
		"\u01df\3\2\2\2\u01e8\u01e0\3\2\2\2\u01e8\u01e2\3\2\2\2\u01e8\u01e4\3\2"+
		"\2\2\u01e9c\3\2\2\2\u01ea\u01eb\7-\2\2\u01eb\u01f0\5f\64\2\u01ec\u01ed"+
		"\7D\2\2\u01ed\u01ef\5f\64\2\u01ee\u01ec\3\2\2\2\u01ef\u01f2\3\2\2\2\u01f0"+
		"\u01ee\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\u01f3\3\2\2\2\u01f2\u01f0\3\2"+
		"\2\2\u01f3\u01f4\7.\2\2\u01f4e\3\2\2\2\u01f5\u01f6\t\20\2\2\u01f6g\3\2"+
		"\2\2\u01f7\u01f8\7)\2\2\u01f8\u01f9\t\3\2\2\u01f9\u01fa\7G\2\2\u01fa\u01fb"+
		"\t\3\2\2\u01fb\u01fc\7*\2\2\u01fci\3\2\2\2\66p\u0085\u008a\u008f\u009d"+
		"\u00ac\u00b3\u00d6\u00dd\u00ee\u00f7\u00fc\u0102\u0105\u0111\u0118\u011d"+
		"\u0125\u012f\u0135\u0139\u013c\u0141\u0149\u0151\u0157\u0160\u0165\u016b"+
		"\u016f\u0172\u017e\u0184\u0189\u018c\u0192\u0195\u0199\u019c\u01a0\u01a3"+
		"\u01a6\u01b2\u01b7\u01bb\u01c2\u01c4\u01cd\u01d1\u01e6\u01e8\u01f0";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}