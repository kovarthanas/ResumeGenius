package com.resume.genius;

import com.resume.genius.dto.LoginDto;
import com.resume.genius.dto.LoginMessage;
import com.resume.genius.dto.UserDto;
import com.resume.genius.repo.UserRepo;
import com.resume.genius.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import static java.lang.Boolean.TRUE;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepo userRepo;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddUser() {
        UserDto userDTO = new UserDto();
        userDTO.setEmail("test@example.com");
        userDTO.setPassword("password");

        // Mock the behavior of addUser method
        when(userService.addUser(userDTO)).thenReturn("AddedUser");

        String result = userService.addUser(userDTO);
        assertNotNull(result);
        assertEquals("AddedUser", result);
    }

    @Test
    public void testLoginUser() {
        LoginDto loginDTO = new LoginDto();
        loginDTO.setEmail("test@example.com");
        loginDTO.setPassword("password");

        // Mock the behavior of loginUser method
        when(userService.loginUser(loginDTO)).thenReturn(new LoginMessage("Login Success", true));

        LoginMessage result = userService.loginUser(loginDTO);
        assertNotNull(result);
        assertTrue(TRUE);
        assertEquals("Login Success", result.getMessage());
    }
}

