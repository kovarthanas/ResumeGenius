package com.resume.genius.controller;


import com.resume.genius.LoginMesage;
import com.resume.genius.dto.LoginDto;
import com.resume.genius.dto.UserDto;
import com.resume.genius.entity.User;
import com.resume.genius.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

        @GetMapping
        public List<User> getAllUsers() {
            return userService.getAllUsers();
        }

        @GetMapping("/{userId}")
        public ResponseEntity<User> getUserById(@PathVariable int userId) {
            Optional<User> user = userService.getUserById(userId);
            return user.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<User> createUser(@RequestBody User user) {
            User createdUser = userService.createUser(user);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        }

        @PutMapping("/{userId}")
        public ResponseEntity<User> updateUser(@PathVariable int userId, @RequestBody User user) {
            User updatedUser = userService.updateUser(userId, user);
            return updatedUser != null ? ResponseEntity.ok().body(updatedUser) : ResponseEntity.notFound().build();
        }

        @DeleteMapping("/{userId}")
        public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
            userService.deleteUser(userId);
            return ResponseEntity.noContent().build();
        }
}