package com.example.quanlydogiadinh.repository;

import com.example.quanlydogiadinh.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface RoleRepository extends JpaRepository<Role, String> {
    Optional<Role> findByRoleName(String id);

}
