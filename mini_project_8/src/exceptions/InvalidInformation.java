package exceptions;

public abstract class InvalidInformation extends Exception {
public InvalidInformation(String message)
{
    super("Invalid Information!!__"+message);
}

}
