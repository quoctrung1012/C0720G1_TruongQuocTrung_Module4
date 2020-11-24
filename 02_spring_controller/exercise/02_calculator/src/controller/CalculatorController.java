package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.CalculatorService;

@Controller
public class CalculatorController {

    @RequestMapping({"","/","home"})
    public String getHome() {
        return "home";
    }

    @Qualifier("calculatorServiceImpl")
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping({"/calculator"})
    public String getCalculator(@RequestParam double number1, @RequestParam double number2, @RequestParam String calculator, Model model){
        double result = 0;
        String message = "Bạn đã nhập số 0";
        switch (calculator){
            case "Addition(+)":
                result = calculatorService.calculatorSum(number1, number2);
                break;
            case  "Subtraction(-)":
                result = calculatorService.calculatorSub(number1, number2);
                break;
            case "Multiplication(*)":
                result = calculatorService.calculatorMulti(number1,number2);
                break;
            case "Division(/)":
                if (number2 != 0 ){
                    result = calculatorService.calculatorDiv(number1,number2);
                } else {
                    model.addAttribute("message", message);
                    return "home";
                }
        }
        model.addAttribute("result", result);
        return "home";
    }
}
