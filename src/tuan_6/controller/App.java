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

    }
    public static void main(String[] args) {

    }
}
