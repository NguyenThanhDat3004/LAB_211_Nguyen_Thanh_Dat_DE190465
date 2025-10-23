package tuan_7;

import java.util.Scanner;

public class Validator {
    static Scanner sc = new Scanner(System.in);
    public static double checkNum(String msg){
        System.out.println(msg);
        while(true){
            try{
                double size = Double.parseDouble(sc.nextLine());
                if(size<=0){
                    System.out.println("Not valid");
                    continue;
                }
                return size;
            }catch(NumberFormatException e){
                System.out.println("Re enter");
            }
        }
    }
    public static int checkChoice(String msg){
        System.out.println(msg);
        while(true){
            try{
                int choice = Integer.parseInt(sc.nextLine());
                if(choice<=0||choice>=7){
                    System.out.println("Not valid");
                    continue;
                }
                return choice;
            }catch(NumberFormatException e){
                System.out.println("Re enter");
            }
        }

    }
}