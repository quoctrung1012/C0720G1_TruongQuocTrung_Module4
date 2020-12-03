package com.codegym.service;

import com.codegym.entity.Book;
import com.codegym.entity.BorrowCard;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    Book findById(Integer id);

    void save (Book book);

    void remove(Integer id);

}
