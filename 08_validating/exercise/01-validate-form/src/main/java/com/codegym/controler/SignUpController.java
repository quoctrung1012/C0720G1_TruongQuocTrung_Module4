package com.codegym.controler;

import com.codegym.entity.SignUp;
import com.codegym.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class SignUpController {
    @Autowired
    private SignUpService signUpService;

    @GetMapping({"","/home"})
    public String goHome(Model model){
        model.addAttribute("signUp", new SignUp());
        return "index";
    }
    @PostMapping("/save")
    public String checkForm(@Valid @ModelAttribute SignUp signUp, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "index";
        } else {
            this.signUpService.save(signUp);
            redirectAttributes.addFlashAttribute("messageSuccess", "Register successfully!");
            return "result";
        }
    }
}
