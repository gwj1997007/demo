package com.example.provider.ServiceImpl;

import com.example.provider.Service.PaymentService;
import com.example.provider.dao.PaymentDao;
import com.example.provider.common.pojo.Payment;
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
