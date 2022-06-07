package com.example.demo.Repositories;


import com.example.demo.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    //This is example for custom query using JPQL and @Query annotation
    @Query("SELECT o FROM Order o where o.ID <> ?1")
    Iterable<Order> findAllExcept(Long excludedId);

    @Query("SELECT o FROM Order o where o.ID <> :excludedId")
    Iterable<Order> findAllExceptWithParam(@Param("excludedId") Long excludedId);

    @Query(value = "SELECT * FROM orders", nativeQuery = true)
    Iterable<Order> findAllNative();

    // Iterable<Order> findAllByStatusAndDateCreatedLessThan(
    //  String status, LocalDate currentDay);
}