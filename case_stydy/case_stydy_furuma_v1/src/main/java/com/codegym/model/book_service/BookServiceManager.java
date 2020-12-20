package com.codegym.model.book_service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
@Service
public class BookServiceManager {
    private static final String SESSION_KEY_BOOKING_SERVICE = "bookingService";
    public BookService getBookService(HttpSession sessionService){
        BookService bookService = (BookService) sessionService.getAttribute(SESSION_KEY_BOOKING_SERVICE);
        if ((bookService == null)){
            bookService = new BookService();
            setBookService(sessionService, bookService);
        }
        return bookService;
    }

    public void setBookService(HttpSession sessionService, BookService bookService){
        sessionService.setAttribute(SESSION_KEY_BOOKING_SERVICE, bookService);
    }

    public void removeBookService(HttpSession sessionService){
        sessionService.removeAttribute(SESSION_KEY_BOOKING_SERVICE);
    }
}
