package com.resume.genius.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "skills")
public class Skill {

    @Id
    private String skillId;
    private String skill;

    // Constructors, getters, and setters
    public Skill() {}

    public Skill(String skillId, String skill) {
        this.skillId = skillId;
        this.skill = skill;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
}

