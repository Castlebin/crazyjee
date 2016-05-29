package ch08.se04;

import ch08.se04.service.Hello;
import ch08.se04.service.World;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

        Hello hello = ctx.getBean(Hello.class);
        World world = ctx.getBean(World.class);

        hello.foo();
        hello.addUser("悟空", "778899");
        world.bar();
    }

}
