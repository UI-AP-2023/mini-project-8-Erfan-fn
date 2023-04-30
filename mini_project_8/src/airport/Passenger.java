package airport;

import exceptions.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passenger {
    private String name;
    private String phoneNumber;
    private String email;
    private double balance;
    private ArrayList<Flight> flights;

    public Passenger(String name, String phoneNumber, String email, double balance) throws InvalidEmail, InvalidPhoneNumber, InvalidBalance {
        flights=new ArrayList<>();
        this.name=name;
        checkInitialBalance(balance);
        checkPhone(phoneNumber);
        checkEmail(email);
    }

    private void checkEmail(String email) throws InvalidEmail {
        Pattern pattern = Pattern.compile("^\\D{5}(\\d{3})+(@gmail|@yahoo)\\.com$");
        Matcher matcher = pattern.matcher(email);
        if (matcher.find()==false)
        {
            throw new InvalidEmail();
        }
         if (matcher.find()==true)
        {
            setEmail(email);
        }
    }

    private void checkPhone(String phone) throws InvalidPhoneNumber {
        Pattern pattern1 = Pattern.compile("^98\\d{10}$");
        Matcher matcher1 = pattern1.matcher(phone);
        if (matcher1.find()==false)
        {
            throw new InvalidPhoneNumber();
        }
         if (matcher1.find()==true)
        {
            setPhoneNumber(phone);
        }
    }

    private void checkInitialBalance(double balance) throws InvalidBalance {
        if (balance<0)
        {
            throw new InvalidBalance();
        }
        else
        {
            setBalance(balance);
        }
    }

    public void reserveFlight(Flight flight) throws InsufficientBalance, TimeInterference, DestinationOriginInterference {
        if (flight.getCost()>this.balance)
        {
            throw new InsufficientBalance();
        }
        if(this.flights!=null && this.flights.size()>0) {
            if (this.flights.get(this.flights.size() - 1).getDate().isEqual(flight.getDate())) {
                if (flight.getTime().isBefore(flights.get(flights.size()-1).getTime().plusMinutes(flights.get(flights.size()-1).getDuration()).plusHours(2))) {
                    throw new TimeInterference();
                }
            }
            if (this.flights.get(this.flights.size() - 1).getDestination() != flight.getOrigin()) {
                throw new DestinationOriginInterference();
            }
                if (flight.getPassengers().size() + 1 > flight.getCapacity()) {
                    throw new IndexOutOfBoundsException("flight capacity is full");
                }

        }
            this.balance-= flight.getCost();
            this.flights.add(flight);
            flight.getPassengers().add(this);

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String showPassengerFlights()
    {
        StringBuilder stringBuilder=new StringBuilder();
     for (Flight flight:flights)
     {
         stringBuilder.append(flight.toString()+"__");
     }
     return stringBuilder.toString();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }
}
