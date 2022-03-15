package lab04;

import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

public class BankClient {

	public static void main(String[] args) {
		try {
			SOAPConnectionFactory factory = SOAPConnectionFactory.newInstance();
			SOAPConnection connection = factory.createConnection();

			MessageFactory messageFactory = MessageFactory.newInstance();
			SOAPMessage soapm = messageFactory.createMessage();
			    
			SOAPPart soapp = soapm.getSOAPPart();
			SOAPEnvelope soape = soapp.getEnvelope();
			SOAPBody soapb = soape.getBody();

			soape.getHeader().detachNode();
			QName name = new QName("http://soap02/", "GetBalance", "tns");
			SOAPElement soapel = soapb.addBodyElement(name);

			soapel.addChildElement(
			    new QName("arg0")).addTextNode("1234567890");
			soapel.addChildElement(
			    new QName("arg1")).addTextNode("02/22");
			soapel.addChildElement(
				    new QName("arg2")).addTextNode("143");
			String endpoint = "http://127.0.0.1:8000/BankService";
			SOAPMessage response = connection.call(soapm, endpoint);
			connection.close();
			SOAPBody responseBody = response.getSOAPBody();
			if (responseBody.hasFault()) {
			    System.out.println(responseBody.getFault().getFaultString()); 
			} else {
			QName totalAmountResponseName = new QName("http://soap02/", "GetBalanceResponse", "ns2");
			QName totalAmountResultName = new QName("return");
			SOAPBodyElement AddResponse = (SOAPBodyElement)
			       responseBody.getChildElements(totalAmountResponseName).next();

			SOAPBodyElement AddResult = (SOAPBodyElement)
			       AddResponse.getChildElements(totalAmountResultName).next();

			System.out.println(AddResult.getValue());
			}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	  }
	
	
}
