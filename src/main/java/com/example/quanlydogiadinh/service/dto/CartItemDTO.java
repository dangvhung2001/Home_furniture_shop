package com.example.quanlydogiadinh.service.dto;

import com.example.quanlydogiadinh.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private Long id;
    private ProductDTO product;
    private int quantity;
    // Getters and setters
}
