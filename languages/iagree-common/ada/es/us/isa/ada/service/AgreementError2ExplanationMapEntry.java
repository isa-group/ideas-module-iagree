/**
 * AgreementError2ExplanationMapEntry.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Nov 19, 2006 (02:31:34 GMT+00:00) WSDL2Java emitter.
 */

package es.us.isa.ada.service;

public class AgreementError2ExplanationMapEntry  implements java.io.Serializable {
    private es.us.isa.ada.errors.AgreementError key;

    private es.us.isa.ada.errors.Explanation value;

    public AgreementError2ExplanationMapEntry() {
    }

    public AgreementError2ExplanationMapEntry(
           es.us.isa.ada.errors.AgreementError key,
           es.us.isa.ada.errors.Explanation value) {
           this.key = key;
           this.value = value;
    }


    /**
     * Gets the key value for this AgreementError2ExplanationMapEntry.
     * 
     * @return key
     */
    public es.us.isa.ada.errors.AgreementError getKey() {
        return key;
    }


    /**
     * Sets the key value for this AgreementError2ExplanationMapEntry.
     * 
     * @param key
     */
    public void setKey(es.us.isa.ada.errors.AgreementError key) {
        this.key = key;
    }


    /**
     * Gets the value value for this AgreementError2ExplanationMapEntry.
     * 
     * @return value
     */
    public es.us.isa.ada.errors.Explanation getValue() {
        return value;
    }


    /**
     * Sets the value value for this AgreementError2ExplanationMapEntry.
     * 
     * @param value
     */
    public void setValue(es.us.isa.ada.errors.Explanation value) {
        this.value = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AgreementError2ExplanationMapEntry)) return false;
        AgreementError2ExplanationMapEntry other = (AgreementError2ExplanationMapEntry) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.key==null && other.getKey()==null) || 
             (this.key!=null &&
              this.key.equals(other.getKey()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue())));
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
        if (getKey() != null) {
            _hashCode += getKey().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AgreementError2ExplanationMapEntry.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", ">AgreementError2ExplanationMap>entry"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("key");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "key"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://errors.ada.isa.us.es", "AgreementError"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://errors.ada.isa.us.es", "Explanation"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
