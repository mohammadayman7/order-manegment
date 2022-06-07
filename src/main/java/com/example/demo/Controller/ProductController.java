package com.example.demo.Controller;


import com.example.demo.Entity.Product;
import com.example.demo.Services.Impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductServiceImpl productServiceImpl;

    /*  Return all products in the system */
    @GetMapping("/products/findAll")
    public Iterable<Product> getAllProducts() {
        return productServiceImpl.getAllProducts();
    }

}
