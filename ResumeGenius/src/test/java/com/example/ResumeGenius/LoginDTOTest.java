package com.example.ResumeGenius;

import com.example.ResumeGenius.dto.LoginDTO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginDTOTest {

    @Test
    public void testConstructorAndGetters() {
        String email = "test@example.com";
        String password = "password123";

        LoginDTO loginDTO = new LoginDTO(email, password);

        assertEquals(email, loginDTO.getEmail());
        assertEquals(password, loginDTO.getPassword());
    }

    @Test
    public void testSetters() {
        String email = "test@example.com";
        String password = "password123";

        LoginDTO loginDTO = new LoginDTO();

        loginDTO.setEmail(email);
        loginDTO.setPassword(password);

        assertEquals(email, loginDTO.getEmail());
        assertEquals(password, loginDTO.getPassword());
    }
}
