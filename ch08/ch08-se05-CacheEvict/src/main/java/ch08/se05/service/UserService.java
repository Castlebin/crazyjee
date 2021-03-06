package ch08.se05.service;

import ch08.se05.bean.User;

public interface UserService {

    User getUserByNameAndAge(String name, int age);

    User getAnotherUser(String name, int age);

    void evictUser(String name, int age);

    void evictAll();

}
