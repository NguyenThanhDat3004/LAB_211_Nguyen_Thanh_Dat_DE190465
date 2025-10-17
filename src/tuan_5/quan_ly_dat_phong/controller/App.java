package tuan_5.quan_ly_dat_phong.controller;

import tuan_5.quan_ly_dat_phong.model.ReservationManager;
import tuan_5.quan_ly_dat_phong.view.Menu1;
import tuan_5.quan_ly_dat_phong.view.Solution;

public class App extends Menu1 {
    Solution so = new Solution();
    ReservationManager re = new ReservationManager();
    public App(){
        super("Reservation Manager", new String[]{
                "Create new reservation", "Update reservation",
                "Delete reservation","Print Flight Information"," Print all","Exit"
        });
    }
    @Override
    public void execute(int n) {
        switch (n){
            case 1:

                break;
            case 2:

                break;
            case 3:

                break;
            case 4:
                so.displayListFly(re);
                break;
            case 5:
                so.display(re);
                break;
            case 6:
                System.out.println("Exitting....");
            default:
                System.out.println("Not valid");
        }
    }

    public static void main(String[] args) {
        App t = new App();
        t.run();
    }
}
