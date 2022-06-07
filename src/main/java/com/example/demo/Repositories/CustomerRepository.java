package com.example.demo.Repositories;



import com.example.demo.Entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    //Optional<Customer>findByEmail();
    Boolean existsByEmail(String email );
    Customer findByEmail(String email);
    Boolean existsByEmailAndPassword(String email, String password);
}
