package com.codegym.service.contract;

import com.codegym.entity.contract.Contract;
import com.codegym.entity.customer.Customer;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.service.ServiceResort;
import com.codegym.repository.contract.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Override
    public List<Contract> findAll() {
        return contractRepository.findAll();
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public void remove(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findPageAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> searchByName(String string, Pageable pageable) {
        return contractRepository.findByCustomer_NameCustomerContaining(string, pageable);
    }

    @Override
    public Iterable<Contract> findByEmployeeAndCustomerAndServiceResort(Employee employee, Customer customer, ServiceResort serviceResort) {
        return contractRepository.findByEmployeeAndCustomerAndServiceResort(employee,customer,serviceResort);
    }

    @Override
    public Iterable<Contract> findByEmployee(Employee employee) {
        return contractRepository.findByEmployee(employee);
    }

    @Override
    public Iterable<Contract> findByCustomer(Customer customer) {
        return contractRepository.findByCustomer(customer);
    }

    @Override
    public Iterable<Contract> findByServiceResort(ServiceResort serviceResort) {
        return contractRepository.findByServiceResort(serviceResort);
    }
}
