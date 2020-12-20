package com.codegym.controller.contract_detail;

import com.codegym.entity.contract_detail.AttachService;
import com.codegym.service.contract_detail.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/attach")
public class AttachServiceController {
    @Autowired
    private AttachServiceService attachServiceService;

    @GetMapping("/listAttach")
    public String listAttach(Model model) {
        List<AttachService> attachServiceList = attachServiceService.findAll();
        model.addAttribute("attachList", attachServiceList);
        return "attach_service/index";
    }
//    @GetMapping("/listAttachBook")
//    public String listAttachBook(Model model) {
//        List<AttachService> attachServiceList = attachServiceService.findAll();
//        model.addAttribute("attachListBook", attachServiceList);
//        return "contract/create";
//    }
}
