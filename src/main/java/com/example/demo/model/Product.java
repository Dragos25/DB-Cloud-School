package com.example.demo.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private int price;
}
