package com.baluchi.ecommerce.ecommerce.dto;

import com.baluchi.ecommerce.ecommerce.enums.UserRole;

import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String email;

    private String name;

    private UserRole userRole;

}
