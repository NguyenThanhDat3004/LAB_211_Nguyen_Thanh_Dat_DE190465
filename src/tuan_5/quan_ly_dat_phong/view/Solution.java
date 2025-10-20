package tuan_5.quan_ly_dat_phong.view;

import tuan_5.quan_ly_dat_phong.model.Reservation;
import tuan_5.quan_ly_dat_phong.model.ReservationManager;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Solution {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public void displayListFly(ReservationManager r){
        List<Reservation> flyList = r.getListFly();

        if(flyList.isEmpty()){
            System.out.println("No information to view");
            return;
        }

        System.out.println("\n--- Flight Pick-up Schedule ---");
        System.out.printf("%-8s %-20s %-15s %-10s %-12s %-10s %-8s %-12s%n",
                "ID", "Customer", "Phone", "Room", "BookingDate", "Flight", "Seat", "PickUpTime");
        System.out.println("=".repeat(110));

        for(Reservation res : flyList){
            System.out.printf("%-8s %-20s %-15s %-10s %-12s %-10s %-8s %-12s%n",
                    res.getBookingID(),
                    res.getCustomerName(),
                    res.getPhoneNumber(),
                    res.getRoomNumber(),
                    res.getBookingDate().format(formatter),
                    res.getFlightInformation().getFlightNumber(),
                    res.getFlightInformation().getSeatNumber(),
                    res.getFlightInformation().getTimePickUp().format(formatter));
        }
        System.out.println();
    }

    public void display(ReservationManager r){
        if(r.getListReser().isEmpty()){
            System.out.println("No information to view");
            return;
        }

        System.out.println("\n--- All Reservations ---");
        System.out.printf("%-8s %-20s %-15s %-10s %-12s %-25s%n",
                "ID", "Customer", "Phone", "Room", "BookingDate", "Flight Info");
        System.out.println("=".repeat(100));

        for(Reservation res : r.getListReser()){
            String flightInfo = "";
            if(res.getFlightInformation() != null &&
                    !res.getFlightInformation().getFlightNumber().isEmpty()){
                flightInfo = res.getFlightInformation().getFlightNumber() + "-" +
                        res.getFlightInformation().getSeatNumber() + "-" +
                        res.getFlightInformation().getTimePickUp().format(formatter);
            } else {
                flightInfo = "No flight";
            }

            System.out.printf("%-8s %-20s %-15s %-10s %-12s %-25s%n",
                    res.getBookingID(),
                    res.getCustomerName(),
                    res.getPhoneNumber(),
                    res.getRoomNumber(),
                    res.getBookingDate().format(formatter),
                    flightInfo);
        }
        System.out.println();
    }
}