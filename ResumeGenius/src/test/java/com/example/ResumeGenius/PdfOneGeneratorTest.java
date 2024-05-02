package com.example.ResumeGenius;

import com.example.ResumeGenius.entity.Resume;
import com.example.ResumeGenius.util.PdfOneGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class PdfOneGeneratorTest {

    @Test
    public void testCreateDocument_Success() throws IOException {
        // Mock the Resume object
        Resume resume = Mockito.mock(Resume.class);

        // Mock the PdfOneGenerator class
        PdfOneGenerator pdfOneGenerator = Mockito.mock(PdfOneGenerator.class);

        // Mock the PdfOneGenerator method behavior
        when(pdfOneGenerator.createDocument(any(Resume.class))).thenReturn("Success");

        // Call the method under test
        String result = pdfOneGenerator.createDocument(resume);

        // Verify the result
        assertEquals("Success", result);
    }

    @Test
    public void testCreateDocument_Failure() throws IOException {
        // Mock the Resume object
        Resume resume = Mockito.mock(Resume.class);

        // Mock the PdfOneGenerator class
        PdfOneGenerator pdfOneGenerator = Mockito.mock(PdfOneGenerator.class);

        // Mock the PdfOneGenerator method behavior to throw IOException
        when(pdfOneGenerator.createDocument(any(Resume.class))).thenThrow(new IOException());

        // Call the method under test
        String result;
        try {
            result = pdfOneGenerator.createDocument(resume);
        } catch (IOException e) {
            result = "Failed";
        }

        // Verify the result
        assertEquals("Failed", result);
    }
}
