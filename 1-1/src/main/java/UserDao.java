import java.sql.*;

public class UserDao {

    public void add(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/springstudy?verifyServerCertificate=false&useSSL=true", "springstudy", "springstudy");

        PreparedStatement ps = conn.prepareStatement("insert into users_tb(id, name, pwd) values(?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPwd());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost/springstudy?verifyServerCertificate=false&useSSL=true", "springstudy", "springstudy");

        PreparedStatement ps = conn.prepareStatement("select * from users_tb where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPwd(rs.getString("pwd"));

        rs.close();
        ps.close();
        conn.close();

        return user;
    }
}
