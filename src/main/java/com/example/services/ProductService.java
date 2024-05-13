package com.example.services;

import com.example.entities.Product;
import com.example.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService
{
    private ProductRepository productRepository;

    public Iterable<Product> findAll()
    {
        return productRepository.findAll();
    }
}
