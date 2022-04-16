package com.example.demo.Service;

import com.example.demo.Model.Order;
import com.example.demo.Model.Payment;
import com.example.demo.Model.PaymentType;

public interface PaymentInterface {
    Payment pay(Integer orderId, PaymentType paymentType);
    Payment getPayment(Integer id);

}
