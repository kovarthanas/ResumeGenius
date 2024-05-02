package com.example.ResumeGenius.service;


import com.example.ResumeGenius.LoginMesage;
import com.example.ResumeGenius.dto.LoginDTO;
import com.example.ResumeGenius.dto.UserDTO;

public interface UserService {
    String addUser(UserDTO userDTO);

    LoginMesage loginUser(LoginDTO loginDTO);

}