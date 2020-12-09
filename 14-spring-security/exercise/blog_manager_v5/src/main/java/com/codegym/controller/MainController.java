package com.codegym.controller;

import com.codegym.service.BlogService;
import com.codegym.ultil.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private BlogService blogService;
    
    @RequestMapping(value = {"/", "/welcome","/listBlogSecurity"}, method = RequestMethod.GET)
    public String listBlogSecurity(Principal principal, Model model, @PageableDefault(size = 3) Pageable pageable, @RequestParam Optional<String> input) {
        String inputCheck = ""; //check để tiếp tục search và phân trang
        model.addAttribute("message", "This is welcome page!");
        if (!input.isPresent()) {
            model.addAttribute("blogList", this.blogService.findAll(pageable)); // nếu trống thì đưa ra danh sách có phân trang
        } else {
            inputCheck = input.get();
            model.addAttribute("blogList", this.blogService.searchBlogByTitle(inputCheck, pageable));
            //Nếu không thì đưa ra danh sách tìm kiếm được và phân trang
        }

        model.addAttribute("inputCheck", inputCheck);
        return "blog/index_security";
    }


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "login/loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "login/logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "login/userInfoPage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "login/adminPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "login/403Page";
    }

}
