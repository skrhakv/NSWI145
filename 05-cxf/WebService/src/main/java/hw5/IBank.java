package hw5;

public interface IBank {
    public boolean ValidatePayment(String number, String date, String validationCode, Integer balance);
	public int GetBalance(String number, String date, String validationCode);
}


