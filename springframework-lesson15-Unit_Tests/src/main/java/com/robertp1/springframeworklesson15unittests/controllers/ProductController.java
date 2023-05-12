package com.robertp1.springframeworklesson15unittests.controllers;

import com.robertp1.springframeworklesson15unittests.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping(path = "/product/{name}")
    public Product getProduct(@PathVariable String name) {
        Product p1 = new Product();
        p1.setName(name);
        p1.setPrice(52999.99);

        return p1;
    }
}
