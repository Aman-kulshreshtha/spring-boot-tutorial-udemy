package com.example.demo.dao;

import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;


public interface StudentDAO {

    void save(Student student);

}
