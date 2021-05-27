package com.example.springbootstudentcrud.service;

import com.example.springbootstudentcrud.model.Student;
import com.example.springbootstudentcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements IStudentService{


    @Autowired
   private StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {

return studentRepository.findAll();

    }

    @Override
    public void saveStudent(Student student) {

        studentRepository.save(student);

    }
}
