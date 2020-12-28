package com.example.consulprovider.Controller;

import com.example.common.pojo.JsonResult;
import com.example.common.pojo.Payment;
import com.example.consulprovider.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String port;
    @GetMapping("/get/{id}")
    public JsonResult<Payment> getPaymentById(@PathVariable Long id) {
        Payment payment = paymentService.GetPaymentById(id);
        if (payment != null) {
            return new JsonResult<Payment>(200, "成功"+port, payment);
        } else {
            return new JsonResult<>(404, "失败"+port);
        }
    }
    @PostMapping("/post")
    public JsonResult<Payment> postPayment(@RequestBody Payment payment) {
        int rows = paymentService.createPayment(payment);
        if (rows !=0) {
            return new JsonResult<Payment>(200, "成功"+port, payment);
        } else {
            return new JsonResult<>(404, "失败"+port);
        }
    }

}