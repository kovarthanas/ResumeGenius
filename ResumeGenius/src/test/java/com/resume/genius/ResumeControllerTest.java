package com.resume.genius;

import com.resume.genius.controller.ResumeController;
import com.resume.genius.entity.Resume;
import com.resume.genius.util.PdfOneGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ResumeControllerTest {

    @Mock
    private PdfOneGenerator pdfGen;

    @InjectMocks
    private ResumeController resumeController;

    @Test
    public void testPostResume() throws IOException {
        Resume resume = new Resume(); // create a sample resume object
        String expectedResponse = "Sample PDF Content"; // define your expected PDF content

        when(pdfGen.createDocument(resume)).thenReturn(expectedResponse);

        ResponseEntity<String> responseEntity = resumeController.postResume(resume);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResponse, responseEntity.getBody());

        // Verify that PdfOneGenerator's createDocument method was called with the correct argument
        verify(pdfGen, times(1)).createDocument(resume);
    }

    @Test
    public void testGetResume() throws IOException {
        String filename = "sample.pdf"; // sample filename
        byte[] expectedContent = "Sample PDF Content".getBytes(); // sample PDF content

        when(pdfGen.getDocument(filename)).thenReturn(expectedContent);

        ResponseEntity<byte[]> responseEntity = resumeController.getResume(filename);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedContent, responseEntity.getBody());

        // Verify that PdfOneGenerator's getDocument method was called with the correct argument
        verify(pdfGen, times(1)).getDocument(filename);
    }
}
