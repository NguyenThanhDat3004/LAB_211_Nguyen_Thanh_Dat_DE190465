package tuan_2.chuong_trinh_may_tinh.utils;

import java.util.Scanner;

public class Checker {
    static Scanner sc = new Scanner(System.in);
    // check chieu cao va can nang
    public static double checkNumBMI(String msg){
        System.out.println(msg);
        while(true){
            try{
            double num = Double.parseDouble(sc.nextLine());
            if(num<=0){
                System.out.println("Please input number greater than 0");
                continue;
            }
            return num;
        }catch(NumberFormatException e){
            System.out.println("Not valid. Re enter");
        }
        }
    }
    //check num nhap vao SimpleCalculator
    public static double checkNum(String msg){
        System.out.println(msg);
        while(true){
            try{
            double num = Double.parseDouble(sc.nextLine());
            return num;
        }catch(NumberFormatException e){
            System.out.println("Not valid. Re enter");
        }
        }
    }
    // check phep toan
    public static String checkOperator(String msg){
        System.out.println(msg);
        while(true){
            String operator = sc.nextLine();
            if(operator.equals("+")||operator.equals("-")||operator.equals("*")||operator.equals("/")||operator.equals("^")||operator.equals("=")){
                return operator;
            }else{
                System.out.println("Not valid. Re enter");
            }
        }
    }
}
