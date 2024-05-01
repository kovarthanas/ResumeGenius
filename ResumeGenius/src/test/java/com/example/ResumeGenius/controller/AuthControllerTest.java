package com.example.ResumeGenius.controller;


import com.example.ResumeGenius.controller.AuthController;
import com.example.ResumeGenius.dto.LoginDto;
import com.example.ResumeGenius.dto.RegisterDto;
import com.example.ResumeGenius.entity.Role;
import com.example.ResumeGenius.entity.User;
import com.example.ResumeGenius.repository.RoleRepository;
import com.example.ResumeGenius.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private AuthController authController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAuthenticateUser() {
        // Prepare test data
        LoginDto loginDto = new LoginDto();
        loginDto.setUsernameOrEmail("testuser");
        loginDto.setPassword("testpassword");

        Authentication authentication = mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        when(authenticationManager.authenticate(any(Authentication.class))).thenReturn(authentication);

        // Call the method to test
        ResponseEntity<String> responseEntity = authController.authenticateUser(loginDto);

        // Verify the result
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("User signed-in successfully!.", responseEntity.getBody());
    }

    @Test
    void testRegisterUser_Success() {
        // Prepare test data
        RegisterDto signUpDto = new RegisterDto();
        signUpDto.setName("Test User");
        signUpDto.setUsername("testuser");
        signUpDto.setEmail("test@example.com");
        signUpDto.setPassword("testpassword");

        Role role = new Role();
        role.setName("ROLE_ADMIN");

        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword("encodedPassword"); // Set an encoded password
        user.setRoles(Collections.singleton(role));

        when(userRepository.existsByUsername(signUpDto.getUsername())).thenReturn(false);
        when(userRepository.existsByEmail(signUpDto.getEmail())).thenReturn(false);
        when(roleRepository.findByName("ROLE_ADMIN")).thenReturn(Optional.of(role));
        when(passwordEncoder.encode(signUpDto.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Call the method to test
        ResponseEntity<?> responseEntity = authController.registerUser(signUpDto);

        // Verify the result
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("User registered successfully", responseEntity.getBody());
    }

}
