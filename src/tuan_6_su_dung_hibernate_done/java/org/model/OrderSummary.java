package org.model;

public class OrderSummary {
    private String customerName;
    private int totalQuantity;
    private double totalAmount;
    private String fruitNames;

    // Constructor
    public OrderSummary(String customerName, int totalQuantity, double totalAmount, String fruitNames) {
        this.customerName = customerName;
        this.totalQuantity = totalQuantity;
        this.totalAmount = totalAmount;
        this.fruitNames = fruitNames;
    }

    // Getters
    public String getCustomerName() {
        return customerName;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getFruitNames() {
        return fruitNames;
    }

    // Setters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setFruitNames(String fruitNames) {
        this.fruitNames = fruitNames;
    }

    // toString() để in ra đẹp
    @Override
    public String toString() {
        return "OrderSummary{" +
                "customerName='" + customerName + '\'' +
                ", totalQuantity=" + totalQuantity +
                ", totalAmount=" + totalAmount +
                ", fruitNames='" + fruitNames + '\'' +
                '}';
    }
}
