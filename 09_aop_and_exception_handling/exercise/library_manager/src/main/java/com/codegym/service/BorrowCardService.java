package com.codegym.service;

import com.codegym.entity.Book;
import com.codegym.entity.BorrowCard;

import java.util.List;

public interface BorrowCardService {
    List<BorrowCard> findAll();

    BorrowCard findById(Integer id);

    void save (BorrowCard borrowCard, Book book);

    void update (BorrowCard borrowCard);

    void remove(Integer id);

}
