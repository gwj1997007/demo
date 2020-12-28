package com.example.consulprovider.ServiceImpl;

import com.example.common.pojo.Payment;
import com.example.consulprovider.Service.PaymentService;
import com.example.consulprovider.dao.PaymentDao;
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
