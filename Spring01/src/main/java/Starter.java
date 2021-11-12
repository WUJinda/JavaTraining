import com.myspring.service.TypeService;
import com.myspring01.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Starter {

    /*
    public static void main(String[] args) {
        // 加载spring的上下文环境， 与ApplicationContext有关。
        // 代表springIOC容器并负责实例化，配置和组装bean。
        // 是拿取其他东西的前提。

        // 子接口 ApplicationContext
        // 父接口 BeanFactory
        // ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        // 能看到他的实现类，继承父类：ApplicationContext
        // 这是当前环境的上下文环境。
        // 需要有配置信息才能根据上下文环境提供想要的对象。
        // 绝对路径加载配置文件：
        //ApplicationContext ac = new FileSystemXmlApplicationContext("F:\\ForGithub\\JavaTraining\\Spring01\\src\\main\\resources\\spring.xml");
        //02
        // 得到需要实例化的对象。
        // UserService userService = (UserService) ac.getBean("userService"); // getBean（）方法中的参数是ID
        // 因为返回的是一个object类型，前后对应，强制转换一下类型。
        // 当执行getBean()方法时，会根据配置文件spring.xml用IOC底层实例化好，之后即可拿到Bean对象。


        //03
        // 调用方法以证明以上被实例化，如果能成功运行，则证明环境已经成功建立。
        // userService.test();

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring.xml");

        TypeService typeService = (TypeService) beanFactory.getBean("typeService");

        typeService.test();

    }*/


    /**
     * for spring01
     */

    public static void main(String[] args) {

        BeanFactory factory = new ClassPathXmlApplicationContext("spring01.xml");

        UserService userService = (UserService) factory.getBean("userService");
        userService.test();

    }
}
