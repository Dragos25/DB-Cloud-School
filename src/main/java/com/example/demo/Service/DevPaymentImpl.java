package com.example.demo.Service;


import com.example.demo.Model.Payment;
import com.example.demo.Model.PaymentType;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.Repository.PaymentRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
@RequiredArgsConstructor

public class DevPaymentImpl implements PaymentInterface{
    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    @Override
    public Payment pay(Integer orderId, PaymentType paymentType) {
        Payment payment = new Payment();
        payment.setOrder(orderRepository.findById(orderId).get());
        payment.setPaymentType(paymentType);
        payment.setWhereFrom("dev");
        return paymentRepository.save(payment);
    }

    @Override
    public Payment getPayment(Integer id) {
        return paymentRepository.getById(id);
    }
}
