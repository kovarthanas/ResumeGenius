package com.resume.genius.entity;

import java.io.Serializable;
import java.util.Objects;
import java.io.Serializable;
import java.util.Objects;

public class CVQualificationsId implements Serializable {

    private CV cv;
    private Qualification qualification;

    // Constructors
    public CVQualificationsId() {
    }

    public CVQualificationsId(CV cv, Qualification qualification) {
        this.cv = cv;
        this.qualification = qualification;
    }

    // Getters and Setters
    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CVQualificationsId that = (CVQualificationsId) o;
        return Objects.equals(cv, that.cv) &&
                Objects.equals(qualification, that.qualification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cv, qualification);
    }
}
