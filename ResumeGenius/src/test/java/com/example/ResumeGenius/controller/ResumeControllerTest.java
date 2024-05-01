package com.example.ResumeGenius.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;

import com.example.ResumeGenius.controller.ResumeController;
import com.example.ResumeGenius.entity.Header;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.ResumeGenius.entity.Resume;
import com.example.ResumeGenius.utils.PdfOneGenerator;

@RunWith(MockitoJUnitRunner.class)
public class ResumeControllerTest {

    @Mock
    private PdfOneGenerator pdfGenMock;

    @InjectMocks
    private ResumeController resumeController;

    private Resume testResume;

    @Before
    public void setup() {
        // Create a Header object
        Header header = new Header();

        // Set values using setters
        header.setName("John Doe");
        header.setAddress("123 Main St, Anytown, USA");
        header.setEmailAddress("john.doe@example.com");
        header.setPhoneNumber("123-456-7890");
        header.setGithub("https://github.com/johndoe");
        header.setLinkedin("https://www.linkedin.com/in/johndoe");
        header.setWebsite("https://www.johndoe.com");

        // Check values using getters
        assertEquals("John Doe", header.getName());
        assertEquals("123 Main St, Anytown, USA", header.getAddress());
        assertEquals("john.doe@example.com", header.getEmailAddress());
        assertEquals("123-456-7890", header.getPhoneNumber());
        assertEquals("https://github.com/johndoe", header.getGithub());
        assertEquals("https://www.linkedin.com/in/johndoe", header.getLinkedin());
        assertEquals("https://www.johndoe.com", header.getWebsite());
        // Initialize test data
        testResume = new Resume();
        testResume.setHeader(header);
        // Initialize other fields as needed for testing
    }

    @Test
    public void testPostResume() throws IOException {
        // Mock the behavior of pdfGen.createDocument()
        when(pdfGenMock.createDocument(testResume)).thenReturn("Test PDF Content");

        ResponseEntity<String> response = resumeController.postResume(testResume);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Test PDF Content", response.getBody());
    }

    @Test
    public void testGetResume() throws IOException {
        // Mock the behavior of pdfGen.getDocument()
        String testFileName = "test.pdf";
        byte[] testPdfContent = "Test PDF Content".getBytes();
        when(pdfGenMock.getDocument(testFileName)).thenReturn(testPdfContent);

        ResponseEntity<byte[]> response = resumeController.getResume(testFileName);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(testPdfContent, response.getBody());
    }
}

