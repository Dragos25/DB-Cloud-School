package com.example.demo.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    private Float value;
    private Integer amount;
    @ManyToOne
    private Customer customer;
    @OneToOne
    private Payment payment;
}
