package org.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "Fruit")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự tăng cho SQL Server
    private int fruit_id;
    private String name;
    private String origin;
    private double price;
    private int quantity;
    // bat buoc co cons rong
    public Fruit() {}
    //id tu tang nen khong can id
    public Fruit(String name, String origin, double price, int quantity) {
        this.name = name;
        this.origin = origin;
        this.price = price;
        this.quantity = quantity;
    }
    //
    public Fruit(int id,String name, String origin, double price, int quantity) {
        this.fruit_id = id;
        this.name = name;
        this.origin = origin;
        this.price = price;
        this.quantity = quantity;
    }
    // Getter & Setter
    public int getFruit_id() {
        return fruit_id;
    }
    public void setFruit_id(int fruit_id) {
        this.fruit_id = fruit_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return "Fruit{" +
                "fruit_id=" + fruit_id +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
