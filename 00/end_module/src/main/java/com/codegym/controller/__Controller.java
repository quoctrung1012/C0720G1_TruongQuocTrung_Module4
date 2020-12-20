package com.codegym.controller;

import com.codegym.entity.__;
import com.codegym.service.__.__Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/__")
public class __Controller {
    @Autowired
    private __Service __Service;



    @GetMapping("/list__")
    public String listEmployee(Principal principal,
                               Model model, @PageableDefault(size = 3) Pageable pageable, @RequestParam Optional<String> input) {
        String inputCheck = "";
        if (!input.isPresent()) {
            model.addAttribute("__List", this.__Service.findPageAll(pageable));
        } else {
            inputCheck = input.get();
            model.addAttribute("__List", this.__Service.searchByName(inputCheck, pageable));
        }
        model.addAttribute("inputCheck", inputCheck);
        return "product/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("__", new __());
        return "product/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute __ __, BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "product/create";
        }
        __Service.save(__);
        attributes.addFlashAttribute("success", "Saved employee successfully!");
        return "redirect:/__/list__";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("__", __Service.findById(id));
        return "product/edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute __ __, BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "product/edit";
        }
        __Service.save(__);
        attributes.addFlashAttribute("success", "Modified employee successfully!");
        return "redirect:/__/list__";
    }

    @GetMapping("/{id}/delete")
    public String remove(@PathVariable Long id, Model model) {
        model.addAttribute("__", __Service.findById(id));
        return "peoduct/delete";
    }

    @PostMapping("/delete")
    public String delete(__ __, RedirectAttributes attributes) {
        __Service.remove(__.getId());
        attributes.addFlashAttribute("success", "Removed employee successfully!");
        return "redirect:/__/list__";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("__", __Service.findById(id));
        return "prodcut/view";
    }
}
