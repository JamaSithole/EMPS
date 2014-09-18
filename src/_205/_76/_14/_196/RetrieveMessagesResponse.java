/**
 * RetrieveMessagesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _205._76._14._196;

public class RetrieveMessagesResponse  implements java.io.Serializable {
    private _205._76._14._196.RetrieveMessagesResponseRetrieveMessagesResult retrieveMessagesResult;

    public RetrieveMessagesResponse() {
    }

    public RetrieveMessagesResponse(
           _205._76._14._196.RetrieveMessagesResponseRetrieveMessagesResult retrieveMessagesResult) {
           this.retrieveMessagesResult = retrieveMessagesResult;
    }


    /**
     * Gets the retrieveMessagesResult value for this RetrieveMessagesResponse.
     * 
     * @return retrieveMessagesResult
     */
    public _205._76._14._196.RetrieveMessagesResponseRetrieveMessagesResult getRetrieveMessagesResult() {
        return retrieveMessagesResult;
    }


    /**
     * Sets the retrieveMessagesResult value for this RetrieveMessagesResponse.
     * 
     * @param retrieveMessagesResult
     */
    public void setRetrieveMessagesResult(_205._76._14._196.RetrieveMessagesResponseRetrieveMessagesResult retrieveMessagesResult) {
        this.retrieveMessagesResult = retrieveMessagesResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RetrieveMessagesResponse)) return false;
        RetrieveMessagesResponse other = (RetrieveMessagesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.retrieveMessagesResult==null && other.getRetrieveMessagesResult()==null) || 
             (this.retrieveMessagesResult!=null &&
              this.retrieveMessagesResult.equals(other.getRetrieveMessagesResult())));
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
        if (getRetrieveMessagesResult() != null) {
            _hashCode += getRetrieveMessagesResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RetrieveMessagesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://196.14.76.205/", ">RetrieveMessagesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("retrieveMessagesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "RetrieveMessagesResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://196.14.76.205/", ">>RetrieveMessagesResponse>RetrieveMessagesResult"));
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
