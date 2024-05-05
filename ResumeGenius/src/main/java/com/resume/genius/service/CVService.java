package com.resume.genius.service;

import com.resume.genius.entity.CV;

public interface CVService {
    CV createCV(CV cv);
    CV getCVById(String cvId);

}
