package com.resume.genius;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.resume.genius.entity.Education;
import com.resume.genius.entity.Experience;
import com.resume.genius.entity.Header;
import com.resume.genius.entity.Project;
import com.resume.genius.util.PdfOneGenerator;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ResumeTestData {
    @Test
    public void contextLoads() {
        Document document = new Document();

        try {
            System.out.println("==========staring============");
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(new File("src/main/file/resume.pdf")));
            System.out.println("==========Pdf document is opened============");
            Header header = new Header();
            header.setName("SRITHAR KOVARTHTHANA");
            header.setAddress("CMB");
            header.setPhoneNumber("+94763427312");
            header.setEmailAddress("kovarththanas@gmail.com");
            header.setWebsite("kk.000webhostapp.com");
            header.setLinkedin("linkedin.com/in/skovarththana");
            header.setGithub("github.com/kovarththanas");

            Education ed1 = new Education();
            ed1.setDegree("Masters");
            ed1.setGpa("awaiting");
            ed1.setLocation("CMB");
            ed1.setMajors("Software Engineering");
            ed1.setName("Kingston University of London");
            ed1.setPeriod("Jan 2024 - Feb 2025");
            Education ed2 = new Education();
            ed2.setDegree("Bachelors");
            ed2.setGpa("3.9");
            ed2.setLocation("CMB");
            ed2.setMajors("Information Technology");
            ed2.setName("Horizon Campus");
            ed2.setPeriod("May 2018 - May 2022");

            ArrayList<Education> eduList = new ArrayList<>();
            eduList.add(ed1);
            eduList.add(ed2);


            ArrayList<Experience> expList = new ArrayList<>();

            Experience exp1 = new Experience();
            exp1.setCompany("Virtusa");
            exp1.setJobrole("Java Developer");
            exp1.setLocation("CMB");
            exp1.setPeriod("Jan 2020- 2021");


            ArrayList<String> resList = new ArrayList<String>();

            resList.add("Experience working in Agile development following Scrum process, Sprint and weekly standup meetings");
            resList.add("Developed DAOs using JPA, Hibernate Criteria API and also written complex HQL  and SQL queries ");
            resList.add("Configured and implemented Amazon Web Services such as SNS, SES and Ring Central API’s for notifications");
            resList.add("Performed Unit testing by implementing Junit test cases for ensuring code coverage");

            exp1.setResponsibilities(resList);

            Experience exp2 = new Experience();
            exp2.setCompany("IFS");
            exp2.setJobrole("Software Engineer");
            exp2.setLocation("CMB");
            exp2.setPeriod("Aug 2022- Present");

            ArrayList<String> resList2 = new ArrayList<String>();

            resList2.add("Developed Web application for Educational training website using Angular 6, Spring boot, Hibernate, SQL and AWS");
            resList2.add("Developed and Supported in the implementation of RESTful Services using Spring boot, Hibernate5 with JPA & SQL");
            resList2.add("Developed Reusable Angular Components using Typescript, NPM, HTML5 and Bootstrap");
            resList2.add("Developed and supported in building Angular Services integrating with REST API’s");

            exp2.setResponsibilities(resList2);

            expList.add(exp1);
            expList.add(exp2);

            HashMap<String, String> map = new HashMap<String, String>();
            map.put("PROGRAMMING LANGUAGES", "Java 1.8, Python, R");
            map.put("FRAMEWORKS", "Spring, Spring Boot, Hibernate, JPA, Angular 6, React JS, Tapestry");
            map.put("SCRIPTING LANGUAGES", "Java Script, Type Script, PHP");
            map.put("DATABASE", "Oracle 11g, MySQL, Firebase, Mongo DB, PlSQL");
            map.put("WEB DEVELOPMENT", "HTML5, JSP, JSTL, jQuery, CSS3 & Bootstrap");

            ArrayList<Project> prolist = new ArrayList<>();

            Project pro1 = new Project();
            pro1.setDescription("Developed e-commerce web application by integrating RESTful Services build using Spring boot, hibernate and MySQL  with Front-end components build using Angular 6, Typescript  ");
            pro1.setName("E-Commerce ");
            pro1.setTechnology("Typescript, Angular 6 , Bootstrap 4 and Web services were implemented using Spring, Hibernate with JPA and MySQL");


            Project pro2 = new Project();
            pro2.setDescription("Developed Mobile based Trip planner application for planning user trips more effectively");
            pro2.setName("Trip Planner");
            pro2.setTechnology("Java, Android Studio, Genymotion, Virtual Box, Firebase");

            prolist.add(pro1);
            prolist.add(pro2);

            document.open();
            PdfOneGenerator.addMetaData(document, header.getName());
            System.out.println("Adding meta data");
            PdfOneGenerator.addLayoutConfig(document);
            System.out.println("Adding page layout configurations");
            PdfOneGenerator.addLines(writer);
            PdfOneGenerator.addHeader(document, header);
            System.out.println("Adding header details");
            PdfOneGenerator.addEducation(document, eduList);
            System.out.println("Adding educational data");
            PdfOneGenerator.addExperience(document, expList);
            System.out.println("Adding professional experience");
            PdfOneGenerator.addSkills(document, map);
            System.out.println("Adding skill section");
            PdfOneGenerator.addProjects(document, prolist);
            System.out.println("Adding projects section");
            document.close();
            writer.close();
            System.out.println("==========Pdf created successfully============");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("==========Error while creating pdf============");
        }

    }

}
