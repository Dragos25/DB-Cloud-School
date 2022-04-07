package com.example.demo.Utils;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Customer;

public class Mapper {
    public static Customer dtoToCustomer(CustomerDTO dto){
        Customer customer = new Customer();
        customer.setCity(dto.getCity());
        customer.setUsername(dto.getUsername());
        customer.setCountry(dto.getCountry());
        return customer;

    }

    public static CustomerDTO customerToDto(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setCity(customer.getCity());
        customerDTO.setCountry(customer.getCountry());
        customerDTO.setUsername(customer.getUsername());
        return customerDTO;
    }
}
