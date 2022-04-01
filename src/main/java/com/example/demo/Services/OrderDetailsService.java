package com.example.demo.Services;

import com.example.demo.Model.OrderDetails;
import com.example.demo.Repositories.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrderDetailsService {
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    public List<OrderDetails> findAllById(Integer id){
        return orderDetailsRepository.findAllById(Collections.singleton(id));
    }
}
