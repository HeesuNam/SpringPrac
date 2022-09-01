package com.example.springprac2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springprac2.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Page<Product> findAllByUserId(Long userId, Pageable Pageable);
}
