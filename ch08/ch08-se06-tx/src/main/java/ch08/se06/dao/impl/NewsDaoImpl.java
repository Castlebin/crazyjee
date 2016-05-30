package ch08.se06.dao.impl;

import ch08.se06.dao.NewsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class NewsDaoImpl implements NewsDao {

    @Autowired
    private DataSource dataSource;

    @Override
    public void insert(String title, String content) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update("INSERT INTO news_inf(news_title, news_content) VALUES(?, ?)", title, content);
        // 两次插入相同title，违反数据库中的唯一约束
        jdbcTemplate.update("INSERT INTO news_inf(news_title, news_content) VALUES(?, ?)", title, content);
        // 如果没有事务管理的话，第一次将会插入成功
        // 有了事务管理，两次数据均不会插入到数据库中
    }

}
