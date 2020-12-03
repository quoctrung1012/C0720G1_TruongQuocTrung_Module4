package com.codegym.controller;

import com.codegym.entity.Book;
import com.codegym.entity.BorrowCard;
import com.codegym.service.BookService;
import com.codegym.service.BorrowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowCardService borrowCardService;



    @GetMapping
    public String findAllBook(Model model) {
        model.addAttribute("listBook", this.bookService.findAll());
        return "book/list";
    }

    @GetMapping("/{id}/view")
    public String bookView(@PathVariable Integer id, Model model) {
        model.addAttribute("book", borrowCardService.findById(id));
        return "book/view";
    }


//    @GetMapping("/{id}/view")
//    public ModelAndView viewBook(@PathVariable("id") Integer id){
//        Book book = bookService.findById(id);
//        Iterable<BorrowCard> borrowCardIterable = borrowCardService.findByLikedBooks(book);
//        ModelAndView modelAndView = new ModelAndView("book/view");
//        modelAndView.addObject("book", book);
//        modelAndView.addObject("borrowCard", borrowCardIterable);
//        return modelAndView;
//    }

    @GetMapping("/create")
    public String createBooks(Model model) {
        model.addAttribute("book", new Book());
        return "book/create";
    }

    @PostMapping("/save")
    public String saveBooks(Book book, RedirectAttributes redirectAttributes) {
        this.bookService.save(book);
        redirectAttributes.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String editBooks(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "book/edit";
    }

    @PostMapping("/update")
    public String updateBook(Book book, RedirectAttributes redirectAttributes) {
        bookService.save(book);
        redirectAttributes.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/books";
    }

    @GetMapping("/{id}/remove")
    public String removeBook(@PathVariable Integer id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        return "book/delete";
    }

    @PostMapping("/delete")
    public String deleteBook(Book book, RedirectAttributes redirectAttributes) {
        bookService.remove(book.getId());
        redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/books";
    }

}
