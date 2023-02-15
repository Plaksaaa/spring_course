package com.plaxa.spring_course.mapper;

import com.plaxa.spring_course.dto.CompanyReadDto;
import com.plaxa.spring_course.dto.UserReadDto;
import com.plaxa.spring_course.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserReadMapper implements Mapper<User, UserReadDto> {

    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDto map(User o) {
        CompanyReadDto company = Optional.ofNullable(o.getCompany())
                .map(companyReadMapper::map)
                .orElse(null);
        return new UserReadDto(
                o.getId(),
                o.getUsername(),
                o.getBirthDate(),
                o.getFirstname(),
                o.getLastname(),
                o.getImage(),
                o.getRole(),
                company
        );
    }
}
