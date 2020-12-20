package com.codegym.controller.service;

import com.codegym.entity.service.RentType;
import com.codegym.entity.service.ServiceResort;
import com.codegym.entity.service.ServiceType;
import com.codegym.service.service_resort.RentTypeService;
import com.codegym.service.service_resort.ServiceResortService;
import com.codegym.service.service_resort.ServiceTypeService;
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
@RequestMapping("/service_resort")
public class ServiceResortController {
    @Autowired
    private ServiceResortService serviceResortService;
    @Autowired
    private ServiceTypeService serviceTypeService;
    @Autowired
    private RentTypeService rentTypeService;

    @ModelAttribute("serviceTypeList")
    public List<ServiceType> serviceTypeList() {
        return serviceTypeService.findAll();
    }

    @ModelAttribute("rentTypeList")
    public List<RentType> rentTypeList() {
        return rentTypeService.findAll();
    }

    @GetMapping("/listServiceResort")
    public String listServiceResort(Principal principal,
                                    Model model, @PageableDefault(size = 3) Pageable pageable, @RequestParam Optional<String> input) {
        String inputCheck = "";
        if (!input.isPresent()) {
            model.addAttribute("serviceResortList", this.serviceResortService.findPageAll(pageable));
        } else {
            inputCheck = input.get();
            model.addAttribute("serviceResortList", this.serviceResortService.searchByName(inputCheck, pageable));
        }
        model.addAttribute("inputCheck", inputCheck);
        return "service/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("serviceResort", new ServiceResort());
        return "service/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute ServiceResort serviceResort, BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "service/create";
        }
        serviceResortService.save(serviceResort);
        attributes.addFlashAttribute("success", "Saved service successfully!");
        return "redirect:/service_resort/listServiceResort";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("serviceResort", serviceResortService.findById(id));
        return "service/edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute ServiceResort serviceResort, BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "service/edit";
        }
        serviceResortService.save(serviceResort);
        attributes.addFlashAttribute("success", "Modified service successfully!");
        return "redirect:/service_resort/listServiceResort";
    }

    @GetMapping("/{id}/delete")
    public String remove(@PathVariable Long id, Model model) {
        model.addAttribute("serviceResort", serviceResortService.findById(id));
        return "service/delete";
    }

    @PostMapping("/delete")
    public String delete(ServiceResort serviceResort, RedirectAttributes attributes) {
        serviceResortService.remove(serviceResort.getId());
        attributes.addFlashAttribute("success", "Removed service successfully!");
        return "redirect:/service_resort/listServiceResort";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("serviceResort", serviceResortService.findById(id));
        return "service/view";
    }
}
