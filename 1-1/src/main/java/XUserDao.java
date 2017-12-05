import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * UserDao 를 상속받아 환경에 맞게 getConnection() 메소드를 구현한다.
 */
public class XUserDao extends UserDao {

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/springstudy?verifyServerCertificate=false&useSSL=true", "springstudy", "springstudy");

        return conn;
    }
}
