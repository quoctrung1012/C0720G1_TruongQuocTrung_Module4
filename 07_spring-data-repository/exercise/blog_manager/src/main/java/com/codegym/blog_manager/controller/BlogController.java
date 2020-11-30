package com.codegym.blog_manager.controller;

import com.codegym.blog_manager.entity.Blog;
import com.codegym.blog_manager.entity.Category;
import com.codegym.blog_manager.service.BlogService;
import com.codegym.blog_manager.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categoryList")
    public Iterable<Category> categoryList(){
        return categoryService.findAll();
    }

    @RequestMapping({"/listBlog"})
    public String listBlog(Model model, @PageableDefault(size = 3)Pageable pageable, @RequestParam Optional<String> input){
        //List<Blog> blogList = blogService.findAll(); //Dua ra list blog
//        model.addAttribute("blogList", this.blogService.findAll(pageable));//phan trang
        String inputCheck= ""; //check để tiếp tục search và phân trang
        if (!input.isPresent()){
            model.addAttribute("blogList", this.blogService.findAll(pageable)); // nếu tróng thì đưa ra danh sách có phân trang
        } else {
            inputCheck = input.get();
            model.addAttribute("blogList", this.blogService.searchBlogByTitle(inputCheck, pageable));
            //Nếu không thì đưa ra danh sách tìm kiếm được và phân trang
        }
        model.addAttribute("inputAfterCheck", inputCheck);
        return "blog/index";
    }
    @RequestMapping("/blog/create")
    public String create(Model model){
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }
    @RequestMapping("/blog/save")
    public String save(Blog blog, RedirectAttributes redirect){
        blogService.save(blog);
        redirect.addFlashAttribute("success","Saved customer successfully!");
        return "redirect:/listBlog";
    }
    @RequestMapping("/blog/{id}/edit")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "blog/edit";
    }
    @RequestMapping("/blog/update")
    public String update(Blog blog, RedirectAttributes redirect){
        blogService.save(blog);
        redirect.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/listBlog";
    }
    @RequestMapping("/blog/{id}/delete")
    public String delete(@PathVariable Integer id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "blog/delete";
    }
    @RequestMapping("/blog/delete")
    public String delete(Blog blog, RedirectAttributes redirect){
        blogService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/listBlog";
    }
    @RequestMapping("/blog/{id}/view")
    public String view(@PathVariable Integer id, Model model){
        model.addAttribute("blog", blogService.findById(id));
        return "blog/view";
    }
}
