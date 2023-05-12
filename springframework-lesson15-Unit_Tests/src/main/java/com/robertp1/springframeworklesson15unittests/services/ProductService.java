package com.robertp1.springframeworklesson15unittests.services;

import com.robertp1.springframeworklesson15unittests.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public List<String> getProductNamesWithEvenNumberOfChars() {
        List<String> names = productRepository.getProductNames();

//        List<String> result = new ArrayList<>();
//
//        for (String name : names) {
//            if (name.length() % 2 == 0) {
//                result.add(name);
//            }
//        }
//
//        return result;

        return names.stream()
                .filter(n -> n.length() % 2 == 0)
                .collect(Collectors.toList());
    }
}
