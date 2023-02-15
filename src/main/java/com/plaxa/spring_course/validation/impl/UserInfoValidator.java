package com.plaxa.spring_course.validation.impl;

import com.plaxa.spring_course.dto.UserCreateEditDto;
import com.plaxa.spring_course.validation.UserInfo;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserInfoValidator implements ConstraintValidator<UserInfo, UserCreateEditDto> {

    @Override
    public boolean isValid(UserCreateEditDto value, ConstraintValidatorContext context) {
        return StringUtils.hasText(value.getFirstname()) || StringUtils.hasText(value.getLastname());
    }
}
