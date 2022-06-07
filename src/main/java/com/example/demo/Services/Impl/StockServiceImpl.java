package com.example.demo.Services.Impl;

import com.example.demo.Entity.Stock;
import com.example.demo.Repositories.StockRepository;
import com.example.demo.Services.StockService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class StockServiceImpl implements StockService {

    private StockRepository stockRepository;

    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
    public StockServiceImpl(){}
    @Override
    public Iterable<Stock> getAllStocks() {
        return stockRepository.findAll();
    }





    @Override
    public Stock save(Stock stock) {
        return stockRepository.save(stock);
    }

    @Override
    public Stock update(Long id, Stock stockDTO) {
        Optional<Stock> stock = stockRepository.findById(id);

        stock.get().setQuantity(stockDTO.getQuantity());
        stock.get().setUpdateAt(stockDTO.getUpdateAt());
        stock.get().setProduct(stockDTO.getProduct());


        Stock result = stockRepository.save(stock.get());
        //todo you should use mappers to spperate the DTO and entities usage.
        return result;
    }
}