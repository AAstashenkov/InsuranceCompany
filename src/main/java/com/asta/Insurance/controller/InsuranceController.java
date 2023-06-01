package com.asta.Insurance.controller;

import com.asta.Insurance.model.Insurance;
import com.asta.Insurance.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/insurances")
@RequiredArgsConstructor
public class InsuranceController {

    private final InsuranceService insuranceService;


    @GetMapping
    public String getAll(@RequestParam(name = "query", required = false) String query, Model model) {
        List<Insurance> insurances = insuranceService.getAll(query);
        model.addAttribute("insurances", insurances);
        return "insurances";
    }


    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Insurance insurance = insuranceService.getById(id);
        model.addAttribute("insurance", insurance);
        return "viewInsurance";
    }

    @PostMapping("/delete/{id}")
    public String deleteInsurance(@PathVariable Long id){
        insuranceService.deleteInsurance(id);
        return "redirect:/insurances";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        Insurance insurance = insuranceService.getById(id);
        model.addAttribute("insurance", insurance);
        return "editInsurance";
    }


    @PostMapping("/edit/{id}")
    public String updateAgent(@PathVariable Long id, @ModelAttribute Insurance updatedInsurance) {
        insuranceService.updateInsurance(id, updatedInsurance);
        return "redirect:/insurances/" + id;
    }

    @PostMapping("/save")
    public String saveAgent(@ModelAttribute("insurance") Insurance insurance) {
        insuranceService.save(insurance);
        return "redirect:/insurances";
    }

    @GetMapping("/add")
    public String getAddForm(Model model) {
        model.addAttribute("insurance", new Insurance());
        return "addInsurance";
    }

    @PostMapping("/add")
    public String addInsurance(@ModelAttribute Insurance insurance) {
        insuranceService.save(insurance);
        return "redirect:/insurances";
    }
}
