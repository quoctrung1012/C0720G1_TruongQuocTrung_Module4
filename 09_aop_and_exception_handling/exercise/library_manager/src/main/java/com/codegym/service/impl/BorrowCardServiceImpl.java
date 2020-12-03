package com.codegym.service.impl;

import com.codegym.entity.Book;
import com.codegym.entity.BorrowCard;
import com.codegym.repository.BorrowCardRepository;
import com.codegym.service.BorrowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BorrowCardServiceImpl implements BorrowCardService {
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
    public void save(BorrowCard borrowCard) {
        borrowCardRepository.save(borrowCard);
    }

    @Override
    public void remove(Integer id) {
        borrowCardRepository.deleteById(id);
    }

    @Override
    public Iterable<BorrowCard> findByLikedBooks(Book book) {
        return borrowCardRepository.findByLikedBooks(book);
    }
}
