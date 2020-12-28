package com.example.provider.dao;

import com.example.provider.common.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public int createPayment(Payment payment);

    public Payment GetPaymentById(@Param("id") Long id);
}
