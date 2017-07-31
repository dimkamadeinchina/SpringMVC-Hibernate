package com.example.dao;

import com.example.model.Company;
import com.example.util.HibernateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
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

    @SuppressWarnings("unchecked")
    @Override
    public List<Company> sortBy(String sort){
        String query = "SELECT c.* FROM companies c ORDER BY "+ sort +" ASC";
        List<Object[]> companiesObjects = hibernateUtil.sortBy(query);
        List<Company> companies = new ArrayList<>();
        for(Object[] companiesObject: companiesObjects) {
            Company company = new Company();
            long id = ((BigInteger) companiesObject[0]).longValue();
            String name = (String) companiesObject[1];
            long minValue = ((BigInteger) companiesObject[2]).longValue();
            long maxValue = ((BigInteger) companiesObject[3]).longValue();
            company.setId(id);
            company.setName(name);
            company.setMinValue(minValue);
            company.setMaxValue(maxValue);
            companies.add(company);
        }
        return companies;
    }
}
