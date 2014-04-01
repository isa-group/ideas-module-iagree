/**
 * AgreementElement2ArrayOfAgreementElementMapEntry.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Nov 19, 2006 (02:31:34 GMT+00:00) WSDL2Java emitter.
 */

package es.us.isa.ada.service;

public class AgreementElement2ArrayOfAgreementElementMapEntry  implements java.io.Serializable {
    private es.us.isa.ada.document.AgreementElement key;

    private es.us.isa.ada.document.AgreementElement[] value;

    public AgreementElement2ArrayOfAgreementElementMapEntry() {
    }

    public AgreementElement2ArrayOfAgreementElementMapEntry(
           es.us.isa.ada.document.AgreementElement key,
           es.us.isa.ada.document.AgreementElement[] value) {
           this.key = key;
           this.value = value;
    }


    /**
     * Gets the key value for this AgreementElement2ArrayOfAgreementElementMapEntry.
     * 
     * @return key
     */
    public es.us.isa.ada.document.AgreementElement getKey() {
        return key;
    }


    /**
     * Sets the key value for this AgreementElement2ArrayOfAgreementElementMapEntry.
     * 
     * @param key
     */
    public void setKey(es.us.isa.ada.document.AgreementElement key) {
        this.key = key;
    }


    /**
     * Gets the value value for this AgreementElement2ArrayOfAgreementElementMapEntry.
     * 
     * @return value
     */
    public es.us.isa.ada.document.AgreementElement[] getValue() {
        return value;
    }


    /**
     * Sets the value value for this AgreementElement2ArrayOfAgreementElementMapEntry.
     * 
     * @param value
     */
    public void setValue(es.us.isa.ada.document.AgreementElement[] value) {
        this.value = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AgreementElement2ArrayOfAgreementElementMapEntry)) return false;
        AgreementElement2ArrayOfAgreementElementMapEntry other = (AgreementElement2ArrayOfAgreementElementMapEntry) obj;
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
              java.util.Arrays.equals(this.value, other.getValue())));
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
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getValue());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getValue(), i);
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
        new org.apache.axis.description.TypeDesc(AgreementElement2ArrayOfAgreementElementMapEntry.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", ">AgreementElement2ArrayOfAgreementElementMap>entry"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("key");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "key"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://document.ada.isa.us.es", "AgreementElement"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "value"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://document.ada.isa.us.es", "AgreementElement"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://document.ada.isa.us.es", "AgreementElement"));
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
