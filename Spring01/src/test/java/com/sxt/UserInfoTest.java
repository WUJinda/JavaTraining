package com.sxt;

import com.sxt.controller.UserinfoController;
import com.sxt.model.Resultinfo;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * JUnit 单元测试
 *      1. 不能是静态方法
 *      2. 不能有参数
 *      3. 放回值是void
 *      4.每个单元测试都需要设置Test注解
 */
public class UserInfoTest {

    @Test
    public void test01(){
        System.out.println("test01....");
    }

    @Test
    public void testLogin(){
        // 加载配置文件
        BeanFactory factory = new ClassPathXmlApplicationContext("spring04.xml");

        UserinfoController userinfoController = (UserinfoController) factory.getBean("userinfoController");
        Resultinfo resultinfo = userinfoController.userLogin("admin","123456");

        System.out.println(resultinfo);

    }
}
