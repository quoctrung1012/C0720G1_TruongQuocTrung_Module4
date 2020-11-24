package com.code.service;

import com.code.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    Employee getById (int id);

    void save(Employee employee);
}
