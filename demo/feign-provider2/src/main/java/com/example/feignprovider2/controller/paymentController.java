package com.example.feignprovider2.controller;

import com.example.common.pojo.JsonResult;
import com.example.common.pojo.Payment;
import com.example.feignprovider2.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class paymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public JsonResult<Payment> GetPayment(@PathVariable Long id) {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Payment payment = paymentService.GetPaymentById(id);
        if (payment != null) {
            return new JsonResult<>(200, "成功==端口：port"+port, payment);
        } else {
            return new JsonResult<>(404, "失败：port"+port);
        }
    }

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public JsonResult<Payment> GetPayment(@RequestBody Payment payment) {
        int row = paymentService.insertPayment(payment);
        if (row != 0) {
            return new JsonResult<>(200, "成功：port"+port);
        } else {
            return new JsonResult<>(404, "失败：port"+port);
        }
    }
}
