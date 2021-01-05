package com.example.feignprovider2.dao;

import com.example.common.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {

    public Payment GetPaymentById(Long id);

    public int createPayment(Payment payment);
}
