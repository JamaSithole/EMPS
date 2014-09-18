/**
 * WebRetrieveSentResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _205._76._14._196;

public class WebRetrieveSentResponse  implements java.io.Serializable {
    private _205._76._14._196.WebRetrieveSentResponseWebRetrieveSentResult webRetrieveSentResult;

    public WebRetrieveSentResponse() {
    }

    public WebRetrieveSentResponse(
           _205._76._14._196.WebRetrieveSentResponseWebRetrieveSentResult webRetrieveSentResult) {
           this.webRetrieveSentResult = webRetrieveSentResult;
    }


    /**
     * Gets the webRetrieveSentResult value for this WebRetrieveSentResponse.
     * 
     * @return webRetrieveSentResult
     */
    public _205._76._14._196.WebRetrieveSentResponseWebRetrieveSentResult getWebRetrieveSentResult() {
        return webRetrieveSentResult;
    }


    /**
     * Sets the webRetrieveSentResult value for this WebRetrieveSentResponse.
     * 
     * @param webRetrieveSentResult
     */
    public void setWebRetrieveSentResult(_205._76._14._196.WebRetrieveSentResponseWebRetrieveSentResult webRetrieveSentResult) {
        this.webRetrieveSentResult = webRetrieveSentResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WebRetrieveSentResponse)) return false;
        WebRetrieveSentResponse other = (WebRetrieveSentResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.webRetrieveSentResult==null && other.getWebRetrieveSentResult()==null) || 
             (this.webRetrieveSentResult!=null &&
              this.webRetrieveSentResult.equals(other.getWebRetrieveSentResult())));
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
        if (getWebRetrieveSentResult() != null) {
            _hashCode += getWebRetrieveSentResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WebRetrieveSentResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://196.14.76.205/", ">WebRetrieveSentResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("webRetrieveSentResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "WebRetrieveSentResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://196.14.76.205/", ">>WebRetrieveSentResponse>WebRetrieveSentResult"));
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
