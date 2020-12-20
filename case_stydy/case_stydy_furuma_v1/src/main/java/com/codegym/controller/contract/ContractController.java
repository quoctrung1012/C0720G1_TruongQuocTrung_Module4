package com.codegym.controller.contract;

import com.codegym.entity.contract.Contract;
import com.codegym.entity.contract_detail.AttachService;
import com.codegym.entity.customer.Customer;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.service.ServiceResort;
import com.codegym.service.contract.ContractService;
import com.codegym.service.contract_detail.AttachServiceService;
import com.codegym.service.customer.CustomerService;
import com.codegym.service.employee.EmployeeService;
import com.codegym.service.service_resort.ServiceResortService;
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
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ServiceResortService serviceResortService;
    @Autowired
    private ContractService contractService;
    @Autowired
    private AttachServiceService attachServiceService;

    @ModelAttribute("customerList")
    public List<Customer> customerList() {
        return customerService.findAll();
    }

    @ModelAttribute("employeeList")
    public List<Employee> employeeList() {
        return employeeService.findAll();
    }

    @ModelAttribute
    public List<ServiceResort> serviceResortList() {
        return serviceResortService.findAll();
    }

    @GetMapping("/listContract")
    public String listEmployee(Principal principal,
                               Model model, @PageableDefault(size = 3) Pageable pageable, @RequestParam Optional<String> input) {
        String inputCheck = "";
        if (!input.isPresent()) {
            model.addAttribute("contractList", this.contractService.findPageAll(pageable));
        } else {
            inputCheck = input.get();
            model.addAttribute("contractList", this.contractService.searchByName(inputCheck, pageable));
        }
        model.addAttribute("inputCheck", inputCheck);
        return "contract/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("contract", new Contract());
        return "contract/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Contract contract, BindingResult bindingResult, RedirectAttributes attributes) {
        validateDateContract(contract, bindingResult);
        new Contract().validate(contract, bindingResult);
        if (bindingResult.hasErrors()) {
            return "contract/create";
        }
        contractService.save(contract);
        attributes.addFlashAttribute("success", "Saved contract successfully!");
        return "redirect:/contract/listContract";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("contract", contractService.findById(id));
        return "contract/edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Contract contract, BindingResult bindingResult, RedirectAttributes attributes) {
        validateDateContract(contract, bindingResult);
        if (bindingResult.hasErrors()) {
            return "contract/edit";
        }
        contractService.save(contract);
        attributes.addFlashAttribute("success", "Modified contract successfully!");
        return "redirect:/contract/listContract";
    }

    @GetMapping("/{id}/delete")
    public String remove(@PathVariable Long id, Model model) {
        model.addAttribute("contract", contractService.findById(id));
        return "contract/delete";
    }

    @PostMapping("/delete")
    public String delete(Contract contract, RedirectAttributes attributes) {
        contractService.remove(contract.getId());
        attributes.addFlashAttribute("success", "Removed contract successfully!");
        return "redirect:/contract/listContract";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("contract", contractService.findById(id));
        return "contract/view";
    }

    public void validateDateContract(@ModelAttribute @Valid Contract contract, BindingResult bindingResult) {
        try {
            LocalDate startDate = LocalDate.parse(contract.getStartDate());
            LocalDate endDate = LocalDate.parse(contract.getEndDate());
            if (endDate.compareTo(startDate) <= 0) {
                bindingResult.rejectValue("startDate", "error.contract", "End Date must be after Start Date");
                bindingResult.rejectValue("endDate", "error.contract", "End Date must be after Start Date");
            }
        } catch (Exception e) {
            bindingResult.rejectValue("startDate", "error.contract", "Date can't be empty");
            bindingResult.rejectValue("endDate", "error.contract", "Date can't be empty");
        }
    }
}
