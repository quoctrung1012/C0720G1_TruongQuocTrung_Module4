package com.codegym.controller.employee;

import com.codegym.entity.account.AccountUser;
import com.codegym.entity.employee.Division;
import com.codegym.entity.employee.EducationDegree;
import com.codegym.entity.employee.Employee;
import com.codegym.entity.employee.Position;
import com.codegym.service.account.AccountUserService;
import com.codegym.service.employee.DivisionService;
import com.codegym.service.employee.EducationDegreeService;
import com.codegym.service.employee.EmployeeService;
import com.codegym.service.employee.PositionService;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private EducationDegreeService educationDegreeService;
    @Autowired
    private DivisionService divisionService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private AccountUserService accountUserService;

    @ModelAttribute("accountUserList")
    public List<AccountUser> accountUsersList(){
        return accountUserService.findAll();
    }
    @ModelAttribute("divisionList")
    public List<Division> divisionList() {
        return divisionService.findAll();
    }

    @ModelAttribute("positionList")
    public List<Position> positionList() {
        return positionService.findAll();
    }

    @ModelAttribute("educationDegreeList")
    public List<EducationDegree> educationDegreeList() {
        return educationDegreeService.findAll();
    }

    @GetMapping("/listEmployee")
    public String listEmployee(Principal principal,
                               Model model, @PageableDefault(size = 3) Pageable pageable, @RequestParam Optional<String> input) {
        String inputCheck = "";
        if (!input.isPresent()) {
            model.addAttribute("employeeList", this.employeeService.findPageAll(pageable));
        } else {
            inputCheck = input.get();
            model.addAttribute("employeeList", this.employeeService.searchByName(inputCheck, pageable));
        }
        model.addAttribute("inputCheck", inputCheck);
        return "employee/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, RedirectAttributes attributes) {
        Duplicate(employee, bindingResult);
        if (bindingResult.hasErrors()) {
            return "employee/create";
        }
        employeeService.save(employee);
        attributes.addFlashAttribute("success", "Saved employee successfully!");
        return "redirect:/employee/listEmployee";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, RedirectAttributes attributes) {
        Duplicate(employee, bindingResult);
        if (bindingResult.hasErrors()) {
            return "employee/edit";
        }
        employeeService.save(employee);
        attributes.addFlashAttribute("success", "Modified employee successfully!");
        return "redirect:/employee/listEmployee";
    }

    @GetMapping("/{id}/delete")
    public String remove(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/delete";
    }

    @PostMapping("/delete")
    public String delete(Employee employee, RedirectAttributes attributes) {
        employeeService.remove(employee.getId());
        attributes.addFlashAttribute("success", "Removed employee successfully!");
        return "redirect:/employee/listEmployee";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/view";
    }
    public void Duplicate(@ModelAttribute @Valid Employee employee, BindingResult bindingResult) {
        for (Employee emp : employeeService.findAll()) {
            if (emp.getIdCard().equals(employee.getIdCard()) && !emp.getId().equals(employee.getId())) {
                bindingResult.rejectValue("idCard", "error.employee", "The ID card is already exist");
                break;
            }
        }
        for (Employee emp : employeeService.findAll()) {
            if (emp.getEmail().equals(employee.getEmail()) && !emp.getId().equals(employee.getId())) {
                bindingResult.rejectValue("email", "error.employee", "The Email is already exist");
                break;
            }
        }
        for (Employee emp : employeeService.findAll()) {
            if (emp.getPhone().equals(employee.getPhone()) && !emp.getId().equals(employee.getId())) {
                bindingResult.rejectValue("phone", "error.employee", "The Phone is already exist");
                break;
            }
        }
    }
}
