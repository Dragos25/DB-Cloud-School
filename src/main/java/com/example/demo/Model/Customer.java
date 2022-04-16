package com.example.demo.Model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity(name = "customers")
public class Customer {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @OneToMany
    private List<Order> orderList;



}
