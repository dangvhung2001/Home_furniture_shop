package com.example.quanlydogiadinh.service.mapper.impl;

import com.example.quanlydogiadinh.domain.Invoice;
import com.example.quanlydogiadinh.service.dto.InvoiceDTO;
import com.example.quanlydogiadinh.service.mapper.CustomerMapper;
import com.example.quanlydogiadinh.service.mapper.InvoiceMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class InvoiceMapperImpl implements InvoiceMapper {
    private final CustomerMapper customerMapper; // Assuming you have a CustomerMapper

    public InvoiceMapperImpl(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @Override
    public Invoice toEntity(InvoiceDTO dto) {
        if (dto == null) {
            return null;
        }
        Invoice invoice = new Invoice();
        invoice.setId(dto.getId());
        invoice.setCustomer(customerMapper.toEntity(dto.getCustomer()));
        invoice.setInvoiceDate(dto.getInvoiceDate());
        invoice.setTotalAmount(dto.getTotalAmount());
        return invoice;
    }

    @Override
    public InvoiceDTO toDto(Invoice entity) {
        if (entity == null) {
            return null;
        }
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setId(entity.getId());
        invoiceDTO.setCustomer(customerMapper.toDto(entity.getCustomer()));
        invoiceDTO.setInvoiceDate(entity.getInvoiceDate());
        invoiceDTO.setTotalAmount(entity.getTotalAmount());
        return invoiceDTO;
    }

    @Override
    public List<Invoice> toEntity(List<InvoiceDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<InvoiceDTO> toDto(List<Invoice> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
