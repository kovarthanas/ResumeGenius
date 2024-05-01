package com.example.ResumeGenius.service;

import com.example.ResumeGenius.dto.LoginDto;
import com.example.ResumeGenius.dto.RegisterDto;
import com.example.ResumeGenius.entity.Role;
import com.example.ResumeGenius.entity.User;
import com.example.ResumeGenius.exception.BlogAPIException;
import com.example.ResumeGenius.repository.RoleRepository;
import com.example.ResumeGenius.repository.UserRepository;
import com.example.ResumeGenius.security.JwtTokenProvider;
import com.example.ResumeGenius.service.AuthService;
import com.example.ResumeGenius.service.impl.AuthServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthServiceImplTest {

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RoleRepository roleRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @InjectMocks
    private AuthServiceImpl authService;

    @Test
    public void testLogin() {
        // Prepare test data
        String usernameOrEmail = "testuser";
        String password = "testpassword";
        String token = "testtoken";
        LoginDto loginDto = new LoginDto(usernameOrEmail, password);
        Authentication authentication = mock(Authentication.class);
        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(jwtTokenProvider.generateToken(authentication)).thenReturn(token);

        // Call the method under test
        String result = authService.login(loginDto);

        // Verify the result
        assertEquals(token, result);
        verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(jwtTokenProvider).generateToken(authentication);
    }

    @Test
    public void testRegister() {
        // Prepare test data
        RegisterDto registerDto = new RegisterDto("John Doe", "johndoe", "johndoe@example.com", "password");
        Role userRole = new Role(); // Create Role object without constructor argument
        userRole.setName("ROLE_USER"); // Set the name
        User user = new User();
        user.setUsername("johndoe");
        user.setEmail("johndoe@example.com");
        when(userRepository.existsByUsername("johndoe")).thenReturn(false);
        when(userRepository.existsByEmail("johndoe@example.com")).thenReturn(false);
        when(roleRepository.findByName("ROLE_USER")).thenReturn(Optional.of(userRole)); // Return Optional containing the Role
        when(passwordEncoder.encode("password")).thenReturn("encodedPassword");

        // Call the method under test
        String result = authService.register(registerDto);

        // Verify the result
        assertEquals("User registered successfully!.", result);
        verify(userRepository).save(any(User.class));
    }


    @Test
    public void testRegister_UsernameExists() {
        // Prepare test data
        RegisterDto registerDto = new RegisterDto("John Doe", "johndoe", "johndoe@example.com", "password");
        when(userRepository.existsByUsername("johndoe")).thenReturn(true);

        // Call the method under test and verify the exception
        BlogAPIException exception = assertThrows(
                BlogAPIException.class,
                () -> authService.register(registerDto)
        );
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatus());


    }

}