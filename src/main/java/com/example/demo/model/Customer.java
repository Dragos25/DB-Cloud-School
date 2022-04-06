package com.example.demo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Customer {
    @GeneratedValue
    @Id
    private Integer id;
    private String username;
    private String city;
    private String country;

}
