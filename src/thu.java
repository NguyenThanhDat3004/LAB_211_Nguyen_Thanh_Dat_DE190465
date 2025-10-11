import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class thu {
    public static void main(String[] args) {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setUser("sa");
        ds.setPassword("30042005");
        ds.setServerName("THANHDAT");
        ds.setPortNumber(1433);
        ds.setDatabaseName("Tuan_5");

        ds.setEncrypt(true); // bật mã hóa
        ds.setTrustServerCertificate(true); // tin tưởng server certificate

        try (Connection conn = ds.getConnection()) {
            System.out.println("✅ Kết nối thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // gom 5 buoc :
        // buoc 1: tao ket noi
        // buoc 2: tao ra doi tuong statement
        // buoc 3: thuc thi mot cau lenh sql
        // buoc 4: xu li ket qua
        // buoc 5: ngat ket noi

    }
}
