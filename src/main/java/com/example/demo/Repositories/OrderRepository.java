package com.example.demo.Repositories;

import com.example.demo.Model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query("select o from Order o where o.customers = :id")
    List<Order> getAllOrdersFromCustomer(@Param("id") Integer id);

    List<Order> getAllByCustomersId(Integer id);
}
