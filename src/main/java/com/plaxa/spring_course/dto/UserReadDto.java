package com.plaxa.spring_course.dto;

import com.plaxa.spring_course.entity.Role;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserReadDto {

    Long id;
    String username;
    LocalDate birthDate;
    String firstname;
    String lastname;
    String image;
    Role role;
    CompanyReadDto company;
}
