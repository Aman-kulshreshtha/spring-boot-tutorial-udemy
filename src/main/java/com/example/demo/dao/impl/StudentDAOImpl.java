package com.example.demo.dao.impl;

import com.example.demo.dao.StudentDAO;
import com.example.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Transient;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findStudentById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
         TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student order by firstName, lastName", Student.class);
         List<Student> result = typedQuery.getResultList();
        return result;
    }

    @Override
    public List<Student> findStudentByFirstName(String firstName) {
        TypedQuery<Student> typedQuery = entityManager.createQuery("FROM Student WHERE firstName=:theFirstName",Student.class);

        typedQuery.setParameter("theFirstName", firstName);

        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public void updateStudentById(int id, Student student) {
//        student.setId(id);
        int rows = entityManager.createQuery("UPDATE Student Set firstName = :firstName , lastName = :lastName, email = :email where id = :id ")
                .setParameter("firstName",student.getFirstName())
                .setParameter("lastName",student.getLastName())
                .setParameter("email",student.getEmail())
                .setParameter("id",id)
                .executeUpdate();
        System.out.println("No. of Rows updated = "+rows);
//        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        int rows = entityManager.createQuery("DELETE Student WHERE id = :id")
                .setParameter("id",id)
                .executeUpdate();
        System.out.println("Rows deleted: "+ rows);
    }
}
