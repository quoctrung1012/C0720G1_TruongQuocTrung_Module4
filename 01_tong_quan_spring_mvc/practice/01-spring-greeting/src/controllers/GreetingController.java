package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {
    //"/greeting" là đường dẫn đến trang jsp
    //@getMapping với @PostMapping là phương thức request bằng get với post

    @GetMapping("/greeting")
    public String greeting(@RequestParam String name, Model model){
        model.addAttribute("names", name);
        return "display";
    }
}
