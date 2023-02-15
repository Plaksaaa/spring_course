package com.plaxa.spring_course.repository;

import com.plaxa.spring_course.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Integer> {

    // Optional, entity, future
    @Query(name = "")
    Optional<Company> findByName(String name);

    // Collection, Stream (batch, close)
    List<Company> findAllByNameContainingIgnoreCase(String fragment);
}
