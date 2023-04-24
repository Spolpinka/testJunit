package pro.sky.testjunit.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.testjunit.model.User;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private String expectedLogin = "right login";
    private String expectedEmail = "just.new@email.subserver.com";

    User first;
    User second;
    User emptyUser;

    @BeforeEach
    public void createNewUsers() {
        first = new User(expectedLogin, expectedEmail);
        second = new User("User2 first name", "123444@234.rt");
        emptyUser = new User();

    }

    @Test
    public void creatingFieldsUserTest() {
        String resultLogin = first.getName();
        String resultEmail = first.getEmail();
        assertEquals(expectedLogin, resultLogin);
        assertEquals(expectedEmail, resultEmail);
    }

    @Test
    public void defaultConstructorUserTest() {
        assertNotNull(emptyUser);
        assertNull(emptyUser.getName());
        assertNull(emptyUser.getEmail());
    }

    @Test
    public void isEmailCorrectTest() {
        assertThrows(IllegalArgumentException.class, () -> new User("", expectedEmail));
        assertThrows(IllegalArgumentException.class, () -> new User("login", "incorrect email"));

    }

    @Test
    public void isLoginAndEmailEqualsTest() {
        assertNotEquals(first.getName(), first.getEmail());
        assertNotEquals(second.getName(), second.getEmail());
    }

}
