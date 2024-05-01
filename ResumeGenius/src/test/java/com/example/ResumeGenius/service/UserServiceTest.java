package com.example.ResumeGenius.service;

import com.example.ResumeGenius.entity.User;
import com.example.ResumeGenius.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testSaveUser() {
        // Prepare test data
        User user = new User();
        when(userRepository.save(user)).thenReturn(user);

        // Call the method under test
        User savedUser = userService.saveUser(user);

        // Verify the result
        assertEquals(user, savedUser);
        verify(userRepository).save(user);
    }

    @Test
    public void testGetAllUsers() {
        // Prepare test data
        User user = new User();
        when(userRepository.findAll()).thenReturn(Collections.singletonList(user));

        // Call the method under test
        List<User> users = userService.getAllUsers();

        // Verify the result
        assertEquals(1, users.size());
        assertEquals(user, users.get(0));
        verify(userRepository).findAll();
    }

    @Test
    public void testGetUserById() {
        // Prepare test data
        Long userId = 1L;
        User user = new User();
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));

        // Call the method under test
        Optional<User> result = userService.getUserById(userId);

        // Verify the result
        assertEquals(Optional.of(user), result);
        verify(userRepository).findById(userId);
    }

    @Test
    public void testUpdateUser() {
        // Prepare test data
        Long userId = 1L;
        User existingUser = new User();
        when(userRepository.findById(userId)).thenReturn(Optional.of(existingUser));
        when(userRepository.save(existingUser)).thenReturn(existingUser);

        // Call the method under test
        User updatedUser = userService.updateUser(userId, existingUser);

        // Verify the result
        assertEquals(existingUser, updatedUser);
        verify(userRepository).findById(userId);
        verify(userRepository).save(existingUser);
    }

    @Test
    public void testDeleteUser() {
        // Prepare test data
        Long userId = 1L;

        // Call the method under test
        userService.deleteUser(userId);

        // Verify the result
        verify(userRepository).deleteById(userId);
    }
}

