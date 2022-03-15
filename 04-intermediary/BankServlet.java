

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.Node;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;

/**
 * Servlet implementation class BankServlet
 */
@WebServlet("/BankServlet")
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Post request recieved ...");
		BillFeeToTheOperation(request, response);
	}
	private void BillFeeToTheOperation(HttpServletRequest r, HttpServletResponse resp) {
		try {
			SOAPConnection soapc = SOAPConnectionFactory.newInstance().createConnection();

			String endpoint = "http://127.0.0.1:8000/BankService";

			int additionalFee = 0;

			SOAPMessage message = MessageFactory.newInstance().createMessage(new MimeHeaders(), r.getInputStream());
			
			System.out.println("SOAP message exists");
			
			if(message.getSOAPHeader().hasChildNodes()) {
				Iterator<Node> it = message.getSOAPHeader().getChildElements();
				while(it.hasNext()) {
					Node n = it.next();
					if(n.getNodeName() == "tweak") {
						String val = n.getAttributes().getNamedItem("Fee").getNodeValue();
						System.out.println("Additional fee: " + val);
						additionalFee = Integer.parseInt(val);
					}
				}
				
			}
			SOAPMessage response = soapc.call(message, endpoint);
			System.out.println("We have response");
			soapc.close();
			
			SOAPBody responseBody = response.getSOAPBody();
			if (responseBody.hasFault()) {
			    System.out.println(responseBody.getFault().getFaultString()); 
			} else {
				QName getBalanceResponseName = new QName("http://soap02/", "GetBalanceResponse", "ns2");
				QName returnName = new QName("return");
				
				SOAPBodyElement GetBalanceResponse = (SOAPBodyElement)
				       responseBody.getChildElements(getBalanceResponseName).next();
				SOAPBodyElement returnResult = (SOAPBodyElement)
						GetBalanceResponse.getChildElements(returnName).next();
		
				int ret = Integer.parseInt(returnResult.getValue());
				System.out.println("Value: " + ret);
				
				if(response.getSOAPHeader() != null) {
					response.getSOAPHeader().addHeaderElement(new QName("http://tweaks.com/","tweaked")).addTextNode("Added fee:" + additionalFee);
				}
				else {
					SOAPHeader h = response.getSOAPPart().getEnvelope().addHeader();
					h.addHeaderElement(new QName("http://tweaks.com/","tweaked")).addTextNode("Added fee:" + additionalFee);
				}
				
				ret = Integer.parseInt(returnResult.getValue()) + additionalFee;
				returnResult.setValue("" + ret);
				
				response.writeTo(System.out);
				response.writeTo(resp.getOutputStream());
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
