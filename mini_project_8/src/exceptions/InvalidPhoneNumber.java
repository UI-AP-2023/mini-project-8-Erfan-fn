package exceptions;

public class InvalidPhoneNumber extends InvalidInformation {
    public InvalidPhoneNumber() {
        super("Invalid PhoneNumber!!");
    }
    public InvalidPhoneNumber(String message) {
        super(message);
    }
}
