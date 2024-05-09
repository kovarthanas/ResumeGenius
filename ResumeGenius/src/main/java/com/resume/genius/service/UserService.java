package com.resume.genius.service;

import com.resume.genius.dto.LoginMessage;
import com.resume.genius.dto.LoginDto;
import com.resume.genius.dto.UserDto;
import com.resume.genius.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String addUser(UserDto userDTO);

    LoginMessage loginUser(LoginDto loginDTO);

    List<User> getAllUsers();

    Optional<User> getUserById(int userId);

    User createUser(User user);

    User updateUser(int userId, User user);

    void deleteUser(int userId);

}