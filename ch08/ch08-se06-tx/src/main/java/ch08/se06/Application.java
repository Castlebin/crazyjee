package ch08.se06;

import ch08.se06.dao.NewsDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        NewsDao newsDao = ctx.getBean(NewsDao.class);
        newsDao.insert("Love", "Love is Hard.");
    }

}
