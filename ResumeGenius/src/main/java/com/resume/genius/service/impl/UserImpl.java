package com.resume.genius.service.impl;

import com.resume.genius.dto.LoginMessage;
import com.resume.genius.dto.LoginDto;
import com.resume.genius.dto.UserDto;
import com.resume.genius.entity.User;
import com.resume.genius.repo.UserRepo;
import com.resume.genius.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserImpl implements UserService {

    UserDto userDTO;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepo userRepository;

    @Override
    public String addUser(UserDto userDTO) {
        if (userDTO.getRoleId() == null) {
            userDTO.setRoleId("Admin");
        }
        if (userDTO.getTitle() == null) {
            userDTO.setTitle("Ms");
        }
        if (userDTO.getLastName() == null) {
            userDTO.setLastName("Last Name");
        }
        if (userDTO.getSaltValue() == null) {
            userDTO.setSaltValue("Salt");
        }
        if (userDTO.getCratedDate() == null) {
            userDTO.setCratedDate("Date Cre");
        }
        if (userDTO.getModifiedDate() == null) {
            userDTO.setModifiedDate("Mod Cre");
        }
        if (userDTO.getStatus() == null) {
            userDTO.setStatus("Active");
        }


        userDTO.setStatus("Active");
        User user = new User(
                userDTO.getUserid(),
                userDTO.getUsername(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                userDTO.getRoleId(),
                userDTO.getTitle(),
                userDTO.getLastName(),
                userDTO.getSaltValue(),
                userDTO.getCratedDate(),
                userDTO.getModifiedDate(),
                userDTO.getStatus()
        );


        userRepo.save(user);

        return user.getFirstName();
    }

    @Override
    public LoginMessage loginUser(LoginDto loginDTO) {
        String msg = "";
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginMessage("Login Success", true);
                } else {
                    return new LoginMessage("Login Failed", false);
                }
            } else {

                return new LoginMessage("password Not Match", false);
            }
        } else {
            return new LoginMessage("Email not exits", false);
        }


    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(int userId, User user) {
        if (userRepository.existsById(userId)) {
            user.setUserId(userId);
            return userRepository.save(user);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }

}