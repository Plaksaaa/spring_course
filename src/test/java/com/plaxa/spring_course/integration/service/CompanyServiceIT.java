package com.plaxa.spring_course.integration.service;

import com.plaxa.spring_course.dto.CompanyReadDto;
import com.plaxa.spring_course.integration.IntegrationTestBase;
import com.plaxa.spring_course.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ApplicationRunner.class,
initializers = ConfigDataApplicationContextInitializer.class)*/
//@SpringBootTest
//@ActiveProfiles("test")
//@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
public class CompanyServiceIT extends IntegrationTestBase {

    private static final Integer COMPANY_ID = 1;

    private final CompanyService companyService;

    @Test
    void findById() {
        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID, null);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
    }
}
