package com.example.zookeeper.Service;

import com.example.common.pojo.Payment;

public interface PaymentService {
    public int createPayment(Payment payment);

    public Payment GetPaymentById(Long id);
}
