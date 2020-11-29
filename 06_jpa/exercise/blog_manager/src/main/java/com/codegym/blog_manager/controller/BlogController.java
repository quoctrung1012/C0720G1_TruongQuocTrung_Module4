package com.codegym.blog_manager.controller;

import com.codegym.blog_manager.entity.Blog;
import com.codegym.blog_manager.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
//    @RequestMapping("/")
//    public String goHome(){
//        return "home";
//    }

    @RequestMapping("/")
    public String listBlog(Model model){
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/index";
    }
    @RequestMapping("/blog/create")
    public String create(Model model){
        model.addAttribute("blog", new Blog());
        return "/create";
    }
    @RequestMapping("/blog/save")
    public String save(Blog blog, RedirectAttributes redirect){
        blogService.save(blog);
        redirect.addFlashAttribute("success","Saved customer successfully!");
        return "redirect:/";
    }
    @RequestMapping("/blog/{id}/edit")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "/edit";
    }
    @RequestMapping("/blog/update")
    public String update(Blog blog, RedirectAttributes redirect){
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/";
    }
    @RequestMapping("/blog/{id}/delete")
    public String delete(@PathVariable Integer id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "/delete";
    }
    @RequestMapping("/blog/delete")
    public String delete(Blog blog, RedirectAttributes redirect){
        blogService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/";
    }
    @RequestMapping("/blog/{id}/view")
    public String view(@PathVariable Integer id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "/view";
    }
}
