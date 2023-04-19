package pro.sky.testjunit.service.impls;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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

    @BeforeEach
    public void init() {
    }

}