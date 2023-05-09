package com.robertp1.springbootspringdata.controllers;

import com.robertp1.springbootspringdata.entities.Product;
import com.robertp1.springbootspringdata.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/add")
    public void addProduct(@RequestBody Product p) {
        productService.addProduct(p);
    }

    @GetMapping("/get/{name}")
    public Product getProduct(@PathVariable String name) {
        return productService.getProduct(name);
    }
}
