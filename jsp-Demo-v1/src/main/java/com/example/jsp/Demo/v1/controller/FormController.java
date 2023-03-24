package com.example.jsp.Demo.v1.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class FormController {

    @GetMapping("/showForm")
    public String displayForm(){
        return "form";
    }

    @PostMapping("/processForm")
    public String processForm(Model model,
                              @RequestParam String name
                              /*HttpServletRequest servletRequest*/){
//       String theName = servletRequest.getParameter("name");
       name=name.toUpperCase();
       String message = "wazzzuppp rp "+name;
       model.addAttribute("message",message);
       return "hello";
    }
}
