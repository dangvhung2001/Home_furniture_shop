package com.example.quanlydogiadinh.service.impl;

import com.example.quanlydogiadinh.domain.Customer;
import com.example.quanlydogiadinh.repository.CustomerRepository;
import com.example.quanlydogiadinh.service.CustomerService;
import com.example.quanlydogiadinh.service.dto.CustomerDTO;
import com.example.quanlydogiadinh.service.mapper.CustomerMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        Customer customer = customerMapper.toEntity(customerDTO);
        customer = customerRepository.save(customer);
        return customerMapper.toDto(customer);
    }

    @Override
    public Page<CustomerDTO> findAll(String textSearch, Pageable pageable) {
        return customerRepository.findAllByUsernameContainingIgnoreCaseOrEmailContainingIgnoreCase(textSearch, textSearch, pageable).map(customerMapper::toDto);
    }

    @Override
    public Optional<CustomerDTO> findOne(Long id) {
        return customerRepository.findById(id).map(customerMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<CustomerDTO> findAllCustomer(Pageable pageable) {
        return customerRepository.findAll(pageable).map(customerMapper::toDto);
    }

    @Override
    public Optional<CustomerDTO> findByEmail(String email) {
        return customerRepository.findByEmailIgnoreCase(email).map(customerMapper::toDto);
    }

    @Override
    public List<CustomerDTO> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customerMapper.toDto(customers);
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        Optional<Customer> oldCustomer = customerRepository.findById(customerDTO.getId());
        if (oldCustomer.isPresent()) {
            Customer existingCustomer = oldCustomer.get();
            existingCustomer.setFullName(customerDTO.getFullName());
            existingCustomer.setEmail(customerDTO.getEmail());
            existingCustomer.setPhoneNumber(customerDTO.getPhoneNumber());
            existingCustomer.setStatus(customerDTO.isStatus());
            customerRepository.save(existingCustomer);
        } else {
            throw new RuntimeException("Customer not found");
        }
    }
}
