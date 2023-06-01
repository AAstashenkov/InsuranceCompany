package com.asta.Insurance.repository;

import com.asta.Insurance.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query(value = "select * from client as a where a.surname LIKE %?1% OR a.name LIKE %?1% OR a.father_name LIKE %?1%", nativeQuery = true)
    List<Client> findByQuery(String query);
}
