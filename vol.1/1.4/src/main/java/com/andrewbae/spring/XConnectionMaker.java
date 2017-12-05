package com.andrewbae.spring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.andrewbae.spring.interfaces.ConnectionMaker;

/**
 * DB 정보에 맞는 커넥션 구현 후 리턴
 */
public class XConnectionMaker implements ConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection(
                "jdbc:mysql://localhost/springstudy?verifyServerCertificate=false&useSSL=true", "springstudy", "springstudy");
    }
}
