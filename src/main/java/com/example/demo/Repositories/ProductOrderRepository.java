package com.example.demo.Repositories;


import com.example.demo.Entity.ProductOrder;
import com.example.demo.Entity.ProductOrderPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, ProductOrderPK> {
}

