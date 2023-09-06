package com.example.quanlydogiadinh.service.mapper.impl;

import com.example.quanlydogiadinh.domain.Employee;
import com.example.quanlydogiadinh.domain.Salary;
import com.example.quanlydogiadinh.service.dto.EmployeeDTO;
import com.example.quanlydogiadinh.service.dto.SalaryDTO;
import com.example.quanlydogiadinh.service.mapper.EmployeeMapper;
import com.example.quanlydogiadinh.service.mapper.SalaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SalaryMapperImpl implements SalaryMapper {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public Salary toEntity(SalaryDTO dto) {
        if (dto == null) {
            return null;
        }
        Salary salary = new Salary();
        salary.setId(dto.getId());
        salary.setAmount(dto.getAmount());
        salary.setPaymentDate(dto.getPaymentDate());
        salary.setStatus(dto.getStatus());
        Employee employee = employeeMapper.toEntity(dto.getEmployee());
        salary.setEmployee(employee);
        return salary;
    }

    @Override
    public SalaryDTO toDto(Salary entity) {
        if (entity == null) {
            return null;
        }
        SalaryDTO salaryDTO = new SalaryDTO();
        salaryDTO.setId(entity.getId());
        salaryDTO.setAmount(entity.getAmount());
        salaryDTO.setPaymentDate(entity.getPaymentDate());
        salaryDTO.setStatus(entity.getStatus());
        EmployeeDTO employeeDTO = employeeMapper.toDto(entity.getEmployee()); // Assume you have an EmployeeMapper
        salaryDTO.setEmployee(employeeDTO);
        return salaryDTO;
    }

    @Override
    public List<Salary> toEntity(List<SalaryDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<SalaryDTO> toDto(List<Salary> entityList) {
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }
}

