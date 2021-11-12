package com.myspring.service;

import com.myspring.dao.TypeDao;

public class TypeService {
    //bean 对象
    private TypeDao typeDao;
    // 字符串类型
    private String host;
    // 整型
    private Integer port;



    /**
     *
     * set方法注入
     * 需要给属性字段提供set方法
     *
     *
     */
    /*public void setTypeDao(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public void test(){
        System.out.println("TypeService...");
        typeDao.test();
        System.out.println("Host: "+ host);
        System.out.println("Port: "+ port);
    }*/




    /**
     *
     * 构造器注入
     *
     */

   /* public TypeService(TypeDao typeDao) {
        this.typeDao = typeDao;
    }
    */
    public TypeService(TypeDao typeDao, String host, Integer port) {
        this.typeDao = typeDao;
        this.host = host;
        this.port = port;
    }


    public void test() {
        System.out.println("TypeService...");
        typeDao.test();

    }



}
