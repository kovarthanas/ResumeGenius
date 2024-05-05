package com.resume.genius.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Entity
@Table(name = "cv_status")
public class CVStatus {

    @Id
    private String statusId;
    private String statusName;

    // Constructors, getters, and setters
    public CVStatus() {}

    public CVStatus(String statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

    public String getStatusId() {
        return statusId;
    }

    public void setStatusId(String statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
