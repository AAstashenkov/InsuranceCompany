package com.asta.Insurance.repository;

import com.asta.Insurance.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query(value = "SELECT * from company as a where a.name LIKE %?1% OR a.number LIKE %?1%", nativeQuery = true)
    List<Company> findByQuery(String query);
}
