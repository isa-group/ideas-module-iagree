/**
 * GetLudicrousTerms.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Nov 19, 2006 (02:31:34 GMT+00:00) WSDL2Java emitter.
 */

package es.us.isa.ada.service;

public class GetLudicrousTerms  implements java.io.Serializable {
    private byte[] arg0;

    public GetLudicrousTerms() {
    }

    public GetLudicrousTerms(
           byte[] arg0) {
           this.arg0 = arg0;
    }


    /**
     * Gets the arg0 value for this GetLudicrousTerms.
     * 
     * @return arg0
     */
    public byte[] getArg0() {
        return arg0;
    }


    /**
     * Sets the arg0 value for this GetLudicrousTerms.
     * 
     * @param arg0
     */
    public void setArg0(byte[] arg0) {
        this.arg0 = arg0;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetLudicrousTerms)) return false;
        GetLudicrousTerms other = (GetLudicrousTerms) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arg0==null && other.getArg0()==null) || 
             (this.arg0!=null &&
              java.util.Arrays.equals(this.arg0, other.getArg0())));
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
        if (getArg0() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getArg0());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getArg0(), i);
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
        new org.apache.axis.description.TypeDesc(GetLudicrousTerms.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "getLudicrousTerms"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arg0");
        elemField.setXmlName(new javax.xml.namespace.QName("http://service.ada.isa.us.es/", "arg0"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "base64Binary"));
        elemField.setNillable(true);
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
