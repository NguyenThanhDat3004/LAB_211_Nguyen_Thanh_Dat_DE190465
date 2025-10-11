package tuan_1.tuan_1_chuyen_so.model;

import java.util.Stack;

public class NumberManagement {
    private Stack<Integer> numberStack = new Stack<>();
    // constructor
    public NumberManagement() {
    }
    // getter
    public Stack<Integer> getNumberStack() {
        return numberStack;
    }
    // ham tong quat gom cac tham so dau vao, base vao, base ra
    // Xac dinh base dau vao va push stack
    public void pushStack(String number, int baseIn){
        numberStack.clear();
        char[] elementNumber = number.toCharArray();
        for(int i = 0; i < elementNumber.length; i++){
            if(baseIn == 16){
            if(elementNumber[i]=='A' || elementNumber[i]=='a' ){
                numberStack.push(10);
            } else if(elementNumber[i]=='B' || elementNumber[i]=='b'){
                numberStack.push(11);
            } else if(elementNumber[i]=='C' || elementNumber[i]=='c'){
                numberStack.push(12);
            } else if(elementNumber[i]=='D' || elementNumber[i]=='d'){
                numberStack.push(13);
            } else if(elementNumber[i]=='E' || elementNumber[i]=='e'){
                numberStack.push(14);
            } else if(elementNumber[i]=='F' || elementNumber[i]=='f'){
                numberStack.push(15);
            } else {
                int num = Integer.parseInt(number);
                numberStack.push(num);
            } 
        }else {  
                numberStack.push(Integer.parseInt(Character.toString(elementNumber[i])));
            }
        }
    }
    // chuyen tu base bat ki sang base 10
    public int convertToBase10(String number, int baseIn) {
        int result = 0;
        int firstPower = 0;
        while (!numberStack.isEmpty()) {
            result += numberStack.pop() * Math.pow(baseIn, firstPower);
            firstPower++;
        }
        return result;        
    }
    // chuyen tu base 10 sang base bat ki  ------------- chua xu ly hexa
    public void outPut(String number, int baseIn, int baseOut){
        int temp = convertToBase10(number, baseIn);
        int remainder; // so du
        int quotient; // thuong
        while(temp != 0){
            remainder = temp % baseOut;
            numberStack.push(remainder);
            quotient = temp / baseOut;
            temp = quotient;
        }
    }
    // ham convert tong quat
    public void convert(String number, int baseIn, int baseOut){
        this.pushStack(number, baseIn);
        this.outPut(number, baseIn, baseOut);
    }
}
