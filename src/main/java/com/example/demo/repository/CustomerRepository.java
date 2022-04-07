package com.example.demo.repository;


import com.example.demo.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository <Customer, Integer>{
    List<Customer> findAll();
    List<Customer> getAllByCity(String city);
    List<Customer> getAllByCountry(String country);
    List<Customer> getAllByUsername(String username);
    Customer getByUsername(String username);
}
