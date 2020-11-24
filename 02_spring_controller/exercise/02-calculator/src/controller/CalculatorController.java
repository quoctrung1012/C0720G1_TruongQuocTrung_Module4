package controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Qualifier("calculatorServiceImpl")
    @Autowired
    private CalculatorService calculatorService;

    @RequestMapping({"","/","home"})
    public String getIndex() {
        return "display";
    }

    @GetMapping("/calculator")
    public String getCalculator(@RequestParam double number1, @RequestParam double number2, @RequestParam String calculator, Model model){
        double result = 0;
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
                String message = "Bạn đã nhập số 0";
                if (number2 == 0 ){
                    model.addAttribute("message", message);
                } else {
                    result = calculatorService.calculatorDiv(number1,number2);
                }
        }
        model.addAttribute("result", result);
        return "display";
    }
}
