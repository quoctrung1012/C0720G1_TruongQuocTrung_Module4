package com.codegym.repository;

import com.codegym.entity.SignUp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignUpRepository extends JpaRepository<SignUp, Integer> {
}
