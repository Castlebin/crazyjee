package ch07.se09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ch07.se09.bean.Person;

public class Application {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Person p1 = ctx.getBean("LiLei", Person.class);
        Person p2 = ctx.getBean("LiLei", Person.class);

        System.out.println(p1 == p2);
        p1.hunt();
        p2.hunt();
    }
}
