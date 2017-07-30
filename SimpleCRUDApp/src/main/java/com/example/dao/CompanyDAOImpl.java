package com.example.dao;

import com.example.model.Company;
import com.example.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompanyDAOImpl implements CompanyDAO {

    @Autowired
    private HibernateUtil hibernateUtil;
    @Override
    public long createCompany(Company company) {
        return (Long) hibernateUtil.create(company);
    }
    @Override
    public Company updateCompany(Company company) {
        return hibernateUtil.update(company);
    }
    @Override
    public void deleteCompany(long id) {
        Company company = new Company();
        company.setId(id);
        hibernateUtil.delete(company);
    }
    @Override
    public List<Company> getAllCompanies() {
        return hibernateUtil.fetchAll(Company.class);
    }
    @Override
    public Company getCompany(long id) {
        return hibernateUtil.fetchById(id, Company.class);
    }
}
