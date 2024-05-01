package com.example.ResumeGenius.service;

import com.example.ResumeGenius.entity.Role;
import com.example.ResumeGenius.entity.User;
import com.example.ResumeGenius.repository.UserRepository;
import com.example.ResumeGenius.security.CustomUserDetailsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomUserDetailsServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private CustomUserDetailsService customUserDetailsService;

    @Test
    public void testLoadUserByUsername_UsernameFound() {
        String usernameOrEmail = "testuser";
        Role role = new Role();
        role.setName("ROLE_USER");
        User user = new User();
        user.setEmail("test@example.com");
        user.setUsername("testuser");
        user.setPassword("testpassword");
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);

        when(userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)).thenReturn(Optional.of(user));

        // Call the method to test
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(usernameOrEmail);

        // Verify the result
        assertEquals(user.getEmail(), userDetails.getUsername());
        assertEquals(user.getPassword(), userDetails.getPassword());
        assertEquals(1, userDetails.getAuthorities().size());
        assertEquals("ROLE_USER", userDetails.getAuthorities().iterator().next().getAuthority());
    }

    @Test
    public void testLoadUserByUsername_UserNotFound() {
        // Prepare test data
        String usernameOrEmail = "nonexistentuser";

        when(userRepository.findByUsernameOrEmail(usernameOrEmail, usernameOrEmail)).thenReturn(Optional.empty());

        // Call the method to test and verify the exception
        UsernameNotFoundException exception = org.junit.jupiter.api.Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> customUserDetailsService.loadUserByUsername(usernameOrEmail)
        );
        assertEquals("User not found with username or email: " + usernameOrEmail, exception.getMessage());
    }
}
