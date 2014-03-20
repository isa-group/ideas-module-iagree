// Generated from C:\Users\Juanlu\Desktop\iAgree\iAgree.g4 by ANTLR 4.1
package es.us.isa.parser;
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
		T__18=1, T__17=2, T__16=3, T__15=4, T__14=5, T__13=6, T__12=7, T__11=8, 
		T__10=9, T__9=10, T__8=11, T__7=12, T__6=13, T__5=14, T__4=15, T__3=16, 
		T__2=17, T__1=18, T__0=19, CA=20, CC=21, PA=22, PC=23, LLA=24, LLC=25, 
		DP=26, RANGE_SEPARATOR=27, MENOR=28, MAYOR=29, IGUAL=30, MENOR_IGUAL=31, 
		MAYOR_IGUAL=32, AND=33, OR=34, NOT=35, IMPLIES=36, BELONGS=37, TRUE=38, 
		FALSE=39, EXCEPT=40, DURING=41, ON=42, FROM=43, END=44, TEMPLATE=45, END_TEMPLATE=46, 
		VERSION=47, AG_OFFER=48, END_AG_OFFER=49, FOR=50, AS=51, INITIATOR=52, 
		RESPONDER=53, SERVICEPROVIDER=54, EXPIRATIONTIME=55, DATEFORMAT=56, GMTZONE=57, 
		GLOBALPERIOD=58, DEFINEDPERIOD=59, METRICS=60, AGREEMENT_TERMS=61, CREATION_CONSTRAINTS=62, 
		GUARANTEE_TERMS=63, SERVICE=64, FEATURES=65, GLOBALDESCRIPTION=66, DESCRIPTION=67, 
		GLOBAL=68, MONITORABLEPROPERTIES=69, GUARANTEES=70, AVAL_AT=71, PROVIDER=72, 
		CONSUMER=73, UPON=74, ONLY_IF=75, INT=76, SINT=77, FLOAT=78, SFLOAT=79, 
		LABEL=80, RANGE=81, VERSION_NUMBER=82, IDENT=83, VALUE=84, ACCESS=85, 
		DATE=86, HOUR=87, STRING=88, COMMENT_LINE=89, WS=90, LETTER=91;
	public static final String[] tokenNames = {
		"<INVALID>", "'%'", "'of'", "','", "'min'", "'+'", "'*'", "'-'", "';'", 
		"'set'", "'all'", "'number'", "'exactly one'", "'integer'", "'/'", "'boolean'", 
		"'float'", "'natural'", "'one or more'", "'enum'", "'['", "']'", "'('", 
		"')'", "'{'", "'}'", "':'", "'..'", "'<'", "'>'", "'='", "'<='", "'>='", 
		"'AND'", "'OR'", "'NOT'", "'IMPLIES'", "'belongs'", "'true'", "'false'", 
		"'except'", "'during'", "'on'", "'from'", "'end'", "'Template'", "'EndTemplate'", 
		"'version'", "'AgreementOffer'", "'EndAgreementOffer'", "'for'", "'as'", 
		"'Initiator'", "'Responder'", "'ServiceProvider'", "'ExpirationTime'", 
		"'DateFormat'", "'GMTZone'", "'GlobalPeriod'", "'DefinedPeriod'", "'Metrics'", 
		"'AgreementTerms'", "'CreationConstraints'", "'GuaranteeTerms'", "'Service'", 
		"'Features/Operations'", "'GlobalDescription'", "'Description'", "'global'", 
		"'MonitorableProperties'", "'guarantees'", "'availableAt.'", "'Provider'", 
		"'Consumer'", "'upon'", "'onlyIf'", "INT", "SINT", "FLOAT", "SFLOAT", 
		"LABEL", "RANGE", "VERSION_NUMBER", "IDENT", "VALUE", "ACCESS", "DATE", 
		"HOUR", "STRING", "COMMENT_LINE", "WS", "LETTER"
	};
	public static final int
		RULE_entry = 0, RULE_template = 1, RULE_agOffer = 2, RULE_version = 3, 
		RULE_template_def = 4, RULE_ag_def = 5, RULE_temp_properties = 6, RULE_initiator_prop = 7, 
		RULE_responder_prop = 8, RULE_serviceProvider_prop = 9, RULE_expirationTime_prop = 10, 
		RULE_dateFormat_prop = 11, RULE_gmtZone_prop = 12, RULE_globalPeriod_prop = 13, 
		RULE_definedPeriod_prop = 14, RULE_datePeriod_def = 15, RULE_temporality = 16, 
		RULE_period = 17, RULE_period_def = 18, RULE_agreementTerms = 19, RULE_creationConstraints = 20, 
		RULE_agreementTerms_def = 21, RULE_creationConstraints_def = 22, RULE_creationConstraint = 23, 
		RULE_service = 24, RULE_features = 25, RULE_descriptions = 26, RULE_feature = 27, 
		RULE_op = 28, RULE_description = 29, RULE_monitorableProperties = 30, 
		RULE_global_MonitorableProperties = 31, RULE_local_MonitorableProperties = 32, 
		RULE_guaranteeTerms = 33, RULE_guaranteeTerm = 34, RULE_grouped_guaranteeTerm = 35, 
		RULE_guarantee_def = 36, RULE_upon_sentence = 37, RULE_onlyif_sentence = 38, 
		RULE_assig_value = 39, RULE_operation = 40, RULE_unit = 41, RULE_list = 42, 
		RULE_expression = 43, RULE_cuantif = 44, RULE_key_value_prop = 45, RULE_type = 46, 
		RULE_range = 47, RULE_url = 48, RULE_metrics_prop = 49, RULE_globalDescription = 50;
	public static final String[] ruleNames = {
		"entry", "template", "agOffer", "version", "template_def", "ag_def", "temp_properties", 
		"initiator_prop", "responder_prop", "serviceProvider_prop", "expirationTime_prop", 
		"dateFormat_prop", "gmtZone_prop", "globalPeriod_prop", "definedPeriod_prop", 
		"datePeriod_def", "temporality", "period", "period_def", "agreementTerms", 
		"creationConstraints", "agreementTerms_def", "creationConstraints_def", 
		"creationConstraint", "service", "features", "descriptions", "feature", 
		"op", "description", "monitorableProperties", "global_MonitorableProperties", 
		"local_MonitorableProperties", "guaranteeTerms", "guaranteeTerm", "grouped_guaranteeTerm", 
		"guarantee_def", "upon_sentence", "onlyif_sentence", "assig_value", "operation", 
		"unit", "list", "expression", "cuantif", "key_value_prop", "type", "range", 
		"url", "metrics_prop", "globalDescription"
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
			setState(108);
			switch (_input.LA(1)) {
			case TEMPLATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(102); template();
				setState(103); match(END_TEMPLATE);
				}
				break;
			case AG_OFFER:
				enterOuterAlt(_localctx, 2);
				{
				setState(105); agOffer();
				setState(106); match(END_AG_OFFER);
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
		public Template_defContext template_def() {
			return getRuleContext(Template_defContext.class,0);
		}
		public TerminalNode VERSION() { return getToken(iAgreeParser.VERSION, 0); }
		public VersionContext version() {
			return getRuleContext(VersionContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(iAgreeParser.IDENT, 0); }
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
			setState(110); match(TEMPLATE);
			setState(111); match(IDENT);
			setState(112); match(VERSION);
			setState(113); version();
			setState(114); template_def();
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
		public Ag_defContext ag_def() {
			return getRuleContext(Ag_defContext.class,0);
		}
		public TerminalNode FOR() { return getToken(iAgreeParser.FOR, 0); }
		public List<TerminalNode> VERSION() { return getTokens(iAgreeParser.VERSION); }
		public List<VersionContext> version() {
			return getRuleContexts(VersionContext.class);
		}
		public TerminalNode AG_OFFER() { return getToken(iAgreeParser.AG_OFFER, 0); }
		public VersionContext version(int i) {
			return getRuleContext(VersionContext.class,i);
		}
		public List<TerminalNode> IDENT() { return getTokens(iAgreeParser.IDENT); }
		public TerminalNode VERSION(int i) {
			return getToken(iAgreeParser.VERSION, i);
		}
		public TerminalNode IDENT(int i) {
			return getToken(iAgreeParser.IDENT, i);
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
			setState(116); match(AG_OFFER);
			setState(117); match(IDENT);
			setState(118); match(VERSION);
			setState(119); version();
			setState(120); match(FOR);
			setState(121); match(IDENT);
			setState(122); match(VERSION);
			setState(123); version();
			setState(124); ag_def();
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

	public static class VersionContext extends ParserRuleContext {
		public TerminalNode VERSION_NUMBER() { return getToken(iAgreeParser.VERSION_NUMBER, 0); }
		public TerminalNode FLOAT() { return getToken(iAgreeParser.FLOAT, 0); }
		public VersionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_version; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterVersion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitVersion(this);
		}
	}

	public final VersionContext version() throws RecognitionException {
		VersionContext _localctx = new VersionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_version);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_la = _input.LA(1);
			if ( !(_la==FLOAT || _la==VERSION_NUMBER) ) {
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
		enterRule(_localctx, 8, RULE_template_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 52)) & ~0x3f) == 0 && ((1L << (_la - 52)) & ((1L << (INITIATOR - 52)) | (1L << (SERVICEPROVIDER - 52)) | (1L << (EXPIRATIONTIME - 52)) | (1L << (DATEFORMAT - 52)) | (1L << (GMTZONE - 52)) | (1L << (GLOBALPERIOD - 52)) | (1L << (DEFINEDPERIOD - 52)) | (1L << (METRICS - 52)) | (1L << (PROVIDER - 52)) | (1L << (CONSUMER - 52)) | (1L << (IDENT - 52)))) != 0)) {
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
		enterRule(_localctx, 10, RULE_ag_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 52)) & ~0x3f) == 0 && ((1L << (_la - 52)) & ((1L << (INITIATOR - 52)) | (1L << (SERVICEPROVIDER - 52)) | (1L << (EXPIRATIONTIME - 52)) | (1L << (DATEFORMAT - 52)) | (1L << (GMTZONE - 52)) | (1L << (GLOBALPERIOD - 52)) | (1L << (DEFINEDPERIOD - 52)) | (1L << (METRICS - 52)) | (1L << (PROVIDER - 52)) | (1L << (CONSUMER - 52)) | (1L << (IDENT - 52)))) != 0)) {
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
		enterRule(_localctx, 12, RULE_temp_properties);
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
			case IDENT:
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

	public static class Initiator_propContext extends ParserRuleContext {
		public TerminalNode INITIATOR() { return getToken(iAgreeParser.INITIATOR, 0); }
		public TerminalNode STRING() { return getToken(iAgreeParser.STRING, 0); }
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
		enterRule(_localctx, 14, RULE_initiator_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157); match(INITIATOR);
			setState(158); match(DP);
			setState(159); match(STRING);
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
		public TerminalNode IDENT() { return getToken(iAgreeParser.IDENT, 0); }
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
		enterRule(_localctx, 16, RULE_responder_prop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			_la = _input.LA(1);
			if ( !(((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & ((1L << (PROVIDER - 72)) | (1L << (CONSUMER - 72)) | (1L << (IDENT - 72)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(162); match(AS);
			setState(163); match(RESPONDER);
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
		public TerminalNode SERVICEPROVIDER() { return getToken(iAgreeParser.SERVICEPROVIDER, 0); }
		public TerminalNode STRING() { return getToken(iAgreeParser.STRING, 0); }
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
		enterRule(_localctx, 18, RULE_serviceProvider_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165); match(SERVICEPROVIDER);
			setState(166); match(DP);
			setState(167); match(STRING);
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
		public TerminalNode EXPIRATIONTIME() { return getToken(iAgreeParser.EXPIRATIONTIME, 0); }
		public TerminalNode STRING() { return getToken(iAgreeParser.STRING, 0); }
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
		enterRule(_localctx, 20, RULE_expirationTime_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169); match(EXPIRATIONTIME);
			setState(170); match(DP);
			setState(171); match(STRING);
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
		public TerminalNode STRING() { return getToken(iAgreeParser.STRING, 0); }
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
		enterRule(_localctx, 22, RULE_dateFormat_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173); match(DATEFORMAT);
			setState(174); match(DP);
			setState(175); match(STRING);
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
		public TerminalNode GMTZONE() { return getToken(iAgreeParser.GMTZONE, 0); }
		public TerminalNode INT() { return getToken(iAgreeParser.INT, 0); }
		public TerminalNode SINT() { return getToken(iAgreeParser.SINT, 0); }
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
		enterRule(_localctx, 24, RULE_gmtZone_prop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177); match(GMTZONE);
			setState(178); match(DP);
			setState(179);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==SINT) ) {
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
		enterRule(_localctx, 26, RULE_globalPeriod_prop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181); match(GLOBALPERIOD);
			setState(182); match(DP);
			setState(183); datePeriod_def();
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
		enterRule(_localctx, 28, RULE_definedPeriod_prop);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(185); match(DEFINEDPERIOD);
			setState(186); match(DP);
			setState(188); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(187); period();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(190); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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
		public List<TerminalNode> DATE() { return getTokens(iAgreeParser.DATE); }
		public TerminalNode RANGE_SEPARATOR() { return getToken(iAgreeParser.RANGE_SEPARATOR, 0); }
		public TerminalNode DATE(int i) {
			return getToken(iAgreeParser.DATE, i);
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
		enterRule(_localctx, 30, RULE_datePeriod_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192); match(DURING);
			setState(193); match(DATE);
			setState(194); match(RANGE_SEPARATOR);
			setState(195); match(DATE);
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
		public TerminalNode IDENT() { return getToken(iAgreeParser.IDENT, 0); }
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
		enterRule(_localctx, 32, RULE_temporality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197); match(ON);
			setState(198); match(IDENT);
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
		public List<Period_defContext> period_def() {
			return getRuleContexts(Period_defContext.class);
		}
		public TerminalNode AND(int i) {
			return getToken(iAgreeParser.AND, i);
		}
		public Period_defContext period_def(int i) {
			return getRuleContext(Period_defContext.class,i);
		}
		public TerminalNode IDENT() { return getToken(iAgreeParser.IDENT, 0); }
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
		enterRule(_localctx, 34, RULE_period);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200); match(IDENT);
			setState(201); match(DP);
			setState(202); period_def();
			setState(207);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND || _la==EXCEPT) {
				{
				{
				setState(203);
				_la = _input.LA(1);
				if ( !(_la==AND || _la==EXCEPT) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(204); period_def();
				}
				}
				setState(209);
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
		public TerminalNode DURING() { return getToken(iAgreeParser.DURING, 0); }
		public TerminalNode ON() { return getToken(iAgreeParser.ON, 0); }
		public List<TerminalNode> DATE() { return getTokens(iAgreeParser.DATE); }
		public TerminalNode HOUR(int i) {
			return getToken(iAgreeParser.HOUR, i);
		}
		public TerminalNode GLOBALPERIOD() { return getToken(iAgreeParser.GLOBALPERIOD, 0); }
		public List<TerminalNode> HOUR() { return getTokens(iAgreeParser.HOUR); }
		public TerminalNode IDENT() { return getToken(iAgreeParser.IDENT, 0); }
		public TerminalNode FROM() { return getToken(iAgreeParser.FROM, 0); }
		public TerminalNode DATE(int i) {
			return getToken(iAgreeParser.DATE, i);
		}
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
		enterRule(_localctx, 36, RULE_period_def);
		int _la;
		try {
			setState(224);
			switch (_input.LA(1)) {
			case FROM:
				enterOuterAlt(_localctx, 1);
				{
				setState(210); match(FROM);
				setState(211); match(HOUR);
				setState(212); match(RANGE_SEPARATOR);
				setState(213); match(HOUR);
				setState(216);
				_la = _input.LA(1);
				if (_la==ON) {
					{
					setState(214); match(ON);
					setState(215); match(IDENT);
					}
				}

				setState(218); match(DURING);
				setState(219); match(DATE);
				setState(220); match(RANGE_SEPARATOR);
				setState(221); match(DATE);
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(222); match(IDENT);
				}
				break;
			case GLOBALPERIOD:
				enterOuterAlt(_localctx, 3);
				{
				setState(223); match(GLOBALPERIOD);
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
		enterRule(_localctx, 38, RULE_agreementTerms);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226); match(AGREEMENT_TERMS);
			setState(227); agreementTerms_def();
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
		enterRule(_localctx, 40, RULE_creationConstraints);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(229); match(CREATION_CONSTRAINTS);
			setState(230); creationConstraints_def();
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
		enterRule(_localctx, 42, RULE_agreementTerms_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232); service();
			setState(233); monitorableProperties();
			setState(234); guaranteeTerms();
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
		enterRule(_localctx, 44, RULE_creationConstraints_def);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(236); creationConstraint();
				}
				}
				setState(239); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LABEL || _la==IDENT );
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
		public Onlyif_sentenceContext onlyif_sentence() {
			return getRuleContext(Onlyif_sentenceContext.class,0);
		}
		public TerminalNode LABEL() { return getToken(iAgreeParser.LABEL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(iAgreeParser.IDENT, 0); }
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
		enterRule(_localctx, 46, RULE_creationConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(241);
			_la = _input.LA(1);
			if ( !(_la==LABEL || _la==IDENT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(242); match(DP);
			setState(243); expression();
			setState(244); match(8);
			setState(246);
			_la = _input.LA(1);
			if (_la==ONLY_IF) {
				{
				setState(245); onlyif_sentence();
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
		public TerminalNode SERVICE() { return getToken(iAgreeParser.SERVICE, 0); }
		public TerminalNode AVAL_AT() { return getToken(iAgreeParser.AVAL_AT, 0); }
		public DescriptionsContext descriptions() {
			return getRuleContext(DescriptionsContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(iAgreeParser.IDENT, 0); }
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
			setState(248); match(SERVICE);
			setState(249); match(IDENT);
			setState(252);
			_la = _input.LA(1);
			if (_la==AVAL_AT) {
				{
				setState(250); match(AVAL_AT);
				setState(251); url();
				}
			}

			setState(255);
			_la = _input.LA(1);
			if (_la==FEATURES) {
				{
				setState(254); features();
				}
			}

			setState(257); globalDescription();
			setState(258); descriptions();
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
			setState(260); match(FEATURES);
			setState(261); match(DP);
			setState(262); feature();
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3) {
				{
				{
				setState(263); match(3);
				setState(264); feature();
				}
				}
				setState(269);
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
		enterRule(_localctx, 52, RULE_descriptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DESCRIPTION) {
				{
				{
				setState(270); description();
				}
				}
				setState(275);
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
		enterRule(_localctx, 54, RULE_feature);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(276); op();
			setState(281);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					{
					{
					setState(277); match(3);
					setState(278); op();
					}
					} 
				}
				setState(283);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class OpContext extends ParserRuleContext {
		public TerminalNode PA() { return getToken(iAgreeParser.PA, 0); }
		public TerminalNode PC() { return getToken(iAgreeParser.PC, 0); }
		public List<TerminalNode> IDENT() { return getTokens(iAgreeParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(iAgreeParser.IDENT, i);
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
		enterRule(_localctx, 56, RULE_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284); match(IDENT);
			setState(295);
			_la = _input.LA(1);
			if (_la==PA) {
				{
				setState(285); match(PA);
				setState(286); match(IDENT);
				setState(291);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==3) {
					{
					{
					setState(287); match(3);
					setState(288); match(IDENT);
					}
					}
					setState(293);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(294); match(PC);
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
			setState(297); match(DESCRIPTION);
			setState(298); match(FOR);
			setState(299); feature();
			setState(304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3) {
				{
				{
				setState(300); match(3);
				setState(301); feature();
				}
				}
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(308); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(307); key_value_prop();
				}
				}
				setState(310); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==13 || _la==15 || _la==IDENT || _la==ACCESS );
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
		public TerminalNode IDENT() { return getToken(iAgreeParser.IDENT, 0); }
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
			setState(312); match(MONITORABLEPROPERTIES);
			setState(314);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(313); match(IDENT);
				}
			}

			setState(317);
			_la = _input.LA(1);
			if (_la==GLOBAL) {
				{
				setState(316); global_MonitorableProperties();
				}
			}

			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FOR) {
				{
				{
				setState(319); local_MonitorableProperties();
				}
				}
				setState(324);
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
			setState(325); match(GLOBAL);
			setState(326); match(DP);
			setState(328); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(327); key_value_prop();
				}
				}
				setState(330); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==13 || _la==15 || _la==IDENT || _la==ACCESS );
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
		public TerminalNode IDENT() { return getToken(iAgreeParser.IDENT, 0); }
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
			setState(332); match(FOR);
			setState(333); match(IDENT);
			setState(334); match(DP);
			setState(336); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(335); key_value_prop();
				}
				}
				setState(338); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==13 || _la==15 || _la==IDENT || _la==ACCESS );
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
			setState(340); match(GUARANTEE_TERMS);
			setState(342); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(341); guaranteeTerm();
				}
				}
				setState(344); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LABEL || _la==IDENT );
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
		public TerminalNode LABEL() { return getToken(iAgreeParser.LABEL, 0); }
		public Grouped_guaranteeTermContext grouped_guaranteeTerm() {
			return getRuleContext(Grouped_guaranteeTermContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(iAgreeParser.IDENT, 0); }
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(346);
			_la = _input.LA(1);
			if ( !(_la==LABEL || _la==IDENT) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(347); match(DP);
			setState(353);
			switch (_input.LA(1)) {
			case PROVIDER:
			case CONSUMER:
				{
				setState(348); guarantee_def();
				}
				break;
			case 10:
			case 12:
			case 18:
				{
				setState(349); cuantif();
				setState(350); match(2);
				setState(351); grouped_guaranteeTerm();
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
			setState(356); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(355); guaranteeTerm();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(358); 
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
		public TerminalNode CONSUMER() { return getToken(iAgreeParser.CONSUMER, 0); }
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
			setState(360);
			_la = _input.LA(1);
			if ( !(_la==PROVIDER || _la==CONSUMER) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(361); match(GUARANTEES);
			setState(362); expression();
			setState(364);
			_la = _input.LA(1);
			if (_la==ON) {
				{
				setState(363); temporality();
				}
			}

			setState(366); match(8);
			setState(368);
			_la = _input.LA(1);
			if (_la==UPON) {
				{
				setState(367); upon_sentence();
				}
			}

			setState(371);
			_la = _input.LA(1);
			if (_la==ONLY_IF) {
				{
				setState(370); onlyif_sentence();
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

	public static class Upon_sentenceContext extends ParserRuleContext {
		public TerminalNode UPON() { return getToken(iAgreeParser.UPON, 0); }
		public TerminalNode IDENT() { return getToken(iAgreeParser.IDENT, 0); }
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
		enterRule(_localctx, 74, RULE_upon_sentence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373); match(UPON);
			setState(374); match(IDENT);
			setState(375); match(8);
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
		enterRule(_localctx, 76, RULE_onlyif_sentence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377); match(ONLY_IF);
			setState(378); match(PA);
			setState(379); expression();
			setState(380); match(PC);
			setState(381); match(8);
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
		public TerminalNode LETTER(int i) {
			return getToken(iAgreeParser.LETTER, i);
		}
		public TerminalNode STRING(int i) {
			return getToken(iAgreeParser.STRING, i);
		}
		public List<TerminalNode> LETTER() { return getTokens(iAgreeParser.LETTER); }
		public TerminalNode FLOAT() { return getToken(iAgreeParser.FLOAT, 0); }
		public OperationContext operation() {
			return getRuleContext(OperationContext.class,0);
		}
		public List<TerminalNode> INT() { return getTokens(iAgreeParser.INT); }
		public TerminalNode TRUE() { return getToken(iAgreeParser.TRUE, 0); }
		public TerminalNode SFLOAT() { return getToken(iAgreeParser.SFLOAT, 0); }
		public TerminalNode SINT() { return getToken(iAgreeParser.SINT, 0); }
		public TerminalNode VALUE(int i) {
			return getToken(iAgreeParser.VALUE, i);
		}
		public TerminalNode INT(int i) {
			return getToken(iAgreeParser.INT, i);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public List<TerminalNode> VALUE() { return getTokens(iAgreeParser.VALUE); }
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public List<TerminalNode> IDENT() { return getTokens(iAgreeParser.IDENT); }
		public List<TerminalNode> STRING() { return getTokens(iAgreeParser.STRING); }
		public TerminalNode IDENT(int i) {
			return getToken(iAgreeParser.IDENT, i);
		}
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
		enterRule(_localctx, 78, RULE_assig_value);
		int _la;
		try {
			setState(415);
			switch (_input.LA(1)) {
			case INT:
			case IDENT:
			case VALUE:
			case STRING:
			case LETTER:
				enterOuterAlt(_localctx, 1);
				{
				setState(384); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(383);
					_la = _input.LA(1);
					if ( !(((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (INT - 76)) | (1L << (IDENT - 76)) | (1L << (VALUE - 76)) | (1L << (STRING - 76)) | (1L << (LETTER - 76)))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					}
					}
					setState(386); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (INT - 76)) | (1L << (IDENT - 76)) | (1L << (VALUE - 76)) | (1L << (STRING - 76)) | (1L << (LETTER - 76)))) != 0) );
				setState(389);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 6) | (1L << 7) | (1L << 14))) != 0)) {
					{
					setState(388); operation();
					}
				}

				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(391); match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(392); match(FALSE);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 4);
				{
				setState(393); match(FLOAT);
				setState(395);
				_la = _input.LA(1);
				if (_la==1 || _la==4) {
					{
					setState(394); unit();
					}
				}

				setState(398);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 6) | (1L << 7) | (1L << 14))) != 0)) {
					{
					setState(397); operation();
					}
				}

				}
				break;
			case SFLOAT:
				enterOuterAlt(_localctx, 5);
				{
				setState(400); match(SFLOAT);
				setState(402);
				_la = _input.LA(1);
				if (_la==1 || _la==4) {
					{
					setState(401); unit();
					}
				}

				setState(405);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 6) | (1L << 7) | (1L << 14))) != 0)) {
					{
					setState(404); operation();
					}
				}

				}
				break;
			case SINT:
				enterOuterAlt(_localctx, 6);
				{
				setState(407); match(SINT);
				setState(409);
				_la = _input.LA(1);
				if (_la==1 || _la==4) {
					{
					setState(408); unit();
					}
				}

				setState(412);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 6) | (1L << 7) | (1L << 14))) != 0)) {
					{
					setState(411); operation();
					}
				}

				}
				break;
			case LLA:
				enterOuterAlt(_localctx, 7);
				{
				setState(414); list();
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
		enterRule(_localctx, 80, RULE_operation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 6) | (1L << 7) | (1L << 14))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(418); assig_value();
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

	public static class UnitContext extends ParserRuleContext {
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).enterUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof iAgreeListener ) ((iAgreeListener)listener).exitUnit(this);
		}
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_unit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			_la = _input.LA(1);
			if ( !(_la==1 || _la==4) ) {
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

	public static class ListContext extends ParserRuleContext {
		public TerminalNode STRING(int i) {
			return getToken(iAgreeParser.STRING, i);
		}
		public List<TerminalNode> INT() { return getTokens(iAgreeParser.INT); }
		public TerminalNode SINT(int i) {
			return getToken(iAgreeParser.SINT, i);
		}
		public List<TerminalNode> FLOAT() { return getTokens(iAgreeParser.FLOAT); }
		public List<TerminalNode> SFLOAT() { return getTokens(iAgreeParser.SFLOAT); }
		public TerminalNode LLA() { return getToken(iAgreeParser.LLA, 0); }
		public List<TerminalNode> SINT() { return getTokens(iAgreeParser.SINT); }
		public TerminalNode INT(int i) {
			return getToken(iAgreeParser.INT, i);
		}
		public TerminalNode SFLOAT(int i) {
			return getToken(iAgreeParser.SFLOAT, i);
		}
		public TerminalNode FLOAT(int i) {
			return getToken(iAgreeParser.FLOAT, i);
		}
		public TerminalNode LLC() { return getToken(iAgreeParser.LLC, 0); }
		public List<TerminalNode> IDENT() { return getTokens(iAgreeParser.IDENT); }
		public List<TerminalNode> STRING() { return getTokens(iAgreeParser.STRING); }
		public TerminalNode IDENT(int i) {
			return getToken(iAgreeParser.IDENT, i);
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
		enterRule(_localctx, 84, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(422); match(LLA);
			setState(423);
			_la = _input.LA(1);
			if ( !(((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (INT - 76)) | (1L << (SINT - 76)) | (1L << (FLOAT - 76)) | (1L << (SFLOAT - 76)) | (1L << (IDENT - 76)) | (1L << (STRING - 76)))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(428);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==3) {
				{
				{
				setState(424); match(3);
				setState(425);
				_la = _input.LA(1);
				if ( !(((((_la - 76)) & ~0x3f) == 0 && ((1L << (_la - 76)) & ((1L << (INT - 76)) | (1L << (SINT - 76)) | (1L << (FLOAT - 76)) | (1L << (SFLOAT - 76)) | (1L << (IDENT - 76)) | (1L << (STRING - 76)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
				}
				setState(430);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(431); match(LLC);
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
		public TerminalNode MAYOR() { return getToken(iAgreeParser.MAYOR, 0); }
		public TerminalNode BELONGS() { return getToken(iAgreeParser.BELONGS, 0); }
		public Assig_valueContext assig_value() {
			return getRuleContext(Assig_valueContext.class,0);
		}
		public TerminalNode AND() { return getToken(iAgreeParser.AND, 0); }
		public TerminalNode MENOR() { return getToken(iAgreeParser.MENOR, 0); }
		public TerminalNode OR() { return getToken(iAgreeParser.OR, 0); }
		public TerminalNode ACCESS() { return getToken(iAgreeParser.ACCESS, 0); }
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
		public TerminalNode MENOR_IGUAL() { return getToken(iAgreeParser.MENOR_IGUAL, 0); }
		public TerminalNode IMPLIES() { return getToken(iAgreeParser.IMPLIES, 0); }
		public TerminalNode IDENT() { return getToken(iAgreeParser.IDENT, 0); }
		public TerminalNode STRING() { return getToken(iAgreeParser.STRING, 0); }
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
			setState(458);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(433); match(NOT);
				setState(434); expression();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(435); match(PA);
				setState(436); expression();
				setState(437); match(PC);
				setState(440);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << IMPLIES))) != 0)) {
					{
					setState(438);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << IMPLIES))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(439); expression();
					}
				}

				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(442);
				_la = _input.LA(1);
				if ( !(((((_la - 83)) & ~0x3f) == 0 && ((1L << (_la - 83)) & ((1L << (IDENT - 83)) | (1L << (ACCESS - 83)) | (1L << (STRING - 83)))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(445);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MENOR) | (1L << MAYOR) | (1L << IGUAL) | (1L << MENOR_IGUAL) | (1L << MAYOR_IGUAL))) != 0)) {
					{
					setState(443);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << MENOR) | (1L << MAYOR) | (1L << IGUAL) | (1L << MENOR_IGUAL) | (1L << MAYOR_IGUAL))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(444); assig_value();
					}
				}

				setState(449);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << IMPLIES))) != 0)) {
					{
					setState(447);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << IMPLIES))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(448); expression();
					}
				}

				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(451);
				_la = _input.LA(1);
				if ( !(_la==IDENT || _la==ACCESS) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(452); match(BELONGS);
				setState(453); list();
				setState(456);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << IMPLIES))) != 0)) {
					{
					setState(454);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AND) | (1L << OR) | (1L << IMPLIES))) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					consume();
					setState(455); expression();
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

	public static class CuantifContext extends ParserRuleContext {
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
		enterRule(_localctx, 88, RULE_cuantif);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(460);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << 12) | (1L << 18))) != 0)) ) {
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
		public Assig_valueContext assig_value() {
			return getRuleContext(Assig_valueContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ACCESS() { return getToken(iAgreeParser.ACCESS, 0); }
		public TerminalNode IGUAL() { return getToken(iAgreeParser.IGUAL, 0); }
		public TerminalNode STRING() { return getToken(iAgreeParser.STRING, 0); }
		public TerminalNode IDENT() { return getToken(iAgreeParser.IDENT, 0); }
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
		enterRule(_localctx, 90, RULE_key_value_prop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(462);
			_la = _input.LA(1);
			if ( !(_la==13 || _la==15 || _la==IDENT || _la==ACCESS) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(463); match(DP);
			setState(466);
			switch (_input.LA(1)) {
			case STRING:
				{
				setState(464); match(STRING);
				}
				break;
			case 9:
			case 11:
			case 13:
			case 15:
			case 16:
			case 17:
			case 19:
			case IDENT:
				{
				setState(465); type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(472);
			_la = _input.LA(1);
			if (_la==IGUAL) {
				{
				setState(468); match(IGUAL);
				setState(469); assig_value();
				setState(470); match(8);
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

	public static class TypeContext extends ParserRuleContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public RangeContext range() {
			return getRuleContext(RangeContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(iAgreeParser.IDENT, 0); }
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
		enterRule(_localctx, 92, RULE_type);
		int _la;
		try {
			setState(483);
			switch (_input.LA(1)) {
			case 11:
			case 13:
			case 15:
			case 16:
			case 17:
				enterOuterAlt(_localctx, 1);
				{
				setState(474);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 11) | (1L << 13) | (1L << 15) | (1L << 16) | (1L << 17))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(476);
				_la = _input.LA(1);
				if (_la==CA) {
					{
					setState(475); range();
					}
				}

				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(478); match(IDENT);
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 3);
				{
				setState(479); match(9);
				setState(480); list();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 4);
				{
				setState(481); match(19);
				setState(482); list();
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

	public static class RangeContext extends ParserRuleContext {
		public TerminalNode RANGE_SEPARATOR() { return getToken(iAgreeParser.RANGE_SEPARATOR, 0); }
		public TerminalNode CC() { return getToken(iAgreeParser.CC, 0); }
		public TerminalNode RANGE() { return getToken(iAgreeParser.RANGE, 0); }
		public TerminalNode SINT(int i) {
			return getToken(iAgreeParser.SINT, i);
		}
		public List<TerminalNode> INT() { return getTokens(iAgreeParser.INT); }
		public TerminalNode CA() { return getToken(iAgreeParser.CA, 0); }
		public List<TerminalNode> SINT() { return getTokens(iAgreeParser.SINT); }
		public TerminalNode INT(int i) {
			return getToken(iAgreeParser.INT, i);
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
		enterRule(_localctx, 94, RULE_range);
		int _la;
		try {
			setState(493);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(485); match(CA);
				setState(486); match(RANGE);
				setState(487); match(CC);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(488); match(CA);
				setState(489);
				_la = _input.LA(1);
				if ( !(_la==INT || _la==SINT) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(490); match(RANGE_SEPARATOR);
				setState(491);
				_la = _input.LA(1);
				if ( !(_la==INT || _la==SINT) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				setState(492); match(CC);
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

	public static class UrlContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(iAgreeParser.STRING, 0); }
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
		enterRule(_localctx, 96, RULE_url);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(495); match(STRING);
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
		enterRule(_localctx, 98, RULE_metrics_prop);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(497); match(METRICS);
			setState(498); match(DP);
			setState(500); 
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(499); key_value_prop();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(502); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
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
		enterRule(_localctx, 100, RULE_globalDescription);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504); match(GLOBALDESCRIPTION);
			setState(506); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(505); key_value_prop();
				}
				}
				setState(508); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==13 || _la==15 || _la==IDENT || _la==ACCESS );
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
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3]\u0201\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\3\2\3\2\3\2\3\2\3\2\3\2\5\2o\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\7\6\u0084\n\6\f\6\16\6\u0087"+
		"\13\6\3\6\3\6\5\6\u008b\n\6\3\7\7\7\u008e\n\7\f\7\16\7\u0091\13\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u009e\n\b\3\t\3\t\3\t\3\t"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\6\20\u00bf\n\20"+
		"\r\20\16\20\u00c0\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3"+
		"\23\3\23\3\23\7\23\u00d0\n\23\f\23\16\23\u00d3\13\23\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\5\24\u00db\n\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00e3"+
		"\n\24\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\30\6\30\u00f0"+
		"\n\30\r\30\16\30\u00f1\3\31\3\31\3\31\3\31\3\31\5\31\u00f9\n\31\3\32\3"+
		"\32\3\32\3\32\5\32\u00ff\n\32\3\32\5\32\u0102\n\32\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\33\7\33\u010c\n\33\f\33\16\33\u010f\13\33\3\34\7\34"+
		"\u0112\n\34\f\34\16\34\u0115\13\34\3\35\3\35\3\35\7\35\u011a\n\35\f\35"+
		"\16\35\u011d\13\35\3\36\3\36\3\36\3\36\3\36\7\36\u0124\n\36\f\36\16\36"+
		"\u0127\13\36\3\36\5\36\u012a\n\36\3\37\3\37\3\37\3\37\3\37\7\37\u0131"+
		"\n\37\f\37\16\37\u0134\13\37\3\37\6\37\u0137\n\37\r\37\16\37\u0138\3 "+
		"\3 \5 \u013d\n \3 \5 \u0140\n \3 \7 \u0143\n \f \16 \u0146\13 \3!\3!\3"+
		"!\6!\u014b\n!\r!\16!\u014c\3\"\3\"\3\"\3\"\6\"\u0153\n\"\r\"\16\"\u0154"+
		"\3#\3#\6#\u0159\n#\r#\16#\u015a\3$\3$\3$\3$\3$\3$\3$\5$\u0164\n$\3%\6"+
		"%\u0167\n%\r%\16%\u0168\3&\3&\3&\3&\5&\u016f\n&\3&\3&\5&\u0173\n&\3&\5"+
		"&\u0176\n&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3)\6)\u0183\n)\r)\16)\u0184"+
		"\3)\5)\u0188\n)\3)\3)\3)\3)\5)\u018e\n)\3)\5)\u0191\n)\3)\3)\5)\u0195"+
		"\n)\3)\5)\u0198\n)\3)\3)\5)\u019c\n)\3)\5)\u019f\n)\3)\5)\u01a2\n)\3*"+
		"\3*\3*\3+\3+\3,\3,\3,\3,\7,\u01ad\n,\f,\16,\u01b0\13,\3,\3,\3-\3-\3-\3"+
		"-\3-\3-\3-\5-\u01bb\n-\3-\3-\3-\5-\u01c0\n-\3-\3-\5-\u01c4\n-\3-\3-\3"+
		"-\3-\3-\5-\u01cb\n-\5-\u01cd\n-\3.\3.\3/\3/\3/\3/\5/\u01d5\n/\3/\3/\3"+
		"/\3/\5/\u01db\n/\3\60\3\60\5\60\u01df\n\60\3\60\3\60\3\60\3\60\3\60\5"+
		"\60\u01e6\n\60\3\61\3\61\3\61\3\61\3\61\3\61\3\61\3\61\5\61\u01f0\n\61"+
		"\3\62\3\62\3\63\3\63\3\63\6\63\u01f7\n\63\r\63\16\63\u01f8\3\64\3\64\6"+
		"\64\u01fd\n\64\r\64\16\64\u01fe\3\64\2\65\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdf\2\23\4\2PPTT\4"+
		"\2JKUU\3\2NO\4\2##**\4\2RRUU\3\2JK\6\2NNUVZZ]]\4\2\7\t\20\20\4\2\3\3\6"+
		"\6\5\2NQUUZZ\4\2#$&&\5\2UUWWZZ\3\2\36\"\4\2UUWW\5\2\f\f\16\16\24\24\6"+
		"\2\17\17\21\21UUWW\5\2\r\r\17\17\21\23\u0213\2n\3\2\2\2\4p\3\2\2\2\6v"+
		"\3\2\2\2\b\u0080\3\2\2\2\n\u0085\3\2\2\2\f\u008f\3\2\2\2\16\u009d\3\2"+
		"\2\2\20\u009f\3\2\2\2\22\u00a3\3\2\2\2\24\u00a7\3\2\2\2\26\u00ab\3\2\2"+
		"\2\30\u00af\3\2\2\2\32\u00b3\3\2\2\2\34\u00b7\3\2\2\2\36\u00bb\3\2\2\2"+
		" \u00c2\3\2\2\2\"\u00c7\3\2\2\2$\u00ca\3\2\2\2&\u00e2\3\2\2\2(\u00e4\3"+
		"\2\2\2*\u00e7\3\2\2\2,\u00ea\3\2\2\2.\u00ef\3\2\2\2\60\u00f3\3\2\2\2\62"+
		"\u00fa\3\2\2\2\64\u0106\3\2\2\2\66\u0113\3\2\2\28\u0116\3\2\2\2:\u011e"+
		"\3\2\2\2<\u012b\3\2\2\2>\u013a\3\2\2\2@\u0147\3\2\2\2B\u014e\3\2\2\2D"+
		"\u0156\3\2\2\2F\u015c\3\2\2\2H\u0166\3\2\2\2J\u016a\3\2\2\2L\u0177\3\2"+
		"\2\2N\u017b\3\2\2\2P\u01a1\3\2\2\2R\u01a3\3\2\2\2T\u01a6\3\2\2\2V\u01a8"+
		"\3\2\2\2X\u01cc\3\2\2\2Z\u01ce\3\2\2\2\\\u01d0\3\2\2\2^\u01e5\3\2\2\2"+
		"`\u01ef\3\2\2\2b\u01f1\3\2\2\2d\u01f3\3\2\2\2f\u01fa\3\2\2\2hi\5\4\3\2"+
		"ij\7\60\2\2jo\3\2\2\2kl\5\6\4\2lm\7\63\2\2mo\3\2\2\2nh\3\2\2\2nk\3\2\2"+
		"\2o\3\3\2\2\2pq\7/\2\2qr\7U\2\2rs\7\61\2\2st\5\b\5\2tu\5\n\6\2u\5\3\2"+
		"\2\2vw\7\62\2\2wx\7U\2\2xy\7\61\2\2yz\5\b\5\2z{\7\64\2\2{|\7U\2\2|}\7"+
		"\61\2\2}~\5\b\5\2~\177\5\f\7\2\177\7\3\2\2\2\u0080\u0081\t\2\2\2\u0081"+
		"\t\3\2\2\2\u0082\u0084\5\16\b\2\u0083\u0082\3\2\2\2\u0084\u0087\3\2\2"+
		"\2\u0085\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0085"+
		"\3\2\2\2\u0088\u008a\5(\25\2\u0089\u008b\5*\26\2\u008a\u0089\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\13\3\2\2\2\u008c\u008e\5\16\b\2\u008d\u008c\3\2\2"+
		"\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092"+
		"\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093\5(\25\2\u0093\r\3\2\2\2\u0094"+
		"\u009e\5\20\t\2\u0095\u009e\5\22\n\2\u0096\u009e\5\24\13\2\u0097\u009e"+
		"\5\26\f\2\u0098\u009e\5\30\r\2\u0099\u009e\5\32\16\2\u009a\u009e\5\34"+
		"\17\2\u009b\u009e\5\36\20\2\u009c\u009e\5d\63\2\u009d\u0094\3\2\2\2\u009d"+
		"\u0095\3\2\2\2\u009d\u0096\3\2\2\2\u009d\u0097\3\2\2\2\u009d\u0098\3\2"+
		"\2\2\u009d\u0099\3\2\2\2\u009d\u009a\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009c\3\2\2\2\u009e\17\3\2\2\2\u009f\u00a0\7\66\2\2\u00a0\u00a1\7\34"+
		"\2\2\u00a1\u00a2\7Z\2\2\u00a2\21\3\2\2\2\u00a3\u00a4\t\3\2\2\u00a4\u00a5"+
		"\7\65\2\2\u00a5\u00a6\7\67\2\2\u00a6\23\3\2\2\2\u00a7\u00a8\78\2\2\u00a8"+
		"\u00a9\7\34\2\2\u00a9\u00aa\7Z\2\2\u00aa\25\3\2\2\2\u00ab\u00ac\79\2\2"+
		"\u00ac\u00ad\7\34\2\2\u00ad\u00ae\7Z\2\2\u00ae\27\3\2\2\2\u00af\u00b0"+
		"\7:\2\2\u00b0\u00b1\7\34\2\2\u00b1\u00b2\7Z\2\2\u00b2\31\3\2\2\2\u00b3"+
		"\u00b4\7;\2\2\u00b4\u00b5\7\34\2\2\u00b5\u00b6\t\4\2\2\u00b6\33\3\2\2"+
		"\2\u00b7\u00b8\7<\2\2\u00b8\u00b9\7\34\2\2\u00b9\u00ba\5 \21\2\u00ba\35"+
		"\3\2\2\2\u00bb\u00bc\7=\2\2\u00bc\u00be\7\34\2\2\u00bd\u00bf\5$\23\2\u00be"+
		"\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2"+
		"\2\2\u00c1\37\3\2\2\2\u00c2\u00c3\7+\2\2\u00c3\u00c4\7X\2\2\u00c4\u00c5"+
		"\7\35\2\2\u00c5\u00c6\7X\2\2\u00c6!\3\2\2\2\u00c7\u00c8\7,\2\2\u00c8\u00c9"+
		"\7U\2\2\u00c9#\3\2\2\2\u00ca\u00cb\7U\2\2\u00cb\u00cc\7\34\2\2\u00cc\u00d1"+
		"\5&\24\2\u00cd\u00ce\t\5\2\2\u00ce\u00d0\5&\24\2\u00cf\u00cd\3\2\2\2\u00d0"+
		"\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2%\3\2\2\2"+
		"\u00d3\u00d1\3\2\2\2\u00d4\u00d5\7-\2\2\u00d5\u00d6\7Y\2\2\u00d6\u00d7"+
		"\7\35\2\2\u00d7\u00da\7Y\2\2\u00d8\u00d9\7,\2\2\u00d9\u00db\7U\2\2\u00da"+
		"\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\7+"+
		"\2\2\u00dd\u00de\7X\2\2\u00de\u00df\7\35\2\2\u00df\u00e3\7X\2\2\u00e0"+
		"\u00e3\7U\2\2\u00e1\u00e3\7<\2\2\u00e2\u00d4\3\2\2\2\u00e2\u00e0\3\2\2"+
		"\2\u00e2\u00e1\3\2\2\2\u00e3\'\3\2\2\2\u00e4\u00e5\7?\2\2\u00e5\u00e6"+
		"\5,\27\2\u00e6)\3\2\2\2\u00e7\u00e8\7@\2\2\u00e8\u00e9\5.\30\2\u00e9+"+
		"\3\2\2\2\u00ea\u00eb\5\62\32\2\u00eb\u00ec\5> \2\u00ec\u00ed\5D#\2\u00ed"+
		"-\3\2\2\2\u00ee\u00f0\5\60\31\2\u00ef\u00ee\3\2\2\2\u00f0\u00f1\3\2\2"+
		"\2\u00f1\u00ef\3\2\2\2\u00f1\u00f2\3\2\2\2\u00f2/\3\2\2\2\u00f3\u00f4"+
		"\t\6\2\2\u00f4\u00f5\7\34\2\2\u00f5\u00f6\5X-\2\u00f6\u00f8\7\n\2\2\u00f7"+
		"\u00f9\5N(\2\u00f8\u00f7\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\61\3\2\2\2"+
		"\u00fa\u00fb\7B\2\2\u00fb\u00fe\7U\2\2\u00fc\u00fd\7I\2\2\u00fd\u00ff"+
		"\5b\62\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\3\2\2\2\u0100"+
		"\u0102\5\64\33\2\u0101\u0100\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3"+
		"\2\2\2\u0103\u0104\5f\64\2\u0104\u0105\5\66\34\2\u0105\63\3\2\2\2\u0106"+
		"\u0107\7C\2\2\u0107\u0108\7\34\2\2\u0108\u010d\58\35\2\u0109\u010a\7\5"+
		"\2\2\u010a\u010c\58\35\2\u010b\u0109\3\2\2\2\u010c\u010f\3\2\2\2\u010d"+
		"\u010b\3\2\2\2\u010d\u010e\3\2\2\2\u010e\65\3\2\2\2\u010f\u010d\3\2\2"+
		"\2\u0110\u0112\5<\37\2\u0111\u0110\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111"+
		"\3\2\2\2\u0113\u0114\3\2\2\2\u0114\67\3\2\2\2\u0115\u0113\3\2\2\2\u0116"+
		"\u011b\5:\36\2\u0117\u0118\7\5\2\2\u0118\u011a\5:\36\2\u0119\u0117\3\2"+
		"\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c"+
		"9\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u0129\7U\2\2\u011f\u0120\7\30\2\2"+
		"\u0120\u0125\7U\2\2\u0121\u0122\7\5\2\2\u0122\u0124\7U\2\2\u0123\u0121"+
		"\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126"+
		"\u0128\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u012a\7\31\2\2\u0129\u011f\3"+
		"\2\2\2\u0129\u012a\3\2\2\2\u012a;\3\2\2\2\u012b\u012c\7E\2\2\u012c\u012d"+
		"\7\64\2\2\u012d\u0132\58\35\2\u012e\u012f\7\5\2\2\u012f\u0131\58\35\2"+
		"\u0130\u012e\3\2\2\2\u0131\u0134\3\2\2\2\u0132\u0130\3\2\2\2\u0132\u0133"+
		"\3\2\2\2\u0133\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0137\5\\/\2\u0136"+
		"\u0135\3\2\2\2\u0137\u0138\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2"+
		"\2\2\u0139=\3\2\2\2\u013a\u013c\7G\2\2\u013b\u013d\7U\2\2\u013c\u013b"+
		"\3\2\2\2\u013c\u013d\3\2\2\2\u013d\u013f\3\2\2\2\u013e\u0140\5@!\2\u013f"+
		"\u013e\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0144\3\2\2\2\u0141\u0143\5B"+
		"\"\2\u0142\u0141\3\2\2\2\u0143\u0146\3\2\2\2\u0144\u0142\3\2\2\2\u0144"+
		"\u0145\3\2\2\2\u0145?\3\2\2\2\u0146\u0144\3\2\2\2\u0147\u0148\7F\2\2\u0148"+
		"\u014a\7\34\2\2\u0149\u014b\5\\/\2\u014a\u0149\3\2\2\2\u014b\u014c\3\2"+
		"\2\2\u014c\u014a\3\2\2\2\u014c\u014d\3\2\2\2\u014dA\3\2\2\2\u014e\u014f"+
		"\7\64\2\2\u014f\u0150\7U\2\2\u0150\u0152\7\34\2\2\u0151\u0153\5\\/\2\u0152"+
		"\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2"+
		"\2\2\u0155C\3\2\2\2\u0156\u0158\7A\2\2\u0157\u0159\5F$\2\u0158\u0157\3"+
		"\2\2\2\u0159\u015a\3\2\2\2\u015a\u0158\3\2\2\2\u015a\u015b\3\2\2\2\u015b"+
		"E\3\2\2\2\u015c\u015d\t\6\2\2\u015d\u0163\7\34\2\2\u015e\u0164\5J&\2\u015f"+
		"\u0160\5Z.\2\u0160\u0161\7\4\2\2\u0161\u0162\5H%\2\u0162\u0164\3\2\2\2"+
		"\u0163\u015e\3\2\2\2\u0163\u015f\3\2\2\2\u0164G\3\2\2\2\u0165\u0167\5"+
		"F$\2\u0166\u0165\3\2\2\2\u0167\u0168\3\2\2\2\u0168\u0166\3\2\2\2\u0168"+
		"\u0169\3\2\2\2\u0169I\3\2\2\2\u016a\u016b\t\7\2\2\u016b\u016c\7H\2\2\u016c"+
		"\u016e\5X-\2\u016d\u016f\5\"\22\2\u016e\u016d\3\2\2\2\u016e\u016f\3\2"+
		"\2\2\u016f\u0170\3\2\2\2\u0170\u0172\7\n\2\2\u0171\u0173\5L\'\2\u0172"+
		"\u0171\3\2\2\2\u0172\u0173\3\2\2\2\u0173\u0175\3\2\2\2\u0174\u0176\5N"+
		"(\2\u0175\u0174\3\2\2\2\u0175\u0176\3\2\2\2\u0176K\3\2\2\2\u0177\u0178"+
		"\7L\2\2\u0178\u0179\7U\2\2\u0179\u017a\7\n\2\2\u017aM\3\2\2\2\u017b\u017c"+
		"\7M\2\2\u017c\u017d\7\30\2\2\u017d\u017e\5X-\2\u017e\u017f\7\31\2\2\u017f"+
		"\u0180\7\n\2\2\u0180O\3\2\2\2\u0181\u0183\t\b\2\2\u0182\u0181\3\2\2\2"+
		"\u0183\u0184\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185\u0187"+
		"\3\2\2\2\u0186\u0188\5R*\2\u0187\u0186\3\2\2\2\u0187\u0188\3\2\2\2\u0188"+
		"\u01a2\3\2\2\2\u0189\u01a2\7(\2\2\u018a\u01a2\7)\2\2\u018b\u018d\7P\2"+
		"\2\u018c\u018e\5T+\2\u018d\u018c\3\2\2\2\u018d\u018e\3\2\2\2\u018e\u0190"+
		"\3\2\2\2\u018f\u0191\5R*\2\u0190\u018f\3\2\2\2\u0190\u0191\3\2\2\2\u0191"+
		"\u01a2\3\2\2\2\u0192\u0194\7Q\2\2\u0193\u0195\5T+\2\u0194\u0193\3\2\2"+
		"\2\u0194\u0195\3\2\2\2\u0195\u0197\3\2\2\2\u0196\u0198\5R*\2\u0197\u0196"+
		"\3\2\2\2\u0197\u0198\3\2\2\2\u0198\u01a2\3\2\2\2\u0199\u019b\7O\2\2\u019a"+
		"\u019c\5T+\2\u019b\u019a\3\2\2\2\u019b\u019c\3\2\2\2\u019c\u019e\3\2\2"+
		"\2\u019d\u019f\5R*\2\u019e\u019d\3\2\2\2\u019e\u019f\3\2\2\2\u019f\u01a2"+
		"\3\2\2\2\u01a0\u01a2\5V,\2\u01a1\u0182\3\2\2\2\u01a1\u0189\3\2\2\2\u01a1"+
		"\u018a\3\2\2\2\u01a1\u018b\3\2\2\2\u01a1\u0192\3\2\2\2\u01a1\u0199\3\2"+
		"\2\2\u01a1\u01a0\3\2\2\2\u01a2Q\3\2\2\2\u01a3\u01a4\t\t\2\2\u01a4\u01a5"+
		"\5P)\2\u01a5S\3\2\2\2\u01a6\u01a7\t\n\2\2\u01a7U\3\2\2\2\u01a8\u01a9\7"+
		"\32\2\2\u01a9\u01ae\t\13\2\2\u01aa\u01ab\7\5\2\2\u01ab\u01ad\t\13\2\2"+
		"\u01ac\u01aa\3\2\2\2\u01ad\u01b0\3\2\2\2\u01ae\u01ac\3\2\2\2\u01ae\u01af"+
		"\3\2\2\2\u01af\u01b1\3\2\2\2\u01b0\u01ae\3\2\2\2\u01b1\u01b2\7\33\2\2"+
		"\u01b2W\3\2\2\2\u01b3\u01b4\7%\2\2\u01b4\u01cd\5X-\2\u01b5\u01b6\7\30"+
		"\2\2\u01b6\u01b7\5X-\2\u01b7\u01ba\7\31\2\2\u01b8\u01b9\t\f\2\2\u01b9"+
		"\u01bb\5X-\2\u01ba\u01b8\3\2\2\2\u01ba\u01bb\3\2\2\2\u01bb\u01cd\3\2\2"+
		"\2\u01bc\u01bf\t\r\2\2\u01bd\u01be\t\16\2\2\u01be\u01c0\5P)\2\u01bf\u01bd"+
		"\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\u01c3\3\2\2\2\u01c1\u01c2\t\f\2\2\u01c2"+
		"\u01c4\5X-\2\u01c3\u01c1\3\2\2\2\u01c3\u01c4\3\2\2\2\u01c4\u01cd\3\2\2"+
		"\2\u01c5\u01c6\t\17\2\2\u01c6\u01c7\7\'\2\2\u01c7\u01ca\5V,\2\u01c8\u01c9"+
		"\t\f\2\2\u01c9\u01cb\5X-\2\u01ca\u01c8\3\2\2\2\u01ca\u01cb\3\2\2\2\u01cb"+
		"\u01cd\3\2\2\2\u01cc\u01b3\3\2\2\2\u01cc\u01b5\3\2\2\2\u01cc\u01bc\3\2"+
		"\2\2\u01cc\u01c5\3\2\2\2\u01cdY\3\2\2\2\u01ce\u01cf\t\20\2\2\u01cf[\3"+
		"\2\2\2\u01d0\u01d1\t\21\2\2\u01d1\u01d4\7\34\2\2\u01d2\u01d5\7Z\2\2\u01d3"+
		"\u01d5\5^\60\2\u01d4\u01d2\3\2\2\2\u01d4\u01d3\3\2\2\2\u01d5\u01da\3\2"+
		"\2\2\u01d6\u01d7\7 \2\2\u01d7\u01d8\5P)\2\u01d8\u01d9\7\n\2\2\u01d9\u01db"+
		"\3\2\2\2\u01da\u01d6\3\2\2\2\u01da\u01db\3\2\2\2\u01db]\3\2\2\2\u01dc"+
		"\u01de\t\22\2\2\u01dd\u01df\5`\61\2\u01de\u01dd\3\2\2\2\u01de\u01df\3"+
		"\2\2\2\u01df\u01e6\3\2\2\2\u01e0\u01e6\7U\2\2\u01e1\u01e2\7\13\2\2\u01e2"+
		"\u01e6\5V,\2\u01e3\u01e4\7\25\2\2\u01e4\u01e6\5V,\2\u01e5\u01dc\3\2\2"+
		"\2\u01e5\u01e0\3\2\2\2\u01e5\u01e1\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6_"+
		"\3\2\2\2\u01e7\u01e8\7\26\2\2\u01e8\u01e9\7S\2\2\u01e9\u01f0\7\27\2\2"+
		"\u01ea\u01eb\7\26\2\2\u01eb\u01ec\t\4\2\2\u01ec\u01ed\7\35\2\2\u01ed\u01ee"+
		"\t\4\2\2\u01ee\u01f0\7\27\2\2\u01ef\u01e7\3\2\2\2\u01ef\u01ea\3\2\2\2"+
		"\u01f0a\3\2\2\2\u01f1\u01f2\7Z\2\2\u01f2c\3\2\2\2\u01f3\u01f4\7>\2\2\u01f4"+
		"\u01f6\7\34\2\2\u01f5\u01f7\5\\/\2\u01f6\u01f5\3\2\2\2\u01f7\u01f8\3\2"+
		"\2\2\u01f8\u01f6\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9e\3\2\2\2\u01fa\u01fc"+
		"\7D\2\2\u01fb\u01fd\5\\/\2\u01fc\u01fb\3\2\2\2\u01fd\u01fe\3\2\2\2\u01fe"+
		"\u01fc\3\2\2\2\u01fe\u01ff\3\2\2\2\u01ffg\3\2\2\2\67n\u0085\u008a\u008f"+
		"\u009d\u00c0\u00d1\u00da\u00e2\u00f1\u00f8\u00fe\u0101\u010d\u0113\u011b"+
		"\u0125\u0129\u0132\u0138\u013c\u013f\u0144\u014c\u0154\u015a\u0163\u0168"+
		"\u016e\u0172\u0175\u0184\u0187\u018d\u0190\u0194\u0197\u019b\u019e\u01a1"+
		"\u01ae\u01ba\u01bf\u01c3\u01ca\u01cc\u01d4\u01da\u01de\u01e5\u01ef\u01f8"+
		"\u01fe";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}