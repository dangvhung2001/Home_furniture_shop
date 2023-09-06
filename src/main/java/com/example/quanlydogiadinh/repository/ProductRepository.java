package com.example.quanlydogiadinh.repository;

import com.example.quanlydogiadinh.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Các phương thức truy vấn tùy chỉnh có thể được thêm ở đây
}

