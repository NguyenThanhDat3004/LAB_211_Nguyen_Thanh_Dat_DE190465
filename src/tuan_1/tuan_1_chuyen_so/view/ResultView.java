package tuan_1.tuan_1_chuyen_so.view;

import tuan_1.tuan_1_chuyen_so.model.NumberManagement;

public class ResultView {
    public void displayResult(NumberManagement NM){
        System.out.println("Result: ");
        while(!NM.getNumberStack().isEmpty()){
            System.out.print(NM.getNumberStack().pop());
        }
        System.out.println();
    }
}
