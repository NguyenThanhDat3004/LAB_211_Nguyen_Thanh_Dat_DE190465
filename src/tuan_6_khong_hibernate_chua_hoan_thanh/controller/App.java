package tuan_6.controller;

import tuan_6.dao.OrderDAO;
import tuan_6.model.Fruit;
import tuan_6.model.Order;
import tuan_6.model.User_Maganement;
import tuan_6.utils.Validator;
import tuan_6.view.Menu1;
import tuan_6.view.Solution;

import java.sql.SQLException;

public class App extends Menu1 {
    User_Maganement m = new User_Maganement();
    Solution so = new Solution();
    public App(){
        super("Fruit Shop", new String[]{
                "Create Fruit","View orders", "Shopping (for buyer)","Exit"
        });
    }
    @Override
    public void execute(int n) throws SQLException {
    switch (n){
        case 1:
            Fruit f = Validator.enterFruit();
            if(m.addFruit(f)) System.out.println("Success");
            else System.out.println("fail");
            break;
        case 2:


            break;
        case 3:
            int d = 0;
            String name = Validator.checkString("Enter your name: ");
            String id1 = Validator.checkString("Enter order id : ");
            do{
                so.getListFruit(m);
                String id = Validator.checkString("Enter your id fruit you want: ");
                Fruit a = m.findById(id);
                if(m!=null) {
                    while(true){
                        int c = Validator.checkInt("Enter quantity: ");
                        if(!m.increaseQuality(a,c)) continue;

                        double total = c*a.getPrice();

                        Order o = new Order(name,total,id1);
                        OrderDAO.getInstance().add(o);
                        break;
                    }
                }
                else System.out.println("Not available id");
                System.out.println("Do you want continue? (Please choose 1 or 2) \n 1. Yes\n 2. No");
                d = Validator.checkNumInWhile("Enter your choice: ");
            }while (d!=2);
            break;
        case 4:
            System.out.println("Exitting ....");
            break;
        default:
            System.out.println("Not available choice");
    }
    }
    public static void main(String[] args) throws SQLException {
    App a = new App();
    a.run();
    }
}
