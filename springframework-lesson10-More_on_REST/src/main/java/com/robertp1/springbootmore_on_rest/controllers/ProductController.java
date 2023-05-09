package com.robertp1.springbootmore_on_rest.controllers;

import com.robertp1.springbootmore_on_rest.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/product")      // By putting this annotation here, we are specifying a "path" that will we concatenated, or prefixed, before all the endpoints defined in the class.
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "/add/{name}")
    public void addProduct(@PathVariable String name) {
        productService.addProduct(name);
    }
}
