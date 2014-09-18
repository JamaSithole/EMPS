/**
 * WebRetrieveSent.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _205._76._14._196;

public class WebRetrieveSent  implements java.io.Serializable {
    private java.lang.String userId;

    private java.lang.String date_from;

    private java.lang.String date_to;

    private int readstart;

    private int readend;

    private java.lang.String order;

    public WebRetrieveSent() {
    }

    public WebRetrieveSent(
           java.lang.String userId,
           java.lang.String date_from,
           java.lang.String date_to,
           int readstart,
           int readend,
           java.lang.String order) {
           this.userId = userId;
           this.date_from = date_from;
           this.date_to = date_to;
           this.readstart = readstart;
           this.readend = readend;
           this.order = order;
    }


    /**
     * Gets the userId value for this WebRetrieveSent.
     * 
     * @return userId
     */
    public java.lang.String getUserId() {
        return userId;
    }


    /**
     * Sets the userId value for this WebRetrieveSent.
     * 
     * @param userId
     */
    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }


    /**
     * Gets the date_from value for this WebRetrieveSent.
     * 
     * @return date_from
     */
    public java.lang.String getDate_from() {
        return date_from;
    }


    /**
     * Sets the date_from value for this WebRetrieveSent.
     * 
     * @param date_from
     */
    public void setDate_from(java.lang.String date_from) {
        this.date_from = date_from;
    }


    /**
     * Gets the date_to value for this WebRetrieveSent.
     * 
     * @return date_to
     */
    public java.lang.String getDate_to() {
        return date_to;
    }


    /**
     * Sets the date_to value for this WebRetrieveSent.
     * 
     * @param date_to
     */
    public void setDate_to(java.lang.String date_to) {
        this.date_to = date_to;
    }


    /**
     * Gets the readstart value for this WebRetrieveSent.
     * 
     * @return readstart
     */
    public int getReadstart() {
        return readstart;
    }


    /**
     * Sets the readstart value for this WebRetrieveSent.
     * 
     * @param readstart
     */
    public void setReadstart(int readstart) {
        this.readstart = readstart;
    }


    /**
     * Gets the readend value for this WebRetrieveSent.
     * 
     * @return readend
     */
    public int getReadend() {
        return readend;
    }


    /**
     * Sets the readend value for this WebRetrieveSent.
     * 
     * @param readend
     */
    public void setReadend(int readend) {
        this.readend = readend;
    }


    /**
     * Gets the order value for this WebRetrieveSent.
     * 
     * @return order
     */
    public java.lang.String getOrder() {
        return order;
    }


    /**
     * Sets the order value for this WebRetrieveSent.
     * 
     * @param order
     */
    public void setOrder(java.lang.String order) {
        this.order = order;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof WebRetrieveSent)) return false;
        WebRetrieveSent other = (WebRetrieveSent) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.userId==null && other.getUserId()==null) || 
             (this.userId!=null &&
              this.userId.equals(other.getUserId()))) &&
            ((this.date_from==null && other.getDate_from()==null) || 
             (this.date_from!=null &&
              this.date_from.equals(other.getDate_from()))) &&
            ((this.date_to==null && other.getDate_to()==null) || 
             (this.date_to!=null &&
              this.date_to.equals(other.getDate_to()))) &&
            this.readstart == other.getReadstart() &&
            this.readend == other.getReadend() &&
            ((this.order==null && other.getOrder()==null) || 
             (this.order!=null &&
              this.order.equals(other.getOrder())));
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
        if (getUserId() != null) {
            _hashCode += getUserId().hashCode();
        }
        if (getDate_from() != null) {
            _hashCode += getDate_from().hashCode();
        }
        if (getDate_to() != null) {
            _hashCode += getDate_to().hashCode();
        }
        _hashCode += getReadstart();
        _hashCode += getReadend();
        if (getOrder() != null) {
            _hashCode += getOrder().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(WebRetrieveSent.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://196.14.76.205/", ">WebRetrieveSent"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("userId");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "UserId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date_from");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "date_from"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("date_to");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "date_to"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("readstart");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "readstart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("readend");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "readend"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("order");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "order"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
