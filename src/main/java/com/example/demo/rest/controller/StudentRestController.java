package com.example.demo.rest.controller;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        return data.get(studentId);
    }

    @GetMapping("/student")
    public List<Student> getStudentsList() {
        return data;
    }


}
