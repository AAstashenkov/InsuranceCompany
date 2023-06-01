package com.asta.Insurance.repository;

import com.asta.Insurance.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    @Query(value = "SELECT a.*, ag.name FROM insurance AS a LEFT JOIN agent AS ag ON a.agent_id = ag.id WHERE ag.name LIKE %?1% OR a.duration_of_insurance LIKE %?1% OR a.sum LIKE %?1%", nativeQuery = true)
    List<Insurance> findByQuery(String query);
}
