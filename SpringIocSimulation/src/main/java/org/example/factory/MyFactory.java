package org.example.factory;

public interface MyFactory {
    // 通过id属性值获取实例化对象
    public Object getBean(String id);
}
