package com.example.demo.Services.Impl;

import com.example.demo.Entity.Order;
import com.example.demo.Repositories.OrderRepository;
import com.example.demo.Services.OrderService;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;

@Service
@Transactional

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderServiceImpl() {
    }

    @Override
    public @NotNull
    Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Iterable<Order> GetAllOrdersByStatusAndDateCreatedGreaterThan() {
        //try all these methods

//        return orderRepository.findAllNative();
        return orderRepository.findAllExceptWithParam(1L);
//        return orderRepository.findAllExcept(1L);
//        return orderRepository.findAllByStatusAndDateCreatedLessThan(OrderStatus.PAID.name(), LocalDate.now());
    }

    @Override
    public Order create(Order order) {
        order.setDateCreated(LocalDate.now());

        return this.orderRepository.save(order);
    }

    @Override
    public void update(Order order) {
        this.orderRepository.save(order);
    }
}

