package com.plaxa.spring_course.mapper;

import com.plaxa.spring_course.dto.CompanyReadDto;
import com.plaxa.spring_course.entity.Company;
import org.springframework.stereotype.Component;

@Component
public class CompanyReadMapper implements Mapper<Company, CompanyReadDto> {

    @Override
    public CompanyReadDto map(Company o) {
        return new CompanyReadDto(
               o.getId(),
               o.getName()
        );
    }
}
