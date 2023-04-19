package pro.sky.testjunit.repository.impls;

import org.springframework.stereotype.Repository;
import pro.sky.testjunit.model.User;
import pro.sky.testjunit.repository.UserDao;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UserDaoImpl implements UserDao {
    private final List<User> users = new ArrayList<>();

    public UserDaoImpl() {
        users.add(new User("MrFirst", "1234@1234.com"));
        users.add(new User("MrSecond", "12345@12345.com"));
        users.add(new User("MrThird", "12346@12346.com"));
        users.add(new User("MrForth", "12347@712347.com"));
        users.add(new User("MrFirth", "12348@12348.com"));
    }

    @Override
    public User getUserByName(String name) {
        if (!name.isBlank() && !name.isEmpty()){
            for (User user :
                    users) {
                if (user.getName().equals(name)) {
                    return user;
                }
            }
        } else {
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return users;
    }
}
