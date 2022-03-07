package com.plaxa.spring_course.integration.repository;

import com.plaxa.spring_course.dto.PersonalInfo2;
import com.plaxa.spring_course.dto.UserFilter;
import com.plaxa.spring_course.entity.Role;
import com.plaxa.spring_course.entity.User;
import com.plaxa.spring_course.integration.annotation.IT;
import com.plaxa.spring_course.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void checkCustomImplementation() {
        UserFilter filter = new UserFilter(
                null, "%ov%", LocalDate.now()
        );
        userRepository.findAllByFilter(filter);
    }

    @Test
    void checkProjections() {
        List<PersonalInfo2> personalInfo = userRepository.findAllByCompanyId(1);
        assertThat(personalInfo).hasSize(2);
    }

    @Test
    void checkPageable() {
        var pageable = PageRequest.of(1, 2, Sort.by("id"));
        var slice = userRepository.findAllBy(pageable);
        slice.forEach(user -> System.out.println(user.getId()));

        while (slice.hasNext()) {
            slice = userRepository.findAllBy(slice.nextPageable());
            slice.forEach(user -> System.out.println(user.getId()));
        }
    }

    @Test
    void checkSort() {
        var sortBy = Sort.sort(User.class);
        var sort = sortBy.by(User::getFirstname)
                .and(sortBy.by(User::getLastname));

        var users = userRepository.findTop3ByBirthDateBefore(LocalDate.now(), sort);
        assertThat(users).hasSize(3);
    }

    @Test
    void findAllBy() {
        var users = userRepository.findAllBy("a", "ov");
        assertThat(users).hasSize(3);
        System.out.println(users);
    }

    @Test
    void checkUpdate() {
        var user = userRepository.getById(1L);
        assertSame(Role.ADMIN, user.getRole());

        var resultCount = userRepository.updateRole(Role.USER, 1L, 5L);
        assertEquals(2, resultCount);

        var theSameUser = userRepository.getById(1L);
        assertSame(Role.USER, theSameUser.getRole());
    }

    @Test
    void checkFirstTop() {
        var topUser = userRepository.findTopByOrderByIdDesc();
        assertTrue(topUser.isPresent());
        topUser.ifPresent(user -> assertEquals(5L, user.getId()));
    }
}