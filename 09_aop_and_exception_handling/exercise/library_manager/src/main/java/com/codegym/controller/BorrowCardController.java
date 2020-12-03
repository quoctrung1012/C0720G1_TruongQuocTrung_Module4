package com.codegym.controller;

import com.codegym.entity.Book;
import com.codegym.entity.BorrowCard;
import com.codegym.service.BookService;
import com.codegym.service.BorrowCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/borrow-card")
public class BorrowCardController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BorrowCardService borrowCardService;

    @ModelAttribute("bookList")
    public List<Book> booksList(){
        return bookService.findAll();
    }

    @GetMapping
    public String listBorrowBook(Model model){
        model.addAttribute("listBorrowCard", this.borrowCardService.findAll());
        return "borrow_card/list";
    }
    @GetMapping("/create")
    public String createBorrowBook(Model model) {
        model.addAttribute("borrowCard", new BorrowCard());
        return "borrow_card/create";
    }
    @PostMapping("/save")
    public String saveBorrowBook(BorrowCard borrowCard, Book book, RedirectAttributes redirectAttributes) {
        this.borrowCardService.save(borrowCard, book);
        redirectAttributes.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/borrow-card";
    }

    @GetMapping("/{id}/edit")
    public String editBorrowBook(@PathVariable Integer id, Model model) {
        model.addAttribute("borrowCard", borrowCardService.findById(id));
        return "borrow_card/edit";
    }

    @PostMapping("/update")
    public String updateBorrowBook(BorrowCard borrowCard, RedirectAttributes redirectAttributes) {
        borrowCardService.update(borrowCard);
        redirectAttributes.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/borrow-card";
    }

    @GetMapping("/{id}/remove")
    public String removeBorrowBook(@PathVariable Integer id, Model model) {
        model.addAttribute("borrowCard", borrowCardService.findById(id));
        return "borrow_card/delete";
    }

    @PostMapping("/delete")
    public String deleteBorrowBook(BorrowCard borrowCard, RedirectAttributes redirectAttributes) {
        borrowCardService.remove(borrowCard.getId());
        redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/borrow-card";
    }

}
