package com.example.quanlydogiadinh.service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private String product_ImgUrl;
    private String productCode;
    private int quantity;
    private String description;
    private float price;
    private String status;
    private Set<String> catalog;
}
