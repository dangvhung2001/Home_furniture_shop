package com.example.quanlydogiadinh.service.mapper.impl;

import com.example.quanlydogiadinh.domain.Employee;
import com.example.quanlydogiadinh.domain.Role;
import com.example.quanlydogiadinh.domain.Salary;
import com.example.quanlydogiadinh.service.dto.EmployeeDTO;
import com.example.quanlydogiadinh.service.mapper.EmployeeMapper;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.HashSet;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {
    @Override
    public Employee toEntity(EmployeeDTO dto) {
        if (dto == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setImgUrl(dto.getImgUrl());
        employee.setName(dto.getName());
        employee.setPassword(dto.getPassword());
        employee.setSex( dto.getSex());
        employee.setMaritalStatus(dto.getMaritalStatus());
        employee.setDateOfBirth(dto.getDateOfBirth());
        employee.setCitizenCode(dto.getCitizenCode());
        employee.setIssueDate(dto.getIssueDate());
        employee.setPlaceOfIssue(dto.getPlaceOfIssue());
        employee.setEmployeeCode(dto.getEmployeeCode());
        employee.setEmail(dto.getEmail());
        employee.setAddress(dto.getAddress());
        employee.setPhone(dto.getPhone());
        employee.setStatus(dto.getStatus());
        employee.setPosition(dto.getPosition());
        return employee;
    }

    @Override
    public EmployeeDTO toDto(Employee entity) {
        if (entity == null) {
            return null;
        }
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(entity.getId());
        employeeDTO.setImgUrl(entity.getImgUrl());
        employeeDTO.setName(entity.getName());
        employeeDTO.setPassword(entity.getPassword());
        employeeDTO.setSex(entity.getSex());
        employeeDTO.setMaritalStatus(entity.getMaritalStatus());
        employeeDTO.setDateOfBirth(entity.getDateOfBirth());
        employeeDTO.setCitizenCode(entity.getCitizenCode());
        employeeDTO.setIssueDate(entity.getIssueDate());
        employeeDTO.setPlaceOfIssue(entity.getPlaceOfIssue());
        employeeDTO.setEmployeeCode(entity.getEmployeeCode());
        employeeDTO.setEmail(entity.getEmail());
        employeeDTO.setAddress(entity.getAddress());
        employeeDTO.setPhone(entity.getPhone());
        employeeDTO.setStatus(entity.getStatus());
        employeeDTO.setPosition(entity.getPosition());
//        Salary salary = entity.getSalary();
//        if (salary != null){
//            employeeDTO.setSalary(salary.getAmount());
//        }
        Set<Role> roles = entity.getRoles();
        if (roles != null) {
            employeeDTO.setRoles(roles.stream().map(Role::getRoleName).collect(Collectors.toSet()));
        }
        return employeeDTO;
    }

    @Override
    public List<Employee> toEntity(List<EmployeeDTO> dtoList) {
        if (dtoList == null) {
            return null;
        }
        List<Employee> list = new ArrayList<Employee>(dtoList.size());
        for (EmployeeDTO employeeDTO : dtoList) {
            list.add(toEntity(employeeDTO));
        }
        return list;
    }

    @Override
    public List<EmployeeDTO> toDto(List<Employee> entityList) {
        if (entityList == null) {
            return null;
        }
        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>(entityList.size());
        for (Employee employee : entityList) {
            list.add(toDto(employee));
        }
        return list;
    }
}
