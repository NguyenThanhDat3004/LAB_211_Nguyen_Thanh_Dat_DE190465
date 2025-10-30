package tuan_6.model;

public class Fruit {
    private String fruit_id;
    private String name;
    private String origin; // xuat xu
    private double price;
    private int quantity; // ton kho
    // cons
    public Fruit(String fruit_id, String name, String origin, double price, int quantity) {
        this.fruit_id = fruit_id;
        this.name = name;
        this.origin = origin;
        this.price = price;
        this.quantity = quantity;
    }
    // get set
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getFruit_id() {
        return fruit_id;
    }
    public String getOrigin() {
        return origin;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setFruit_id(String fruit_id) {
        this.fruit_id = fruit_id;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return  fruit_id + '-' + name + "-" + origin + "-" + price + "-" + quantity;
    }
}
