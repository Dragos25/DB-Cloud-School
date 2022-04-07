package com.example.demo.controller;


import com.example.demo.Utils.Mapper;
import com.example.demo.Utils.PasswordEncrypt;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.model.Customer;
import com.example.demo.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
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
    public String login(@RequestParam String username, @RequestParam String password, HttpServletResponse response){
        Customer c = customerService.getByUsername(username);

        if(c==null)
            return "Username nu exista";
        if(c.getPassword().equals(PasswordEncrypt.encrypt(password))) {
            Cookie userName = new Cookie("username", username);
            userName.setMaxAge(60);
            userName.setPath("/");
            response.addCookie(userName);
            return "Ai fost logat";
        }
        return "Parola gresita";
    }

    @PostMapping("/customers/logout")
    public String login(@CookieValue(value = "username", defaultValue = "notLogged") String username, HttpServletResponse response){
        if(username.equals("notLogged"))
            return "Nu esti logat!";
        Cookie userName = new Cookie("username", "notLogged");
        userName.setMaxAge(60);
        userName.setPath("/");
        response.addCookie(userName);
        return "Ai iesit din cont!";

    }

    @GetMapping("/customers/isLogged")
    public String login(@CookieValue(value = "username", defaultValue = "notLogged") String username){
        if(username.equals("notLogged")) return "Not logged in";
        return "Logat cu userul " + username;

    }







}
