package ${package}.usecases;


import ${package}.application.UserUsecase;
import ${package}.domain.exception.UserException;
import ${package}.domain.model.User;
import ${package}.domain.ports.UserRepository;
import ${package}.domain.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserUsecaseTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;
    private UserUsecase userUsecase;

    private final User user = new User();

    @BeforeEach
    public void setUp() {
        userUsecase = new UserUsecase(userService);
        user.setId(1L);
        user.setAddress("Calle falsa");
        user.setName("Carlos");
        user.setPhone("1234");
        user.setCompany("bds");
        user.setWebsite("google.com.ar");
    }

    @Test
    public void findUserByIdTest() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        assertEquals("Carlos", userUsecase.getUser(1L).getName());
    }

    @Test
    public void notFoundUser() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(UserException.class,() -> userUsecase.getUser(2L));
    }


}
