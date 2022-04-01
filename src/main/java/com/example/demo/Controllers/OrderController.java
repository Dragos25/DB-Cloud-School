package com.example.demo.Controllers;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Order;
import com.example.demo.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/orders")
    public List<Order> getAll(){
        return orderService.findAll();
    }

    @GetMapping("/orders/{id}")
    public Order getById(@PathVariable Integer id){
        Order order = orderService.findById(id);
        return order;

    }
    @PostMapping("/orders")
    public ResponseEntity<Order> newOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.add(order));
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable Integer id) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        order.setId(id);
        Order updated = orderService.update(order);
        if(updated==null) return (ResponseEntity<Order>) ResponseEntity.notFound();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<String> deleteOrder(@PathVariable Integer id){
        if(orderService.delete(id))
            return ResponseEntity.ok("Order " + id + " deleted");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found");
    }

    @GetMapping("/orders/filter")
    public List<Order> getOrdersFromCustomers(@RequestParam("customerId") Integer customerId){
        System.out.println("ALO");
        return orderService.getAllOrdersFromCustomer(customerId);
    }
}
