package pro.sky.testjunit.service.impls;

import pro.sky.testjunit.model.User;
import pro.sky.testjunit.repository.impls.UserDaoImpl;
import pro.sky.testjunit.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDaoImpl userDaoImpl;

    public UserServiceImpl() {
        userDaoImpl = new UserDaoImpl();
    }

    @Override
    public boolean checkUserExist(User user) {
        if (userDaoImpl.getUserByName(user.getName()) == null) {
            return false;
        } else {
            return true;
        }
    }
}
