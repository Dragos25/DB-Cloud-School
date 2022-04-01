package com.example.demo.Controllers;

import com.example.demo.Model.Customer;
import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/{id}")
    public Customer getById(@PathVariable Integer id){
        return customerService.getById(id);

    }

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAll(){
        return ResponseEntity.ok(customerService.getAll());
    }

    @PostMapping("/customers")
    public ResponseEntity<Customer> newCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.add(customer));
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Integer id) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        customer.setId(id);
        Customer updated = customerService.update(customer);
        if(updated==null) return (ResponseEntity<Customer>) ResponseEntity.notFound();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id){
        if(customerService.delete(id))
            return ResponseEntity.ok("Customer " + id + " deleted");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Customer not found");
    }


}
