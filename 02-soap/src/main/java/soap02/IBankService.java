package soap02;

@javax.jws.WebService
public interface IBankService {
    @javax.jws.WebMethod
    public boolean ValidatePayment(String number, String date, String validationCode, Integer balance);
}


