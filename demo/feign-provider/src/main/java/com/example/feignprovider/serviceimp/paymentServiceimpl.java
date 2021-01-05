package com.example.feignprovider.serviceimp;

import com.example.common.pojo.Payment;
import com.example.feignprovider.dao.PaymentDao;
import com.example.feignprovider.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class paymentServiceimpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public Payment GetPaymentById(Long id) {
        return paymentDao.GetPaymentById(id);
    }

    @Override
    public int insertPayment(Payment payment) {
        return paymentDao.createPayment(payment);
    }
}
