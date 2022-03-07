package com.plaxa.spring_course.service;

import com.plaxa.spring_course.repository.CompanyRepository;
import com.plaxa.spring_course.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    /*public UserService(UserRepository userRepository, CrudRepository<Integer, Company> crudRepository) {
        this.userRepository = userRepository;
        this.crudRepository = crudRepository;
    }*/
}
