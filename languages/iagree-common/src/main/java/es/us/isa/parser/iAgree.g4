grammar iAgree;


// Parser Rules

entry : template END_TEMPLATE 
      | agOffer END_AG_OFFER
      ;
 
template : TEMPLATE IDENT VERSION version template_def;
				
agOffer : AG_OFFER IDENT VERSION version FOR IDENT VERSION version ag_def;

version : VERSION_NUMBER 
        | FLOAT
        ;

template_def : temp_properties*  agreementTerms creationConstraints?;

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


//Template properties:

initiator_prop : INITIATOR DP STRING;
				
responder_prop : (PROVIDER | CONSUMER | IDENT) AS RESPONDER;
				
serviceProvider_prop : SERVICEPROVIDER DP STRING;
				
expirationTime_prop : EXPIRATIONTIME DP STRING;
				
dateFormat_prop : DATEFORMAT DP STRING;
				
gmtZone_prop : GMTZONE DP (SINT | INT);
				
globalPeriod_prop : GLOBALPERIOD DP datePeriod_def;
				
definedPeriod_prop : DEFINEDPERIOD DP period+;
			
				
//End Template properties.
datePeriod_def : DURING DATE RANGE_SEPARATOR DATE;
               
//Temp. definitions

temporality : ON IDENT;

period : IDENT DP period_def ((EXCEPT|AND) period_def)*;

period_def : FROM HOUR '..' HOUR (ON IDENT)? DURING DATE '..' DATE 
           | IDENT
           | GLOBALPERIOD
           ;

//End Temp. definitions.
			
agreementTerms : AGREEMENT_TERMS agreementTerms_def;
				
creationConstraints : CREATION_CONSTRAINTS creationConstraints_def;


agreementTerms_def : service monitorableProperties guaranteeTerms;
				
creationConstraints_def	: creationConstraint+;

creationConstraint : (LABEL|IDENT) DP expression ';' onlyif_sentence?;

//Ag. terms def:
service : SERVICE IDENT (AVAL_AT url)? (features)? 
          globalDescription descriptions
        ;

features : FEATURES DP feature (',' feature)*;
				
descriptions : description*;
				
feature : op (',' op)*;

//op
//				: IDENT (PA ((IDENT|INT) (',' (IDENT|INT))*)* PC)?
//				;
op : IDENT (PA IDENT (',' IDENT )* PC)?;

description : DESCRIPTION FOR feature (',' feature)* key_value_prop+;
		
monitorableProperties : MONITORABLEPROPERTIES (IDENT)? 
                        global_MonitorableProperties? 
                        local_MonitorableProperties*
                      ;
				
global_MonitorableProperties : GLOBAL DP (key_value_prop)+;
				
local_MonitorableProperties : FOR IDENT DP key_value_prop+;
				
guaranteeTerms : GUARANTEE_TERMS (guaranteeTerm )+;
				
guaranteeTerm : (LABEL | IDENT) DP 
                (guarantee_def | cuantif 'of' grouped_guaranteeTerm)
              ;

grouped_guaranteeTerm : (guaranteeTerm)+;
							
guarantee_def : (PROVIDER | CONSUMER) GUARANTEES 
                expression temporality? ';' 
                (upon_sentence)? (onlyif_sentence)?
              ;
				
upon_sentence : UPON IDENT ';';
	
onlyif_sentence : ONLY_IF PA expression PC ';';
                
//End Ag. terms def.


//Aux:
assig_value : (IDENT | LETTER | VALUE | INT | STRING)+ (operation)?
            | TRUE
            | FALSE
            | FLOAT (unit)? (operation)?
            | SFLOAT (unit)? (operation)?
            | SINT (unit)? (operation)?
            | list
            ;
				
operation : ('+'|'-'|'*'|'/') assig_value;

unit : '%' | 'min'; //Completar!

list : LLA (IDENT|STRING|INT|SINT|FLOAT|SFLOAT) 
       (',' (IDENT|STRING|INT|SINT|FLOAT|SFLOAT))* LLC
     ;


expression : NOT expression
           | PA expression PC ((AND|OR|IMPLIES) expression)?
           | (IDENT|ACCESS|STRING) ( (IGUAL|MENOR|MAYOR|MENOR_IGUAL|MAYOR_IGUAL) assig_value)? ((AND|OR|IMPLIES) expression)?
           | (IDENT|ACCESS) BELONGS list ((AND|OR|IMPLIES) expression)?
           ;

cuantif : 'exactly one' 
        | 'one or more'
        | 'all'
        ;

key_value_prop : (IDENT|ACCESS|'boolean'|'integer') DP 
                 (STRING | type)  (IGUAL assig_value ';')?
               ;

type : ('integer' | 'float' | 'natural' | 'number' | 'boolean')(range)? 
     | IDENT | 'set' list | 'enum' list
     ;
				
range : CA RANGE CC
      | CA (INT|SINT) RANGE_SEPARATOR (INT|SINT) CC
      ;

url
//  :'http' ('s')? '://' ~(WS | CC) (('/') ~(WS | CC))* ('/')
//  |'www.' ~(WS | CC) (('/') ~(WS | CC))* ('/')
    : STRING
    ;
		
		
metrics_prop : METRICS /*CA (ACCESS|IDENT) (',' (ACCESS|IDENT))* CC*/ DP (key_value_prop)+;
						
globalDescription : GLOBALDESCRIPTION (key_value_prop)+;


// Tokens

CA : '[';
CC : ']';
PA : '(';
PC : ')';
LLA : '{';
LLC : '}';
DP : ':';
RANGE_SEPARATOR : '..';

MENOR : '<';
MAYOR : '>';
IGUAL : '=';
MENOR_IGUAL : '<=';
MAYOR_IGUAL : '>=';

AND : 'AND';
OR : 'OR';
NOT : 'NOT';
IMPLIES : 'IMPLIES';
BELONGS : 'belongs';

TRUE : 'true';
FALSE : 'false';

EXCEPT : 'except';
DURING : 'during';
ON : 'on';
FROM : 'from';

END : 'end';

TEMPLATE : 'Template';
END_TEMPLATE : 'EndTemplate';

VERSION : 'version';

AG_OFFER : 'AgreementOffer';
END_AG_OFFER : 'EndAgreementOffer';

FOR : 'for';
AS : 'as';

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

UPON : 'upon';
ONLY_IF : 'onlyIf';

INT : DIGIT+ ;
SINT : ('+'|'-') INT;
FLOAT : INT '.' INT;
SFLOAT : ('+'|'-') FLOAT;

LABEL : (LETTER|DIGIT|'_')+ ('.' (LETTER|DIGIT|'_') )+;

RANGE : INT RANGE_SEPARATOR INT
			|	INT RANGE_SEPARATOR SINT
			| SINT RANGE_SEPARATOR INT
			| SINT RANGE_SEPARATOR SINT;

VERSION_NUMBER : INT ('.' INT)+;

IDENT : (LETTER | '_') VALUE;
VALUE : (LETTER | DIGIT | '_' | '-' | '+' | '%')+;

ACCESS : IDENT ('.' IDENT)+;

DATE : INT (INT | '/' | '-')+;
HOUR : DIGIT DIGIT DP DIGIT DIGIT;

STRING : '"' (~('"'|'\r'|'\n'))* '"';

fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';

COMMENT_LINE : '//' ~('\n'|'\r')* '\n';

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ -> skip;