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
public class InvoiceDTO {
    private Long id;
    private CustomerDTO customer;
    private Date invoiceDate;
    private float totalAmount;
    // Getters and setters
}
