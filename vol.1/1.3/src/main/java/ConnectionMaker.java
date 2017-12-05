import java.sql.Connection;
import java.sql.SQLException;

/**
 * DB 커넥션 인터페이스
 * {@link XConnectionMaker 에서 구현}
 * {@link UserDao 에서 생성자 파라미터로 받음}
 */
public interface ConnectionMaker {
    Connection makeConnection() throws ClassNotFoundException, SQLException;
}
