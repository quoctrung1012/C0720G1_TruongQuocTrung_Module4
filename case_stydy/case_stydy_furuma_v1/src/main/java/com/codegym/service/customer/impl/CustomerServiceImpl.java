package com.codegym.service.customer.impl;

import com.codegym.entity.customer.Customer;
import com.codegym.entity.customer.CustomerType;
import com.codegym.repository.customer.CustomerRepository;
import com.codegym.service.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }
//
//    @Override
//    public Page<Customer> searchNameAndAddress(String string01, String string02, Pageable pageable) {
//        return customerRepository.findByNameCustomerContainingAndAddressContaining(string01, string02,pageable);
//    }

    @Override
    public Iterable<Customer> findByCustomerType(CustomerType customerType) {
        return customerRepository.findByCustomerType(customerType);
    }

    @Override
    public Page<Customer> searchIdCard(String string01, String string02, Pageable pageable) {
        return customerRepository.findByIdCardContainingAndNameCustomerContaining(string01, string02, pageable);
    }

    @Override
    public Page<Customer> searchPhone(String string01, String string02, Pageable pageable) {
        return customerRepository.findByPhoneContainingAndNameCustomerContaining(string01, string02, pageable);
    }

    @Override
    public Page<Customer> searchAddress(String string01, String string02, Pageable pageable) {
        return customerRepository.findByAddressContainingAndNameCustomerContaining(string01, string02, pageable);
    }

    @Override
    public Page<Customer> searchEmail(String string01, String string02, Pageable pageable) {
        return customerRepository.findByEmailContainingAndNameCustomerContaining(string01, string02, pageable);
    }

    @Override
    public Page<Customer> searchCustomerType(String string01, String string02, Pageable pageable) {
        return customerRepository.findByCustomerType_NameCustomerTypeContainingAndNameCustomerContaining(string01, string02, pageable);
    }

    @Override
    public Page<Customer> findByBirthdayAfter(String input, Pageable pageable) {
        return customerRepository.findByBirthdayAfter(input, pageable);
    }

    @Override
    public Page<Customer> findByBirthdayBefore(String input, Pageable pageable) {
        return customerRepository.findByBirthdayBefore(input, pageable);
    }

    @Override
    public Page<Customer> findByBirthdayBetween(String inputBefore, String inputAfter, Pageable pageable) {
        return customerRepository.findByBirthdayBetween(inputBefore, inputAfter, pageable);
    }

    @Override
    public Page<Customer> findPageAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> searchByName(String string, Pageable pageable) {
        return customerRepository.findByNameCustomerContaining(string, pageable);
    }
}
