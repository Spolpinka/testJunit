package pro.sky.testjunit.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.testjunit.model.User;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.testjunit.constants.UserTestConstants.*;

public class UserTest {

    User first;
    User second;
    User emptyUser;

    @BeforeEach
    public void createNewUsers() {
        first = new User(EXPECTED_LOGIN, EXPECTED_EMAIL);
        second = new User(EXPECTED_LOGIN, "123444");
        emptyUser = new User();

    }

    @Test
    public void creatingFieldsUserTest() {
        String resultLogin = first.getLogin();
        String resultEmail = first.getEmail();
        assertEquals(EXPECTED_LOGIN, resultLogin);
        assertEquals(EXPECTED_EMAIL, resultEmail);
    }

    @Test
    public void defaultConstructorUserTest() {
        assertNotNull(emptyUser);
    }

    @Test
    public void isEmailCorrectTest() {
        assertTrue(first.getEmail().contains("@") && first.getEmail().contains("."));
        assertFalse(second.getEmail().contains("@") && second.getEmail().contains("."));
    }

    @Test
    public void isLoginAndEmailEqualsTest() {
        assertNotEquals(first.getLogin(), first.getEmail());
        assertNotEquals(second.getLogin(), second.getEmail());
    }

}
