package com.example.demo.repository;


import com.example.demo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findAll();
    List<Customer> getAllByCity(String city);
    List<Customer> getAllByCountry(String country);
    List<Customer> getAllByUsername(String username);
    Customer getByUsername(String username);
}
