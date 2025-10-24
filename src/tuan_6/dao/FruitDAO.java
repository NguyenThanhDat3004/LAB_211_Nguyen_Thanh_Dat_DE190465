package tuan_6.dao;
import tuan_6.model.Fruit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FruitDAO implements DAOInterface<Fruit> {
    public static FruitDAO getInstance(){
        return new FruitDAO();
    }

    @Override
    public int add(Fruit fruit) throws SQLException {
        int result;
        try {
            Connection co = tuan_6.dao.JDBCUtils.getConnection();
            String sql = "INSERT INTO Fruit(fruit_id,name,origin,price,quantity)" +
                    " VALUES (?,?,?,?,?)";
            PreparedStatement st = co.prepareStatement(sql);
            st.setString(1,fruit.getFruit_id());
            st.setString(2,fruit.getName());
            st.setString(3,fruit.getOrigin());
            st.setDouble(4,fruit.getPrice());
            st.setInt(5,fruit.getQuantity());
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
    public int update(Fruit fruit) {
        int result;
        try {
            Connection co = JDBCUtils.getConnection();
            String sql = "UPDATE Fruit " +
                    " SET name=?, origin=?, price=?, quantity=? " +
                    " WHERE fruit_id=?";
            PreparedStatement st = co.prepareStatement(sql);
            st.setString(1, fruit.getName());
            st.setString(2, fruit.getOrigin());
            st.setDouble(3, fruit.getPrice());
            st.setInt(4, fruit.getQuantity());
            st.setString(5, fruit.getFruit_id());
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
    public int delete(Fruit fruit) {
        int result;
        try {
            Connection co = JDBCUtils.getConnection();
            String sql = "DELETE FROM Fruit " +
                    "WHERE fruit_id=? ";
            PreparedStatement st = co.prepareStatement(sql);
            st.setString(1,fruit.getFruit_id());
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
    public List<Fruit> selectAll() {
        List<Fruit> list = new ArrayList<>();
        // bat ngoai le
        try {
            Connection con = JDBCUtils.getConnection();
            String sql = "SELECT * FROM Fruit";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("fruit_id");
                String name = rs.getString("name");
                String origin = rs.getString("origin");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                Fruit fruit = new Fruit(id,name,origin,price,quantity);
                list.add(fruit);
            }
            // buoc 5: ngat ket noi
            JDBCUtils.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
