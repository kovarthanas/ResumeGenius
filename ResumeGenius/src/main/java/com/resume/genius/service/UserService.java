package com.resume.genius.service;


import com.resume.genius.LoginMesage;
import com.resume.genius.dto.LoginDTO;
import com.resume.genius.dto.UserDTO;

public interface UserService {
    String addUser(UserDTO userDTO);

    LoginMesage loginUser(LoginDTO loginDTO);

}