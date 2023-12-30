package com.example.demo.exceptionHandler;

import com.example.demo.error.StudentErrorResponse;
import com.example.demo.exception.StudentNotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


// provides global exception handling
@ControllerAdvice
public class StudentExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(StudentNotFoundException exception) {
        StudentErrorResponse error = new StudentErrorResponse(404,exception.getMessage());
        return new ResponseEntity<StudentErrorResponse>(error, HttpStatusCode.valueOf(404));

    }
}
