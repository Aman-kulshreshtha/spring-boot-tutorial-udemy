package com.example.demo.rest.service;

import com.example.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public void save(Employee employee);

    public Employee getEmployeeById(int id);

    public List<Employee> getEmployee();

    public void update(Employee employee, int id);

    public void delete(int id);
}
