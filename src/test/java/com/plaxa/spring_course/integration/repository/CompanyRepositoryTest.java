package com.plaxa.spring_course.integration.repository;

import com.plaxa.spring_course.entity.Company;
import com.plaxa.spring_course.integration.annotation.IT;
import com.plaxa.spring_course.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@RequiredArgsConstructor
class CompanyRepositoryTest {

    private final EntityManager entityManager;
    private final CompanyRepository companyRepository;
    private static final Integer META_ID = 2;

    @Test
    void checkFindByQueries(){
        companyRepository.findByName("Google");
        companyRepository.findAllByNameContainingIgnoreCase("a");
    }

    @Test
    void delete() {
        var maybeCompany = companyRepository.findById(META_ID);
        assertTrue(maybeCompany.isPresent());
        maybeCompany.ifPresent(companyRepository::delete);
        entityManager.flush();
        assertTrue(companyRepository.findById(META_ID).isEmpty());
    }

    @Test
    void findById() {
        var company = entityManager.find(Company.class, 1L);
        assertNotNull(company);
        assertThat(company.getLocales()).hasSize(2);
    }

    @Test
    void save() {
        var company = Company.builder()
                .name("Apple")
                .locales(Map.of(
                        "ru", "Apple описание",
                        "en", "Apple description"
                ))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }
}