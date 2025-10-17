package tuan_5.quan_ly_dat_phong.view;

import tuan_5.quan_ly_dat_phong.model.ReservationManager;

public class Solution {
    public void displayListReser(ReservationManager r){
        for(int i = 0;i<r.getListReser().size();i++){
            System.out.println(r.getListReser().get(i));
        }
    }
    public void displayListFly(ReservationManager r){
        for(int i = 0;i<r.getListFly().size();i++){
            System.out.println(r.getListFly().get(i));
        }
    }
    public void display(ReservationManager r){
        System.out.println("List Reservation: ");
        for(int i = 0;i<r.getListReser().size();i++){
            System.out.println(r.getListReser().get(i));
        }
        System.out.println("List FlightInformation: ");
        for(int i = 0;i<r.getListReser().size();i++){
            System.out.println(r.getListReser().get(i));
        }
    }
}
