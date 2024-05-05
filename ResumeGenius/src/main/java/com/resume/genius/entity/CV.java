package com.resume.genius.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "cv")
public class CV {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cvId;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String contactNumber;
    private Date createdDate;
    private String currentDesignation;
    private Date dob;
    private String edLevelId;
    private int experience;
    private String gender;
    private String headline;
    private Date modifiedDate;
    private String photoLink;
    private String sectorId;
    private String skillId;
    private String statusId;
    private String userId;

    // Constructors
    public CV() {
    }

    public CV(Long cvId, String addressLine1, String addressLine2, String city, String contactNumber, Date createdDate,
              String currentDesignation, Date dob, String edLevelId, int experience, String gender, String headline,
              Date modifiedDate, String photoLink, String sectorId, String skillId, String statusId, String userId) {
        this.cvId = cvId;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.contactNumber = contactNumber;
        this.createdDate = createdDate;
        this.currentDesignation = currentDesignation;
        this.dob = dob;
        this.edLevelId = edLevelId;
        this.experience = experience;
        this.gender = gender;
        this.headline = headline;
        this.modifiedDate = modifiedDate;
        this.photoLink = photoLink;
        this.sectorId = sectorId;
        this.skillId = skillId;
        this.statusId = statusId;
        this.userId = userId;
    }
}

// Getters a
