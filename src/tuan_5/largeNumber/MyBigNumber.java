/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_5.largeNumber;
public class MyBigNumber {
    // 
    private String number;
    //con
    public MyBigNumber(String number) {
        this.number = number;
    }
    @Override
    public String toString() {
        return number;
    }
    public String convertToString(int a[]){
        StringBuilder kq = new StringBuilder();
        for(int d : a){
            kq.append(d);
        }
        return kq.toString();
    }
    // ham add
    public MyBigNumber add(MyBigNumber orther){
        int k = Math.max(this.number.length(), orther.number.length());
        int result[] = new int[k+1];
        int i = this.number.length()-1; // tro vao phan tu cuoi cung cua string 
        int j = orther.number.length()-1; // tro vao phan tu cuoi cung cua tham so truyen vao
        int soDu = 0;
        while(i>=0||j>=0){
            int so1 = (i>=0) ? this.number.charAt(i)-'0' : 0; // tra ve ki tu so nen tru ma ascii cua no de ve so
            int so2 = (j>=0) ? orther.number.charAt(j)-'0' : 0;
            int kq = so1+so2+soDu;
            result[k] = kq%10;
            soDu = kq/10;
            i--;
            j--;
            k--;
        }
        if(soDu>0) result[k] = soDu;
        return new MyBigNumber(convertToString(result));
    }
    // ham nhan 
    public MyBigNumber multi(MyBigNumber orther){
        int result[] = new int[this.number.length()+orther.number.length()];
        for(int i = this.number.length()-1;i>=0;i--){
        int sd = 0;
        int s1 = this.number.charAt(i)-'0';
        for(int j  = orther.number.length()-1;j>=0;j--){
            int s2 = orther.number.charAt(j)-'0';
            int val = s1*s2+result[i+j+1]+sd;
            result[i+j+1] = val%10;
            sd = val/10;
        }
        result[i] = result[i]+sd;
    }
        return new MyBigNumber(convertToString(result));
    }
    public static void main(String[] args) {
        MyBigNumber so1 = new MyBigNumber("55");
        MyBigNumber so2 = new MyBigNumber("55");
        MyBigNumber so3 = so1.add(so2);
        System.out.println("Result = "+so3);
    }    
}
