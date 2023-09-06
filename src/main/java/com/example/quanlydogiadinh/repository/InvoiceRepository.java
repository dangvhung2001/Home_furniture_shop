package com.example.quanlydogiadinh.repository;

import com.example.quanlydogiadinh.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    // Các phương thức truy vấn tùy chỉnh có thể được thêm ở đây
}
