package com.codegym.controler;

import com.codegym.model.PhoneNumber;
import com.codegym.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import javax.validation.Valid;


@Controller
public class PhoneController {
    @Autowired
    private PhoneNumberService phoneNumberService;
    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("phonemunber", new PhoneNumber());
        return "index";
    }
    @PostMapping("/")
    public String checkValidation (@Valid @ModelAttribute("phonemunber")PhoneNumber phoneNumber, BindingResult bindingResult, Model model){
        new PhoneNumber().validate(phoneNumber, bindingResult);
        if (bindingResult.hasFieldErrors()){
//            model.addAttribute("phonemunber", this.phoneNumberService.findAll());
            return "index";
        }
        else {
            model.addAttribute("phoneNumber", phoneNumber.getNumberOfPhone());
            return "result";
        }
    }
}