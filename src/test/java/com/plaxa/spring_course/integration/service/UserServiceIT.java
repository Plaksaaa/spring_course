package com.plaxa.spring_course.integration.service;

import com.plaxa.spring_course.dto.CompanyReadDto;
import com.plaxa.spring_course.integration.annotation.IT;
import com.plaxa.spring_course.pool.ConnectionPool;
import com.plaxa.spring_course.service.CompanyService;
import com.plaxa.spring_course.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@RequiredArgsConstructor
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserServiceIT {

    private final UserService userService;
    private final ConnectionPool pool1;

    @Test
    void test() {

    }

    @Test
    void test2() {

    }
}
