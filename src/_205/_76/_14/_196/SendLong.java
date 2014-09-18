/**
 * SendLong.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package _205._76._14._196;

public class SendLong  implements java.io.Serializable {
    private java.lang.String recepient;

    private java.lang.String short_message;

    private java.lang.String message_id;

    private java.lang.String dispatch_datetime;

    private java.lang.String cutoff_datetime;

    private java.lang.String user_id;

    public SendLong() {
    }

    public SendLong(
           java.lang.String recepient,
           java.lang.String short_message,
           java.lang.String message_id,
           java.lang.String dispatch_datetime,
           java.lang.String cutoff_datetime,
           java.lang.String user_id) {
           this.recepient = recepient;
           this.short_message = short_message;
           this.message_id = message_id;
           this.dispatch_datetime = dispatch_datetime;
           this.cutoff_datetime = cutoff_datetime;
           this.user_id = user_id;
    }


    /**
     * Gets the recepient value for this SendLong.
     * 
     * @return recepient
     */
    public java.lang.String getRecepient() {
        return recepient;
    }


    /**
     * Sets the recepient value for this SendLong.
     * 
     * @param recepient
     */
    public void setRecepient(java.lang.String recepient) {
        this.recepient = recepient;
    }


    /**
     * Gets the short_message value for this SendLong.
     * 
     * @return short_message
     */
    public java.lang.String getShort_message() {
        return short_message;
    }


    /**
     * Sets the short_message value for this SendLong.
     * 
     * @param short_message
     */
    public void setShort_message(java.lang.String short_message) {
        this.short_message = short_message;
    }


    /**
     * Gets the message_id value for this SendLong.
     * 
     * @return message_id
     */
    public java.lang.String getMessage_id() {
        return message_id;
    }


    /**
     * Sets the message_id value for this SendLong.
     * 
     * @param message_id
     */
    public void setMessage_id(java.lang.String message_id) {
        this.message_id = message_id;
    }


    /**
     * Gets the dispatch_datetime value for this SendLong.
     * 
     * @return dispatch_datetime
     */
    public java.lang.String getDispatch_datetime() {
        return dispatch_datetime;
    }


    /**
     * Sets the dispatch_datetime value for this SendLong.
     * 
     * @param dispatch_datetime
     */
    public void setDispatch_datetime(java.lang.String dispatch_datetime) {
        this.dispatch_datetime = dispatch_datetime;
    }


    /**
     * Gets the cutoff_datetime value for this SendLong.
     * 
     * @return cutoff_datetime
     */
    public java.lang.String getCutoff_datetime() {
        return cutoff_datetime;
    }


    /**
     * Sets the cutoff_datetime value for this SendLong.
     * 
     * @param cutoff_datetime
     */
    public void setCutoff_datetime(java.lang.String cutoff_datetime) {
        this.cutoff_datetime = cutoff_datetime;
    }


    /**
     * Gets the user_id value for this SendLong.
     * 
     * @return user_id
     */
    public java.lang.String getUser_id() {
        return user_id;
    }


    /**
     * Sets the user_id value for this SendLong.
     * 
     * @param user_id
     */
    public void setUser_id(java.lang.String user_id) {
        this.user_id = user_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SendLong)) return false;
        SendLong other = (SendLong) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.recepient==null && other.getRecepient()==null) || 
             (this.recepient!=null &&
              this.recepient.equals(other.getRecepient()))) &&
            ((this.short_message==null && other.getShort_message()==null) || 
             (this.short_message!=null &&
              this.short_message.equals(other.getShort_message()))) &&
            ((this.message_id==null && other.getMessage_id()==null) || 
             (this.message_id!=null &&
              this.message_id.equals(other.getMessage_id()))) &&
            ((this.dispatch_datetime==null && other.getDispatch_datetime()==null) || 
             (this.dispatch_datetime!=null &&
              this.dispatch_datetime.equals(other.getDispatch_datetime()))) &&
            ((this.cutoff_datetime==null && other.getCutoff_datetime()==null) || 
             (this.cutoff_datetime!=null &&
              this.cutoff_datetime.equals(other.getCutoff_datetime()))) &&
            ((this.user_id==null && other.getUser_id()==null) || 
             (this.user_id!=null &&
              this.user_id.equals(other.getUser_id())));
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
        if (getRecepient() != null) {
            _hashCode += getRecepient().hashCode();
        }
        if (getShort_message() != null) {
            _hashCode += getShort_message().hashCode();
        }
        if (getMessage_id() != null) {
            _hashCode += getMessage_id().hashCode();
        }
        if (getDispatch_datetime() != null) {
            _hashCode += getDispatch_datetime().hashCode();
        }
        if (getCutoff_datetime() != null) {
            _hashCode += getCutoff_datetime().hashCode();
        }
        if (getUser_id() != null) {
            _hashCode += getUser_id().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SendLong.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://196.14.76.205/", ">SendLong"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recepient");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "recepient"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("short_message");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "short_message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "message_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dispatch_datetime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "dispatch_datetime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cutoff_datetime");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "cutoff_datetime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("user_id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://196.14.76.205/", "user_id"));
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
