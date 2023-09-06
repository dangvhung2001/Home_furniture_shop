package com.example.quanlydogiadinh.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String email;
    private boolean status;
    private String phoneNumber;
    // Getters and setters
    private Set<String> roles;
}
