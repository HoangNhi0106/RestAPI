package com.example.nashtech.restapi.restcontroller;

import com.example.nashtech.restapi.entity.Student;
import com.example.nashtech.restapi.exception.StudentException;
import com.example.nashtech.restapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
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
    public Student saveStudent(@Valid @RequestBody Student student) {
        if (studentService.isExistStudent(student))
            throw new StudentException(student);
        return studentService.saveStudent(student);
    }

    @DeleteMapping(value = "delete/{sid}")
    public HashMap<String, String> deleteStudent(@PathVariable Integer sid) {
        Student student = studentService.getStudent(sid);
        if (student == null)
            throw new StudentException(sid);
        studentService.deleteStudent(sid);
        HashMap<String, String> map = new HashMap<>();
        map.put("delete student sid = " + sid, "successful");
        return map;
    }

    @PutMapping(value = "/update")
    public HashMap<String, String> updateStudent(@Valid @RequestBody Student student) {
        if (student == null)
            throw new StudentException(student.getSid());
        studentService.updateStudent(student);
        HashMap<String, String> map = new HashMap<>();
        map.put("update student sid = " + student.getSid(), "successful");
        return map;
    }
}
