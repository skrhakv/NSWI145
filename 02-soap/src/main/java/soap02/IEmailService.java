package soap02;

@javax.jws.WebService
public interface IEmailService {
    @javax.jws.WebMethod
    public boolean SendEmail(String recipient, String sender, String subject, String bookingDetails);
    @javax.jws.WebMethod
    public boolean RegisterToNewsLetter(String recipient);
    @javax.jws.WebMethod
    public int SendNewsLetter(String sender, String subject, String bookingDetails);
}



