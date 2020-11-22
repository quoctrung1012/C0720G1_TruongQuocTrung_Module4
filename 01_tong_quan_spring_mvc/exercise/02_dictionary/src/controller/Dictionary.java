package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.DictionaryService;

import java.util.Map;
import java.util.TreeMap;
@Controller
public class Dictionary {
    @Qualifier("dictionaryServiceImpl")
    @Autowired
    private DictionaryService dictionaryService;

    @GetMapping("/dictionary")
    public String searchDictionary(@RequestParam String string, Model model){
//        Map<String, String> dictionaryMap = new TreeMap<>();
//        dictionaryMap.put("Một", "One");
//        dictionaryMap.put("Hai", "Two");
//        dictionaryMap.put("Ba", "Three");
//        dictionaryMap.put("Bốn", "Four");
//        dictionaryMap.put("Năm", "Five");
//        String result =  dictionaryMap.get(string);
        String result = dictionaryService.search(string);
        String message = "Không tìm thấy";
        if (result == null){
            model.addAttribute("string",message);
        }else {
            model.addAttribute("string", result);
        }
        return "display";
    }
}
