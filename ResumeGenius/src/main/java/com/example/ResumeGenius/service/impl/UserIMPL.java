package com.example.ResumeGenius.service.impl;



import com.example.ResumeGenius.dto.LoginDTO;
import com.example.ResumeGenius.dto.UserDTO;
import com.example.ResumeGenius.repo.UserRepo;
import com.example.ResumeGenius.LoginMesage;
import com.example.ResumeGenius.entity.User;
import com.example.ResumeGenius.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class UserIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public String addUser(UserDTO userDTO) {
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
    UserDTO userDTO;

    @Override
    public LoginMesage loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginMesage("Login Success", true);
                } else {
                    return new LoginMesage("Login Failed", false);
                }
            } else {

                return new LoginMesage("password Not Match", false);
            }
        }else {
            return new LoginMesage("Email not exits", false);
        }


    }

}