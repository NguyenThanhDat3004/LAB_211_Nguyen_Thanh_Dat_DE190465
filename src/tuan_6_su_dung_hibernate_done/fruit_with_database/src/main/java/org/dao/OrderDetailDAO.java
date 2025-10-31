package org.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.OrderDetail;
import org.model.OrderSummary;
import org.utills.HibernateUtill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class OrderDetailDAO implements DaoInterface<OrderDetail>{
    public static OrderDetailDAO getInstance(){
        return new OrderDetailDAO();
    }
    @Override
    public void add(OrderDetail orderDetail) throws SQLException {
        Transaction transaction = null;
        Session session = HibernateUtill.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.save(orderDetail);
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
    public int update(OrderDetail orderDetail) {
        int result;
        try {
            Connection co = JDBC_Utils.getConnection();
            String sql = "UPDATE OrderDetail " +
                    " SET  quantity=?, amount=? " +
                    " WHERE order_detail_id = ?";
            PreparedStatement st = co.prepareStatement(sql);
            st.setInt(1, orderDetail.getQuantity());
            st.setDouble(2, orderDetail.getAmount());
            st.setInt(3,orderDetail.getOrder_detail_id());
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
    public int delete(OrderDetail orderDetail) {
        int result;
        try {
            Connection co = JDBC_Utils.getConnection();
            String sql = "DELETE FROM OrderDetail " +
                    "WHERE order_detail_id=?";
            PreparedStatement st = co.prepareStatement(sql);
            st.setInt(1,orderDetail.getOrder_detail_id());
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
    public List<OrderDetail> selectAll() {
        List<OrderDetail> list = new ArrayList<>();
        try {
            Connection con = JDBC_Utils.getConnection();
            String sql = "SELECT * FROM OrderDetail";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int detailId = rs.getInt("order_detail_id");
                int orderIdResult = rs.getInt("order_id");
                int fruitId = rs.getInt("fruit_id");
                int quantity = rs.getInt("quantity");
                double amount = rs.getDouble("amount");
                OrderDetail detail = new OrderDetail(detailId, orderIdResult, fruitId, quantity, amount);
                list.add(detail);
            }
            JDBC_Utils.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    // truy xuat don hang
    public List<OrderSummary> selectOrderSummary() {
        List<OrderSummary> list = new ArrayList<>();
        try {
            Connection con = JDBC_Utils.getConnection();
            String sql = "SELECT " +
                    "o.customerName, " +
                    "SUM(od.quantity) AS total_quantity, " +
                    "SUM(od.amount) AS total_amount, " +
                    "STUFF((" +
                    "   SELECT ', ' + f2.name " +
                    "   FROM OrderDetail od2 " +
                    "   JOIN Fruit f2 ON od2.fruit_id = f2.fruit_id " +
                    "   WHERE od2.order_id = o.order_id " +
                    "   FOR XML PATH('')" +
                    "), 1, 2, '') AS fruit_names " +
                    "FROM Orders o " +
                    "JOIN OrderDetail od ON o.order_id = od.order_id " +
                    "GROUP BY o.order_id, o.customerName";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String customerName = rs.getString("customerName");
                int totalQuantity = rs.getInt("total_quantity");
                double totalAmount = rs.getDouble("total_amount");
                String fruitNames = rs.getString("fruit_names");

                // OrderSummary là class bạn tự tạo để chứa kết quả
                OrderSummary summary = new OrderSummary(customerName, totalQuantity, totalAmount, fruitNames);
                list.add(summary);
            }

            JDBC_Utils.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
