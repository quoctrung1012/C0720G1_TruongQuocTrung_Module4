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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BlogService blogService;

    @RequestMapping({"/listCategory"})
    public String listCategory(Model model, @PageableDefault(size = 3)Pageable pageable, @RequestParam Optional<String> input){
        String inputCheck= ""; //check để tiếp tục search và phân trang
        if (!input.isPresent()){
            model.addAttribute("categoryList", this.categoryService.findAll(pageable));
        } else {
            inputCheck = input.get();
            model.addAttribute("categoryList", this.categoryService.findByNameCategory(inputCheck, pageable));
        }
        model.addAttribute("inputCheck", inputCheck);
        return "category/index";
    }
    @RequestMapping("/category/create")
    public String create(Model model){
        model.addAttribute("category", new Category());
        return "category/create";
    }
    @RequestMapping("/category/save")
    public String save(Category category, RedirectAttributes redirect){
        categoryService.save(category);
        redirect.addFlashAttribute("success","Saved customer successfully!");
        return "redirect:/listCategory";
    }
    @RequestMapping("/category/{id}/edit")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("category", categoryService.findById(id));
        return "category/edit";
    }
    @RequestMapping("/category/update")
    public String update(Category category, RedirectAttributes redirect){
        categoryService.save(category);
        redirect.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/listCategory";
    }
    @RequestMapping("/category/{id}/delete")
    public String delete(@PathVariable Integer id, Model model){
        model.addAttribute("category", categoryService.findById(id));
        return "category/delete";
    }
    @RequestMapping("/category/delete")
    public String delete(Category category, RedirectAttributes redirect){
        categoryService.remove(category.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/listCategory";
    }
//    @RequestMapping("/category/{id}/view")
//    public String view(@PathVariable Integer id, Model model){
//        model.addAttribute("category", categoryService.findById(id));
//        return "category/view";
//    }
    @RequestMapping("/category/{id}/view")
    public ModelAndView viewCategory(@PathVariable("id") Integer id){
        Category category = categoryService.findById(id);
        Iterable<Blog> blogIterable = blogService.findByCategory(category);

        ModelAndView modelAndView = new ModelAndView("category/view");
        modelAndView.addObject("category", category);
        modelAndView.addObject("blog", blogIterable);
        return modelAndView;
    }

}
