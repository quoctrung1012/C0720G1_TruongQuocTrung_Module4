package com.codegym.controller.contract_detail;

import com.codegym.entity.contract.Contract;
import com.codegym.entity.contract_detail.AttachService;
import com.codegym.entity.contract_detail.ContractDetail;
import com.codegym.service.contract.ContractService;
import com.codegym.service.contract_detail.AttachServiceService;
import com.codegym.service.contract_detail.ContractDetailService;
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
@RequestMapping("contract_detail")
public class ContractDetailController {
    @Autowired
    private ContractDetailService contractDetailService;
    @Autowired
    private AttachServiceService attachServiceService;
    @Autowired
    private ContractService contractService;

    @ModelAttribute("attachServiceList")
    public List<AttachService> attachServiceList() {
        return attachServiceService.findAll();
    }

    @ModelAttribute("contractList")
    public List<Contract> contractList() {
        return contractService.findAll();
    }

    @GetMapping("/listContractDetail")
    public String listContractDetail(Principal principal,
                                     Model model, @PageableDefault(size = 3) Pageable pageable, @RequestParam Optional<String> input) {
        String inputCheck = "";
        if (!input.isPresent()) {
            model.addAttribute("contractDetailList", this.contractDetailService.findPageAll(pageable));
        } else {
            inputCheck = input.get();
            model.addAttribute("contractList", this.contractDetailService.searchByName(inputCheck, pageable));
        }
        model.addAttribute("inputCheck", inputCheck);
        return "contract_detail/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("contractDetail", new ContractDetail());
        return "contract_detail/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute ContractDetail contractDetail, BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "contract_detail/create";
        }
        contractDetailService.save(contractDetail);
        attributes.addFlashAttribute("success", "Saved contract detail successfully!");
        return "redirect:/contract_detail/listContractDetail";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("contractDetail", contractDetailService.findById(id));
        return "contract_detail/edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute ContractDetail contractDetail, BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "contract_detail/edit";
        }
        contractDetailService.save(contractDetail);
        attributes.addFlashAttribute("success", "Modified contract detail successfully!");
        return "redirect:/contract_detail/listContractDetail";
    }

    @GetMapping("/{id}/delete")
    public String remove(@PathVariable Long id, Model model) {
        model.addAttribute("contractDetail", contractDetailService.findById(id));
        return "contract_detail/delete";
    }

    @PostMapping("/delete")
    public String delete(ContractDetail contractDetail, RedirectAttributes attributes) {
        contractDetailService.remove(contractDetail.getId());
        attributes.addFlashAttribute("success", "Removed contract detail successfully!");
        return "redirect:/contract_detail/listContractDetail";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("contractDetail", contractDetailService.findById(id));
        return "contract_detail/view";
    }
}
