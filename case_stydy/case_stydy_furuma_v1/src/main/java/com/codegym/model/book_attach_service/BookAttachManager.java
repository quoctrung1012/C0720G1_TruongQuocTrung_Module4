package com.codegym.model.book_attach_service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
@Service
public class BookAttachManager {
    private static final String SESSION_KEY_BOOKING_ATTACH = "bookingAttach";
    public BookAttach getBookAttach(HttpSession sessionAttach){
        BookAttach attachService = (BookAttach) sessionAttach.getAttribute(SESSION_KEY_BOOKING_ATTACH);
        if ((attachService == null)){
            attachService = new BookAttach();
            setAttachService(sessionAttach, attachService);
        }
        return attachService;
    }

    public void setAttachService(HttpSession sessionAttach, BookAttach attachService){
        sessionAttach.setAttribute(SESSION_KEY_BOOKING_ATTACH, attachService);
    }

    public void removeBookAttach(HttpSession sessionAttach){
        sessionAttach.removeAttribute(SESSION_KEY_BOOKING_ATTACH);
    }
}
