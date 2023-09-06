package com.example.quanlydogiadinh.service.mapper.impl;

import com.example.quanlydogiadinh.domain.Cart;
import com.example.quanlydogiadinh.domain.CartItem;
import com.example.quanlydogiadinh.service.dto.CartDTO;
import com.example.quanlydogiadinh.service.dto.CartItemDTO;
import com.example.quanlydogiadinh.service.mapper.CartItemMapper;
import com.example.quanlydogiadinh.service.mapper.CartMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartMapperImpl implements CartMapper {
    private final CartItemMapper cartItemMapper;
    public CartMapperImpl(CartItemMapper cartItemMapper) {
        this.cartItemMapper = cartItemMapper;
    }

    @Override
    public Cart toEntity(CartDTO dto) {
        if (dto == null) {
            return null;
        }
        Cart cart = new Cart();
        cart.setId(dto.getId());
        cart.setTotal(dto.getTotal());
        List<CartItem> cartItems = cartItemMapper.toEntity(dto.getCartItems());
        cart.setCartItems(cartItems);

        return cart;
    }

    @Override
    public CartDTO toDto(Cart entity) {
        if (entity == null) {
            return null;
        }
        CartDTO cartDTO = new CartDTO();
        cartDTO.setId(entity.getId());
        cartDTO.setTotal(entity.getTotal());

        List<CartItemDTO> cartItemDTOs = cartItemMapper.toDto(new ArrayList<>(entity.getCartItems()));
        cartDTO.setCartItems(cartItemDTOs);

        return cartDTO;
    }

    @Override
    public List<Cart> toEntity(List<CartDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<CartDTO> toDto(List<Cart> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
