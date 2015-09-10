/**
 * ADAServiceV2PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Nov 19, 2006 (02:31:34 GMT+00:00) WSDL2Java emitter.
 */

package es.us.isa.ideas.adaintegration.adaadhoc.ada.service;

public interface ADAServiceV2PortType extends java.rmi.Remote {
    public es.us.isa.ideas.adaintegration.adaadhoc.ada.service.Term2ArrayOfAgreementElementMapEntry[] explainLudicrousTerms(byte[] arg0, es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[] arg1) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
    public es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[] getLudicrousTerms(byte[] arg0) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
    public es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementElement2ArrayOfAgreementElementMapEntry[] explainInconsistencies(byte[] arg0) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
    public es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[] getDeadTerms(byte[] arg0) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
    public boolean checkDocumentConsistency(byte[] arg0) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionWarningException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
    public es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementError2ExplanationMapEntry[] explainNonCompliance(byte[] arg0, byte[] arg1) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
    public byte[] wsag4PeopleToXML(byte[] arg0) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
    public byte[] getMetricFile(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean isFulfilled(byte[] arg0, byte[] arg1) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
    public boolean isCompliant(byte[] arg0, byte[] arg1) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.PeriodDefinitionWarningException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
    public java.lang.String addMetricFile(byte[] arg0, byte[] arg1) throws java.rmi.RemoteException;
    public es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument[] getAlternativeDocuments(byte[] arg0) throws java.rmi.RemoteException;
    public es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.AbstractAgreementDocument[] getDocumentViews(byte[] arg0) throws java.rmi.RemoteException;
    public es.us.isa.ideas.adaintegration.adaadhoc.ada.service.Term2ArrayOfAgreementElementMapEntry[] explainDeadTerms(byte[] arg0, es.us.isa.ideas.adaintegration.adaadhoc.ada.wsag10.Term[] arg1) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
    public int getNumberOfAlternatives(byte[] arg0) throws java.rmi.RemoteException;
    public es.us.isa.ideas.adaintegration.adaadhoc.ada.service.AgreementError2ExplanationMapEntry[] explainAgreementViolation(byte[] arg0, byte[] arg1) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
    public byte[] xmlToWSAg4People(byte[] arg0) throws java.rmi.RemoteException, es.us.isa.ideas.adaintegration.adaadhoc.ada.exceptions.BadSyntaxException;
}
