package com.example.ResumeGenius;

import com.example.ResumeGenius.controller.UserController;
import com.example.ResumeGenius.dto.LoginDTO;
import com.example.ResumeGenius.dto.UserDTO;
import com.example.ResumeGenius.service.UserService;
import com.example.ResumeGenius.LoginMesage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionUsageException;

import static java.lang.Boolean.TRUE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void testSaveUser() {
        UserDTO userDTO = new UserDTO(); // create a sample user DTO object
        String expectedResponse = "User Data Inserted Successfully"; // define your expected response

        when(userService.addUser(userDTO)).thenReturn("sampleId");

        String response = userController.saveUser(userDTO);

        assertEquals(expectedResponse, response);

        // Verify that userService's addUser method was called with the correct argument
        verify(userService, times(1)).addUser(userDTO);
    }

    @Test
    public void testLoginUser() {
        LoginDTO loginDTO = new LoginDTO(); // create a sample login DTO object
        LoginMesage loginMessage = new LoginMesage("Helllooo",TRUE); // create a sample login message object

        when(userService.loginUser(loginDTO)).thenReturn(loginMessage);

        ResponseEntity<?> responseEntity = userController.loginUser(loginDTO);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(loginMessage, responseEntity.getBody());

        // Verify that userService's loginUser method was called with the correct argument
        verify(userService, times(1)).loginUser(loginDTO);
    }
}

