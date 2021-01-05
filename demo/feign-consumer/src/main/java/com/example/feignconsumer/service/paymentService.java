package com.example.feignconsumer.service;

import com.example.common.pojo.JsonResult;
import com.example.common.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(name="feign-provider")
public interface paymentService {
    @RequestMapping("/payment/get/{id}")
    public JsonResult getPaymentById(@PathVariable("id") Long id);

    @RequestMapping("/payment/post")
    public JsonResult insertPayment(Payment payment);
}
