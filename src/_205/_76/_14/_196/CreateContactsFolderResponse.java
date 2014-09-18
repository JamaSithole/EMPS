/**
 * CreateContactsFolderResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _205._76._14._196;

public class CreateContactsFolderResponse  implements java.io.Serializable {
    private boolean createContactsFolderResult;

    public CreateContactsFolderResponse() {
    }

    public CreateContactsFolderResponse(
           boolean createContactsFolderResult) {
           this.createContactsFolderResult = createContactsFolderResult;
    }


    /**
     * Gets the createContactsFolderResult value for this CreateContactsFolderResponse.
     * 
     * @return createContactsFolderResult
     */
    public boolean isCreateContactsFolderResult() {
        return createContactsFolderResult;
    }


    /**
     * Sets the createContactsFolderResult value for this CreateContactsFolderResponse.
     * 
     * @param createContactsFolderResult
     */
    public void setCreateContactsFolderResult(boolean createContactsFolderResult) {
        this.createContactsFolderResult = createContactsFolderResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreateContactsFolderResponse)) return false;
        CreateContactsFolderResponse other = (CreateContactsFolderResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.createContactsFolderResult == other.isCreateContactsFolderResult();
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
        _hashCode += (isCreateContactsFolderResult() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CreateContactsFolderResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://196.14.76.205/", ">CreateContactsFolderResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createContactsFolderResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "CreateContactsFolderResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
