package tuan_6.controller;

import tuan_6.model.Fruit;
import tuan_6.model.User_Maganement;
import tuan_6.utils.Validator;
import tuan_6.view.Menu1;

import java.sql.SQLException;

public class App extends Menu1 {
    User_Maganement m = new User_Maganement();
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
