package com.resume.genius.controller;


import com.resume.genius.LoginMesage;
import com.resume.genius.dto.LoginDto;
import com.resume.genius.dto.UserDto;
import com.resume.genius.service.UserService;
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
    public String saveUser(@RequestBody UserDto userDTO) {
        String id = userService.addUser(userDTO);
        return "User Data Inserted Successfully";
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDTO) {
        LoginMesage loginResponse = userService.loginUser(loginDTO);
        return ResponseEntity.ok(loginResponse);
    }
}