package com.example.ResumeGenius.controller;

import com.example.ResumeGenius.controller.UserController;
import com.example.ResumeGenius.entity.User;
import com.example.ResumeGenius.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private User testUser;

    @Before
    public void setup() {
        testUser = new User();
        // Initialize testUser as needed
    }

    @Test
    public void testSaveUser() {
        when(userService.saveUser(testUser)).thenReturn(testUser);

        ResponseEntity<User> responseEntity = userController.saveUser(testUser);

        assertEquals(testUser, responseEntity.getBody());
    }

    @Test
    public void testGetAllUsers() {
        List<User> userList = new ArrayList<>();
        userList.add(testUser);

        when(userService.getAllUsers()).thenReturn(userList);

        List<User> returnedUsers = userController.getAllUsers();

        assertEquals(userList, returnedUsers);
    }

    @Test
    public void testGetUserById() {
        Long userId = 1L;

        when(userService.getUserById(userId)).thenReturn(Optional.of(testUser));

        ResponseEntity<User> responseEntity = userController.getUserById(userId);

        assertEquals(testUser, responseEntity.getBody());
    }

    @Test
    public void testUpdateUser() {
        Long userId = 1L;

        when(userService.updateUser(userId, testUser)).thenReturn(testUser);

        ResponseEntity<User> responseEntity = userController.updateUser(userId, testUser);

        assertEquals(testUser, responseEntity.getBody());
    }

    @Test
    public void testDeleteUser() {
        Long userId = 1L;

        ResponseEntity<String> responseEntity = userController.deleteUser(userId);

        assertEquals("User deleted successfully", responseEntity.getBody());
        verify(userService, times(1)).deleteUser(userId);
    }
}

