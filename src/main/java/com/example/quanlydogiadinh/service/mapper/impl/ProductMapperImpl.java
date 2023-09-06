package com.example.quanlydogiadinh.service.mapper.impl;

import com.example.quanlydogiadinh.domain.Catalog;
import com.example.quanlydogiadinh.domain.Product;
import com.example.quanlydogiadinh.domain.Role;
import com.example.quanlydogiadinh.service.dto.CatalogDTO;
import com.example.quanlydogiadinh.service.dto.ProductDTO;
import com.example.quanlydogiadinh.service.mapper.CatalogMapper;
import com.example.quanlydogiadinh.service.mapper.ProductMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ProductMapperImpl implements ProductMapper {
    private final CatalogMapper catalogMapper; // Assuming you have a CatalogMapper

    public ProductMapperImpl(CatalogMapper catalogMapper) {
        this.catalogMapper = catalogMapper;
    }

    @Override
    public Product toEntity(ProductDTO dto) {
        if (dto == null) {
            return null;
        }
        Product product = new Product();
        product.setId(dto.getId());
        product.setProduct_ImgUrl(dto.getProduct_ImgUrl());
        product.setName(dto.getName());
        product.setProductCode(dto.getProductCode());
        product.setQuantity(dto.getQuantity());
        product.setDescription(dto.getDescription());
        product.setPrice(dto.getPrice());
        product.setStatus(dto.getStatus());
        return product;
    }

    @Override
    public ProductDTO toDto(Product entity) {
        if (entity == null) {
            return null;
        }
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(entity.getId());
        productDTO.setProduct_ImgUrl(entity.getProduct_ImgUrl());
        productDTO.setName(entity.getName());
        productDTO.setProductCode(entity.getProductCode());
        productDTO.setQuantity(entity.getQuantity());
        productDTO.setDescription(entity.getDescription());
        productDTO.setPrice(entity.getPrice());
        productDTO.setStatus(entity.getStatus());
        Set<Catalog> catalogs = entity.getCatalogs();
        if (catalogs != null) {
            productDTO.setCatalog(catalogs.stream().map(Catalog::getName).collect(Collectors.toSet()));
        }
        return productDTO;
    }

    @Override
    public List<Product> toEntity(List<ProductDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> toDto(List<Product> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
