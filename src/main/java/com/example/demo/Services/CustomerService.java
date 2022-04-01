package com.example.demo.Services;

import com.example.demo.Model.Customer;
import com.example.demo.Repositories.CustomerRepository;
import com.example.demo.Utils.Utils;
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

    public Customer update(Customer customer) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Optional<Customer> customerFind = customerRepository.findById(customer.getId());
        if(customerFind.isPresent()) {
            Customer merged = Utils.mergeObjects(customer, customerFind.get());
            return customerRepository.save(merged);

        }
        return null;
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
