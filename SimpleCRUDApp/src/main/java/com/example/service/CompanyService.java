package com.example.service;

import com.example.model.Company;

import java.util.List;

public interface CompanyService {

    public long createCompany(Company company);
    public Company updateCompany(Company company);
    public void deleteCompany(long id);
    public List<Company> getAllCompanies();
    public Company getCompany(long id);
}
