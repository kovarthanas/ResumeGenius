package com.resume.genius.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    private String roleId;
    private String roleName;


}
