package exceptions;
public class InsufficientBalance extends FlightReserveUnsuccessful{
    public InsufficientBalance(String message) {
        super(message);
    }

    public InsufficientBalance() {
    super("Insufficient balance!!");
    }
}
