package com.example.springbootstudentcrud.service;

import com.example.springbootstudentcrud.model.Student;

import java.util.List;

public interface IStudentService {

    List<Student> getAllStudents();
    void saveStudent (Student student);
    Student getStudentById(long id);
    void deleteStudentById(long id);
}
