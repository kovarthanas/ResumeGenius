package com.resume.genius.repo;

import com.resume.genius.entity.CVStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CVStatusRepository extends JpaRepository<CVStatus, String> {
}