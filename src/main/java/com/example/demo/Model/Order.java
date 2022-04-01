package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "orders")
@ToString
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date orderDate;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date shippedDate;
    private String status;
    private String comments;
    @ManyToOne
    @JoinColumn(name = "customers_id")
    Customer customers;


}
