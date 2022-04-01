package com.example.demo.Model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@ToString
public class OrderDetails {
    @Id
    @GeneratedValue
    private Integer id;
    private String productCode;
    private Integer quantity;
    @ManyToOne
    @JoinColumn(name = "order_id")
    Order orders;


}
