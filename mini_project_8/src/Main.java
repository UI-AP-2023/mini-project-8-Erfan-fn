import airport.Flight;
import airport.Passenger;
import exceptions.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse("13/02/2022", formatter);
        Flight f1 = null;
        Flight f2 = null;
        Flight f3 = null;
        Flight f22 = null;
        try {
             f2 = new Flight(date, LocalTime.parse("21:00"), "isfahan", "mashhad",
                    900d, 110, 1570.5, 50);
            f22 = new Flight(date, LocalTime.parse("21:54"), "tehran", "ahwaz",
                    900d, 110, 1570.5, 50);
             f1 = new Flight(date, LocalTime.parse("19:00"), "isfahan", "tehran",
                    320.5, 55, 780.3, 2);
             f3 = new Flight(date, LocalTime.parse("23:00"), "isfahan", "tehran",
                    320.5, 55, 780.3, 87);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        boolean finish = false;
        Passenger p1 = null;
        Passenger p2 = null;
        Passenger p3 = null;
        Passenger p4 = null;
        do {
            try {
                System.out.println("enter your name");
                String name1 = sc.next();
                System.out.println("enter your name");
                String name2 = sc.next();
                System.out.println("enter your phone");
                String phone1 = sc.next();
                System.out.println("enter your phone");
                String phone2 = sc.next();
                System.out.println("enter your email");
                String email1 = sc.next();
                System.out.println("enter your email");
                String email2 = sc.next();
                System.out.println("enter your balance");
                double balance1 = sc.nextDouble();
                System.out.println("enter your balance");
                double balance2 = sc.nextDouble();

                  p1 = new Passenger(name1, phone1, email1, balance1);
                  p2 = new Passenger(name2, phone2, email2, balance2);
//                p3 = new Passenger("ali", "9301112233", "abc@gmail.com", 2000.5);
//                p4 = new Passenger("zahra", "989301112233", "abcgl.com", 3000d);

                finish = true;
            } catch (InvalidInformation | InputMismatchException ex) {
                if (ex instanceof InvalidInformation) {
                    if (ex instanceof InvalidEmail) {
                        System.out.println(((InvalidEmail) ex).getMessage());
                    }
                    if (ex instanceof InvalidPhoneNumber) {
                        System.out.println(((InvalidPhoneNumber) ex).getMessage());
                    }
                    if (ex instanceof InvalidBalance) {
                        System.out.println(((InvalidBalance) ex).getMessage());
                    }
                } else {
                    System.out.println(ex.getMessage());
                }
                finish = false;
            }
        }
        while (!finish);

        try {
            p1.reserveFlight(f1);
            p1.reserveFlight(f22);
            p2.reserveFlight(f3);
            p2.reserveFlight(f2);
        }
        catch ( FlightReserveUnsuccessful | IndexOutOfBoundsException ex) {


            if (ex instanceof FlightReserveUnsuccessful) {
                if (ex instanceof InsufficientBalance) {
                    System.out.println(((InsufficientBalance) ex).getMessage());
                }
                if (ex instanceof TimeInterference) {
                    System.out.println(((TimeInterference) ex).getMessage());
                }
                if (ex instanceof DestinationOriginInterference) {
                    System.out.println(((DestinationOriginInterference) ex).getMessage());
                }
            }
            else
            {
                System.out.println(ex.getMessage());
            }
        }
        finally {
            System.out.println("passenger balance:"+p1.getBalance()+p1.showPassengerFlights());
            System.out.println("passenger balance:"+p2.getBalance()+p2.showPassengerFlights());
        }


        //System.out.println(p1.showPassengerFlights());
    }
}
