package com.example.demo.Controllers;


import com.example.demo.Model.Order;
import com.example.demo.Model.OrderDetails;
import com.example.demo.Services.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderDetailsController {
    @Autowired
    private OrderDetailsService orderDetailsService;

    @GetMapping("/orderdetails/{id}")
    public List<OrderDetails> getOrderDetails(@PathVariable Integer id){
        return orderDetailsService.findAllById(id);
    }
}
