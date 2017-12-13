package com.andrewbae.spring.factory;

import com.andrewbae.spring.XConnectionMaker;
import com.andrewbae.spring.dao.MessageDao;
import com.andrewbae.spring.dao.UserDao;
import com.andrewbae.spring.interfaces.ConnectionMaker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 스프링에서 사용할 설정 정보
 */
@Configuration
public class DaoFactory {

    @Bean
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    @Bean
    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new XConnectionMaker();
    }
}
