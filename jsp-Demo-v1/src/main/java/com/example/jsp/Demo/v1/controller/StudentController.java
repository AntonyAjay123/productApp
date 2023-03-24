package com.example.jsp.Demo.v1.controller;

import com.example.jsp.Demo.v1.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/student")
public class StudentController {
    @RequestMapping("/showform")
    public String showForm(Model model){
        Student student = new Student();
        log.info(student.getCountryOptions().toString());
        model.addAttribute("student",student);
        return "studentForm";
    }

    @RequestMapping("/processform")
    public String processForm(@ModelAttribute Student student){
        return "student-confirmation";
    }
}
