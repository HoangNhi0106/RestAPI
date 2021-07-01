package com.example.nashtech.restapi.service.impl;

import com.example.nashtech.restapi.entity.Student;
import com.example.nashtech.restapi.repository.StudentRepository;
import com.example.nashtech.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceimpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> retrieveStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(Integer sid) {
        return studentRepository.findById(sid).get();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer sid) {
        studentRepository.deleteById(sid);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }
}
