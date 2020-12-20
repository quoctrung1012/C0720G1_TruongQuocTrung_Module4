package com.codegym.service.employee;

import com.codegym.entity.account.AccountUser;
import com.codegym.entity.employee.Division;
import com.codegym.entity.employee.EducationDegree;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.employee.Position;
import com.codegym.service.generic.ServiceGeneric;

public interface EmployeeService extends ServiceGeneric<Employee> {
    Iterable<Employee> findByPositionAndDivisionAndEducationDegreeAndAccountUser_UserName(Position position, Division division, EducationDegree educationDegree, AccountUser accountUser);
    Iterable<Employee> findByPosition(Position position);
    Iterable<Employee> findByEducationDegree(EducationDegree educationDegree);
    Iterable<Employee> findByDivision(Division division);
    Iterable<Employee> findByAccountUser(AccountUser accountUser);
}
