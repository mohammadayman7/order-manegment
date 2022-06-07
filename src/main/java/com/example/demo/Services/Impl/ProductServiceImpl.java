package com.example.demo.Services.Impl;

import com.example.demo.Entity.Product;
import com.example.demo.Repositories.ProductRepository;
import com.example.demo.Services.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public ProductServiceImpl(){}
    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }



    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, Product productDTO) {
        Optional<Product> product = productRepository.findById(id);

        product.get().setPrice(productDTO.getPrice());
        product.get().setName(productDTO.getName());
        product.get().setReference(productDTO.getReference());
        product.get().setSlug(productDTO.getSlug());
        product.get().setStockable(productDTO.isStockable());
        product.get().setStockList(productDTO.getStockList());
        product.get().setVat(productDTO.getVat());

        Product result = productRepository.save(product.get());
        //todo you should use mappers to spperate the DTO and entities usage.
        return result;
    }
}

