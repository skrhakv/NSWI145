
package hw5.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.5.1
 * Wed Mar 23 14:51:33 CET 2022
 * Generated source version: 3.5.1
 */

@XmlRootElement(name = "ValidatePayment", namespace = "http://hw5/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ValidatePayment", namespace = "http://hw5/", propOrder = {"arg0", "arg1", "arg2", "arg3"})

public class ValidatePayment {

    @XmlElement(name = "arg0")
    private java.lang.String arg0;
    @XmlElement(name = "arg1")
    private java.lang.String arg1;
    @XmlElement(name = "arg2")
    private java.lang.String arg2;
    @XmlElement(name = "arg3")
    private java.lang.Integer arg3;

    public java.lang.String getArg0() {
        return this.arg0;
    }

    public void setArg0(java.lang.String newArg0)  {
        this.arg0 = newArg0;
    }

    public java.lang.String getArg1() {
        return this.arg1;
    }

    public void setArg1(java.lang.String newArg1)  {
        this.arg1 = newArg1;
    }

    public java.lang.String getArg2() {
        return this.arg2;
    }

    public void setArg2(java.lang.String newArg2)  {
        this.arg2 = newArg2;
    }

    public java.lang.Integer getArg3() {
        return this.arg3;
    }

    public void setArg3(java.lang.Integer newArg3)  {
        this.arg3 = newArg3;
    }

}

