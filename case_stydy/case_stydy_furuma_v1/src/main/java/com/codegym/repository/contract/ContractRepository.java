package com.codegym.repository.contract;

import com.codegym.entity.contract.Contract;
import com.codegym.entity.customer.Customer;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.service.ServiceResort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract, Long> {

    Page<Contract> findByCustomer_NameCustomerContaining(String string, Pageable pageable);
    Iterable<Contract> findByEmployeeAndCustomerAndServiceResort(Employee employee, Customer customer, ServiceResort serviceResort);
    Iterable<Contract> findByEmployee(Employee employee);
    Iterable<Contract> findByCustomer(Customer customer);
    Iterable<Contract> findByServiceResort(ServiceResort serviceResort);
}
