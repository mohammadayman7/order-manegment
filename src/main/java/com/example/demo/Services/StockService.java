package com.example.demo.Services;

import com.example.demo.Entity.Stock;

import javax.validation.constraints.NotNull;

public interface StockService {
    Stock save(Stock product);
    @NotNull Iterable<Stock> getAllStocks();



    Stock update(Long id, Stock stockDTO);
}
