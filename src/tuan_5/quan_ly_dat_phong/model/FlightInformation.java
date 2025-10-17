package tuan_5.quan_ly_dat_phong.model;

import java.time.LocalDate;

public class FlightInformation {
    private String flightNumber;
    private  String seatNumber;
    private LocalDate timePickUp;
    // con
    public FlightInformation(String flightNumber,String seatNumber,LocalDate timePickUp){
        this.flightNumber = flightNumber;
        this.seatNumber = seatNumber;
        this.timePickUp = timePickUp;
    }
    public FlightInformation(){
        this.flightNumber = "";
        this.seatNumber = "";
        this.timePickUp = null;
    }

    public LocalDate getTimePickUp() {
        return timePickUp;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setTimePickUp(LocalDate timePickUp) {
        this.timePickUp = timePickUp;
    }
}
