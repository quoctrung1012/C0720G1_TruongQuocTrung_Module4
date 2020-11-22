package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.ConvertService;

@Controller
public class ConvertMoney {
    @Qualifier("convertServiceImpl")
    @Autowired
    private ConvertService convertService;

    @GetMapping({"/converts"})
    public String convertUsdToVnd(@RequestParam String number, Model model){
        double num = Double.parseDouble(number);
//        double result = num * 23000;
        double result = convertService.convert(num);
        model.addAttribute("result", result);

        return "display";
    }
}
