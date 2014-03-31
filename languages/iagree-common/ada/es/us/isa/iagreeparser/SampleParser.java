// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g 2013-07-15 16:30:16

  package es.us.isa.iagreeparser;
  import java.util.Calendar;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SampleParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "END_TEMPLATE", "END_AG_OFFER", "COMMENT_LINE", "WS", "CA", "CC", "PA", "PC", "LLA", "LLC", "DP", "RANGE_SEPARATOR", "MENOR", "MAYOR", "IGUAL", "MENOR_IGUAL", "MAYOR_IGUAL", "AND", "OR", "NOT", "IMPLIES", "BELONGS", "TRUE", "FALSE", "EXCEPT", "DURING", "ON", "FROM", "END", "TEMPLATE", "AG_OFFER", "FOR", "AS", "INITIATOR", "RESPONDER", "SERVICEPROVIDER", "EXPIRATIONTIME", "DATEFORMAT", "GMTZONE", "GLOBALPERIOD", "DEFINEDPERIOD", "METRICS", "AGREEMENT_TERMS", "CREATION_CONSTRAINTS", "GUARANTEE_TERMS", "SERVICE", "FEATURES", "GLOBALDESCRIPTION", "DESCRIPTION", "GLOBAL", "MONITORABLEPROPERTIES", "GUARANTEES", "AVAL_AT", "PROVIDER", "CONSUMER", "UPON", "ONLY_IF", "LETTER", "DIGIT", "INT", "SINT", "FLOAT", "SFLOAT", "LABEL", "RANGE", "VERSION", "VALUE", "IDENT", "ACCESS", "DATE", "HOUR", "STRING", "'version'", "';'", "','", "'of'", "'+'", "'-'", "'*'", "'/'", "'%'", "'min'", "'exactly one'", "'one or more'", "'all'", "'boolean'", "'integer'", "'float'", "'natural'", "'number'", "'set'", "'enum'"
    };
    public static final int LETTER=61;
    public static final int DP=14;
    public static final int SINT=64;
    public static final int NOT=23;
    public static final int END_TEMPLATE=4;
    public static final int EXCEPT=28;
    public static final int EOF=-1;
    public static final int MENOR_IGUAL=19;
    public static final int RANGE_SEPARATOR=15;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int T__92=92;
    public static final int T__90=90;
    public static final int DESCRIPTION=52;
    public static final int AGREEMENT_TERMS=46;
    public static final int END_AG_OFFER=5;
    public static final int T__95=95;
    public static final int DEFINEDPERIOD=44;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int IMPLIES=24;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int AG_OFFER=34;
    public static final int ON=30;
    public static final int INT=63;
    public static final int SFLOAT=66;
    public static final int VALUE=70;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int METRICS=45;
    public static final int T__89=89;
    public static final int T__88=88;
    public static final int CONSUMER=58;
    public static final int WS=7;
    public static final int SERVICE=49;
    public static final int OR=22;
    public static final int MAYOR=17;
    public static final int IGUAL=18;
    public static final int DURING=29;
    public static final int T__76=76;
    public static final int FROM=31;
    public static final int END=32;
    public static final int FALSE=27;
    public static final int PA=10;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int PC=11;
    public static final int T__77=77;
    public static final int MAYOR_IGUAL=20;
    public static final int MENOR=16;
    public static final int GUARANTEES=55;
    public static final int GLOBALDESCRIPTION=51;
    public static final int FOR=35;
    public static final int FLOAT=65;
    public static final int VERSION=69;
    public static final int AND=21;
    public static final int MONITORABLEPROPERTIES=54;
    public static final int DATEFORMAT=41;
    public static final int AS=36;
    public static final int ACCESS=72;
    public static final int IDENT=71;
    public static final int GUARANTEE_TERMS=48;
    public static final int ONLY_IF=60;
    public static final int DIGIT=62;
    public static final int RESPONDER=38;
    public static final int PROVIDER=57;
    public static final int GLOBALPERIOD=43;
    public static final int FEATURES=50;
    public static final int CA=8;
    public static final int SERVICEPROVIDER=39;
    public static final int AVAL_AT=56;
    public static final int UPON=59;
    public static final int RANGE=68;
    public static final int HOUR=74;
    public static final int TRUE=26;
    public static final int COMMENT_LINE=6;
    public static final int EXPIRATIONTIME=40;
    public static final int INITIATOR=37;
    public static final int TEMPLATE=33;
    public static final int LABEL=67;
    public static final int GMTZONE=42;
    public static final int CREATION_CONSTRAINTS=47;
    public static final int LLC=13;
    public static final int LLA=12;
    public static final int CC=9;
    public static final int DATE=73;
    public static final int GLOBAL=53;
    public static final int BELONGS=25;
    public static final int STRING=75;

    // delegates
    // delegators


        public SampleParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SampleParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return SampleParser.tokenNames; }
    public String getGrammarFileName() { return "C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g"; }



    	//Global vars:
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
    	
    	public String withoutQuotes(String s) {
    		String str = s;
    		if (str.startsWith("\""))
          {
              str = str.substring(1, str.length());
          }
          if (str.endsWith("\""))
          {
              str = str.substring(0, str.length() - 1);
          }
          return str;
        }
        
        public String convertEntities(String s) {
        	String str = s;
        	str = str.replaceAll("<","&lt;");
        	str = str.replaceAll(">","&gt;");
        	return str;
        }
        
        public String convertMetricType(String originalType) {
        	String newType = originalType;
        	
        	if(originalType!=null) {
        		newType = newType.toLowerCase();
        		
    	    	if( 	 originalType.equals("float")
    	    			|| originalType.equals("double")
    	    			|| originalType.equals("natural")
    	    			|| originalType.equals("number")
    	    			|| originalType.equals("cost")
    	    			|| originalType.equals("time")
    	    			|| originalType.equals("size")
    	    			|| originalType.equals("errors")
    	    			|| originalType.equals("money")
    	    			|| originalType.equals("percent")
    	    			|| originalType.equals("integer")
    	    			|| originalType.equals("string")
    	    			)
    	    	{
    	    		newType = "integer";
    	    	}else{
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
    	



    // $ANTLR start "entry"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:98:1: entry returns [String wsag] : ( template END_TEMPLATE | agOffer END_AG_OFFER );
    public final String entry() throws RecognitionException {
        String wsag = null;

        String template1 = null;

        String agOffer2 = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:99:5: ( template END_TEMPLATE | agOffer END_AG_OFFER )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==TEMPLATE) ) {
                alt1=1;
            }
            else if ( (LA1_0==AG_OFFER) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:99:7: template END_TEMPLATE
                    {
                    pushFollow(FOLLOW_template_in_entry59);
                    template1=template();

                    state._fsp--;

                    match(input,END_TEMPLATE,FOLLOW_END_TEMPLATE_in_entry61); 
                    wsag = xmlHeader + template1;

                    }
                    break;
                case 2 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:100:7: agOffer END_AG_OFFER
                    {
                    pushFollow(FOLLOW_agOffer_in_entry71);
                    agOffer2=agOffer();

                    state._fsp--;

                    match(input,END_AG_OFFER,FOLLOW_END_AG_OFFER_in_entry73); 
                    wsag = xmlHeader + agOffer2;

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return wsag;
    }
    // $ANTLR end "entry"


    // $ANTLR start "template"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:215:1: template returns [String result] : TEMPLATE IDENT 'version' version template_def ;
    public final String template() throws RecognitionException {
        String result = null;

        Token IDENT3=null;
        String version4 = null;

        String template_def5 = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:216:5: ( TEMPLATE IDENT 'version' version template_def )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:216:7: TEMPLATE IDENT 'version' version template_def
            {
            match(input,TEMPLATE,FOLLOW_TEMPLATE_in_template854); 
            IDENT3=(Token)match(input,IDENT,FOLLOW_IDENT_in_template856); 
            match(input,76,FOLLOW_76_in_template858); 
            pushFollow(FOLLOW_version_in_template860);
            version4=version();

            state._fsp--;

            metric = (IDENT3!=null?IDENT3.getText():null)+"_"+Calendar.getInstance().getTimeInMillis();
            pushFollow(FOLLOW_template_def_in_template864);
            template_def5=template_def();

            state._fsp--;


            					result = "<wsag:Template wsag:TemplateId=\""+version4+"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"  \n" + 
            				" xmlns:wsag=\"http://schemas.ggf.org/graap/2007/03/ws-agreement\" \n" + 
            				" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" \n" + 
            				" xsi:schemaLocation=\"http://schemas.ggf.org/graap/2007/03/wsagreement\" \n" + 
            				" agreement_types.xsd=\"http://www.w3.org/2001/XMLSchema XMLSchema.xsd\" >\n"+
            										"	<wsag:Name >"+(IDENT3!=null?IDENT3.getText():null)+"</wsag:Name>\n"+
            										template_def5+
            										"</wsag:Template>";
            				

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "template"


    // $ANTLR start "agOffer"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:228:1: agOffer returns [String result] : AG_OFFER i1= IDENT 'version' v1= version FOR i2= IDENT 'version' v2= version ag_def ;
    public final String agOffer() throws RecognitionException {
        String result = null;

        Token i1=null;
        Token i2=null;
        String v1 = null;

        String v2 = null;

        String ag_def6 = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:229:5: ( AG_OFFER i1= IDENT 'version' v1= version FOR i2= IDENT 'version' v2= version ag_def )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:229:7: AG_OFFER i1= IDENT 'version' v1= version FOR i2= IDENT 'version' v2= version ag_def
            {
            match(input,AG_OFFER,FOLLOW_AG_OFFER_in_agOffer890); 
            i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_agOffer894); 
            match(input,76,FOLLOW_76_in_agOffer896); 
            pushFollow(FOLLOW_version_in_agOffer900);
            v1=version();

            state._fsp--;

            match(input,FOR,FOLLOW_FOR_in_agOffer902); 
            i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_agOffer906); 
            match(input,76,FOLLOW_76_in_agOffer908); 
            pushFollow(FOLLOW_version_in_agOffer912);
            v2=version();

            state._fsp--;


            					metric = (i1!=null?i1.getText():null)+"_"+Calendar.getInstance().getTimeInMillis();
            					
            					agg_template = "		<wsag:TemplateId>"+v2+"</wsag:TemplateId>\n";
            					agg_temId = "		<wsag:TemplateName>"+(i2!=null?i2.getText():null)+"</wsag:TemplateName>\n";
            				
            pushFollow(FOLLOW_ag_def_in_agOffer920);
            ag_def6=ag_def();

            state._fsp--;


            					result = "<wsag:AgreementOffer wsag:AgreementId=\""+v1+"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"  \n" + 
            				" xmlns:wsag=\"http://schemas.ggf.org/graap/2007/03/ws-agreement\" \n" + 
            				" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" \n" + 
            				" xsi:schemaLocation=\"http://schemas.ggf.org/graap/2007/03/wsagreement\" \n" + 
            				" agreement_types.xsd=\"http://www.w3.org/2001/XMLSchema XMLSchema.xsd\" >\n"+
            										"	<wsag:Name >"+(i1!=null?i1.getText():null)+"</wsag:Name>\n"+
            										ag_def6+
            										"</wsag:AgreementOffer>";
            				

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "agOffer"


    // $ANTLR start "version"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:247:1: version returns [String result] : ( VERSION | FLOAT );
    public final String version() throws RecognitionException {
        String result = null;

        Token VERSION7=null;
        Token FLOAT8=null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:248:5: ( VERSION | FLOAT )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==VERSION) ) {
                alt2=1;
            }
            else if ( (LA2_0==FLOAT) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:248:7: VERSION
                    {
                    VERSION7=(Token)match(input,VERSION,FOLLOW_VERSION_in_version942); 
                    result = (VERSION7!=null?VERSION7.getText():null);

                    }
                    break;
                case 2 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:249:7: FLOAT
                    {
                    FLOAT8=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_version952); 
                    result = (FLOAT8!=null?FLOAT8.getText():null);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "version"


    // $ANTLR start "template_def"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:253:1: template_def returns [String result] : ( temp_properties )* agreementTerms ( creationConstraints )? ;
    public final String template_def() throws RecognitionException {
        String result = null;

        String agreementTerms9 = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:254:5: ( ( temp_properties )* agreementTerms ( creationConstraints )? )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:254:7: ( temp_properties )* agreementTerms ( creationConstraints )?
            {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:254:7: ( temp_properties )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==INITIATOR||(LA3_0>=SERVICEPROVIDER && LA3_0<=METRICS)||(LA3_0>=PROVIDER && LA3_0<=CONSUMER)||LA3_0==IDENT) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:254:7: temp_properties
            	    {
            	    pushFollow(FOLLOW_temp_properties_in_template_def976);
            	    temp_properties();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            pushFollow(FOLLOW_agreementTerms_in_template_def980);
            agreementTerms9=agreementTerms();

            state._fsp--;

            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:254:40: ( creationConstraints )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==CREATION_CONSTRAINTS) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:254:40: creationConstraints
                    {
                    pushFollow(FOLLOW_creationConstraints_in_template_def982);
                    creationConstraints();

                    state._fsp--;


                    }
                    break;

            }


            						result = "	<wsag:Context >\n"+
            													context +
            											"\n	</wsag:Context >\n\n"+
            											
            											"	<wsag:Terms wsag:Name=\""+serviceName+"\">\n		<wsag:All >\n"+
            											 		agreementTerms9 +
            											"\n		</wsag:All >\n	</wsag:Terms >\n\n"+
            											
            											"	<wsag:CreationConstraints >\n"+
            													cc +
            											"	</wsag:CreationConstraints >\n";
            					

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "template_def"


    // $ANTLR start "ag_def"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:270:1: ag_def returns [String result] : ( temp_properties )* agreementTerms ;
    public final String ag_def() throws RecognitionException {
        String result = null;

        String agreementTerms10 = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:271:5: ( ( temp_properties )* agreementTerms )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:271:7: ( temp_properties )* agreementTerms
            {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:271:7: ( temp_properties )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==INITIATOR||(LA5_0>=SERVICEPROVIDER && LA5_0<=METRICS)||(LA5_0>=PROVIDER && LA5_0<=CONSUMER)||LA5_0==IDENT) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:271:7: temp_properties
            	    {
            	    pushFollow(FOLLOW_temp_properties_in_ag_def1011);
            	    temp_properties();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            pushFollow(FOLLOW_agreementTerms_in_ag_def1015);
            agreementTerms10=agreementTerms();

            state._fsp--;


            						result = "	<wsag:Context >\n"+
            													agg_template+
            													agg_temId+
            													context +
            											"\n	</wsag:Context >\n\n"+
            											
            											"	<wsag:Terms wsag:Name=\""+serviceName+"\">\n		<wsag:All >\n"+
            											 		agreementTerms10 +
            											"\n		</wsag:All >\n	</wsag:Terms >\n\n";
            					

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "ag_def"


    // $ANTLR start "temp_properties"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:285:1: temp_properties : ( initiator_prop | responder_prop | serviceProvider_prop | expirationTime_prop | dateFormat_prop | gmtZone_prop | globalPeriod_prop | definedPeriod_prop | metrics_prop );
    public final void temp_properties() throws RecognitionException {
        String initiator_prop11 = null;

        String responder_prop12 = null;

        String serviceProvider_prop13 = null;

        String expirationTime_prop14 = null;

        String dateFormat_prop15 = null;

        String gmtZone_prop16 = null;

        String globalPeriod_prop17 = null;

        String definedPeriod_prop18 = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:286:5: ( initiator_prop | responder_prop | serviceProvider_prop | expirationTime_prop | dateFormat_prop | gmtZone_prop | globalPeriod_prop | definedPeriod_prop | metrics_prop )
            int alt6=9;
            switch ( input.LA(1) ) {
            case INITIATOR:
                {
                alt6=1;
                }
                break;
            case PROVIDER:
            case CONSUMER:
            case IDENT:
                {
                alt6=2;
                }
                break;
            case SERVICEPROVIDER:
                {
                alt6=3;
                }
                break;
            case EXPIRATIONTIME:
                {
                alt6=4;
                }
                break;
            case DATEFORMAT:
                {
                alt6=5;
                }
                break;
            case GMTZONE:
                {
                alt6=6;
                }
                break;
            case GLOBALPERIOD:
                {
                alt6=7;
                }
                break;
            case DEFINEDPERIOD:
                {
                alt6=8;
                }
                break;
            case METRICS:
                {
                alt6=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:286:7: initiator_prop
                    {
                    pushFollow(FOLLOW_initiator_prop_in_temp_properties1039);
                    initiator_prop11=initiator_prop();

                    state._fsp--;

                     context += "		<wsag:AgreementInitiator >" + initiator_prop11 + "</wsag:AgreementInitiator >\n"; 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:287:7: responder_prop
                    {
                    pushFollow(FOLLOW_responder_prop_in_temp_properties1049);
                    responder_prop12=responder_prop();

                    state._fsp--;

                     context += "		<wsag:AgreementResponder >" + responder_prop12 + "</wsag:AgreementResponder >\n"; 

                    }
                    break;
                case 3 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:288:7: serviceProvider_prop
                    {
                    pushFollow(FOLLOW_serviceProvider_prop_in_temp_properties1059);
                    serviceProvider_prop13=serviceProvider_prop();

                    state._fsp--;

                     context += "		<wsag:ServiceProvider >" + serviceProvider_prop13 + "</wsag:ServiceProvider >\n"; 

                    }
                    break;
                case 4 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:289:7: expirationTime_prop
                    {
                    pushFollow(FOLLOW_expirationTime_prop_in_temp_properties1069);
                    expirationTime_prop14=expirationTime_prop();

                    state._fsp--;

                     context += "		<wsag:ExpirationTime >" + expirationTime_prop14 + "</wsag:ExpirationTime >\n"; 

                    }
                    break;
                case 5 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:290:7: dateFormat_prop
                    {
                    pushFollow(FOLLOW_dateFormat_prop_in_temp_properties1079);
                    dateFormat_prop15=dateFormat_prop();

                    state._fsp--;

                     context += "		<twsag4people:DateFormat >" + withoutQuotes(dateFormat_prop15) + "</twsag4people:DateFormat >\n"; 

                    }
                    break;
                case 6 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:291:7: gmtZone_prop
                    {
                    pushFollow(FOLLOW_gmtZone_prop_in_temp_properties1089);
                    gmtZone_prop16=gmtZone_prop();

                    state._fsp--;

                     context += "		<wsag:GMTZone >" + gmtZone_prop16 + "</wsag:GMTZone >\n"; 

                    }
                    break;
                case 7 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:292:7: globalPeriod_prop
                    {
                    pushFollow(FOLLOW_globalPeriod_prop_in_temp_properties1099);
                    globalPeriod_prop17=globalPeriod_prop();

                    state._fsp--;

                     context += "		<twsag4people:GlobalPeriod >" + globalPeriod_prop17 + "</twsag4people:GlobalPeriod >\n"; 

                    }
                    break;
                case 8 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:293:7: definedPeriod_prop
                    {
                    pushFollow(FOLLOW_definedPeriod_prop_in_temp_properties1109);
                    definedPeriod_prop18=definedPeriod_prop();

                    state._fsp--;

                     context += "		<twsag4people:DefinedValidityPeriodSet >" + definedPeriod_prop18 + "</twsag4people:DefinedValidityPeriodSet >\n"; 

                    }
                    break;
                case 9 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:294:7: metrics_prop
                    {
                    pushFollow(FOLLOW_metrics_prop_in_temp_properties1119);
                    metrics_prop();

                    state._fsp--;


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "temp_properties"


    // $ANTLR start "initiator_prop"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:298:1: initiator_prop returns [String result] : INITIATOR DP STRING ;
    public final String initiator_prop() throws RecognitionException {
        String result = null;

        Token STRING19=null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:299:5: ( INITIATOR DP STRING )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:299:7: INITIATOR DP STRING
            {
            match(input,INITIATOR,FOLLOW_INITIATOR_in_initiator_prop1143); 
            match(input,DP,FOLLOW_DP_in_initiator_prop1145); 
            STRING19=(Token)match(input,STRING,FOLLOW_STRING_in_initiator_prop1147); 
             result = withoutQuotes((STRING19!=null?STRING19.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "initiator_prop"


    // $ANTLR start "responder_prop"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:302:1: responder_prop returns [String result] : target= ( PROVIDER | CONSUMER | IDENT ) AS RESPONDER ;
    public final String responder_prop() throws RecognitionException {
        String result = null;

        Token target=null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:303:5: (target= ( PROVIDER | CONSUMER | IDENT ) AS RESPONDER )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:303:7: target= ( PROVIDER | CONSUMER | IDENT ) AS RESPONDER
            {
            target=(Token)input.LT(1);
            if ( (input.LA(1)>=PROVIDER && input.LA(1)<=CONSUMER)||input.LA(1)==IDENT ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            match(input,AS,FOLLOW_AS_in_responder_prop1188); 
            match(input,RESPONDER,FOLLOW_RESPONDER_in_responder_prop1190); 
             result = (target!=null?target.getText():null);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "responder_prop"


    // $ANTLR start "serviceProvider_prop"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:306:1: serviceProvider_prop returns [String result] : SERVICEPROVIDER DP STRING ;
    public final String serviceProvider_prop() throws RecognitionException {
        String result = null;

        Token STRING20=null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:307:5: ( SERVICEPROVIDER DP STRING )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:307:8: SERVICEPROVIDER DP STRING
            {
            match(input,SERVICEPROVIDER,FOLLOW_SERVICEPROVIDER_in_serviceProvider_prop1219); 
            match(input,DP,FOLLOW_DP_in_serviceProvider_prop1221); 
            STRING20=(Token)match(input,STRING,FOLLOW_STRING_in_serviceProvider_prop1223); 
             result = withoutQuotes((STRING20!=null?STRING20.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "serviceProvider_prop"


    // $ANTLR start "expirationTime_prop"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:310:1: expirationTime_prop returns [String result] : EXPIRATIONTIME DP STRING ;
    public final String expirationTime_prop() throws RecognitionException {
        String result = null;

        Token STRING21=null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:311:5: ( EXPIRATIONTIME DP STRING )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:311:7: EXPIRATIONTIME DP STRING
            {
            match(input,EXPIRATIONTIME,FOLLOW_EXPIRATIONTIME_in_expirationTime_prop1250); 
            match(input,DP,FOLLOW_DP_in_expirationTime_prop1252); 
            STRING21=(Token)match(input,STRING,FOLLOW_STRING_in_expirationTime_prop1254); 
             result = withoutQuotes((STRING21!=null?STRING21.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "expirationTime_prop"


    // $ANTLR start "dateFormat_prop"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:314:1: dateFormat_prop returns [String result] : DATEFORMAT DP STRING ;
    public final String dateFormat_prop() throws RecognitionException {
        String result = null;

        Token STRING22=null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:315:5: ( DATEFORMAT DP STRING )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:315:7: DATEFORMAT DP STRING
            {
            match(input,DATEFORMAT,FOLLOW_DATEFORMAT_in_dateFormat_prop1281); 
            match(input,DP,FOLLOW_DP_in_dateFormat_prop1283); 
            STRING22=(Token)match(input,STRING,FOLLOW_STRING_in_dateFormat_prop1285); 
             result = withoutQuotes((STRING22!=null?STRING22.getText():null));

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "dateFormat_prop"


    // $ANTLR start "gmtZone_prop"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:318:1: gmtZone_prop returns [String result] : GMTZONE DP zone= ( SINT | INT ) ;
    public final String gmtZone_prop() throws RecognitionException {
        String result = null;

        Token zone=null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:319:5: ( GMTZONE DP zone= ( SINT | INT ) )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:319:7: GMTZONE DP zone= ( SINT | INT )
            {
            match(input,GMTZONE,FOLLOW_GMTZONE_in_gmtZone_prop1312); 
            match(input,DP,FOLLOW_DP_in_gmtZone_prop1314); 
            zone=(Token)input.LT(1);
            if ( (input.LA(1)>=INT && input.LA(1)<=SINT) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             result = (zone!=null?zone.getText():null);

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "gmtZone_prop"


    // $ANTLR start "globalPeriod_prop"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:322:1: globalPeriod_prop returns [String result] : GLOBALPERIOD DP datePeriod_def ;
    public final String globalPeriod_prop() throws RecognitionException {
        String result = null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:323:5: ( GLOBALPERIOD DP datePeriod_def )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:323:7: GLOBALPERIOD DP datePeriod_def
            {
            match(input,GLOBALPERIOD,FOLLOW_GLOBALPERIOD_in_globalPeriod_prop1351); 
            match(input,DP,FOLLOW_DP_in_globalPeriod_prop1353); 
            pushFollow(FOLLOW_datePeriod_def_in_globalPeriod_prop1355);
            datePeriod_def();

            state._fsp--;

            result = "";

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "globalPeriod_prop"


    // $ANTLR start "definedPeriod_prop"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:326:1: definedPeriod_prop returns [String result] : DEFINEDPERIOD DP ( period )+ ;
    public final String definedPeriod_prop() throws RecognitionException {
        String result = null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:327:5: ( DEFINEDPERIOD DP ( period )+ )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:327:7: DEFINEDPERIOD DP ( period )+
            {
            match(input,DEFINEDPERIOD,FOLLOW_DEFINEDPERIOD_in_definedPeriod_prop1382); 
            match(input,DP,FOLLOW_DP_in_definedPeriod_prop1384); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:327:24: ( period )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==IDENT) ) {
                    int LA7_2 = input.LA(2);

                    if ( (LA7_2==DP) ) {
                        alt7=1;
                    }


                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:327:24: period
            	    {
            	    pushFollow(FOLLOW_period_in_definedPeriod_prop1386);
            	    period();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt7 >= 1 ) break loop7;
                        EarlyExitException eee =
                            new EarlyExitException(7, input);
                        throw eee;
                }
                cnt7++;
            } while (true);

            result = "";

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "definedPeriod_prop"


    // $ANTLR start "datePeriod_def"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:333:1: datePeriod_def returns [String result] : DURING DATE RANGE_SEPARATOR DATE ;
    public final String datePeriod_def() throws RecognitionException {
        String result = null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:334:5: ( DURING DATE RANGE_SEPARATOR DATE )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:334:7: DURING DATE RANGE_SEPARATOR DATE
            {
            match(input,DURING,FOLLOW_DURING_in_datePeriod_def1421); 
            match(input,DATE,FOLLOW_DATE_in_datePeriod_def1423); 
            match(input,RANGE_SEPARATOR,FOLLOW_RANGE_SEPARATOR_in_datePeriod_def1425); 
            match(input,DATE,FOLLOW_DATE_in_datePeriod_def1427); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "datePeriod_def"


    // $ANTLR start "temporality"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:338:1: temporality returns [String result] : ON IDENT ;
    public final String temporality() throws RecognitionException {
        String result = null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:339:5: ( ON IDENT )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:339:7: ON IDENT
            {
            match(input,ON,FOLLOW_ON_in_temporality1449); 
            match(input,IDENT,FOLLOW_IDENT_in_temporality1451); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "temporality"


    // $ANTLR start "period"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:342:1: period returns [String result] : IDENT DP period_def ( ( EXCEPT | AND ) period_def )* ;
    public final String period() throws RecognitionException {
        String result = null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:343:5: ( IDENT DP period_def ( ( EXCEPT | AND ) period_def )* )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:343:7: IDENT DP period_def ( ( EXCEPT | AND ) period_def )*
            {
            match(input,IDENT,FOLLOW_IDENT_in_period1472); 
            match(input,DP,FOLLOW_DP_in_period1474); 
            pushFollow(FOLLOW_period_def_in_period1476);
            period_def();

            state._fsp--;

            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:343:27: ( ( EXCEPT | AND ) period_def )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==AND||LA8_0==EXCEPT) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:343:28: ( EXCEPT | AND ) period_def
            	    {
            	    if ( input.LA(1)==AND||input.LA(1)==EXCEPT ) {
            	        input.consume();
            	        state.errorRecovery=false;
            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        throw mse;
            	    }

            	    pushFollow(FOLLOW_period_def_in_period1485);
            	    period_def();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "period"


    // $ANTLR start "period_def"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:346:1: period_def returns [String result] : ( FROM HOUR '..' HOUR ( ON IDENT )? DURING DATE '..' DATE | IDENT | GLOBALPERIOD );
    public final String period_def() throws RecognitionException {
        String result = null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:347:5: ( FROM HOUR '..' HOUR ( ON IDENT )? DURING DATE '..' DATE | IDENT | GLOBALPERIOD )
            int alt10=3;
            switch ( input.LA(1) ) {
            case FROM:
                {
                alt10=1;
                }
                break;
            case IDENT:
                {
                alt10=2;
                }
                break;
            case GLOBALPERIOD:
                {
                alt10=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:347:7: FROM HOUR '..' HOUR ( ON IDENT )? DURING DATE '..' DATE
                    {
                    match(input,FROM,FOLLOW_FROM_in_period_def1508); 
                    match(input,HOUR,FOLLOW_HOUR_in_period_def1510); 
                    match(input,RANGE_SEPARATOR,FOLLOW_RANGE_SEPARATOR_in_period_def1512); 
                    match(input,HOUR,FOLLOW_HOUR_in_period_def1514); 
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:347:27: ( ON IDENT )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==ON) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:347:28: ON IDENT
                            {
                            match(input,ON,FOLLOW_ON_in_period_def1517); 
                            match(input,IDENT,FOLLOW_IDENT_in_period_def1519); 

                            }
                            break;

                    }

                    match(input,DURING,FOLLOW_DURING_in_period_def1523); 
                    match(input,DATE,FOLLOW_DATE_in_period_def1525); 
                    match(input,RANGE_SEPARATOR,FOLLOW_RANGE_SEPARATOR_in_period_def1527); 
                    match(input,DATE,FOLLOW_DATE_in_period_def1529); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:348:7: IDENT
                    {
                    match(input,IDENT,FOLLOW_IDENT_in_period_def1538); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:349:7: GLOBALPERIOD
                    {
                    match(input,GLOBALPERIOD,FOLLOW_GLOBALPERIOD_in_period_def1546); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "period_def"


    // $ANTLR start "agreementTerms"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:354:1: agreementTerms returns [String result] : AGREEMENT_TERMS agreementTerms_def ;
    public final String agreementTerms() throws RecognitionException {
        String result = null;

        String agreementTerms_def23 = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:355:5: ( AGREEMENT_TERMS agreementTerms_def )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:355:7: AGREEMENT_TERMS agreementTerms_def
            {
            match(input,AGREEMENT_TERMS,FOLLOW_AGREEMENT_TERMS_in_agreementTerms1572); 
            pushFollow(FOLLOW_agreementTerms_def_in_agreementTerms1574);
            agreementTerms_def23=agreementTerms_def();

            state._fsp--;


            //						result =
            //						"				<wsag:VariableSet >\n"+
            //						variablesSet+
            //						"				</wsag:VariableSet >\n";
            							result = agreementTerms_def23;
            					

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "agreementTerms"


    // $ANTLR start "creationConstraints"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:365:1: creationConstraints : CREATION_CONSTRAINTS creationConstraints_def ;
    public final void creationConstraints() throws RecognitionException {
        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:366:5: ( CREATION_CONSTRAINTS creationConstraints_def )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:366:7: CREATION_CONSTRAINTS creationConstraints_def
            {
            match(input,CREATION_CONSTRAINTS,FOLLOW_CREATION_CONSTRAINTS_in_creationConstraints1602); 
            pushFollow(FOLLOW_creationConstraints_def_in_creationConstraints1604);
            creationConstraints_def();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "creationConstraints"


    // $ANTLR start "agreementTerms_def"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:370:1: agreementTerms_def returns [String result] : service monitorableProperties guaranteeTerms ;
    public final String agreementTerms_def() throws RecognitionException {
        String result = null;

        String service24 = null;

        String monitorableProperties25 = null;

        String guaranteeTerms26 = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:371:5: ( service monitorableProperties guaranteeTerms )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:371:7: service monitorableProperties guaranteeTerms
            {
            pushFollow(FOLLOW_service_in_agreementTerms_def1626);
            service24=service();

            state._fsp--;

            pushFollow(FOLLOW_monitorableProperties_in_agreementTerms_def1628);
            monitorableProperties25=monitorableProperties();

            state._fsp--;

            pushFollow(FOLLOW_guaranteeTerms_in_agreementTerms_def1630);
            guaranteeTerms26=guaranteeTerms();

            state._fsp--;


            						result = service24
            										+ monitorableProperties25
            										+ guaranteeTerms26;
            						
            					

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "agreementTerms_def"


    // $ANTLR start "creationConstraints_def"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:380:1: creationConstraints_def returns [String result] : ( creationConstraint )+ ;
    public final String creationConstraints_def() throws RecognitionException {
        String result = null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:381:5: ( ( creationConstraint )+ )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:381:7: ( creationConstraint )+
            {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:381:7: ( creationConstraint )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==LABEL||LA11_0==IDENT) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:381:7: creationConstraint
            	    {
            	    pushFollow(FOLLOW_creationConstraint_in_creationConstraints_def1662);
            	    creationConstraint();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "creationConstraints_def"


    // $ANTLR start "creationConstraint"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:384:1: creationConstraint returns [String result] : etiq= ( LABEL | IDENT ) DP exp= expression ';' ( onlyif_sentence )? ;
    public final String creationConstraint() throws RecognitionException {
        String result = null;

        Token etiq=null;
        String exp = null;

        String onlyif_sentence27 = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:385:5: (etiq= ( LABEL | IDENT ) DP exp= expression ';' ( onlyif_sentence )? )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:385:7: etiq= ( LABEL | IDENT ) DP exp= expression ';' ( onlyif_sentence )?
            {
            etiq=(Token)input.LT(1);
            if ( input.LA(1)==LABEL||input.LA(1)==IDENT ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

            match(input,DP,FOLLOW_DP_in_creationConstraint1692); 
            pushFollow(FOLLOW_expression_in_creationConstraint1696);
            exp=expression();

            state._fsp--;

            match(input,77,FOLLOW_77_in_creationConstraint1698); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:385:48: ( onlyif_sentence )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==ONLY_IF) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:385:48: onlyif_sentence
                    {
                    pushFollow(FOLLOW_onlyif_sentence_in_creationConstraint1700);
                    onlyif_sentence27=onlyif_sentence();

                    state._fsp--;


                    }
                    break;

            }


            							String name = (etiq!=null?etiq.getText():null);
            							
            							cc += "		<wsag:Constraint >\n"+
            										"			<Name>"+name+"</Name>\n"+
            										"			<Content>";
            										
            							if(onlyif_sentence27!=null)
            								cc += onlyif_sentence27 + " IMPLIES ";
            								
            							cc += exp+"</Content>\n"+
            										"		</wsag:Constraint >\n";
            						

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "creationConstraint"


    // $ANTLR start "service"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:402:1: service returns [String result] : SERVICE id= IDENT ( AVAL_AT url )? ( features )? globalDescription descriptions ;
    public final String service() throws RecognitionException {
        String result = null;

        Token id=null;
        SampleParser.url_return url28 = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:403:5: ( SERVICE id= IDENT ( AVAL_AT url )? ( features )? globalDescription descriptions )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:403:7: SERVICE id= IDENT ( AVAL_AT url )? ( features )? globalDescription descriptions
            {
            match(input,SERVICE,FOLLOW_SERVICE_in_service1731); 
            id=(Token)match(input,IDENT,FOLLOW_IDENT_in_service1735); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:403:24: ( AVAL_AT url )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==AVAL_AT) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:403:25: AVAL_AT url
                    {
                    match(input,AVAL_AT,FOLLOW_AVAL_AT_in_service1738); 
                    pushFollow(FOLLOW_url_in_service1740);
                    url28=url();

                    state._fsp--;


                    }
                    break;

            }

            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:404:7: ( features )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==FEATURES) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:404:8: features
                    {
                    pushFollow(FOLLOW_features_in_service1751);
                    features();

                    state._fsp--;


                    }
                    break;

            }

            pushFollow(FOLLOW_globalDescription_in_service1761);
            globalDescription();

            state._fsp--;

            pushFollow(FOLLOW_descriptions_in_service1769);
            descriptions();

            state._fsp--;


            				  	String urlValue = (url28!=null?input.toString(url28.start,url28.stop):null);
            				  	
            				  		
            				  	
            				  	serviceName = (id!=null?id.getText():null);
            						String name = "SDT_"+serviceName;
            						if(id!=null)
            							name = (id!=null?id.getText():null);
            						
            						result =
            							"			<wsag:ServiceDescriptionTerm wsag:Name=\"SDT_"+name+"\" wsag:ServiceName=\""+serviceName+"\" >\n"+
            											offerItems+
            							"			</wsag:ServiceDescriptionTerm>\n\n";
            							
            //						if(urlValue!=null)
            //							result += "			<wsag:ServiceReference  wsag:Name=\""+(id!=null?id.getText():null)+"_SREF\" wsag:ServiceName=\""+(id!=null?id.getText():null)+"\" >"+urlValue+"</wsag:ServiceReference>\n\n";
            				  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "service"


    // $ANTLR start "features"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:427:1: features returns [String result] : FEATURES DP feature ( ',' feature )* ;
    public final String features() throws RecognitionException {
        String result = null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:428:5: ( FEATURES DP feature ( ',' feature )* )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:428:7: FEATURES DP feature ( ',' feature )*
            {
            match(input,FEATURES,FOLLOW_FEATURES_in_features1799); 
            match(input,DP,FOLLOW_DP_in_features1801); 
            pushFollow(FOLLOW_feature_in_features1803);
            feature();

            state._fsp--;

            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:428:27: ( ',' feature )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==78) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:428:28: ',' feature
            	    {
            	    match(input,78,FOLLOW_78_in_features1806); 
            	    pushFollow(FOLLOW_feature_in_features1808);
            	    feature();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "features"


    // $ANTLR start "descriptions"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:433:1: descriptions returns [String result] : ( description )* ;
    public final String descriptions() throws RecognitionException {
        String result = null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:433:38: ( ( description )* )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:433:40: ( description )*
            {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:433:40: ( description )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==DESCRIPTION) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:433:40: description
            	    {
            	    pushFollow(FOLLOW_description_in_descriptions1837);
            	    description();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "descriptions"


    // $ANTLR start "feature"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:435:1: feature returns [String result] : op ( ',' op )* ;
    public final String feature() throws RecognitionException {
        String result = null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:435:33: ( op ( ',' op )* )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:435:35: op ( ',' op )*
            {
            pushFollow(FOLLOW_op_in_feature1854);
            op();

            state._fsp--;

            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:435:38: ( ',' op )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==78) ) {
                    int LA17_1 = input.LA(2);

                    if ( (LA17_1==IDENT) ) {
                        alt17=1;
                    }


                }


                switch (alt17) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:435:39: ',' op
            	    {
            	    match(input,78,FOLLOW_78_in_feature1857); 
            	    pushFollow(FOLLOW_op_in_feature1859);
            	    op();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "feature"


    // $ANTLR start "op"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:441:1: op returns [String result] : IDENT ( PA IDENT ( ',' IDENT )* PC )? ;
    public final String op() throws RecognitionException {
        String result = null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:442:5: ( IDENT ( PA IDENT ( ',' IDENT )* PC )? )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:442:7: IDENT ( PA IDENT ( ',' IDENT )* PC )?
            {
            match(input,IDENT,FOLLOW_IDENT_in_op1885); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:442:13: ( PA IDENT ( ',' IDENT )* PC )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==PA) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:442:14: PA IDENT ( ',' IDENT )* PC
                    {
                    match(input,PA,FOLLOW_PA_in_op1888); 
                    match(input,IDENT,FOLLOW_IDENT_in_op1890); 
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:442:23: ( ',' IDENT )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==78) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:442:24: ',' IDENT
                    	    {
                    	    match(input,78,FOLLOW_78_in_op1893); 
                    	    match(input,IDENT,FOLLOW_IDENT_in_op1895); 

                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);

                    match(input,PC,FOLLOW_PC_in_op1900); 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "op"


    // $ANTLR start "description"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:445:1: description returns [String result] : DESCRIPTION FOR feature ( ',' feature )* ( key_value_prop )+ ;
    public final String description() throws RecognitionException {
        String result = null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:446:5: ( DESCRIPTION FOR feature ( ',' feature )* ( key_value_prop )+ )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:446:7: DESCRIPTION FOR feature ( ',' feature )* ( key_value_prop )+
            {
            match(input,DESCRIPTION,FOLLOW_DESCRIPTION_in_description1923); 
            match(input,FOR,FOLLOW_FOR_in_description1925); 
            pushFollow(FOLLOW_feature_in_description1927);
            feature();

            state._fsp--;

            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:446:31: ( ',' feature )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==78) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:446:32: ',' feature
            	    {
            	    match(input,78,FOLLOW_78_in_description1930); 
            	    pushFollow(FOLLOW_feature_in_description1932);
            	    feature();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:447:7: ( key_value_prop )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( ((LA21_0>=IDENT && LA21_0<=ACCESS)||(LA21_0>=89 && LA21_0<=90)) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:447:7: key_value_prop
            	    {
            	    pushFollow(FOLLOW_key_value_prop_in_description1942);
            	    key_value_prop();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "description"


    // $ANTLR start "monitorableProperties"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:450:1: monitorableProperties returns [String result] : MONITORABLEPROPERTIES ( IDENT )? ( global_MonitorableProperties )? ( local_MonitorableProperties )* ;
    public final String monitorableProperties() throws RecognitionException {
        String result = null;

        Token IDENT29=null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:451:5: ( MONITORABLEPROPERTIES ( IDENT )? ( global_MonitorableProperties )? ( local_MonitorableProperties )* )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:451:7: MONITORABLEPROPERTIES ( IDENT )? ( global_MonitorableProperties )? ( local_MonitorableProperties )*
            {
            match(input,MONITORABLEPROPERTIES,FOLLOW_MONITORABLEPROPERTIES_in_monitorableProperties1966); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:451:29: ( IDENT )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==IDENT) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:451:30: IDENT
                    {
                    IDENT29=(Token)match(input,IDENT,FOLLOW_IDENT_in_monitorableProperties1969); 

                    }
                    break;

            }

            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:451:38: ( global_MonitorableProperties )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==GLOBAL) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:451:38: global_MonitorableProperties
                    {
                    pushFollow(FOLLOW_global_MonitorableProperties_in_monitorableProperties1973);
                    global_MonitorableProperties();

                    state._fsp--;


                    }
                    break;

            }

            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:451:68: ( local_MonitorableProperties )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==FOR) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:451:68: local_MonitorableProperties
            	    {
            	    pushFollow(FOLLOW_local_MonitorableProperties_in_monitorableProperties1976);
            	    local_MonitorableProperties();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            						String name = (IDENT29!=null?IDENT29.getText():null);
            						if(name==null)
            							name = serviceName;
            						result =
            				  		"			<wsag:ServiceProperties wsag:Name=\"SP_"+name+"\" wsag:ServiceName=\""+name+"\">\n"+
            				  		"				<wsag:VariableSet >\n"+
            				  						variablesSet +
            				  		"				</wsag:VariableSet >\n"+
            				  		"			</wsag:ServiceProperties>\n\n";
            				  		
            					

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "monitorableProperties"


    // $ANTLR start "global_MonitorableProperties"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:466:1: global_MonitorableProperties : GLOBAL DP (kv= key_value_prop )+ ;
    public final void global_MonitorableProperties() throws RecognitionException {
        SampleParser.key_value_prop_return kv = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:467:5: ( GLOBAL DP (kv= key_value_prop )+ )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:467:7: GLOBAL DP (kv= key_value_prop )+
            {
            match(input,GLOBAL,FOLLOW_GLOBAL_in_global_MonitorableProperties2005); 
            match(input,DP,FOLLOW_DP_in_global_MonitorableProperties2007); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:467:17: (kv= key_value_prop )+
            int cnt25=0;
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=IDENT && LA25_0<=ACCESS)||(LA25_0>=89 && LA25_0<=90)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:467:18: kv= key_value_prop
            	    {
            	    pushFollow(FOLLOW_key_value_prop_in_global_MonitorableProperties2012);
            	    kv=key_value_prop();

            	    state._fsp--;


            	    //						offerItems += "				<OfferItem name=\""+(kv!=null?kv.key:null)+"\" wsag:Metric=\"metrics/"+metric+":"+(kv!=null?kv.value:null)+"\" ></OfferItem>\n";
            	    							variablesSet +=
            	    						"					<wsag:Variable  wsag:Name=\""+ (kv!=null?kv.key:null) +"\" wsag:Metric=\"metrics/"+metric+":"+(kv!=null?kv.value:null)+"\" >\n"+
            	    						"						<wsag:Location >/"+(kv!=null?kv.key:null)+"</wsag:Location>\n"+
            	    						"					</wsag:Variable >\n";
            	    					

            	    }
            	    break;

            	default :
            	    if ( cnt25 >= 1 ) break loop25;
                        EarlyExitException eee =
                            new EarlyExitException(25, input);
                        throw eee;
                }
                cnt25++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "global_MonitorableProperties"


    // $ANTLR start "local_MonitorableProperties"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:478:1: local_MonitorableProperties returns [String result] : FOR IDENT DP ( key_value_prop )+ ;
    public final String local_MonitorableProperties() throws RecognitionException {
        String result = null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:479:5: ( FOR IDENT DP ( key_value_prop )+ )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:479:7: FOR IDENT DP ( key_value_prop )+
            {
            match(input,FOR,FOLLOW_FOR_in_local_MonitorableProperties2052); 
            match(input,IDENT,FOLLOW_IDENT_in_local_MonitorableProperties2054); 
            match(input,DP,FOLLOW_DP_in_local_MonitorableProperties2056); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:479:20: ( key_value_prop )+
            int cnt26=0;
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( ((LA26_0>=IDENT && LA26_0<=ACCESS)||(LA26_0>=89 && LA26_0<=90)) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:479:20: key_value_prop
            	    {
            	    pushFollow(FOLLOW_key_value_prop_in_local_MonitorableProperties2058);
            	    key_value_prop();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "local_MonitorableProperties"


    // $ANTLR start "guaranteeTerms"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:482:1: guaranteeTerms returns [String result] : GUARANTEE_TERMS (g= guaranteeTerm )+ ;
    public final String guaranteeTerms() throws RecognitionException {
        String result = null;

        String g = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:483:5: ( GUARANTEE_TERMS (g= guaranteeTerm )+ )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:483:7: GUARANTEE_TERMS (g= guaranteeTerm )+
            {
            match(input,GUARANTEE_TERMS,FOLLOW_GUARANTEE_TERMS_in_guaranteeTerms2084); 
            result ="";
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:483:37: (g= guaranteeTerm )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==LABEL||LA27_0==IDENT) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:483:38: g= guaranteeTerm
            	    {
            	    pushFollow(FOLLOW_guaranteeTerm_in_guaranteeTerms2091);
            	    g=guaranteeTerm();

            	    state._fsp--;

            	    result += g;

            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "guaranteeTerms"


    // $ANTLR start "guaranteeTerm"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:486:1: guaranteeTerm returns [String result] : (name= LABEL | name= IDENT ) DP (gdef= guarantee_def | c= cuantif 'of' g_gterm= grouped_guaranteeTerm END ) ;
    public final String guaranteeTerm() throws RecognitionException {
        String result = null;

        Token name=null;
        SampleParser.guarantee_def_return gdef = null;

        String c = null;

        String g_gterm = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:487:5: ( (name= LABEL | name= IDENT ) DP (gdef= guarantee_def | c= cuantif 'of' g_gterm= grouped_guaranteeTerm END ) )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:487:7: (name= LABEL | name= IDENT ) DP (gdef= guarantee_def | c= cuantif 'of' g_gterm= grouped_guaranteeTerm END )
            {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:487:7: (name= LABEL | name= IDENT )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==LABEL) ) {
                alt28=1;
            }
            else if ( (LA28_0==IDENT) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:487:8: name= LABEL
                    {
                    name=(Token)match(input,LABEL,FOLLOW_LABEL_in_guaranteeTerm2124); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:487:19: name= IDENT
                    {
                    name=(Token)match(input,IDENT,FOLLOW_IDENT_in_guaranteeTerm2128); 

                    }
                    break;

            }

            match(input,DP,FOLLOW_DP_in_guaranteeTerm2131); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:487:34: (gdef= guarantee_def | c= cuantif 'of' g_gterm= grouped_guaranteeTerm END )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=PROVIDER && LA29_0<=CONSUMER)) ) {
                alt29=1;
            }
            else if ( ((LA29_0>=86 && LA29_0<=88)) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:487:35: gdef= guarantee_def
                    {
                    pushFollow(FOLLOW_guarantee_def_in_guaranteeTerm2136);
                    gdef=guarantee_def();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:487:56: c= cuantif 'of' g_gterm= grouped_guaranteeTerm END
                    {
                    pushFollow(FOLLOW_cuantif_in_guaranteeTerm2142);
                    c=cuantif();

                    state._fsp--;

                    match(input,79,FOLLOW_79_in_guaranteeTerm2144); 
                    pushFollow(FOLLOW_grouped_guaranteeTerm_in_guaranteeTerm2148);
                    g_gterm=grouped_guaranteeTerm();

                    state._fsp--;

                    match(input,END,FOLLOW_END_in_guaranteeTerm2150); 

                    }
                    break;

            }


            						if(c!=null) {
            							result =
            							"			<wsag:"+c+" >\n"+
            										g_gterm+
            							"			</wsag:"+c+" >\n";
            						}else{
            						
            							result = 
            							"			<wsag:GuaranteeTerm wsag:Obligated=\"Service"+(gdef!=null?gdef.obligated:null)+"\" wsag:Name=\""+(name!=null?name.getText():null)+"\" >\n"+(gdef!=null?gdef.result:null)+
            							"			</wsag:GuaranteeTerm>\n";
            							
            						}
            						
            					

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "guaranteeTerm"


    // $ANTLR start "grouped_guaranteeTerm"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:505:1: grouped_guaranteeTerm returns [String result] : ( guaranteeTerm )+ ;
    public final String grouped_guaranteeTerm() throws RecognitionException {
        String result = null;

        String guaranteeTerm30 = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:506:4: ( ( guaranteeTerm )+ )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:506:6: ( guaranteeTerm )+
            {
            result = "";
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:506:21: ( guaranteeTerm )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==LABEL||LA30_0==IDENT) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:506:22: guaranteeTerm
            	    {
            	    pushFollow(FOLLOW_guaranteeTerm_in_grouped_guaranteeTerm2180);
            	    guaranteeTerm30=guaranteeTerm();

            	    state._fsp--;

            	    result += guaranteeTerm30;

            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "grouped_guaranteeTerm"

    public static class guarantee_def_return extends ParserRuleReturnScope {
        public String result;
        public String obligated;
    };

    // $ANTLR start "guarantee_def"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:509:1: guarantee_def returns [String result, String obligated] : (ob= PROVIDER | ob= CONSUMER ) GUARANTEES expression ( temporality )? ';' ( upon_sentence )? (onlyif= onlyif_sentence )? ;
    public final SampleParser.guarantee_def_return guarantee_def() throws RecognitionException {
        SampleParser.guarantee_def_return retval = new SampleParser.guarantee_def_return();
        retval.start = input.LT(1);

        Token ob=null;
        String onlyif = null;

        String expression31 = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:510:5: ( (ob= PROVIDER | ob= CONSUMER ) GUARANTEES expression ( temporality )? ';' ( upon_sentence )? (onlyif= onlyif_sentence )? )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:510:7: (ob= PROVIDER | ob= CONSUMER ) GUARANTEES expression ( temporality )? ';' ( upon_sentence )? (onlyif= onlyif_sentence )?
            {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:510:7: (ob= PROVIDER | ob= CONSUMER )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==PROVIDER) ) {
                alt31=1;
            }
            else if ( (LA31_0==CONSUMER) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:510:8: ob= PROVIDER
                    {
                    ob=(Token)match(input,PROVIDER,FOLLOW_PROVIDER_in_guarantee_def2214); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:510:22: ob= CONSUMER
                    {
                    ob=(Token)match(input,CONSUMER,FOLLOW_CONSUMER_in_guarantee_def2220); 

                    }
                    break;

            }

            match(input,GUARANTEES,FOLLOW_GUARANTEES_in_guarantee_def2223); 
            pushFollow(FOLLOW_expression_in_guarantee_def2225);
            expression31=expression();

            state._fsp--;

            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:510:57: ( temporality )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==ON) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:510:57: temporality
                    {
                    pushFollow(FOLLOW_temporality_in_guarantee_def2227);
                    temporality();

                    state._fsp--;


                    }
                    break;

            }

            match(input,77,FOLLOW_77_in_guarantee_def2230); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:510:74: ( upon_sentence )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==UPON) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:510:75: upon_sentence
                    {
                    pushFollow(FOLLOW_upon_sentence_in_guarantee_def2233);
                    upon_sentence();

                    state._fsp--;


                    }
                    break;

            }

            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:510:91: (onlyif= onlyif_sentence )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==ONLY_IF) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:510:92: onlyif= onlyif_sentence
                    {
                    pushFollow(FOLLOW_onlyif_sentence_in_guarantee_def2240);
                    onlyif=onlyif_sentence();

                    state._fsp--;


                    }
                    break;

            }


            						retval.obligated = (ob!=null?ob.getText():null);
            						retval.result = "";
            						if(onlyif!=null) {
            							retval.result =
            								"				<wsag:QualifyingCondition >\n"
            													+"					"+convertEntities(onlyif)+"\n"+
            								"				</wsag:QualifyingCondition>\n";
            						}
            						
            						retval.result += 
            							"				<wsag:ServiceLevelObjective >\n"+
            							"					<wsag:CustomServiceLevel >"+convertEntities(expression31)+"</wsag:CustomServiceLevel>\n"+
            							"				</wsag:ServiceLevelObjective>\n";
            						
            					

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "guarantee_def"


    // $ANTLR start "upon_sentence"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:529:1: upon_sentence returns [String result] : UPON IDENT ';' ;
    public final String upon_sentence() throws RecognitionException {
        String result = null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:530:5: ( UPON IDENT ';' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:530:7: UPON IDENT ';'
            {
            match(input,UPON,FOLLOW_UPON_in_upon_sentence2274); 
            match(input,IDENT,FOLLOW_IDENT_in_upon_sentence2276); 
            match(input,77,FOLLOW_77_in_upon_sentence2278); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "upon_sentence"


    // $ANTLR start "onlyif_sentence"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:533:1: onlyif_sentence returns [String result] : ONLY_IF PA expression PC ';' ;
    public final String onlyif_sentence() throws RecognitionException {
        String result = null;

        String expression32 = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:534:5: ( ONLY_IF PA expression PC ';' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:534:7: ONLY_IF PA expression PC ';'
            {
            match(input,ONLY_IF,FOLLOW_ONLY_IF_in_onlyif_sentence2300); 
            match(input,PA,FOLLOW_PA_in_onlyif_sentence2302); 
            pushFollow(FOLLOW_expression_in_onlyif_sentence2304);
            expression32=expression();

            state._fsp--;

            match(input,PC,FOLLOW_PC_in_onlyif_sentence2306); 
            match(input,77,FOLLOW_77_in_onlyif_sentence2308); 
            result = expression32;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "onlyif_sentence"


    // $ANTLR start "assig_value"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:540:1: assig_value returns [String result] : ( (val= ( IDENT | LETTER | VALUE | INT | STRING ) )+ ( operation )? | TRUE | FALSE | FLOAT (u= ( unit ) )? ( operation )? | SFLOAT (u= ( unit ) )? ( operation )? | SINT (u= ( unit ) )? ( operation )? | list );
    public final String assig_value() throws RecognitionException {
        String result = null;

        Token val=null;
        Token u=null;
        Token FLOAT34=null;
        Token SFLOAT36=null;
        Token SINT38=null;
        String operation33 = null;

        String operation35 = null;

        String operation37 = null;

        String operation39 = null;

        SampleParser.list_return list40 = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:541:5: ( (val= ( IDENT | LETTER | VALUE | INT | STRING ) )+ ( operation )? | TRUE | FALSE | FLOAT (u= ( unit ) )? ( operation )? | SFLOAT (u= ( unit ) )? ( operation )? | SINT (u= ( unit ) )? ( operation )? | list )
            int alt43=7;
            switch ( input.LA(1) ) {
            case LETTER:
            case INT:
            case VALUE:
            case IDENT:
            case STRING:
                {
                alt43=1;
                }
                break;
            case TRUE:
                {
                alt43=2;
                }
                break;
            case FALSE:
                {
                alt43=3;
                }
                break;
            case FLOAT:
                {
                alt43=4;
                }
                break;
            case SFLOAT:
                {
                alt43=5;
                }
                break;
            case SINT:
                {
                alt43=6;
                }
                break;
            case LLA:
                {
                alt43=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }

            switch (alt43) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:541:7: (val= ( IDENT | LETTER | VALUE | INT | STRING ) )+ ( operation )?
                    {
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:541:10: (val= ( IDENT | LETTER | VALUE | INT | STRING ) )+
                    int cnt35=0;
                    loop35:
                    do {
                        int alt35=2;
                        int LA35_0 = input.LA(1);

                        if ( (LA35_0==LETTER||LA35_0==INT||(LA35_0>=VALUE && LA35_0<=IDENT)||LA35_0==STRING) ) {
                            alt35=1;
                        }


                        switch (alt35) {
                    	case 1 :
                    	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:541:10: val= ( IDENT | LETTER | VALUE | INT | STRING )
                    	    {
                    	    val=(Token)input.LT(1);
                    	    if ( input.LA(1)==LETTER||input.LA(1)==INT||(input.LA(1)>=VALUE && input.LA(1)<=IDENT)||input.LA(1)==STRING ) {
                    	        input.consume();
                    	        state.errorRecovery=false;
                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        throw mse;
                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt35 >= 1 ) break loop35;
                                EarlyExitException eee =
                                    new EarlyExitException(35, input);
                                throw eee;
                        }
                        cnt35++;
                    } while (true);

                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:541:52: ( operation )?
                    int alt36=2;
                    int LA36_0 = input.LA(1);

                    if ( ((LA36_0>=80 && LA36_0<=83)) ) {
                        alt36=1;
                    }
                    switch (alt36) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:541:53: operation
                            {
                            pushFollow(FOLLOW_operation_in_assig_value2358);
                            operation33=operation();

                            state._fsp--;


                            }
                            break;

                    }

                     result = (val!=null?val.getText():null); if(operation33!=null) result+=operation33; 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:542:7: TRUE
                    {
                    match(input,TRUE,FOLLOW_TRUE_in_assig_value2369); 
                     result ="\"True\""; 

                    }
                    break;
                case 3 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:543:7: FALSE
                    {
                    match(input,FALSE,FOLLOW_FALSE_in_assig_value2379); 
                     result ="\"False\""; 

                    }
                    break;
                case 4 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:544:7: FLOAT (u= ( unit ) )? ( operation )?
                    {
                    FLOAT34=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_assig_value2389); 
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:544:14: (u= ( unit ) )?
                    int alt37=2;
                    int LA37_0 = input.LA(1);

                    if ( ((LA37_0>=84 && LA37_0<=85)) ) {
                        alt37=1;
                    }
                    switch (alt37) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:544:14: u= ( unit )
                            {
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:544:15: ( unit )
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:544:16: unit
                            {
                            pushFollow(FOLLOW_unit_in_assig_value2394);
                            unit();

                            state._fsp--;


                            }


                            }
                            break;

                    }

                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:544:23: ( operation )?
                    int alt38=2;
                    int LA38_0 = input.LA(1);

                    if ( ((LA38_0>=80 && LA38_0<=83)) ) {
                        alt38=1;
                    }
                    switch (alt38) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:544:24: operation
                            {
                            pushFollow(FOLLOW_operation_in_assig_value2399);
                            operation35=operation();

                            state._fsp--;


                            }
                            break;

                    }

                     result = (FLOAT34!=null?FLOAT34.getText():null); if(u!=null) result+=u; if(operation35!=null) result+=operation35; 

                    }
                    break;
                case 5 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:545:7: SFLOAT (u= ( unit ) )? ( operation )?
                    {
                    SFLOAT36=(Token)match(input,SFLOAT,FOLLOW_SFLOAT_in_assig_value2411); 
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:545:15: (u= ( unit ) )?
                    int alt39=2;
                    int LA39_0 = input.LA(1);

                    if ( ((LA39_0>=84 && LA39_0<=85)) ) {
                        alt39=1;
                    }
                    switch (alt39) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:545:15: u= ( unit )
                            {
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:545:16: ( unit )
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:545:17: unit
                            {
                            pushFollow(FOLLOW_unit_in_assig_value2416);
                            unit();

                            state._fsp--;


                            }


                            }
                            break;

                    }

                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:545:24: ( operation )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( ((LA40_0>=80 && LA40_0<=83)) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:545:25: operation
                            {
                            pushFollow(FOLLOW_operation_in_assig_value2421);
                            operation37=operation();

                            state._fsp--;


                            }
                            break;

                    }

                     result = (SFLOAT36!=null?SFLOAT36.getText():null); if(u!=null) result+=u; if(operation37!=null) result+=operation37;

                    }
                    break;
                case 6 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:546:7: SINT (u= ( unit ) )? ( operation )?
                    {
                    SINT38=(Token)match(input,SINT,FOLLOW_SINT_in_assig_value2433); 
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:546:13: (u= ( unit ) )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( ((LA41_0>=84 && LA41_0<=85)) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:546:13: u= ( unit )
                            {
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:546:14: ( unit )
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:546:15: unit
                            {
                            pushFollow(FOLLOW_unit_in_assig_value2438);
                            unit();

                            state._fsp--;


                            }


                            }
                            break;

                    }

                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:546:22: ( operation )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( ((LA42_0>=80 && LA42_0<=83)) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:546:23: operation
                            {
                            pushFollow(FOLLOW_operation_in_assig_value2443);
                            operation39=operation();

                            state._fsp--;


                            }
                            break;

                    }

                     result = (SINT38!=null?SINT38.getText():null); if(u!=null) result+=u; if(operation39!=null) result+=operation39; 

                    }
                    break;
                case 7 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:547:7: list
                    {
                    pushFollow(FOLLOW_list_in_assig_value2455);
                    list40=list();

                    state._fsp--;

                     result = (list40!=null?list40.result:null);

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "assig_value"


    // $ANTLR start "operation"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:550:1: operation returns [String result] : (ope= '+' | ope= '-' | ope= '*' | ope= '/' ) assig_value ;
    public final String operation() throws RecognitionException {
        String result = null;

        Token ope=null;
        String assig_value41 = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:551:5: ( (ope= '+' | ope= '-' | ope= '*' | ope= '/' ) assig_value )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:551:7: (ope= '+' | ope= '-' | ope= '*' | ope= '/' ) assig_value
            {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:551:7: (ope= '+' | ope= '-' | ope= '*' | ope= '/' )
            int alt44=4;
            switch ( input.LA(1) ) {
            case 80:
                {
                alt44=1;
                }
                break;
            case 81:
                {
                alt44=2;
                }
                break;
            case 82:
                {
                alt44=3;
                }
                break;
            case 83:
                {
                alt44=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }

            switch (alt44) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:551:8: ope= '+'
                    {
                    ope=(Token)match(input,80,FOLLOW_80_in_operation2485); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:551:16: ope= '-'
                    {
                    ope=(Token)match(input,81,FOLLOW_81_in_operation2489); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:551:24: ope= '*'
                    {
                    ope=(Token)match(input,82,FOLLOW_82_in_operation2493); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:551:32: ope= '/'
                    {
                    ope=(Token)match(input,83,FOLLOW_83_in_operation2497); 

                    }
                    break;

            }

            pushFollow(FOLLOW_assig_value_in_operation2500);
            assig_value41=assig_value();

            state._fsp--;

             result = (ope!=null?ope.getText():null) + assig_value41; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "operation"


    // $ANTLR start "unit"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:554:1: unit returns [String result] : ( '%' | 'min' );
    public final String unit() throws RecognitionException {
        String result = null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:554:30: ( '%' | 'min' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:
            {
            if ( (input.LA(1)>=84 && input.LA(1)<=85) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "unit"

    public static class list_return extends ParserRuleReturnScope {
        public String result;
        public String values;
    };

    // $ANTLR start "list"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:556:1: list returns [String result, String values] : LLA (i1= IDENT | i1= STRING | i1= INT | i1= SINT | i1= FLOAT | i1= SFLOAT ) ( ',' (i2= IDENT | i2= STRING | i2= INT | i2= SINT | i2= FLOAT | i2= SFLOAT ) )* LLC ;
    public final SampleParser.list_return list() throws RecognitionException {
        SampleParser.list_return retval = new SampleParser.list_return();
        retval.start = input.LT(1);

        Token i1=null;
        Token i2=null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:5: ( LLA (i1= IDENT | i1= STRING | i1= INT | i1= SINT | i1= FLOAT | i1= SFLOAT ) ( ',' (i2= IDENT | i2= STRING | i2= INT | i2= SINT | i2= FLOAT | i2= SFLOAT ) )* LLC )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:7: LLA (i1= IDENT | i1= STRING | i1= INT | i1= SINT | i1= FLOAT | i1= SFLOAT ) ( ',' (i2= IDENT | i2= STRING | i2= INT | i2= SINT | i2= FLOAT | i2= SFLOAT ) )* LLC
            {
            match(input,LLA,FOLLOW_LLA_in_list2540); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:11: (i1= IDENT | i1= STRING | i1= INT | i1= SINT | i1= FLOAT | i1= SFLOAT )
            int alt45=6;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt45=1;
                }
                break;
            case STRING:
                {
                alt45=2;
                }
                break;
            case INT:
                {
                alt45=3;
                }
                break;
            case SINT:
                {
                alt45=4;
                }
                break;
            case FLOAT:
                {
                alt45=5;
                }
                break;
            case SFLOAT:
                {
                alt45=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:12: i1= IDENT
                    {
                    i1=(Token)match(input,IDENT,FOLLOW_IDENT_in_list2545); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:21: i1= STRING
                    {
                    i1=(Token)match(input,STRING,FOLLOW_STRING_in_list2549); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:31: i1= INT
                    {
                    i1=(Token)match(input,INT,FOLLOW_INT_in_list2553); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:38: i1= SINT
                    {
                    i1=(Token)match(input,SINT,FOLLOW_SINT_in_list2557); 

                    }
                    break;
                case 5 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:46: i1= FLOAT
                    {
                    i1=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_list2561); 

                    }
                    break;
                case 6 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:55: i1= SFLOAT
                    {
                    i1=(Token)match(input,SFLOAT,FOLLOW_SFLOAT_in_list2565); 

                    }
                    break;

            }

             retval.result ="{"+(i1!=null?i1.getText():null); retval.values =(i1!=null?i1.getText():null); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:110: ( ',' (i2= IDENT | i2= STRING | i2= INT | i2= SINT | i2= FLOAT | i2= SFLOAT ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==78) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:111: ',' (i2= IDENT | i2= STRING | i2= INT | i2= SINT | i2= FLOAT | i2= SFLOAT )
            	    {
            	    match(input,78,FOLLOW_78_in_list2571); 
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:115: (i2= IDENT | i2= STRING | i2= INT | i2= SINT | i2= FLOAT | i2= SFLOAT )
            	    int alt46=6;
            	    switch ( input.LA(1) ) {
            	    case IDENT:
            	        {
            	        alt46=1;
            	        }
            	        break;
            	    case STRING:
            	        {
            	        alt46=2;
            	        }
            	        break;
            	    case INT:
            	        {
            	        alt46=3;
            	        }
            	        break;
            	    case SINT:
            	        {
            	        alt46=4;
            	        }
            	        break;
            	    case FLOAT:
            	        {
            	        alt46=5;
            	        }
            	        break;
            	    case SFLOAT:
            	        {
            	        alt46=6;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 46, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt46) {
            	        case 1 :
            	            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:116: i2= IDENT
            	            {
            	            i2=(Token)match(input,IDENT,FOLLOW_IDENT_in_list2576); 

            	            }
            	            break;
            	        case 2 :
            	            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:125: i2= STRING
            	            {
            	            i2=(Token)match(input,STRING,FOLLOW_STRING_in_list2580); 

            	            }
            	            break;
            	        case 3 :
            	            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:135: i2= INT
            	            {
            	            i2=(Token)match(input,INT,FOLLOW_INT_in_list2584); 

            	            }
            	            break;
            	        case 4 :
            	            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:142: i2= SINT
            	            {
            	            i2=(Token)match(input,SINT,FOLLOW_SINT_in_list2588); 

            	            }
            	            break;
            	        case 5 :
            	            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:150: i2= FLOAT
            	            {
            	            i2=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_list2592); 

            	            }
            	            break;
            	        case 6 :
            	            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:557:159: i2= SFLOAT
            	            {
            	            i2=(Token)match(input,SFLOAT,FOLLOW_SFLOAT_in_list2596); 

            	            }
            	            break;

            	    }

            	     retval.result+=", "+(i2!=null?i2.getText():null); retval.values+=","+(i2!=null?i2.getText():null); 

            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);

            match(input,LLC,FOLLOW_LLC_in_list2603); 
            retval.result+="}";

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "list"


    // $ANTLR start "expression"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:561:1: expression returns [String result] : ( NOT e1= expression | PA e1= expression PC (log= ( AND | OR | IMPLIES ) e2= expression )? | (id= IDENT | id= ACCESS | id= STRING ) (comp= ( IGUAL | MENOR | MAYOR | MENOR_IGUAL | MAYOR_IGUAL ) val= assig_value )? (log= ( AND | OR | IMPLIES ) e2= expression )? | (id= IDENT | id= ACCESS ) BELONGS l= list (log= ( AND | OR | IMPLIES ) exp= expression )? );
    public final String expression() throws RecognitionException {
        String result = null;

        Token log=null;
        Token id=null;
        Token comp=null;
        Token PA42=null;
        Token PC43=null;
        String e1 = null;

        String e2 = null;

        String val = null;

        SampleParser.list_return l = null;

        String exp = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:562:5: ( NOT e1= expression | PA e1= expression PC (log= ( AND | OR | IMPLIES ) e2= expression )? | (id= IDENT | id= ACCESS | id= STRING ) (comp= ( IGUAL | MENOR | MAYOR | MENOR_IGUAL | MAYOR_IGUAL ) val= assig_value )? (log= ( AND | OR | IMPLIES ) e2= expression )? | (id= IDENT | id= ACCESS ) BELONGS l= list (log= ( AND | OR | IMPLIES ) exp= expression )? )
            int alt54=4;
            switch ( input.LA(1) ) {
            case NOT:
                {
                alt54=1;
                }
                break;
            case PA:
                {
                alt54=2;
                }
                break;
            case IDENT:
                {
                int LA54_3 = input.LA(2);

                if ( (LA54_3==PC||(LA54_3>=MENOR && LA54_3<=OR)||LA54_3==IMPLIES||LA54_3==ON||LA54_3==77) ) {
                    alt54=3;
                }
                else if ( (LA54_3==BELONGS) ) {
                    alt54=4;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 3, input);

                    throw nvae;
                }
                }
                break;
            case ACCESS:
                {
                int LA54_4 = input.LA(2);

                if ( (LA54_4==BELONGS) ) {
                    alt54=4;
                }
                else if ( (LA54_4==PC||(LA54_4>=MENOR && LA54_4<=OR)||LA54_4==IMPLIES||LA54_4==ON||LA54_4==77) ) {
                    alt54=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 54, 4, input);

                    throw nvae;
                }
                }
                break;
            case STRING:
                {
                alt54=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:562:7: NOT e1= expression
                    {
                    match(input,NOT,FOLLOW_NOT_in_expression2627); 
                    pushFollow(FOLLOW_expression_in_expression2631);
                    e1=expression();

                    state._fsp--;


                    						result = "NOT ("+e1+")";
                    					

                    }
                    break;
                case 2 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:566:7: PA e1= expression PC (log= ( AND | OR | IMPLIES ) e2= expression )?
                    {
                    PA42=(Token)match(input,PA,FOLLOW_PA_in_expression2646); 
                    pushFollow(FOLLOW_expression_in_expression2650);
                    e1=expression();

                    state._fsp--;

                    PC43=(Token)match(input,PC,FOLLOW_PC_in_expression2652); 
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:566:27: (log= ( AND | OR | IMPLIES ) e2= expression )?
                    int alt48=2;
                    int LA48_0 = input.LA(1);

                    if ( ((LA48_0>=AND && LA48_0<=OR)||LA48_0==IMPLIES) ) {
                        alt48=1;
                    }
                    switch (alt48) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:566:28: log= ( AND | OR | IMPLIES ) e2= expression
                            {
                            log=(Token)input.LT(1);
                            if ( (input.LA(1)>=AND && input.LA(1)<=OR)||input.LA(1)==IMPLIES ) {
                                input.consume();
                                state.errorRecovery=false;
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            pushFollow(FOLLOW_expression_in_expression2667);
                            e2=expression();

                            state._fsp--;


                            }
                            break;

                    }


                    						result = (PA42!=null?PA42.getText():null) + e1 + (PC43!=null?PC43.getText():null);
                    						if(log!=null) {
                    							result += " "+(log!=null?log.getText():null) + " " + e2;
                    						}
                    						
                    						result = convertEntities(result);
                    					

                    }
                    break;
                case 3 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:575:7: (id= IDENT | id= ACCESS | id= STRING ) (comp= ( IGUAL | MENOR | MAYOR | MENOR_IGUAL | MAYOR_IGUAL ) val= assig_value )? (log= ( AND | OR | IMPLIES ) e2= expression )?
                    {
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:575:7: (id= IDENT | id= ACCESS | id= STRING )
                    int alt49=3;
                    switch ( input.LA(1) ) {
                    case IDENT:
                        {
                        alt49=1;
                        }
                        break;
                    case ACCESS:
                        {
                        alt49=2;
                        }
                        break;
                    case STRING:
                        {
                        alt49=3;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 49, 0, input);

                        throw nvae;
                    }

                    switch (alt49) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:575:8: id= IDENT
                            {
                            id=(Token)match(input,IDENT,FOLLOW_IDENT_in_expression2687); 

                            }
                            break;
                        case 2 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:575:17: id= ACCESS
                            {
                            id=(Token)match(input,ACCESS,FOLLOW_ACCESS_in_expression2691); 

                            }
                            break;
                        case 3 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:575:27: id= STRING
                            {
                            id=(Token)match(input,STRING,FOLLOW_STRING_in_expression2695); 

                            }
                            break;

                    }

                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:575:38: (comp= ( IGUAL | MENOR | MAYOR | MENOR_IGUAL | MAYOR_IGUAL ) val= assig_value )?
                    int alt50=2;
                    int LA50_0 = input.LA(1);

                    if ( ((LA50_0>=MENOR && LA50_0<=MAYOR_IGUAL)) ) {
                        alt50=1;
                    }
                    switch (alt50) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:575:40: comp= ( IGUAL | MENOR | MAYOR | MENOR_IGUAL | MAYOR_IGUAL ) val= assig_value
                            {
                            comp=(Token)input.LT(1);
                            if ( (input.LA(1)>=MENOR && input.LA(1)<=MAYOR_IGUAL) ) {
                                input.consume();
                                state.errorRecovery=false;
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            pushFollow(FOLLOW_assig_value_in_expression2716);
                            val=assig_value();

                            state._fsp--;


                            }
                            break;

                    }

                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:575:107: (log= ( AND | OR | IMPLIES ) e2= expression )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( ((LA51_0>=AND && LA51_0<=OR)||LA51_0==IMPLIES) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:575:108: log= ( AND | OR | IMPLIES ) e2= expression
                            {
                            log=(Token)input.LT(1);
                            if ( (input.LA(1)>=AND && input.LA(1)<=OR)||input.LA(1)==IMPLIES ) {
                                input.consume();
                                state.errorRecovery=false;
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            pushFollow(FOLLOW_expression_in_expression2733);
                            e2=expression();

                            state._fsp--;


                            }
                            break;

                    }


                    						result = "";

                    						result += (id!=null?id.getText():null);
                    						if(comp!=null) result += (comp!=null?comp.getText():null) + val;
                    						if(log!=null) result += " "+(log!=null?log.getText():null) + " " + e2;
                    						
                    						result = convertEntities(result);
                    					

                    }
                    break;
                case 4 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:585:7: (id= IDENT | id= ACCESS ) BELONGS l= list (log= ( AND | OR | IMPLIES ) exp= expression )?
                    {
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:585:7: (id= IDENT | id= ACCESS )
                    int alt52=2;
                    int LA52_0 = input.LA(1);

                    if ( (LA52_0==IDENT) ) {
                        alt52=1;
                    }
                    else if ( (LA52_0==ACCESS) ) {
                        alt52=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 52, 0, input);

                        throw nvae;
                    }
                    switch (alt52) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:585:8: id= IDENT
                            {
                            id=(Token)match(input,IDENT,FOLLOW_IDENT_in_expression2753); 

                            }
                            break;
                        case 2 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:585:17: id= ACCESS
                            {
                            id=(Token)match(input,ACCESS,FOLLOW_ACCESS_in_expression2757); 

                            }
                            break;

                    }

                    match(input,BELONGS,FOLLOW_BELONGS_in_expression2760); 
                    pushFollow(FOLLOW_list_in_expression2764);
                    l=list();

                    state._fsp--;

                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:585:43: (log= ( AND | OR | IMPLIES ) exp= expression )?
                    int alt53=2;
                    int LA53_0 = input.LA(1);

                    if ( ((LA53_0>=AND && LA53_0<=OR)||LA53_0==IMPLIES) ) {
                        alt53=1;
                    }
                    switch (alt53) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:585:44: log= ( AND | OR | IMPLIES ) exp= expression
                            {
                            log=(Token)input.LT(1);
                            if ( (input.LA(1)>=AND && input.LA(1)<=OR)||input.LA(1)==IMPLIES ) {
                                input.consume();
                                state.errorRecovery=false;
                            }
                            else {
                                MismatchedSetException mse = new MismatchedSetException(null,input);
                                throw mse;
                            }

                            pushFollow(FOLLOW_expression_in_expression2779);
                            exp=expression();

                            state._fsp--;


                            }
                            break;

                    }


                    						result = "";

                    							
                    							String[] values = (l!=null?l.values:null).split(",");
                    							
                    							result += "("+(id!=null?id.getText():null)+" = \""+values[0]+"\")";
                    							
                    							for(int i=1; i<values.length; i++) {
                    								result += " OR ("+(id!=null?id.getText():null)+" = \""+values[i]+"\")";
                    							}
                    							
                    							result += ")";

                    							
                    							if(log!=null) result += " "+(log!=null?log.getText():null) + " " +exp;
                    						
                    						result = convertEntities(result);
                    					

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "expression"


    // $ANTLR start "cuantif"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:607:1: cuantif returns [String result] : ( 'exactly one' | 'one or more' | 'all' );
    public final String cuantif() throws RecognitionException {
        String result = null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:608:5: ( 'exactly one' | 'one or more' | 'all' )
            int alt55=3;
            switch ( input.LA(1) ) {
            case 86:
                {
                alt55=1;
                }
                break;
            case 87:
                {
                alt55=2;
                }
                break;
            case 88:
                {
                alt55=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:608:7: 'exactly one'
                    {
                    match(input,86,FOLLOW_86_in_cuantif2809); 
                    result = "ExactlyOne";

                    }
                    break;
                case 2 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:609:7: 'one or more'
                    {
                    match(input,87,FOLLOW_87_in_cuantif2819); 
                    result = "OneOrMore";

                    }
                    break;
                case 3 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:610:7: 'all'
                    {
                    match(input,88,FOLLOW_88_in_cuantif2829); 
                    result = "All";

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return result;
    }
    // $ANTLR end "cuantif"

    public static class key_value_prop_return extends ParserRuleReturnScope {
        public String result;
        public String key;
        public String value;
        public String assigValue;
        public String type;
        public String typeArg;
    };

    // $ANTLR start "key_value_prop"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:613:1: key_value_prop returns [String result, String key, String value, String assigValue, String type, String typeArg] : (k= IDENT | k= ACCESS | k= 'boolean' | k= 'integer' ) DP (v= STRING | v2= type ) ( IGUAL a= assig_value ';' )? ;
    public final SampleParser.key_value_prop_return key_value_prop() throws RecognitionException {
        SampleParser.key_value_prop_return retval = new SampleParser.key_value_prop_return();
        retval.start = input.LT(1);

        Token k=null;
        Token v=null;
        SampleParser.type_return v2 = null;

        String a = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:614:5: ( (k= IDENT | k= ACCESS | k= 'boolean' | k= 'integer' ) DP (v= STRING | v2= type ) ( IGUAL a= assig_value ';' )? )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:614:7: (k= IDENT | k= ACCESS | k= 'boolean' | k= 'integer' ) DP (v= STRING | v2= type ) ( IGUAL a= assig_value ';' )?
            {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:614:7: (k= IDENT | k= ACCESS | k= 'boolean' | k= 'integer' )
            int alt56=4;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt56=1;
                }
                break;
            case ACCESS:
                {
                alt56=2;
                }
                break;
            case 89:
                {
                alt56=3;
                }
                break;
            case 90:
                {
                alt56=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:614:8: k= IDENT
                    {
                    k=(Token)match(input,IDENT,FOLLOW_IDENT_in_key_value_prop2855); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:614:16: k= ACCESS
                    {
                    k=(Token)match(input,ACCESS,FOLLOW_ACCESS_in_key_value_prop2859); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:614:25: k= 'boolean'
                    {
                    k=(Token)match(input,89,FOLLOW_89_in_key_value_prop2863); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:614:37: k= 'integer'
                    {
                    k=(Token)match(input,90,FOLLOW_90_in_key_value_prop2867); 

                    }
                    break;

            }

            match(input,DP,FOLLOW_DP_in_key_value_prop2870); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:614:53: (v= STRING | v2= type )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==STRING) ) {
                alt57=1;
            }
            else if ( (LA57_0==IDENT||(LA57_0>=89 && LA57_0<=95)) ) {
                alt57=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:614:54: v= STRING
                    {
                    v=(Token)match(input,STRING,FOLLOW_STRING_in_key_value_prop2875); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:614:65: v2= type
                    {
                    pushFollow(FOLLOW_type_in_key_value_prop2881);
                    v2=type();

                    state._fsp--;


                    }
                    break;

            }

            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:614:75: ( IGUAL a= assig_value ';' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==IGUAL) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:614:76: IGUAL a= assig_value ';'
                    {
                    match(input,IGUAL,FOLLOW_IGUAL_in_key_value_prop2886); 
                    pushFollow(FOLLOW_assig_value_in_key_value_prop2890);
                    a=assig_value();

                    state._fsp--;

                    match(input,77,FOLLOW_77_in_key_value_prop2892); 
                    retval.assigValue = a;

                    }
                    break;

            }


            						
            						retval.result = (k!=null?k.getText():null)+"=";
            						retval.key = (k!=null?k.getText():null);
            						if(v2!=null) {
            							retval.result += (v2!=null?input.toString(v2.start,v2.stop):null);
            							retval.value = (v2!=null?input.toString(v2.start,v2.stop):null);
            							retval.type = (v2!=null?v2.result:null);
            							retval.typeArg = (v2!=null?v2.arg:null);
            						}else{
            							retval.result += (v!=null?v.getText():null);
            							retval.value = (v!=null?v.getText():null);
            						}
            						
            						if(retval.assigValue==null) retval.assigValue = "";
            						
            					

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "key_value_prop"

    public static class type_return extends ParserRuleReturnScope {
        public String result;
        public String arg;
    };

    // $ANTLR start "type"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:634:1: type returns [String result, String arg] : ( (v= 'integer' | v= 'float' | v= 'natural' | v= 'number' | v= 'boolean' ) (r= range )? | IDENT | v= 'set' list | v= 'enum' list );
    public final SampleParser.type_return type() throws RecognitionException {
        SampleParser.type_return retval = new SampleParser.type_return();
        retval.start = input.LT(1);

        Token v=null;
        Token IDENT44=null;
        SampleParser.range_return r = null;

        SampleParser.list_return list45 = null;

        SampleParser.list_return list46 = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:635:5: ( (v= 'integer' | v= 'float' | v= 'natural' | v= 'number' | v= 'boolean' ) (r= range )? | IDENT | v= 'set' list | v= 'enum' list )
            int alt61=4;
            switch ( input.LA(1) ) {
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
                {
                alt61=1;
                }
                break;
            case IDENT:
                {
                alt61=2;
                }
                break;
            case 94:
                {
                alt61=3;
                }
                break;
            case 95:
                {
                alt61=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:635:7: (v= 'integer' | v= 'float' | v= 'natural' | v= 'number' | v= 'boolean' ) (r= range )?
                    {
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:635:7: (v= 'integer' | v= 'float' | v= 'natural' | v= 'number' | v= 'boolean' )
                    int alt59=5;
                    switch ( input.LA(1) ) {
                    case 90:
                        {
                        alt59=1;
                        }
                        break;
                    case 91:
                        {
                        alt59=2;
                        }
                        break;
                    case 92:
                        {
                        alt59=3;
                        }
                        break;
                    case 93:
                        {
                        alt59=4;
                        }
                        break;
                    case 89:
                        {
                        alt59=5;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 59, 0, input);

                        throw nvae;
                    }

                    switch (alt59) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:635:8: v= 'integer'
                            {
                            v=(Token)match(input,90,FOLLOW_90_in_type2927); 

                            }
                            break;
                        case 2 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:635:22: v= 'float'
                            {
                            v=(Token)match(input,91,FOLLOW_91_in_type2933); 

                            }
                            break;
                        case 3 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:635:34: v= 'natural'
                            {
                            v=(Token)match(input,92,FOLLOW_92_in_type2939); 

                            }
                            break;
                        case 4 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:635:48: v= 'number'
                            {
                            v=(Token)match(input,93,FOLLOW_93_in_type2945); 

                            }
                            break;
                        case 5 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:635:61: v= 'boolean'
                            {
                            v=(Token)match(input,89,FOLLOW_89_in_type2951); 

                            }
                            break;

                    }


                    					if((v!=null?v.getText():null) != "boolean") {
                    								retval.result = "integer";
                    							} else {
                    								retval.result = (v!=null?v.getText():null);
                    							}
                    							
                    				
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:643:7: (r= range )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==CA) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:643:8: r= range
                            {
                            pushFollow(FOLLOW_range_in_type2963);
                            r=range();

                            state._fsp--;

                            retval.arg = (r!=null?r.min:null)+","+(r!=null?r.max:null);

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:644:7: IDENT
                    {
                    IDENT44=(Token)match(input,IDENT,FOLLOW_IDENT_in_type2976); 
                    retval.result = (IDENT44!=null?IDENT44.getText():null);

                    }
                    break;
                case 3 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:645:7: v= 'set' list
                    {
                    v=(Token)match(input,94,FOLLOW_94_in_type2988); 
                    pushFollow(FOLLOW_list_in_type2990);
                    list45=list();

                    state._fsp--;

                    retval.result = (v!=null?v.getText():null); retval.arg = (list45!=null?list45.values:null);

                    }
                    break;
                case 4 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:646:7: v= 'enum' list
                    {
                    v=(Token)match(input,95,FOLLOW_95_in_type3002); 
                    pushFollow(FOLLOW_list_in_type3004);
                    list46=list();

                    state._fsp--;

                    retval.result = (v!=null?v.getText():null); retval.arg = (list46!=null?list46.values:null);

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "type"

    public static class range_return extends ParserRuleReturnScope {
        public String min;
        public String max;
    };

    // $ANTLR start "range"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:649:1: range returns [String min, String max] : ( CA RANGE CC | CA (i1= INT | i1= SINT ) RANGE_SEPARATOR (i2= INT | i2= SINT ) CC );
    public final SampleParser.range_return range() throws RecognitionException {
        SampleParser.range_return retval = new SampleParser.range_return();
        retval.start = input.LT(1);

        Token i1=null;
        Token i2=null;
        Token RANGE47=null;

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:650:5: ( CA RANGE CC | CA (i1= INT | i1= SINT ) RANGE_SEPARATOR (i2= INT | i2= SINT ) CC )
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==CA) ) {
                int LA64_1 = input.LA(2);

                if ( (LA64_1==RANGE) ) {
                    alt64=1;
                }
                else if ( ((LA64_1>=INT && LA64_1<=SINT)) ) {
                    alt64=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 64, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }
            switch (alt64) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:650:7: CA RANGE CC
                    {
                    match(input,CA,FOLLOW_CA_in_range3031); 
                    RANGE47=(Token)match(input,RANGE,FOLLOW_RANGE_in_range3033); 
                    match(input,CC,FOLLOW_CC_in_range3035); 

                    						String rangeStr = (RANGE47!=null?RANGE47.getText():null);
                    						rangeStr = rangeStr.replace("..",",");
                    						
                    						String[] vals = rangeStr.split(",");
                    						
                    						retval.min =vals[0];
                    						retval.max =vals[1];
                    					

                    }
                    break;
                case 2 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:660:7: CA (i1= INT | i1= SINT ) RANGE_SEPARATOR (i2= INT | i2= SINT ) CC
                    {
                    match(input,CA,FOLLOW_CA_in_range3050); 
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:660:10: (i1= INT | i1= SINT )
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==INT) ) {
                        alt62=1;
                    }
                    else if ( (LA62_0==SINT) ) {
                        alt62=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 62, 0, input);

                        throw nvae;
                    }
                    switch (alt62) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:660:11: i1= INT
                            {
                            i1=(Token)match(input,INT,FOLLOW_INT_in_range3055); 

                            }
                            break;
                        case 2 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:660:18: i1= SINT
                            {
                            i1=(Token)match(input,SINT,FOLLOW_SINT_in_range3059); 

                            }
                            break;

                    }

                    match(input,RANGE_SEPARATOR,FOLLOW_RANGE_SEPARATOR_in_range3062); 
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:660:43: (i2= INT | i2= SINT )
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==INT) ) {
                        alt63=1;
                    }
                    else if ( (LA63_0==SINT) ) {
                        alt63=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 63, 0, input);

                        throw nvae;
                    }
                    switch (alt63) {
                        case 1 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:660:44: i2= INT
                            {
                            i2=(Token)match(input,INT,FOLLOW_INT_in_range3067); 

                            }
                            break;
                        case 2 :
                            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:660:51: i2= SINT
                            {
                            i2=(Token)match(input,SINT,FOLLOW_SINT_in_range3071); 

                            }
                            break;

                    }

                    match(input,CC,FOLLOW_CC_in_range3074); 
                    retval.min =(i1!=null?i1.getText():null); retval.max =(i2!=null?i2.getText():null);

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "range"

    public static class url_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "url"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:663:1: url : STRING ;
    public final SampleParser.url_return url() throws RecognitionException {
        SampleParser.url_return retval = new SampleParser.url_return();
        retval.start = input.LT(1);

        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:666:5: ( STRING )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:666:7: STRING
            {
            match(input,STRING,FOLLOW_STRING_in_url3095); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "url"


    // $ANTLR start "metrics_prop"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:670:1: metrics_prop : METRICS DP (kv= key_value_prop )+ ;
    public final void metrics_prop() throws RecognitionException {
        SampleParser.key_value_prop_return kv = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:671:5: ( METRICS DP (kv= key_value_prop )+ )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:671:7: METRICS DP (kv= key_value_prop )+
            {
            match(input,METRICS,FOLLOW_METRICS_in_metrics_prop3117); 
            String metrics_def = "	"+"<met:metric id=\"boolean\" type=\"enumerated\" >\n" + 
            														"		<met:value value=\"True\"/>\n" + 
            														"		<met:value value=\"False\"/>\n" + 
            														"	</met:metric>\n";
            match(input,DP,FOLLOW_DP_in_metrics_prop3123); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:674:86: (kv= key_value_prop )+
            int cnt65=0;
            loop65:
            do {
                int alt65=2;
                int LA65_0 = input.LA(1);

                if ( (LA65_0==IDENT) ) {
                    int LA65_2 = input.LA(2);

                    if ( (LA65_2==DP) ) {
                        alt65=1;
                    }


                }
                else if ( (LA65_0==ACCESS||(LA65_0>=89 && LA65_0<=90)) ) {
                    alt65=1;
                }


                switch (alt65) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:674:87: kv= key_value_prop
            	    {
            	    pushFollow(FOLLOW_key_value_prop_in_metrics_prop3128);
            	    kv=key_value_prop();

            	    state._fsp--;


            	    						String mId, mType;
            	    						String min = "0";
            	    						String max = "500";
            	    						mId = (kv!=null?kv.key:null);
            	    						mType = convertMetricType((kv!=null?kv.type:null));
            	    						
            	    						
            	    						
            	    						metrics_def += "	<met:metric id=\""+mId+"\" type=\""+mType+"\" ";
            	    						
            	    						if((kv!=null?kv.typeArg:null)!=null) {
            	    							String[] aux = (kv!=null?kv.typeArg:null).split(",");
            	    							
            	    							if(mType == "enumerated") {
            	    								metrics_def += ">\n";
            	    								
            	    								if((kv!=null?kv.type:null)!=null && (kv!=null?kv.type:null).toLowerCase().equals("boolean")) {
            	    									aux[0] = "True";
            	    									aux[1] = "False";
            	    								}
            	    								
            	    								for(int i=0; i<aux.length; i++) {
            	    									metrics_def += "		<met:value value=\""+aux[i]+"\"/>\n";
            	    								}
            	    								
            	    								metrics_def += "	</met:metric>\n";
            	    								
            	    							}else{
            	    								min = aux[0];
            	    								max = aux[1];
            	    								
            	    								metrics_def += " min=\""+min+"\" max=\""+max+"\" />\n";
            	    								
            	    							}
            	    							
            	    							
            	    							
            	    						}else{
            	    							metrics_def += " min=\""+min+"\" max=\""+max+"\"";
            	    							metrics_def += "/>\n";
            	    						}
            	    						
            	    					

            	    }
            	    break;

            	default :
            	    if ( cnt65 >= 1 ) break loop65;
                        EarlyExitException eee =
                            new EarlyExitException(65, input);
                        throw eee;
                }
                cnt65++;
            } while (true);


            						metricsTemplate = "<met:metricXML xmlns:met=\"http:/www.isa.us.es/ada/metrics\">\n"+metrics_def+"</met:metricXML>";
            					

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "metrics_prop"


    // $ANTLR start "globalDescription"
    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:724:1: globalDescription : GLOBALDESCRIPTION (kv= key_value_prop )+ ;
    public final void globalDescription() throws RecognitionException {
        SampleParser.key_value_prop_return kv = null;


        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:725:5: ( GLOBALDESCRIPTION (kv= key_value_prop )+ )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:725:6: GLOBALDESCRIPTION (kv= key_value_prop )+
            {
            match(input,GLOBALDESCRIPTION,FOLLOW_GLOBALDESCRIPTION_in_globalDescription3166); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:725:24: (kv= key_value_prop )+
            int cnt66=0;
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( ((LA66_0>=IDENT && LA66_0<=ACCESS)||(LA66_0>=89 && LA66_0<=90)) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:725:25: kv= key_value_prop
            	    {
            	    pushFollow(FOLLOW_key_value_prop_in_globalDescription3171);
            	    kv=key_value_prop();

            	    state._fsp--;


            	    //						variablesSet +=
            	    //						"					<wsag:Variable  wsag:Name=\""+ (kv!=null?kv.key:null) +"\" wsag:Metric=\"metrics/"+metric+":"+(kv!=null?kv.value:null)+"\" >\n"+
            	    //						"						<wsag:Location >/"+(kv!=null?kv.key:null)+"</wsag:Location>\n"+
            	    //						"					</wsag:Variable >\n";
            	    							
            	    							offerItems += "				<OfferItem name=\""+(kv!=null?kv.key:null)+"\" wsag:Metric=\"metrics/"+metric+":"+(kv!=null?kv.value:null)+"\" >"+(kv!=null?kv.assigValue:null)+"</OfferItem>\n";
            	    					

            	    }
            	    break;

            	default :
            	    if ( cnt66 >= 1 ) break loop66;
                        EarlyExitException eee =
                            new EarlyExitException(66, input);
                        throw eee;
                }
                cnt66++;
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "globalDescription"

    // Delegated rules


 

    public static final BitSet FOLLOW_template_in_entry59 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_END_TEMPLATE_in_entry61 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_agOffer_in_entry71 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_END_AG_OFFER_in_entry73 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TEMPLATE_in_template854 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_IDENT_in_template856 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_template858 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000022L});
    public static final BitSet FOLLOW_version_in_template860 = new BitSet(new long[]{0x06007FA000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_template_def_in_template864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AG_OFFER_in_agOffer890 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_IDENT_in_agOffer894 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_agOffer896 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000022L});
    public static final BitSet FOLLOW_version_in_agOffer900 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_FOR_in_agOffer902 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_IDENT_in_agOffer906 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_agOffer908 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000022L});
    public static final BitSet FOLLOW_version_in_agOffer912 = new BitSet(new long[]{0x06007FA000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_ag_def_in_agOffer920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_VERSION_in_version942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_version952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_temp_properties_in_template_def976 = new BitSet(new long[]{0x06007FA000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_agreementTerms_in_template_def980 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_creationConstraints_in_template_def982 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_temp_properties_in_ag_def1011 = new BitSet(new long[]{0x06007FA000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_agreementTerms_in_ag_def1015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_initiator_prop_in_temp_properties1039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_responder_prop_in_temp_properties1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_serviceProvider_prop_in_temp_properties1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expirationTime_prop_in_temp_properties1069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dateFormat_prop_in_temp_properties1079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_gmtZone_prop_in_temp_properties1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_globalPeriod_prop_in_temp_properties1099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_definedPeriod_prop_in_temp_properties1109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_metrics_prop_in_temp_properties1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INITIATOR_in_initiator_prop1143 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DP_in_initiator_prop1145 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_STRING_in_initiator_prop1147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_responder_prop1176 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_AS_in_responder_prop1188 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_RESPONDER_in_responder_prop1190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SERVICEPROVIDER_in_serviceProvider_prop1219 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DP_in_serviceProvider_prop1221 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_STRING_in_serviceProvider_prop1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXPIRATIONTIME_in_expirationTime_prop1250 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DP_in_expirationTime_prop1252 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_STRING_in_expirationTime_prop1254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DATEFORMAT_in_dateFormat_prop1281 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DP_in_dateFormat_prop1283 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_STRING_in_dateFormat_prop1285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GMTZONE_in_gmtZone_prop1312 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DP_in_gmtZone_prop1314 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_set_in_gmtZone_prop1318 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GLOBALPERIOD_in_globalPeriod_prop1351 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DP_in_globalPeriod_prop1353 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_datePeriod_def_in_globalPeriod_prop1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEFINEDPERIOD_in_definedPeriod_prop1382 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DP_in_definedPeriod_prop1384 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_period_in_definedPeriod_prop1386 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_DURING_in_datePeriod_def1421 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_DATE_in_datePeriod_def1423 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RANGE_SEPARATOR_in_datePeriod_def1425 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_DATE_in_datePeriod_def1427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ON_in_temporality1449 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_IDENT_in_temporality1451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_period1472 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DP_in_period1474 = new BitSet(new long[]{0x0000080080000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_period_def_in_period1476 = new BitSet(new long[]{0x0000000010200002L});
    public static final BitSet FOLLOW_set_in_period1479 = new BitSet(new long[]{0x0000080080000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_period_def_in_period1485 = new BitSet(new long[]{0x0000000010200002L});
    public static final BitSet FOLLOW_FROM_in_period_def1508 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_HOUR_in_period_def1510 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RANGE_SEPARATOR_in_period_def1512 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_HOUR_in_period_def1514 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_ON_in_period_def1517 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_IDENT_in_period_def1519 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_DURING_in_period_def1523 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_DATE_in_period_def1525 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RANGE_SEPARATOR_in_period_def1527 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_DATE_in_period_def1529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_period_def1538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GLOBALPERIOD_in_period_def1546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_AGREEMENT_TERMS_in_agreementTerms1572 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_agreementTerms_def_in_agreementTerms1574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATION_CONSTRAINTS_in_creationConstraints1602 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000088L});
    public static final BitSet FOLLOW_creationConstraints_def_in_creationConstraints1604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_service_in_agreementTerms_def1626 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_monitorableProperties_in_agreementTerms_def1628 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_guaranteeTerms_in_agreementTerms_def1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_creationConstraint_in_creationConstraints_def1662 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000088L});
    public static final BitSet FOLLOW_set_in_creationConstraint1686 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DP_in_creationConstraint1692 = new BitSet(new long[]{0x0000000000800400L,0x0000000000000980L});
    public static final BitSet FOLLOW_expression_in_creationConstraint1696 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_creationConstraint1698 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_onlyif_sentence_in_creationConstraint1700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SERVICE_in_service1731 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_IDENT_in_service1735 = new BitSet(new long[]{0x010C000000000000L});
    public static final BitSet FOLLOW_AVAL_AT_in_service1738 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_url_in_service1740 = new BitSet(new long[]{0x010C000000000000L});
    public static final BitSet FOLLOW_features_in_service1751 = new BitSet(new long[]{0x010C000000000000L});
    public static final BitSet FOLLOW_globalDescription_in_service1761 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_descriptions_in_service1769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FEATURES_in_features1799 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DP_in_features1801 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_feature_in_features1803 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_features1806 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_feature_in_features1808 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_description_in_descriptions1837 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_op_in_feature1854 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_feature1857 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_op_in_feature1859 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});
    public static final BitSet FOLLOW_IDENT_in_op1885 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_PA_in_op1888 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_IDENT_in_op1890 = new BitSet(new long[]{0x0000000000000800L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_op1893 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_IDENT_in_op1895 = new BitSet(new long[]{0x0000000000000800L,0x0000000000004000L});
    public static final BitSet FOLLOW_PC_in_op1900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESCRIPTION_in_description1923 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_FOR_in_description1925 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_feature_in_description1927 = new BitSet(new long[]{0x0000000000000000L,0x0000000006004180L});
    public static final BitSet FOLLOW_78_in_description1930 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_feature_in_description1932 = new BitSet(new long[]{0x0000000000000000L,0x0000000006004180L});
    public static final BitSet FOLLOW_key_value_prop_in_description1942 = new BitSet(new long[]{0x0000000000000002L,0x0000000006004180L});
    public static final BitSet FOLLOW_MONITORABLEPROPERTIES_in_monitorableProperties1966 = new BitSet(new long[]{0x0020000800000002L,0x0000000000000080L});
    public static final BitSet FOLLOW_IDENT_in_monitorableProperties1969 = new BitSet(new long[]{0x0020000800000002L});
    public static final BitSet FOLLOW_global_MonitorableProperties_in_monitorableProperties1973 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_local_MonitorableProperties_in_monitorableProperties1976 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_GLOBAL_in_global_MonitorableProperties2005 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DP_in_global_MonitorableProperties2007 = new BitSet(new long[]{0x0000000000000000L,0x0000000006004180L});
    public static final BitSet FOLLOW_key_value_prop_in_global_MonitorableProperties2012 = new BitSet(new long[]{0x0000000000000002L,0x0000000006004180L});
    public static final BitSet FOLLOW_FOR_in_local_MonitorableProperties2052 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_IDENT_in_local_MonitorableProperties2054 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DP_in_local_MonitorableProperties2056 = new BitSet(new long[]{0x0000000000000000L,0x0000000006004180L});
    public static final BitSet FOLLOW_key_value_prop_in_local_MonitorableProperties2058 = new BitSet(new long[]{0x0000000000000002L,0x0000000006004180L});
    public static final BitSet FOLLOW_GUARANTEE_TERMS_in_guaranteeTerms2084 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000088L});
    public static final BitSet FOLLOW_guaranteeTerm_in_guaranteeTerms2091 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000088L});
    public static final BitSet FOLLOW_LABEL_in_guaranteeTerm2124 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_IDENT_in_guaranteeTerm2128 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DP_in_guaranteeTerm2131 = new BitSet(new long[]{0x0600000000000000L,0x0000000001C00000L});
    public static final BitSet FOLLOW_guarantee_def_in_guaranteeTerm2136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cuantif_in_guaranteeTerm2142 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_79_in_guaranteeTerm2144 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000088L});
    public static final BitSet FOLLOW_grouped_guaranteeTerm_in_guaranteeTerm2148 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_END_in_guaranteeTerm2150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_guaranteeTerm_in_grouped_guaranteeTerm2180 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000088L});
    public static final BitSet FOLLOW_PROVIDER_in_guarantee_def2214 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_CONSUMER_in_guarantee_def2220 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_GUARANTEES_in_guarantee_def2223 = new BitSet(new long[]{0x0000000000800400L,0x0000000000000980L});
    public static final BitSet FOLLOW_expression_in_guarantee_def2225 = new BitSet(new long[]{0x0000000040000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_temporality_in_guarantee_def2227 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_guarantee_def2230 = new BitSet(new long[]{0x1800000000000002L});
    public static final BitSet FOLLOW_upon_sentence_in_guarantee_def2233 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_onlyif_sentence_in_guarantee_def2240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPON_in_upon_sentence2274 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_IDENT_in_upon_sentence2276 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_upon_sentence2278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ONLY_IF_in_onlyif_sentence2300 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_PA_in_onlyif_sentence2302 = new BitSet(new long[]{0x0000000000800400L,0x0000000000000980L});
    public static final BitSet FOLLOW_expression_in_onlyif_sentence2304 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_PC_in_onlyif_sentence2306 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_onlyif_sentence2308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_assig_value2336 = new BitSet(new long[]{0xA000000000000002L,0x00000000000F08C0L});
    public static final BitSet FOLLOW_operation_in_assig_value2358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUE_in_assig_value2369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FALSE_in_assig_value2379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_assig_value2389 = new BitSet(new long[]{0x0000000000000002L,0x00000000003F0000L});
    public static final BitSet FOLLOW_unit_in_assig_value2394 = new BitSet(new long[]{0x0000000000000002L,0x00000000000F0000L});
    public static final BitSet FOLLOW_operation_in_assig_value2399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SFLOAT_in_assig_value2411 = new BitSet(new long[]{0x0000000000000002L,0x00000000003F0000L});
    public static final BitSet FOLLOW_unit_in_assig_value2416 = new BitSet(new long[]{0x0000000000000002L,0x00000000000F0000L});
    public static final BitSet FOLLOW_operation_in_assig_value2421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SINT_in_assig_value2433 = new BitSet(new long[]{0x0000000000000002L,0x00000000003F0000L});
    public static final BitSet FOLLOW_unit_in_assig_value2438 = new BitSet(new long[]{0x0000000000000002L,0x00000000000F0000L});
    public static final BitSet FOLLOW_operation_in_assig_value2443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_list_in_assig_value2455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_80_in_operation2485 = new BitSet(new long[]{0xA00000000C001000L,0x00000000000008C7L});
    public static final BitSet FOLLOW_81_in_operation2489 = new BitSet(new long[]{0xA00000000C001000L,0x00000000000008C7L});
    public static final BitSet FOLLOW_82_in_operation2493 = new BitSet(new long[]{0xA00000000C001000L,0x00000000000008C7L});
    public static final BitSet FOLLOW_83_in_operation2497 = new BitSet(new long[]{0xA00000000C001000L,0x00000000000008C7L});
    public static final BitSet FOLLOW_assig_value_in_operation2500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_unit0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LLA_in_list2540 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000887L});
    public static final BitSet FOLLOW_IDENT_in_list2545 = new BitSet(new long[]{0x0000000000002000L,0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_list2549 = new BitSet(new long[]{0x0000000000002000L,0x0000000000004000L});
    public static final BitSet FOLLOW_INT_in_list2553 = new BitSet(new long[]{0x0000000000002000L,0x0000000000004000L});
    public static final BitSet FOLLOW_SINT_in_list2557 = new BitSet(new long[]{0x0000000000002000L,0x0000000000004000L});
    public static final BitSet FOLLOW_FLOAT_in_list2561 = new BitSet(new long[]{0x0000000000002000L,0x0000000000004000L});
    public static final BitSet FOLLOW_SFLOAT_in_list2565 = new BitSet(new long[]{0x0000000000002000L,0x0000000000004000L});
    public static final BitSet FOLLOW_78_in_list2571 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000887L});
    public static final BitSet FOLLOW_IDENT_in_list2576 = new BitSet(new long[]{0x0000000000002000L,0x0000000000004000L});
    public static final BitSet FOLLOW_STRING_in_list2580 = new BitSet(new long[]{0x0000000000002000L,0x0000000000004000L});
    public static final BitSet FOLLOW_INT_in_list2584 = new BitSet(new long[]{0x0000000000002000L,0x0000000000004000L});
    public static final BitSet FOLLOW_SINT_in_list2588 = new BitSet(new long[]{0x0000000000002000L,0x0000000000004000L});
    public static final BitSet FOLLOW_FLOAT_in_list2592 = new BitSet(new long[]{0x0000000000002000L,0x0000000000004000L});
    public static final BitSet FOLLOW_SFLOAT_in_list2596 = new BitSet(new long[]{0x0000000000002000L,0x0000000000004000L});
    public static final BitSet FOLLOW_LLC_in_list2603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_NOT_in_expression2627 = new BitSet(new long[]{0x0000000000800400L,0x0000000000000980L});
    public static final BitSet FOLLOW_expression_in_expression2631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PA_in_expression2646 = new BitSet(new long[]{0x0000000000800400L,0x0000000000000980L});
    public static final BitSet FOLLOW_expression_in_expression2650 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_PC_in_expression2652 = new BitSet(new long[]{0x0000000001600002L});
    public static final BitSet FOLLOW_set_in_expression2657 = new BitSet(new long[]{0x0000000000800400L,0x0000000000000980L});
    public static final BitSet FOLLOW_expression_in_expression2667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_expression2687 = new BitSet(new long[]{0x00000000017F0002L});
    public static final BitSet FOLLOW_ACCESS_in_expression2691 = new BitSet(new long[]{0x00000000017F0002L});
    public static final BitSet FOLLOW_STRING_in_expression2695 = new BitSet(new long[]{0x00000000017F0002L});
    public static final BitSet FOLLOW_set_in_expression2702 = new BitSet(new long[]{0xA00000000C001000L,0x00000000000008C7L});
    public static final BitSet FOLLOW_assig_value_in_expression2716 = new BitSet(new long[]{0x0000000001600002L});
    public static final BitSet FOLLOW_set_in_expression2723 = new BitSet(new long[]{0x0000000000800400L,0x0000000000000980L});
    public static final BitSet FOLLOW_expression_in_expression2733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_expression2753 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ACCESS_in_expression2757 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_BELONGS_in_expression2760 = new BitSet(new long[]{0xA00000000C001000L,0x00000000000008C7L});
    public static final BitSet FOLLOW_list_in_expression2764 = new BitSet(new long[]{0x0000000001600002L});
    public static final BitSet FOLLOW_set_in_expression2769 = new BitSet(new long[]{0x0000000000800400L,0x0000000000000980L});
    public static final BitSet FOLLOW_expression_in_expression2779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_86_in_cuantif2809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_87_in_cuantif2819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_88_in_cuantif2829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_key_value_prop2855 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_ACCESS_in_key_value_prop2859 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_89_in_key_value_prop2863 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_90_in_key_value_prop2867 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DP_in_key_value_prop2870 = new BitSet(new long[]{0x0000000000000000L,0x00000000FE000880L});
    public static final BitSet FOLLOW_STRING_in_key_value_prop2875 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_type_in_key_value_prop2881 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_IGUAL_in_key_value_prop2886 = new BitSet(new long[]{0xA00000000C001000L,0x00000000000008C7L});
    public static final BitSet FOLLOW_assig_value_in_key_value_prop2890 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_key_value_prop2892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_90_in_type2927 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_91_in_type2933 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_92_in_type2939 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_93_in_type2945 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_89_in_type2951 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_range_in_type2963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_type2976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_94_in_type2988 = new BitSet(new long[]{0xA00000000C001000L,0x00000000000008C7L});
    public static final BitSet FOLLOW_list_in_type2990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_95_in_type3002 = new BitSet(new long[]{0xA00000000C001000L,0x00000000000008C7L});
    public static final BitSet FOLLOW_list_in_type3004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CA_in_range3031 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_RANGE_in_range3033 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CC_in_range3035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CA_in_range3050 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_INT_in_range3055 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_SINT_in_range3059 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_RANGE_SEPARATOR_in_range3062 = new BitSet(new long[]{0x8000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_INT_in_range3067 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_SINT_in_range3071 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_CC_in_range3074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_in_url3095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_METRICS_in_metrics_prop3117 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_DP_in_metrics_prop3123 = new BitSet(new long[]{0x0000000000000000L,0x0000000006004180L});
    public static final BitSet FOLLOW_key_value_prop_in_metrics_prop3128 = new BitSet(new long[]{0x0000000000000002L,0x0000000006004180L});
    public static final BitSet FOLLOW_GLOBALDESCRIPTION_in_globalDescription3166 = new BitSet(new long[]{0x0000000000000000L,0x0000000006004180L});
    public static final BitSet FOLLOW_key_value_prop_in_globalDescription3171 = new BitSet(new long[]{0x0000000000000002L,0x0000000006004180L});

}