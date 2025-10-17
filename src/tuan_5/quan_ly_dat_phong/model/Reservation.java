package tuan_5.quan_ly_dat_phong.model;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class Reservation {
    private String bookingID;
    private String customerName;
    private String phoneNumber;
    private String roomNumber;
    private LocalDate bookingDate;
    private FlightInformation flightInformation;

    public Reservation(String bookingID, String customerName, String phoneNumber,
            String roomNumber, LocalDate bookingDate, FlightInformation flightInformation) {
        this.bookingID = bookingID;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.roomNumber = roomNumber;
        this.bookingDate = bookingDate;
        this.flightInformation = flightInformation;
    }

    public Reservation() {
        this.bookingID = "";
        this.customerName = "";
        this.phoneNumber = "";
        this.roomNumber = "";
        this.bookingDate = null;
        this.flightInformation = null;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public FlightInformation getFlightInformation() {
        return flightInformation;
    }

    public void setFlightInformation(FlightInformation flightInformation) {
        this.flightInformation = flightInformation;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String flightInfo = (flightInformation.getFlightNumber().isEmpty()) ? "" : flightInformation.toString();
        return bookingID + " - " + customerName + " - " + phoneNumber + " - " + roomNumber + " - " + sdf.format(bookingDate) + " - " + flightInfo;
    }
}