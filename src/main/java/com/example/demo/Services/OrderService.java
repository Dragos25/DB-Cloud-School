package com.example.demo.Services;

import com.example.demo.Model.Customer;
import com.example.demo.Model.Order;
import com.example.demo.Repositories.OrderRepository;
import com.example.demo.Utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Integer id){
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()) return order.get();
        return null;
    }

    public Order add(Order order){
        return orderRepository.save(order);
    }

    public Order update(Order order) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Optional<Order> orderFind = orderRepository.findById(order.getId());
        if(orderFind.isPresent()) {
            Order merged = Utils.mergeObjects(order, orderFind.get());
            System.out.println(merged.toString());
            return orderRepository.save(merged);

        }
        return null;
    }

    public boolean delete(Integer id){
        Optional<Order> o = orderRepository.findById(id);
        if(o.isPresent()){
            orderRepository.delete(o.get());
            return true;
        }
        else return false;


    }

    public List<Order> getAllOrdersFromCustomer(Integer id){
        return orderRepository.getAllByCustomersId(id);
    }

}
