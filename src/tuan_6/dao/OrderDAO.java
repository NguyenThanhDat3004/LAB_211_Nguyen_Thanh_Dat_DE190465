package tuan_6.dao;

import tuan_6.model.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements DAOInterface<Order> {
    public static OrderDAO getInstance(){
        return new OrderDAO();
    }

    @Override
    public int add(Order order) throws SQLException {
        int result;
        try {
            Connection co = tuan_6.dao.JDBCUtils.getConnection();
            String sql = "INSERT INTO Orders(orders_id,customer_name,total)" +
                    " VALUES (?,?,?)";
            PreparedStatement st = co.prepareStatement(sql);
            st.setString(1,order.getOrderID());
            st.setString(2,order.getCustomerName());
            st.setDouble(3,order.getTotal());
            result = st.executeUpdate(); // tra ve so luong dong bi thay doi
            System.out.println("You excuted: " + sql);
            System.out.println("Have " + result + " changed");
            JDBCUtils.closeConnection(co);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int update(Order order) {
        int result;
        try {
            Connection co = JDBCUtils.getConnection();
            String sql = "UPDATE Orders " +
                    " SET customer_name=?, total=?" +
                    " WHERE orders_id=?";
            PreparedStatement st = co.prepareStatement(sql);
            st.setString(1, order.getCustomerName());
            st.setDouble(2, order.getTotal());
            st.setString(3, order.getOrderID());
            result = st.executeUpdate();
            System.out.println("You excuted: " + sql);
            System.out.println("Have " + result + " changed");
            // buoc 5: ngat ket noi
            JDBCUtils.closeConnection(co);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public int delete(Order order) {
        int result;
        try {
            Connection co = JDBCUtils.getConnection();
            String sql = "DELETE FROM Orders " +
                    "WHERE orders_id=? ";
            PreparedStatement st = co.prepareStatement(sql);
            st.setString(1,order.getOrderID());
            result = st.executeUpdate(); // tra ve so luong dong bi thay doi
            System.out.println("You excuted: " + sql);
            System.out.println("Have " + result + " changed");
            JDBCUtils.closeConnection(co);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    @Override
    public List<Order> selectAll() {
        List<Order> list = new ArrayList<>();
        try {
            Connection con = JDBCUtils.getConnection();
            String sql = "SELECT * FROM Orders";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String orderId = rs.getString("orders_id");
                String customerName = rs.getString("customer_name");
                double total = rs.getDouble("total");
                Order order = new Order(customerName, total, orderId);
                list.add(order);
            }
            JDBCUtils.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
