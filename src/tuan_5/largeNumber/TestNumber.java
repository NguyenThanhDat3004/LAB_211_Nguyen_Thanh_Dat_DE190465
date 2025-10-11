/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tuan_5.largeNumber;

import java.math.BigInteger;

/**
 *
 * @author nguye
 */
public class TestNumber {
    //Viết một chương trình để cộng và nhân hai số được nhập từ bàn phím, sau đó hiển thị kết quả ra màn hình.
    // mang bang max + 1
    // nho vo mot bien nho
    // bai lam

    public static void main(String[] args) {
        BigInteger so1 = new BigInteger("100000000000000000000000000"); // thuc hien phep toan dai vo han
        // BigIn la 1 doi tuong nha
        BigInteger so2 = new BigInteger("100000000000000000000000000000000000");
        BigInteger so3 = so1.add(so2);
        System.out.println("KQ = "+ so3);
    }
}
