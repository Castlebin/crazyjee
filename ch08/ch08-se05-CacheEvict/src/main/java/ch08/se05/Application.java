package ch08.se05;

import ch08.se05.bean.User;
import ch08.se05.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 程序执行完spring容器无法关闭啦！
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        UserService us = ctx.getBean(UserService.class);

        // 第一次调用us对象的方法时会执行该方法，并缓存方法的结果
        User u1 = us.getUserByNameAndAge("孙悟空", 500);
        User u2 = us.getUserByNameAndAge("猪八戒", 400);

        // 清空指定内容
        us.evictUser("猪八戒", 400);
        // 由于缓存被清除，所以方法将重新执行
        User u3 = us.getUserByNameAndAge("猪八戒", 400);
        System.out.println(u2 == u3);// false

        User u4 = us.getUserByNameAndAge("孙悟空", 500);
        System.out.println(u1 == u4);// true，缓存还在

        // 清空整个缓冲区
        us.evictAll();
        // 由于整个缓存都已经被清空，因此下面两行代码都会重新执行
        User u5 = us.getAnotherUser("孙悟空", 500);
        User u6 = us.getAnotherUser("猪八戒", 400);
        System.out.println(u1 == u5); // 输出false
        System.out.println(u3 == u6); // 输出false
    }

}
