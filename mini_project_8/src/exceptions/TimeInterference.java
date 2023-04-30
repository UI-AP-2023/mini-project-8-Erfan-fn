package exceptions;

public class TimeInterference extends FlightReserveUnsuccessful{
    public TimeInterference(String message) {
        super(message);
    }

    public TimeInterference() {
        super("Time Interference error!!");
    }
}
