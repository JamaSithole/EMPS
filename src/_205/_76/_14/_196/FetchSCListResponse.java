/**
 * FetchSCListResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _205._76._14._196;

public class FetchSCListResponse  implements java.io.Serializable {
    private java.lang.String[] fetchSCListResult;

    public FetchSCListResponse() {
    }

    public FetchSCListResponse(
           java.lang.String[] fetchSCListResult) {
           this.fetchSCListResult = fetchSCListResult;
    }


    /**
     * Gets the fetchSCListResult value for this FetchSCListResponse.
     * 
     * @return fetchSCListResult
     */
    public java.lang.String[] getFetchSCListResult() {
        return fetchSCListResult;
    }


    /**
     * Sets the fetchSCListResult value for this FetchSCListResponse.
     * 
     * @param fetchSCListResult
     */
    public void setFetchSCListResult(java.lang.String[] fetchSCListResult) {
        this.fetchSCListResult = fetchSCListResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FetchSCListResponse)) return false;
        FetchSCListResponse other = (FetchSCListResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fetchSCListResult==null && other.getFetchSCListResult()==null) || 
             (this.fetchSCListResult!=null &&
              java.util.Arrays.equals(this.fetchSCListResult, other.getFetchSCListResult())));
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
        if (getFetchSCListResult() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFetchSCListResult());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFetchSCListResult(), i);
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
        new org.apache.axis.description.TypeDesc(FetchSCListResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://196.14.76.205/", ">FetchSCListResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fetchSCListResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "FetchSCListResult"));
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
