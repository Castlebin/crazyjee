package ch08.se05.service;

import ch08.se05.bean.User;

public interface UserService {

    User getUserByNameAndAge(String name, int age);

    User getAnotherUser(String name, int age);

    User getUser(String notName);

    User getByName(String name);

}
