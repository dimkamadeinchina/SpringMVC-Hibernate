package com.example.controller;

import com.example.model.Company;
import com.example.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
}