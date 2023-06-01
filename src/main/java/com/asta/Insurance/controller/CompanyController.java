package com.asta.Insurance.controller;

import com.asta.Insurance.model.Company;
import com.asta.Insurance.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/companies")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;


    @GetMapping
    public String getAll(@RequestParam(name = "query", required = false) String query, Model model) {
        List<Company> companies = companyService.getAll(query);
        model.addAttribute("companies", companies);
        return "companies";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable Long id, Model model) {
        Company company = companyService.getById(id);
        model.addAttribute("company", company);
        return "viewCompany";
    }

    @PostMapping("/delete/{id}")
    public String deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
        return "redirect:/companies";
    }

    @GetMapping("/edit/{id}")
    public String getEditForm(@PathVariable Long id, Model model) {
        Company company = companyService.getById(id);
        model.addAttribute("company", company);
        return "editCompany";
    }


    @PostMapping("/edit/{id}")
    public String updateCompany(@PathVariable Long id, @ModelAttribute Company updatedCompany) {
        companyService.updateCompany(id, updatedCompany);
        return "redirect:/companies/" + id;
    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("company") Company company) {
        companyService.save(company);
        return "redirect:/companies";
    }

    @GetMapping("/add")
    public String getAddForm(Model model) {
        model.addAttribute("company", new Company());
        return "addCompany";
    }

    @PostMapping("/add")
    public String addCompany(@ModelAttribute Company company) {
        companyService.save(company);
        return "redirect:/companies";
    }
}
