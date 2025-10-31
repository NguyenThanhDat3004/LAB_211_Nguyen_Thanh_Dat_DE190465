package org.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Orders;
import org.utills.HibernateUtill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDAO implements DaoInterface<Orders>{
    public static OrderDAO getInstance(){
        return new OrderDAO();
    }
    @Override
    public int update(Orders order) {
        int result;
        try {
            Connection co = JDBC_Utils.getConnection();
            String sql = "UPDATE Orders " +
                    " SET customerName=?, total_amount=?" +
                    " WHERE order_id=?";
            PreparedStatement st = co.prepareStatement(sql);
            st.setString(1, order.getCustomerName());
            st.setDouble(2, order.getTotal_amount());
            st.setInt(3, order.getOrder_id());
            result = st.executeUpdate();
            System.out.println("You excuted: " + sql);
            System.out.println("Have " + result + " changed");
            // buoc 5: ngat ket noi
            JDBC_Utils.closeConnection(co);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
    @Override
    public void add(Orders orders) throws SQLException {

        Transaction transaction = null;
        Session session = HibernateUtill.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.save(orders);
            session.flush();
            transaction.commit();
            System.out.println("Create successfully");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
//session.close();
        }
    }
    @Override
    public int delete(Orders orders) {
        int result;
        try {
            Connection co = JDBC_Utils.getConnection();
            String sql = "DELETE FROM Orders " +
                    "WHERE order_id=? ";
            PreparedStatement st = co.prepareStatement(sql);
            st.setInt(1,orders.getOrder_id());
            result = st.executeUpdate(); // tra ve so luong dong bi thay doi
            System.out.println("You excuted: " + sql);
            System.out.println("Have " + result + " changed");
            JDBC_Utils.closeConnection(co);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public List<Orders> selectAll() {
        List<Orders> list = new ArrayList<>();
        try {
            Connection con = JDBC_Utils.getConnection();
            String sql = "SELECT * FROM Orders";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("order_id");
                String customerName = rs.getString("customerName");
                double total = rs.getDouble("total_amount");
                Orders order = new Orders(orderId,customerName, total);
                list.add(order);
            }
            JDBC_Utils.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // lay ra hoa don

}
