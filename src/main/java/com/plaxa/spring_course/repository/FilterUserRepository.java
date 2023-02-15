package com.plaxa.spring_course.repository;

import com.plaxa.spring_course.dto.PersonalInfo;
import com.plaxa.spring_course.dto.UserFilter;
import com.plaxa.spring_course.entity.Role;
import com.plaxa.spring_course.entity.User;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);

    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role);

    void updateCompanyAndRole(List<User> users);

    void updateCompanyAndRoleNamed(List<User> users);
}
