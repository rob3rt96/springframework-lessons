package com.example.springdatacontracts.controllers;

import com.example.springdatacontracts.entities.Product;
import com.example.springdatacontracts.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(path = "/sort")
    public Iterable<Product> getAllSortedDescendingById() {
        return productRepository.findAll(Sort.by("id").descending());
    }

    // This returns the rows from the database in the form of Pages, starting with page 0.
    @GetMapping(path = "/page/{pageNumber}")
    public List<Product> getProductsByPage(@PathVariable int pageNumber) {
        return productRepository.findAll(PageRequest.of(pageNumber, 3)).getContent();
    }

    @GetMapping(path = "/pageDescending/{pageNumber}")
    public List<Product> getProductsByPageDescending(@PathVariable int pageNumber) {
        Sort sort = Sort.by("id").descending();

        return productRepository.findAll(PageRequest.of(pageNumber, 3, sort)).getContent();
    }

    @GetMapping(path = "/name/{name}/{page}")
    public List<Product> getProductsByName(@PathVariable String name,
                                           @PathVariable int page) {
        Pageable p = PageRequest.of(page, 2);

        return productRepository.findProductsByName(name, p);
    }
}
