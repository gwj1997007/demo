package com.example.provider.Service;

import com.example.provider.common.pojo.Payment;

public interface PaymentService {
    public int createPayment(Payment payment);

    public Payment GetPaymentById(Long id);
}
