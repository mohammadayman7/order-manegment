package com.example.demo.Services;

import com.example.demo.Entity.Product;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public interface ProductService {

    @NotNull Iterable<Product> getAllProducts();



    Product save(Product product);

    Product update(Long id, Product product);
}

