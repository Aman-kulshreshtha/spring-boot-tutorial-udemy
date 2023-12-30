package com.example.demo.rest.dao;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public void save(Employee employee);

    public Employee getEmployeeById(int id);

    public List<Employee> getEmployee();

    public void update(Employee employee, int id);

    public void delete(int id);

}
