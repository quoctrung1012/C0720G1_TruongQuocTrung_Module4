package com.code.controller;

import com.code.model.EmailSetting;
import com.code.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmailController {
    @Qualifier("emailServiceImpl")
    @Autowired
    private EmailService emailService;

    @RequestMapping({"","/","home"})
    public String goHome(Model model){
        model.addAttribute("emailSetting", new EmailSetting());
        model.addAttribute("language", emailService.getLanguageList());
        model.addAttribute("paperSize", emailService.getPage());
        return "home";
    }
    @RequestMapping("/save")
    public String saveEmail(@ModelAttribute EmailSetting emailSetting, Model model){
        String message = "Save Success";
        model.addAttribute("emailSetting",emailService.emailSave(emailSetting));
        model.addAttribute("message", message);
        return "result";
    }


}
