package com.example.zookeeper.ServiceImpl;

import com.example.common.pojo.Payment;

import com.example.zookeeper.Service.PaymentService;
import com.example.zookeeper.dao.PaymentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceimp implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int createPayment(Payment payment) {
        return paymentDao.createPayment(payment);
    }

    @Override
    public Payment GetPaymentById(Long id) {
        return paymentDao.GetPaymentById(id);
    }
}
