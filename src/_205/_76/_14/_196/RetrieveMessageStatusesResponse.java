/**
 * RetrieveMessageStatusesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _205._76._14._196;

public class RetrieveMessageStatusesResponse  implements java.io.Serializable {
    private java.lang.String[] retrieveMessageStatusesResult;

    public RetrieveMessageStatusesResponse() {
    }

    public RetrieveMessageStatusesResponse(
           java.lang.String[] retrieveMessageStatusesResult) {
           this.retrieveMessageStatusesResult = retrieveMessageStatusesResult;
    }


    /**
     * Gets the retrieveMessageStatusesResult value for this RetrieveMessageStatusesResponse.
     * 
     * @return retrieveMessageStatusesResult
     */
    public java.lang.String[] getRetrieveMessageStatusesResult() {
        return retrieveMessageStatusesResult;
    }


    /**
     * Sets the retrieveMessageStatusesResult value for this RetrieveMessageStatusesResponse.
     * 
     * @param retrieveMessageStatusesResult
     */
    public void setRetrieveMessageStatusesResult(java.lang.String[] retrieveMessageStatusesResult) {
        this.retrieveMessageStatusesResult = retrieveMessageStatusesResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RetrieveMessageStatusesResponse)) return false;
        RetrieveMessageStatusesResponse other = (RetrieveMessageStatusesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.retrieveMessageStatusesResult==null && other.getRetrieveMessageStatusesResult()==null) || 
             (this.retrieveMessageStatusesResult!=null &&
              java.util.Arrays.equals(this.retrieveMessageStatusesResult, other.getRetrieveMessageStatusesResult())));
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
        if (getRetrieveMessageStatusesResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRetrieveMessageStatusesResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRetrieveMessageStatusesResult(), i);
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
        new org.apache.axis.description.TypeDesc(RetrieveMessageStatusesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://196.14.76.205/", ">RetrieveMessageStatusesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retrieveMessageStatusesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "RetrieveMessageStatusesResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://196.14.76.205/", "string"));
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
