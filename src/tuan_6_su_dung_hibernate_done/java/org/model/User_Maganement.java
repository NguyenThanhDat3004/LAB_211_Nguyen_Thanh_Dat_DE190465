package org.model;

import org.dao.FruitDAO;
import org.dao.OrderDAO;
import org.dao.OrderDetailDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class User_Maganement{
    private List<OrderSummary> summaryList = new ArrayList<>();
    private List<Fruit> fruitList = new ArrayList<>();
    private List<Orders> ordersList =  new ArrayList<>();
    private List<OrderDetail> orderDetailList = new ArrayList<>();

    public List<Fruit> getFruitList() {
        return fruitList;
    }

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public List<OrderSummary> getSummaryList() {
        return summaryList;
    }

    //    lay du lieu len
    public void load(){
        ordersList= OrderDAO.getInstance().selectAll();
        orderDetailList= OrderDetailDAO.getInstance().selectAll();
        fruitList = FruitDAO.getInstance().selectAll();
        summaryList = OrderDetailDAO.getInstance().selectOrderSummary();
    }
// cap nhat kho khi mua
// cap nhat ton kho
    public boolean increaseQuality(Fruit fruit, int quantity){
        if((fruit.getQuantity()-quantity)==0){
            FruitDAO.getInstance().delete(fruit);
        } else if ((fruit.getQuantity()-quantity)<0) {
            System.out.println("Quantity not enough. Try again.");
            return false;
        } else{
            fruit.setQuantity(fruit.getQuantity()-quantity);
            FruitDAO.getInstance().update(fruit);
        }
        load();
        return true;
    }
//
public void addOrder(Orders order) throws SQLException {
    OrderDAO.getInstance().add(order);
    ordersList.add(order);
}
public void addOrderDetail(OrderDetail orderDetail) throws SQLException {
        OrderDetailDAO.getInstance().add(orderDetail);
        orderDetailList.add(orderDetail);
    }


}