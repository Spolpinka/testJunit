package pro.sky.testjunit.tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import pro.sky.testjunit.model.User;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class UserTestParams {

    public static Stream<Arguments> paramsForTests() {
        return Stream.of(
                Arguments.of("user1", "mail@mail.com"),
                Arguments.of("user2", "example@gmail.com"),
                Arguments.of("user3", "email@email.email.com")
        );
    }

    public static Stream<Arguments> wrongParams() {
        return Stream.of(
                Arguments.of("12345", "mail@mail"),
                Arguments.of("aaaaa", "mail.com"),
                Arguments.of("user", "example@.ru"),
                Arguments.of("newUser", "example")
        );
    }

    @ParameterizedTest
    @MethodSource("paramsForTests")
    public void testUserCreation(String login, String email) {
        User user = new User(login, email);
        assertEquals(login, user.getName());
        assertEquals(email, user.getEmail());
    }

    @ParameterizedTest
    @MethodSource("wrongParams")
    public void wrongEmailsTest(String login, String email) {
        assertThrows(IllegalArgumentException.class, () -> new User(login, email));
    }

}