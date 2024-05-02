package com.resume.genius;

import com.resume.genius.dto.LoginDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginDtoTest {

    @Test
    public void testConstructorAndGetters() {
        String email = "test@example.com";
        String password = "password123";

        LoginDto loginDTO = new LoginDto(email, password);

        assertEquals(email, loginDTO.getEmail());
        assertEquals(password, loginDTO.getPassword());
    }

    @Test
    public void testSetters() {
        String email = "test@example.com";
        String password = "password123";

        LoginDto loginDTO = new LoginDto();

        loginDTO.setEmail(email);
        loginDTO.setPassword(password);

        assertEquals(email, loginDTO.getEmail());
        assertEquals(password, loginDTO.getPassword());
    }
}
