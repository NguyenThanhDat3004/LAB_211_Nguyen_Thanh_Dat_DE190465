package tuan_2.matrix.utils;

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
    // check cac phan tu cua ma tran
    public static double checkElement(String msg){
        System.out.println(msg);
        while(true){
            try{
            double num = Double.parseDouble(sc.nextLine());
            return num;
        }catch(NumberFormatException e){
            System.out.println("Not valid. Re enter a number");
        }
        }
    }
    //
}
