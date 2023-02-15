package com.plaxa.spring_course.repository;

import com.plaxa.spring_course.dto.PersonalInfo2;
import com.plaxa.spring_course.entity.Role;
import com.plaxa.spring_course.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends
        JpaRepository<User, Long>,
        FilterUserRepository,
        RevisionRepository<User, Long, Integer>,
        QuerydslPredicateExecutor<User> {

    @Query("select u from User u " +
            "where u.firstname like %:firstname% " +
            "and u.lastname like %:lastname%")
    List<User> findAllBy(String firstname, String lastname);

    @Query(value = "SELECT u.* FROM users u WHERE u.username = :username",
            nativeQuery = true)
    List<User> findAllByUsername(String username);

    @Modifying(clearAutomatically = true)
    @Query("update User u " +
            "set u.role = :role " +
            "where u.id in (:ids)")
    int updateRole(Role role, Long... ids);

    Optional<User> findTopByOrderByIdDesc();

    @QueryHints(@QueryHint(name = "org.hibernate.fetchSize", value = "50"))
    @Lock(LockModeType.OPTIMISTIC)
    List<User> findTop3ByBirthDateBefore(LocalDate birthDate, Sort sort);

    @EntityGraph(attributePaths = {"company", "company.locales"})
    @Query(value = "select u from User u",
            countQuery = "select count(distinct u.firstname) from User u")
    Page<User> findAllBy(Pageable pageable);

//    List<PersonalInfo> findAllByCompanyId(Integer companyId);

//    <T> List<T> findAllByCompanyId(Integer companyId, Class<T> clazz);

    @Query(value = "Select firstname, lastname, birth_date birthDate " +
            "from users where companyId = :companyId",
            nativeQuery = true)
    List<PersonalInfo2> findAllByCompanyId(Integer companyId);

    Optional<User> findByUsername(String username);
}
