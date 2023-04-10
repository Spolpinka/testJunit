package pro.sky.testjunit.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.testjunit.model.User;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.testjunit.constants.UserTestConstants.*;

public class UserTest {

    User first;
    User second;
    User emptyUser;

    @BeforeEach
    public void createNewUsers() {
        first = new User("login", "1234@2353.44");
        second = new User("login", "123444");
        emptyUser = new User();

    }

    @Test
    public void creatingFieldsUserTest() {
        String resultLogin = first.getLogin();
        String resultEmail = first.getEmail();
        assertTrue(resultLogin != null);
        assertTrue(resultEmail != null);

    }

    @Test
    public void defaultConstructorUserTest() {
        assertNotNull(emptyUser);
    }

    @Test
    public void isEmailCorrectTest() {
        assertTrue(first.getEmail().contains("@") && first.getEmail().contains("."));
    }

    @Test
    public void isLoginAndEmailEqualsTest() {
        assertNotEquals(first.getLogin(), first.getEmail());
    }

}
