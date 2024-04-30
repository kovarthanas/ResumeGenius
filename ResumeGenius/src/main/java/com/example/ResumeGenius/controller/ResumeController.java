package com.example.ResumeGenius.controller;


import com.example.ResumeGenius.entity.Resume;
import com.example.ResumeGenius.utils.PdfOneGenerator;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class ResumeController {

    private static final Logger log = Logger.getLogger(ResumeController.class);

    @Autowired
    private PdfOneGenerator pdfGen;

    @PostMapping(path = "/resume")
    public ResponseEntity<String> postResume(@Valid @RequestBody Resume resume) throws IOException {

        log.info(resume.getHeader());
        log.info(resume.getExperience());
        log.info(resume.getEducation());
        log.info(resume.getProjects());
        log.info(resume.getSkills());
        return new ResponseEntity<String>(pdfGen.createDocument(resume), HttpStatus.OK);
    }

    @GetMapping(path = "/resumef")
    public ResponseEntity<byte[]> getResume(@RequestParam("filename") String filename) throws IOException {

        return new ResponseEntity<byte[]>(pdfGen.getDocument(filename), HttpStatus.OK);
    }
}
