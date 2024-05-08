package com.resume.genius.controller;

import com.resume.genius.entity.Qualification;
import com.resume.genius.service.QualificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/qualifications")
public class QualificationController {

    @Autowired
    private QualificationService qualificationService;

    @GetMapping
    public List<Qualification> getAllQualifications() {
        return qualificationService.getAllQualifications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Qualification> getQualificationById(@PathVariable String id) {
        Optional<Qualification> qualification = qualificationService.getQualificationById(id);
        return qualification.map(value -> ResponseEntity.ok().body(value)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Qualification> createQualification(@RequestBody Qualification qualification) {
        Qualification createdQualification = qualificationService.createQualification(qualification);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdQualification);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Qualification> updateQualification(@PathVariable String id, @RequestBody Qualification qualification) {
        Qualification updatedQualification = qualificationService.updateQualification(id, qualification);
        return updatedQualification != null ? ResponseEntity.ok().body(updatedQualification) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQualification(@PathVariable String id) {
        qualificationService.deleteQualification(id);
        return ResponseEntity.noContent().build();
    }
}

