package com.resume.genius.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    private String id;
    private String name;

    // Constructors, getters, and setters
    public Role() {}

    public Role(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
