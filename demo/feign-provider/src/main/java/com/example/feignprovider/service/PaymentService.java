package com.example.feignprovider.service;

import com.example.common.pojo.Payment;

public interface PaymentService {
    public Payment GetPaymentById(Long id);

    public int insertPayment(Payment payment);
}
