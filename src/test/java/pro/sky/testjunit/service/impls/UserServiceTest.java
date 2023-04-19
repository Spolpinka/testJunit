package pro.sky.testjunit.service.impls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.testjunit.model.User;
import pro.sky.testjunit.repository.UserDao;
import pro.sky.testjunit.service.UserService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {
    private final UserDao daoMock = mock(UserDao.class);

    @Mock
    private UserDao daoMock1;

    @InjectMocks
    private UserServiceImpl out;

    private User user1;
    private User user2;
    private User notExistedUser;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        user1 = new User("MrFirst", "1234@1234.com");
        user2 = new User("MrSecond", "1234@1234.com");

        notExistedUser = new User("MrNotExisted", "mail@mail.com");

    }

    @Test
    public void checkUserExistTest() {
        when(daoMock.getUserByName("MrFirst")).thenReturn(user1);

        assertTrue(out.checkUserExist(user1));
        assertTrue(out.checkUserExist(user2));
        assertFalse(out.checkUserExist(notExistedUser));
    }
}