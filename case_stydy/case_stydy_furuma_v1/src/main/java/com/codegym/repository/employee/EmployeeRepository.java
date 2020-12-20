package com.codegym.repository.employee;

import com.codegym.entity.account.AccountUser;
import com.codegym.entity.customer.Customer;
import com.codegym.entity.employee.Division;
import com.codegym.entity.employee.EducationDegree;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Page<Employee> findByNameEmployeeContaining(String input, Pageable pageable);
    Iterable<Employee> findByPositionAndDivisionAndEducationDegreeAndAccountUser_UserName(Position position, Division division, EducationDegree educationDegree, AccountUser accountUser);
    Iterable<Employee> findByPosition(Position position);
    Iterable<Employee> findByEducationDegree(EducationDegree educationDegree);
    Iterable<Employee> findByDivision(Division division);
    Iterable<Employee> findByAccountUser_EmployeesUser(AccountUser accountUser);
}
