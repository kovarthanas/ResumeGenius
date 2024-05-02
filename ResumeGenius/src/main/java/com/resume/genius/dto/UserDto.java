package com.resume.genius.dto;

public class UserDto {

    private int userid;
    private String username;
    private String email;
    private String password;

    public UserDto(int userid, String username, String email, String password, String lastName, String saltValue, String cratedDate, String modifiedDate, String status, String roleId, String title) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
        this.lastName = lastName;
        this.saltValue = saltValue;
        this.cratedDate = cratedDate;
        this.modifiedDate = modifiedDate;
        this.status = status;
        this.roleId = roleId;
        this.title = title;
    }

    private String lastName;
    private String saltValue;
    private String cratedDate;
    private String modifiedDate;
    private String status;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSaltValue() {
        return saltValue;
    }

    public void setSaltValue(String saltValue) {
        this.saltValue = saltValue;
    }

    public String getCratedDate() {
        return cratedDate;
    }

    public void setCratedDate(String cratedDate) {
        this.cratedDate = cratedDate;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String roleId;
    private String title;
    public UserDto() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

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

    public UserDto(int userid, String username, String email, String password) {
        this.userid = userid;
        this.username = username;
        this.email = email;
        this.password = password;
    }
} //create getters and setters
