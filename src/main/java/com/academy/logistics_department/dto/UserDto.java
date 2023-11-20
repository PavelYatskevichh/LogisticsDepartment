package com.academy.logistics_department.dto;

import com.academy.logistics_department.model.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Integer id;
    private Role role;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
}
