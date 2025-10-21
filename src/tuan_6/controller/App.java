package tuan_6.controller;

import tuan_6.view.Menu1;

public class App extends Menu1 {
    public App(){
        super("Fruit Shop", new String[]{
                "Create Fruit","View orders", "Shopping (for buyer)","Exit"
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

            System.out.println("Exitting ....");
            break;
        default:
            System.out.println("Not available choice");
    }
    }
    public static void main(String[] args) {

    }
}
