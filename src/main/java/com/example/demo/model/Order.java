package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    private long timestamp;
}
