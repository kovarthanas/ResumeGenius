package com.resume.genius.service;

import com.resume.genius.entity.Qualification;

import java.util.List;
import java.util.Optional;

public interface QualificationService {

    List<Qualification> getAllQualifications();

    Optional<Qualification> getQualificationById(String id);

    Qualification createQualification(Qualification qualification);

    Qualification updateQualification(String id, Qualification qualification);

    void deleteQualification(String id);
}
