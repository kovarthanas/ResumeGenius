package com.resume.genius.service;

import com.resume.genius.entity.CV;
import com.resume.genius.entity.CVQualifications;
import com.resume.genius.entity.CVQualificationsId;

import java.util.List;
import java.util.Optional;

public interface CVQualificationsService {

    List<CVQualifications> getAllCVQualifications();

    CVQualifications getCVQualificationsById(CV id);

    CVQualifications createCVQualifications(CVQualifications cvQualifications);

    CVQualifications updateCVQualifications(CV id, CVQualifications cvQualifications);

    void deleteCVQualifications(CV id);
}
