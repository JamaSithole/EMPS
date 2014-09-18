/**
 * CountUnreadReceivedResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _205._76._14._196;

public class CountUnreadReceivedResponse  implements java.io.Serializable {
    private int countUnreadReceivedResult;

    public CountUnreadReceivedResponse() {
    }

    public CountUnreadReceivedResponse(
           int countUnreadReceivedResult) {
           this.countUnreadReceivedResult = countUnreadReceivedResult;
    }


    /**
     * Gets the countUnreadReceivedResult value for this CountUnreadReceivedResponse.
     * 
     * @return countUnreadReceivedResult
     */
    public int getCountUnreadReceivedResult() {
        return countUnreadReceivedResult;
    }


    /**
     * Sets the countUnreadReceivedResult value for this CountUnreadReceivedResponse.
     * 
     * @param countUnreadReceivedResult
     */
    public void setCountUnreadReceivedResult(int countUnreadReceivedResult) {
        this.countUnreadReceivedResult = countUnreadReceivedResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CountUnreadReceivedResponse)) return false;
        CountUnreadReceivedResponse other = (CountUnreadReceivedResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.countUnreadReceivedResult == other.getCountUnreadReceivedResult();
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
        _hashCode += getCountUnreadReceivedResult();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CountUnreadReceivedResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://196.14.76.205/", ">CountUnreadReceivedResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("countUnreadReceivedResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "CountUnreadReceivedResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
