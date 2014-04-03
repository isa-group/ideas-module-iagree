// $ANTLR 3.2 Sep 23, 2009 12:02:23 C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g 2013-07-15 16:30:17

  package es.us.isa.iagreeparser;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SampleLexer extends Lexer {
    public static final int LETTER=61;
    public static final int SINT=64;
    public static final int DP=14;
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
    public static final int IMPLIES=24;
    public static final int T__81=81;
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
    public static final int METRICS=45;
    public static final int T__86=86;
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
    public static final int GLOBAL=53;
    public static final int DATE=73;
    public static final int BELONGS=25;
    public static final int STRING=75;

    // delegates
    // delegators

    public SampleLexer() {;} 
    public SampleLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public SampleLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g"; }

    // $ANTLR start "T__76"
    public final void mT__76() throws RecognitionException {
        try {
            int _type = T__76;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:11:7: ( 'version' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:11:9: 'version'
            {
            match("version"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__76"

    // $ANTLR start "T__77"
    public final void mT__77() throws RecognitionException {
        try {
            int _type = T__77;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:12:7: ( ';' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:12:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__77"

    // $ANTLR start "T__78"
    public final void mT__78() throws RecognitionException {
        try {
            int _type = T__78;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:13:7: ( ',' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:13:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__78"

    // $ANTLR start "T__79"
    public final void mT__79() throws RecognitionException {
        try {
            int _type = T__79;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:14:7: ( 'of' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:14:9: 'of'
            {
            match("of"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__79"

    // $ANTLR start "T__80"
    public final void mT__80() throws RecognitionException {
        try {
            int _type = T__80;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:15:7: ( '+' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:15:9: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__80"

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:16:7: ( '-' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:16:9: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:17:7: ( '*' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:17:9: '*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:18:7: ( '/' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:18:9: '/'
            {
            match('/'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:19:7: ( '%' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:19:9: '%'
            {
            match('%'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:20:7: ( 'min' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:20:9: 'min'
            {
            match("min"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:21:7: ( 'exactly one' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:21:9: 'exactly one'
            {
            match("exactly one"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:22:7: ( 'one or more' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:22:9: 'one or more'
            {
            match("one or more"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:23:7: ( 'all' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:23:9: 'all'
            {
            match("all"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:24:7: ( 'boolean' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:24:9: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:25:7: ( 'integer' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:25:9: 'integer'
            {
            match("integer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:26:7: ( 'float' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:26:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:27:7: ( 'natural' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:27:9: 'natural'
            {
            match("natural"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:28:7: ( 'number' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:28:9: 'number'
            {
            match("number"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:29:7: ( 'set' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:29:9: 'set'
            {
            match("set"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:30:7: ( 'enum' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:30:9: 'enum'
            {
            match("enum"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "COMMENT_LINE"
    public final void mCOMMENT_LINE() throws RecognitionException {
        try {
            int _type = COMMENT_LINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:105:5: ( '//' (~ ( '\\n' | '\\r' ) )* '\\n' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:105:7: '//' (~ ( '\\n' | '\\r' ) )* '\\n'
            {
            match("//"); 

            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:105:12: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:105:12: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match('\n'); 
            _channel = HIDDEN; skip();

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT_LINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:109:4: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:109:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:109:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='\t' && LA2_0<='\n')||(LA2_0>='\f' && LA2_0<='\r')||LA2_0==' ') ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||(input.LA(1)>='\f' && input.LA(1)<='\r')||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);

            _channel = HIDDEN;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "CA"
    public final void mCA() throws RecognitionException {
        try {
            int _type = CA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:112:4: ( '[' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:112:6: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CA"

    // $ANTLR start "CC"
    public final void mCC() throws RecognitionException {
        try {
            int _type = CC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:113:4: ( ']' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:113:6: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CC"

    // $ANTLR start "PA"
    public final void mPA() throws RecognitionException {
        try {
            int _type = PA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:114:4: ( '(' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:114:6: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PA"

    // $ANTLR start "PC"
    public final void mPC() throws RecognitionException {
        try {
            int _type = PC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:115:4: ( ')' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:115:6: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PC"

    // $ANTLR start "LLA"
    public final void mLLA() throws RecognitionException {
        try {
            int _type = LLA;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:116:5: ( '{' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:116:7: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LLA"

    // $ANTLR start "LLC"
    public final void mLLC() throws RecognitionException {
        try {
            int _type = LLC;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:117:5: ( '}' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:117:7: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LLC"

    // $ANTLR start "DP"
    public final void mDP() throws RecognitionException {
        try {
            int _type = DP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:118:4: ( ':' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:118:6: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DP"

    // $ANTLR start "RANGE_SEPARATOR"
    public final void mRANGE_SEPARATOR() throws RecognitionException {
        try {
            int _type = RANGE_SEPARATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:119:17: ( '..' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:119:19: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGE_SEPARATOR"

    // $ANTLR start "MENOR"
    public final void mMENOR() throws RecognitionException {
        try {
            int _type = MENOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:121:7: ( '<' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:121:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MENOR"

    // $ANTLR start "MAYOR"
    public final void mMAYOR() throws RecognitionException {
        try {
            int _type = MAYOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:122:7: ( '>' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:122:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MAYOR"

    // $ANTLR start "IGUAL"
    public final void mIGUAL() throws RecognitionException {
        try {
            int _type = IGUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:123:7: ( '=' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:123:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IGUAL"

    // $ANTLR start "MENOR_IGUAL"
    public final void mMENOR_IGUAL() throws RecognitionException {
        try {
            int _type = MENOR_IGUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:124:13: ( '<=' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:124:15: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MENOR_IGUAL"

    // $ANTLR start "MAYOR_IGUAL"
    public final void mMAYOR_IGUAL() throws RecognitionException {
        try {
            int _type = MAYOR_IGUAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:125:13: ( '>=' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:125:15: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MAYOR_IGUAL"

    // $ANTLR start "AND"
    public final void mAND() throws RecognitionException {
        try {
            int _type = AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:127:5: ( 'AND' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:127:7: 'AND'
            {
            match("AND"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AND"

    // $ANTLR start "OR"
    public final void mOR() throws RecognitionException {
        try {
            int _type = OR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:128:4: ( 'OR' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:128:6: 'OR'
            {
            match("OR"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OR"

    // $ANTLR start "NOT"
    public final void mNOT() throws RecognitionException {
        try {
            int _type = NOT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:129:5: ( 'NOT' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:129:7: 'NOT'
            {
            match("NOT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NOT"

    // $ANTLR start "IMPLIES"
    public final void mIMPLIES() throws RecognitionException {
        try {
            int _type = IMPLIES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:130:9: ( 'IMPLIES' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:130:11: 'IMPLIES'
            {
            match("IMPLIES"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IMPLIES"

    // $ANTLR start "BELONGS"
    public final void mBELONGS() throws RecognitionException {
        try {
            int _type = BELONGS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:131:9: ( 'belongs' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:131:11: 'belongs'
            {
            match("belongs"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BELONGS"

    // $ANTLR start "TRUE"
    public final void mTRUE() throws RecognitionException {
        try {
            int _type = TRUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:133:6: ( 'true' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:133:8: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TRUE"

    // $ANTLR start "FALSE"
    public final void mFALSE() throws RecognitionException {
        try {
            int _type = FALSE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:134:7: ( 'false' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:134:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FALSE"

    // $ANTLR start "EXCEPT"
    public final void mEXCEPT() throws RecognitionException {
        try {
            int _type = EXCEPT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:136:8: ( 'except' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:136:10: 'except'
            {
            match("except"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXCEPT"

    // $ANTLR start "DURING"
    public final void mDURING() throws RecognitionException {
        try {
            int _type = DURING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:137:8: ( 'during' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:137:10: 'during'
            {
            match("during"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DURING"

    // $ANTLR start "ON"
    public final void mON() throws RecognitionException {
        try {
            int _type = ON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:138:4: ( 'on' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:138:6: 'on'
            {
            match("on"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ON"

    // $ANTLR start "FROM"
    public final void mFROM() throws RecognitionException {
        try {
            int _type = FROM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:139:6: ( 'from' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:139:8: 'from'
            {
            match("from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FROM"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:141:5: ( 'end' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:141:7: 'end'
            {
            match("end"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "TEMPLATE"
    public final void mTEMPLATE() throws RecognitionException {
        try {
            int _type = TEMPLATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:143:10: ( 'Template' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:143:12: 'Template'
            {
            match("Template"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "TEMPLATE"

    // $ANTLR start "END_TEMPLATE"
    public final void mEND_TEMPLATE() throws RecognitionException {
        try {
            int _type = END_TEMPLATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:144:14: ( 'EndTemplate' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:144:16: 'EndTemplate'
            {
            match("EndTemplate"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END_TEMPLATE"

    // $ANTLR start "AG_OFFER"
    public final void mAG_OFFER() throws RecognitionException {
        try {
            int _type = AG_OFFER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:146:10: ( 'AgreementOffer' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:146:12: 'AgreementOffer'
            {
            match("AgreementOffer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AG_OFFER"

    // $ANTLR start "END_AG_OFFER"
    public final void mEND_AG_OFFER() throws RecognitionException {
        try {
            int _type = END_AG_OFFER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:147:14: ( 'EndAgreementOffer' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:147:16: 'EndAgreementOffer'
            {
            match("EndAgreementOffer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END_AG_OFFER"

    // $ANTLR start "FOR"
    public final void mFOR() throws RecognitionException {
        try {
            int _type = FOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:149:5: ( 'for' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:149:7: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FOR"

    // $ANTLR start "AS"
    public final void mAS() throws RecognitionException {
        try {
            int _type = AS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:150:4: ( 'as' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:150:6: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AS"

    // $ANTLR start "INITIATOR"
    public final void mINITIATOR() throws RecognitionException {
        try {
            int _type = INITIATOR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:152:11: ( 'Initiator' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:152:13: 'Initiator'
            {
            match("Initiator"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INITIATOR"

    // $ANTLR start "RESPONDER"
    public final void mRESPONDER() throws RecognitionException {
        try {
            int _type = RESPONDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:153:11: ( 'Responder' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:153:13: 'Responder'
            {
            match("Responder"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RESPONDER"

    // $ANTLR start "SERVICEPROVIDER"
    public final void mSERVICEPROVIDER() throws RecognitionException {
        try {
            int _type = SERVICEPROVIDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:154:17: ( 'ServiceProvider' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:154:19: 'ServiceProvider'
            {
            match("ServiceProvider"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SERVICEPROVIDER"

    // $ANTLR start "EXPIRATIONTIME"
    public final void mEXPIRATIONTIME() throws RecognitionException {
        try {
            int _type = EXPIRATIONTIME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:155:16: ( 'ExpirationTime' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:155:18: 'ExpirationTime'
            {
            match("ExpirationTime"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EXPIRATIONTIME"

    // $ANTLR start "DATEFORMAT"
    public final void mDATEFORMAT() throws RecognitionException {
        try {
            int _type = DATEFORMAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:156:12: ( 'DateFormat' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:156:14: 'DateFormat'
            {
            match("DateFormat"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DATEFORMAT"

    // $ANTLR start "GMTZONE"
    public final void mGMTZONE() throws RecognitionException {
        try {
            int _type = GMTZONE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:157:9: ( 'GMTZone' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:157:11: 'GMTZone'
            {
            match("GMTZone"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GMTZONE"

    // $ANTLR start "GLOBALPERIOD"
    public final void mGLOBALPERIOD() throws RecognitionException {
        try {
            int _type = GLOBALPERIOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:158:14: ( 'GlobalPeriod' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:158:16: 'GlobalPeriod'
            {
            match("GlobalPeriod"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GLOBALPERIOD"

    // $ANTLR start "DEFINEDPERIOD"
    public final void mDEFINEDPERIOD() throws RecognitionException {
        try {
            int _type = DEFINEDPERIOD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:159:15: ( 'DefinedPeriod' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:159:17: 'DefinedPeriod'
            {
            match("DefinedPeriod"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEFINEDPERIOD"

    // $ANTLR start "METRICS"
    public final void mMETRICS() throws RecognitionException {
        try {
            int _type = METRICS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:160:9: ( 'Metrics' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:160:11: 'Metrics'
            {
            match("Metrics"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "METRICS"

    // $ANTLR start "AGREEMENT_TERMS"
    public final void mAGREEMENT_TERMS() throws RecognitionException {
        try {
            int _type = AGREEMENT_TERMS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:162:17: ( 'AgreementTerms' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:162:19: 'AgreementTerms'
            {
            match("AgreementTerms"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AGREEMENT_TERMS"

    // $ANTLR start "CREATION_CONSTRAINTS"
    public final void mCREATION_CONSTRAINTS() throws RecognitionException {
        try {
            int _type = CREATION_CONSTRAINTS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:163:22: ( 'CreationConstraints' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:163:24: 'CreationConstraints'
            {
            match("CreationConstraints"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CREATION_CONSTRAINTS"

    // $ANTLR start "GUARANTEE_TERMS"
    public final void mGUARANTEE_TERMS() throws RecognitionException {
        try {
            int _type = GUARANTEE_TERMS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:164:17: ( 'GuaranteeTerms' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:164:19: 'GuaranteeTerms'
            {
            match("GuaranteeTerms"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GUARANTEE_TERMS"

    // $ANTLR start "SERVICE"
    public final void mSERVICE() throws RecognitionException {
        try {
            int _type = SERVICE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:166:9: ( 'Service' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:166:11: 'Service'
            {
            match("Service"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SERVICE"

    // $ANTLR start "FEATURES"
    public final void mFEATURES() throws RecognitionException {
        try {
            int _type = FEATURES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:167:9: ( 'Features/Operations' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:167:11: 'Features/Operations'
            {
            match("Features/Operations"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FEATURES"

    // $ANTLR start "GLOBALDESCRIPTION"
    public final void mGLOBALDESCRIPTION() throws RecognitionException {
        try {
            int _type = GLOBALDESCRIPTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:168:19: ( 'GlobalDescription' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:168:21: 'GlobalDescription'
            {
            match("GlobalDescription"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GLOBALDESCRIPTION"

    // $ANTLR start "DESCRIPTION"
    public final void mDESCRIPTION() throws RecognitionException {
        try {
            int _type = DESCRIPTION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:169:13: ( 'Description' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:169:15: 'Description'
            {
            match("Description"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DESCRIPTION"

    // $ANTLR start "GLOBAL"
    public final void mGLOBAL() throws RecognitionException {
        try {
            int _type = GLOBAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:170:8: ( 'global' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:170:10: 'global'
            {
            match("global"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GLOBAL"

    // $ANTLR start "MONITORABLEPROPERTIES"
    public final void mMONITORABLEPROPERTIES() throws RecognitionException {
        try {
            int _type = MONITORABLEPROPERTIES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:171:23: ( 'MonitorableProperties' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:171:25: 'MonitorableProperties'
            {
            match("MonitorableProperties"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MONITORABLEPROPERTIES"

    // $ANTLR start "GUARANTEES"
    public final void mGUARANTEES() throws RecognitionException {
        try {
            int _type = GUARANTEES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:172:12: ( 'guarantees' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:172:14: 'guarantees'
            {
            match("guarantees"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GUARANTEES"

    // $ANTLR start "AVAL_AT"
    public final void mAVAL_AT() throws RecognitionException {
        try {
            int _type = AVAL_AT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:174:9: ( 'availableAt.' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:174:11: 'availableAt.'
            {
            match("availableAt."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AVAL_AT"

    // $ANTLR start "PROVIDER"
    public final void mPROVIDER() throws RecognitionException {
        try {
            int _type = PROVIDER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:176:10: ( 'Provider' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:176:12: 'Provider'
            {
            match("Provider"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROVIDER"

    // $ANTLR start "CONSUMER"
    public final void mCONSUMER() throws RecognitionException {
        try {
            int _type = CONSUMER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:177:10: ( 'Consumer' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:177:12: 'Consumer'
            {
            match("Consumer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CONSUMER"

    // $ANTLR start "UPON"
    public final void mUPON() throws RecognitionException {
        try {
            int _type = UPON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:179:6: ( 'upon' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:179:8: 'upon'
            {
            match("upon"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UPON"

    // $ANTLR start "ONLY_IF"
    public final void mONLY_IF() throws RecognitionException {
        try {
            int _type = ONLY_IF;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:180:9: ( 'onlyIf' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:180:11: 'onlyIf'
            {
            match("onlyIf"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ONLY_IF"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:182:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:182:19: ( 'a' .. 'z' | 'A' .. 'Z' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:183:16: ( '0' .. '9' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:183:18: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "INT"
    public final void mINT() throws RecognitionException {
        try {
            int _type = INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:185:5: ( ( DIGIT )+ )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:185:7: ( DIGIT )+
            {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:185:7: ( DIGIT )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:185:7: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INT"

    // $ANTLR start "SINT"
    public final void mSINT() throws RecognitionException {
        try {
            int _type = SINT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:186:6: ( ( '+' | '-' ) INT )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:186:8: ( '+' | '-' ) INT
            {
            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mINT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SINT"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:187:7: ( INT '.' INT )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:187:9: INT '.' INT
            {
            mINT(); 
            match('.'); 
            mINT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "SFLOAT"
    public final void mSFLOAT() throws RecognitionException {
        try {
            int _type = SFLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:188:8: ( ( '+' | '-' ) FLOAT )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:188:10: ( '+' | '-' ) FLOAT
            {
            if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mFLOAT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "SFLOAT"

    // $ANTLR start "LABEL"
    public final void mLABEL() throws RecognitionException {
        try {
            int _type = LABEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:190:7: ( ( LETTER | DIGIT | '_' )+ ( '.' ( LETTER | DIGIT | '_' ) )+ )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:190:9: ( LETTER | DIGIT | '_' )+ ( '.' ( LETTER | DIGIT | '_' ) )+
            {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:190:9: ( LETTER | DIGIT | '_' )+
            int cnt4=0;
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>='0' && LA4_0<='9')||(LA4_0>='A' && LA4_0<='Z')||LA4_0=='_'||(LA4_0>='a' && LA4_0<='z')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt4 >= 1 ) break loop4;
                        EarlyExitException eee =
                            new EarlyExitException(4, input);
                        throw eee;
                }
                cnt4++;
            } while (true);

            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:190:29: ( '.' ( LETTER | DIGIT | '_' ) )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0=='.') ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:190:30: '.' ( LETTER | DIGIT | '_' )
            	    {
            	    match('.'); 
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LABEL"

    // $ANTLR start "RANGE"
    public final void mRANGE() throws RecognitionException {
        try {
            int _type = RANGE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:192:7: ( INT RANGE_SEPARATOR INT | INT RANGE_SEPARATOR SINT | SINT RANGE_SEPARATOR INT | SINT RANGE_SEPARATOR SINT )
            int alt6=4;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:192:9: INT RANGE_SEPARATOR INT
                    {
                    mINT(); 
                    mRANGE_SEPARATOR(); 
                    mINT(); 

                    }
                    break;
                case 2 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:193:6: INT RANGE_SEPARATOR SINT
                    {
                    mINT(); 
                    mRANGE_SEPARATOR(); 
                    mSINT(); 

                    }
                    break;
                case 3 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:194:6: SINT RANGE_SEPARATOR INT
                    {
                    mSINT(); 
                    mRANGE_SEPARATOR(); 
                    mINT(); 

                    }
                    break;
                case 4 :
                    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:195:6: SINT RANGE_SEPARATOR SINT
                    {
                    mSINT(); 
                    mRANGE_SEPARATOR(); 
                    mSINT(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGE"

    // $ANTLR start "VERSION"
    public final void mVERSION() throws RecognitionException {
        try {
            int _type = VERSION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:197:9: ( INT ( '.' INT )+ )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:197:11: INT ( '.' INT )+
            {
            mINT(); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:197:15: ( '.' INT )+
            int cnt7=0;
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='.') ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:197:16: '.' INT
            	    {
            	    match('.'); 
            	    mINT(); 

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


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VERSION"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:199:7: ( ( LETTER | '_' ) VALUE )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:199:9: ( LETTER | '_' ) VALUE
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            mVALUE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "VALUE"
    public final void mVALUE() throws RecognitionException {
        try {
            int _type = VALUE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:201:7: ( ( LETTER | DIGIT | '_' | '-' | '+' | '%' )* )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:201:9: ( LETTER | DIGIT | '_' | '-' | '+' | '%' )*
            {
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:201:9: ( LETTER | DIGIT | '_' | '-' | '+' | '%' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0=='%'||LA8_0=='+'||LA8_0=='-'||(LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='Z')||LA8_0=='_'||(LA8_0>='a' && LA8_0<='z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:
            	    {
            	    if ( input.LA(1)=='%'||input.LA(1)=='+'||input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VALUE"

    // $ANTLR start "ACCESS"
    public final void mACCESS() throws RecognitionException {
        try {
            int _type = ACCESS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:203:8: ( IDENT ( '.' IDENT )+ )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:203:10: IDENT ( '.' IDENT )+
            {
            mIDENT(); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:203:16: ( '.' IDENT )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='.') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:203:17: '.' IDENT
            	    {
            	    match('.'); 
            	    mIDENT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ACCESS"

    // $ANTLR start "DATE"
    public final void mDATE() throws RecognitionException {
        try {
            int _type = DATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:205:6: ( INT ( INT | '/' | '-' )+ )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:205:8: INT ( INT | '/' | '-' )+
            {
            mINT(); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:205:12: ( INT | '/' | '-' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=4;
                switch ( input.LA(1) ) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt10=1;
                    }
                    break;
                case '/':
                    {
                    alt10=2;
                    }
                    break;
                case '-':
                    {
                    alt10=3;
                    }
                    break;

                }

                switch (alt10) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:205:13: INT
            	    {
            	    mINT(); 

            	    }
            	    break;
            	case 2 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:205:19: '/'
            	    {
            	    match('/'); 

            	    }
            	    break;
            	case 3 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:205:25: '-'
            	    {
            	    match('-'); 

            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DATE"

    // $ANTLR start "HOUR"
    public final void mHOUR() throws RecognitionException {
        try {
            int _type = HOUR;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:206:6: ( DIGIT DIGIT DP DIGIT DIGIT )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:206:8: DIGIT DIGIT DP DIGIT DIGIT
            {
            mDIGIT(); 
            mDIGIT(); 
            mDP(); 
            mDIGIT(); 
            mDIGIT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HOUR"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:209:2: ( '\"' (~ ( '\"' | '\\r' | '\\n' ) )* '\"' )
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:209:4: '\"' (~ ( '\"' | '\\r' | '\\n' ) )* '\"'
            {
            match('\"'); 
            // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:209:8: (~ ( '\"' | '\\r' | '\\n' ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\u0000' && LA11_0<='\t')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='!')||(LA11_0>='#' && LA11_0<='\uFFFF')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:209:9: ~ ( '\"' | '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            match('\"'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    public void mTokens() throws RecognitionException {
        // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:8: ( T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | COMMENT_LINE | WS | CA | CC | PA | PC | LLA | LLC | DP | RANGE_SEPARATOR | MENOR | MAYOR | IGUAL | MENOR_IGUAL | MAYOR_IGUAL | AND | OR | NOT | IMPLIES | BELONGS | TRUE | FALSE | EXCEPT | DURING | ON | FROM | END | TEMPLATE | END_TEMPLATE | AG_OFFER | END_AG_OFFER | FOR | AS | INITIATOR | RESPONDER | SERVICEPROVIDER | EXPIRATIONTIME | DATEFORMAT | GMTZONE | GLOBALPERIOD | DEFINEDPERIOD | METRICS | AGREEMENT_TERMS | CREATION_CONSTRAINTS | GUARANTEE_TERMS | SERVICE | FEATURES | GLOBALDESCRIPTION | DESCRIPTION | GLOBAL | MONITORABLEPROPERTIES | GUARANTEES | AVAL_AT | PROVIDER | CONSUMER | UPON | ONLY_IF | INT | SINT | FLOAT | SFLOAT | LABEL | RANGE | VERSION | IDENT | VALUE | ACCESS | DATE | HOUR | STRING )
        int alt12=90;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:10: T__76
                {
                mT__76(); 

                }
                break;
            case 2 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:16: T__77
                {
                mT__77(); 

                }
                break;
            case 3 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:22: T__78
                {
                mT__78(); 

                }
                break;
            case 4 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:28: T__79
                {
                mT__79(); 

                }
                break;
            case 5 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:34: T__80
                {
                mT__80(); 

                }
                break;
            case 6 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:40: T__81
                {
                mT__81(); 

                }
                break;
            case 7 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:46: T__82
                {
                mT__82(); 

                }
                break;
            case 8 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:52: T__83
                {
                mT__83(); 

                }
                break;
            case 9 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:58: T__84
                {
                mT__84(); 

                }
                break;
            case 10 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:64: T__85
                {
                mT__85(); 

                }
                break;
            case 11 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:70: T__86
                {
                mT__86(); 

                }
                break;
            case 12 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:76: T__87
                {
                mT__87(); 

                }
                break;
            case 13 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:82: T__88
                {
                mT__88(); 

                }
                break;
            case 14 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:88: T__89
                {
                mT__89(); 

                }
                break;
            case 15 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:94: T__90
                {
                mT__90(); 

                }
                break;
            case 16 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:100: T__91
                {
                mT__91(); 

                }
                break;
            case 17 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:106: T__92
                {
                mT__92(); 

                }
                break;
            case 18 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:112: T__93
                {
                mT__93(); 

                }
                break;
            case 19 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:118: T__94
                {
                mT__94(); 

                }
                break;
            case 20 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:124: T__95
                {
                mT__95(); 

                }
                break;
            case 21 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:130: COMMENT_LINE
                {
                mCOMMENT_LINE(); 

                }
                break;
            case 22 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:143: WS
                {
                mWS(); 

                }
                break;
            case 23 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:146: CA
                {
                mCA(); 

                }
                break;
            case 24 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:149: CC
                {
                mCC(); 

                }
                break;
            case 25 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:152: PA
                {
                mPA(); 

                }
                break;
            case 26 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:155: PC
                {
                mPC(); 

                }
                break;
            case 27 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:158: LLA
                {
                mLLA(); 

                }
                break;
            case 28 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:162: LLC
                {
                mLLC(); 

                }
                break;
            case 29 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:166: DP
                {
                mDP(); 

                }
                break;
            case 30 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:169: RANGE_SEPARATOR
                {
                mRANGE_SEPARATOR(); 

                }
                break;
            case 31 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:185: MENOR
                {
                mMENOR(); 

                }
                break;
            case 32 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:191: MAYOR
                {
                mMAYOR(); 

                }
                break;
            case 33 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:197: IGUAL
                {
                mIGUAL(); 

                }
                break;
            case 34 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:203: MENOR_IGUAL
                {
                mMENOR_IGUAL(); 

                }
                break;
            case 35 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:215: MAYOR_IGUAL
                {
                mMAYOR_IGUAL(); 

                }
                break;
            case 36 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:227: AND
                {
                mAND(); 

                }
                break;
            case 37 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:231: OR
                {
                mOR(); 

                }
                break;
            case 38 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:234: NOT
                {
                mNOT(); 

                }
                break;
            case 39 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:238: IMPLIES
                {
                mIMPLIES(); 

                }
                break;
            case 40 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:246: BELONGS
                {
                mBELONGS(); 

                }
                break;
            case 41 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:254: TRUE
                {
                mTRUE(); 

                }
                break;
            case 42 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:259: FALSE
                {
                mFALSE(); 

                }
                break;
            case 43 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:265: EXCEPT
                {
                mEXCEPT(); 

                }
                break;
            case 44 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:272: DURING
                {
                mDURING(); 

                }
                break;
            case 45 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:279: ON
                {
                mON(); 

                }
                break;
            case 46 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:282: FROM
                {
                mFROM(); 

                }
                break;
            case 47 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:287: END
                {
                mEND(); 

                }
                break;
            case 48 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:291: TEMPLATE
                {
                mTEMPLATE(); 

                }
                break;
            case 49 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:300: END_TEMPLATE
                {
                mEND_TEMPLATE(); 

                }
                break;
            case 50 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:313: AG_OFFER
                {
                mAG_OFFER(); 

                }
                break;
            case 51 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:322: END_AG_OFFER
                {
                mEND_AG_OFFER(); 

                }
                break;
            case 52 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:335: FOR
                {
                mFOR(); 

                }
                break;
            case 53 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:339: AS
                {
                mAS(); 

                }
                break;
            case 54 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:342: INITIATOR
                {
                mINITIATOR(); 

                }
                break;
            case 55 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:352: RESPONDER
                {
                mRESPONDER(); 

                }
                break;
            case 56 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:362: SERVICEPROVIDER
                {
                mSERVICEPROVIDER(); 

                }
                break;
            case 57 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:378: EXPIRATIONTIME
                {
                mEXPIRATIONTIME(); 

                }
                break;
            case 58 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:393: DATEFORMAT
                {
                mDATEFORMAT(); 

                }
                break;
            case 59 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:404: GMTZONE
                {
                mGMTZONE(); 

                }
                break;
            case 60 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:412: GLOBALPERIOD
                {
                mGLOBALPERIOD(); 

                }
                break;
            case 61 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:425: DEFINEDPERIOD
                {
                mDEFINEDPERIOD(); 

                }
                break;
            case 62 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:439: METRICS
                {
                mMETRICS(); 

                }
                break;
            case 63 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:447: AGREEMENT_TERMS
                {
                mAGREEMENT_TERMS(); 

                }
                break;
            case 64 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:463: CREATION_CONSTRAINTS
                {
                mCREATION_CONSTRAINTS(); 

                }
                break;
            case 65 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:484: GUARANTEE_TERMS
                {
                mGUARANTEE_TERMS(); 

                }
                break;
            case 66 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:500: SERVICE
                {
                mSERVICE(); 

                }
                break;
            case 67 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:508: FEATURES
                {
                mFEATURES(); 

                }
                break;
            case 68 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:517: GLOBALDESCRIPTION
                {
                mGLOBALDESCRIPTION(); 

                }
                break;
            case 69 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:535: DESCRIPTION
                {
                mDESCRIPTION(); 

                }
                break;
            case 70 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:547: GLOBAL
                {
                mGLOBAL(); 

                }
                break;
            case 71 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:554: MONITORABLEPROPERTIES
                {
                mMONITORABLEPROPERTIES(); 

                }
                break;
            case 72 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:576: GUARANTEES
                {
                mGUARANTEES(); 

                }
                break;
            case 73 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:587: AVAL_AT
                {
                mAVAL_AT(); 

                }
                break;
            case 74 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:595: PROVIDER
                {
                mPROVIDER(); 

                }
                break;
            case 75 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:604: CONSUMER
                {
                mCONSUMER(); 

                }
                break;
            case 76 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:613: UPON
                {
                mUPON(); 

                }
                break;
            case 77 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:618: ONLY_IF
                {
                mONLY_IF(); 

                }
                break;
            case 78 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:626: INT
                {
                mINT(); 

                }
                break;
            case 79 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:630: SINT
                {
                mSINT(); 

                }
                break;
            case 80 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:635: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 81 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:641: SFLOAT
                {
                mSFLOAT(); 

                }
                break;
            case 82 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:648: LABEL
                {
                mLABEL(); 

                }
                break;
            case 83 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:654: RANGE
                {
                mRANGE(); 

                }
                break;
            case 84 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:660: VERSION
                {
                mVERSION(); 

                }
                break;
            case 85 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:668: IDENT
                {
                mIDENT(); 

                }
                break;
            case 86 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:674: VALUE
                {
                mVALUE(); 

                }
                break;
            case 87 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:680: ACCESS
                {
                mACCESS(); 

                }
                break;
            case 88 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:687: DATE
                {
                mDATE(); 

                }
                break;
            case 89 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:692: HOUR
                {
                mHOUR(); 

                }
                break;
            case 90 :
                // C:\\Users\\Antonio\\workspaceICSOC\\iAgreeStudioServerComponent\\src\\es\\us\\isa\\iagreeparser\\Sample.g:1:697: STRING
                {
                mSTRING(); 

                }
                break;

        }

    }


    protected DFA6 dfa6 = new DFA6(this);
    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA6_eotS =
        "\14\uffff";
    static final String DFA6_eofS =
        "\14\uffff";
    static final String DFA6_minS =
        "\1\53\1\56\1\60\2\56\1\53\1\56\2\uffff\1\53\2\uffff";
    static final String DFA6_maxS =
        "\3\71\1\56\2\71\1\56\2\uffff\1\71\2\uffff";
    static final String DFA6_acceptS =
        "\7\uffff\1\2\1\1\1\uffff\1\4\1\3";
    static final String DFA6_specialS =
        "\14\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\2\1\uffff\1\2\2\uffff\12\1",
            "\1\3\1\uffff\12\1",
            "\12\4",
            "\1\5",
            "\1\6\1\uffff\12\4",
            "\1\7\1\uffff\1\7\2\uffff\12\10",
            "\1\11",
            "",
            "",
            "\1\12\1\uffff\1\12\2\uffff\12\13",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "192:1: RANGE : ( INT RANGE_SEPARATOR INT | INT RANGE_SEPARATOR SINT | SINT RANGE_SEPARATOR INT | SINT RANGE_SEPARATOR SINT );";
        }
    }
    static final String DFA12_eotS =
        "\1\62\1\66\2\uffff\1\66\1\74\1\75\1\uffff\1\77\1\100\10\66\11\uffff"+
        "\1\122\1\124\1\uffff\22\66\1\160\1\66\2\uffff\2\66\2\uffff\1\66"+
        "\1\172\1\175\1\176\5\uffff\4\66\1\u0086\13\66\4\uffff\2\66\1\u0094"+
        "\30\66\2\uffff\1\160\1\uffff\2\62\1\66\1\170\3\uffff\2\66\3\uffff"+
        "\1\u00b7\3\66\1\u00bb\1\u00bc\1\uffff\7\66\1\u00c4\2\66\1\u00c7"+
        "\1\u00c8\1\66\1\uffff\1\u00ca\30\66\1\uffff\1\u00e4\1\160\1\uffff"+
        "\1\62\1\66\1\uffff\1\66\2\uffff\2\66\1\u00eb\2\uffff\6\66\1\u00f2"+
        "\1\uffff\2\66\2\uffff\1\66\1\uffff\2\66\1\u00f8\25\66\1\u010e\1"+
        "\uffff\1\u00e4\1\uffff\4\66\1\uffff\4\66\1\u0119\1\u011a\1\uffff"+
        "\5\66\1\uffff\25\66\2\uffff\1\170\1\66\1\u0136\1\66\1\u0138\4\66"+
        "\2\uffff\1\66\1\u013e\3\66\1\u0142\21\66\1\u0155\2\66\1\u0158\1"+
        "\uffff\1\66\1\uffff\1\66\1\u015b\1\u015c\1\u015d\1\u015e\1\uffff"+
        "\1\66\1\u0160\1\66\1\uffff\5\66\1\u0168\3\66\1\u016c\3\66\1\u0170"+
        "\4\66\1\uffff\2\66\2\uffff\1\66\4\uffff\1\66\1\uffff\1\66\1\u017a"+
        "\5\66\1\uffff\3\66\1\uffff\3\66\1\uffff\2\66\1\u0188\2\66\1\u018b"+
        "\2\66\1\u018f\1\uffff\3\66\1\u0193\11\66\2\uffff\1\66\1\uffff\3"+
        "\66\1\uffff\3\66\1\uffff\1\66\1\u01a5\7\66\1\u01ad\3\66\1\u01b1"+
        "\3\66\1\uffff\1\66\1\u01b6\5\66\1\uffff\1\u01bc\2\66\1\uffff\4\66"+
        "\1\uffff\1\u01c3\4\66\1\uffff\5\66\1\u01cd\1\uffff\4\66\1\u01d2"+
        "\1\u01d3\1\66\1\u01d5\1\66\1\uffff\1\66\1\u01d8\2\66\2\uffff\1\66"+
        "\1\uffff\1\u01dc\1\66\1\uffff\3\66\1\uffff\3\66\1\u01e4\1\u01e5"+
        "\2\66\2\uffff\3\66\1\u01eb\1\66\1\uffff\1\u01ed\1\uffff";
    static final String DFA12_eofS =
        "\u01ee\uffff";
    static final String DFA12_minS =
        "\1\11\1\45\2\uffff\3\45\1\uffff\1\57\11\45\11\uffff\2\75\1\uffff"+
        "\24\45\2\uffff\2\45\1\uffff\1\60\4\45\5\uffff\20\45\4\uffff\33\45"+
        "\1\uffff\1\56\1\45\1\uffff\1\55\1\56\2\45\3\uffff\1\40\1\45\2\uffff"+
        "\1\56\6\45\1\uffff\15\45\1\uffff\31\45\1\uffff\1\56\1\45\1\uffff"+
        "\1\55\1\45\1\uffff\1\45\2\uffff\3\45\2\uffff\7\45\1\uffff\2\45\2"+
        "\uffff\1\45\1\uffff\31\45\1\uffff\1\56\1\60\4\45\1\uffff\6\45\1"+
        "\uffff\5\45\1\uffff\25\45\2\uffff\1\56\10\45\2\uffff\33\45\1\uffff"+
        "\1\40\1\uffff\5\45\1\uffff\3\45\1\uffff\22\45\1\uffff\2\45\2\uffff"+
        "\1\45\4\uffff\1\45\1\uffff\7\45\1\uffff\3\45\1\uffff\3\45\1\uffff"+
        "\11\45\1\uffff\15\45\2\uffff\1\45\1\uffff\3\45\1\uffff\3\45\1\uffff"+
        "\21\45\1\uffff\7\45\1\uffff\1\60\2\45\1\uffff\4\45\1\uffff\5\45"+
        "\1\uffff\6\45\1\uffff\11\45\1\uffff\4\45\2\uffff\1\45\1\uffff\2"+
        "\45\1\uffff\3\45\1\uffff\7\45\2\uffff\5\45\1\uffff\1\45\1\uffff";
    static final String DFA12_maxS =
        "\1\175\1\172\2\uffff\3\172\1\uffff\1\57\11\172\11\uffff\2\75\1"+
        "\uffff\24\172\2\uffff\2\172\1\uffff\5\172\5\uffff\20\172\4\uffff"+
        "\33\172\1\uffff\2\172\1\uffff\1\71\3\172\3\uffff\2\172\2\uffff\1"+
        "\71\6\172\1\uffff\15\172\1\uffff\31\172\1\uffff\1\71\1\172\1\uffff"+
        "\1\71\1\172\1\uffff\1\172\2\uffff\3\172\2\uffff\7\172\1\uffff\2"+
        "\172\2\uffff\1\172\1\uffff\31\172\1\uffff\1\71\5\172\1\uffff\6\172"+
        "\1\uffff\5\172\1\uffff\25\172\2\uffff\1\71\10\172\2\uffff\33\172"+
        "\1\uffff\1\172\1\uffff\5\172\1\uffff\3\172\1\uffff\22\172\1\uffff"+
        "\2\172\2\uffff\1\172\4\uffff\1\172\1\uffff\7\172\1\uffff\3\172\1"+
        "\uffff\3\172\1\uffff\11\172\1\uffff\15\172\2\uffff\1\172\1\uffff"+
        "\3\172\1\uffff\3\172\1\uffff\21\172\1\uffff\7\172\1\uffff\3\172"+
        "\1\uffff\4\172\1\uffff\5\172\1\uffff\6\172\1\uffff\11\172\1\uffff"+
        "\4\172\2\uffff\1\172\1\uffff\2\172\1\uffff\3\172\1\uffff\7\172\2"+
        "\uffff\5\172\1\uffff\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\1\3\3\uffff\1\7\12\uffff\1\26\1\27\1\30\1\31\1\32"+
        "\1\33\1\34\1\35\1\36\2\uffff\1\41\24\uffff\1\126\1\132\2\uffff\1"+
        "\125\5\uffff\1\5\1\6\1\25\1\10\1\11\20\uffff\1\42\1\37\1\43\1\40"+
        "\33\uffff\1\116\2\uffff\1\130\4\uffff\1\122\1\127\1\4\2\uffff\1"+
        "\55\1\117\7\uffff\1\65\15\uffff\1\45\31\uffff\1\123\2\uffff\1\131"+
        "\2\uffff\1\14\1\uffff\1\121\1\12\3\uffff\1\57\1\15\7\uffff\1\64"+
        "\2\uffff\1\23\1\44\1\uffff\1\46\31\uffff\1\120\6\uffff\1\24\6\uffff"+
        "\1\56\5\uffff\1\51\25\uffff\1\114\1\124\11\uffff\1\20\1\52\33\uffff"+
        "\1\115\1\uffff\1\53\5\uffff\1\22\3\uffff\1\54\22\uffff\1\106\2\uffff"+
        "\1\1\1\13\1\uffff\1\16\1\50\1\17\1\21\1\uffff\1\47\7\uffff\1\102"+
        "\3\uffff\1\73\3\uffff\1\76\11\uffff\1\60\15\uffff\1\113\1\103\1"+
        "\uffff\1\112\3\uffff\1\66\3\uffff\1\67\21\uffff\1\72\7\uffff\1\110"+
        "\3\uffff\1\61\4\uffff\1\105\5\uffff\1\111\6\uffff\1\74\11\uffff"+
        "\1\75\4\uffff\1\62\1\77\1\uffff\1\71\2\uffff\1\101\3\uffff\1\70"+
        "\7\uffff\1\63\1\104\5\uffff\1\100\1\uffff\1\107";
    static final String DFA12_specialS =
        "\u01ee\uffff}>";
    static final String[] DFA12_transitionS = {
            "\2\22\1\uffff\2\22\22\uffff\1\22\1\uffff\1\63\2\uffff\1\11"+
            "\2\uffff\1\25\1\26\1\7\1\5\1\3\1\6\1\32\1\10\12\60\1\31\1\2"+
            "\1\33\1\35\1\34\2\uffff\1\36\1\61\1\53\1\50\1\45\1\54\1\51\1"+
            "\61\1\41\3\61\1\52\1\40\1\37\1\56\1\61\1\46\1\47\1\44\6\61\1"+
            "\23\1\uffff\1\24\1\uffff\1\61\1\uffff\1\14\1\15\1\61\1\43\1"+
            "\13\1\17\1\55\1\61\1\16\3\61\1\12\1\20\1\4\3\61\1\21\1\42\1"+
            "\57\1\1\4\61\1\27\1\uffff\1\30",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\64\25\65",
            "",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\5\65\1\71\7\65\1\72\14\65",
            "\1\62\5\uffff\1\62\1\uffff\1\62\2\uffff\12\73\7\uffff\32\62"+
            "\4\uffff\1\62\1\uffff\32\62",
            "\1\62\5\uffff\1\62\1\uffff\1\62\2\uffff\12\73\7\uffff\32\62"+
            "\4\uffff\1\62\1\uffff\32\62",
            "",
            "\1\76",
            "\1\62\5\uffff\1\62\1\uffff\1\62\2\uffff\12\62\7\uffff\32\62"+
            "\4\uffff\1\62\1\uffff\32\62",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\101\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\103\11\65\1\102\2\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\13\65\1\104\6\65\1\105\2\65\1\106"+
            "\4\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\110\11\65\1\107\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\111\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\113\12\65\1\112\2\65\1\115\2\65"+
            "\1\114\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\116\23\65\1\117\5\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\120\25\65",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\121",
            "\1\123",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\15\65\1\125\14\65\4\uffff\1\65\1\uffff\6\65\1\126\23\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\21\65\1\127\10\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\16\65\1\130\13\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\14\65\1\131\15\65\4\uffff\1\65\1\uffff\15\65\1\132\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\133\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\24\65\1\134\5\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\135\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\136\11\65\1\137\2\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\140\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\141\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\142\3\65\1\143\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\14\65\1\144\15\65\4\uffff\1\65\1\uffff\13\65\1\145\10\65\1"+
            "\146\5\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\147\11\65\1\150\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\152\2\65\1\151\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\153\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\13\65\1\154\10\65\1\155\5\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\156\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\17\65\1\157\12\65",
            "\1\62\5\uffff\1\62\1\uffff\1\164\1\161\1\163\12\162\7\uffff"+
            "\32\165\4\uffff\1\165\1\uffff\32\165",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\166\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\12\170\7\uffff\32\167\4\uffff\1\167\1\uffff\32\167",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\171\1\uffff\12\70\7\uffff"+
            "\32\70\4\uffff\1\70\1\uffff\32\70",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\173\6\65\1\174\16\65",
            "\1\62\5\uffff\1\62\1\uffff\1\62\1\177\1\uffff\12\73\7\uffff"+
            "\32\62\4\uffff\1\62\1\uffff\32\62",
            "",
            "",
            "",
            "",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u0080\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u0081\1\65\1\u0082\27\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\3\65\1\u0084\20\65\1\u0083\5\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\13\65\1\u0085\16\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u0087\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u0088\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\13\65\1\u0089\16\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u008a\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u008b\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\13\65\1\u008c\16\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u008d\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u008e\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u008f\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\14\65\1\u0090\15\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u0091\6\65",
            "",
            "",
            "",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\3\65\1\u0092\26\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u0093\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\23\65\1\u0095\6\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\17\65\1\u0096\12\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u0097\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\24\65\1\u0098\5\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u0099\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\14\65\1\u009a\15\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\3\65\1\u009b\26\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\17\65\1\u009c\12\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\22\65\1\u009d\7\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u009e\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u009f\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\5\65\1\u00a0\14\65\1\u00a1\7\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\23\65\1\u00a2\6\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u00a3\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u00a4\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u00a5\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u00a6\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u00a7\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u00a8\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u00a9\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u00aa\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u00ab\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u00ac\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u00ad\13\65",
            "",
            "\1\u00ae\1\uffff\12\u00af\7\uffff\32\170\4\uffff\1\170\1\uffff"+
            "\32\170",
            "\1\62\5\uffff\1\62\1\uffff\1\164\1\161\1\163\12\u00b0\1\u00b1"+
            "\6\uffff\32\165\4\uffff\1\165\1\uffff\32\165",
            "",
            "\1\164\1\uffff\1\163\12\u00b2",
            "\1\170\1\uffff\12\165\7\uffff\32\165\4\uffff\1\165\1\uffff"+
            "\32\165",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\22\65\1\u00b3\7\65",
            "\1\171\5\uffff\1\171\1\uffff\1\171\1\67\1\uffff\12\171\7\uffff"+
            "\32\171\4\uffff\1\171\1\uffff\32\171",
            "",
            "",
            "",
            "\1\u00b4\4\uffff\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff"+
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\30\65\1\u00b5\1\65",
            "",
            "",
            "\1\u00ae\1\uffff\12\u00b6",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\2\65\1\u00b8\27\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u00b9\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\14\65\1\u00ba\15\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u00bd\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\13\65\1\u00be\16\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u00bf\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u00c0\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u00c1\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\22\65\1\u00c2\7\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\14\65\1\u00c3\15\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\24\65\1\u00c5\5\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\65\1\u00c6\30\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u00c9\25\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\13\65\1\u00cb\16\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u00cc\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u00cd\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u00ce\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\17\65\1\u00cf\12\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\1\u00d1\22\65\1\u00d0\6\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u00d2\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\17\65\1\u00d3\12\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\25\65\1\u00d4\4\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u00d5\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u00d6\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\2\65\1\u00d7\27\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\31\65\1\u00d8\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\65\1\u00d9\30\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u00da\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u00db\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u00dc\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u00dd\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\22\65\1\u00de\7\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u00df\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\65\1\u00e0\30\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u00e1\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\25\65\1\u00e2\4\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u00e3\14\65",
            "",
            "\1\u00e6\1\uffff\12\u00e5",
            "\1\62\5\uffff\1\62\1\uffff\1\164\1\161\1\163\12\u00b0\7\uffff"+
            "\32\165\4\uffff\1\165\1\uffff\32\165",
            "",
            "\1\164\1\uffff\1\163\12\u00b2",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u00e7\21\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\10\65\1\u00e8\21\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u00e9\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\17\65\1\u00ea\12\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\13\65\1\u00ec\16\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u00ed\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u00ee\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\6\65\1\u00ef\23\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u00f0\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u00f1\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u00f3\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u00f4\25\65",
            "",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u00f5\25\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\10\65\1\u00f6\21\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u00f7\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u00f9\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\13\65\1\u00fa\16\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u00fb\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\6\65\1\u00fc\23\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u00fd\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u00fe\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u00ff\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\5\65\1\u0100\24\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u0101\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u0102\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u0103\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u0104\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u0105\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u0106\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u0107\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u0108\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\24\65\1\u0109\5\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\24\65\1\u010a\5\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u010b\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u010c\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u010d\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\u010f\1\uffff\12\u00e5",
            "\12\u0110\7\uffff\32\170\4\uffff\1\170\1\uffff\32\170",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u0111\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\5\65\1\u0112\24\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\13\65\1\u0113\16\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u0114\6\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u0115\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u0116\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\6\65\1\u0117\23\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u0118\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u011b\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u011c\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\14\65\1\u011d\15\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\4\65\1\u011e\25\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u011f\31\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\6\65\1\u0120\23\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u0121\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\14\65\1\u0122\15\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u0123\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u0124\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u0125\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\2\65\1\u0126\27\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u0127\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u0128\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u0129\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u012a\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\13\65\1\u012b\16\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u012c\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\2\65\1\u012d\27\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u012e\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u012f\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\14\65\1\u0130\15\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u0131\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\13\65\1\u0132\16\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u0133\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\3\65\1\u0134\26\65",
            "",
            "",
            "\1\u00e6\1\uffff\12\u010f",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u0135\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\30\65\1\u0137\1\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\65\1\u0139\30\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u013a\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\22\65\1\u013b\7\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u013c\10\65",
            "",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\13\65\1\u013d\16\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u013f\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\22\65\1\u0140\7\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u0141\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u0143\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\17\65\1\u0144\12\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u0145\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u0146\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\3\65\1\u0147\26\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u0148\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u0149\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\3\65\1\u014a\26\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\17\65\1\u014b\12\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u014c\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\3\65\1\u014e\13\65\1\u014d\12\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u014f\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\22\65\1\u0150\7\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u0151\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u0152\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u0153\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u0154\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u0156\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u0157\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\u0159\4\uffff\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff"+
            "\12\65\7\uffff\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\13\65\1\u015a\16\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u015f\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u0161\13\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u0162\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\13\65\1\u0163\16\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u0164\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u0165\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u0166\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\17\65\1\u0167\12\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\14\65\1\u0169\15\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\17\65\1\u016a\12\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u016b\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u016d\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u016e\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u016f\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u0171\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u0172\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u0173\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\22\65\1\u0174\7\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u0175\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u0176\10\65",
            "",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u0177\25\65",
            "",
            "",
            "",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u0178\6\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u0179\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u017b\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\14\65\1\u017c\15\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u017d\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u017e\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u017f\10\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u0180\31\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u0181\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u0182\21\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u0183\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\22\65\1\u0184\7\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u0185\25\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\65\1\u0186\30\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\2\65\1\u0187\27\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\u0189\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u018a\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\1\u018c\31\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\16\65\1\u018d\4\65\1\u018e\6\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u0190\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u0191\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u0192\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u0194\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u0195\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u0196\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u0197\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u0198\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\2\65\1\u0199\27\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\23\65\1\u019a\6\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\13\65\1\u019b\16\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u019c\13\65",
            "",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\22\65\1\u019d\7\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u019e\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\5\65\1\u019f\24\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u01a0\25\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u01a1\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u01a2\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\23\65\1\u01a3\6\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\25\65\1\u01a4\4\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u01a6\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u01a7\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u01a8\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u01a9\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u01aa\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u01ab\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u01ac\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\u01ae\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\5\65\1\u01af\24\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u01b0\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u01b2\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u01b3\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u01b4\21\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u01b5\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\3\65\1\u01b7\26\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u01b8\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u01b9\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\17\65\1\u01ba\12\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\22\65\1\u01bb\7\65",
            "",
            "\12\170\7\uffff\32\167\4\uffff\1\167\1\uffff\32\167",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u01bd\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\14\65\1\u01be\15\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\16\65\1\u01bf\13\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\14\65\1\u01c0\15\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\3\65\1\u01c1\26\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\3\65\1\u01c2\26\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\17\65\1\u01c4\12\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\14\65\1\u01c5\15\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u01c6\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u01c7\6\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u01c8\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\22\65\1\u01c9\7\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\5\65\1\u01ca\24\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u01cb\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u01cc\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u01ce\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\22\65\1\u01cf\7\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u01d0\13\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u01d1\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\5\65\1\u01d4\24\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u01d6\10\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u01d7\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\17\65\1\u01d9\12\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\1\u01da\31\65",
            "",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u01db\25\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\16\65\1\u01dd\13\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u01de\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u01df\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u01e0\10\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u01e1\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\21\65\1\u01e2\10\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\15\65\1\u01e3\14\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u01e6\6\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\23\65\1\u01e7\6\65",
            "",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\10\65\1\u01e8\21\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\22\65\1\u01e9\7\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\4\65\1\u01ea\25\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\22\65\1\u01ec\7\65",
            "",
            "\1\70\5\uffff\1\70\1\uffff\1\70\1\67\1\uffff\12\65\7\uffff"+
            "\32\65\4\uffff\1\65\1\uffff\32\65",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__76 | T__77 | T__78 | T__79 | T__80 | T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | COMMENT_LINE | WS | CA | CC | PA | PC | LLA | LLC | DP | RANGE_SEPARATOR | MENOR | MAYOR | IGUAL | MENOR_IGUAL | MAYOR_IGUAL | AND | OR | NOT | IMPLIES | BELONGS | TRUE | FALSE | EXCEPT | DURING | ON | FROM | END | TEMPLATE | END_TEMPLATE | AG_OFFER | END_AG_OFFER | FOR | AS | INITIATOR | RESPONDER | SERVICEPROVIDER | EXPIRATIONTIME | DATEFORMAT | GMTZONE | GLOBALPERIOD | DEFINEDPERIOD | METRICS | AGREEMENT_TERMS | CREATION_CONSTRAINTS | GUARANTEE_TERMS | SERVICE | FEATURES | GLOBALDESCRIPTION | DESCRIPTION | GLOBAL | MONITORABLEPROPERTIES | GUARANTEES | AVAL_AT | PROVIDER | CONSUMER | UPON | ONLY_IF | INT | SINT | FLOAT | SFLOAT | LABEL | RANGE | VERSION | IDENT | VALUE | ACCESS | DATE | HOUR | STRING );";
        }
    }
 

}