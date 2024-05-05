package com.resume.genius.controller;
import com.resume.genius.entity.CV;
import com.resume.genius.entity.CVQualifications;
import com.resume.genius.entity.CVQualificationsId;
import com.resume.genius.service.CVQualificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cv-qualifications")
public class CVQualificationsController {

    @Autowired
    private CVQualificationsService cvQualificationsService;

    @GetMapping
    public List<CVQualifications> getAllCVQualifications() {
        return cvQualificationsService.getAllCVQualifications();
    }

    @GetMapping("/{cvId}/{qualificationId}")
    public ResponseEntity<CVQualifications> getCVQualificationsById(@PathVariable int cvId, @PathVariable int qualificationId) {
        CV id = new CV();
        // set CV and Qualification objects based on id
        CVQualifications cvQualifications = cvQualificationsService.getCVQualificationsById(id);
        return cvQualifications != null ? ResponseEntity.ok().body(cvQualifications) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<CVQualifications> createCVQualifications(@RequestBody CVQualifications cvQualifications) {
        CVQualifications createdCVQualifications = cvQualificationsService.createCVQualifications(cvQualifications);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCVQualifications);
    }

    @PutMapping("/{cvId}/{qualificationId}")
    public ResponseEntity<CVQualifications> updateCVQualifications(@PathVariable int cvId, @PathVariable int qualificationId, @RequestBody CVQualifications cvQualifications) {
        CV id = new CV();
        // set CV and Qualification objects based on id
        CVQualifications updatedCVQualifications = cvQualificationsService.updateCVQualifications(id, cvQualifications);
        return updatedCVQualifications != null ? ResponseEntity.ok().body(updatedCVQualifications) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{cvId}/{qualificationId}")
    public ResponseEntity<Void> deleteCVQualifications(@PathVariable int cvId, @PathVariable int qualificationId) {
        CV id = new CV();
        // set CV and Qualification objects based on id
        cvQualificationsService.deleteCVQualifications(id);
        return ResponseEntity.noContent().build();
    }
}
