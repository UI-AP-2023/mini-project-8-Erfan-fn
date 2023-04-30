package exceptions;

public class InvalidBalance extends InvalidInformation{
    public InvalidBalance() {
        super("Invalid Balance!!");
    }
    public InvalidBalance(String message) {
        super(message);
    }
}
