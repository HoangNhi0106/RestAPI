package com.example.nashtech.restapi.service;

import com.example.nashtech.restapi.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> retrieveStudents();

    public Student getStudent(Integer sid);

    public Student saveStudent(Student student);

    public void deleteStudent(Integer sid);

    public void updateStudent(Student student);

    public boolean isExistStudent(Student student);
}
