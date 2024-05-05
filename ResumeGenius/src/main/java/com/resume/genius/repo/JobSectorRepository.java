package com.resume.genius.repo;

import com.resume.genius.entity.JobSector;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSectorRepository extends JpaRepository<JobSector, String> {
}