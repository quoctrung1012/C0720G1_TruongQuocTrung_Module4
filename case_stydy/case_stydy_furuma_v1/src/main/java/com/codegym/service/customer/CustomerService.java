package com.codegym.service.customer;

import com.codegym.entity.customer.Customer;
import com.codegym.entity.customer.CustomerType;
import com.codegym.service.generic.ServiceGeneric;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService extends ServiceGeneric<Customer> {
        //Page<Customer> searchNameAndAddress(String string01, String string02, Pageable pageable);
        Iterable<Customer> findByCustomerType(CustomerType customerType);
        Page<Customer> searchIdCard(String string01, String string02, Pageable pageable);
        Page<Customer> searchPhone(String string01, String string02, Pageable pageable);
        Page<Customer> searchAddress(String string01, String string02, Pageable pageable);
        Page<Customer> searchEmail(String string01, String string02, Pageable pageable);
        Page<Customer> searchCustomerType(String string01, String string02, Pageable pageable);
        Page<Customer> findByBirthdayAfter(String input, Pageable pageable);
        Page<Customer> findByBirthdayBefore(String input, Pageable pageable);
        Page<Customer> findByBirthdayBetween(String inputBefore, String inputAfter, Pageable pageable);
}
