package com.example.quanlydogiadinh.service.mapper.impl;

import com.example.quanlydogiadinh.domain.CartItem;
import com.example.quanlydogiadinh.service.dto.CartItemDTO;
import com.example.quanlydogiadinh.service.mapper.CartItemMapper;
import com.example.quanlydogiadinh.service.mapper.CartMapper;
import com.example.quanlydogiadinh.service.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CartItemMapperImpl implements CartItemMapper {
    private final CartMapper cartMapper;
    private final ProductMapper productMapper;
    public CartItemMapperImpl(CartMapper cartMapper, ProductMapper productMapper) {
        this.cartMapper = cartMapper;
        this.productMapper = productMapper;
    }

    @Override
    public CartItem toEntity(CartItemDTO dto) {
        if (dto == null) {
            return null;
        }
        CartItem cartItem = new CartItem();
        cartItem.setId(dto.getId());
        cartItem.setProduct(productMapper.toEntity(dto.getProduct()));
        cartItem.setQuantity(dto.getQuantity());
        return cartItem;
    }

    @Override
    public CartItemDTO toDto(CartItem entity) {
        if (entity == null) {
            return null;
        }
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setId(entity.getId());
        cartItemDTO.setProduct(productMapper.toDto(entity.getProduct()));
        cartItemDTO.setQuantity(entity.getQuantity());
        return cartItemDTO;
    }

    @Override
    public List<CartItem> toEntity(List<CartItemDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<CartItemDTO> toDto(List<CartItem> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}

