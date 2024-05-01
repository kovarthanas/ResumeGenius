package com.example.ResumeGenius.service;

import com.example.ResumeGenius.security.JwtAuthenticationFilter;
import com.example.ResumeGenius.security.JwtTokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import java.io.IOException;
import java.util.Collections;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JwtAuthenticationFilterTest {

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @Mock
    private UserDetailsService userDetailsService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private FilterChain filterChain;

    @InjectMocks
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Test
    public void testDoFilterInternal_ValidToken() throws ServletException, IOException {
        // Prepare test data
        String token = "validToken";
        String username = "testUser";
        UserDetails userDetails = new User(username, "", Collections.emptyList());

        // Mock behavior
        when(request.getHeader("Authorization")).thenReturn("Bearer " + token);
        when(jwtTokenProvider.validateToken(token)).thenReturn(true);
        when(jwtTokenProvider.getUsername(token)).thenReturn(username);
        when(userDetailsService.loadUserByUsername(username)).thenReturn(userDetails);

        // Call the method under test
        jwtAuthenticationFilter.doFilter(request,response,filterChain);

        // Verify the authentication token is set in the security context
        verify(filterChain).doFilter(request, response);
        verify(userDetailsService).loadUserByUsername(username);
        verify(jwtTokenProvider).validateToken(token);
        verify(jwtTokenProvider).getUsername(token);
        verify(request).getHeader("Authorization");
    }

}

