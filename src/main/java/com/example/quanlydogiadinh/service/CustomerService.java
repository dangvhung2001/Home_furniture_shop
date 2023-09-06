package com.example.quanlydogiadinh.service;

import com.example.quanlydogiadinh.service.dto.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    CustomerDTO save(CustomerDTO customerDTO);
    Page<CustomerDTO> findAll(String textSearch, Pageable pageable);
    Optional<CustomerDTO> findOne(Long id);
    void delete(Long id);
    Page<CustomerDTO> findAllCustomer(Pageable pageable);
    Optional<CustomerDTO> findByEmail(String email);
    List<CustomerDTO> getAll();
    void updateCustomer(CustomerDTO customerDTO);
}

