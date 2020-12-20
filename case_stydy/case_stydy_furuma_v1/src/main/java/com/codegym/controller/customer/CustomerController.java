package com.codegym.controller.customer;

import com.codegym.entity.customer.Customer;
import com.codegym.entity.customer.CustomerType;
import com.codegym.entity.customer.GenderPerson;
import com.codegym.service.customer.CustomerService;
import com.codegym.service.customer.CustomerTypeService;
import com.codegym.service.customer.GenderService;
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
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerTypeService customerTypeService;
    @Autowired
    private GenderService genderService;

    //    private CustomerValidator customerValidator;
    @ModelAttribute("customerTypeList")
    public List<CustomerType> customerTypeList() {
        return customerTypeService.findAll();
    }

    @ModelAttribute("genderList")
    public List<GenderPerson> genderPersonList() {
        return genderService.findAll();
    }

    @ModelAttribute("customer")
    public Customer getCustomer(Customer customer) {
        customer = new Customer();
        return customer;
    }
//    @GetMapping("/listCustomer")
//    public String listCustomer(Principal principal,
//                               Model model, @PageableDefault(size = 3) Pageable pageable, @RequestParam Optional<String> input) {
//        String inputCheck = "";
//        if (!input.isPresent()) {
//            model.addAttribute("customerList", this.customerService.findPageAll(pageable));
//        } else {
//            inputCheck = input.get();
//            model.addAttribute("customerList", this.customerService.searchByName(inputCheck, pageable));
//        }
//        model.addAttribute("inputCheck", inputCheck);
//        return "customer/index";
//    }

    @GetMapping("/listCustomer")
    public String listCustomer(Principal principal,
                               Model model, @PageableDefault(size = 3) Pageable pageable,
                               @RequestParam Optional<String> input01,
                               @RequestParam Optional<String> input02,
                               @RequestParam Optional<String> input03) {
        String inputCheck01 = "";
        String inputCheck02 = "";
        String inputCheck03 = "";

        if (!input01.isPresent() && !input02.isPresent() && !input03.isPresent()) {
            model.addAttribute("customerList", this.customerService.findPageAll(pageable));
        } else {
            inputCheck01 = input01.get();
            inputCheck02 = input02.get();
            inputCheck03 = input03.get();
            //model.addAttribute("customerList", this.customerService.searchNameAndAddress(inputCheck01, inputCheck02, pageable));
            switch (inputCheck01) {
                case "address":
                    model.addAttribute("customerList", this.customerService.searchAddress(inputCheck02, inputCheck03, pageable));
                    break;
                case "phone":
                    model.addAttribute("customerList", this.customerService.searchPhone(inputCheck02, inputCheck03, pageable));
                    break;
                case "email":
                    model.addAttribute("customerList", this.customerService.searchEmail(inputCheck02, inputCheck03, pageable));
                    break;
                case "customerType":
                    model.addAttribute("customerList", this.customerService.searchCustomerType(inputCheck02, inputCheck03, pageable));
                    break;
                case "Id Card":
                    model.addAttribute("customerList", this.customerService.searchIdCard(inputCheck02, inputCheck03, pageable));
                    break;
            }
        }
        model.addAttribute("inputCheck01", inputCheck01);
        model.addAttribute("inputCheck02", inputCheck02);
        return "customer/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        //model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes attributes) {
        Duplicate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            return "customer/create";
        }
        customerService.save(customer);
        attributes.addFlashAttribute("success", "Saved customer successfully!");
        return "redirect:/customer/listCustomer";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Customer customer, BindingResult bindingResult, RedirectAttributes attributes) {
        Duplicate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            return "customer/edit";
        }
        customerService.save(customer);
        attributes.addFlashAttribute("success", "Modified customer successfully!");
        return "redirect:/customer/listCustomer";
    }

        @GetMapping("/{id}/delete")
    public String remove(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/delete";
    }

    @PostMapping("/delete")
    public String delete(Customer customer, RedirectAttributes attributes) {
        customerService.remove(customer.getId());
        attributes.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer/listCustomer";
    }
//    @GetMapping("/delete")
//    public String delete(@RequestParam Long deleteID, RedirectAttributes redirectAttributes) {
//        customerService.remove(deleteID);
//        redirectAttributes.addFlashAttribute("success", "Delete Successful");
//        return "redirect:/customer/listCustomer";
//    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/view";
    }

    public void Duplicate(@ModelAttribute @Valid Customer customer, BindingResult bindingResult) {
        for (Customer cus : customerService.findAll()) {
            if (cus.getIdCard().equals(customer.getIdCard()) && !cus.getId().equals(customer.getId())) {
                bindingResult.rejectValue("idCard", "error.customer", "The ID card is already exist");
                break;
            }
        }
        for (Customer cus : customerService.findAll()) {
            if (cus.getEmail().equals(customer.getEmail()) && !cus.getId().equals(customer.getId())) {
                bindingResult.rejectValue("email", "error.customer", "The Email is already exist");
                break;
            }
        }
        for (Customer cus : customerService.findAll()) {
            if (cus.getPhone().equals(customer.getPhone()) && !cus.getId().equals(customer.getId())) {
                bindingResult.rejectValue("phone", "error.customer", "The Phone is already exist");
                break;
            }
        }
    }
}
