package com.example.quanlydogiadinh.repository;

import com.example.quanlydogiadinh.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
    // Các phương thức truy vấn tùy chỉnh có thể được thêm ở đây
}

