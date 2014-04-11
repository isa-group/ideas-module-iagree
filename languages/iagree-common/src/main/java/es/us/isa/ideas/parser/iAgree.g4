grammar iAgree;



/*=====================================
            SYNTACTICAL RULES
 ======================================*/

entry : template END_TEMPLATE
      | agOffer END_AG_OFFER
      ;
 
template : TEMPLATE Identifier VERSION versionNumber template_def
         ;

agOffer : AG_OFFER Identifier VERSION versionNumber FOR Identifier VERSION versionNumber ag_def;

template_def : temp_properties* agreementTerms creationConstraints?;

ag_def : temp_properties*  agreementTerms;

temp_properties : initiator_prop
                | responder_prop 
                | serviceProvider_prop 
                | expirationTime_prop
                | dateFormat_prop
                | gmtZone_prop
                | globalPeriod_prop
                | definedPeriod_prop
                | metrics_prop
                ;

agreementTerms : AGREEMENT_TERMS agreementTerms_def;

creationConstraints : CREATION_CONSTRAINTS creationConstraints_def;

agreementTerms_def : service monitorableProperties guaranteeTerms;

creationConstraints_def	: creationConstraint+;

creationConstraint : (Identifier) DP expression SEMICOLON onlyif_sentence?;

//---------------------------------------
// Template properties
//---------------------------------------

initiator_prop : INITIATOR DP String;

responder_prop : (PROVIDER | CONSUMER | Identifier) AS RESPONDER;

serviceProvider_prop : SERVICEPROVIDER DP String;
				
expirationTime_prop : EXPIRATIONTIME DP String;

dateFormat_prop : DATEFORMAT DP String;

gmtZone_prop : GMTZONE DP (S_Integer | Integer);

globalPeriod_prop : GLOBALPERIOD DP datePeriod_def;

definedPeriod_prop : DEFINEDPERIOD DP period+;

metrics_prop : METRICS /*CA (ACCESS|IDENT) (',' (ACCESS|IDENT))* CC*/ DP (key_value_prop)+;

//---------------------------------------
// Temp. definitions
//---------------------------------------

datePeriod_def : DURING Date RANGE_SEPARATOR Date;

temporality : ON Identifier;

period : Identifier DP period_def ((EXCEPT|AND) period_def)*;

period_def : FROM Hour RANGE_SEPARATOR Hour (ON Identifier)? datePeriod_def 
           | id
           | GLOBALPERIOD
           ;


//---------------------------------------
// Agreement Terms definitions
//---------------------------------------
			
service : SERVICE Identifier (AVAL_AT url)? (features)? 
          globalDescription descriptions
        ;

features : FEATURES DP feature (COMMA feature)*;

globalDescription : GLOBALDESCRIPTION (key_value_prop)+;

descriptions : description*;
				
feature : op (COMMA op)*;

description : DESCRIPTION FOR feature (COMMA feature)* key_value_prop+;
		
monitorableProperties : MONITORABLEPROPERTIES (Identifier)? 
                        global_MonitorableProperties? 
                        local_MonitorableProperties*
                      ;
				
global_MonitorableProperties : GLOBAL DP (key_value_prop)+;
				
local_MonitorableProperties : FOR Identifier DP key_value_prop+;
				
guaranteeTerms : GUARANTEE_TERMS (guaranteeTerm )+;
				
guaranteeTerm : Identifier DP 
                (guarantee_def | cuantif OF grouped_guaranteeTerm)
              ;

grouped_guaranteeTerm : (guaranteeTerm)+;
							
guarantee_def : (PROVIDER | CONSUMER) GUARANTEES 
                expression temporality? SEMICOLON 
                (upon_sentence)? (onlyif_sentence)?
              ;


//----------------------------------
// COMMONS
//----------------------------------

id : Identifier;

versionNumber : Float
              | Version
              ;

url : Url
    | String
    ;

key_value_prop : k=(Identifier | Access | BOOLEAN | INTEGER ) DP 
                 (v=String | v2=type)  (IGUAL a=assig_value SEMICOLON)?
               ;

assig_value : (Identifier | Integer | String)+ (operation)?
            | Boolean
            | Float (Unit)? (operation)?
            | S_Float (Unit)? (operation)?
            | S_Integer (Unit)? (operation)?
            | list
            ;

operation : Operador assig_value;

expression : NOT expression
           | PA expression PC ((AND|OR|IMPLIES) expression)?
           | (Identifier | Access | String) ( (IGUAL|MENOR|MAYOR|MENOR_IGUAL|MAYOR_IGUAL) assig_value)? ((AND|OR|IMPLIES) expression)?
           | (Identifier | Access) BELONGS list ((AND|OR|IMPLIES) expression)?
           ;

op : Identifier (PA Identifier (COMMA Identifier )* PC)?;

cuantif : EXACTLY_ONE 
        | ONE_OR_MORE
        | ALL
        ;

upon_sentence : UPON Identifier SEMICOLON;
	
onlyif_sentence : ONLY_IF PA expression PC SEMICOLON;

type : Identifier | SET list | ENUM list 
     | (INTEGER | FLOAT | NATURAL | NUMBER | BOOLEAN)(range)? 
     ;

list : LLA (Identifier | String | Integer | S_Integer | Float | S_Float) 
       (COMMA (Identifier | String | Integer | S_Integer | Float | S_Float))* LLC
     ;

range : CA Integer RANGE_SEPARATOR Integer CC
      |	CA Integer RANGE_SEPARATOR S_Integer CC
      | CA S_Integer RANGE_SEPARATOR Integer CC
      | CA S_Integer RANGE_SEPARATOR S_Integer CC
      | CA (Integer | S_Integer) RANGE_SEPARATOR (Integer | S_Integer) CC
      ;


/*=====================================
            LEXICAL RULES
 ======================================*/

//---------------------------------------
// Language Keywords
//---------------------------------------

TEMPLATE : 'Template';
END_TEMPLATE : 'EndTemplate';

AG_OFFER : 'AgreementOffer';
END_AG_OFFER : 'EndAgreementOffer';

INITIATOR : 'Initiator';
RESPONDER : 'Responder';
SERVICEPROVIDER : 'ServiceProvider';
EXPIRATIONTIME : 'ExpirationTime';
DATEFORMAT : 'DateFormat';
GMTZONE : 'GMTZone';
GLOBALPERIOD : 'GlobalPeriod';
DEFINEDPERIOD : 'DefinedPeriod';
METRICS : 'Metrics';

AGREEMENT_TERMS : 'AgreementTerms';
CREATION_CONSTRAINTS : 'CreationConstraints';
GUARANTEE_TERMS : 'GuaranteeTerms';

SERVICE : 'Service';
FEATURES: 'Features/Operations';
GLOBALDESCRIPTION : 'GlobalDescription';
DESCRIPTION : 'Description';
GLOBAL : 'global';
MONITORABLEPROPERTIES : 'MonitorableProperties';
GUARANTEES : 'guarantees';

AVAL_AT : 'availableAt.';

PROVIDER : 'Provider';
CONSUMER : 'Consumer';

VERSION : 'version';

EXCEPT : 'except';
DURING : 'during';

BOOLEAN : 'boolean';
INTEGER : 'integer';
FLOAT : 'float';
NATURAL : 'natural';
NUMBER : 'number';
SET : 'set';
ENUM : 'enum';


//---------------------------------------
// Commons tokens
//---------------------------------------

CA : '[';
CC : ']';
PA : '(';
PC : ')';
LLA : '{';
LLC : '}';
ON : 'on';
FROM : 'from';
OF : 'of';
FOR : 'for';
AS : 'as';


//---------------------------------------
// Logical connective
//---------------------------------------

AND : 'AND';
OR : 'OR';
NOT : 'NOT';
IMPLIES : 'IMPLIES';
ONLY_IF : 'onlyIf';


//---------------------------------------
// Quantity
//---------------------------------------

EXACTLY_ONE : 'exactly one';
ONE_OR_MORE : 'one or more';
ALL : 'all';


//---------------------------------------
// Relational tokens
//---------------------------------------

MENOR : '<';
MAYOR : '>';
IGUAL : '=';
MENOR_IGUAL : '<=';
MAYOR_IGUAL : '>=';
BELONGS : 'belongs';
UPON : 'upon';


//---------------------------------------
// Punctuation marks
//---------------------------------------

DOT : '.';
COMMA: ',';
DP: ':';
SEMICOLON : ';';
RANGE_SEPARATOR : '..';


//---------------------------------------
// Basic Lexical Elements
//---------------------------------------

Identifier: Letter ('-'|'_'|DOT|LetterOrDigit)*;

fragment Letter : [a-zA-Z$_];

fragment LetterOrDigit : [a-zA-Z0-9$_];

// Literals

Integer : Digit+;
S_Integer : [+-] Integer;

Float: Integer DOT Integer;
S_Float : [+-] Float;

Boolean : 'true'
        | 'false'
        ;

Url : ('http'|'https'|'ftp'|'file')':''/''/'[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]
    ;

Version : Integer (DOT Integer)+;

Date : Integer [-/] Integer [-/] Integer;

Hour : Digit? Digit DP Digit Digit;

Access : Identifier ('.' Identifier)+;

Unit : '%' | 'min';

Operador : '+'|'-'|'*'|'/';



//Digits

fragment Digit : '0'
               | NonZeroDigit
               ;

fragment NonZeroDigit : [1-9]
                      ;

// String

String : '\'' ~[']* '\''
       | '"' ~["]* '"'
       ;


//---------------------------------------
// Ignone spaces, tabs, newlines
//---------------------------------------

WS : [ \t\r\n]+ -> skip ;


// Comments
COMMENT : '/*' .*? '*/' -> skip
        ;

LINE_COMMENT : '//' ~[\r\n]* -> skip
             ;