package com.codegym.repository;

import com.codegym.entity.Book;
import com.codegym.entity.BorrowCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowCardRepository extends JpaRepository<BorrowCard, Integer> {

}
