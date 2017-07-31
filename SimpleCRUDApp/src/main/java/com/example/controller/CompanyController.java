package com.example.controller;

import com.example.model.Company;
import com.example.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = {"getAllCompanies", "/", "index"})
    public ModelAndView getAllEmployees() {
        List<Company> companyList = companyService.getAllCompanies();
        return new ModelAndView("companies", "companyList", companyList);
    }

    @RequestMapping("createCompany")
    public ModelAndView createCompany(@ModelAttribute Company company) {
        return new ModelAndView("company-form");
    }

    @RequestMapping("editCompany")
    public ModelAndView editCompany(@RequestParam long id, @ModelAttribute Company company) {
        company = companyService.getCompany(id);
        return new ModelAndView("company-form", "companyObject", company);
    }

    @RequestMapping("saveCompany")
    public ModelAndView saveCompany(@ModelAttribute Company company) {
        if(company.getId() == 0){
            companyService.createCompany(company);
        } else {
            companyService.updateCompany(company);
        }
        return new ModelAndView("redirect:getAllCompanies");
    }

    @RequestMapping("deleteCompany")
    public ModelAndView deleteCompany(@RequestParam long id) {
            companyService.deleteCompany(id);
        return new ModelAndView("redirect:getAllCompanies");
    }

    @RequestMapping("sortCompanies")
    public ModelAndView sortCompanies(@RequestParam("sort") String sort) {
        List<Company> companyList = companyService.getAllCompanies(sort);
        return new ModelAndView("companies", "companyList", companyList);
    }
}