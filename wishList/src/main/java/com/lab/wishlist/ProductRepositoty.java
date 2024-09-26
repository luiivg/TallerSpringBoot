package com.lab.wishlist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepositoty extends CrudRepository<Product, Long> {

    Optional<Product> findByName(String name);

}
