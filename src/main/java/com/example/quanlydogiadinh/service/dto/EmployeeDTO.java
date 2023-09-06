package com.example.quanlydogiadinh.service.dto;

import com.example.quanlydogiadinh.domain.Salary;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String imgUrl;
    private String name;
    private String password;
    private Byte sex;
    private String maritalStatus;
    private Date dateOfBirth;
    private String citizenCode;
    private Date issueDate;
    private String placeOfIssue;
    private String employeeCode;
    @Email
    private String email;
    private String address;
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    private String phone;
    private String position;
    private String status;
    private Salary salary;
    private Set<String> roles;

}
