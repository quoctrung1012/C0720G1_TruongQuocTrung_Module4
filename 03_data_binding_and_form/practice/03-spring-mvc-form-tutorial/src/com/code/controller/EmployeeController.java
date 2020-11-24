package com.code.controller;

import com.code.model.Employee;
import com.code.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Qualifier("employeeServiceImpl")
    @Autowired
    private EmployeeService employeeService;

    public String goEmployeeList(Model model){
        model.addAttribute("listEmployee",this.employeeService.getAllEmployee());
        return "list_Employee";
    }

    @RequestMapping(value = "showForm", method = RequestMethod.GET)
    public String showForm(ModelMap model) {
        model.addAttribute("employee", new Employee());
        return "create";
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public String submit(@ModelAttribute("employee") Employee employee, BindingResult result, ModelMap model) {
        model.addAttribute("name", employee.getName());
        model.addAttribute("contactNumber", employee.getContactNumber());
        model.addAttribute("id", employee.getId());
        return "info";
    }

}
