package com.example.quanlydogiadinh.service.dto;

import com.example.quanlydogiadinh.domain.CartItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {
    private Long id;
    private CustomerDTO customer;
    private float total;
    private List<CartItemDTO> cartItems;
    // Getters and setters
}
