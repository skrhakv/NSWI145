package hw5;

import javax.jws.WebService;
import java.util.Map;
import java.util.HashMap;

@WebService(targetNamespace = "http://hw5/", endpointInterface = "hw5.Runner", portName = "BankPort", serviceName = "BankService")
public class Bank implements IBank, Runner {
    
	private Map<String, Integer> cardDetails = new HashMap<String, Integer>();
	
	public Bank() {
		// bank can support any number of cards
		// for now it supports only:
		// Card Number = 12345667890
		// Expiration date = 02/22
		// Validation Code = 143
		// Balance = 1000
	
		// register card
		cardDetails.put("123456789002/22143", 1000);
	}
	public boolean ValidatePayment(String number, String date, String validationCode, Integer price)
    {
		// It's just a simple implementation, if you are looking for something more complex,
		// then please let me know and I can provide another solution
		
		String combined = number + date + validationCode;
		
		System.out.println(combined);
		// check if card is registered
    	if(cardDetails.containsKey(combined))
    	{
    		Integer balance = cardDetails.get(combined);
    		
    		// check if there is enough money
    		if(balance >= price)
    		{
    			cardDetails.put(combined, balance - price);
    			return true;
    		}
    	}
    	return false;
    }
	public int GetBalance(String number, String date, String validationCode)
    {
		String combined = number + date + validationCode;
		
		System.out.println(combined);

		// check if card is registered
    	if(cardDetails.containsKey(combined))
    	{
    		System.out.println(cardDetails.get(combined));
    		return cardDetails.get(combined);
    	}
    	return -1;
    }
}

