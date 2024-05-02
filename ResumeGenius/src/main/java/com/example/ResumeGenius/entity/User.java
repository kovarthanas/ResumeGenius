package com.example.ResumeGenius.entity;

import jakarta.persistence.Table;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {

    @Id
    @Column(name = "user_id", length = 20)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name = "first_name", length = 45)
    private String firstName;

    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "password_hash", length = 4500)
    private String password;

    private String roleId;
    private String title;

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

    private String lastName;
    private String saltValue;
    private String cratedDate;
    private String modifiedDate;
    private String status;





    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public User() {
    }

    public User(int userId, String firstName, String email, String password, String roleId, String title, String lastName, String saltValue, String cratedDate, String modifiedDate, String status) {
        this.userId = userId;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.roleId = roleId;
        this.title = title;
        this.lastName = lastName;
        this.saltValue = saltValue;
        this.cratedDate = cratedDate;
        this.modifiedDate = modifiedDate;
        this.status = status;
    }
}

//create getters and setters