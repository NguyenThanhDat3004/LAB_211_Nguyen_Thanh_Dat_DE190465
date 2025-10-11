package tuan_3.binary_search;

import java.util.Scanner;

public class Validator {
    static Scanner sc = new Scanner(System.in);
    // check size > 0
    public static int checkNum(String msg){
        System.out.println(msg);
        while(true){
            try{
            int size = Integer.parseInt(sc.nextLine());
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
}
