/**
 * FetchScheduleResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _205._76._14._196;

public class FetchScheduleResponse  implements java.io.Serializable {
    private _205._76._14._196.FetchScheduleResponseFetchScheduleResult fetchScheduleResult;

    public FetchScheduleResponse() {
    }

    public FetchScheduleResponse(
           _205._76._14._196.FetchScheduleResponseFetchScheduleResult fetchScheduleResult) {
           this.fetchScheduleResult = fetchScheduleResult;
    }


    /**
     * Gets the fetchScheduleResult value for this FetchScheduleResponse.
     * 
     * @return fetchScheduleResult
     */
    public _205._76._14._196.FetchScheduleResponseFetchScheduleResult getFetchScheduleResult() {
        return fetchScheduleResult;
    }


    /**
     * Sets the fetchScheduleResult value for this FetchScheduleResponse.
     * 
     * @param fetchScheduleResult
     */
    public void setFetchScheduleResult(_205._76._14._196.FetchScheduleResponseFetchScheduleResult fetchScheduleResult) {
        this.fetchScheduleResult = fetchScheduleResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FetchScheduleResponse)) return false;
        FetchScheduleResponse other = (FetchScheduleResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fetchScheduleResult==null && other.getFetchScheduleResult()==null) || 
             (this.fetchScheduleResult!=null &&
              this.fetchScheduleResult.equals(other.getFetchScheduleResult())));
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
        if (getFetchScheduleResult() != null) {
            _hashCode += getFetchScheduleResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FetchScheduleResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://196.14.76.205/", ">FetchScheduleResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fetchScheduleResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "FetchScheduleResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://196.14.76.205/", ">>FetchScheduleResponse>FetchScheduleResult"));
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
