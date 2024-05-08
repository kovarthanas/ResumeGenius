package com.resume.genius.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "cv_has_qualifications")
@IdClass(CVQualificationsId.class)
public class CVQualifications {

    @Id
    @ManyToOne
    @JoinColumn(name = "cv_id")
    private CV cv;

    @Id
    @ManyToOne
    @JoinColumn(name = "qualification_id")
    private Qualification qualification;

    private String gcsePass;

    // Constructors
    public CVQualifications() {}

    public CVQualifications(CV cv, Qualification qualification, String gcsePass) {
        this.cv = cv;
        this.qualification = qualification;
        this.gcsePass = gcsePass;
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

    public String getGcsePass() {
        return gcsePass;
    }

    public void setGcsePass(String gcsePass) {
        this.gcsePass = gcsePass;
    }
}
