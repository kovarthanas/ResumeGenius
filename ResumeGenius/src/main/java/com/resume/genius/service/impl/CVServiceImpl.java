package com.resume.genius.service.impl;

import com.resume.genius.entity.CV;
import com.resume.genius.repo.CVRepo;
import com.resume.genius.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CVServiceImpl implements CVService {

    @Autowired
    private CVRepo cvRepository;

    @Override
    public CV createCV(CV cv) {
        return cvRepository.save(cv);
    }

    @Override
    public CV getCVById(String cvId) {
        return cvRepository.findById(cvId).orElse(null);
    }

}

