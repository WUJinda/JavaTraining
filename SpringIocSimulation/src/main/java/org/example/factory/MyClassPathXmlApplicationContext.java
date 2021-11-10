package org.example.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.XPath;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 工厂接口实现类
 * 1.通过构造器的形参传递需要解析的配置文件
 * 2.解析配置文件，得到对应的bean标签的id与class属性值，并设置到对应的bean对象中，存放到集合里。
 * 3.遍历list集合，得到每一个bean对象，得到对应的class属性对应的实例化对象，并设置到map中，通过id与实例化bean对象
 * 4.通过getBean方法，从map对象中通过id获取指定val， val就是实例化对象
 */
public class MyClassPathXmlApplicationContext implements MyFactory{

    // 定义map对象，用来存放id属性与对应的class属性实例化好的bean对象
    private Map<String,Object> beanMap = new HashMap<>();
    // 定义集合list ，用来存放Mybean对象（mybean是用来存放配置文件中bean标签对应id，class的）
    private List<MyBean> beanList = null;
    public MyClassPathXmlApplicationContext(String filename){
        //解析配置文件
        parseXml(filename);
        //得到实例化对象
        instanceBean();
    }

    private void instanceBean() {
        // 判断
        if (beanList != null && beanList.size()>0){
            // 遍历beanList集合，得到对应Mybean对象
            for (MyBean myBean : beanList){
                // 得到id class值
                String id = myBean.getId();
                String clazz = myBean.getClazz();
                // 通过反射，实例化指定class属性对应的Mybean对象
                try {
                    Object object = Class.forName(clazz).newInstance();
//                    Object object = clazz.Mybean().newInstance();
                    // 将id值与实例化好的bean对象，设置到map中
                    beanMap.put(id,object);
                } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private void parseXml(String filename) {
        // 得到解析器
        SAXReader reader = new SAXReader();
        // 得到配置文件对应的Url
        URL url = this.getClass().getClassLoader().getResource(filename);
        // 解析配置文件，得到doucument对象
        try {
            Document document = reader.read(url);
            // 拿到具体对应标签, Xpath是获取XML文件中标签的语言
            XPath xPath = document.createXPath("beans/bean");
            // 得到对应的bean标签，返回集合element
            List<Element> elementList = xPath.selectNodes(document);
            // 集合基本的操作，判断并操作
            if(elementList != null && elementList.size()>0){
                // 实例化beanList集合
                beanList = new ArrayList<>();
                for(Element element : elementList){
                    // 拿到对应属性值
                    String id = element.attributeValue("id");
                    String clazz = element.attributeValue("class");
                    // 将属性设置到mybean对象中
                    MyBean myBean = new MyBean(id,clazz);
                    beanList.add(myBean);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Object getBean(String id) {
        //通过id属性，从map中获取对应的实例化对象
        Object object = beanMap.get(id);
        return null;
    }
}
