package com.example.feignprovider.dao;

import com.example.common.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.GetMapping;

@Mapper
public interface PaymentDao {

    public Payment GetPaymentById(Long id);

    public int createPayment(Payment payment);
}
