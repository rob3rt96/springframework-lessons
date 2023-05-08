package com.robertp1.springbootspringdata.repositories;

import com.robertp1.springbootspringdata.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// JpaRepository is a Spring Data Contract which knows how to communicate with the database. Spring Data will provide an implementation which know how to deal with this interface.
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("SELECT p FROM Product p WHERE p.name=:name")
    public Product findProductByName(String name);
}
