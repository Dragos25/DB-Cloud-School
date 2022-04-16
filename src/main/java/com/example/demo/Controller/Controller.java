package com.example.demo.Controller;


import com.example.demo.Model.Customer;

import com.example.demo.Model.Order;
import com.example.demo.Model.Payment;
import com.example.demo.Model.PaymentType;
import com.example.demo.Service.CustomerService;
import com.example.demo.Service.OrderService;
import com.example.demo.Service.PaymentInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final CustomerService customerService;
    private final OrderService orderService;
    private final PaymentInterface paymentService;


    @GetMapping("/getCustomers")
    public List<Customer> getAllCustomers(){
        return customerService.getAll();
    }

    @GetMapping("/getOrders")
    public List<Order> getAllOrders(){
        return orderService.getAll();
    }

    @PostMapping("/addPayment/{paymentType}/{orderId}")
    public Payment addPayment(@PathVariable PaymentType paymentType, @PathVariable Integer orderId){
        return paymentService.pay(orderId, paymentType);
    }
}
