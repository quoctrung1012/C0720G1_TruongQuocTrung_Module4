package com.codegym.service.contract;

import com.codegym.entity.contract.Contract;
import com.codegym.entity.customer.Customer;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.service.ServiceResort;
import com.codegym.service.generic.ServiceGeneric;

public interface ContractService extends ServiceGeneric<Contract> {
    Iterable<Contract> findByEmployeeAndCustomerAndServiceResort(Employee employee, Customer customer, ServiceResort serviceResort);
    Iterable<Contract> findByEmployee(Employee employee);
    Iterable<Contract> findByCustomer(Customer customer);
    Iterable<Contract> findByServiceResort(ServiceResort serviceResort);
}
