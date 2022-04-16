package com.example.demo.Service;


import com.example.demo.Model.Order;
import com.example.demo.Model.Payment;
import com.example.demo.Model.PaymentType;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.Repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
@RequiredArgsConstructor
public class ProdPaymentImpl implements PaymentInterface{
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    @Override
    public Payment pay(Integer orderId, PaymentType paymentType) {
        Order order = orderRepository.findById(orderId).get();
        if(order.getAmount()>10)
            return pay1(order, paymentType);
        return pay2(order, paymentType);

    }
    public Payment pay1(Order order, PaymentType paymentType){
        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setPaymentType(paymentType);
        payment.setWhereFrom("prod with method 1");
        return paymentRepository.save(payment);
    }

    public Payment pay2(Order order, PaymentType paymentType){
        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setPaymentType(paymentType);
        payment.setWhereFrom("prod with method 2");
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPayment(Integer id) {
        return paymentRepository.getById(id);
    }

}
