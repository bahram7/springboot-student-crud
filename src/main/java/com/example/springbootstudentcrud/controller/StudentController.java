package com.example.springbootstudentcrud.controller;


import com.example.springbootstudentcrud.model.Student;
import com.example.springbootstudentcrud.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;

    //show student list
    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("listStudents", studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/newStudent")
    public String newStudent(Model model){
        Student student=new Student();
    model.addAttribute("student",student);
    return "new student";

    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student){
//save to DB

        studentService.saveStudent(student);
        return "redirect:/";

    }


    @GetMapping("/updateForm/{id}")
public String updateForm (@PathVariable(value = "id") long id,Model model){

Student student=studentService.getStudentById(id);
model.addAttribute("student",student);
return "update student";


    }

}
