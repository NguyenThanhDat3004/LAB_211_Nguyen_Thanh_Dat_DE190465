package tuan_5.quan_ly_dat_phong.model;

import java.util.ArrayList;
import java.util.List;

public class ReservationManager {
    private List<Reservation> listReser = new ArrayList<>();
    private List<FlightInformation> listFly = new ArrayList<>();

    public List<Reservation> getListReser() {
        return listReser;
    }

    public List<FlightInformation> getListFly() {
        return listFly;
    }

    // ham search
    public Reservation searchByID(String r){
        return listReser.stream().filter(s->s.getBookingID().equalsIgnoreCase(r)).findFirst().orElse(null);
    }
    // ham add
    public boolean add(Reservation r){
        if(searchByID(r.getBookingID())==null){
            listReser.add(r);
            listFly.add(r);
            return true;
        }
        return false; // neu that bai
    }
    //ham update
    public void update(Reservation re, Reservation newRe){
        re = newRe;
    }
    //tim kiem va xoa
    public void delete(Reservation re){
        listReser.remove(re);
        listFly.remove(re);
    }
}
