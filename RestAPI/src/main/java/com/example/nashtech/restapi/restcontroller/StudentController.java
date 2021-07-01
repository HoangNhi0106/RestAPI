package com.example.nashtech.restapi.restcontroller;

import com.example.nashtech.restapi.entity.Student;
import com.example.nashtech.restapi.exception.StudentException;
import com.example.nashtech.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> findAllStudent() {
        List<Student> students = studentService.retrieveStudents();
        return students;
    }

    @GetMapping(value = "/{sid}")
    public Student findStudent(@PathVariable Integer sid) {
        Student student = studentService.getStudent(sid);
        if (student == null)
            throw new StudentException(sid);
        return student;
    }

    @PostMapping(value = "/save")
    public Student saveStudent(Student student) {
        Student _student = studentService.saveStudent(student);
        return _student;
    }

    @DeleteMapping(value = "delete/{sid}")
    public void deleteStudent(@PathVariable Integer sid) {
        studentService.deleteStudent(sid);
    }

    @PutMapping(value = "/update")
    public void updateStudent(Student student) {
        studentService.saveStudent(student);
    }
}
