package pro.sky.testjunit.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.testjunit.model.User;
import pro.sky.testjunit.repository.impls.UserDaoImpl;
import pro.sky.testjunit.service.UserService;
import pro.sky.testjunit.service.impls.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


public class UserDaoTest {

    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserDaoImpl udi;
    User resultUser;
    User notExistedUser;

    @BeforeEach
    private void init() {
        udi = new UserDaoImpl();
        userService = new UserServiceImpl();
        resultUser = new User("MrFirst", "1234@1234.com");
        notExistedUser = new User("notExistedName", "1234@1234.com");
    }

    @Test
    public void getUserByNameTest() {
        User expectedUser = udi.getUserByName("MrFirst");

        assertEquals(expectedUser, resultUser);

        User nullUser = udi.getUserByName("notExistedName");
        assertNull(nullUser);
    }
}
