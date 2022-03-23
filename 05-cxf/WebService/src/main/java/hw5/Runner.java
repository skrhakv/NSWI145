package hw5;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "Runner", targetNamespace = "http://hw5/")
public interface Runner {

	@WebMethod(operationName = "ValidatePayment", action = "urn:ValidatePayment")
	boolean ValidatePayment(String number, String date, String validationCode, Integer price);

	@WebMethod(operationName = "GetBalance", action = "urn:GetBalance")
	int GetBalance(String number, String date, String validationCode);

}