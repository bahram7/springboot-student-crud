package com.example.springbootstudentcrud.service;

import com.example.springbootstudentcrud.model.Student;
import com.example.springbootstudentcrud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements IStudentService {


    @Autowired
    private StudentRepository studentRepository;


    @Override
    public List<Student> getAllStudents() {

        return studentRepository.findAll();

    }

    @Override
    public Student saveStudent(Student student) {

        studentRepository.save(student);

        return student;
    }

    @Override
    public Student getStudentById(long id) {
        Optional<Student> optional = studentRepository.findById(id);
        Student student = null;
        if (optional.isPresent()) {

            student = optional.get();
        } else {
            throw new RuntimeException("student not found id:" + id);
        }
        return student;
    }

    @Override
    public void deleteStudentById(long id) {

        studentRepository.deleteById(id);


    }
}