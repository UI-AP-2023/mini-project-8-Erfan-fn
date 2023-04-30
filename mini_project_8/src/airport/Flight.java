package airport;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Flight {
    private LocalDate date;
    private LocalTime time;
    private ArrayList<Passenger> passengers;
    private String origin;
    private String destination;
    private double distance;
    private int duration;
    private int speed;
    private double cost;
    private int capacity;

    public Flight(LocalDate date, LocalTime time, String origin, String destination,
                  double distance, int duration, double cost, int capacity)throws ArithmeticException {
        this.passengers=new ArrayList<>();
        this.duration=duration;
        this.distance=distance;
        this.cost=cost;
        this.date=date;
        this.time=time;
        this.origin=origin;
        this.destination=destination;
        this.capacity=capacity;
        this.speed=  ((int)(distance))*60/duration;
        //Exceptions?!!
        //........
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getTime() {
        return time;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getDistance() {
        return distance;
    }

    public long getDuration() {
        return duration;
    }

    public double getSpeed() {
        return speed;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "date=" + date +
                ", time=" + time +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", distance=" + distance +
                ", duration=" + duration +
                ", cost=" + cost +
                ", capacity=" + capacity +
                '}';
    }
}
