package com.example.demo.controller;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer;
import com.example.demo.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class DemoController {


    private CustomerService customerService;
    @GetMapping("/customers")
    public List<Customer> getAll(){
        return customerService.getAll();
    }



    @PostMapping("/customers")
    public Customer newCustomer(@RequestBody Customer customer){
        return customerService.add(customer);
    }

    @GetMapping("/customers/{id}")
    public ModelAndView getById(@PathVariable Integer id){
        ModelAndView modelAndView = new ModelAndView("view-page");
        Customer customer = customerService.getById(id);
        modelAndView.addObject("customers", customer);
        return modelAndView;

    }

    @GetMapping("/viewByCity")
    public ModelAndView getAllByCity(@RequestParam("city") String city){
        ModelAndView modelAndView = new ModelAndView("view-page");
        modelAndView.addObject("customers", customerService.getAllByCity(city));
        return modelAndView;
    }

    @GetMapping("/viewByCountry")
    public ModelAndView getAllByCountry(@RequestParam("country") String country){
        ModelAndView modelAndView = new ModelAndView("view-page");
        modelAndView.addObject("customers", customerService.getAllByCountry(country));
        return modelAndView;
    }

    @GetMapping("/viewByUsername")
    public ModelAndView getAllByUsername(@RequestParam("username") String username){
        ModelAndView modelAndView = new ModelAndView("view-page");
        modelAndView.addObject("customers", customerService.getAllByUsername(username));
        return modelAndView;
    }

    @GetMapping("/view")
    public ModelAndView displayView() {

        ModelAndView modelAndView = new ModelAndView("view-page");
        modelAndView.addObject("customers", customerService.getAll());
        return modelAndView;
    }


}
