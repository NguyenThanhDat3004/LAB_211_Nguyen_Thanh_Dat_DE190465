/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_2.chuong_trinh_may_tinh.controller;


import tuan_2.chuong_trinh_may_tinh.model.BMI_Calculation;
import tuan_2.chuong_trinh_may_tinh.model.Operator;
import tuan_2.chuong_trinh_may_tinh.model.SimpleCalculation;
import tuan_2.chuong_trinh_may_tinh.utils.Checker;
import tuan_2.chuong_trinh_may_tinh.view.Menu1;
import tuan_2.chuong_trinh_may_tinh.view.Solution;

/**
 *
 * @author nguye
 */
public class Cal_Controller extends Menu1 {
    BMI_Calculation bmiCalculation = new BMI_Calculation();
    SimpleCalculation simpleCalculation = new SimpleCalculation();
    Cal_Controller(){
        super("Simple Calculator", new String[]{
            "Simple Calculation","BMI Calculation","Exit"
        });
    }
    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                double a = Checker.checkNum("Enter Number: ");
                simpleCalculation.setMemory(a);
                String op = Checker.checkOperator("Enter Operator: ");
                Operator operator = null;
               //
                for(Operator o : Operator.values()){
                    if(o.getSymbol().equals(op)){
                        operator = o;
                        break;
                    }
                }
                simpleCalculation.setOperator(operator);
                if(simpleCalculation.isEqual()){
                    System.out.println("Result: "+simpleCalculation.getMemory());
                    return;
                }
                double b = Checker.checkNum("Enter Number: ");
                simpleCalculation.setInput(b);
                System.out.println("Result: "+simpleCalculation.performSimpleCalculation());
                break;
            case 2:
                double height = Checker.checkNumBMI("Enter your height (cm): ");
                double weight = Checker.checkNumBMI("Enter your weight (kg): ");
                bmiCalculation.setHeight(height);
                bmiCalculation.setWeight(weight);
                Solution solution = new Solution();
                solution.display(bmiCalculation);
                 break;
            case 3:
                System.out.println("Exiting program...");
            default:
                    System.out.println("Invalid choice. Exit...");
                break;
        }
        
    }
    public static void main(String[] args) {
       Cal_Controller cal = new Cal_Controller();
        cal.run(); 
    }


}
