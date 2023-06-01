package com.asta.Insurance.repository;

import com.asta.Insurance.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {
    @Query(value = "select * from agent as a where a.surname LIKE %?1% OR a.number LIKE %?1% OR a.name LIKE %?1% OR a.father_name LIKE %?1% ", nativeQuery = true)
    List<Agent> findByQuery(String query);
}
