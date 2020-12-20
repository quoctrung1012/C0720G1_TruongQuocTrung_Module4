package com.codegym.service.employee.impl;

import com.codegym.entity.account.AccountUser;
import com.codegym.entity.employee.Division;
import com.codegym.entity.employee.EducationDegree;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.employee.Position;
import com.codegym.repository.employee.EmployeeRepository;
import com.codegym.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void remove(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findPageAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Page<Employee> searchByName(String string, Pageable pageable) {
        return employeeRepository.findByNameEmployeeContaining(string,pageable);
    }

    @Override
    public Iterable<Employee> findByPositionAndDivisionAndEducationDegreeAndAccountUser_UserName(Position position, Division division, EducationDegree educationDegree, AccountUser accountUser) {
        return employeeRepository.findByPositionAndDivisionAndEducationDegreeAndAccountUser_UserName(position, division,educationDegree,accountUser);
    }

    @Override
    public Iterable<Employee> findByPosition(Position position) {
        return employeeRepository.findByPosition(position);
    }

    @Override
    public Iterable<Employee> findByEducationDegree(EducationDegree educationDegree) {
        return employeeRepository.findByEducationDegree(educationDegree);
    }

    @Override
    public Iterable<Employee> findByDivision(Division division) {
        return employeeRepository.findByDivision(division);
    }

    @Override
    public Iterable<Employee> findByAccountUser(AccountUser accountUser) {
        return employeeRepository.findByAccountUser_EmployeesUser(accountUser);
    }
}
