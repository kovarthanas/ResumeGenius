package com.example.ResumeGenius.service;

import com.example.ResumeGenius.dto.LoginDto;
import com.example.ResumeGenius.dto.RegisterDto;


public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}

