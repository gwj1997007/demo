package com.example.consulprovider.dao;

import com.example.common.pojo.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    public int createPayment(Payment payment);

    public Payment GetPaymentById(@Param("id") Long id);
}
