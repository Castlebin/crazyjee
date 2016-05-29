package ch08.se05.service.impl;

import ch08.se05.bean.User;
import ch08.se05.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Cacheable("users")
@Service
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

    // 根据name、age清除users缓存区中的指定内容
    @CacheEvict("users")
    @Override
    public void evictUser(String name, int age) {
        System.out.println("--正在清除缓冲区中name: " + name + ", age: " + age + "对应的缓存内容--");
    }

    // 清除users缓存区中的所有内容
    @CacheEvict(value = "users", allEntries = true)
    @Override
    public void evictAll() {
        System.out.println("--正在清空整个缓存区内容--");
    }

}
