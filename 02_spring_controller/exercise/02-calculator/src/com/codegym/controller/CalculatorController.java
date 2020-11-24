package com.codegym.controller;

import com.codegym.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/calculator")
public class CalculatorController {

    @Qualifier("calculatorServiceImplSum")
    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String showAdditionForm() {
        return "add";
    }

    @GetMapping("/calculator")
    public String sum(@RequestParam double number1, @RequestParam double number2, Model model){
        double result  = calculatorService.calculator(number1, number2);
        model.addAttribute("result", result);
        return "display";
    }
}
