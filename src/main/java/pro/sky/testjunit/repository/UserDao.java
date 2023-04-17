package pro.sky.testjunit.repository;

import pro.sky.testjunit.model.User;

import java.util.List;

public interface UserDao {
    User getUserByName(String name);

    List<User> findAllUsers();
}
