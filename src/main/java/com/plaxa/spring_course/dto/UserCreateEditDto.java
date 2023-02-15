package com.plaxa.spring_course.dto;

import com.plaxa.spring_course.entity.Role;
import com.plaxa.spring_course.validation.UserInfo;
import com.plaxa.spring_course.validation.group.CreateAction;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Value
@FieldNameConstants
@UserInfo(groups = CreateAction.class)
public class UserCreateEditDto {

    @Email
    String username;

    @NotBlank(groups = CreateAction.class)
    String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;

    @NotBlank
    String firstname;

    @NotBlank
    String lastname;

    Role role;

    Integer companyId;

    MultipartFile image;
}
