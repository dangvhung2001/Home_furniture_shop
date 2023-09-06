package com.example.quanlydogiadinh.repository;

import com.example.quanlydogiadinh.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    // Các phương thức truy vấn tùy chỉnh có thể được thêm ở đây
}
