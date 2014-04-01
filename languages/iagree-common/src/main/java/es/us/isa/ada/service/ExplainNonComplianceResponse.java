/**
 * ExplainNonComplianceResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Nov 19, 2006 (02:31:34 GMT+00:00) WSDL2Java emitter.
 */

package es.us.isa.ada.service;

public class ExplainNonComplianceResponse  implements java.io.Serializable {
    private es.us.isa.ada.service.AgreementError2ExplanationMapEntry[] _return;

    public ExplainNonComplianceResponse() {
    }

    public ExplainNonComplianceResponse(
           es.us.isa.ada.service.AgreementError2ExplanationMapEntry[] _return) {
           this._return = _return;
    }


    /**
     * Gets the _return value for this ExplainNonComplianceResponse.
     * 
     * @return _return
     */
    public es.us.isa.ada.service.AgreementError2ExplanationMapEntry[] get_return() {
        return _return;
    }


    /**
     * Sets the _return value for this ExplainNonComplianceResponse.
     * 
     * @param _return
     */
    public void set_return(es.us.isa.ada.service.AgreementError2ExplanationMapEntry[] _return) {
        this._return = _return;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ExplainNonComplianceResponse)) return false;
        ExplainNonComplianceResponse other = (ExplainNonComplianceResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this._return==null && other.get_return()==null) || 
             (this._return!=null &&
              java.util.Arrays.equals(this._return, other.get_return())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (get_return() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(get_return());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(get_return(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ExplainNonComplianceResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "explainNonComplianceResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("_return");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "return"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", ">AgreementError2ExplanationMap>entry"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "entry"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
