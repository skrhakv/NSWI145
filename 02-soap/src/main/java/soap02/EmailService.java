package soap02;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;
import javax.jws.WebService;

@WebService(endpointInterface = "soap02.IEmailService")
public class EmailService implements IEmailService {
	private List<String> registrations = new ArrayList<String>();
	
    public boolean SendEmail(String recipient, String sender, String subject, String bookingDetails)
    {	
    	// The method correctly sends email from sender to the recipient
    	
	    String to = recipient;
	    String from = sender;
	    String host = "localhost";
	
	    Properties properties = System.getProperties();
	
	    // Setup mail server
	    properties.setProperty("mail.smtp.host", host);
	    javax.mail.Session session = Session.getDefaultInstance(properties);
	
	    try {
	       MimeMessage message = new MimeMessage(session);
	
	       message.setFrom(new InternetAddress(from));
	       message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
	       message.setSubject(subject);
	       message.setText(bookingDetails);
	
	       Transport.send(message);
	       System.out.println("Sent message successfully....");
	         
	       return true;
	    } 
	    catch (MessagingException mex) {
	       mex.printStackTrace();
	       return false;
  	     }
   }
    
    public boolean RegisterToNewsLetter(String recipient)
    {
    	registrations.add(recipient);
    	return true;
    }
    
    public int SendNewsLetter(String sender, String subject, String bookingDetails)
    {
    	int counter = 0;
    	
    	for (int i = 0; i < registrations.size(); i++)
    	{
    		SendEmail(registrations.get(i), sender, subject, bookingDetails);
    		counter++;
    	}
    	
    	return counter;
	}
}

