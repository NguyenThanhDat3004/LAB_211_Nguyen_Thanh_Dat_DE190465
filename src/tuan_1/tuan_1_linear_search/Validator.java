package tuan_1.tuan_1_linear_search;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nguye
 */
public class Validator {
    static Scanner sc = new Scanner(System.in);
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
