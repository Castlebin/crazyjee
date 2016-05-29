package ch08.se05;

import ch08.se05.bean.User;
import ch08.se05.service.UserService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 程序执行完spring容器无法关闭啦！
public class Application {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        UserService userService = ctx.getBean(UserService.class);
        User u1 = userService.getUserByNameAndAge("孙悟空", 500);
        User u2 = userService.getAnotherUser("孙悟空", 100);

        // 将输出true，表明缓存生效
        System.out.println(u1==u2);

        // getUser()方法中的参数名没有name，执行的话会报错
//        User u3 = userService.getUser("孙悟空");
        User u4 = userService.getByName("孙悟空");
//        System.out.println(u3==u4);
        System.out.println(u4==u2);


    }

}
