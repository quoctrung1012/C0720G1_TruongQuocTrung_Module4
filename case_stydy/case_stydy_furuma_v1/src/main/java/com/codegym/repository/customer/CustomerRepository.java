package com.codegym.repository.customer;

import com.codegym.entity.customer.Customer;
import com.codegym.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Page<Customer> findByNameCustomerContaining(String input, Pageable pageable);

    Page<Customer> findByIdCardContainingAndNameCustomerContaining(String string01, String string02, Pageable pageable);
    Page<Customer> findByPhoneContainingAndNameCustomerContaining(String string01, String string02, Pageable pageable);
    Page<Customer> findByAddressContainingAndNameCustomerContaining(String string01, String string02, Pageable pageable);
    Page<Customer> findByEmailContainingAndNameCustomerContaining(String string01, String string02, Pageable pageable);
    Page<Customer> findByCustomerType_NameCustomerTypeContainingAndNameCustomerContaining(String string01, String string02, Pageable pageable);

    Page<Customer> findByBirthdayAfter(String input, Pageable pageable);
    Page<Customer> findByBirthdayBefore(String input, Pageable pageable);
    Page<Customer> findByBirthdayBetween(String inputBefore, String inputAfter, Pageable pageable);
    //Page<Customer> findByNameCustomerContainingAndAddressContaining(String string01, String string02, Pageable pageable);
    Iterable<Customer> findByCustomerType(CustomerType customerType);
}
