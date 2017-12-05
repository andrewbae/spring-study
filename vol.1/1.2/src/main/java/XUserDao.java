import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * UserDao 를 상속 받아 추상 메소드 getConnection() 를 환경에 맞게 구현하여 Connection 객체를 리턴한다.
 */
public class XUserDao extends UserDao {
    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/springstudy?verifyServerCertificate=false&useSSL=true", "springstudy", "springstudy");

        return conn;
    }
}
