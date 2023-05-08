package com.robertp1.springbootmore_on_rest.services;

import com.robertp1.springbootmore_on_rest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(String name) {
        productRepository.addProduct(name);
    }
}
