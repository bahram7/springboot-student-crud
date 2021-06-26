package com.example.springbootstudentcrud.controller;


import com.example.springbootstudentcrud.model.Student;
import com.example.springbootstudentcrud.service.IStudentService;
import com.example.springbootstudentcrud.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class StudentController {

    @Autowired
    private IStudentService studentService;


    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("listStudents", studentService.getAllStudents());
        return "index";
    }

    @GetMapping("/newStudent")
    public String newStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "new student";

    }


//    public String saveStudent(@ModelAttribute("student") Student student,MultipartFile file) {
//
//        studentService.saveStudent(student);
   //     return "redirect:/";


    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") Student student,
                                 @RequestParam("image") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        student.setPhotos(fileName);

        Student savedStudent = studentService.saveStudent(student);

        String uploadDir = "student-photos/" + savedStudent.getId();

        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);

        return "redirect:/";

    }



    @GetMapping("/updateForm/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {

        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "update student";


    }

    @GetMapping("/deleteStudent/{id}")
    public String deleteStudent(@PathVariable(value = "id") long id) {

        studentService.deleteStudentById(id);

        return "redirect:/";


    }

}
