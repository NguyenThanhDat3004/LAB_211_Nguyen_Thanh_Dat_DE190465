package tuan_5.quan_ly_dat_phong.utils;

import tuan_5.quan_ly_dat_phong.model.FlightInformation;
import tuan_5.quan_ly_dat_phong.model.Reservation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validator {

    static Scanner sc = new Scanner(System.in);
    // Check ID: 6 digits
    public static String checkId(String msg) {
        System.out.println(msg);
        while (true) {
            try {
                String id = sc.nextLine().trim();
                if (id.length() != 6) {
                    System.out.println("Re-enter ID with 6 digits");
                    continue;
                }
                Integer.parseInt(id);
                return id;
            } catch (NumberFormatException e) {
                System.out.println("Re-enter ID with 6 digits");
            }
        }
    }

    // Check Customer Name: only letters and spaces
    public static String checkCustomerName(String msg) {
        System.out.println(msg);
        while (true) {
            String name = sc.nextLine().trim();
            if (name.matches("[a-zA-Z ]+")) {
                return name;
            } else {
                System.out.println("Re-enter name (letters and spaces only)");
            }
        }
    }

    // Check Phone Number: 12 digits
    public static String checkPhoneNumber(String msg) {
        System.out.println(msg);
        while (true) {
            String phone = sc.nextLine().trim();
            if (phone.matches("\\d{12}")) {
                return phone;
            } else {
                System.out.println("Re-enter phone number (12 digits required)");
            }
        }
    }

    // Check Room Number: 4 digits
    public static String checkRoomNumber(String msg) {
        System.out.println(msg);
        while (true) {
            String room = sc.nextLine().trim();
            if (room.matches("\\d{4}")) {
                return room;
            } else {
                System.out.println("Re-enter room number (4 digits required)");
            }
        }
    }

    // Check Booking Date: must be after today
    public static LocalDate checkBookingDate(String msg) {
        System.out.println(msg);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                String input = sc.nextLine().trim();
                LocalDate bookingDate = LocalDate.parse(input, formatter);
                if (bookingDate.isAfter(LocalDate.now())) {
                    return bookingDate;
                } else {
                    System.out.println("Booking date must be after today. Re-enter:");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Use dd/MM/yyyy");
            }
        }
    }
    public static LocalDate checkTimePickUp(String msg, LocalDate bookingDate) {
        System.out.println(msg + " (dd/MM/yyyy)");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                String input = sc.nextLine().trim();
                LocalDate pickUp = LocalDate.parse(input, formatter);

                LocalDate today = LocalDate.now();

                if (pickUp.isAfter(today) && pickUp.isBefore(bookingDate)) {
                    return pickUp;
                } else {
                    System.out.println(" Pick up date must be after today and before booking date. Re-enter:");
                }
            } catch (DateTimeParseException e) {
                System.out.println(" Invalid format. Use dd/MM/yyyy. Re-enter:");
            }
        }
    }
    public static String checkFlightNumber(String msg){
        System.out.println(msg);
        while(true){
            String flightNumber = sc.nextLine().trim();
            if(flightNumber.isEmpty()){
                System.out.println(" Flight number cannot be empty. Re-enter:");
                continue;
            }
            if(!flightNumber.matches("[A-Z0-9]+")){
                System.out.println(" Flight number must contain only uppercase letters and digits. Re-enter:");
                continue;
            }
            return flightNumber;
        }
    }
    public static String checkSeatNumber(String msg){
        System.out.println(msg);
        while(true){
            String seatNumber = sc.nextLine().trim();
            if(seatNumber.isEmpty()){
                System.out.println("Seat number cannot be empty. Re-enter:");
                continue;
            }
            if(!seatNumber.matches("[A-Z]\\d{1,2}")){
                System.out.println("Seat number must be in format like 'A12' or 'B3'. Re-enter:");
                continue;
            }
            return seatNumber;
        }
    }

    public static Reservation enterRe(String msg){
        System.out.println(msg);
        String id = checkId("Enter id: ");
        String cusName = checkCustomerName("Enter customer name: ");
        String phoneNumber = checkPhoneNumber("Enter phone number: ");
        String roomNumber = checkRoomNumber("Enter room number: ");
        LocalDate bookingDate = checkBookingDate("Enter booking date: ");
        String flightNumber = checkFlightNumber("Enter flight number: ");
        String seatNumber = checkSeatNumber("Enter seat number: ");
        LocalDate s = checkTimePickUp("Enter time: ", bookingDate);
        FlightInformation t = new FlightInformation(flightNumber,seatNumber,s);
        return new Reservation(id,cusName,phoneNumber,roomNumber,bookingDate,t);
    }
}
