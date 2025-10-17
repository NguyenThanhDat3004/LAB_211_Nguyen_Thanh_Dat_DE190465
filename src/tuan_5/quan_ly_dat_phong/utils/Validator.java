package tuan_5.quan_ly_dat_phong.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    // Check Time Pick Up: must be after now and before booking date
    public static LocalDateTime checkTimePickUp(String msg, LocalDate bookingDate) {
        System.out.println(msg);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        while (true) {
            try {
                String input = sc.nextLine().trim();
                LocalDateTime pickUp = LocalDateTime.parse(input, formatter);

                LocalDateTime bookingDateTime = bookingDate.atStartOfDay();

                if (pickUp.isAfter(LocalDateTime.now()) && pickUp.isBefore(bookingDateTime)) {
                    return pickUp;
                } else {
                    System.out.println("Pick up time must be after now and before booking date. Re-enter:");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Invalid format. Use dd/MM/yyyy HH:mm");
            }
        }
    }
}
