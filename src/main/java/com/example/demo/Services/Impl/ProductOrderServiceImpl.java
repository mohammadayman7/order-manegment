package com.example.demo.Services.Impl;

import com.example.demo.Entity.ProductOrder;
import com.example.demo.Repositories.ProductOrderRepository;
import com.example.demo.Services.ProduceOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductOrderServiceImpl implements ProduceOrderService {

    private ProductOrderRepository productOrderRepository;

    public ProductOrderServiceImpl(ProductOrderRepository productOrderRepository) {
        this.productOrderRepository = productOrderRepository;
    }
    public ProductOrderServiceImpl(){}
    @Override
    public ProductOrder create(ProductOrder orderProduct) {
        return this.productOrderRepository.save(orderProduct);
    }
}

