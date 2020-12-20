package com.codegym.repository.customer;

import com.codegym.entity.customer.GenderPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepository extends JpaRepository<GenderPerson, Long> {
}
