package exceptions;

public class InvalidEmail extends InvalidInformation {
    public InvalidEmail() {
    super("Invalid Email!!");
    }

    public InvalidEmail(String message) {
        super(message);
    }
}
