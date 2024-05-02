package com.resume.genius.service;


import com.resume.genius.LoginMesage;
import com.resume.genius.dto.LoginDto;
import com.resume.genius.dto.UserDto;

public interface UserService {
    String addUser(UserDto userDTO);

    LoginMesage loginUser(LoginDto loginDTO);

}