package com.resume.genius.repo;

import com.resume.genius.entity.CV;
import com.resume.genius.entity.CVQualifications;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVQualificationsRepository extends JpaRepository<CVQualifications, CV> {
}