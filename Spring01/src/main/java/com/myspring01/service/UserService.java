package com.myspring01.service;

import com.myspring01.dao.IUserDao;
import com.myspring01.dao.UserDao;
import com.myspring01.dao.UserDao01;

import javax.annotation.Resource;


public class UserService {

    /**
     * 实现Bean对象的自动注入
     * 1，默认会根据bean标签的id属性值查找(属性字段名与bean标签的id属性值相等)
     * 2，如果属性名名称未找到，则会根据类型(Class)查我
     * 3，属性字段可以提供set方法 也可以不提供
     * 4，注解可以声明在属性字段级别或set方法级别
     *
     * 5，可以设置注解的name属性，如果设别name属性，name属性的值必须与bean标签的id属性值保持一致
     * 6. 如果注入的是接口，接口只有一个实现类时，能正常注入，如果接口有多个实现类，则需要属性name设置id属性值
     */

    @Resource
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 注入接口
     */
    @Resource(name = "userDao01")
    private IUserDao iUserDao;


    public void test(){
        System.out.println("userService...");
        userDao.test();
        iUserDao.test();
    }
}
