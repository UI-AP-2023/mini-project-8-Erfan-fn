package exceptions;

public class DestinationOriginInterference extends FlightReserveUnsuccessful{
    public DestinationOriginInterference(String message) {
        super(message);
    }

    public DestinationOriginInterference() {
        super("Destination and Origin Interference!!");
    }
}
