package com.asta.Insurance.service;

import com.asta.Insurance.model.Company;
import com.asta.Insurance.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> getAll(String query) {
        if (query != null) {
            return companyRepository.findByQuery(query);
        }
        return companyRepository.findAll();
    }

    public Company getById(Long id) {
        return companyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    public void updateCompany(Long id, Company updatedCompany) {
        Company company = this.getById(id);


        company.setNumber(updatedCompany.getNumber());
        company.setName(updatedCompany.getName());

        companyRepository.save(company);
    }
    public void save(Company company) {
        companyRepository.save(company);
    }
}
