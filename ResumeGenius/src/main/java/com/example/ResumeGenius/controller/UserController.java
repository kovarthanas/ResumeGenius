package com.example.ResumeGenius.controller;


import com.example.ResumeGenius.dto.LoginDTO;
import com.example.ResumeGenius.dto.UserDTO;
import com.example.ResumeGenius.service.UserService;
import com.example.ResumeGenius.LoginMesage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping(path = "/signup")
    public String saveUser(@RequestBody UserDTO userDTO)
    {
        String id = userService.addUser(userDTO);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO)
    {
        LoginMesage loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}