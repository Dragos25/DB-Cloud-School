package com.example.demo.dao;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CustomerDAO implements DAO<Customer> {
    private final CustomerRepository customerRepository;

    @Override
    public Optional<Customer> get(Integer id) {
        return customerRepository.findById(id);
    }

    public List<Customer> getAll(){
        return  customerRepository.findAll();
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }
}
