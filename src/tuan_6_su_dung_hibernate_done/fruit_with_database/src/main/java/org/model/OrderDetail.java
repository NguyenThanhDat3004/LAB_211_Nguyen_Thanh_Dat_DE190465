package org.model;

import jakarta.persistence.*;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int order_detail_id;
    private int order_id;
    private int fruit_id;
    private int quantity;
    private double amount; // tong tien
    public OrderDetail(){}
    public OrderDetail( int order_id,int fruit_id,int quantity,double amount){
        this.order_id = order_id;
        this.fruit_id = fruit_id;
        this.quantity = quantity;
        this.amount = amount;
    }
    public OrderDetail(int order_detail_id, int order_id,int fruit_id,int quantity,double amount){
        this.order_detail_id = order_detail_id;
        this.order_id = order_id;
        this.fruit_id = fruit_id;
        this.quantity = quantity;
        this.amount = amount;
    }
    public double getAmount() {
        return amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getOrder_detail_id() {
        return order_detail_id;
    }

    public int getFruit_id() {
        return fruit_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setFruit_id(int fruit_id) {
        this.fruit_id = fruit_id;
    }

    public void setOrder_detail_id(int order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
}

