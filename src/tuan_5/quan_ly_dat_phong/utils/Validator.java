package tuan_5.quan_ly_dat_phong.utils;

import tuan_5.quan_ly_dat_phong.model.FlightInformation;
import tuan_5.quan_ly_dat_phong.model.Reservation;
import tuan_5.quan_ly_dat_phong.model.ReservationManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validator {

    static Scanner sc = new Scanner(System.in);

    public static String checkId(String msg) {
        System.out.print(msg);
        while (true) {
            try {
                String id = sc.nextLine().trim();
                if (id.length() != 6) {
                    System.out.println("Data input is invalid");
                    System.out.print("ID: ");
                    continue;
                }
                Integer.parseInt(id);
                return id;
            } catch (NumberFormatException e) {
                System.out.println("Data input is invalid");
                System.out.print("ID: ");
            }
        }
    }

    public static String checkCustomerName(String msg) {
        System.out.print(msg);
        while (true) {
            String name = sc.nextLine().trim();
            if (name.matches("[a-zA-Z ]+")) {
                return name;
            } else {
                System.out.println("Data input is invalid");
                System.out.print("Name: ");
            }
        }
    }

    public static String checkPhoneNumber(String msg) {
        System.out.print(msg);
        while (true) {
            String phone = sc.nextLine().trim();
            if (phone.matches("\\d{12}")) {
                return phone;
            } else {
                System.out.println("Data input is invalid");
                System.out.print("Phone: ");
            }
        }
    }

    public static String checkRoomNumber(String msg) {
        System.out.print(msg);
        while (true) {
            String room = sc.nextLine().trim();
            if (room.matches("\\d{4}")) {
                return room;
            } else {
                System.out.println("Data input is invalid");
                System.out.print("RoomNumber: ");
            }
        }
    }

    public static LocalDate checkBookingDate(String msg) {
        System.out.print(msg);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                String input = sc.nextLine().trim();
                LocalDate bookingDate = LocalDate.parse(input, formatter);
                if (bookingDate.isAfter(LocalDate.now())) {
                    return bookingDate;
                } else {
                    System.out.println("Data input is invalid");
                    System.out.print("BookingDate: ");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Data input is invalid");
                System.out.print("BookingDate: ");
            }
        }
    }

    public static LocalDate checkTimePickUp(String msg, LocalDate bookingDate) {
        System.out.print(msg);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                String input = sc.nextLine().trim();
                LocalDate pickUp = LocalDate.parse(input, formatter);
                LocalDate today = LocalDate.now();

                if (pickUp.isAfter(today) && pickUp.isBefore(bookingDate)) {
                    return pickUp;
                } else {
                    System.out.println("Data input is invalid");
                    System.out.print("TimePickUp: ");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Data input is invalid");
                System.out.print("TimePickUp: ");
            }
        }
    }

    public static String checkFlightNumber(String msg){
        System.out.print(msg);
        while(true){
            String flightNumber = sc.nextLine().trim();
            if(flightNumber.isEmpty()){
                System.out.println("Data input is invalid");
                System.out.print("Flight: ");
                continue;
            }
            if(!flightNumber.matches("[A-Z0-9]+")){
                System.out.println("Data input is invalid");
                System.out.print("Flight: ");
                continue;
            }
            return flightNumber;
        }
    }

    public static String checkSeatNumber(String msg){
        System.out.print(msg);
        while(true){
            String seatNumber = sc.nextLine().trim();
            if(seatNumber.isEmpty()){
                System.out.println("Data input is invalid");
                System.out.print("Seat: ");
                continue;
            }
            if(!seatNumber.matches("[A-Z]\\d{1,3}")){
                System.out.println("Data input is invalid");
                System.out.print("Seat: ");
                continue;
            }
            return seatNumber;
        }
    }

    public static boolean confirmYesNo(String msg){
        System.out.print(msg);
        while(true){
            String input = sc.nextLine().trim().toUpperCase();
            if(input.equals("Y")){
                return true;
            } else if(input.equals("N")){
                return false;
            } else {
                System.out.println("Data input is invalid");
                System.out.print(msg);
            }
        }
    }

    public static Reservation enterRe(String msg, ReservationManager manager){
        if(!msg.isEmpty()) System.out.println(msg);

        String id = checkId("ID: ");
        String cusName = checkCustomerName("Name: ");
        String phoneNumber = checkPhoneNumber("Phone: ");
        String roomNumber = checkRoomNumber("RoomNumber: ");
        LocalDate bookingDate = checkBookingDate("BookingDate: ");

        boolean needPickup = confirmYesNo("Need airport pick up? (Y/N): ");
        FlightInformation flightInfo = null;

        if(needPickup){
            String flightNumber = checkFlightNumber("Flight: ");
            String seatNumber = checkSeatNumber("Seat: ");
            LocalDate timePickUp = checkTimePickUp("TimePickUp: ", bookingDate);
            flightInfo = new FlightInformation(flightNumber, seatNumber, timePickUp);
        } else {
            flightInfo = new FlightInformation();
        }

        return new Reservation(id, cusName, phoneNumber, roomNumber, bookingDate, flightInfo);
    }

    public static Reservation updateRe(Reservation oldRes, ReservationManager manager){
        System.out.println("Current information: " + oldRes);
        System.out.println("(Press Enter to keep current value)");

        System.out.print("Name [" + oldRes.getCustomerName() + "]: ");
        String newName = sc.nextLine().trim();
        if(!newName.isEmpty()){
            while(!newName.matches("[a-zA-Z ]+")){
                System.out.println("Data input is invalid");
                System.out.print("Name: ");
                newName = sc.nextLine().trim();
                if(newName.isEmpty()) break;
            }
        }
        String cusName = newName.isEmpty() ? oldRes.getCustomerName() : newName;

        System.out.print("Phone [" + oldRes.getPhoneNumber() + "]: ");
        String newPhone = sc.nextLine().trim();
        if(!newPhone.isEmpty()){
            while(!newPhone.matches("\\d{12}")){
                System.out.println("Data input is invalid");
                System.out.print("Phone: ");
                newPhone = sc.nextLine().trim();
                if(newPhone.isEmpty()) break;
            }
        }
        String phoneNumber = newPhone.isEmpty() ? oldRes.getPhoneNumber() : newPhone;

        System.out.print("RoomNumber [" + oldRes.getRoomNumber() + "]: ");
        String newRoom = sc.nextLine().trim();
        if(!newRoom.isEmpty()){
            while(!newRoom.matches("\\d{4}")){
                System.out.println("Data input is invalid");
                System.out.print("RoomNumber: ");
                newRoom = sc.nextLine().trim();
                if(newRoom.isEmpty()) break;
            }
        }
        String roomNumber = newRoom.isEmpty() ? oldRes.getRoomNumber() : newRoom;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("BookingDate [" + oldRes.getBookingDate().format(formatter) + "]: ");
        String newBookingStr = sc.nextLine().trim();
        LocalDate bookingDate = oldRes.getBookingDate();
        if(!newBookingStr.isEmpty()){
            while(true){
                try{
                    LocalDate newDate = LocalDate.parse(newBookingStr, formatter);
                    if(newDate.isAfter(LocalDate.now())){
                        bookingDate = newDate;
                        break;
                    } else {
                        System.out.println("Data input is invalid");
                        System.out.print("BookingDate: ");
                        newBookingStr = sc.nextLine().trim();
                        if(newBookingStr.isEmpty()) break;
                    }
                } catch(DateTimeParseException e){
                    System.out.println("Data input is invalid");
                    System.out.print("BookingDate: ");
                    newBookingStr = sc.nextLine().trim();
                    if(newBookingStr.isEmpty()) break;
                }
            }
        }

        FlightInformation flightInfo = oldRes.getFlightInformation();
        boolean hasOldFlight = (flightInfo != null && !flightInfo.getFlightNumber().isEmpty());

        System.out.print("Need airport pick up? (Y/N) [" + (hasOldFlight ? "Y" : "N") + "]: ");
        String needPickupStr = sc.nextLine().trim().toUpperCase();

        if(needPickupStr.isEmpty()){
            needPickupStr = hasOldFlight ? "Y" : "N";
        }

        if(needPickupStr.equals("Y")){
            String oldFlight = hasOldFlight ? flightInfo.getFlightNumber() : "";
            System.out.print("Flight [" + oldFlight + "]: ");
            String newFlight = sc.nextLine().trim();
            if(newFlight.isEmpty()) newFlight = oldFlight;

            String oldSeat = hasOldFlight ? flightInfo.getSeatNumber() : "";
            System.out.print("Seat [" + oldSeat + "]: ");
            String newSeat = sc.nextLine().trim();
            if(newSeat.isEmpty()) newSeat = oldSeat;

            String oldTime = hasOldFlight ? flightInfo.getTimePickUp().format(formatter) : "";
            System.out.print("TimePickUp [" + oldTime + "]: ");
            String newTimeStr = sc.nextLine().trim();
            LocalDate newTime = hasOldFlight ? flightInfo.getTimePickUp() : LocalDate.now().plusDays(1);

            if(!newTimeStr.isEmpty()){
                try{
                    newTime = LocalDate.parse(newTimeStr, formatter);
                } catch(DateTimeParseException e){
                    System.out.println("Invalid date format, keeping old value");
                }
            }

            flightInfo = new FlightInformation(newFlight, newSeat, newTime);
        } else {
            flightInfo = new FlightInformation();
        }

        return new Reservation(oldRes.getBookingID(), cusName, phoneNumber,
                roomNumber, bookingDate, flightInfo);
    }
}
