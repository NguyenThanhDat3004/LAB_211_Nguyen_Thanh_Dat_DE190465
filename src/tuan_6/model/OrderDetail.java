package tuan_6.model;

public class OrderDetail {
    // Lop chi tiet hoa don
    private Fruit fruit;
    private int quantity;
    private  double amount;
    private int ordersId;
    public OrderDetail(Fruit fruit, int quantity) {
        this.fruit = fruit;
        this.quantity = quantity;
        this.amount = fruit.getPrice()*quantity;
    }
    public Fruit getFruit() {
        return fruit;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getAmount() {
        return amount;
    }

    public int getOrdersId() {
        return ordersId;
    }
    @Override
    public String toString() {
        return  fruit + "-" + amount + "-" + quantity;
    }
}
