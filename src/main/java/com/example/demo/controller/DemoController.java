package com.example.demo.controller;


import com.example.demo.utils.Mapper;
import com.example.demo.utils.PasswordEncrypt;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Customer;
import com.example.demo.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class DemoController {


    private CustomerService customerService;
    @GetMapping("/customers")
    public List<CustomerDTO> getAll(){
        List<CustomerDTO> customerDtos = new ArrayList<>();
        List<Customer> customers = customerService.getAll();

        for(Customer customer : customers){
            System.out.println(customer);
            customerDtos.add(Mapper.customerToDto(customer));}
        return customerDtos;
    }

    @PostMapping("/customers/register")
    public Customer addCustomer(@RequestBody Customer customer){
        customer.setPassword(PasswordEncrypt.encrypt(customer.getPassword()));
        return customerService.add(customer);
    }

    @PostMapping("/customers/login")
    public String login(@RequestBody Customer details, HttpServletResponse response){
        Customer c = customerService.getByUsername(details.getUsername());
        if(c==null)
            return "Username nu exista";
        if(c.getPassword().equals(PasswordEncrypt.encrypt(details.getPassword()))) {
            Cookie userName = new Cookie("username", details.getUsername());
            userName.setMaxAge(60);
            userName.setPath("/");
            response.addCookie(userName);
            return "Ai fost logat";
        }
        return "Parola gresita";
    }

    @PostMapping("/customers/logout")
    public String logout(@CookieValue(value = "username", defaultValue = "notLogged") String username, HttpServletResponse response){
        if(username.equals("notLogged"))
            return "Nu esti logat!";
        Cookie userName = new Cookie("username", "notLogged");
        userName.setMaxAge(60);
        userName.setPath("/");
        response.addCookie(userName);
        return "Ai iesit din cont!";

    }

    @GetMapping("/customers/isLogged")
    public String isLogged(@CookieValue(value = "username", defaultValue = "notLogged") String username){
        if(username.equals("notLogged")) return "Nu esti logat!";
        return "Logat cu userul " + username;

    }
}
