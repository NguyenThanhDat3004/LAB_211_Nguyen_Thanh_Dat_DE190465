package tuan_6.model;

public class OrderDetail {
    // Lop chi tiet hoa don
    private Fruit fruit;
    private int quantity;
    private  double amount;
    private String ordersId;
    public OrderDetail(Fruit fruit, int quantity, String ordersId) {
        this.ordersId = ordersId;
        this.fruit = fruit;
        this.quantity = quantity;
        this.amount = fruit.getPrice()*quantity;
    }
    public OrderDetail(Fruit fruit, int quantity, String ordersId, double amount){
        this.fruit = fruit;
        this.quantity = quantity;
        this.ordersId = ordersId;
        this.amount = amount;
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

    public String getOrdersId() {
        return ordersId;
    }
    @Override
    public String toString() {
        return  fruit + "-" + amount + "-" + quantity;
    }
}
