package tuan_1.tuan_1_chuyen_so.controller;
import java.util.Scanner;

import tuan_1.tuan_1_chuyen_so.model.NumberManagement;
import tuan_1.tuan_1_chuyen_so.view.Menu1;
import tuan_1.tuan_1_chuyen_so.view.ResultView;

public class NumberController extends Menu1{
    private int baseIn, baseOut;
    private String number;
    Scanner sc = new Scanner(System.in);
    NumberManagement NM = new NumberManagement();
    // constructor
    public NumberController(){
        super("MENU BASE INPUT", new String[]{
            " Binary",
            " Decimal",
            " Octal",
            " Hexadecimal",
        });
    }
    //override method
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                baseIn = 2;
                this.menuBaseOut();
                break;
            case 2:
                baseIn = 10;
                this.menuBaseOut();
                break;
            case 3:
                baseIn = 8;
                this.menuBaseOut();
                break;
            case 4:
                baseIn = 16;
                this.menuBaseOut();
                break;
            default:
                break;
        }
        sc.nextLine();
        System.out.print("Nhap so can chuyen: ");
        number = sc.nextLine();
        NM.convert(number, baseIn, baseOut);
        ResultView RV = new ResultView();
        RV.displayResult(NM);
    }
    //ham menu base output
    public void menuBaseOut(){
        System.out.println("Select base output: ");
        System.out.println("1. Binary");
        System.out.println("2. Decimal");
        System.out.println("3. Octal");
        System.out.println("4. Hexadecimal");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        
        switch (choice) {
            case 1:
                baseOut = 2;
                break;
            case 2:
                baseOut = 10;
                break;
            case 3:
                baseOut = 8;
                break;
            case 4:
                baseOut = 16;
                break;
            default: System.out.println("Invalid choice");
                break;
                }
    }
    // Ham main
    public static void main(String[] args) {
        NumberController NC = new NumberController(); 
        NC.run();
    }
}
