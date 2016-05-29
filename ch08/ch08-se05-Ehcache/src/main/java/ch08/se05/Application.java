package ch08.se05;

import ch08.se05.bean.User;
import ch08.se05.service.UserService;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        UserService userService = ctx.getBean(UserService.class);
        User u1 = userService.getUserByNameAndAge("孙悟空", 500);
        User u2 = userService.getAnotherUser("孙悟空", 500);

        // 将输出true，表明缓存生效
        System.out.println(u1==u2);
    }

}
