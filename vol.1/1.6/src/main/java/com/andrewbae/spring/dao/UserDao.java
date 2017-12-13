package com.andrewbae.spring.dao;

import com.andrewbae.spring.domain.User;
import com.andrewbae.spring.interfaces.ConnectionMaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private ConnectionMaker mConnectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.mConnectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection conn = mConnectionMaker.makeConnection();

        PreparedStatement ps = conn.prepareStatement("insert into users_tb(id, name, pwd) values(?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPwd());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Connection conn = mConnectionMaker.makeConnection();

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
