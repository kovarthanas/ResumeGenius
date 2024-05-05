package com.resume.genius.service.impl;

import com.resume.genius.entity.Qualification;
import com.resume.genius.repo.QualificationRepository;
import com.resume.genius.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QualificationServiceImpl implements QualificationService {

    @Autowired
    private QualificationRepository qualificationRepository;

    @Override
    public List<Qualification> getAllQualifications() {
        return qualificationRepository.findAll();
    }

    @Override
    public Optional<Qualification> getQualificationById(String id) {
        return qualificationRepository.findById(Long.valueOf(id));
    }

    @Override
    public Qualification createQualification(Qualification qualification) {
        return qualificationRepository.save(qualification);
    }

    @Override
    public Qualification updateQualification(String id, Qualification qualification) {
        if (qualificationRepository.existsById(Long.valueOf(id))) {
            qualification.setQualificationId(Long.valueOf(id));
            return qualificationRepository.save(qualification);
        }
        return null; // Or throw an exception
    }

    @Override
    public void deleteQualification(String id) {
        qualificationRepository.deleteById(Long.valueOf(id));
    }
}
