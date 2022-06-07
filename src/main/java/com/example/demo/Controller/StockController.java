package com.example.demo.Controller;


import com.example.demo.Entity.Stock;
import com.example.demo.Services.Impl.StockServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockController {

    @Autowired
    StockServiceImpl stockServiceImpl;

    /* Return all stocks in the system */
    @GetMapping("/stocks")
    public Iterable<Stock> getStock() {
        return stockServiceImpl.getAllStocks();
    }

}
