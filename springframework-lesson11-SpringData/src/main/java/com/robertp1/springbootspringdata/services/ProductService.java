package com.robertp1.springbootspringdata.services;

import com.robertp1.springbootspringdata.entities.Product;
import com.robertp1.springbootspringdata.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product p) {
        productRepository.save(p);
    }
}
