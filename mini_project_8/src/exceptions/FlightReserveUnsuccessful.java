package exceptions;

public abstract class FlightReserveUnsuccessful extends Exception{
    public FlightReserveUnsuccessful(String message)
    {
        super("Flight reserve was unsuccessful!!__"+message);
    }
}
