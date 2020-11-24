package com.code.controller;

import com.code.dao.UsersDao;
import com.code.model.Login;
import com.code.model.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {
    @GetMapping({"","/","/home"})
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView("home", "login", new Login());
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login){
        Users user = UsersDao.checkLogin(login);
        if(user == null){
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("users");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
    }
}
