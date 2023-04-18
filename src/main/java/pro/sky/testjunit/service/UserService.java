package pro.sky.testjunit.service;

import org.springframework.stereotype.Service;
import pro.sky.testjunit.model.User;
@Service
public interface UserService {
    boolean checkUserExist(User user);
}
