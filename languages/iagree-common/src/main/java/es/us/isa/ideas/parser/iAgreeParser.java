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
		T__3=1, T__2=2, T__1=3, T__0=4, TEMPLATE=5, END_TEMPLATE=6, AG_OFFER=7, 
		END_AG_OFFER=8, INITIATOR=9, RESPONDER=10, SERVICEPROVIDER=11, EXPIRATIONTIME=12, 
		DATEFORMAT=13, GMTZONE=14, GLOBALPERIOD=15, DEFINEDPERIOD=16, METRICS=17, 
		AGREEMENT_TERMS=18, CREATION_CONSTRAINTS=19, GUARANTEE_TERMS=20, SERVICE=21, 
		FEATURES=22, GLOBALDESCRIPTION=23, DESCRIPTION=24, GLOBAL=25, MONITORABLEPROPERTIES=26, 
		GUARANTEES=27, AVAL_AT=28, PROVIDER=29, CONSUMER=30, VERSION=31, EXCEPT=32, 
		DURING=33, BOOLEAN=34, INTEGER=35, FLOAT=36, NATURAL=37, NUMBER=38, SET=39, 
		ENUM=40, TRUE=41, FALSE=42, WITH=43, END=44, IF=45, YEARLY=46, MONTHLY=47, 
		WEEKLY=48, DAILY=49, HOURLY=50, MINUTELY=51, PENALTY=52, REWARD=53, ON=54, 
		FROM=55, OF=56, FOR=57, AS=58, CA=59, CC=60, PA=61, PC=62, LLA=63, LLC=64, 
		AND=65, OR=66, NOT=67, IMPLIES=68, ONLY_IF=69, EXACTLY_ONE=70, ONE_OR_MORE=71, 
		ALL=72, LT=73, GT=74, EQ=75, LTE=76, GTE=77, BELONGS=78, UPON=79, Identifier=80, 
		Integer=81, S_Integer=82, Float=83, S_Float=84, Boolean=85, Url=86, Version=87, 
		Date=88, Hour=89, Access=90, Unit=91, Operador=92, String=93, WS=94, COMMENT=95, 
		LINE_COMMENT=96;
	public static final String[] tokenNames = {
		"<INVALID>", "','", "':'", "';'", "'..'", "'Template'", "'EndTemplate'", 
		"'AgreementOffer'", "'EndAgreementOffer'", "'Initiator'", "'Responder'", 
		"'ServiceProvider'", "'ExpirationTime'", "'DateFormat'", "'GMTZone'", 
		"'GlobalPeriod'", "'DefinedPeriod'", "'Metrics'", "'AgreementTerms'", 
		"'CreationConstraints'", "'GuaranteeTerms'", "'Service'", "'Features/Operations'", 
		"'GlobalDescription'", "'Description'", "'global'", "'MonitorableProperties'", 
		"'guarantees'", "'availableAt.'", "'Provider'", "'Consumer'", "'version'", 
		"'except'", "'during'", "'boolean'", "'integer'", "'float'", "'natural'", 
		"'number'", "'set'", "'enum'", "'true'", "'false'", "'with'", "'end'", 
		"'if'", "'yearly'", "'monthly'", "'weekly'", "'daily'", "'hourly'", "'minutely'", 
		"'penalty'", "'reward'", "'on'", "'from'", "'of'", "'for'", "'as'", "'['", 
		"']'", "'('", "')'", "'{'", "'}'", "'AND'", "'OR'", "'NOT'", "'IMPLIES'", 
		"'onlyIf'", "'exactly one'", "'one or more'", "'all'", "'<'", "'>'", "'='", 
		"'<='", "'>='", "'belongs'", "'upon'", "Identifier", "Integer", "S_Integer", 
		"Float", "S_Float", "Boolean", "Url", "Version", "Date", "Hour", "Access", 
		"Unit", "Operador", "String", "WS", "COMMENT", "LINE_COMMENT"
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
		RULE_guarantee_def = 36, RULE_slo = 37, RULE_serviceScope = 38, RULE_qualifyingCondition = 39, 
		RULE_compensations = 40, RULE_compensationsInterval = 41, RULE_compensation = 42, 
		RULE_id = 43, RULE_versionNumber = 44, RULE_url = 45, RULE_key_value_prop = 46, 
		RULE_assig_value = 47, RULE_operation = 48, RULE_expression = 49, RULE_op = 50, 
		RULE_cuantif = 51, RULE_type = 52, RULE_list = 53, RULE_listArg = 54, 
		RULE_range = 55;
	public static final String[] ruleNames = {
		"entry", "template", "agOffer", "template_def", "ag_def", "temp_properties", 
		"agreementTerms", "creationConstraints", "agreementTerms_def", "creationConstraints_def", 
		"creationConstraint", "initiator_prop", "responder_prop", "serviceProvider_prop", 
		"expirationTime_prop", "dateFormat_prop", "gmtZone_prop", "globalPeriod_prop", 
		"definedPeriod_prop", "metrics_prop", "datePeriod_def", "temporality", 
		"period", "period_def", "service", "features", "globalDescription", "descriptions", 
		"feature", "description", "monitorableProperties", "global_MonitorableProperties", 
		"local_MonitorableProperties", "guaranteeTerms", "guaranteeTerm", "grouped_guaranteeTerm", 
		"guarantee_def", "slo", "serviceScope", "qualifyingCondition", "compensations", 
		"compensationsInterval", "compensation", "id", "versionNumber", "url", 
		"key_value_prop", "assig_value", "operation", "expression", "op", "cuantif", 
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
			setState(118);
			switch (_input.LA(1)) {
			case TEMPLATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(112); template();
				setState(113); match(END_TEMPLATE);
				}
				break;
			case AG_OFFER:
				enterOuterAlt(_localctx, 2);
				{
				setState(115); agOffer();
				setState(116); match(END_AG_OFFER);
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
			setState(120); match(TEMPLATE);
			setState(121); match(Identifier);
			setState(122); match(VERSION);
			setState(123); versionNumber();
			setState(124); template_def();
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
			setState(126); match(AG_OFFER);
			setState(127); match(Identifier);
			setState(128); match(VERSION);
			setState(129); versionNumber();
			setState(130); match(FOR);
			setState(131); match(Identifier);
			setState(132); match(VERSION);
			setState(133); versionNumber();
			setState(134); ag_def();
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
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INITIATOR) | (1L << SERVICEPROVIDER) | (1L << EXPIRATIONTIME) | (1L << DATEFORMAT) | (1L << GMTZONE) | (1L << GLOBALPERIOD) | (1L << DEFINEDPERIOD) | (1L << METRICS) | (1L << PROVIDER) | (1L << CONSUMER))) != 0) || _la==Identifier) {
				{
				{
				setState(136); temp_properties();
				}
				}
				setState(141);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(142); agreementTerms();
			setState(144);
			_la = _input.LA(1);
			if (_la==CREATION_CONSTRAINTS) {
				{
				setState(143); creationConstraints();
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
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INITIATOR) | (1L << SERVICEPROVIDER) | (1L << EXPIRATIONTIME) | (1L << DATEFORMAT) | (1L << GMTZONE) | (1L << GLOBALPERIOD) | (1L << DEFINEDPERIOD) | (1L << METRICS) | (1L << PROVIDER) | (1L << CONSUMER))) != 0) || _la==Identifier) {
				{
				{
				setState(146); temp_properties();
				}
				}
				setState(151);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(152); agreementTerms();
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
			setState(163);
			switch (_input.LA(1)) {
			case INITIATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(154); initiator_prop();
				}
				break;
			case PROVIDER:
			case CONSUMER:
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(155); responder_prop();
				}
				break;
			case SERVICEPROVIDER:
				enterOuterAlt(_localctx, 3);
				{
				setState(156); serviceProvider_prop();
				}
				break;
			case EXPIRATIONTIME:
				enterOuterAlt(_localctx, 4);
				{
				setState(157); expirationTime_prop();
				}
				break;
			case DATEFORMAT:
				enterOuterAlt(_localctx, 5);
				{
				setState(158); dateFormat_prop();
				}
				break;
			case GMTZONE:
				enterOuterAlt(_localctx, 6);
				{
				setState(159); gmtZone_prop();
				}
				break;
			case GLOBALPERIOD:
				enterOuterAlt(_localctx, 7);
				{
				setState(160); globalPeriod_prop();
				}
				break;
			case DEFINEDPERIOD:
				enterOuterAlt(_localctx, 8);
				{
				setState(161); definedPeriod_prop();
				}
				break;
			case METRICS:
				enterOuterAlt(_localctx, 9);
				{
				setState(162); metrics_prop();
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
			setState(165); match(AGREEMENT_TERMS);
			setState(166); agreementTerms_def();
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
			setState(168); match(CREATION_CONSTRAINTS);
			setState(169); creationConstraints_def();
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
			setState(171); service();
			setState(172); monitorableProperties();
			setState(173); guaranteeTerms();
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
			setState(176); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(175); creationConstraint();
				}
				}
				setState(178); 
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
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public QualifyingConditionContext qualifyingCondition() {
			return getRuleContext(QualifyingConditionContext.class,0);
		}
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
			setState(180); match(Identifier);
			}
			setState(181); match(2);
			setState(182); expression();
			setState(183); match(3);
			setState(185);
			_la = _input.LA(1);
			if (_la==ONLY_IF) {
				{
				setState(184); qualifyingCondition();
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
			setState(187); match(INITIATOR);
			setState(188); match(2);
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
			setState(191);
			_la = _input.LA(1);
			if ( !(((((_la - 29)) & ~0x3f) == 0 && ((1L << (_la - 29)) & ((1L << (PROVIDER - 29)) | (1L << (CONSUMER - 29)) | (1L << (Identifier - 29)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(192); match(AS);
			setState(193); match(RESPONDER);
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
			setState(195); match(SERVICEPROVIDER);
			setState(196); match(2);
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

	public static class ExpirationTime_propContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode EXPIRATIONTIME() { return getToken(iAgreeParser.EXPIRATIONTIME, 0); }
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
			setState(199); match(EXPIRATIONTIME);
			setState(200); match(2);
			setState(201); match(String);
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
			setState(203); match(DATEFORMAT);
			setState(204); match(2);
			setState(205); match(String);
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
			setState(207); match(GMTZONE);
			setState(208); match(2);
			setState(209);
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
			setState(211); match(GLOBALPERIOD);
			setState(212); match(2);
			setState(213); datePeriod_def();
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
			setState(215); match(DEFINEDPERIOD);
			setState(216); match(2);
			setState(218); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(217); period();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(220); 
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
			setState(222); match(METRICS);
			setState(223); match(2);
			setState(225); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(224); key_value_prop();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(227); 
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
			setState(229); match(DURING);
			setState(230); match(Date);
			setState(231); match(4);
			setState(232); match(Date);
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
			setState(234); match(ON);
			setState(235); match(Identifier);
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
			setState(237); match(Identifier);
			setState(238); match(2);
			setState(239); period_def();
			setState(244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==EXCEPT || _la==AND) {
				{
				{
				setState(240);
				_la = _input.LA(1);
				if ( !(_la==EXCEPT || _la==AND) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(241); period_def();
				}
				}
				setState(246);
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
			setState(258);
			switch (_input.LA(1)) {
			case FROM:
				enterOuterAlt(_localctx, 1);
				{
				setState(247); match(FROM);
				setState(248); match(Hour);
				setState(249); match(4);
				setState(250); match(Hour);
				setState(253);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(251); match(ON);
					setState(252); match(Identifier);
					}
				}

				setState(255); datePeriod_def();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(256); id();
				}
				break;
			case GLOBALPERIOD:
				enterOuterAlt(_localctx, 3);
				{
				setState(257); match(GLOBALPERIOD);
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
			setState(260); match(SERVICE);
			setState(261); match(Identifier);
			setState(264);
			_la = _input.LA(1);
			if (_la==AVAL_AT) {
				{
				setState(262); match(AVAL_AT);
				setState(263); url();
				}
			}

			setState(267);
			_la = _input.LA(1);
			if (_la==FEATURES) {
				{
				setState(266); features();
				}
			}

			setState(269); globalDescription();
			setState(270); descriptions();
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
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
		}
		public TerminalNode FEATURES() { return getToken(iAgreeParser.FEATURES, 0); }
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
			setState(272); match(FEATURES);
			setState(273); match(2);
			setState(274); feature();
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(275); match(1);
				setState(276); feature();
				}
				}
				setState(281);
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
			setState(282); match(GLOBALDESCRIPTION);
			setState(284); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(283); key_value_prop();
				}
				}
				setState(286); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 34)) & ~0x3f) == 0 && ((1L << (_la - 34)) & ((1L << (BOOLEAN - 34)) | (1L << (INTEGER - 34)) | (1L << (Identifier - 34)) | (1L << (Access - 34)))) != 0) );
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
			setState(291);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DESCRIPTION) {
				{
				{
				setState(288); description();
				}
				}
				setState(293);
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
			setState(294); op();
			setState(299);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(295); match(1);
					setState(296); op();
					}
					} 
				}
				setState(301);
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
		public FeatureContext feature(int i) {
			return getRuleContext(FeatureContext.class,i);
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
			setState(302); match(DESCRIPTION);
			setState(303); match(FOR);
			setState(304); feature();
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(305); match(1);
				setState(306); feature();
				}
				}
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(313); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(312); key_value_prop();
				}
				}
				setState(315); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 34)) & ~0x3f) == 0 && ((1L << (_la - 34)) & ((1L << (BOOLEAN - 34)) | (1L << (INTEGER - 34)) | (1L << (Identifier - 34)) | (1L << (Access - 34)))) != 0) );
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
			setState(317); match(MONITORABLEPROPERTIES);
			setState(319);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(318); match(Identifier);
				}
			}

			setState(322);
			_la = _input.LA(1);
			if (_la==GLOBAL) {
				{
				setState(321); global_MonitorableProperties();
				}
			}

			setState(327);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FOR) {
				{
				{
				setState(324); local_MonitorableProperties();
				}
				}
				setState(329);
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
			setState(330); match(GLOBAL);
			setState(331); match(2);
			setState(335);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 34)) & ~0x3f) == 0 && ((1L << (_la - 34)) & ((1L << (BOOLEAN - 34)) | (1L << (INTEGER - 34)) | (1L << (Identifier - 34)) | (1L << (Access - 34)))) != 0)) {
				{
				{
				setState(332); key_value_prop();
				}
				}
				setState(337);
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

	public static class Local_MonitorablePropertiesContext extends ParserRuleContext {
		public Key_value_propContext key_value_prop(int i) {
			return getRuleContext(Key_value_propContext.class,i);
		}
		public TerminalNode FOR() { return getToken(iAgreeParser.FOR, 0); }
		public List<Key_value_propContext> key_value_prop() {
			return getRuleContexts(Key_value_propContext.class);
		}
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
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
			setState(338); match(FOR);
			setState(339); match(Identifier);
			setState(340); match(2);
			setState(342); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(341); key_value_prop();
				}
				}
				setState(344); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 34)) & ~0x3f) == 0 && ((1L << (_la - 34)) & ((1L << (BOOLEAN - 34)) | (1L << (INTEGER - 34)) | (1L << (Identifier - 34)) | (1L << (Access - 34)))) != 0) );
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
			setState(346); match(GUARANTEE_TERMS);
			setState(350);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Identifier) {
				{
				{
				setState(347); guaranteeTerm();
				}
				}
				setState(352);
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
		public TerminalNode END() { return getToken(iAgreeParser.END, 0); }
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
			setState(353); match(Identifier);
			setState(354); match(2);
			setState(360);
			switch (_input.LA(1)) {
			case PROVIDER:
			case CONSUMER:
				{
				setState(355); guarantee_def();
				}
				break;
			case EXACTLY_ONE:
			case ONE_OR_MORE:
			case ALL:
				{
				setState(356); cuantif();
				setState(357); match(OF);
				setState(358); grouped_guaranteeTerm();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(363);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(362); match(END);
				}
				break;
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
			setState(366); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(365); guaranteeTerm();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(368); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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
		public List<CompensationsContext> compensations() {
			return getRuleContexts(CompensationsContext.class);
		}
		public TerminalNode CONSUMER() { return getToken(iAgreeParser.CONSUMER, 0); }
		public TerminalNode PROVIDER() { return getToken(iAgreeParser.PROVIDER, 0); }
		public SloContext slo() {
			return getRuleContext(SloContext.class,0);
		}
		public CompensationsContext compensations(int i) {
			return getRuleContext(CompensationsContext.class,i);
		}
		public TerminalNode GUARANTEES() { return getToken(iAgreeParser.GUARANTEES, 0); }
		public QualifyingConditionContext qualifyingCondition() {
			return getRuleContext(QualifyingConditionContext.class,0);
		}
		public ServiceScopeContext serviceScope() {
			return getRuleContext(ServiceScopeContext.class,0);
		}
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
			setState(370);
			((Guarantee_defContext)_localctx).ob = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==PROVIDER || _la==CONSUMER) ) {
				((Guarantee_defContext)_localctx).ob = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(371); match(GUARANTEES);
			setState(372); slo();
			setState(374);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(373); temporality();
				}
			}

			setState(376); match(3);
			setState(378);
			_la = _input.LA(1);
			if (_la==UPON) {
				{
				setState(377); serviceScope();
				}
			}

			setState(381);
			_la = _input.LA(1);
			if (_la==ONLY_IF) {
				{
				setState(380); qualifyingCondition();
				}
			}

			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WITH) {
				{
				{
				setState(383); compensations();
				}
				}
				setState(388);
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

	public static class SloContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterSlo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitSlo(this);
		}
	}

	public final SloContext slo() throws RecognitionException {
		SloContext _localctx = new SloContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_slo);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389); expression();
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

	public static class ServiceScopeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TerminalNode UPON() { return getToken(iAgreeParser.UPON, 0); }
		public ServiceScopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_serviceScope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterServiceScope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitServiceScope(this);
		}
	}

	public final ServiceScopeContext serviceScope() throws RecognitionException {
		ServiceScopeContext _localctx = new ServiceScopeContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_serviceScope);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(391); match(UPON);
			setState(392); match(Identifier);
			setState(393); match(3);
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

	public static class QualifyingConditionContext extends ParserRuleContext {
		public TerminalNode ONLY_IF() { return getToken(iAgreeParser.ONLY_IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public QualifyingConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifyingCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterQualifyingCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitQualifyingCondition(this);
		}
	}

	public final QualifyingConditionContext qualifyingCondition() throws RecognitionException {
		QualifyingConditionContext _localctx = new QualifyingConditionContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_qualifyingCondition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(395); match(ONLY_IF);
			setState(396); match(PA);
			setState(397); expression();
			setState(398); match(PC);
			setState(399); match(3);
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

	public static class CompensationsContext extends ParserRuleContext {
		public CompensationsIntervalContext interv;
		public Token compType;
		public CompensationsIntervalContext compensationsInterval() {
			return getRuleContext(CompensationsIntervalContext.class,0);
		}
		public TerminalNode PENALTY() { return getToken(iAgreeParser.PENALTY, 0); }
		public TerminalNode WITH() { return getToken(iAgreeParser.WITH, 0); }
		public List<CompensationContext> compensation() {
			return getRuleContexts(CompensationContext.class);
		}
		public CompensationContext compensation(int i) {
			return getRuleContext(CompensationContext.class,i);
		}
		public TerminalNode REWARD() { return getToken(iAgreeParser.REWARD, 0); }
		public TerminalNode END() { return getToken(iAgreeParser.END, 0); }
		public CompensationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compensations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterCompensations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitCompensations(this);
		}
	}

	public final CompensationsContext compensations() throws RecognitionException {
		CompensationsContext _localctx = new CompensationsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_compensations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401); match(WITH);
			setState(402); ((CompensationsContext)_localctx).interv = compensationsInterval();
			setState(403);
			((CompensationsContext)_localctx).compType = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==PENALTY || _la==REWARD) ) {
				((CompensationsContext)_localctx).compType = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(405); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(404); compensation();
				}
				}
				setState(407); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==OF );
			setState(409); match(END);
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

	public static class CompensationsIntervalContext extends ParserRuleContext {
		public TerminalNode MONTHLY() { return getToken(iAgreeParser.MONTHLY, 0); }
		public TerminalNode DAILY() { return getToken(iAgreeParser.DAILY, 0); }
		public TerminalNode MINUTELY() { return getToken(iAgreeParser.MINUTELY, 0); }
		public TerminalNode HOURLY() { return getToken(iAgreeParser.HOURLY, 0); }
		public TerminalNode WEEKLY() { return getToken(iAgreeParser.WEEKLY, 0); }
		public TerminalNode YEARLY() { return getToken(iAgreeParser.YEARLY, 0); }
		public CompensationsIntervalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compensationsInterval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterCompensationsInterval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitCompensationsInterval(this);
		}
	}

	public final CompensationsIntervalContext compensationsInterval() throws RecognitionException {
		CompensationsIntervalContext _localctx = new CompensationsIntervalContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_compensationsInterval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << YEARLY) | (1L << MONTHLY) | (1L << WEEKLY) | (1L << DAILY) | (1L << HOURLY) | (1L << MINUTELY))) != 0)) ) {
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

	public static class CompensationContext extends ParserRuleContext {
		public ExpressionContext e1;
		public ExpressionContext e2;
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode IF() { return getToken(iAgreeParser.IF, 0); }
		public TerminalNode OF() { return getToken(iAgreeParser.OF, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public CompensationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compensation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterCompensation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitCompensation(this);
		}
	}

	public final CompensationContext compensation() throws RecognitionException {
		CompensationContext _localctx = new CompensationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_compensation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413); match(OF);
			setState(414); ((CompensationContext)_localctx).e1 = expression();
			setState(415); match(IF);
			setState(416); ((CompensationContext)_localctx).e2 = expression();
			setState(417); match(3);
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
		enterRule(_localctx, 86, RULE_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419); match(Identifier);
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
		enterRule(_localctx, 88, RULE_versionNumber);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
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
		enterRule(_localctx, 90, RULE_url);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(423);
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
		public TerminalNode BOOLEAN() { return getToken(iAgreeParser.BOOLEAN, 0); }
		public Assig_valueContext assig_value() {
			return getRuleContext(Assig_valueContext.class,0);
		}
		public TerminalNode Access() { return getToken(iAgreeParser.Access, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode INTEGER() { return getToken(iAgreeParser.INTEGER, 0); }
		public TerminalNode EQ() { return getToken(iAgreeParser.EQ, 0); }
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
		enterRule(_localctx, 92, RULE_key_value_prop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			((Key_value_propContext)_localctx).k = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 34)) & ~0x3f) == 0 && ((1L << (_la - 34)) & ((1L << (BOOLEAN - 34)) | (1L << (INTEGER - 34)) | (1L << (Identifier - 34)) | (1L << (Access - 34)))) != 0)) ) {
				((Key_value_propContext)_localctx).k = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(426); match(2);
			setState(429);
			switch (_input.LA(1)) {
			case String:
				{
				setState(427); ((Key_value_propContext)_localctx).v = match(String);
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
				setState(428); ((Key_value_propContext)_localctx).v2 = type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(435);
			_la = _input.LA(1);
			if (_la==EQ) {
				{
				setState(431); match(EQ);
				setState(432); ((Key_value_propContext)_localctx).a = assig_value();
				setState(433); match(3);
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
		enterRule(_localctx, 94, RULE_assig_value);
		int _la;
		try {
			setState(468);
			switch (_input.LA(1)) {
			case Identifier:
			case Integer:
			case String:
				enterOuterAlt(_localctx, 1);
				{
				setState(438); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(437);
					((Assig_valueContext)_localctx).val = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (Identifier - 80)) | (1L << (Integer - 80)) | (1L << (String - 80)))) != 0)) ) {
						((Assig_valueContext)_localctx).val = (Token)_errHandler.recoverInline(this);
					}
					consume();
					}
					}
					setState(440); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (Identifier - 80)) | (1L << (Integer - 80)) | (1L << (String - 80)))) != 0) );
				setState(443);
				_la = _input.LA(1);
				if (_la==Operador) {
					{
					setState(442); operation();
					}
				}

				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(445);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				break;
			case Float:
				enterOuterAlt(_localctx, 3);
				{
				setState(446); match(Float);
				setState(448);
				_la = _input.LA(1);
				if (_la==Unit) {
					{
					setState(447); match(Unit);
					}
				}

				setState(451);
				_la = _input.LA(1);
				if (_la==Operador) {
					{
					setState(450); operation();
					}
				}

				}
				break;
			case S_Float:
				enterOuterAlt(_localctx, 4);
				{
				setState(453); match(S_Float);
				setState(455);
				_la = _input.LA(1);
				if (_la==Unit) {
					{
					setState(454); match(Unit);
					}
				}

				setState(458);
				_la = _input.LA(1);
				if (_la==Operador) {
					{
					setState(457); operation();
					}
				}

				}
				break;
			case S_Integer:
				enterOuterAlt(_localctx, 5);
				{
				setState(460); match(S_Integer);
				setState(462);
				_la = _input.LA(1);
				if (_la==Unit) {
					{
					setState(461); match(Unit);
					}
				}

				setState(465);
				_la = _input.LA(1);
				if (_la==Operador) {
					{
					setState(464); operation();
					}
				}

				}
				break;
			case LLA:
				enterOuterAlt(_localctx, 6);
				{
				setState(467); list();
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
		enterRule(_localctx, 96, RULE_operation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(470); match(Operador);
			setState(471); assig_value();
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
		public TerminalNode String() { return getToken(iAgreeParser.String, 0); }
		public TerminalNode GTE() { return getToken(iAgreeParser.GTE, 0); }
		public TerminalNode BELONGS() { return getToken(iAgreeParser.BELONGS, 0); }
		public Assig_valueContext assig_value() {
			return getRuleContext(Assig_valueContext.class,0);
		}
		public TerminalNode AND() { return getToken(iAgreeParser.AND, 0); }
		public TerminalNode LTE() { return getToken(iAgreeParser.LTE, 0); }
		public TerminalNode OR() { return getToken(iAgreeParser.OR, 0); }
		public TerminalNode Identifier() { return getToken(iAgreeParser.Identifier, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public TerminalNode EQ() { return getToken(iAgreeParser.EQ, 0); }
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public TerminalNode LT() { return getToken(iAgreeParser.LT, 0); }
		public TerminalNode NOT() { return getToken(iAgreeParser.NOT, 0); }
		public TerminalNode Access() { return getToken(iAgreeParser.Access, 0); }
		public TerminalNode GT() { return getToken(iAgreeParser.GT, 0); }
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
		enterRule(_localctx, 98, RULE_expression);
		int _la;
		try {
			setState(498);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(473); match(NOT);
				setState(474); ((ExpressionContext)_localctx).e1 = expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(475); match(PA);
				setState(476); ((ExpressionContext)_localctx).e1 = expression();
				setState(477); match(PC);
				setState(480);
				_la = _input.LA(1);
				if (((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (AND - 65)) | (1L << (OR - 65)) | (1L << (IMPLIES - 65)))) != 0)) {
					{
					setState(478);
					((ExpressionContext)_localctx).log = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (AND - 65)) | (1L << (OR - 65)) | (1L << (IMPLIES - 65)))) != 0)) ) {
						((ExpressionContext)_localctx).log = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(479); ((ExpressionContext)_localctx).e2 = expression();
					}
				}

				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(482);
				((ExpressionContext)_localctx).ident = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (Identifier - 80)) | (1L << (Access - 80)) | (1L << (String - 80)))) != 0)) ) {
					((ExpressionContext)_localctx).ident = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(485);
				_la = _input.LA(1);
				if (((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LT - 73)) | (1L << (GT - 73)) | (1L << (EQ - 73)) | (1L << (LTE - 73)) | (1L << (GTE - 73)))) != 0)) {
					{
					setState(483);
					((ExpressionContext)_localctx).cmp = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & ((1L << (LT - 73)) | (1L << (GT - 73)) | (1L << (EQ - 73)) | (1L << (LTE - 73)) | (1L << (GTE - 73)))) != 0)) ) {
						((ExpressionContext)_localctx).cmp = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(484); ((ExpressionContext)_localctx).val = assig_value();
					}
				}

				setState(489);
				_la = _input.LA(1);
				if (((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (AND - 65)) | (1L << (OR - 65)) | (1L << (IMPLIES - 65)))) != 0)) {
					{
					setState(487);
					((ExpressionContext)_localctx).log = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (AND - 65)) | (1L << (OR - 65)) | (1L << (IMPLIES - 65)))) != 0)) ) {
						((ExpressionContext)_localctx).log = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(488); ((ExpressionContext)_localctx).e1 = expression();
					}
				}

				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(491);
				((ExpressionContext)_localctx).ident = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==Identifier || _la==Access) ) {
					((ExpressionContext)_localctx).ident = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(492); match(BELONGS);
				setState(493); ((ExpressionContext)_localctx).l = list();
				setState(496);
				_la = _input.LA(1);
				if (((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (AND - 65)) | (1L << (OR - 65)) | (1L << (IMPLIES - 65)))) != 0)) {
					{
					setState(494);
					((ExpressionContext)_localctx).log = _input.LT(1);
					_la = _input.LA(1);
					if ( !(((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & ((1L << (AND - 65)) | (1L << (OR - 65)) | (1L << (IMPLIES - 65)))) != 0)) ) {
						((ExpressionContext)_localctx).log = (Token)_errHandler.recoverInline(this);
					}
					consume();
					setState(495); ((ExpressionContext)_localctx).e1 = expression();
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
		public TerminalNode Identifier(int i) {
			return getToken(iAgreeParser.Identifier, i);
		}
		public List<TerminalNode> Identifier() { return getTokens(iAgreeParser.Identifier); }
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
		enterRule(_localctx, 100, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500); match(Identifier);
			setState(511);
			_la = _input.LA(1);
			if (_la==PA) {
				{
				setState(501); match(PA);
				setState(502); match(Identifier);
				setState(507);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==1) {
					{
					{
					setState(503); match(1);
					setState(504); match(Identifier);
					}
					}
					setState(509);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(510); match(PC);
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
		enterRule(_localctx, 102, RULE_cuantif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(513);
			_la = _input.LA(1);
			if ( !(((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & ((1L << (EXACTLY_ONE - 70)) | (1L << (ONE_OR_MORE - 70)) | (1L << (ALL - 70)))) != 0)) ) {
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
		enterRule(_localctx, 104, RULE_type);
		int _la;
		try {
			setState(524);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(515); match(Identifier);
				}
				break;
			case SET:
				enterOuterAlt(_localctx, 2);
				{
				setState(516); match(SET);
				setState(517); list();
				}
				break;
			case ENUM:
				enterOuterAlt(_localctx, 3);
				{
				setState(518); match(ENUM);
				setState(519); list();
				}
				break;
			case BOOLEAN:
			case INTEGER:
			case FLOAT:
			case NATURAL:
			case NUMBER:
				enterOuterAlt(_localctx, 4);
				{
				setState(520);
				((TypeContext)_localctx).v = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOLEAN) | (1L << INTEGER) | (1L << FLOAT) | (1L << NATURAL) | (1L << NUMBER))) != 0)) ) {
					((TypeContext)_localctx).v = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(522);
				_la = _input.LA(1);
				if (_la==CA) {
					{
					setState(521); range();
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
		public List<ListArgContext> listArg() {
			return getRuleContexts(ListArgContext.class);
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
		enterRule(_localctx, 106, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(526); match(LLA);
			setState(527); ((ListContext)_localctx).l1 = listArg();
			setState(532);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==1) {
				{
				{
				setState(528); match(1);
				setState(529); ((ListContext)_localctx).l2 = listArg();
				}
				}
				setState(534);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(535); match(LLC);
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
		enterRule(_localctx, 108, RULE_listArg);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			((ListArgContext)_localctx).l1 = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((((_la - 80)) & ~0x3f) == 0 && ((1L << (_la - 80)) & ((1L << (Identifier - 80)) | (1L << (Integer - 80)) | (1L << (S_Integer - 80)) | (1L << (Float - 80)) | (1L << (S_Float - 80)) | (1L << (String - 80)))) != 0)) ) {
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
		enterRule(_localctx, 110, RULE_range);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539); match(CA);
			setState(540);
			((RangeContext)_localctx).min = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==S_Integer) ) {
				((RangeContext)_localctx).min = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(541); match(4);
			setState(542);
			((RangeContext)_localctx).max = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==Integer || _la==S_Integer) ) {
				((RangeContext)_localctx).max = (Token)_errHandler.recoverInline(this);
			}
			consume();
			setState(543); match(CC);
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3b\u0224\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\5\2y\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\5\7\5\u008c\n\5\f\5\16\5\u008f\13\5\3\5\3\5\5\5\u0093\n\5\3\6\7"+
		"\6\u0096\n\6\f\6\16\6\u0099\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\5\7\u00a6\n\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\6\13"+
		"\u00b3\n\13\r\13\16\13\u00b4\3\f\3\f\3\f\3\f\3\f\5\f\u00bc\n\f\3\r\3\r"+
		"\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\6\24\u00dd\n\24\r\24\16\24\u00de\3\25\3\25\3\25\6\25\u00e4\n\25\r"+
		"\25\16\25\u00e5\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\7\30\u00f5\n\30\f\30\16\30\u00f8\13\30\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\5\31\u0100\n\31\3\31\3\31\3\31\5\31\u0105\n\31\3\32\3\32\3"+
		"\32\3\32\5\32\u010b\n\32\3\32\5\32\u010e\n\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\7\33\u0118\n\33\f\33\16\33\u011b\13\33\3\34\3\34\6\34"+
		"\u011f\n\34\r\34\16\34\u0120\3\35\7\35\u0124\n\35\f\35\16\35\u0127\13"+
		"\35\3\36\3\36\3\36\7\36\u012c\n\36\f\36\16\36\u012f\13\36\3\37\3\37\3"+
		"\37\3\37\3\37\7\37\u0136\n\37\f\37\16\37\u0139\13\37\3\37\6\37\u013c\n"+
		"\37\r\37\16\37\u013d\3 \3 \5 \u0142\n \3 \5 \u0145\n \3 \7 \u0148\n \f"+
		" \16 \u014b\13 \3!\3!\3!\7!\u0150\n!\f!\16!\u0153\13!\3\"\3\"\3\"\3\""+
		"\6\"\u0159\n\"\r\"\16\"\u015a\3#\3#\7#\u015f\n#\f#\16#\u0162\13#\3$\3"+
		"$\3$\3$\3$\3$\3$\5$\u016b\n$\3$\5$\u016e\n$\3%\6%\u0171\n%\r%\16%\u0172"+
		"\3&\3&\3&\3&\5&\u0179\n&\3&\3&\5&\u017d\n&\3&\5&\u0180\n&\3&\7&\u0183"+
		"\n&\f&\16&\u0186\13&\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3*\3*\3*\3"+
		"*\6*\u0198\n*\r*\16*\u0199\3*\3*\3+\3+\3,\3,\3,\3,\3,\3,\3-\3-\3.\3.\3"+
		"/\3/\3\60\3\60\3\60\3\60\5\60\u01b0\n\60\3\60\3\60\3\60\3\60\5\60\u01b6"+
		"\n\60\3\61\6\61\u01b9\n\61\r\61\16\61\u01ba\3\61\5\61\u01be\n\61\3\61"+
		"\3\61\3\61\5\61\u01c3\n\61\3\61\5\61\u01c6\n\61\3\61\3\61\5\61\u01ca\n"+
		"\61\3\61\5\61\u01cd\n\61\3\61\3\61\5\61\u01d1\n\61\3\61\5\61\u01d4\n\61"+
		"\3\61\5\61\u01d7\n\61\3\62\3\62\3\62\3\63\3\63\3\63\3\63\3\63\3\63\3\63"+
		"\5\63\u01e3\n\63\3\63\3\63\3\63\5\63\u01e8\n\63\3\63\3\63\5\63\u01ec\n"+
		"\63\3\63\3\63\3\63\3\63\3\63\5\63\u01f3\n\63\5\63\u01f5\n\63\3\64\3\64"+
		"\3\64\3\64\3\64\7\64\u01fc\n\64\f\64\16\64\u01ff\13\64\3\64\5\64\u0202"+
		"\n\64\3\65\3\65\3\66\3\66\3\66\3\66\3\66\3\66\3\66\5\66\u020d\n\66\5\66"+
		"\u020f\n\66\3\67\3\67\3\67\3\67\7\67\u0215\n\67\f\67\16\67\u0218\13\67"+
		"\3\67\3\67\38\38\39\39\39\39\39\39\39\2:\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnp\2\24\4\2"+
		"\37 RR\3\2ST\4\2\"\"CC\3\2\37 \3\2\66\67\3\2\60\65\4\2UUYY\4\2XX__\5\2"+
		"$%RR\\\\\4\2RS__\3\2+,\4\2CDFF\5\2RR\\\\__\3\2KO\4\2RR\\\\\3\2HJ\3\2$"+
		"(\4\2RV__\u0232\2x\3\2\2\2\4z\3\2\2\2\6\u0080\3\2\2\2\b\u008d\3\2\2\2"+
		"\n\u0097\3\2\2\2\f\u00a5\3\2\2\2\16\u00a7\3\2\2\2\20\u00aa\3\2\2\2\22"+
		"\u00ad\3\2\2\2\24\u00b2\3\2\2\2\26\u00b6\3\2\2\2\30\u00bd\3\2\2\2\32\u00c1"+
		"\3\2\2\2\34\u00c5\3\2\2\2\36\u00c9\3\2\2\2 \u00cd\3\2\2\2\"\u00d1\3\2"+
		"\2\2$\u00d5\3\2\2\2&\u00d9\3\2\2\2(\u00e0\3\2\2\2*\u00e7\3\2\2\2,\u00ec"+
		"\3\2\2\2.\u00ef\3\2\2\2\60\u0104\3\2\2\2\62\u0106\3\2\2\2\64\u0112\3\2"+
		"\2\2\66\u011c\3\2\2\28\u0125\3\2\2\2:\u0128\3\2\2\2<\u0130\3\2\2\2>\u013f"+
		"\3\2\2\2@\u014c\3\2\2\2B\u0154\3\2\2\2D\u015c\3\2\2\2F\u0163\3\2\2\2H"+
		"\u0170\3\2\2\2J\u0174\3\2\2\2L\u0187\3\2\2\2N\u0189\3\2\2\2P\u018d\3\2"+
		"\2\2R\u0193\3\2\2\2T\u019d\3\2\2\2V\u019f\3\2\2\2X\u01a5\3\2\2\2Z\u01a7"+
		"\3\2\2\2\\\u01a9\3\2\2\2^\u01ab\3\2\2\2`\u01d6\3\2\2\2b\u01d8\3\2\2\2"+
		"d\u01f4\3\2\2\2f\u01f6\3\2\2\2h\u0203\3\2\2\2j\u020e\3\2\2\2l\u0210\3"+
		"\2\2\2n\u021b\3\2\2\2p\u021d\3\2\2\2rs\5\4\3\2st\7\b\2\2ty\3\2\2\2uv\5"+
		"\6\4\2vw\7\n\2\2wy\3\2\2\2xr\3\2\2\2xu\3\2\2\2y\3\3\2\2\2z{\7\7\2\2{|"+
		"\7R\2\2|}\7!\2\2}~\5Z.\2~\177\5\b\5\2\177\5\3\2\2\2\u0080\u0081\7\t\2"+
		"\2\u0081\u0082\7R\2\2\u0082\u0083\7!\2\2\u0083\u0084\5Z.\2\u0084\u0085"+
		"\7;\2\2\u0085\u0086\7R\2\2\u0086\u0087\7!\2\2\u0087\u0088\5Z.\2\u0088"+
		"\u0089\5\n\6\2\u0089\7\3\2\2\2\u008a\u008c\5\f\7\2\u008b\u008a\3\2\2\2"+
		"\u008c\u008f\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u0090"+
		"\3\2\2\2\u008f\u008d\3\2\2\2\u0090\u0092\5\16\b\2\u0091\u0093\5\20\t\2"+
		"\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\t\3\2\2\2\u0094\u0096\5"+
		"\f\7\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u009b\5\16"+
		"\b\2\u009b\13\3\2\2\2\u009c\u00a6\5\30\r\2\u009d\u00a6\5\32\16\2\u009e"+
		"\u00a6\5\34\17\2\u009f\u00a6\5\36\20\2\u00a0\u00a6\5 \21\2\u00a1\u00a6"+
		"\5\"\22\2\u00a2\u00a6\5$\23\2\u00a3\u00a6\5&\24\2\u00a4\u00a6\5(\25\2"+
		"\u00a5\u009c\3\2\2\2\u00a5\u009d\3\2\2\2\u00a5\u009e\3\2\2\2\u00a5\u009f"+
		"\3\2\2\2\u00a5\u00a0\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a5\u00a2\3\2\2\2\u00a5"+
		"\u00a3\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6\r\3\2\2\2\u00a7\u00a8\7\24\2"+
		"\2\u00a8\u00a9\5\22\n\2\u00a9\17\3\2\2\2\u00aa\u00ab\7\25\2\2\u00ab\u00ac"+
		"\5\24\13\2\u00ac\21\3\2\2\2\u00ad\u00ae\5\62\32\2\u00ae\u00af\5> \2\u00af"+
		"\u00b0\5D#\2\u00b0\23\3\2\2\2\u00b1\u00b3\5\26\f\2\u00b2\u00b1\3\2\2\2"+
		"\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5\25"+
		"\3\2\2\2\u00b6\u00b7\7R\2\2\u00b7\u00b8\7\4\2\2\u00b8\u00b9\5d\63\2\u00b9"+
		"\u00bb\7\5\2\2\u00ba\u00bc\5P)\2\u00bb\u00ba\3\2\2\2\u00bb\u00bc\3\2\2"+
		"\2\u00bc\27\3\2\2\2\u00bd\u00be\7\13\2\2\u00be\u00bf\7\4\2\2\u00bf\u00c0"+
		"\7_\2\2\u00c0\31\3\2\2\2\u00c1\u00c2\t\2\2\2\u00c2\u00c3\7<\2\2\u00c3"+
		"\u00c4\7\f\2\2\u00c4\33\3\2\2\2\u00c5\u00c6\7\r\2\2\u00c6\u00c7\7\4\2"+
		"\2\u00c7\u00c8\7_\2\2\u00c8\35\3\2\2\2\u00c9\u00ca\7\16\2\2\u00ca\u00cb"+
		"\7\4\2\2\u00cb\u00cc\7_\2\2\u00cc\37\3\2\2\2\u00cd\u00ce\7\17\2\2\u00ce"+
		"\u00cf\7\4\2\2\u00cf\u00d0\7_\2\2\u00d0!\3\2\2\2\u00d1\u00d2\7\20\2\2"+
		"\u00d2\u00d3\7\4\2\2\u00d3\u00d4\t\3\2\2\u00d4#\3\2\2\2\u00d5\u00d6\7"+
		"\21\2\2\u00d6\u00d7\7\4\2\2\u00d7\u00d8\5*\26\2\u00d8%\3\2\2\2\u00d9\u00da"+
		"\7\22\2\2\u00da\u00dc\7\4\2\2\u00db\u00dd\5.\30\2\u00dc\u00db\3\2\2\2"+
		"\u00dd\u00de\3\2\2\2\u00de\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\'\3"+
		"\2\2\2\u00e0\u00e1\7\23\2\2\u00e1\u00e3\7\4\2\2\u00e2\u00e4\5^\60\2\u00e3"+
		"\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2"+
		"\2\2\u00e6)\3\2\2\2\u00e7\u00e8\7#\2\2\u00e8\u00e9\7Z\2\2\u00e9\u00ea"+
		"\7\6\2\2\u00ea\u00eb\7Z\2\2\u00eb+\3\2\2\2\u00ec\u00ed\78\2\2\u00ed\u00ee"+
		"\7R\2\2\u00ee-\3\2\2\2\u00ef\u00f0\7R\2\2\u00f0\u00f1\7\4\2\2\u00f1\u00f6"+
		"\5\60\31\2\u00f2\u00f3\t\4\2\2\u00f3\u00f5\5\60\31\2\u00f4\u00f2\3\2\2"+
		"\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7/"+
		"\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fa\79\2\2\u00fa\u00fb\7[\2\2\u00fb"+
		"\u00fc\7\6\2\2\u00fc\u00ff\7[\2\2\u00fd\u00fe\78\2\2\u00fe\u0100\7R\2"+
		"\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101\3\2\2\2\u0101\u0105"+
		"\5*\26\2\u0102\u0105\5X-\2\u0103\u0105\7\21\2\2\u0104\u00f9\3\2\2\2\u0104"+
		"\u0102\3\2\2\2\u0104\u0103\3\2\2\2\u0105\61\3\2\2\2\u0106\u0107\7\27\2"+
		"\2\u0107\u010a\7R\2\2\u0108\u0109\7\36\2\2\u0109\u010b\5\\/\2\u010a\u0108"+
		"\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010d\3\2\2\2\u010c\u010e\5\64\33\2"+
		"\u010d\u010c\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u010f\3\2\2\2\u010f\u0110"+
		"\5\66\34\2\u0110\u0111\58\35\2\u0111\63\3\2\2\2\u0112\u0113\7\30\2\2\u0113"+
		"\u0114\7\4\2\2\u0114\u0119\5:\36\2\u0115\u0116\7\3\2\2\u0116\u0118\5:"+
		"\36\2\u0117\u0115\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u011a\65\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u011e\7\31\2"+
		"\2\u011d\u011f\5^\60\2\u011e\u011d\3\2\2\2\u011f\u0120\3\2\2\2\u0120\u011e"+
		"\3\2\2\2\u0120\u0121\3\2\2\2\u0121\67\3\2\2\2\u0122\u0124\5<\37\2\u0123"+
		"\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2"+
		"\2\2\u01269\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u012d\5f\64\2\u0129\u012a"+
		"\7\3\2\2\u012a\u012c\5f\64\2\u012b\u0129\3\2\2\2\u012c\u012f\3\2\2\2\u012d"+
		"\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e;\3\2\2\2\u012f\u012d\3\2\2\2"+
		"\u0130\u0131\7\32\2\2\u0131\u0132\7;\2\2\u0132\u0137\5:\36\2\u0133\u0134"+
		"\7\3\2\2\u0134\u0136\5:\36\2\u0135\u0133\3\2\2\2\u0136\u0139\3\2\2\2\u0137"+
		"\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2"+
		"\2\2\u013a\u013c\5^\60\2\u013b\u013a\3\2\2\2\u013c\u013d\3\2\2\2\u013d"+
		"\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013e=\3\2\2\2\u013f\u0141\7\34\2\2"+
		"\u0140\u0142\7R\2\2\u0141\u0140\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0144"+
		"\3\2\2\2\u0143\u0145\5@!\2\u0144\u0143\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\u0149\3\2\2\2\u0146\u0148\5B\"\2\u0147\u0146\3\2\2\2\u0148\u014b\3\2"+
		"\2\2\u0149\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014a?\3\2\2\2\u014b\u0149"+
		"\3\2\2\2\u014c\u014d\7\33\2\2\u014d\u0151\7\4\2\2\u014e\u0150\5^\60\2"+
		"\u014f\u014e\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0151\u0152"+
		"\3\2\2\2\u0152A\3\2\2\2\u0153\u0151\3\2\2\2\u0154\u0155\7;\2\2\u0155\u0156"+
		"\7R\2\2\u0156\u0158\7\4\2\2\u0157\u0159\5^\60\2\u0158\u0157\3\2\2\2\u0159"+
		"\u015a\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015bC\3\2\2\2"+
		"\u015c\u0160\7\26\2\2\u015d\u015f\5F$\2\u015e\u015d\3\2\2\2\u015f\u0162"+
		"\3\2\2\2\u0160\u015e\3\2\2\2\u0160\u0161\3\2\2\2\u0161E\3\2\2\2\u0162"+
		"\u0160\3\2\2\2\u0163\u0164\7R\2\2\u0164\u016a\7\4\2\2\u0165\u016b\5J&"+
		"\2\u0166\u0167\5h\65\2\u0167\u0168\7:\2\2\u0168\u0169\5H%\2\u0169\u016b"+
		"\3\2\2\2\u016a\u0165\3\2\2\2\u016a\u0166\3\2\2\2\u016b\u016d\3\2\2\2\u016c"+
		"\u016e\7.\2\2\u016d\u016c\3\2\2\2\u016d\u016e\3\2\2\2\u016eG\3\2\2\2\u016f"+
		"\u0171\5F$\2\u0170\u016f\3\2\2\2\u0171\u0172\3\2\2\2\u0172\u0170\3\2\2"+
		"\2\u0172\u0173\3\2\2\2\u0173I\3\2\2\2\u0174\u0175\t\5\2\2\u0175\u0176"+
		"\7\35\2\2\u0176\u0178\5L\'\2\u0177\u0179\5,\27\2\u0178\u0177\3\2\2\2\u0178"+
		"\u0179\3\2\2\2\u0179\u017a\3\2\2\2\u017a\u017c\7\5\2\2\u017b\u017d\5N"+
		"(\2\u017c\u017b\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017f\3\2\2\2\u017e"+
		"\u0180\5P)\2\u017f\u017e\3\2\2\2\u017f\u0180\3\2\2\2\u0180\u0184\3\2\2"+
		"\2\u0181\u0183\5R*\2\u0182\u0181\3\2\2\2\u0183\u0186\3\2\2\2\u0184\u0182"+
		"\3\2\2\2\u0184\u0185\3\2\2\2\u0185K\3\2\2\2\u0186\u0184\3\2\2\2\u0187"+
		"\u0188\5d\63\2\u0188M\3\2\2\2\u0189\u018a\7Q\2\2\u018a\u018b\7R\2\2\u018b"+
		"\u018c\7\5\2\2\u018cO\3\2\2\2\u018d\u018e\7G\2\2\u018e\u018f\7?\2\2\u018f"+
		"\u0190\5d\63\2\u0190\u0191\7@\2\2\u0191\u0192\7\5\2\2\u0192Q\3\2\2\2\u0193"+
		"\u0194\7-\2\2\u0194\u0195\5T+\2\u0195\u0197\t\6\2\2\u0196\u0198\5V,\2"+
		"\u0197\u0196\3\2\2\2\u0198\u0199\3\2\2\2\u0199\u0197\3\2\2\2\u0199\u019a"+
		"\3\2\2\2\u019a\u019b\3\2\2\2\u019b\u019c\7.\2\2\u019cS\3\2\2\2\u019d\u019e"+
		"\t\7\2\2\u019eU\3\2\2\2\u019f\u01a0\7:\2\2\u01a0\u01a1\5d\63\2\u01a1\u01a2"+
		"\7/\2\2\u01a2\u01a3\5d\63\2\u01a3\u01a4\7\5\2\2\u01a4W\3\2\2\2\u01a5\u01a6"+
		"\7R\2\2\u01a6Y\3\2\2\2\u01a7\u01a8\t\b\2\2\u01a8[\3\2\2\2\u01a9\u01aa"+
		"\t\t\2\2\u01aa]\3\2\2\2\u01ab\u01ac\t\n\2\2\u01ac\u01af\7\4\2\2\u01ad"+
		"\u01b0\7_\2\2\u01ae\u01b0\5j\66\2\u01af\u01ad\3\2\2\2\u01af\u01ae\3\2"+
		"\2\2\u01b0\u01b5\3\2\2\2\u01b1\u01b2\7M\2\2\u01b2\u01b3\5`\61\2\u01b3"+
		"\u01b4\7\5\2\2\u01b4\u01b6\3\2\2\2\u01b5\u01b1\3\2\2\2\u01b5\u01b6\3\2"+
		"\2\2\u01b6_\3\2\2\2\u01b7\u01b9\t\13\2\2\u01b8\u01b7\3\2\2\2\u01b9\u01ba"+
		"\3\2\2\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01bd\3\2\2\2\u01bc"+
		"\u01be\5b\62\2\u01bd\u01bc\3\2\2\2\u01bd\u01be\3\2\2\2\u01be\u01d7\3\2"+
		"\2\2\u01bf\u01d7\t\f\2\2\u01c0\u01c2\7U\2\2\u01c1\u01c3\7]\2\2\u01c2\u01c1"+
		"\3\2\2\2\u01c2\u01c3\3\2\2\2\u01c3\u01c5\3\2\2\2\u01c4\u01c6\5b\62\2\u01c5"+
		"\u01c4\3\2\2\2\u01c5\u01c6\3\2\2\2\u01c6\u01d7\3\2\2\2\u01c7\u01c9\7V"+
		"\2\2\u01c8\u01ca\7]\2\2\u01c9\u01c8\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca"+
		"\u01cc\3\2\2\2\u01cb\u01cd\5b\62\2\u01cc\u01cb\3\2\2\2\u01cc\u01cd\3\2"+
		"\2\2\u01cd\u01d7\3\2\2\2\u01ce\u01d0\7T\2\2\u01cf\u01d1\7]\2\2\u01d0\u01cf"+
		"\3\2\2\2\u01d0\u01d1\3\2\2\2\u01d1\u01d3\3\2\2\2\u01d2\u01d4\5b\62\2\u01d3"+
		"\u01d2\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4\u01d7\3\2\2\2\u01d5\u01d7\5l"+
		"\67\2\u01d6\u01b8\3\2\2\2\u01d6\u01bf\3\2\2\2\u01d6\u01c0\3\2\2\2\u01d6"+
		"\u01c7\3\2\2\2\u01d6\u01ce\3\2\2\2\u01d6\u01d5\3\2\2\2\u01d7a\3\2\2\2"+
		"\u01d8\u01d9\7^\2\2\u01d9\u01da\5`\61\2\u01dac\3\2\2\2\u01db\u01dc\7E"+
		"\2\2\u01dc\u01f5\5d\63\2\u01dd\u01de\7?\2\2\u01de\u01df\5d\63\2\u01df"+
		"\u01e2\7@\2\2\u01e0\u01e1\t\r\2\2\u01e1\u01e3\5d\63\2\u01e2\u01e0\3\2"+
		"\2\2\u01e2\u01e3\3\2\2\2\u01e3\u01f5\3\2\2\2\u01e4\u01e7\t\16\2\2\u01e5"+
		"\u01e6\t\17\2\2\u01e6\u01e8\5`\61\2\u01e7\u01e5\3\2\2\2\u01e7\u01e8\3"+
		"\2\2\2\u01e8\u01eb\3\2\2\2\u01e9\u01ea\t\r\2\2\u01ea\u01ec\5d\63\2\u01eb"+
		"\u01e9\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01f5\3\2\2\2\u01ed\u01ee\t\20"+
		"\2\2\u01ee\u01ef\7P\2\2\u01ef\u01f2\5l\67\2\u01f0\u01f1\t\r\2\2\u01f1"+
		"\u01f3\5d\63\2\u01f2\u01f0\3\2\2\2\u01f2\u01f3\3\2\2\2\u01f3\u01f5\3\2"+
		"\2\2\u01f4\u01db\3\2\2\2\u01f4\u01dd\3\2\2\2\u01f4\u01e4\3\2\2\2\u01f4"+
		"\u01ed\3\2\2\2\u01f5e\3\2\2\2\u01f6\u0201\7R\2\2\u01f7\u01f8\7?\2\2\u01f8"+
		"\u01fd\7R\2\2\u01f9\u01fa\7\3\2\2\u01fa\u01fc\7R\2\2\u01fb\u01f9\3\2\2"+
		"\2\u01fc\u01ff\3\2\2\2\u01fd\u01fb\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe\u0200"+
		"\3\2\2\2\u01ff\u01fd\3\2\2\2\u0200\u0202\7@\2\2\u0201\u01f7\3\2\2\2\u0201"+
		"\u0202\3\2\2\2\u0202g\3\2\2\2\u0203\u0204\t\21\2\2\u0204i\3\2\2\2\u0205"+
		"\u020f\7R\2\2\u0206\u0207\7)\2\2\u0207\u020f\5l\67\2\u0208\u0209\7*\2"+
		"\2\u0209\u020f\5l\67\2\u020a\u020c\t\22\2\2\u020b\u020d\5p9\2\u020c\u020b"+
		"\3\2\2\2\u020c\u020d\3\2\2\2\u020d\u020f\3\2\2\2\u020e\u0205\3\2\2\2\u020e"+
		"\u0206\3\2\2\2\u020e\u0208\3\2\2\2\u020e\u020a\3\2\2\2\u020fk\3\2\2\2"+
		"\u0210\u0211\7A\2\2\u0211\u0216\5n8\2\u0212\u0213\7\3\2\2\u0213\u0215"+
		"\5n8\2\u0214\u0212\3\2\2\2\u0215\u0218\3\2\2\2\u0216\u0214\3\2\2\2\u0216"+
		"\u0217\3\2\2\2\u0217\u0219\3\2\2\2\u0218\u0216\3\2\2\2\u0219\u021a\7B"+
		"\2\2\u021am\3\2\2\2\u021b\u021c\t\23\2\2\u021co\3\2\2\2\u021d\u021e\7"+
		"=\2\2\u021e\u021f\t\3\2\2\u021f\u0220\7\6\2\2\u0220\u0221\t\3\2\2\u0221"+
		"\u0222\7>\2\2\u0222q\3\2\2\29x\u008d\u0092\u0097\u00a5\u00b4\u00bb\u00de"+
		"\u00e5\u00f6\u00ff\u0104\u010a\u010d\u0119\u0120\u0125\u012d\u0137\u013d"+
		"\u0141\u0144\u0149\u0151\u015a\u0160\u016a\u016d\u0172\u0178\u017c\u017f"+
		"\u0184\u0199\u01af\u01b5\u01ba\u01bd\u01c2\u01c5\u01c9\u01cc\u01d0\u01d3"+
		"\u01d6\u01e2\u01e7\u01eb\u01f2\u01f4\u01fd\u0201\u020c\u020e\u0216";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}