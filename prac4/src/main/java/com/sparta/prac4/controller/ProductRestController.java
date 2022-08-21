package com.sparta.prac4.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sparta.prac4.models.Product;
import com.sparta.prac4.models.ProductMypriceRequestDto;
import com.sparta.prac4.models.ProductRepository;
import com.sparta.prac4.models.ProductRequestDto;
import com.sparta.prac4.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductRestController {
    private final ProductRepository productRepository;

    @GetMapping("/api/products")
    public List<Product> getProduct() {
        return productRepository.findAll();
    }

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto) {
        Product product = new Product(requestDto);
        productRepository.save(product);
        return product;

    }

    private final ProductService productService;

    @PutMapping("/api/products/{id}")
    public Long setMyprice(@PathVariable Long id, @RequestBody ProductMypriceRequestDto mypriceRequestDto) {
        return productService.update(id, mypriceRequestDto);
    }
}
