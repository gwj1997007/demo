package com.example.feignprovider2.service;

import com.example.common.pojo.Payment;

public interface PaymentService {
    public Payment GetPaymentById(Long id);

    public int insertPayment(Payment payment);
}
