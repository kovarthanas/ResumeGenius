package com.resume.genius.repo;


import com.resume.genius.entity.CV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVRepo extends JpaRepository<CV, String> {

}