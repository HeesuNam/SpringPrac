package com.example.springprac2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springprac2.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findAllByUserId(Long userId);
}
