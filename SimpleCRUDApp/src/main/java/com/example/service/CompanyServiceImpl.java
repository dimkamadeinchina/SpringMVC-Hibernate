package com.example.service;

import com.example.dao.CompanyDAO;
import com.example.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyDAO companyDAOImpl;
    @Override
    public long createCompany(Company company) {
        return companyDAOImpl.createCompany(company);
    }
    @Override
    public Company updateCompany(Company company) {
        return companyDAOImpl.updateCompany(company);
    }
    @Override
    public void deleteCompany(long id) {
        companyDAOImpl.deleteCompany(id);
    }
    @Override
    public List<Company> getAllCompanies() {
        return companyDAOImpl.getAllCompanies();
    }
    @Override
    public Company getCompany(long id) {
        return companyDAOImpl.getCompany(id);
    }
    @Override
    public  List<Company> getAllCompanies(String sort){
        return companyDAOImpl.sortBy(sort);
    }
}
