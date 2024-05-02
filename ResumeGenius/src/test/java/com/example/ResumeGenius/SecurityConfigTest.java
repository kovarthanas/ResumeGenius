package com.example.ResumeGenius;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SecurityConfigTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void testPasswordEncoderBeanExists() {
        assertNotNull(passwordEncoder);
    }

    // Add more tests as needed

}
