package com.plaxa.spring_course.integration.service;

import com.plaxa.spring_course.ApplicationRunner;
import com.plaxa.spring_course.dto.CompanyReadDto;
import com.plaxa.spring_course.entity.Company;
import com.plaxa.spring_course.integration.annotation.IT;
import com.plaxa.spring_course.listener.entity.EntityEvent;
import com.plaxa.spring_course.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

/*@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationRunner.class,
initializers = ConfigDataApplicationContextInitializer.class)*/
//@SpringBootTest
//@ActiveProfiles("test")
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
@IT
public class CompanyServiceIT {

    private static final Integer COMPANY_ID = 1;

    private final CompanyService companyService;

    @Test
    void findById() {
        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
    }
}
