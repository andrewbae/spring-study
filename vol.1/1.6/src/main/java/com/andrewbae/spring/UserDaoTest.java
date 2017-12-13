package com.andrewbae.spring;

import com.andrewbae.spring.dao.UserDao;
import com.andrewbae.spring.domain.User;
import com.andrewbae.spring.factory.DaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // DaoFactory를 직접 사용.
        DaoFactory factory = new DaoFactory();
        UserDao dao1 = factory.userDao();
        UserDao dao2 = factory.userDao();

        System.out.println("DaoFactory 직접 사용");
        System.out.println(dao1);
        System.out.println(dao2);
        System.out.println("dao1 == dao2: " + (dao1 == dao2));

        System.out.println("=========================================");

        // DaoFactory를 설정정보로 사용하는 애플리케이션 컨텍스트 생성.
        ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao dao3 = ctx.getBean("userDao", UserDao.class);
        UserDao dao4 = ctx.getBean("userDao", UserDao.class);

        System.out.println("애플리케이션 컨텍스트를 통해 DaoFactory 사용");
        System.out.println(dao3);
        System.out.println(dao4);
        System.out.println("dao1 == dao2: " + (dao3 == dao4));
    }
}
