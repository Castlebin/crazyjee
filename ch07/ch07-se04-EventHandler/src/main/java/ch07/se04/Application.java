package ch07.se04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch07.se04.event.EmailEvent;

public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        // 创建事件
        EmailEvent emailEvent = new EmailEvent("this", "test@test.com", "This is a test email.");
        // 发布事件
        ctx.publishEvent(emailEvent);
    }

}
