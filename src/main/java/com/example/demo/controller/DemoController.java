package com.example.demo.controller;


import com.example.demo.dto.CustomerDTO;
import com.example.demo.jwt.JwtRequestModel;
import com.example.demo.jwt.JwtResponseModel;
import com.example.demo.jwt.JwtUserDetailsService;
import com.example.demo.model.Customer;
import com.example.demo.services.CustomerService;
import com.example.demo.utils.Mapper;
import com.example.demo.utils.PasswordEncrypt;
import com.example.demo.utils.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class DemoController {
    @Autowired
    private JwtUserDetailsService userDetailsService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenManager tokenManager;

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

    @PostMapping("/login")
    public ResponseEntity<JwtResponseModel> login(@RequestBody JwtRequestModel request) throws Exception{
        try {
            authenticationManager.authenticate(
                    new
                            UsernamePasswordAuthenticationToken(request.getUsername(),
                            request.getPassword())
            );
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String jwtToken = tokenManager.generateJwtToken(userDetails);
        return ResponseEntity.ok(new JwtResponseModel(jwtToken));
    }


}

