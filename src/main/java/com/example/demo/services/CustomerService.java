package com.example.demo.services;


import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer getById(Integer id){
        return customerRepository.findById(id).get();
    }
    public Customer add(Customer customer){
        return customerRepository.save(customer);
    }
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public List<Customer> getAllByCity(String city){
        return customerRepository.getAllByCity(city);
    }

    public List<Customer> getAllByCountry(String country){
        return customerRepository.getAllByCountry(country);
    }

    public List<Customer> getAllByUsername(String username){
        return customerRepository.getAllByUsername(username);
    }

    public boolean delete(Integer id){
        Optional<Customer> c = customerRepository.findById(id);
        if(c.isPresent()){
            customerRepository.delete(c.get());
            return true;
        }

        else return false;


    }
}