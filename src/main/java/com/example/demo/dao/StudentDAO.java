package com.example.demo.dao;

import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentDAO {

    void save(Student student);

    Student findStudentById(int id);

    List<Student> findAll();

    List<Student> findStudentByFirstName(String firstName);

}
