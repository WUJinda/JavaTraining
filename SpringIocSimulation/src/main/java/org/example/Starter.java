package org.example;

import org.example.dao.UserDao;
import org.example.factory.MyClassPathXmlApplicationContext;
import org.example.factory.MyFactory;
import org.example.service.UserService;

public class Starter {
    public static void main(String[] args) {
        // 得到工厂类
        MyFactory myFactory = new MyClassPathXmlApplicationContext("spring.xml");
        // 通过getBean方法得到bean对象
        UserService userService = (UserService) myFactory.getBean("userService");
        userService.test();

        UserDao userDao = (UserDao) myFactory.getBean("userDao");
        userDao.test();

    }
}
