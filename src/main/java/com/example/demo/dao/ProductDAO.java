package com.example.demo.dao;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ProductDAO implements DAO<Product> {
    private final ProductRepository productRepository;

    @Override
    public Optional<Product> get(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }
}
