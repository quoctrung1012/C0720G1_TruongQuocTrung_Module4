package com.codegym.controller.contract_detail;

import com.codegym.entity.contract_detail.AttachService;
import com.codegym.entity.service.ServiceResort;
import com.codegym.model.book_attach_service.BookAttach;
import com.codegym.model.book_attach_service.BookAttachManager;
import com.codegym.model.book_service.BookService;
import com.codegym.service.contract_detail.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/book_attach")
public class BookAttachController {

    @Autowired
    private AttachServiceService attachServiceService;
    @Autowired
    private BookAttachManager bookAttachManager;

    @RequestMapping("/add_book_attach")
    public String addBookAttach(HttpSession sessionAttach, @RequestParam("id_attach") Long id,
                                 @RequestParam(value = "quantity_attach", required = false, defaultValue = "1") Integer quantity){
        AttachService attachService = attachServiceService.findById(id);
        BookAttach bookAttach = bookAttachManager.getBookAttach(sessionAttach);
        bookAttach.addItemAttach(attachService, quantity);
        return "redirect:/attach/listAttach";
    }
    @RequestMapping("/update_book_attach")
    public String update(HttpSession sessionAttach, @RequestParam("id_attach") Long id, @RequestParam("quantity_attach") Integer quantity){
        AttachService attachService = attachServiceService.findById(id);
        BookAttach bookAttach = bookAttachManager.getBookAttach(sessionAttach);
        bookAttach.updateAttachItem(attachService, quantity);
        return "redirect:/contract/create";
//        return "book/booking";
    }
    @RequestMapping("/remove_book_attach")
    public String remove(HttpSession sessionAttach, @RequestParam("id_attach") Long id){
        AttachService attachService = attachServiceService.findById(id);
        BookAttach bookAttach = bookAttachManager.getBookAttach(sessionAttach);
        bookAttach.removeAttachItem(attachService);
        return "redirect:/contract/create";
//        return "book/booking";
    }

}
