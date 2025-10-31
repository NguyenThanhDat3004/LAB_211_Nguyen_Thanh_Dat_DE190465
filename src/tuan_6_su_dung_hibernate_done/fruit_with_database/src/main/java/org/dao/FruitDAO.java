package org.dao;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Fruit;
import org.utills.HibernateUtill;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class FruitDAO implements DaoInterface<Fruit>{
    public static FruitDAO getInstance(){
        return new FruitDAO();
    }
    @Override
    public void add(Fruit fruit) throws SQLException {
        Transaction transaction = null;
        Session session = HibernateUtill.getSessionFactory().openSession();
        try{
            transaction = session.beginTransaction();
            session.save(fruit);
            transaction.commit();
            System.out.println("Create successfully");
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
           // session.close();
        }
    }
    @Override
    public int update(Fruit fruit) {
        int result;
        try {
            Connection co = JDBC_Utils.getConnection();
            String sql = "UPDATE Fruit " +
                    " SET name=?, origin=?, price=?, quantity=? " +
                    " WHERE fruit_id=?";
            PreparedStatement st = co.prepareStatement(sql);
            st.setString(1, fruit.getName());
            st.setString(2, fruit.getOrigin());
            st.setDouble(3, fruit.getPrice());
            st.setInt(4, fruit.getQuantity());
            st.setInt(5, fruit.getFruit_id());
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
    public int delete(Fruit fruit) {
        int result;
        try {
            Connection co = JDBC_Utils.getConnection();
            String sql = "DELETE FROM Fruit " +
                    "WHERE fruit_id=? ";
            PreparedStatement st = co.prepareStatement(sql);
            st.setInt(1,fruit.getFruit_id());
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
    public List<Fruit> selectAll() {
        List<Fruit> list = new ArrayList<>();
        // bat ngoai le
        try {
            Connection con = JDBC_Utils.getConnection();
            String sql = "SELECT * FROM Fruit";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("fruit_id");
                String name = rs.getString("name");
                String origin = rs.getString("origin");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                Fruit fruit1 = new Fruit(id,name,origin,price,quantity);
                list.add(fruit1);
            }
            // buoc 5: ngat ket noi
            JDBC_Utils.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
