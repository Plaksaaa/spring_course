package com.plaxa.spring_course.integration.service;

import com.plaxa.spring_course.dto.UserCreateEditDto;
import com.plaxa.spring_course.dto.UserReadDto;
import com.plaxa.spring_course.entity.Role;
import com.plaxa.spring_course.integration.IntegrationTestBase;
import com.plaxa.spring_course.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserServiceIT extends IntegrationTestBase {

    private static final Long USER_1 = 2L;
    private static final Integer COMPANY_1 = 1;

    private final UserService userService;

    @Test
    void findAll() {
        List<UserReadDto> result = userService.findAll();
        assertThat(result).hasSize(5);
    }

    @Test
    void findById() {
        Optional<UserReadDto> maybeUser = userService.findById(USER_1);
        assertTrue(maybeUser.isPresent());
        maybeUser.ifPresent(userReadDto -> assertEquals("ivan@gmail.com", userReadDto.getUsername()));
    }

    @Test
    void create() {
        UserCreateEditDto user = new UserCreateEditDto(
                "test@gmail.com",
                "test",
                LocalDate.now(),
                "test",
                "test",
                Role.USER,
                COMPANY_1,
                new MockMultipartFile("test", new byte[0])
        );
        UserReadDto actualResult = userService.create(user);

        assertEquals(user.getUsername(), actualResult.getUsername());
        assertEquals(user.getLastname(), actualResult.getLastname());
    }

    @Test
    void update() {
        UserCreateEditDto editDto = new UserCreateEditDto(
                "test@gmail.com",
                "test",
                LocalDate.now(),
                "test",
                "test",
                Role.USER,
                COMPANY_1,
                new MockMultipartFile("test", new byte[0])
        );
        Optional<UserReadDto> actualResult = userService.update(USER_1, editDto);

        assertTrue(actualResult.isPresent());
        actualResult.ifPresent(user -> {
            assertEquals(editDto.getUsername(), user.getUsername());
            assertEquals(editDto.getLastname(), user.getLastname());
        });
    }

    @Test
    void delete() {
        assertFalse(userService.delete(-124L));
        assertTrue(userService.delete(USER_1));
    }
}
