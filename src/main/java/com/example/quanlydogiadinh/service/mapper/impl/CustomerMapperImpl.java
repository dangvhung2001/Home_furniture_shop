package com.example.quanlydogiadinh.service.mapper.impl;

import com.example.quanlydogiadinh.domain.Customer;
import com.example.quanlydogiadinh.domain.Role;
import com.example.quanlydogiadinh.service.dto.CustomerDTO;
import com.example.quanlydogiadinh.service.mapper.CustomerMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer toEntity(CustomerDTO dto) {
        if (dto == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setId(dto.getId());
        customer.setUsername(dto.getUsername());
        customer.setPassword(dto.getPassword());
        customer.setFullName(dto.getFullName());
        customer.setEmail(dto.getEmail());
        customer.setPhoneNumber(dto.getPhoneNumber());
        customer.setStatus(dto.isStatus());
        return customer;
    }

    @Override
    public CustomerDTO toDto(Customer entity) {
        if (entity == null) {
            return null;
        }
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(entity.getId());
        customerDTO.setUsername(entity.getUsername());
        customerDTO.setPassword(entity.getPassword());
        customerDTO.setFullName(entity.getFullName());
        customerDTO.setEmail(entity.getEmail());
        customerDTO.setPhoneNumber(entity.getPhoneNumber());
        customerDTO.setStatus(entity.isStatus());
        Set<Role> roles = entity.getRoles();
        if (roles != null) {
            customerDTO.setRoles(roles.stream().map(Role::getRoleName).collect(Collectors.toSet()));
        }
        return customerDTO;
    }

    @Override
    public List<Customer> toEntity(List<CustomerDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDTO> toDto(List<Customer> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}
