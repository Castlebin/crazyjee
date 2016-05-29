package ch08.se05.service.impl;

import ch08.se05.bean.User;
import ch08.se05.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Cacheable(value = "users", key = "#name")// 这么配置，如果类方法中有的方法参数名称不包括name，执行它时就会报错
public class UserServiceImpl implements UserService {
    @Override
    public User getUserByNameAndAge(String name, int age) {
        System.out.println("---正在执行findUserByNameAndAge()查询方法---");
        return new User(name, age);
    }

    @Override
    public User getAnotherUser(String name, int age) {
        System.out.println("---正在执行getAnotherUser()查询方法---");
        return new User(name, age);
    }

    // 注意这里的参数名不叫name
    @Override
    public User getUser(String notName) {
        System.out.println("---正在执行getUser()查询方法---");
        User user = new User();
        user.setName(notName);
        return user;
    }

    @Override
    public User getByName(String name) {
        System.out.println("---正在执行getByName()查询方法---");
        User user = new User();
        user.setName(name);
        return user;
    }
}
