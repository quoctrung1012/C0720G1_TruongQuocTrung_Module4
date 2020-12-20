package com.codegym.controller.contract_detail;

import com.codegym.entity.service.ServiceResort;
import com.codegym.model.book_service.BookService;
import com.codegym.model.book_service.BookServiceManager;
import com.codegym.service.service_resort.ServiceResortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/book_service")
public class BookServiceController {
    @Autowired
    private ServiceResortService serviceResortService;
    @Autowired
    private BookServiceManager bookServiceManager;

    @RequestMapping("/add_book_service")
    public String addBookService(HttpSession session,@RequestParam("id_service") Long id,
                                 @RequestParam(value = "quantity_service", required = false, defaultValue = "1") Integer quantity){
        ServiceResort serviceResort = serviceResortService.findById(id);
        BookService bookService = bookServiceManager.getBookService(session);
        bookService.addItemService(serviceResort, quantity);
//        return "book/booking";
        return "redirect:/service_resort/listServiceResort";
    }
    @RequestMapping("/update_book_service")
    public String update(HttpSession session, @RequestParam("id_service") Long id, @RequestParam("quantity_service") Integer quantity){
        ServiceResort serviceResort = serviceResortService.findById(id);
        BookService bookService = bookServiceManager.getBookService(session);
        bookService.updateServiceItem(serviceResort, quantity);
        return "redirect:/contract/create";
//        return "book/booking";
    }
    @RequestMapping("/remove_book_service")
    public String remove(HttpSession session, @RequestParam("id_service") Long id){
        ServiceResort serviceResort = serviceResortService.findById(id);
        BookService bookService = bookServiceManager.getBookService(session);
        bookService.removeServiceItem(serviceResort);
        return "redirect:/contract/create";
    }
}
