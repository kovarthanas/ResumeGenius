package com.resume.genius.dto;

public class LoginDto {
    private String email;
    private String password;

    public LoginDto() {
    }

    public LoginDto(String email, String password) {
        this.email = email;
        this.password = password;
    } //create getters and setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}