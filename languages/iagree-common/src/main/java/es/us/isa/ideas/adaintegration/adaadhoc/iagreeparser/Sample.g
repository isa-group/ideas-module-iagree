grammar Sample;

options {
  language = Java;
  
}

@header {
  package es.us.isa.iagreeparser;
  import java.util.Calendar;
}
@lexer::header {
  package es.us.isa.iagreeparser;
}



@members {

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
	
}



entry returns [String wsag]
				: template END_TEMPLATE {$wsag = xmlHeader + $template.result;}
				| agOffer END_AG_OFFER {$wsag = xmlHeader + $agOffer.result;}
				;


COMMENT_LINE
    : '//' ~('\n'|'\r')* '\n' 
    {$channel = HIDDEN; skip();}
    ;

WS : (' ' | '\t' | '\n' | '\r' | '\f')+ {$channel = HIDDEN;};


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

fragment LETTER : ('a'..'z' | 'A'..'Z') ;
fragment DIGIT : '0'..'9';

INT : DIGIT+ ;
SINT : ('+'|'-') INT;
FLOAT : INT '.' INT;
SFLOAT : ('+'|'-') FLOAT;

LABEL : (LETTER|DIGIT|'_')+ ('.' (LETTER|DIGIT|'_') )+;

RANGE : INT RANGE_SEPARATOR INT
			|	INT RANGE_SEPARATOR SINT
			| SINT RANGE_SEPARATOR INT
			| SINT RANGE_SEPARATOR SINT;

VERSION : INT ('.' INT)+;

IDENT : (LETTER | '_') VALUE;

VALUE : (LETTER | DIGIT | '_' | '-' | '+' | '%')*;

ACCESS : IDENT ('.' IDENT)+;

DATE : INT (INT | '/' | '-')+;
HOUR : DIGIT DIGIT DP DIGIT DIGIT;

STRING
	:	'"' (~('"'|'\r'|'\n'))* '"'
	;


//Rules:

template returns [String result]
				: TEMPLATE IDENT 'version' version {metric = $IDENT.text+"_"+Calendar.getInstance().getTimeInMillis();} template_def
				{
					$result = "<wsag:Template wsag:TemplateId=\""+$version.result+"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"  \n" + 
				" xmlns:wsag=\"http://schemas.ggf.org/graap/2007/03/ws-agreement\" \n" + 
				" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" \n" + 
				" xsi:schemaLocation=\"http://schemas.ggf.org/graap/2007/03/wsagreement\" \n" + 
				" agreement_types.xsd=\"http://www.w3.org/2001/XMLSchema XMLSchema.xsd\" >\n"+
										"	<wsag:Name >"+$IDENT.text+"</wsag:Name>\n"+
										$template_def.result+
										"</wsag:Template>";
				};
				
agOffer returns [String result]
				: AG_OFFER i1=IDENT 'version' v1=version FOR i2=IDENT 'version' v2=version {
					metric = $i1.text+"_"+Calendar.getInstance().getTimeInMillis();
					
					agg_template = "		<wsag:TemplateId>"+$v2.result+"</wsag:TemplateId>\n";
					agg_temId = "		<wsag:TemplateName>"+$i2.text+"</wsag:TemplateName>\n";
				}
				ag_def
				{
					$result = "<wsag:AgreementOffer wsag:AgreementId=\""+$v1.result+"\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"  \n" + 
				" xmlns:wsag=\"http://schemas.ggf.org/graap/2007/03/ws-agreement\" \n" + 
				" xmlns:xs=\"http://www.w3.org/2001/XMLSchema\" \n" + 
				" xsi:schemaLocation=\"http://schemas.ggf.org/graap/2007/03/wsagreement\" \n" + 
				" agreement_types.xsd=\"http://www.w3.org/2001/XMLSchema XMLSchema.xsd\" >\n"+
										"	<wsag:Name >"+$i1.text+"</wsag:Name>\n"+
										$ag_def.result+
										"</wsag:AgreementOffer>";
				};

version returns [String result]
				:	VERSION {$result = $VERSION.text;}
				| FLOAT {$result = $FLOAT.text;}
				;


template_def returns [String result]
				: temp_properties*  agreementTerms creationConstraints?
					{
						$result = "	<wsag:Context >\n"+
													context +
											"\n	</wsag:Context >\n\n"+
											
											"	<wsag:Terms wsag:Name=\""+serviceName+"\">\n		<wsag:All >\n"+
											 		$agreementTerms.result +
											"\n		</wsag:All >\n	</wsag:Terms >\n\n"+
											
											"	<wsag:CreationConstraints >\n"+
													cc +
											"	</wsag:CreationConstraints >\n";
					}
				;

ag_def returns [String result]
				: temp_properties*  agreementTerms
					{
						$result = "	<wsag:Context >\n"+
													agg_template+
													agg_temId+
													context +
											"\n	</wsag:Context >\n\n"+
											
											"	<wsag:Terms wsag:Name=\""+serviceName+"\">\n		<wsag:All >\n"+
											 		$agreementTerms.result +
											"\n		</wsag:All >\n	</wsag:Terms >\n\n";
					}
				;

temp_properties
				: initiator_prop { context += "		<wsag:AgreementInitiator >" + $initiator_prop.result + "</wsag:AgreementInitiator >\n"; }
				| responder_prop { context += "		<wsag:AgreementResponder >" + $responder_prop.result + "</wsag:AgreementResponder >\n"; }
				| serviceProvider_prop { context += "		<wsag:ServiceProvider >" + $serviceProvider_prop.result + "</wsag:ServiceProvider >\n"; }
				| expirationTime_prop { context += "		<wsag:ExpirationTime >" + $expirationTime_prop.result + "</wsag:ExpirationTime >\n"; }
				| dateFormat_prop { context += "		<twsag4people:DateFormat >" + withoutQuotes($dateFormat_prop.result) + "</twsag4people:DateFormat >\n"; }
				| gmtZone_prop { context += "		<wsag:GMTZone >" + $gmtZone_prop.result + "</wsag:GMTZone >\n"; }
				| globalPeriod_prop { context += "		<twsag4people:GlobalPeriod >" + $globalPeriod_prop.result + "</twsag4people:GlobalPeriod >\n"; }
				| definedPeriod_prop { context += "		<twsag4people:DefinedValidityPeriodSet >" + $definedPeriod_prop.result + "</twsag4people:DefinedValidityPeriodSet >\n"; }
				| metrics_prop /*{ context += "		<wsag:Metrics >" + $metrics_prop.result + "</wsag:Metrics >"; }*/
				;

//Template properties:
initiator_prop returns [String result]
				: INITIATOR DP STRING { $result = withoutQuotes($STRING.text);}
				;
				
responder_prop returns [String result]
				: target=(PROVIDER | CONSUMER | IDENT) AS RESPONDER  { $result = $target.text;}
				;
				
serviceProvider_prop returns [String result]
				:  SERVICEPROVIDER DP STRING { $result = withoutQuotes($STRING.text);}
				;
				
expirationTime_prop returns [String result]
				: EXPIRATIONTIME DP STRING { $result = withoutQuotes($STRING.text);}
				;
				
dateFormat_prop returns [String result]
				: DATEFORMAT DP STRING { $result = withoutQuotes($STRING.text);}
				;
				
gmtZone_prop returns [String result]
				: GMTZONE DP zone=(SINT | INT) { $result = $zone.text;}
				;
				
globalPeriod_prop returns [String result]
				: GLOBALPERIOD DP datePeriod_def {$result = "";}
				;
				
definedPeriod_prop returns [String result]
				: DEFINEDPERIOD DP period+ {$result = "";}
				;
				

				
//End Template properties.
datePeriod_def returns [String result]
				: DURING DATE RANGE_SEPARATOR DATE
				;
//Temp. definitions

temporality returns [String result]
				: ON IDENT
				;

period returns [String result]
				: IDENT DP period_def ((EXCEPT|AND) period_def)*
				;

period_def returns [String result]
				: FROM HOUR '..' HOUR (ON IDENT)? DURING DATE '..' DATE 
				| IDENT
				| GLOBALPERIOD
				;

//End Temp. definitions.
			
agreementTerms returns [String result]
				: AGREEMENT_TERMS agreementTerms_def
					{
//						$result =
//						"				<wsag:VariableSet >\n"+
//						variablesSet+
//						"				</wsag:VariableSet >\n";
							$result = $agreementTerms_def.result;
					}
				;
				
creationConstraints
				: CREATION_CONSTRAINTS creationConstraints_def
				;


agreementTerms_def returns [String result]
				: service monitorableProperties guaranteeTerms
					{
						$result = $service.result
										+ $monitorableProperties.result
										+ $guaranteeTerms.result;
						
					}
				;
				
creationConstraints_def returns [String result]
				: creationConstraint+
				;

creationConstraint returns [String result]
				: etiq=(LABEL|IDENT) DP exp=expression ';' onlyif_sentence?
						{
							String name = $etiq.text;
							
							cc += "		<wsag:Constraint >\n"+
										"			<Name>"+name+"</Name>\n"+
										"			<Content>";
										
							if($onlyif_sentence.result!=null)
								cc += $onlyif_sentence.result + " IMPLIES ";
								
							cc += $exp.result+"</Content>\n"+
										"		</wsag:Constraint >\n";
						}
				;

//Ag. terms def:
service returns [String result]
				: SERVICE id=IDENT (AVAL_AT url)?
				  (features)?
				  globalDescription
				  descriptions
				  	{
				  	String urlValue = $url.text;
				  	
				  		
				  	
				  	serviceName = $IDENT.text;
						String name = "SDT_"+serviceName;
						if($id!=null)
							name = $id.text;
						
						$result =
							"			<wsag:ServiceDescriptionTerm wsag:Name=\"SDT_"+name+"\" wsag:ServiceName=\""+serviceName+"\" >\n"+
											offerItems+
							"			</wsag:ServiceDescriptionTerm>\n\n";
							
//						if(urlValue!=null)
//							$result += "			<wsag:ServiceReference  wsag:Name=\""+$IDENT.text+"_SREF\" wsag:ServiceName=\""+$IDENT.text+"\" >"+urlValue+"</wsag:ServiceReference>\n\n";
				  }
				;

features returns [String result]
				: FEATURES DP feature (',' feature)*
				;
				

				
descriptions returns [String result] : description*;
				
feature returns [String result] : op (',' op)*
				;

//op
//				: IDENT (PA ((IDENT|INT) (',' (IDENT|INT))*)* PC)?
//				;
op returns [String result]
				: IDENT (PA IDENT (',' IDENT )* PC)?
				;

description returns [String result]
				: DESCRIPTION FOR feature (',' feature)*
				  key_value_prop+
				;
		
monitorableProperties returns [String result]
				: MONITORABLEPROPERTIES (IDENT)? global_MonitorableProperties? local_MonitorableProperties*
					{
						String name = $IDENT.text;
						if(name==null)
							name = serviceName;
						$result =
				  		"			<wsag:ServiceProperties wsag:Name=\"SP_"+name+"\" wsag:ServiceName=\""+name+"\">\n"+
				  		"				<wsag:VariableSet >\n"+
				  						variablesSet +
				  		"				</wsag:VariableSet >\n"+
				  		"			</wsag:ServiceProperties>\n\n";
				  		
					}
				;
				
global_MonitorableProperties
				: GLOBAL DP (kv=key_value_prop
					{
//						offerItems += "				<OfferItem name=\""+$kv.key+"\" wsag:Metric=\"metrics/"+metric+":"+$kv.value+"\" ></OfferItem>\n";
							variablesSet +=
						"					<wsag:Variable  wsag:Name=\""+ $kv.key +"\" wsag:Metric=\"metrics/"+metric+":"+$kv.value+"\" >\n"+
						"						<wsag:Location >/"+$kv.key+"</wsag:Location>\n"+
						"					</wsag:Variable >\n";
					}
					)+
				;
				
local_MonitorableProperties returns [String result]
				: FOR IDENT DP key_value_prop+
				;
				
guaranteeTerms returns [String result]
				: GUARANTEE_TERMS {$result="";} (g=guaranteeTerm {$result += $g.result;} )+
				;
				
guaranteeTerm returns [String result]
				: (name=LABEL|name=IDENT) DP (gdef=guarantee_def | c=cuantif 'of' g_gterm=grouped_guaranteeTerm END)
					{
						if(c!=null) {
							$result =
							"			<wsag:"+$c.result+" >\n"+
										g_gterm+
							"			</wsag:"+$c.result+" >\n";
						}else{
						
							$result = 
							"			<wsag:GuaranteeTerm wsag:Obligated=\"Service"+$gdef.obligated+"\" wsag:Name=\""+$name.text+"\" >\n"+$gdef.result+
							"			</wsag:GuaranteeTerm>\n";
							
						}
						
					}
				;

grouped_guaranteeTerm returns [String result]
			: {$result = "";}(guaranteeTerm {$result += $guaranteeTerm.result;})+
			;
							
guarantee_def returns [String result, String obligated]
				: (ob=PROVIDER | ob=CONSUMER) GUARANTEES expression temporality? ';' (upon_sentence)? (onlyif=onlyif_sentence)?
					{
						$obligated = $ob.text;
						$result = "";
						if(onlyif!=null) {
							$result =
								"				<wsag:QualifyingCondition >\n"
													+"					"+convertEntities($onlyif.result)+"\n"+
								"				</wsag:QualifyingCondition>\n";
						}
						
						$result += 
							"				<wsag:ServiceLevelObjective >\n"+
							"					<wsag:CustomServiceLevel >"+convertEntities($expression.result)+"</wsag:CustomServiceLevel>\n"+
							"				</wsag:ServiceLevelObjective>\n";
						
					}
				;
				
upon_sentence returns [String result]
				: UPON IDENT ';'
				;
	
onlyif_sentence returns [String result]
				: ONLY_IF PA expression PC ';' {$result = $expression.result;}
				;
//End Ag. terms def.


//Aux:
assig_value returns [String result]
				: val=(IDENT | LETTER | VALUE | INT | STRING)+ (operation)?{ $result = $val.text; if($operation.result!=null) $result+=$operation.result; }
				| TRUE { $result="\"True\""; }
				| FALSE { $result="\"False\""; }
				| FLOAT u=(unit)? (operation)? { $result = $FLOAT.text; if($u!=null) $result+=$u; if($operation.result!=null) $result+=$operation.result; }
				| SFLOAT u=(unit)? (operation)? { $result = $SFLOAT.text; if($u!=null) $result+=$u; if($operation.result!=null) $result+=$operation.result;}
				| SINT u=(unit)? (operation)? { $result = $SINT.text; if($u!=null) $result+=$u; if($operation.result!=null) $result+=$operation.result; }
				| list { $result = $list.result;}
				;
				
operation returns [String result]
				: (ope='+'|ope='-'|ope='*'|ope='/') assig_value { $result = $ope.text + $assig_value.result; }
				;

unit returns [String result] : '%' | 'min'; //Completar!

list returns [String result, String values]
				: LLA (i1=IDENT|i1=STRING|i1=INT|i1=SINT|i1=FLOAT|i1=SFLOAT) { $result="{"+$i1.text; $values=$i1.text; } (',' (i2=IDENT|i2=STRING|i2=INT|i2=SINT|i2=FLOAT|i2=SFLOAT) { $result+=", "+$i2.text; $values+=","+$i2.text; })* LLC {$result+="}";}
				;


expression returns [String result]
				: NOT e1=expression
					{
						$result = "NOT ("+$e1.result+")";
					}
				| PA e1=expression PC (log=(AND|OR|IMPLIES) e2=expression)?
					{
						$result = $PA.text + $e1.result + $PC.text;
						if($log!=null) {
							$result += " "+$log.text + " " + $e2.result;
						}
						
						$result = convertEntities($result);
					}
				| (id=IDENT|id=ACCESS|id=STRING) ( comp=(IGUAL|MENOR|MAYOR|MENOR_IGUAL|MAYOR_IGUAL) val=assig_value)? (log=(AND|OR|IMPLIES) e2=expression)?
					{
						$result = "";

						$result += $id.text;
						if($comp!=null) $result += $comp.text + $val.result;
						if($log!=null) $result += " "+$log.text + " " + $e2.result;
						
						$result = convertEntities($result);
					}
				| (id=IDENT|id=ACCESS) BELONGS l=list (log=(AND|OR|IMPLIES) exp=expression)?
					{
						$result = "";

							
							String[] values = $l.values.split(",");
							
							$result += "("+$id.text+" = \""+values[0]+"\")";
							
							for(int i=1; i<values.length; i++) {
								$result += " OR ("+$id.text+" = \""+values[i]+"\")";
							}
							
							$result += ")";

							
							if($log!=null) $result += " "+$log.text + " " +$exp.result;
						
						$result = convertEntities($result);
					}
				;

cuantif returns [String result]
				: 'exactly one' {$result = "ExactlyOne";}
				| 'one or more' {$result = "OneOrMore";}
				| 'all' {$result = "All";}
				;

key_value_prop returns [String result, String key, String value, String assigValue, String type, String typeArg]
				: (k=IDENT|k=ACCESS|k='boolean'|k='integer') DP (v=STRING | v2=type)  (IGUAL a=assig_value ';' {$assigValue = $a.result;})?
					{
						
						$result = $k.text+"=";
						$key = $k.text;
						if(v2!=null) {
							$result += $v2.text;
							$value = $v2.text;
							$type = $v2.result;
							$typeArg = $v2.arg;
						}else{
							$result += $v.text;
							$value = $v.text;
						}
						
						if($assigValue==null) $assigValue = "";
						
					}
				;

type returns [String result, String arg]
				: (v='integer' | v='float' | v='natural' | v='number' | v='boolean')
				{
					if($v.text != "boolean") {
								$result = "integer";
							} else {
								$result = $v.text;
							}
							
				} (r=range {$arg = $r.min+","+$r.max;})? 
				| IDENT {$result = $IDENT.text;}
				| v='set' list {$result = $v.text; $arg = $list.values;}
				| v='enum' list {$result = $v.text; $arg = $list.values;}
				;
				
range returns [String min, String max]
				: CA RANGE CC
					{
						String rangeStr = $RANGE.text;
						rangeStr = rangeStr.replace("..",",");
						
						String[] vals = rangeStr.split(",");
						
						$min=vals[0];
						$max=vals[1];
					}
				| CA (i1=INT|i1=SINT) RANGE_SEPARATOR (i2=INT|i2=SINT) CC {$min=$i1.text; $max=$i2.text;}
				;

url
//				:'http' ('s')? '://' ~(WS | CC) (('/') ~(WS | CC))* ('/')
//				|'www.' ~(WS | CC) (('/') ~(WS | CC))* ('/')
				: STRING
				;
		
		
metrics_prop
				: METRICS {String metrics_def = "	"+"<met:metric id=\"boolean\" type=\"enumerated\" >\n" + 
														"		<met:value value=\"True\"/>\n" + 
														"		<met:value value=\"False\"/>\n" + 
														"	</met:metric>\n";} /*CA (ACCESS|IDENT) (',' (ACCESS|IDENT))* CC*/ DP (kv=key_value_prop
					{
						String mId, mType;
						String min = "0";
						String max = "500";
						mId = $kv.key;
						mType = convertMetricType($kv.type);
						
						
						
						metrics_def += "	<met:metric id=\""+mId+"\" type=\""+mType+"\" ";
						
						if($kv.typeArg!=null) {
							String[] aux = $kv.typeArg.split(",");
							
							if(mType == "enumerated") {
								metrics_def += ">\n";
								
								if($kv.type!=null && $kv.type.toLowerCase().equals("boolean")) {
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
						
					})+
					{
						metricsTemplate = "<met:metricXML xmlns:met=\"http:/www.isa.us.es/ada/metrics\">\n"+metrics_def+"</met:metricXML>";
					}
				;
						
globalDescription
				:GLOBALDESCRIPTION (kv=key_value_prop
					{
//						variablesSet +=
//						"					<wsag:Variable  wsag:Name=\""+ $kv.key +"\" wsag:Metric=\"metrics/"+metric+":"+$kv.value+"\" >\n"+
//						"						<wsag:Location >/"+$kv.key+"</wsag:Location>\n"+
//						"					</wsag:Variable >\n";
							
							offerItems += "				<OfferItem name=\""+$kv.key+"\" wsag:Metric=\"metrics/"+metric+":"+$kv.value+"\" >"+$kv.assigValue+"</OfferItem>\n";
					})+
				;
