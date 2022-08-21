package com.sparta.prac4.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sparta.prac4.models.Product;
import com.sparta.prac4.models.ProductMypriceRequestDto;
import com.sparta.prac4.models.ProductRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Long update(Long id, ProductMypriceRequestDto mypriceRequestDto) {
        Product product = new Product();
        product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다."));
        product.update(mypriceRequestDto);

        return id;
    }
}
