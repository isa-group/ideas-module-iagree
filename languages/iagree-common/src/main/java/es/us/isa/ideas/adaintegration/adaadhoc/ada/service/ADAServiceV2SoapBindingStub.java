/**
 * ADAServiceV2SoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Nov 19, 2006 (02:31:34 GMT+00:00) WSDL2Java emitter.
 */

package es.us.isa.ideas.adaintegration.adaadhoc.ada.service;

public class ADAServiceV2SoapBindingStub extends org.apache.axis.client.Stub implements es.us.isa.ideas.adaintegration.adaadhoc.ada.service.ADAServiceV2PortType {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[17];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("explainLudicrousTerms");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "ArrayOfTerm"), es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "Term"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "Term2ArrayOfAgreementElementMap"));
        oper.setReturnClass(es.us.isa.ideas.adaintegration.adaadhoc.ada.service.Term2ArrayOfAgreementElementMapEntry[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "entry"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "BadSyntaxException"),
                      "es.us.isa.ada.exceptions.BadSyntaxException",
                      new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "BadSyntaxException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getLudicrousTerms");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "ArrayOfTerm"));
        oper.setReturnClass(es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "Term"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "BadSyntaxException"),
                      "es.us.isa.ada.exceptions.BadSyntaxException",
                      new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "BadSyntaxException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("explainInconsistencies");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "AgreementElement2ArrayOfAgreementElementMap"));
        oper.setReturnClass(es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementElement2ArrayOfAgreementElementMapEntry[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "entry"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "BadSyntaxException"),
                      "es.us.isa.ada.exceptions.BadSyntaxException",
                      new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "BadSyntaxException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("checkDocumentConsistency");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "PeriodDefinitionException"),
                      "es.us.isa.ada.exceptions.PeriodDefinitionException",
                      new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "PeriodDefinitionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "PeriodDefinitionWarningException"),
                      "es.us.isa.ada.exceptions.PeriodDefinitionWarningException",
                      new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "PeriodDefinitionWarningException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "BadSyntaxException"),
                      "es.us.isa.ada.exceptions.BadSyntaxException",
                      new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "BadSyntaxException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDeadTerms");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "ArrayOfTerm"));
        oper.setReturnClass(es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "Term"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "BadSyntaxException"),
                      "es.us.isa.ada.exceptions.BadSyntaxException",
                      new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "BadSyntaxException"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("explainNonCompliance");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "AgreementError2ExplanationMap"));
        oper.setReturnClass(es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementError2ExplanationMapEntry[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "entry"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "BadSyntaxException"),
                      "es.us.isa.ada.exceptions.BadSyntaxException",
                      new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "BadSyntaxException"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMetricFile");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        oper.setReturnClass(byte[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("wsag4PeopleToXML");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        oper.setReturnClass(byte[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "BadSyntaxException"),
                      "es.us.isa.ada.exceptions.BadSyntaxException",
                      new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "BadSyntaxException"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("isCompliant");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "PeriodDefinitionException"),
                      "es.us.isa.ada.exceptions.PeriodDefinitionException",
                      new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "PeriodDefinitionException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "PeriodDefinitionWarningException"),
                      "es.us.isa.ada.exceptions.PeriodDefinitionWarningException",
                      new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "PeriodDefinitionWarningException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "BadSyntaxException"),
                      "es.us.isa.ada.exceptions.BadSyntaxException",
                      new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "BadSyntaxException"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("isFulfilled");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        oper.setReturnClass(boolean.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "BadSyntaxException"),
                      "es.us.isa.ada.exceptions.BadSyntaxException",
                      new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "BadSyntaxException"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("addMetricFile");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        oper.setReturnClass(java.lang.String.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getAlternativeDocuments");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "ArrayOfAbstractAgreementDocument"));
        oper.setReturnClass(es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "AbstractAgreementDocument"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getDocumentViews");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "ArrayOfAbstractAgreementDocument"));
        oper.setReturnClass(es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "AbstractAgreementDocument"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("explainDeadTerms");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "ArrayOfTerm"), es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "Term"));
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "Term2ArrayOfAgreementElementMap"));
        oper.setReturnClass(es.us.isa.ideas.adaintegration.adaadhoc.ada.service.Term2ArrayOfAgreementElementMapEntry[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "entry"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "BadSyntaxException"),
                      "es.us.isa.ada.exceptions.BadSyntaxException",
                      new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "BadSyntaxException"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getNumberOfAlternatives");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("explainAgreementViolation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "AgreementError2ExplanationMap"));
        oper.setReturnClass(es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementError2ExplanationMapEntry[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "entry"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "BadSyntaxException"),
                      "es.us.isa.ada.exceptions.BadSyntaxException",
                      new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "BadSyntaxException"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("xmlToWSAg4People");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"), byte[].class, false, false);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        oper.setReturnClass(byte[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "BadSyntaxException"),
                      "es.us.isa.ada.exceptions.BadSyntaxException",
                      new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "BadSyntaxException"), 
                      true
                     ));
        _operations[16] = oper;

    }

    public ADAServiceV2SoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public ADAServiceV2SoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public ADAServiceV2SoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://document.ada.isa.us.es", "AgreementElement");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AgreementElement.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://document.ada.isa.us.es", "ArrayOfAgreementElement");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.document.AgreementElement[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://document.ada.isa.us.es", "AgreementElement");
            qName2 = new javax.xml.namespace.QName("http://document.ada.isa.us.es", "AgreementElement");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://document.ada.isa.us.es", "ArrayOfDocumentConstraint");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.document.DocumentConstraint[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://document.ada.isa.us.es", "DocumentConstraint");
            qName2 = new javax.xml.namespace.QName("http://document.ada.isa.us.es", "DocumentConstraint");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://document.ada.isa.us.es", "ArrayOfDocumentVariable");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.document.DocumentVariable[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://document.ada.isa.us.es", "DocumentVariable");
            qName2 = new javax.xml.namespace.QName("http://document.ada.isa.us.es", "DocumentVariable");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://document.ada.isa.us.es", "ArrayOfRange");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.document.Range[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://document.ada.isa.us.es", "Range");
            qName2 = new javax.xml.namespace.QName("http://document.ada.isa.us.es", "Range");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://document.ada.isa.us.es", "DocumentConstraint");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.document.DocumentConstraint.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://document.ada.isa.us.es", "DocumentVariable");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.document.DocumentVariable.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://document.ada.isa.us.es", "Range");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.document.Range.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://errors.ada.isa.us.es", "AgreementError");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.errors.AgreementError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://errors.ada.isa.us.es", "Explanation");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.errors.Explanation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "BadSyntaxException");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "PeriodDefinitionException");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://exceptions.ada.isa.us.es", "PeriodDefinitionWarningException");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionWarningException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", ">AgreementElement2ArrayOfAgreementElementMap>entry");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementElement2ArrayOfAgreementElementMapEntry.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", ">AgreementError2ExplanationMap>entry");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementError2ExplanationMapEntry.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", ">Term2ArrayOfAgreementElementMap>entry");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.Term2ArrayOfAgreementElementMapEntry.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "addMetricFile");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AddMetricFile.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "addMetricFileResponse");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AddMetricFileResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "AgreementElement2ArrayOfAgreementElementMap");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementElement2ArrayOfAgreementElementMapEntry[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", ">AgreementElement2ArrayOfAgreementElementMap>entry");
            qName2 = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "entry");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "AgreementError2ExplanationMap");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementError2ExplanationMapEntry[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", ">AgreementError2ExplanationMap>entry");
            qName2 = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "entry");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "checkDocumentConsistency");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.CheckDocumentConsistency.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "checkDocumentConsistencyResponse");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.CheckDocumentConsistencyResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "explainAgreementViolation");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.ExplainAgreementViolation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "explainAgreementViolationResponse");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.ExplainAgreementViolationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "explainDeadTerms");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.ExplainDeadTerms.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "explainDeadTermsResponse");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.ExplainDeadTermsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "explainInconsistencies");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.ExplainInconsistencies.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "explainInconsistenciesResponse");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.ExplainInconsistenciesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "explainLudicrousTerms");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.ExplainLudicrousTerms.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "explainLudicrousTermsResponse");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.ExplainLudicrousTermsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "explainNonCompliance");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.ExplainNonCompliance.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "explainNonComplianceResponse");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.ExplainNonComplianceResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getAlternativeDocuments");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.GetAlternativeDocuments.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getAlternativeDocumentsResponse");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.GetAlternativeDocumentsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getDeadTerms");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.GetDeadTerms.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getDeadTermsResponse");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.GetDeadTermsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getDocumentViews");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.GetDocumentViews.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getDocumentViewsResponse");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.GetDocumentViewsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getLudicrousTerms");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.GetLudicrousTerms.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getLudicrousTermsResponse");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.GetLudicrousTermsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getMetricFile");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.GetMetricFile.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getMetricFileResponse");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.GetMetricFileResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getNumberOfAlternatives");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.GetNumberOfAlternatives.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getNumberOfAlternativesResponse");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.GetNumberOfAlternativesResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "isCompliant");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.IsCompliant.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "isCompliantResponse");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.IsCompliantResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "isFulfilled");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.IsFulfilled.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "isFulfilledResponse");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.IsFulfilledResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "Term2ArrayOfAgreementElementMap");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.Term2ArrayOfAgreementElementMapEntry[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", ">Term2ArrayOfAgreementElementMap>entry");
            qName2 = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "entry");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "wsag4PeopleToXML");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.Wsag4PeopleToXML.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "wsag4PeopleToXMLResponse");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.Wsag4PeopleToXMLResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "xmlToWSAg4People");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.XmlToWSAg4People.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "xmlToWSAg4PeopleResponse");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.service.XmlToWSAg4PeopleResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://util.isa.us.es", "ArrayOfNode");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.util.Node[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://util.isa.us.es", "Node");
            qName2 = new javax.xml.namespace.QName("http://util.isa.us.es", "Node");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://util.isa.us.es", "Node");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.util.Node.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://util.isa.us.es", "Tree");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.util.Tree.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "AbstractAgreementDocument");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "ArrayOfAbstractAgreementDocument");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "AbstractAgreementDocument");
            qName2 = new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "AbstractAgreementDocument");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "ArrayOfTerm");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "Term");
            qName2 = new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "Term");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "Context");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Context.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "Term");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://wsag10.ada.isa.us.es", "TermCompositor");
            cachedSerQNames.add(qName);
            cls = es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.TermCompositor.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Exception _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public es.us.isa.ideas.adaintegration.adaadhoc.ada.service.Term2ArrayOfAgreementElementMapEntry[] explainLudicrousTerms(byte[] arg0, es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[] arg1) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "explainLudicrousTerms"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.service.Term2ArrayOfAgreementElementMapEntry[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.service.Term2ArrayOfAgreementElementMapEntry[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.us.isa.ideas.adaintegration.adaadhoc.ada.service.Term2ArrayOfAgreementElementMapEntry[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) {
              throw (es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[] getLudicrousTerms(byte[] arg0) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getLudicrousTerms"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) {
              throw (es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementElement2ArrayOfAgreementElementMapEntry[] explainInconsistencies(byte[] arg0) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "explainInconsistencies"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementElement2ArrayOfAgreementElementMapEntry[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementElement2ArrayOfAgreementElementMapEntry[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementElement2ArrayOfAgreementElementMapEntry[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) {
              throw (es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public boolean checkDocumentConsistency(byte[] arg0) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionWarningException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "checkDocumentConsistency"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionException) {
              throw (es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionWarningException) {
              throw (es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionWarningException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) {
              throw (es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[] getDeadTerms(byte[] arg0) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getDeadTerms"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) {
              throw (es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementError2ExplanationMapEntry[] explainNonCompliance(byte[] arg0, byte[] arg1) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "explainNonCompliance"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementError2ExplanationMapEntry[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementError2ExplanationMapEntry[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementError2ExplanationMapEntry[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) {
              throw (es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public byte[] getMetricFile(java.lang.String arg0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getMetricFile"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (byte[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (byte[]) org.apache.axis.utils.JavaUtils.convert(_resp, byte[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public byte[] wsag4PeopleToXML(byte[] arg0) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "wsag4PeopleToXML"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (byte[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (byte[]) org.apache.axis.utils.JavaUtils.convert(_resp, byte[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) {
              throw (es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public boolean isCompliant(byte[] arg0, byte[] arg1) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionWarningException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "isCompliant"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionException) {
              throw (es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionWarningException) {
              throw (es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionWarningException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) {
              throw (es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public boolean isFulfilled(byte[] arg0, byte[] arg1) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "isFulfilled"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Boolean) _resp).booleanValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Boolean) org.apache.axis.utils.JavaUtils.convert(_resp, boolean.class)).booleanValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) {
              throw (es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public java.lang.String addMetricFile(byte[] arg0, byte[] arg1) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "addMetricFile"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (java.lang.String) _resp;
            } catch (java.lang.Exception _exception) {
                return (java.lang.String) org.apache.axis.utils.JavaUtils.convert(_resp, java.lang.String.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument[] getAlternativeDocuments(byte[] arg0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getAlternativeDocuments"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument[] getDocumentViews(byte[] arg0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getDocumentViews"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.us.isa.ideas.adaintegration.adaadhoc.ada.service.Term2ArrayOfAgreementElementMapEntry[] explainDeadTerms(byte[] arg0, es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[] arg1) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "explainDeadTerms"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.service.Term2ArrayOfAgreementElementMapEntry[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.service.Term2ArrayOfAgreementElementMapEntry[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.us.isa.ideas.adaintegration.adaadhoc.ada.service.Term2ArrayOfAgreementElementMapEntry[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) {
              throw (es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int getNumberOfAlternatives(byte[] arg0) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getNumberOfAlternatives"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementError2ExplanationMapEntry[] explainAgreementViolation(byte[] arg0, byte[] arg1) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "explainAgreementViolation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0, arg1});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementError2ExplanationMapEntry[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementError2ExplanationMapEntry[]) org.apache.axis.utils.JavaUtils.convert(_resp, es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementError2ExplanationMapEntry[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) {
              throw (es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public byte[] xmlToWSAg4People(byte[] arg0) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "xmlToWSAg4People"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {arg0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (byte[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (byte[]) org.apache.axis.utils.JavaUtils.convert(_resp, byte[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) {
              throw (es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
