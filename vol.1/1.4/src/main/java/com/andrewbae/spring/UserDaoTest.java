package com.andrewbae.spring;

import com.andrewbae.spring.dao.UserDao;
import com.andrewbae.spring.domain.User;
import com.andrewbae.spring.factory.DaoFactory;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // 불필요한 코드가 사라짐
        UserDao dao = new DaoFactory().userDao();

        User user = new User();
        user.setId("andrewbae");
        user.setName("배상우");
        user.setPwd("sangwoo");

        dao.add(user);
        System.out.println(user.getId() + ": 등록 성공!");
        System.out.println("=============================");

        User user2 = dao.get("andrewbae");
        System.out.printf("id: %s\n", user2.getId());
        System.out.printf("name: %s\n", user2.getName());
        System.out.printf("pwd: %s\n", user2.getPwd());
        System.out.println("조회 성공!");
    }
}
