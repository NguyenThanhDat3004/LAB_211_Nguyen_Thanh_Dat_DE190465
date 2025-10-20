package tuan_5.quan_ly_dat_phong.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ReservationManager {
    private List<Reservation> listReser = new ArrayList<>();

    public List<Reservation> getListReser() {
        return listReser;
    }

    public List<Reservation> getListFly() {
        List<Reservation> flyList = new ArrayList<>();
        for(Reservation r : listReser){
            if(r.getFlightInformation() != null &&
                    !r.getFlightInformation().getFlightNumber().isEmpty()){
                flyList.add(r);
            }
        }
        flyList.sort(Comparator.comparing(r -> r.getFlightInformation().getTimePickUp()));
        return flyList;
    }

    public Reservation searchByID(String id){
        return listReser.stream()
                .filter(s -> s.getBookingID().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }

    public boolean add(Reservation r){
        if(searchByID(r.getBookingID()) == null){
            listReser.add(r);
            return true;
        }
        return false;
    }

    public void update(Reservation oldRes, Reservation newRes){
        int index = listReser.indexOf(oldRes);
        if(index != -1){
            listReser.set(index, newRes);
        }
    }

    public void delete(Reservation re){
        listReser.remove(re);
    }
}