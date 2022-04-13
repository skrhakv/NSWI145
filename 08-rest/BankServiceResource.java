package hw8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.xml.bind.JAXBElement;
import lab08task02.Contact;

@Path("/bank")
public class BankServiceResource {
	private static Map<String, Integer> cardDetails = new HashMap<String, Integer>();

	public BankServiceResource() {
		if(!cardDetails.containsKey("12345678900222143"))
			cardDetails.put("12345678900222143", 1000);
	}

	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Map<String, Integer> getOverview() {
		System.out.println("Executing GET request ...");

	    return cardDetails;
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{cardDetail}/{newBalance}")
	    public Response putNewBalance(
	            @PathParam("cardDetail") String cardDetail, @PathParam("newBalance") String newBalance) {
		Response res;
		System.out.println("Executing PUT request ...");

		try{
	        int number = Integer.parseInt(newBalance);
	        
	        if(cardDetails.containsKey(cardDetail))
	        {
	        	cardDetails.put(cardDetail, number);
	        	res = Response.status(204).build();
	        }
	        else {
	        	res = Response.status(409).entity("No Balance to update").build();
	        }

	    }
	    catch (NumberFormatException ex){
	       res = Response.status(Response.Status.BAD_REQUEST).build();
	    }

		return res;
	}
	
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{cardDetail}/{balance}")
	    public Response postNewCard(
	            @PathParam("cardDetail") String cardDetail, @PathParam("balance") String newBalance) {
		Response res;
		System.out.println("Executing POST request ...");

		try{
	        int number = Integer.parseInt(newBalance);
	        
	        if(cardDetails.containsKey(cardDetail))
	        {
	        	res = Response.status(409).entity("Card Already exists").build();
	        }
	        else {

	        	cardDetails.put(cardDetail, number);
	        	res = Response.status(201).build();
	        }

	    }
	    catch (NumberFormatException ex){
	       res = Response.status(Response.Status.BAD_REQUEST).build();
	    }

		return res;
	}
	
	@DELETE
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Path("{cardDetail}")
	    public Response deleteCard(
	            @PathParam("cardDetail") String cardDetail) {
		Response res;
		System.out.println("Executing DELETE request ...");
        
        if(cardDetails.containsKey(cardDetail))
        {
        	cardDetails.remove(cardDetail);
        	res = Response.status(202).build();
        }
        else {
        	res = Response.status(409).entity("No card ").build();
        }

		return res;
	}
	
	/* curl -X PUT -d "<contact>
<email>asddasd</email>
<fullName>asdasd</fullName>
<ID>1</ID>
</contact>" -H "Content-Type:application/xml" http://localhost:8080/lab08/rest/contacts/1 -i
*/
}

