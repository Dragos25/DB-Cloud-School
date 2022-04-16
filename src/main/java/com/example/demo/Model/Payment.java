package com.example.demo.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@Entity(name = "payments")
public class Payment {
    @Id
    @GeneratedValue
    private Integer id;
    private PaymentType paymentType;
    private String whereFrom;
    @OneToOne
    private Order order;
}
