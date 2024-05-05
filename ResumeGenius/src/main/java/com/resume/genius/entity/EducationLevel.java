package com.resume.genius.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "education_level")
public class EducationLevel {

    @Id
    private String edLevelId;
    private String levelName;

    // Constructors, getters, and setters
    public EducationLevel() {}

    public EducationLevel(String edLevelId, String levelName) {
        this.edLevelId = edLevelId;
        this.levelName = levelName;
    }

    public String getEdLevelId() {
        return edLevelId;
    }

    public void setEdLevelId(String edLevelId) {
        this.edLevelId = edLevelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}

