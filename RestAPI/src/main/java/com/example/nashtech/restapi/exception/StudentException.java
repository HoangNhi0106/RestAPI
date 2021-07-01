package com.example.nashtech.restapi.exception;

import com.example.nashtech.restapi.entity.Student;

public class StudentException extends RuntimeException {
    public StudentException(int id) {
        super("Cannot find student with id = " + id);
    }

    public StudentException(Student student) {
        super("Already have student with id = " + student.getSid());
    }
}
