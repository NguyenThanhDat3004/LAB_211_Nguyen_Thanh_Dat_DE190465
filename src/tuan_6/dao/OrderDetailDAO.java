package tuan_6.dao;
import tuan_5.quanLiKhoaHoc.dao.JDBCUtils;
import tuan_6.model.Fruit;
import tuan_6.model.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDAO implements DAOInterface<OrderDetail>{

    @Override
    public int add(OrderDetail orderDetail) throws SQLException {
        int result = 0;
        try{
            Connection co = tuan_5.quanLiKhoaHoc.dao.JDBCUtils.getConnection();
            String sql = "INSERT INTO OrderDetail(fruit_id,order_id,quantity,amount)" +
                    " VALUES (?,?,?,?)";
            PreparedStatement st = co.prepareStatement(sql);
            st.setString(1,orderDetail.getFruit().getFruit_id());
            st.setInt(2,orderDetail.getOrdersId());
            st.setInt(3,orderDetail.getQuantity());
            st.setDouble(4,orderDetail.getAmount());
            result = st.executeUpdate(); // tra ve so luong dong bi thay doi
            System.out.println("You excuted: " + sql);
            System.out.println("Have " + result + " changed");
            JDBCUtils.closeConnection(co);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public int update(OrderDetail orderDetail) {
        int result;
        try {
            Connection co = JDBCUtils.getConnection();
            String sql = "UPDATE OrderDetail " +
                    " SET fruit_id=?, orders_id=?, quantity=?, amount=? " +
                    " WHERE orders_id=?";
            PreparedStatement st = co.prepareStatement(sql);
            st.setString(1, orderDetail.getFruit().getFruit_id());
            st.setInt(2, orderDetail.getOrdersId());
            st.setInt(3, orderDetail.getQuantity());
            st.setDouble(4, orderDetail.getAmount());
            st.setInt(5, orderDetail.getOrdersId());
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
    public int delete(OrderDetail orderDetail) {
        int result;
        try {
            Connection co = JDBCUtils.getConnection();
            String sql = "DELETE FROM OrderDetail " +
                    "WHERE orders_id=? ";
            PreparedStatement st = co.prepareStatement(sql);
            st.setInt(1,orderDetail.getOrdersId());
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
    public List<OrderDetail> selectAll() {
        List<OrderDetail> list = new ArrayList<>();
        // bat ngoai le
        try {
            Connection con = JDBCUtils.getConnection();
            String sql = """
            SELECT od.fruit_id, f.fruit_name, f.origin, od.orders_id, od.quantity, od.amount
            FROM OrderDetail od
            JOIN Fruit f ON od.fruit_id = f.fruit_id
        """; // dung """ de viet chuoi nhieu dong thay vi + tung chuoi
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String id = rs.getString("fruit_id");
                String name = rs.getString("name");
                String origin = rs.getString("origin");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                int ordersId = rs.getInt("orders_id");
                int quantityOrder = rs.getInt("quantity");
                double amount = rs.getDouble("amount");
                OrderDetail o = new OrderDetail(new Fruit(id,name,origin,price,quantity),quantityOrder,ordersId,amount);
                list.add(o);
            }
            // buoc 5: ngat ket noi
            JDBCUtils.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
