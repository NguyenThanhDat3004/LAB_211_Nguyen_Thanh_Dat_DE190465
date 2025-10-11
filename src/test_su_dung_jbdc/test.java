package test_su_dung_jbdc;

import java.sql.Connection;
import java.sql.SQLException;
public class test {
    public static void main(String[] args) {
        // buoc 1: tao ket noi
        Connection connection = null;
        try {
            connection = JDBC_Utils.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //
        JDBC_Utils.show(connection);
        // buoc 5: ngat ket noi
        JDBC_Utils.closeConnection(connection);
        System.out.println(connection);

    }
}
