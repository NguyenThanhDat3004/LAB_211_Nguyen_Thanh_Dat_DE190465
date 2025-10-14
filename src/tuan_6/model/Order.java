package tuan_6.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    // 1 lop hoa don
    private String customerName;
    private List<OrderDetail> items = new ArrayList<>();
    private double total;
    private int orderID;
    public Order(String customerName){
        this.customerName = customerName;
    }
    public void addDetail(OrderDetail od){
        items.add(od);
        total+=od.getAmount();
    }
    public String getCustomerName(){
        return customerName;
    }

    public double getTotal() {
        return total;
    }

    public List<OrderDetail> getItems() {
        return items;
    }

    public int getOrderID() {
        return orderID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer: ").append(customerName).append("\n");
        sb.append("Product      |   Qty   |     Price   |   Amount \n");
        int i = 1;
        for(OrderDetail od : items){
            sb.append(i++).append(". ").append(od.toString()).append("\n");
        }
        sb.append("Total: ").append(String.format("%.2f$",total)).append("\n");
        return sb.toString();
    }
}
