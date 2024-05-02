package com.example.ResumeGenius;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoginMessageTest {

    @Test
    public void testConstructorAndGetters() {
        // Create a LoginMessage object using the constructor
        String expectedMessage = "Test message";
        Boolean expectedStatus = true;
        LoginMesage loginMessage = new LoginMesage(expectedMessage, expectedStatus);

        // Verify that the constructor initializes the fields correctly
        assertEquals(expectedMessage, loginMessage.getMessage());
        assertEquals(expectedStatus, loginMessage.getStatus());
    }

    @Test
    public void testSetters() {
        // Create a LoginMessage object
        LoginMesage loginMessage = new LoginMesage("Initial message", true);

        // Set new values using setters
        String newMessage = "New message";
        Boolean newStatus = false;
        loginMessage.setMessage(newMessage);
        loginMessage.setStatus(newStatus);

        // Verify that the setters update the fields correctly
        assertEquals(newMessage, loginMessage.getMessage());
        assertEquals(newStatus, loginMessage.getStatus());
    }
}
