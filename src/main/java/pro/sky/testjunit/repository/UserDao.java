package pro.sky.testjunit.repository;

import org.springframework.stereotype.Repository;
import pro.sky.testjunit.model.User;

import java.util.List;
@Repository
public interface UserDao {
    User getUserByName(String name);

    List<User> findAllUsers();
}
