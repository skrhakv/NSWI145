
package soap02;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap02 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetBalance_QNAME = new QName("http://soap02/", "GetBalance");
    private final static QName _GetBalanceResponse_QNAME = new QName("http://soap02/", "GetBalanceResponse");
    private final static QName _ValidatePayment_QNAME = new QName("http://soap02/", "ValidatePayment");
    private final static QName _ValidatePaymentResponse_QNAME = new QName("http://soap02/", "ValidatePaymentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap02
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBalance }
     * 
     */
    public GetBalance createGetBalance() {
        return new GetBalance();
    }

    /**
     * Create an instance of {@link GetBalanceResponse }
     * 
     */
    public GetBalanceResponse createGetBalanceResponse() {
        return new GetBalanceResponse();
    }

    /**
     * Create an instance of {@link ValidatePayment }
     * 
     */
    public ValidatePayment createValidatePayment() {
        return new ValidatePayment();
    }

    /**
     * Create an instance of {@link ValidatePaymentResponse }
     * 
     */
    public ValidatePaymentResponse createValidatePaymentResponse() {
        return new ValidatePaymentResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBalance }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBalance }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap02/", name = "GetBalance")
    public JAXBElement<GetBalance> createGetBalance(GetBalance value) {
        return new JAXBElement<GetBalance>(_GetBalance_QNAME, GetBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBalanceResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetBalanceResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap02/", name = "GetBalanceResponse")
    public JAXBElement<GetBalanceResponse> createGetBalanceResponse(GetBalanceResponse value) {
        return new JAXBElement<GetBalanceResponse>(_GetBalanceResponse_QNAME, GetBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidatePayment }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValidatePayment }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap02/", name = "ValidatePayment")
    public JAXBElement<ValidatePayment> createValidatePayment(ValidatePayment value) {
        return new JAXBElement<ValidatePayment>(_ValidatePayment_QNAME, ValidatePayment.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ValidatePaymentResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ValidatePaymentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://soap02/", name = "ValidatePaymentResponse")
    public JAXBElement<ValidatePaymentResponse> createValidatePaymentResponse(ValidatePaymentResponse value) {
        return new JAXBElement<ValidatePaymentResponse>(_ValidatePaymentResponse_QNAME, ValidatePaymentResponse.class, null, value);
    }

}
