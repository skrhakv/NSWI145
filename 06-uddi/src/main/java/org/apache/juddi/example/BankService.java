/*
 * Copyright 2001-2010 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package org.apache.juddi.example;

import javax.jws.WebResult;
import java.util.HashMap;
import java.util.Map;

import javax.jws.WebService;

import org.apache.juddi.v3.annotations.UDDIService;
import org.apache.juddi.v3.annotations.UDDIServiceBinding;

import soap02.IBankService;

/**
 * This example show you how to use UDDI Annotations to decorate a class.
 * When the Servlet Listener
 * 
 */

@UDDIService(
		businessKey="uddi:skrhak.cz:bankservice",
		serviceKey="uddi:${keyDomain}:services-bankservice${department}", 
		description = "Bank service")
@UDDIServiceBinding(
		bindingKey="uddi:${keyDomain}:${serverName}-${serverPort}-bankservice${department}-wsdl",
	    description="WSDL endpoint for the Bank Service.",
	    accessPointType="wsdlDeployment",
	    accessPoint="http://${serverName}:${serverPort}/uddi-annotations/services/bankservice?wsdl")
@WebService(
		endpointInterface = "org.apache.juddi.example.IBankService",
        serviceName = "BankService")

public class BankService implements IBankService {
    
	private Map<String, Integer> cardDetails = new HashMap<String, Integer>();
	
	public BankService() {
		// bank can support any number of cards
		// for now it supports only:
		// Card Number = 12345667890
		// Expiration date = 02/22
		// Validation Code = 143
		// Balance = 1000
	
		// register card
		cardDetails.put("123456789002/22143", 1000);
	}
	@WebResult(name="ValidatePaymentSuccess")
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
	@WebResult(name="GetBalanceSuccess")
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
