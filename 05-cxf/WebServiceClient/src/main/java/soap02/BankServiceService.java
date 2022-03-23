package soap02;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.5.1
 * 2022-03-23T14:26:14.859+01:00
 * Generated source version: 3.5.1
 *
 */
@WebServiceClient(name = "BankServiceService",
                  wsdlLocation = "	http://127.0.0.1:8000/BankService?wsdl",
                  targetNamespace = "http://soap02/")
public class BankServiceService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://soap02/", "BankServiceService");
    public final static QName BankServicePort = new QName("http://soap02/", "BankServicePort");
    static {
        URL url = null;
        try {
            url = new URL("	http://127.0.0.1:8000/BankService?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(BankServiceService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "	http://127.0.0.1:8000/BankService?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public BankServiceService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public BankServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public BankServiceService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public BankServiceService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public BankServiceService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public BankServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns IBankService
     */
    @WebEndpoint(name = "BankServicePort")
    public IBankService getBankServicePort() {
        return super.getPort(BankServicePort, IBankService.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IBankService
     */
    @WebEndpoint(name = "BankServicePort")
    public IBankService getBankServicePort(WebServiceFeature... features) {
        return super.getPort(BankServicePort, IBankService.class, features);
    }

}
