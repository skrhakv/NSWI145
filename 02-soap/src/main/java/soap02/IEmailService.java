package soap02;

@javax.jws.WebService
public interface IEmailService {
    @javax.jws.WebMethod
    public boolean SendEmail(String recipient, String sender, String subject, String bookingDetails);
}



