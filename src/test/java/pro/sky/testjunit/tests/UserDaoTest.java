package pro.sky.testjunit.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.testjunit.model.User;
import pro.sky.testjunit.repository.impls.UserDaoImpl;

import static org.junit.jupiter.api.Assertions.*;

public class UserDaoTest {

    private UserDaoImpl udi;
    @BeforeEach
    public void init() {
        udi = new UserDaoImpl();
    }
    @Test
    public void getUserByNameTest() {
        User expectedUser = udi.getUserByName("MrFirst");
        User resultUser = new User("MrFirst", "1234@1234.com");
        assertEquals(expectedUser, resultUser);

        User nullUser = udi.getUserByName("notExistedName");
        assertNull(nullUser);
    }


}
