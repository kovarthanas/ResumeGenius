package com.resume.genius.service.impl;

import com.resume.genius.entity.CV;
import com.resume.genius.entity.CVQualifications;
import com.resume.genius.entity.CVQualificationsId;
import com.resume.genius.repo.CVQualificationsRepository;
import com.resume.genius.service.CVQualificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CVQualificationsServiceImpl implements CVQualificationsService {

    @Autowired
    private CVQualificationsRepository cvQualificationsRepository;

    @Override
    public List<CVQualifications> getAllCVQualifications() {
        return cvQualificationsRepository.findAll();
    }

    @Override
    public CVQualifications getCVQualificationsById(CV id) {
        return cvQualificationsRepository.findById(id).orElse(null);
    }

    @Override
    public CVQualifications createCVQualifications(CVQualifications cvQualifications) {
        return cvQualificationsRepository.save(cvQualifications);
    }

    @Override
    public CVQualifications updateCVQualifications(CV id, CVQualifications cvQualifications) {
        if (cvQualificationsRepository.existsById(id)) {
            cvQualifications.setCv(cvQualifications.getCv());
            cvQualifications.setQualification(cvQualifications.getQualification());
            return cvQualificationsRepository.save(cvQualifications);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteCVQualifications(CV id) {
        cvQualificationsRepository.deleteById(id);
    }
}
