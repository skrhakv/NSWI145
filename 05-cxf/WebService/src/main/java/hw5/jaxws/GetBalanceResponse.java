
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

@XmlRootElement(name = "GetBalanceResponse", namespace = "http://hw5/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetBalanceResponse", namespace = "http://hw5/")

public class GetBalanceResponse {

    @XmlElement(name = "return")
    private int _return;

    public int getReturn() {
        return this._return;
    }

    public void setReturn(int new_return)  {
        this._return = new_return;
    }

}

