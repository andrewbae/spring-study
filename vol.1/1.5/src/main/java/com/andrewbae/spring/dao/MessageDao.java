package com.andrewbae.spring.dao;

import com.andrewbae.spring.domain.Message;
import com.andrewbae.spring.interfaces.ConnectionMaker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageDao {

    private ConnectionMaker mConnectionMaker;

    public MessageDao(ConnectionMaker connectionMaker) {
        this.mConnectionMaker = connectionMaker;
    }

    public void add(Message message) throws ClassNotFoundException, SQLException {
        Connection conn = mConnectionMaker.makeConnection();

        PreparedStatement ps = conn.prepareStatement("insert into messages_tb(id, title, msg) value(?, ?, ?)");
        ps.setString(1, message.getId());
        ps.setString(2, message.getTitle());
        ps.setString(3, message.getMsg());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }
}
