package org.utills;

import org.model.Fruit;
import org.model.Orders;
import java.util.Scanner;

public class Validator {
    static Scanner sc = new Scanner(System.in);

    // check số nguyên > 0
    public static int checkInt(String msg){
        System.out.println(msg);
        while(true){
            try{
                int num = Integer.parseInt(sc.nextLine());
                if(num <= 0){
                    System.out.println("Please input a number greater than 0");
                    continue;
                }
                return num;
            } catch(NumberFormatException e){
                System.out.println("Not valid. Re-enter an integer number");
            }
        }
    }

    // check số double > 0
    public static double checkDouble(String msg){
        System.out.println(msg);
        while(true){
            try{
                double num = Double.parseDouble(sc.nextLine());
                if(num <= 0){
                    System.out.println("Please input a number greater than 0");
                    continue;
                }
                return num;
            } catch(NumberFormatException e){
                System.out.println("Not valid. Re-enter a valid number");
            }
        }
    }

    // check String không rỗng
    public static String checkString(String msg){
        System.out.println(msg);
        while(true){
            String input = sc.nextLine().trim();
            if(!input.isEmpty()){
                return input;
            }
            System.out.println("Input cannot be empty. Please re-enter:");
        }
    }

    // input Fruit
    public static Fruit enterFruit(){
        String name = checkString("Enter Fruit Name:");
        String origin = checkString("Enter Origin:");
        double price = checkDouble("Enter Price:");
        int quantity = checkInt("Enter Quantity:");
        return new Fruit( name, origin, price, quantity);
    }

    // input Orders (không nhập ID, Hibernate tự cấp)
    public static Orders inputOrder(){
        String customerName = checkString("Enter Customer Name:");
        double totalAmount = checkDouble("Enter Total Amount:");
        return new Orders(customerName, totalAmount);
    }

    // input OrderDetail (tham chiếu order_id + fruit_id)
    public static int enterQuantity(){
        return checkInt("Enter Quantity:");
    }

    // check nhập 1 hoặc 2
    public static int checkNumInWhile(String msg){
        System.out.println(msg);
        while(true){
            try{
                int num = Integer.parseInt(sc.nextLine());
                if(num < 1 || num > 2){
                    System.out.println("Please input 1 or 2");
                    continue;
                }
                return num;
            } catch(NumberFormatException e){
                System.out.println("Not valid. Re-enter an integer number");
            }
        }
    }
}
