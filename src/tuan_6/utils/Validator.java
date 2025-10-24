package tuan_6.utils;
import tuan_6.model.Fruit;
import tuan_6.model.Order;
import java.util.Scanner;

public class Validator {
    static Scanner sc = new Scanner(System.in);
    // check chi so mang
    public static int checkNum(String msg){
        System.out.println(msg);
        while(true){
            try{
            int num = Integer.parseInt(sc.nextLine());
            if(num<=0){
                System.out.println("Please input number greater than 0");
                continue;
            }
            return num;
        }catch(NumberFormatException e){
            System.out.println("Not valid. Re enter a integer number");
        }
        }
    }
    // valid cho fruit
    // id khong duoc co khoang trang
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
    // dung cho quantity
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
    // nhap cho price
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
    // ham input fruit
    public static Fruit enterFruit(){
        String id = checkString("Enter Fruit ID:");
        String name = checkString("Enter Fruit Name:");
        String origin =checkString("Enter Origin:");
        double price = checkDouble("Enter Price:");
        int quantity = checkInt("Enter Quantity:");
        return new Fruit(id, name, origin, price, quantity);
    }
    // ham input Order
    public  static Order inputOrder(){
        String orderID = checkString("Enter Order ID:");
        String customerName = sc.nextLine();
        double total = checkDouble("Enter Total Amount:");
        return new Order(customerName,total,orderID);
    }
    public static int checkNumInWhile(String msg){
        System.out.println(msg);
        while(true){
            try{
                int num = Integer.parseInt(sc.nextLine());
                if(num<1||num>2){
                    System.out.println("Please input 1 or 2");
                    continue;
                }
                return num;
            }catch(NumberFormatException e){
                System.out.println("Not valid. Re enter a integer number");
            }
        }
    }

}
