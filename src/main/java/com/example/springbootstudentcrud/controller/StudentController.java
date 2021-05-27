package com.example.springbootstudentcrud.controller;


import com.example.springbootstudentcrud.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;

    //show student list
    @GetMapping("/")
    public String homePage(Model model){
    model.addAttribute("listStudents",studentService.getAllStudents());
    return "index";


    }
}
