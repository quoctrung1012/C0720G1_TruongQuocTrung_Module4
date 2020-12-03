package com.codegym.service.impl;

import com.codegym.entity.Book;
import com.codegym.entity.BorrowCard;
import com.codegym.repository.BorrowCardRepository;
import com.codegym.service.BookService;
import com.codegym.service.BorrowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Service
public class BorrowCardServiceImpl implements BorrowCardService {

    @Autowired
    BookService bookService;
    @Autowired
    private BorrowCardRepository borrowCardRepository;
    @Override
    public List<BorrowCard> findAll() {
        return borrowCardRepository.findAll();
    }

    @Override
    public BorrowCard findById(Integer id) {
        return borrowCardRepository.getOne(id);
    }

    @Override
    public void save(BorrowCard borrowCard, Book book) {
        borrowCard.setDateOfBorrow(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        borrowCard.setBook(book);
        book.setQuality(book.getQuality()-1);
        bookService.save(book);
        borrowCardRepository.save(borrowCard);
    }

    @Override
    public void update(BorrowCard borrowCard) {
        borrowCard.setStatus(true);
        borrowCard.setDateOfPay(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        borrowCardRepository.save(borrowCard);
        Book book = borrowCard.getBook();
        book.setQuality(book.getQuality()+1);
        bookService.save(book);
    }

    @Override
    public void remove(Integer id) {
        borrowCardRepository.deleteById(id);
    }


}
