package com.robertp1.springframeworklesson15unittests.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepository {

    public List<String> getProductNames() {
        return List.of("aa", "bbb", "cccc", "dd", "eee");
    }

    public void addProduct(String name) {

    }
}
