package com.example.demo.Services;

import com.example.demo.DTO.CustomerDto;

import com.example.demo.Entity.Customer;
import com.sun.istack.NotNull;
import org.springframework.http.ResponseEntity;


public interface CustomerService {

    Customer save(Customer product);
    @NotNull
    Iterable<Customer> getAllStocks();

    Customer update(Long id, CustomerDto customerDto);
}
