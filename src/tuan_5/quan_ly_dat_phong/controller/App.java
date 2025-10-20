package tuan_5.quan_ly_dat_phong.controller;

import tuan_5.quan_ly_dat_phong.model.Reservation;
import tuan_5.quan_ly_dat_phong.model.ReservationManager;
import tuan_5.quan_ly_dat_phong.utils.Validator;
import tuan_5.quan_ly_dat_phong.view.Menu1;
import tuan_5.quan_ly_dat_phong.view.Solution;

public class App extends Menu1 {
    Solution so = new Solution();
    ReservationManager re = new ReservationManager();

    public App(){
        super("*** Reservation Management ***", new String[]{
                "Create new reservation",
                "Update reservation",
                "Delete reservation",
                "Print Flight Information",
                "Print all",
                "Exit"
        });
    }

    @Override
    public void execute(int n) {
        switch (n){
            case 1:
                System.out.println("*** Create new reservation ***");
                Reservation newRes = Validator.enterRe("", re);
                if(re.add(newRes)){
                    System.out.println("Information saved successfully.");
                } else {
                    System.out.println("Booking ID already exists!");
                }
                break;

            case 2:
                System.out.println("*** Update reservation ***");
                String updateId = Validator.checkId("Enter booking ID to update: ");
                Reservation foundRes = re.searchByID(updateId);
                if(foundRes == null){
                    System.out.println("Booking ID not found!");
                } else {
                    Reservation updatedRes = Validator.updateRe(foundRes, re);
                    re.update(foundRes, updatedRes);
                    System.out.println("Reservation updated successfully.");
                }
                break;

            case 3:
                System.out.println("*** Delete reservation ***");
                String deleteId = Validator.checkId("Enter booking ID to delete: ");
                Reservation delRes = re.searchByID(deleteId);
                if(delRes == null){
                    System.out.println("Booking ID not found!");
                } else {
                    if(Validator.confirmYesNo("Are you sure you want to delete this reservation? (Y/N): ")){
                        re.delete(delRes);
                        System.out.println("Reservation deleted successfully.");
                    } else {
                        System.out.println("Deletion cancelled.");
                    }
                }
                break;

            case 4:
                System.out.println("*** Flight Information List ***");
                so.displayListFly(re);
                break;

            case 5:
                System.out.println("*** All Reservations ***");
                so.display(re);
                break;

            case 6:
                System.out.println("Exiting....");
                break;

            default:
                System.out.println("Invalid selection. Please choose 1-6.");
        }
    }

    public static void main(String[] args) {
        App t = new App();
        t.run();
    }
}
