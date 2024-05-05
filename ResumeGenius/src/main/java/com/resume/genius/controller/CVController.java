package com.resume.genius.controller;

import com.resume.genius.entity.CV;
import com.resume.genius.service.CVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cv")
public class CVController {

    @Autowired
    private CVService cvService;

    @PostMapping("/create")
    public ResponseEntity<CV> createCV(@RequestBody CV cv) {
        CV createdCV = cvService.createCV(cv);
        return new ResponseEntity<>(createdCV, HttpStatus.CREATED);
    }

    @GetMapping("/{cvId}")
    public ResponseEntity<CV> getCVById(@PathVariable String cvId) {
        CV cv = cvService.getCVById(cvId);
        if (cv != null) {
            return new ResponseEntity<>(cv, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
