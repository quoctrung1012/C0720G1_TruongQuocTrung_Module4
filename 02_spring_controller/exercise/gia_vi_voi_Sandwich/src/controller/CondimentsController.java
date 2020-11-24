package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CondimentsController {
    @GetMapping("/condiment")
    public String listCondiment(@RequestParam ( defaultValue = "không có") String[] condiment, Model model){
        model.addAttribute("condiment",condiment);
        return "condiments";
    }
}
