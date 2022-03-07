package com.plaxa.spring_course.repository;

import com.plaxa.spring_course.dto.UserFilter;
import com.plaxa.spring_course.entity.User;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);
}
