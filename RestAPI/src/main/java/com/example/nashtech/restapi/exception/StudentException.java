package com.example.nashtech.restapi.exception;

public class StudentException extends RuntimeException {
    public StudentException(int id) {
        super("Cannot find student with id = " + id);
    }
}
