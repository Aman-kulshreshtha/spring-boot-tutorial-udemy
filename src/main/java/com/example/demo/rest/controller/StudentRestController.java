package com.example.demo.rest.controller;

import com.example.demo.entity.Student;
import com.example.demo.error.StudentErrorResponse;
import com.example.demo.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> data;


    // @PostConstruct will be called only once after the bean is created
    @PostConstruct
    private void loadData() {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Aman","kulshreshtha"));
        studentList.add(new Student("Bittu","Kulshreshtha"));
        studentList.add(new Student("Naman","Kulshreshtha"));
        studentList.add(new Student("Chaman","Kulshreshtha"));

        data = studentList;
    }



    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleStudentException(Exception exception) {
        StudentErrorResponse error = new StudentErrorResponse(400,exception.getMessage());
        return new ResponseEntity<StudentErrorResponse>(error, HttpStatusCode.valueOf(400));

    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // check if student exists or not with given index
        if(studentId < 0 || studentId >= data.size()) {
            // throw exception
            throw new StudentNotFoundException("No Student exists with given id");
        }
        return data.get(studentId);
    }

    @GetMapping("/student")
    public List<Student> getStudentsList() {
        return data;
    }


}
