package ch08.se05.service.impl;

import ch08.se05.bean.User;
import ch08.se05.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Cacheable("users1")
    @Override
    public User getUserByNameAndAge(String name, int age) {
        System.out.println("---正在执行findUserByNameAndAge()查询方法---");
        return new User(name, age);
    }

    @Cacheable("users2")
    @Override
    public User getAnotherUser(String name, int age) {
        System.out.println("---正在执行getAnotherUser()查询方法---");
        return new User(name, age);
    }
}
