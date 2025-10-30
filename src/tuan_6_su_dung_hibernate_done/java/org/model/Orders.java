package org.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id // thong bao khoa chinh cua bang
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int order_id;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "total_amount")
    private double total_amount; // tong tien don hang
    public Orders(){
    }
    public Orders(String customerName,double total_amount){
        this.customerName = customerName;
        this.total_amount = total_amount;
    }
    public Orders(int id,String customerName,double total_amount){
        this.order_id = id;
        this.customerName = customerName;
        this.total_amount = total_amount;
    }

    public int getOrder_id() {
        return order_id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }
}
