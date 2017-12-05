package com.andrewbae.spring.factory;

import com.andrewbae.spring.interfaces.ConnectionMaker;
import com.andrewbae.spring.XConnectionMaker;
import com.andrewbae.spring.dao.MessageDao;
import com.andrewbae.spring.dao.UserDao;

/**
 * 객체를 생성하는 쪽과 객체를 사용하는 쪽의 역할과 책임을 분리
 * 여기서는 커넥션 객체를 받아 dao 객체를 생성한다.
 */
public class DaoFactory {
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }

    /**
     * com.andrewbae.spring.interfaces.ConnectionMaker 객체 생성 코드를 분리함으로 DAO 가 여러개여도 변경 시 아래 메소드만 수정하면 적용됨.
     * @return com.andrewbae.spring.interfaces.ConnectionMaker
     */
    private ConnectionMaker connectionMaker() {
        return new XConnectionMaker();
    }
}
