package com.example.demo.rest.dao.impl;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.rest.dao.EmployeeDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager= entityManager;
    }

    @Override
    public void save(Employee employee) {
//        int rows = entityManager.createQuery("INSERT INTO Employee VALUE (':firstName',':lastName',':email')")
//                .setParameter("firstName",employee.getFirstName())
//                .setParameter("lastName", employee.getLastName())
//                .setParameter("email",employee.getEmail()).executeUpdate();
//        System.out.println("Inserted "+rows+" rows");
        entityManager.persist(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee WHERE id=:id",Employee.class).setParameter("id",id);
        List<Employee> resultList = query.getResultList();
        if(resultList == null || resultList.size() == 0) {
            // throw an exception of student not found
            throw new EmployeeNotFoundException("Employee with given id was not found");
        }
        return resultList.get(0);
    }

    @Override
    public List<Employee> getEmployee() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee",Employee.class);
        List<Employee> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public void update(Employee employee, int id) {
        int rowsUpdated = entityManager.createQuery("UPDATE Employee SET firstName=:firstName, lastName=:lastName, email=:email WHERE id=:id")
                .setParameter("firstName",employee.getFirstName())
                .setParameter("lastName",employee.getLastName())
                .setParameter("email",employee.getEmail())
                .setParameter("id",id)
                .executeUpdate();
        System.out.println("Updated "+rowsUpdated+" rows");

    }

    @Override
    public void delete(int id) {
        int query = entityManager.createQuery(" DELETE FROM Employee where id=:id")
                .setParameter("id",id)
                .executeUpdate();
        System.out.println("Deleted "+query+" records");
    }
}
