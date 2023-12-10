package com.example.demo.rest.controller;

import com.example.demo.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Aman","kulshreshtha"));
        studentList.add(new Student("Bittu","Kulshreshtha"));

        return studentList.get(studentId);
    }

    @GetMapping("/student")
    public List<Student> getStudentsList() {
        List<Student> studentList = new ArrayList<>();

        studentList.add(new Student("Aman","kulshreshtha"));
        studentList.add(new Student("Bittu","Kulshreshtha"));

        return studentList;
    }


}
