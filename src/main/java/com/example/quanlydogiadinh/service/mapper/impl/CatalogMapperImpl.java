package com.example.quanlydogiadinh.service.mapper.impl;

import com.example.quanlydogiadinh.domain.Catalog;
import com.example.quanlydogiadinh.service.dto.CatalogDTO;
import com.example.quanlydogiadinh.service.mapper.CatalogMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CatalogMapperImpl implements CatalogMapper {
    @Override
    public Catalog toEntity(CatalogDTO dto) {
        if (dto == null) {
            return null;
        }
        Catalog catalog = new Catalog();
        catalog.setCatalogId(dto.getCatalogId());
        catalog.setName(dto.getName());
        return catalog;
    }

    @Override
    public CatalogDTO toDto(Catalog entity) {
        if (entity == null) {
            return null;
        }
        CatalogDTO catalogDTO = new CatalogDTO();
        catalogDTO.setCatalogId(entity.getCatalogId());
        catalogDTO.setName(entity.getName());
        return catalogDTO;
    }

    @Override
    public List<Catalog> toEntity(List<CatalogDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<CatalogDTO> toDto(List<Catalog> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}

