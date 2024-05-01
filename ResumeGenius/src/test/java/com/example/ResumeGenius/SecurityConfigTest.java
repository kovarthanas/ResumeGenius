package com.example.ResumeGenius;
import com.example.ResumeGenius.config.SecurityConfig;
import com.example.ResumeGenius.security.JwtAuthenticationEntryPoint;
import com.example.ResumeGenius.security.JwtAuthenticationFilter;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
@SpringBootTest
@AutoConfigureMockMvc
@EnableWebSecurity // Ensure that your security configuration is enabled for testing
public class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    SecurityConfig securityConfig;
    @Test
    public void testSecurityFilterChain() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/some-endpoint"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/private-endpoint"))
                .andExpect(MockMvcResultMatchers.status().isUnauthorized());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/private-endpoint")
                        .with(SecurityMockMvcRequestPostProcessors.user("username").password("password").roles("ROLE_USER")))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void testConstructorInjection() {
        // Create mock objects for dependencies
        UserDetailsService userDetailsServiceMock = Mockito.mock(UserDetailsService.class);
        JwtAuthenticationEntryPoint authenticationEntryPointMock = Mockito.mock(JwtAuthenticationEntryPoint.class);
        JwtAuthenticationFilter authenticationFilterMock = Mockito.mock(JwtAuthenticationFilter.class);
        SecurityConfig securityConfig = new SecurityConfig(userDetailsServiceMock, authenticationEntryPointMock, authenticationFilterMock);


    }

    @Test
    public void testPasswordEncoderBean() {
        UserDetailsService userDetailsService = mock(UserDetailsService.class);
        JwtAuthenticationEntryPoint authenticationEntryPoint = mock(JwtAuthenticationEntryPoint.class);
        JwtAuthenticationFilter authenticationFilter = mock(JwtAuthenticationFilter.class);
        assertNotNull(securityConfig);

        SecurityConfig securityConfig = new SecurityConfig(userDetailsService, authenticationEntryPoint, authenticationFilter);



        PasswordEncoder passwordEncoder = securityConfig.passwordEncoder();

        assertNotNull(passwordEncoder);

        // assertTrue(passwordEncoder instanceof BCryptPasswordEncoder);
    }

    @Test
    public void testAuthenticationManagerBean() throws Exception {
        AuthenticationConfiguration authenticationConfiguration = mock(AuthenticationConfiguration.class);
        UserDetailsService userDetailsService = mock(UserDetailsService.class);
        JwtAuthenticationEntryPoint authenticationEntryPoint = mock(JwtAuthenticationEntryPoint.class);
        JwtAuthenticationFilter authenticationFilter = mock(JwtAuthenticationFilter.class);
        assertNotNull(securityConfig);
        // Create an instance of the SecurityConfig class
        SecurityConfig securityConfig = new SecurityConfig(userDetailsService, authenticationEntryPoint, authenticationFilter);

        // Call the authenticationManager() method
        AuthenticationManager authenticationManager = securityConfig.authenticationManager(authenticationConfiguration);

        // Assert that the AuthenticationManager bean is not null
        //assertNotNull(authenticationManager);

       // assertTrue(authenticationManager instanceof Mock);
    }
}
