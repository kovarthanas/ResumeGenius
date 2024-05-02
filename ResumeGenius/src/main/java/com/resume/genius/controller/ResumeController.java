package com.resume.genius.controller;


import com.resume.genius.entity.Resume;
import com.resume.genius.util.PdfOneGenerator;
import jakarta.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/resumes")
public class ResumeController {

    private static final Logger log = Logger.getLogger(ResumeController.class);

    @Autowired
    private PdfOneGenerator pdfGen;

    @PostMapping
    public ResponseEntity<String> postResume(@Valid @RequestBody Resume resume) throws IOException {

        log.info(resume.getHeader());
        log.info(resume.getExperience());
        log.info(resume.getEducation());
        log.info(resume.getProjects());
        log.info(resume.getSkills());
        return new ResponseEntity<String>(pdfGen.createDocument(resume), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<byte[]> getResume(@RequestParam("filename") String filename) throws IOException {

        return new ResponseEntity<byte[]>(pdfGen.getDocument(filename), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Resume>> getResumes(@RequestParam String sectorId,
                                                   @RequestParam(required = false) String eduLevel,
                                                   @RequestParam(required = false) String minGcse,
                                                   @RequestParam(required = false) String eduQualificationId,
                                                   @RequestParam(required = false) String profQualificationId,
                                                   @RequestParam(required = false) String skill,
                                                   @RequestParam(required = false) Integer experience) {

        log.info("Search Cvs for sectorId:" + sectorId + ", eduLevel" + eduLevel + ", minGcse"
                + minGcse + ", eduQualificationId" + eduQualificationId + ", profQualificationId" + profQualificationId
                + ", skill" + skill + ", experience" + experience);
        List<Resume> resumes = new ArrayList<>();
        return new ResponseEntity<>(resumes, HttpStatus.OK);
    }
}