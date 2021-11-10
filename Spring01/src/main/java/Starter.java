import com.myspring.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {
    public static void main(String[] args) {
        // 加载spring的上下文环境， 与ApplicationContext有关。
        // 代表springIOC容器并负责实例化，配置和组装bean。
        // 是拿取其他东西的前提。

        // 子接口 ApplicationContext
        // 父接口 BeanFactory
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        // 能看到他的实现类，继承父类：ApplicationContext
        // 这是当前环境的上下文环境。
        // 需要有配置信息才能根据上下文环境提供想要的对象。

        //02
        // 得到需要实例化的对象。
        UserService userService = (UserService) ac.getBean("userService"); // getBean（）方法中的参数是ID
        // 因为返回的是一个object类型，前后对应，强制转换一下类型。
        // 当执行getBean()方法时，会根据配置文件spring.xml用IOC底层实例化好，之后即可拿到Bean对象。


        //03
        // 调用方法以证明以上被实例化，如果能成功运行，则证明环境已经成功建立。
        userService.test();

    }
}
