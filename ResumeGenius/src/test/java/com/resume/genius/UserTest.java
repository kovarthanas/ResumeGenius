package com.resume.genius;

import com.resume.genius.entity.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testConstructorAndGetters() {
        int userId = 1;
        String firstName = "John";
        String email = "john@example.com";
        String password = "password123";
        String roleId = "role1";
        String title = "Developer";
        String lastName = "Doe";
        String saltValue = "salt";
        String createdDate = "2024-05-02";
        String modifiedDate = "2024-05-02";
        String status = "active";

        User user = new User(userId, firstName, email, password, roleId, title, lastName, saltValue, createdDate, modifiedDate, status);

        assertEquals(userId, user.getUserId());
        assertEquals(firstName, user.getFirstName());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(roleId, user.getRoleId());
        assertEquals(title, user.getTitle());
        assertEquals(lastName, user.getLastName());
        assertEquals(saltValue, user.getSaltValue());
        assertEquals(createdDate, user.getCratedDate());
        assertEquals(modifiedDate, user.getModifiedDate());
        assertEquals(status, user.getStatus());
    }

    @Test
    public void testSetters() {
        User user = new User();

        int userId = 1;
        String firstName = "John";
        String email = "john@example.com";
        String password = "password123";
        String roleId = "role1";
        String title = "Developer";
        String lastName = "Doe";
        String saltValue = "salt";
        String createdDate = "2024-05-02";
        String modifiedDate = "2024-05-02";
        String status = "active";

        user.setUserId(userId);
        user.setFirstName(firstName);
        user.setEmail(email);
        user.setPassword(password);
        user.setRoleId(roleId);
        user.setTitle(title);
        user.setLastName(lastName);
        user.setSaltValue(saltValue);
        user.setCratedDate(createdDate);
        user.setModifiedDate(modifiedDate);
        user.setStatus(status);

        assertEquals(userId, user.getUserId());
        assertEquals(firstName, user.getFirstName());
        assertEquals(email, user.getEmail());
        assertEquals(password, user.getPassword());
        assertEquals(roleId, user.getRoleId());
        assertEquals(title, user.getTitle());
        assertEquals(lastName, user.getLastName());
        assertEquals(saltValue, user.getSaltValue());
        assertEquals(createdDate, user.getCratedDate());
        assertEquals(modifiedDate, user.getModifiedDate());
        assertEquals(status, user.getStatus());
    }
}

