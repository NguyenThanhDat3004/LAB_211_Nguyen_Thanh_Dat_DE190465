package tuan_6.model;
import tuan_6.dao.FruitDAO;
import tuan_6.dao.OrderDAO;
import tuan_6.dao.OrderDetailDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class User_Maganement {
    List<Fruit> listFruit = new ArrayList<>();
    List<OrderDetail> listOD = new ArrayList<>();
    List<Order> listOrder = new ArrayList<>();
    public User_Maganement() {
        load();
    }
    // ham load du lieu
    public void load(){
        listFruit = FruitDAO.getInstance().selectAll();
        listOD = OrderDetailDAO.getInstance().selectAll();
        listOrder = OrderDAO.getInstance().selectAll();
    }
    //check id da ton tai
    public boolean checkFruit(String id){
        Predicate<Fruit> containFruitId = s -> s.getFruit_id().equalsIgnoreCase(id);
        return listFruit.stream().filter(containFruitId).collect(Collectors.toList()).isEmpty();
    }
    // them trai cay
    public boolean addFruit(Fruit fruit) throws SQLException {
            int result = FruitDAO.getInstance().add(fruit);
            if (result > 0) {
                listFruit.add(fruit);
                return true;
            }
        return false;
    }
    public boolean updateFruit(Fruit fruit) {
        if(!checkFruit(fruit.getFruit_id())){
            FruitDAO.getInstance().update(fruit);
            load();
            return true;
        }
        return false;
    }
    //xoa
    public boolean removeFruit(Fruit fruit){
        if(!checkFruit(fruit.getFruit_id())){
            FruitDAO.getInstance().delete(fruit);
            load();
            return true;
        }
        return false;
    }
    //order
    // check order ton tai
    public boolean checkOrders(String id){
        Predicate<Order> containOrdersId = s -> s.getOrderID().equalsIgnoreCase(id);
        return listOrder.stream().filter(containOrdersId).collect(Collectors.toList()).isEmpty();
    }
    public boolean addOrder(Order order) throws SQLException {
        int result = OrderDAO.getInstance().add(order);
        if (result > 0) {
            listOrder.add(order);
            return true;
        }
        return false;
    }
    public boolean removeOrder(Order order){
        if(!checkOrders(order.getOrderID())){
            OrderDAO.getInstance().delete(order);
            load();
            return true;
        }
        return false;
    }
    // update
    public boolean updateOrder(Order order) {
        if(!checkOrders(order.getOrderID())){
            OrderDAO.getInstance().update(order);
            load();
            return true;
        }
        return false;
    }
    //order detail
    public boolean checkOrderDetail(String idFruit, String idOrder){
        return !checkFruit(idFruit) && !checkOrders(idOrder);
    }
    public boolean addOrderDetail(OrderDetail orderDetail) throws SQLException {
        int result = OrderDetailDAO.getInstance().add(orderDetail);
        if (result > 0) {
            listOD.add(orderDetail);
            return true;
        }
        return false;
    }
    public boolean removeOD(OrderDetail orderDetail){
        if(!checkOrderDetail(orderDetail.getFruit().getFruit_id(),orderDetail.getOrdersId())){
            OrderDetailDAO.getInstance().delete(orderDetail);
            load();
            return true;
        }
        return false;
    }
    public boolean updateOD(OrderDetail orderDetail) {
        if(!checkOrderDetail(orderDetail.getFruit().getFruit_id(),orderDetail.getOrdersId())){
            OrderDetailDAO.getInstance().update(orderDetail);
            load();
            return true;
        }
        return false;
    }
}
