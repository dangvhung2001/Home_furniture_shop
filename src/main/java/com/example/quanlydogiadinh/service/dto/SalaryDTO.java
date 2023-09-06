package com.example.quanlydogiadinh.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalaryDTO {
    private Long id;
    private EmployeeDTO employee;
    private float amount;
    private Date paymentDate;
    private String status;
}

