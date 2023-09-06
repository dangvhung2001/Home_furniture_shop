package com.example.quanlydogiadinh.repository;

import com.example.quanlydogiadinh.domain.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
}
