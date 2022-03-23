package soap02;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.5.1
 * 2022-03-23T14:26:14.855+01:00
 * Generated source version: 3.5.1
 *
 */
@WebService(targetNamespace = "http://soap02/", name = "IBankService")
@XmlSeeAlso({ObjectFactory.class})
public interface IBankService {

    @WebMethod(operationName = "ValidatePayment")
    @Action(input = "http://soap02/IBankService/ValidatePaymentRequest", output = "http://soap02/IBankService/ValidatePaymentResponse")
    @RequestWrapper(localName = "ValidatePayment", targetNamespace = "http://soap02/", className = "soap02.ValidatePayment")
    @ResponseWrapper(localName = "ValidatePaymentResponse", targetNamespace = "http://soap02/", className = "soap02.ValidatePaymentResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean validatePayment(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        java.lang.Integer arg3
    );

    @WebMethod(operationName = "GetBalance")
    @Action(input = "http://soap02/IBankService/GetBalanceRequest", output = "http://soap02/IBankService/GetBalanceResponse")
    @RequestWrapper(localName = "GetBalance", targetNamespace = "http://soap02/", className = "soap02.GetBalance")
    @ResponseWrapper(localName = "GetBalanceResponse", targetNamespace = "http://soap02/", className = "soap02.GetBalanceResponse")
    @WebResult(name = "return", targetNamespace = "")
    public int getBalance(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2
    );
}
